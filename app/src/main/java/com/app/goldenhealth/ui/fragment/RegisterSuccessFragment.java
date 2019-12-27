package com.app.goldenhealth.ui.fragment;

import android.view.View;
import butterknife.ButterKnife;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.RegisterSuccessPresenter;
import com.app.goldenhealth.presenter.impl.RegisterSuccessPresenterImpl;

public class RegisterSuccessFragment extends BaseFragment<RegisterSuccessPresenter> implements RegisterSuccessView {
    @Override
    public int getContentViewId() {
        return R.layout.fragment_register_success;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public RegisterSuccessPresenter createPresenter() {
        return new RegisterSuccessPresenterImpl(this);
    }
}
