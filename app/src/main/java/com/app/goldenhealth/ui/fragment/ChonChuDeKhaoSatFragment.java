package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.app.goldenhealth.model.ChuDeKhaoSat;
import com.app.goldenhealth.presenter.ChonChuDeKhaoSatPresenter;
import com.app.goldenhealth.presenter.impl.ChonChuDeKhaoSatPresenterImpl;
import com.app.goldenhealth.ui.activity.KhaoSattActivity;
import com.app.goldenhealth.ui.adapter.ChuDeKhaoSatAdapter;
import com.app.goldenhealth.util.Util;

import java.util.ArrayList;

public class ChonChuDeKhaoSatFragment extends BaseFragment<ChonChuDeKhaoSatPresenter> implements ChonChuDeKhaoSatView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.rcv)
    RecyclerView rcv;
    @BindView(R.id.btn_next)
    Button btnNext;

    private ChuDeKhaoSatAdapter adapter;
    private int id = 0;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_chon_chu_de_khao_sat;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public ChonChuDeKhaoSatPresenter createPresenter() {
        return new ChonChuDeKhaoSatPresenterImpl(this);
    }


    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetListChuDeKS(ArrayList<ChuDeKhaoSat> data) {
        adapter = new ChuDeKhaoSatAdapter(getContext(), data);
        adapter.setOnItemClickListener(new ChuDeKhaoSatAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, boolean isSeleted) {
                if (isSeleted){
                    id = data.get(position).getId();
                }else {
                    id = 0;
                }

            }
        });
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @OnClick({R.id.btn_back, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_next:
                if (id == 0){
                    Util.showMessenger("Vui lòng chọn chủ đề!", getContext());
                }else {
                    Intent intent = new Intent(getContext(), KhaoSattActivity.class);
                    intent.putExtra(Key.ID, id);
                    startActivity(intent);
                }
                break;
        }
    }
}