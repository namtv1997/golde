package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.ChuDePhanAnh;
import com.app.goldenhealth.presenter.ChuDePhanAnhPresenter;
import com.app.goldenhealth.presenter.impl.ChuDePhanAnhPresenterImpl;
import com.app.goldenhealth.ui.adapter.ChuDePhanAnhAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class ChuDePhanAnhFragment extends BaseFragment<ChuDePhanAnhPresenter> implements ChuDePhanAnhView {
    @BindView(R.id.rcv)
    RecyclerView rcv;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;

    private ChuDePhanAnhAdapter adapter;
    private ArrayList<ChuDePhanAnh> arrayList;
    private OnItemClickListener onItemClickListener;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_chon_chu_de_phan_anh;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getChuDePhanAnh();
        arrayList = new ArrayList<>();
        adapter = new ChuDePhanAnhAdapter(getContext(), arrayList);
        adapter.setOnItemClickListener(new ChuDePhanAnhAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                onItemClickListener.onClick(arrayList.get(position));
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
            }
        });
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getChuDePhanAnh();
            }
        });
    }

    @Override
    public ChuDePhanAnhPresenter createPresenter() {
        return new ChuDePhanAnhPresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetChuDePhanAnh(ArrayList<ChuDePhanAnh> data) {
        arrayList.clear();
        arrayList.addAll(data);
        adapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
    }

    public interface OnItemClickListener {
        void onClick(ChuDePhanAnh chuDePhanAnh);
    }
}