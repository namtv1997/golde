package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.presenter.PolicyPresenter;

public interface PolicyView extends BaseView<PolicyPresenter> {


    Context gContext();

    void onGetDieuKhoanSuDung(String data);
}