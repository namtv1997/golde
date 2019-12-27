package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.TienSuPhauThuat;
import com.app.goldenhealth.presenter.HealthProfile6Presenter;
import com.app.goldenhealth.presenter.impl.HealthProfile6PresenterImpl;
import com.app.goldenhealth.ui.adapter.TienSuPhauThuatAdapter;

import java.util.ArrayList;

public class HealthProfile6Fragment extends BaseFragment<HealthProfile6Presenter> implements HealthProfile6View {

    @BindView(R.id.rcv)
    RecyclerView rcv;
    @BindView(R.id.title)
    LinearLayout title;
    @BindView(R.id.btn_add)
    ImageView btnAdd;
    Unbinder unbinder;
    private ArrayList<TienSuPhauThuat> phauThuatArrayList;
    private TienSuPhauThuatAdapter adapter;
    private boolean isGetData;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_health_profile_6;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getTienSuPhauThuat();

    }

    @Override
    public HealthProfile6Presenter createPresenter() {
        return new HealthProfile6PresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetInfo(ArrayList<TienSuPhauThuat> data) {
//        isGetData = true;
//        phauThuatArrayList.clear();
//        phauThuatArrayList.addAll(data);
//        adapter.notifyDataSetChanged();

        phauThuatArrayList = data;
        adapter = new TienSuPhauThuatAdapter(getContext(), phauThuatArrayList);
        adapter.setOnItemClickListener(new TienSuPhauThuatAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                ThemTienSuPhauThuatFragment themTienSuPhauThuatFragment = new ThemTienSuPhauThuatFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(Key.ID, adapter.getArrayList().get(position).getID());
                themTienSuPhauThuatFragment.setArguments(bundle);
                themTienSuPhauThuatFragment.setOnCreateSuccess(new ThemTienSuPhauThuatFragment.OnCreateSuccess() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getContext(), R.string.update_success, Toast.LENGTH_SHORT).show();
                        getPresenter().getTienSuPhauThuat();
                    }
                });
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, themTienSuPhauThuatFragment)
                        .addToBackStack(null).commit();
            }
        });
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv.setAdapter(adapter);
    }

    @OnClick(R.id.btn_add)
    public void onViewClicked() {
        ThemTienSuPhauThuatFragment themTienSuPhauThuatFragment = new ThemTienSuPhauThuatFragment();
        themTienSuPhauThuatFragment.setOnCreateSuccess(new ThemTienSuPhauThuatFragment.OnCreateSuccess() {
            @Override
            public void onSuccess() {
                Toast.makeText(getContext(), R.string.them_thanh_cong, Toast.LENGTH_SHORT).show();
                getPresenter().getTienSuPhauThuat();
            }
        });
        getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, themTienSuPhauThuatFragment)
                .addToBackStack(null).commit();
    }
}