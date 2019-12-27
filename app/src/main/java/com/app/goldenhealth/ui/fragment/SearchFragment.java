package com.app.goldenhealth.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.TimKiem;
import com.app.goldenhealth.model.TimKiemLoc;
import com.app.goldenhealth.presenter.SearchPresenter;
import com.app.goldenhealth.presenter.impl.SearchPresenterImpl;
import com.app.goldenhealth.ui.adapter.HistorySearchAdapter;
import com.app.goldenhealth.ui.adapter.SearchAdapter;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.RecyclerViewEmptySupport;
import com.app.goldenhealth.util.Toolbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SearchFragment extends BaseFragment<SearchPresenter> implements SearchView {
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.btn_filter)
    ImageView btnFilter;
    @BindView(R.id.view_title)
    LinearLayout viewTitle;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.empty_view)
    LinearLayout emptyView;
    @BindView(R.id.rcv)
    RecyclerViewEmptySupport rcv;
    @BindView(R.id.btn_delete_history)
    TextView btnDeleteHistory;
    @BindView(R.id.edt_search)
    EditText edtSearch;
    @BindView(R.id.rcv_history)
    RecyclerView rcvHistory;

    private Timer timer;
    private Handler handler;
    private ArrayList<Integer> loaiTimKiem;
    private ArrayList<Integer> timKiemUuTien;
    private SearchAdapter adapter;
    private ArrayList<TimKiem> arrayList;
    private List<String> history;
    private HistorySearchAdapter historySearchAdapter;
    private FilterFragment filterFragment;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_search;
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        loaiTimKiem = new ArrayList<>();
        timKiemUuTien = new ArrayList<>();
        history = new ArrayList<>();
        if (PrefUtil.getSearchHistory(getContext()).size() > 10){
            history.addAll(PrefUtil.getSearchHistory(getContext()).subList(0, 10));
        }else {
            history.addAll(PrefUtil.getSearchHistory(getContext()));
        }

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    String key = msg.getData().getString("key");
                    if (!key.isEmpty()){
                        getPresenter().search(key, loaiTimKiem, timKiemUuTien);
                        if (history.contains(key)){
                            history.remove(key);
                        }
                        if (history.size() == 10){
                            history.remove(9);
                        }
                        history.add(0, key);
                        historySearchAdapter.notifyDataSetChanged();
                        PrefUtil.saveSearcHistory(history, getContext());
                        rcvHistory.setVisibility(View.GONE);
                        btnDeleteHistory.setVisibility(View.GONE);
                        txtTitle.setText(getString(R.string.ket_qua_hang_dau));

                    }else {
                        rcvHistory.setVisibility(View.VISIBLE);
                        arrayList.clear();
                        adapter.notifyDataSetChanged();
                        emptyView.setVisibility(View.GONE);
                        btnDeleteHistory.setVisibility(View.VISIBLE);
                        txtTitle.setText(getString(R.string.cac_tim_kiem_gan_day));
                    }

                }
            }
        };

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (timer != null) {
                    timer.cancel();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        String key = s.toString();
                        Message message = new Message();
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        bundle.putString("key", key);
                        message.setData(bundle);
                        handler.sendMessage(message);
                    }
                }, 1000);
            }
        });

        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                Toolbox.hideKeyboard(edtSearch);
                return false;
            }
        });

        arrayList = new ArrayList<>();
        adapter = new SearchAdapter(getContext(), arrayList);
        adapter.setOnItemClickListener(new SearchAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {

            }
        });
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv.setEmptyView(emptyView);
        emptyView.setVisibility(View.GONE);

        historySearchAdapter = new HistorySearchAdapter(getContext(), history);
        historySearchAdapter.setOnItemClickListener(new HistorySearchAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                PrefUtil.saveSearcHistory(history, getContext());
            }
        });
        rcvHistory.setAdapter(historySearchAdapter);
        rcvHistory.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public SearchPresenter createPresenter() {
        return new SearchPresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_filter, R.id.btn_delete_history})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_filter:
                if (filterFragment == null){
                    filterFragment = new FilterFragment();

                }
                filterFragment.setOnSaveFilterListener(new FilterFragment.OnSaveFilterListener() {
                    @Override
                    public void onClick(ArrayList<Integer> loai, ArrayList<Integer> uuTien) {
                        loaiTimKiem = loai;
                        timKiemUuTien = uuTien;
                        Toast.makeText(getContext(), loai.toString(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), uuTien.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                getActivity().getSupportFragmentManager().beginTransaction().add(android.R.id.content, filterFragment)
                        .addToBackStack(null).commit();
                break;
            case R.id.btn_delete_history:
                history.clear();
                historySearchAdapter.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetData(ArrayList<TimKiem> data) {
        arrayList.clear();
        if (data.size() > 5){
            arrayList.addAll(data.subList(0, 5));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSearchFail(String message) {
        arrayList.clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onGetLoaiTimKiem(ArrayList<TimKiemLoc> data) {
        for (TimKiemLoc timKiemLoc : data){
            loaiTimKiem.add(timKiemLoc.getId());
        }
    }

    @Override
    public void onGetTimKiemUuTien(ArrayList<TimKiemLoc> data) {
        for (TimKiemLoc timKiemLoc : data){
            timKiemUuTien.add(timKiemLoc.getId());
        }
    }
}
