package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.presenter.Login2Presenter;

public interface Login2View extends BaseView<Login2Presenter> {

    Context gContext();

    void onFailure(String errorDescription);

    void onLoginSuccess();
}