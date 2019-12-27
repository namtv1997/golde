package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.presenter.CauHoiTraLoiPresenter;

public interface CauHoiTraLoiView extends BaseView<CauHoiTraLoiPresenter> {


    Context gContext();

    void onSuccess();

    void onFail(String message);
}