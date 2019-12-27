package com.app.goldenhealth.ui.activity;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.presenter.LoginOrRegisterPresenter;

public interface LoginOrRegisterView extends BaseView<LoginOrRegisterPresenter> {


    Context gContext();

    void onGetToken(Token token);
}