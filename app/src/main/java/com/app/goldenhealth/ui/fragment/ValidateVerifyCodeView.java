package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.presenter.ValidateVerifyCodePresenter;

public interface ValidateVerifyCodeView extends BaseView<ValidateVerifyCodePresenter> {


    void onFail(String message);

    void onSuccess();

    Context gContext();

    void onResend();
}