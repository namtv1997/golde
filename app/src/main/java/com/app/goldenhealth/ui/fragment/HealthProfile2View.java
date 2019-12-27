package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.ThongTinTomTat;
import com.app.goldenhealth.model.TinhTrangLucSinh;
import com.app.goldenhealth.presenter.HealthProfile2Presenter;

public interface HealthProfile2View extends BaseView<HealthProfile2Presenter> {


    Context gContext();

    void onGetInfo(TinhTrangLucSinh data);

    void onUpdateSuccess();

    void onFail(String message);
}