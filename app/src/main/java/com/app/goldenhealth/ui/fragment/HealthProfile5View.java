package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.KhuyetTat;
import com.app.goldenhealth.presenter.HealthProfile5Presenter;

public interface HealthProfile5View extends BaseView<HealthProfile5Presenter> {


    Context gContext();

    void onGetInfo(KhuyetTat data);

    void onUpdateSuccess();

    void onFail(String message);
}