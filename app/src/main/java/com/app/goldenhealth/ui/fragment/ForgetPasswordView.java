package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.presenter.ForgetPasswordPresenter;

public interface ForgetPasswordView extends BaseView<ForgetPasswordPresenter> {
    void onGetToken(Token token);

    void onSuccess(String data);

    void onFail(String message);

    Context gContext();
}
