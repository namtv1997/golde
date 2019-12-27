package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.ThongTinTomTat;
import com.app.goldenhealth.presenter.HealthProfile1Presenter;

public interface HealthProfile1View extends BaseView<HealthProfile1Presenter> {


    Context gContext();

    void onGetInfo(ThongTinTomTat data);

    void onUpdateSuccess();

    void onFail(String message);
}