package com.app.goldenhealth.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.DanhBaDaLuuPresenter;
import com.app.goldenhealth.presenter.impl.DanhBaDaLuuPresenterImpl;
import com.app.goldenhealth.ui.adapter.DanhBaAdapter;
import com.app.goldenhealth.util.EndlessRecyclerViewScrollListener;
import com.app.goldenhealth.util.PrefUtil;

import java.util.Timer;
import java.util.TimerTask;

public class DanhBaDaLuuFragment extends BaseFragment<DanhBaDaLuuPresenter> implements DanhBaDaLuuView {


    @BindView(R.id.edt_search)
    EditText edtSearch;
    @BindView(R.id.rcv)
    RecyclerView rcv;
    Unbinder unbinder;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;

    private EndlessRecyclerViewScrollListener scrollListener;
    private DanhBaAdapter adapter;
    private Timer timer;
    private Handler handler;
    private String key = "";

    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_ba_da_luu;
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getDanhBaByKey("",true);

        adapter = new DanhBaAdapter(getContext(), getPresenter().getListDanhBa());
        adapter.setOnItemClickListener(new DanhBaAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                if (getPresenter().getListDanhBa().get(position).getTYPE() == DanhBaAdapter.TYPE_BAC_SI){

                }else {
                    CoSoYTeFragment coSoYTeFragment = new CoSoYTeFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt(Key.ID, getPresenter().getListDanhBa().get(position).getBENHVIENID());
                    coSoYTeFragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, coSoYTeFragment)
                            .addToBackStack(null).commit();
                }
            }
        });
        rcv.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(linearLayoutManager);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getDanhBaByKey(key, true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getDanhBaByKey(key,false);
            }
        };
        rcv.addOnScrollListener(scrollListener);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    key = msg.getData().getString("key");
                    getPresenter().getDanhBaByKey(key, true);
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
    }

    @Override
    public DanhBaDaLuuPresenter createPresenter() {
        return new DanhBaDaLuuPresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetListDanhBa() {
        swipeLayout.setRefreshing(false);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onGetDataFail() {
        adapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
    }

}