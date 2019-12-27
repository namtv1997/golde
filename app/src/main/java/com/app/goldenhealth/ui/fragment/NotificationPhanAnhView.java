package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.presenter.NotificationPhanAnhPresenter;

public interface NotificationPhanAnhView extends BaseView<NotificationPhanAnhPresenter> {


    Context gContext();

    void onGetListThongBao();

    void onUpdateNotify();
}