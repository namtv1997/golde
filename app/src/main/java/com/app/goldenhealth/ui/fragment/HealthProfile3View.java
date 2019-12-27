package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.HoXi;
import com.app.goldenhealth.model.YeuToNguyCo;
import com.app.goldenhealth.presenter.HealthProfile3Presenter;

import java.util.ArrayList;

public interface HealthProfile3View extends BaseView<HealthProfile3Presenter> {


    Context gContext();

    void onGetInfo(YeuToNguyCo data);

    void onGetListHoXi(ArrayList<HoXi> data);

    void onUpdateSuccess();

    void onFail(String message);
}