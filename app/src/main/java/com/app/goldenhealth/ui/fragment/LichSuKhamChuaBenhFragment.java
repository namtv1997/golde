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
import com.app.goldenhealth.model.GroupLichSuKhamChuaBenh;
import com.app.goldenhealth.presenter.LichSuKhamChuaBenhPresenter;
import com.app.goldenhealth.presenter.impl.LichSuKhamChuaBenhPresenterImpl;
import com.app.goldenhealth.ui.adapter.GroupLichSuKhamChuaBenhAdapter;

import java.util.ArrayList;

public class LichSuKhamChuaBenhFragment extends BaseFragment<LichSuKhamChuaBenhPresenter> implements LichSuKhamChuaBenhView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.rcv)
    RecyclerView rcv;
    Unbinder unbinder;

    private GroupLichSuKhamChuaBenhAdapter adapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_lich_su_kham_chua_benh;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getLichSuKhamChua();
    }

    @Override
    public LichSuKhamChuaBenhPresenter createPresenter() {
        return new LichSuKhamChuaBenhPresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetLichSuKhamChua(ArrayList<GroupLichSuKhamChuaBenh> data) {
        adapter = new GroupLichSuKhamChuaBenhAdapter(getContext(), data);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv.setAdapter(adapter);
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        getActivity().getSupportFragmentManager().popBackStack();
    }
}