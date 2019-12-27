package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.PolicyPresenter;
import com.app.goldenhealth.presenter.impl.PolicyPresenterImpl;

public class PolicyFragment extends BaseFragment<PolicyPresenter> implements PolicyView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.webView)
    WebView webView;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_policy;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getDieuKhoanSuDung();
    }

    @Override
    public PolicyPresenter createPresenter() {
        return new PolicyPresenterImpl(this);
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetDieuKhoanSuDung(String data) {
        webView.loadData(data,  "text/html", null);
    }
}