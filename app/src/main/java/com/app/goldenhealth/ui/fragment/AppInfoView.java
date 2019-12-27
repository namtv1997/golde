package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.presenter.AppInfoPresenter;

public interface AppInfoView extends BaseView<AppInfoPresenter> {


    Context gContext();

    void onGetThongTinApp(String data);
}