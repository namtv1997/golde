package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.presenter.VerifyPhonePresenter;

public interface VerifyPhoneView extends BaseView<VerifyPhonePresenter> {
    Context gContext();

    void onSuccess();

    void onFail(String message);

    void onResend();
}
