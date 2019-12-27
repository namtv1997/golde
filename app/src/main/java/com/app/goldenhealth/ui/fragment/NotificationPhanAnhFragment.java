package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.NotificationPhanAnhPresenter;
import com.app.goldenhealth.presenter.impl.NotificationPhanAnhPresenterImpl;
import com.app.goldenhealth.ui.activity.PhanAnhChiTietActivity;
import com.app.goldenhealth.ui.activity.PhanAnhMoiNguoiActivity;
import com.app.goldenhealth.ui.adapter.NotificationAdapter;
import com.app.goldenhealth.util.EndlessRecyclerViewScrollListener;

public class NotificationPhanAnhFragment extends BaseFragment<NotificationPhanAnhPresenter> implements NotificationPhanAnhView {


    @BindView(R.id.rcv)
    RecyclerView rcv;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    Unbinder unbinder;
    private NotificationAdapter adapter;
    private EndlessRecyclerViewScrollListener scrollListener;
    private int type;

    @Override
    public int getContentViewId() {
        return R.layout.fragmnent_notification_phan_hoi;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        type = Key.PHAN_ANH;
        Bundle bundle = getArguments();
        if (bundle != null) {
            type = bundle.getInt(Key.NOTIFICATION_TYPE);
        }
        getPresenter().getThongBao(type, false);

        adapter = new NotificationAdapter(getContext(), getPresenter().getListThongBao());
        adapter.setOnItemClickListener(new NotificationAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                getPresenter().updateThongBao(getPresenter().getListThongBao().get(position).getId());
                if (getPresenter().getListThongBao().get(position).getPayload().getType() == 1){
                    Intent intent = new Intent(getContext(), PhanAnhChiTietActivity.class);
                    intent.putExtra(Key.PHAN_ANH_ID, getPresenter().getListThongBao().get(position).getPayload().getId());
                    startActivity(intent);
                }
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setAdapter(adapter);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getThongBao(type, true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getThongBao(type, false);
            }
        };
        rcv.addOnScrollListener(scrollListener);

    }

    @Override
    public NotificationPhanAnhPresenter createPresenter() {
        return new NotificationPhanAnhPresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetListThongBao() {
        adapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
    }

    @Override
    public void onUpdateNotify() {
        adapter.notifyDataSetChanged();
    }

}