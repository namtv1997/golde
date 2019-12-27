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
import com.app.goldenhealth.presenter.CauHoiNhieuLuaChonPresenter;
import com.app.goldenhealth.presenter.impl.CauHoiNhieuLuaChonPresenterImpl;
import com.app.goldenhealth.ui.activity.KhaoSattActivity;
import com.app.goldenhealth.ui.adapter.CauHoiNhieuLuaChonAdapter;
import com.app.goldenhealth.util.Util;

import java.util.ArrayList;
import java.util.Objects;

public class CauHoiNhieuLuaChonFragment extends BaseFragment<CauHoiNhieuLuaChonPresenter> implements CauHoiNhieuLuaChonView {

    @BindView(R.id.txt_cau_hoi)
    TextView txtCauHoi;
    @BindView(R.id.rcv)
    RecyclerView rcv;
    @BindView(R.id.btn_next)
    Button btnNext;
    Unbinder unbinder;
    private KhaoSatCauHoi cauHoi;
    private CauHoiNhieuLuaChonAdapter adapter;
    private ArrayList<Integer> dapAns;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_cau_hoi_nhieu_lua_chon;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        dapAns = new ArrayList<>();
        Bundle bundle = getArguments();
        if (bundle != null) {
            cauHoi = (KhaoSatCauHoi) bundle.getSerializable(Key.CAU_HOI);
            txtCauHoi.setText(cauHoi.getCauHoi());
            adapter = new CauHoiNhieuLuaChonAdapter(getContext(), (ArrayList<KhaoSatDapAn>) cauHoi.getKSDapAs());
            adapter.setOnItemClickListener(new CauHoiNhieuLuaChonAdapter.OnItemClickListener() {
                @Override
                public void onClick(int position, boolean isCheck) {
                    if (isCheck){
                        dapAns.add(cauHoi.getKSDapAs().get(position).getId());
                    }else if (dapAns.contains(cauHoi.getKSDapAs().get(position).getId())){
                        dapAns.remove(cauHoi.getKSDapAs().get(position).getId());
                    }

                }
            });
            rcv.setAdapter(adapter);
            rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        }
    }

    @Override
    public CauHoiNhieuLuaChonPresenter createPresenter() {
        return new CauHoiNhieuLuaChonPresenterImpl(this);
    }

    @OnClick(R.id.btn_next)
    public void onViewClicked() {
        if (cauHoi != null){
            if (dapAns.size() == 0){
                Util.showMessenger("Vui lòng chọn câu trả lời!", getContext());
                return;
            }
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