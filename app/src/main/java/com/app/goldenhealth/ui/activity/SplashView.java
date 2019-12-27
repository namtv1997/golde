package com.app.goldenhealth.ui.activity;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.presenter.SplashPresenter;

public interface SplashView extends BaseView<SplashPresenter> {
    Context gContext();

    void onGetDataSuccess();

    void onGetDataFail();
}
