package com.app.goldenhealth.ui.activity;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.presenter.LoginPresenter;

public interface LoginView extends BaseView<LoginPresenter> {
    Context gContext();

    void onFailure(String s);

    void onLoginSuccess();
}
