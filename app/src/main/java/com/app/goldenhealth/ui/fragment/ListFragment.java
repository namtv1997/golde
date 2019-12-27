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
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.presenter.ListPresenter;
import com.app.goldenhealth.presenter.impl.ListPresenterImpl;
import com.app.goldenhealth.ui.adapter.BenhVienAdapter;
import com.app.goldenhealth.util.EndlessRecyclerViewScrollListener;

import java.util.Objects;

public class ListFragment extends BaseFragment<ListPresenter> implements ListView {
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.rcv)
    RecyclerView rcv;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    Unbinder unbinder;

    private BenhVienAdapter adapter;
    private EndlessRecyclerViewScrollListener scrollListener;
    private String token;
    private OnItemSelectedistener onItemSelectedistener;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_list;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            token = bundle.getString(Key.TOKEN);
        }
        getPresenter().getBenhVien(token, false);

        adapter = new BenhVienAdapter(getContext(), getPresenter().getArrayList()) {
        };
        adapter.setOnItemClickListener(new BenhVienAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                onItemSelectedistener.onSelected(getPresenter().getArrayList().get(position));
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setAdapter(adapter);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getBenhVien(token, true);
            }
        });
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getBenhVien(token, false);
            }
        };
        rcv.addOnScrollListener(scrollListener);
    }

    @Override
    public ListPresenter createPresenter() {
        return new ListPresenterImpl(this);
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
    public void onGetListBenhVien() {
        adapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
    }

    public void setOnItemSelectedistener(OnItemSelectedistener onItemSelectedistener) {
        this.onItemSelectedistener = onItemSelectedistener;
    }

    public interface OnItemSelectedistener {
        void onSelected(BenhVien benhVien);
    }
}