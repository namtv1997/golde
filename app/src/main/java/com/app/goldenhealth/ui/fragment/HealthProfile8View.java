package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.VanDeKhac;
import com.app.goldenhealth.presenter.HealthProfile8Presenter;

public interface HealthProfile8View extends BaseView<HealthProfile8Presenter> {


    Context gContext();

    void onGetInfo(VanDeKhac data);

    void onUpdateSuccess();

    void onFail(String message);
}