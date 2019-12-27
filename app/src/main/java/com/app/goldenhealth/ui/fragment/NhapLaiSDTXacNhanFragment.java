package com.app.goldenhealth.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.NhapLaiSDTXacNhanPresenter;
import com.app.goldenhealth.presenter.impl.NhapLaiSDTXacNhanPresenterImpl;

import java.util.Objects;

public class NhapLaiSDTXacNhanFragment extends BaseFragment<NhapLaiSDTXacNhanPresenter> implements NhapLaiSDTXacNhanView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.edt_phone)
    EditText edtPhone;
    @BindView(R.id.btn_next)
    TextView btnNext;
    Unbinder unbinder;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_nhap_lai_sdt_xac_nhan;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public NhapLaiSDTXacNhanPresenter createPresenter() {
        return new NhapLaiSDTXacNhanPresenterImpl(this);
    }


    @OnClick({R.id.btn_back, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_next:

                break;
        }
    }
}