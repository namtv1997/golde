package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.TienSuBenhTat;
import com.app.goldenhealth.presenter.HealthProfile4Presenter;

public interface HealthProfile4View extends BaseView<HealthProfile4Presenter> {


    Context gContext();

    void onGetInfo(TienSuBenhTat data);

    void onUpdateSuccess();

    void onFail(String message);
}