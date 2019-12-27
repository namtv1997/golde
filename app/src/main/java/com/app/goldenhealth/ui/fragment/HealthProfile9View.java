package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.DanhMuc;
import com.app.goldenhealth.model.SKSS_KHHGD;
import com.app.goldenhealth.presenter.HealthProfile9Presenter;

import java.util.ArrayList;

public interface HealthProfile9View extends BaseView<HealthProfile9Presenter> {


    Context gContext();

    void onGetInfo(SKSS_KHHGD data);

    void onUpdateSuccess();

    void onFail(String message);

    void onGetListDanhMuc(ArrayList<DanhMuc> data);
}