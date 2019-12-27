package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.BenhNhan;
import com.app.goldenhealth.presenter.YBaPresenter;
import com.app.goldenhealth.presenter.impl.YBaPresenterImpl;
import com.app.goldenhealth.ui.adapter.YBaAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class YBaFragment extends BaseFragment<YBaPresenter> implements YBaView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.edt_search)
    EditText edtSearch;
    @BindView(R.id.rcv)
    RecyclerView rcv;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;

    private YBaAdapter adapter;
    private ArrayList<BenhNhan> benhNhans;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_y_ba;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null){
            if (bundle.getBoolean(Key.TITLE)){
                viewTitle.setVisibility(View.VISIBLE);
            }
        }

        getPresenter().getListBenhNhan();
        benhNhans = new ArrayList<>();
        adapter = new YBaAdapter(getContext(), benhNhans);
        adapter.setOnItemClickListener(new YBaAdapter.OnItemClickListener() {
            @Override
            public void onClick(int id) {

            }
        });
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv.setAdapter(adapter);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getListBenhNhan();
            }
        });
    }

    @Override
    public YBaPresenter createPresenter() {
        return new YBaPresenterImpl(this);
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetListBenhNhan(ArrayList<BenhNhan> data) {
        benhNhans.clear();
        benhNhans.addAll(data);
        adapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
    }

    @Override
    public void onGetDataFailed(String message) {
        swipeLayout.setRefreshing(false);
    }
}