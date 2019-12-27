package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.presenter.CauHoiNhieuLuaChonPresenter;

public interface CauHoiNhieuLuaChonView extends BaseView<CauHoiNhieuLuaChonPresenter> {


    Context gContext();

    void onSuccess();

    void onFail(String message);
}