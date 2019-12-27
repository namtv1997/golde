package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.AppInfoPresenter;
import com.app.goldenhealth.presenter.impl.AppInfoPresenterImpl;

import java.util.Objects;

public class AppInfoFragment extends BaseFragment<AppInfoPresenter> implements AppInfoView {


    @BindView(R.id.txt_version)
    TextView txtVersion;
    @BindView(R.id.btn_hdsd)
    LinearLayout btnHdsd;
    @BindView(R.id.btn_policy)
    LinearLayout btnPolicy;
    @BindView(R.id.btn_binh_chon)
    LinearLayout btnBinhChon;
    Unbinder unbinder;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_thong_tin_app;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);

    }

    @Override
    public AppInfoPresenter createPresenter() {
        return new AppInfoPresenterImpl(this);
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
    public void onGetThongTinApp(String data) {

    }

    @OnClick({R.id.btn_hdsd, R.id.btn_policy, R.id.btn_binh_chon})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_hdsd:
                break;
            case R.id.btn_policy:
                PolicyFragment policyFragment = new PolicyFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, policyFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_binh_chon:
                break;
        }
    }
}