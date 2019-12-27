package com.app.goldenhealth.ui.fragment;

import android.view.View;
import butterknife.ButterKnife;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.CapNhatMaYTCNPresenter;
import com.app.goldenhealth.presenter.impl.CapNhatMaYTCNPresenterImpl;

public class CapNhatMaYTCNFragment extends BaseFragment<CapNhatMaYTCNPresenter> implements CapNhatMaYTCNView {


    @Override
    public int getContentViewId() {
        return R.layout.fragment_cap_nhat_ma_y_te_ca_nhan;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public CapNhatMaYTCNPresenter createPresenter() {
        return new CapNhatMaYTCNPresenterImpl(this);
    }
}