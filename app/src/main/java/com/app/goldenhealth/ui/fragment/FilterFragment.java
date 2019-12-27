package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
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
import com.app.goldenhealth.model.TimKiemLoc;
import com.app.goldenhealth.presenter.FilterPresenter;
import com.app.goldenhealth.presenter.impl.FilterPresenterImpl;
import com.app.goldenhealth.ui.adapter.FilterAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class FilterFragment extends BaseFragment<FilterPresenter> implements FilterView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.rcv_loai)
    RecyclerView rcvLoai;
    @BindView(R.id.rcv_uu_tien)
    RecyclerView rcvUuTien;
    @BindView(R.id.btn_save)
    TextView btnSave;
    Unbinder unbinder;

    private FilterAdapter adapterLoai;
    private FilterAdapter adapterUuTien;
    private ArrayList<TimKiemLoc> listLoai;
    private ArrayList<TimKiemLoc> listUuTien;
    private OnSaveFilterListener onSaveFilterListener;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_filter;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        listLoai = new ArrayList<>();
        listUuTien = new ArrayList<>();
    }

    @Override
    public FilterPresenter createPresenter() {
        return new FilterPresenterImpl(this);
    }


    @OnClick({R.id.btn_back, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_save:
                ArrayList<Integer> loaiTimKiem = new ArrayList<>();
                for (int i=0; i<listLoai.size(); i++){
                    if (listLoai.get(i).isCheck()){
                        loaiTimKiem.add(listLoai.get(i).getId());
                    }
                }

                ArrayList<Integer> timKiemUuTien = new ArrayList<>();
                for (int i=0; i<listUuTien.size(); i++){
                    if (listUuTien.get(i).isCheck()){
                        timKiemUuTien.add(listUuTien.get(i).getId());
                    }
                }

                onSaveFilterListener.onClick(loaiTimKiem, timKiemUuTien);
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
                break;
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetLoaiTimKiem(ArrayList<TimKiemLoc> data) {
        listLoai = data;
        adapterLoai = new FilterAdapter(getContext(), listLoai);
        adapterLoai.setOnItemClickListener(new FilterAdapter.OnItemClickListener() {
            @Override
            public void onClick(int id, boolean isCheck) {

            }
        });
        rcvLoai.setAdapter(adapterLoai);
        rcvLoai.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onGetTimKiemUuTien(ArrayList<TimKiemLoc> data) {
        listUuTien = data;
        adapterUuTien = new FilterAdapter(getContext(), listUuTien);
        adapterUuTien.setOnItemClickListener(new FilterAdapter.OnItemClickListener() {
            @Override
            public void onClick(int id, boolean isCheck) {

            }
        });
        rcvUuTien.setAdapter(adapterUuTien);
        rcvUuTien.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void setOnSaveFilterListener(OnSaveFilterListener onSaveFilterListener) {
        this.onSaveFilterListener = onSaveFilterListener;
    }

    public interface OnSaveFilterListener {
        void onClick(ArrayList<Integer> loaiTimKiem, ArrayList<Integer> timKiemUuTien);
    }
}
