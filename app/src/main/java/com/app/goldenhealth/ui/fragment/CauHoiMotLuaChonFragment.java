package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.KhaoSatCauHoi;
import com.app.goldenhealth.model.KhaoSatDapAn;
import com.app.goldenhealth.presenter.CauHoiMotLuaChonPresenter;
import com.app.goldenhealth.presenter.impl.CauHoiMotLuaChonPresenterImpl;
import com.app.goldenhealth.ui.activity.KhaoSattActivity;
import com.app.goldenhealth.ui.adapter.CauHoiMotLuaChonAdapter;
import com.app.goldenhealth.ui.adapter.CauHoiNhieuLuaChonAdapter;
import com.app.goldenhealth.util.Util;

import java.util.ArrayList;
import java.util.Objects;

public class CauHoiMotLuaChonFragment extends BaseFragment<CauHoiMotLuaChonPresenter> implements CauHoiMotLuaChonView {

    @BindView(R.id.txt_cau_hoi)
    TextView txtCauHoi;
    @BindView(R.id.rcv)
    RecyclerView rcv;
    @BindView(R.id.btn_next)
    Button btnNext;
    Unbinder unbinder;
    private KhaoSatCauHoi cauHoi;
    CauHoiMotLuaChonAdapter adapter;
    private int dapAnId = 0;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_cau_hoi_mot_lua_chon;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            cauHoi = (KhaoSatCauHoi) bundle.getSerializable(Key.CAU_HOI);
            txtCauHoi.setText(cauHoi.getCauHoi());
            adapter = new CauHoiMotLuaChonAdapter(getContext(), (ArrayList<KhaoSatDapAn>) cauHoi.getKSDapAs());
            adapter.setOnItemClickListener(new CauHoiMotLuaChonAdapter.OnItemClickListener(){
                @Override
                public void onClick(int position) {
                    dapAnId = cauHoi.getKSDapAs().get(position).getId();
                }

                @Override
                public void onUnClick(int position) {
                    dapAnId = 0;
                }
            });
            rcv.setAdapter(adapter);
            rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        }
    }

    @Override
    public CauHoiMotLuaChonPresenter createPresenter() {
        return new CauHoiMotLuaChonPresenterImpl(this);
    }

    @OnClick(R.id.btn_next)
    public void onViewClicked() {
       if (cauHoi != null){
           if (dapAnId == 0){
               Util.showMessenger("Vui lòng chọn câu trả lời!", getContext());
               return;
           }
           ArrayList<Integer> dapAns = new ArrayList<>();
           dapAns.add(dapAnId);
           getPresenter().traLoi(cauHoi.getId(), dapAns);
       }else {
           ((KhaoSattActivity) Objects.requireNonNull(getActivity())).next();
       }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onSuccess() {
        ((KhaoSattActivity) Objects.requireNonNull(getActivity())).next();
    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, gContext());
    }
}