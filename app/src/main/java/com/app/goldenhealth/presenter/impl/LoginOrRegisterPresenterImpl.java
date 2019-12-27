package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.LoginOrRegisterPresenter;
import com.app.goldenhealth.ui.activity.LoginOrRegisterView;
import com.app.goldenhealth.util.PrefUtil;
import com.google.firebase.iid.FirebaseInstanceId;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginOrRegisterPresenterImpl extends BasePresenterImpl<LoginOrRegisterView> implements LoginOrRegisterPresenter {

    private static final String TAG = "LoginOrRegister";

    public LoginOrRegisterPresenterImpl(LoginOrRegisterView view) {
        super(view);
    }

    @Override
    public void getToken() {
        String token = FirebaseInstanceId.getInstance().getToken();
        if (token == null || token.isEmpty()) {
            token = "null123456";
        }
        NetworkModule.getService().login("anonymous", "ngqiwtidkqwiuteiq", token, "password")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Token token) {
                        Log.d(TAG, "onNext: " + token);
                        PrefUtil.saveToken(token, getView().gContext());
                        getView().onGetToken(token);
                    }

                });
    }

}