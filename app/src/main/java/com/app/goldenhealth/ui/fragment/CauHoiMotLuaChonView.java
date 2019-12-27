package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.presenter.CauHoiMotLuaChonPresenter;

public interface CauHoiMotLuaChonView extends BaseView<CauHoiMotLuaChonPresenter> {


    Context gContext();

    void onSuccess();

    void onFail(String message);
}