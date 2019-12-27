package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.presenter.NewPasswordPresenter;

public interface NewPasswordView extends BaseView<NewPasswordPresenter> {
    Context gContext();

    void onSuccess();

    void onFail(String message);
}
