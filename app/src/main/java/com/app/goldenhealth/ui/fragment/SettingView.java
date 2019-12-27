package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.presenter.SettingPresenter;

public interface SettingView extends BaseView<SettingPresenter> {


    Context gContext();

    void onSuccess(int isNotify);

    void onFail(String message);
}