package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.TienSuBenh;
import com.app.goldenhealth.model.TienSuDiUng;
import com.app.goldenhealth.presenter.HealthProfile7Presenter;
import com.app.goldenhealth.presenter.impl.HealthProfile7PresenterImpl;
import com.app.goldenhealth.ui.adapter.TienSuBenhAdapter;
import com.app.goldenhealth.ui.adapter.TienSuDiUngAdapter;

import java.util.ArrayList;

public class HealthProfile7Fragment extends BaseFragment<HealthProfile7Presenter> implements HealthProfile7View {


    @BindView(R.id.btn_add_du)
    ImageView btnAddDu;
    @BindView(R.id.rcv_du)
    RecyclerView rcvDu;
    @BindView(R.id.btn_add_benh)
    ImageView btnAddBenh;
    @BindView(R.id.rcv_benh)
    RecyclerView rcvBenh;
    Unbinder unbinder;

    private ArrayList<TienSuDiUng> tienSuDiUngArrayList;
    private TienSuDiUngAdapter tienSuDiUngAdapter;
    private ArrayList<TienSuBenh> tienSuBenhArrayList;
    private TienSuBenhAdapter tienSuBenhAdapter;
    private boolean isLoadTienSuDiUng;
    private boolean isLoadTienSuBenh;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_health_profile_7;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getTienSuBenh();
        getPresenter().getTienSuDiUng();
        tienSuDiUngArrayList = new ArrayList<>();
        tienSuDiUngAdapter = new TienSuDiUngAdapter(getContext(), tienSuDiUngArrayList);
        tienSuDiUngAdapter.setOnItemClickListener(new TienSuDiUngAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                ThemTienSuDiUngFragment themTienSuDiUngFragment = new ThemTienSuDiUngFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(Key.ID, tienSuDiUngAdapter.getArrayList().get(position).getID());
                themTienSuDiUngFragment.setArguments(bundle);
                themTienSuDiUngFragment.setOnCreateSuccess(new ThemTienSuDiUngFragment.OnCreateSuccess() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getContext(), R.string.update_success, Toast.LENGTH_SHORT).show();
                        getPresenter().getTienSuDiUng();
                    }
                });
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, themTienSuDiUngFragment)
                        .addToBackStack(null).commit();
            }
        });
        rcvDu.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvDu.setAdapter(tienSuDiUngAdapter);

        tienSuBenhArrayList = new ArrayList<>();
        tienSuBenhAdapter = new TienSuBenhAdapter(getContext(), tienSuBenhArrayList);
        tienSuBenhAdapter.setOnItemClickListener(new TienSuBenhAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                ThemTienSuBenhFragment themTienSuBenhFragment = new ThemTienSuBenhFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(Key.ID, tienSuBenhAdapter.getArrayList().get(position).getID());
                themTienSuBenhFragment.setArguments(bundle);
                themTienSuBenhFragment.setOnCreateSuccess(new ThemTienSuDiUngFragment.OnCreateSuccess() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getContext(), R.string.update_success, Toast.LENGTH_SHORT).show();
                        getPresenter().getTienSuBenh();
                    }
                });

                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, themTienSuBenhFragment)
                        .addToBackStack(null).commit();
            }
        });
        rcvBenh.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvBenh.setAdapter(tienSuBenhAdapter);
    }

    @Override
    public HealthProfile7Presenter createPresenter() {
        return new HealthProfile7PresenterImpl(this);
    }

    @OnClick({R.id.btn_add_du, R.id.btn_add_benh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add_du:
                ThemTienSuDiUngFragment themTienSuDiUngFragment = new ThemTienSuDiUngFragment();
                themTienSuDiUngFragment.setOnCreateSuccess(new ThemTienSuDiUngFragment.OnCreateSuccess() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getContext(), R.string.them_thanh_cong, Toast.LENGTH_SHORT).show();
                        getPresenter().getTienSuDiUng();
                    }
                });
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, themTienSuDiUngFragment)
                        .addToBackStack(null).commit();
                break;
            case R.id.btn_add_benh:
                ThemTienSuBenhFragment themTienSuBenhFragment = new ThemTienSuBenhFragment();
                themTienSuBenhFragment.setOnCreateSuccess(new ThemTienSuDiUngFragment.OnCreateSuccess() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getContext(), R.string.them_thanh_cong, Toast.LENGTH_SHORT).show();
                        getPresenter().getTienSuBenh();
                    }
                });

                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, themTienSuBenhFragment)
                        .addToBackStack(null).commit();
                break;
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetTienSuDiUng(ArrayList<TienSuDiUng> data) {
        isLoadTienSuDiUng = true;
        tienSuDiUngArrayList.clear();
        tienSuDiUngArrayList.addAll(data);
        tienSuDiUngAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetTienSuBenh(ArrayList<TienSuBenh> data) {
        isLoadTienSuBenh = true;
        tienSuBenhArrayList.clear();
        tienSuBenhArrayList.addAll(data);
        tienSuBenhAdapter.notifyDataSetChanged();
    }

}