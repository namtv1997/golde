package com.app.goldenhealth.ui.fragment;

import android.os.Bundle;
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
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.KhaoSatPresenter;
import com.app.goldenhealth.presenter.impl.KhaoSatPresenterImpl;

public class KhaoSatFragment extends BaseFragment<KhaoSatPresenter> implements KhaoSatView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.btn_next)
    Button btnNext;
    Unbinder unbinder;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_khao_sat;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public KhaoSatPresenter createPresenter() {
        return new KhaoSatPresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_next:
                ChonChuDeKhaoSatFragment chonChuDeKhaoSatFragment = new ChonChuDeKhaoSatFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, chonChuDeKhaoSatFragment)
                        .addToBackStack(null).commit();
                break;
        }
    }
}