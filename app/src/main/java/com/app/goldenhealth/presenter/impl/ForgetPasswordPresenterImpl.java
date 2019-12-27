package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.ForgetPasswordPresenter;
import com.app.goldenhealth.ui.fragment.ForgetPasswordView;
import com.app.goldenhealth.util.Util;
import com.google.firebase.iid.FirebaseInstanceId;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ForgetPasswordPresenterImpl extends BasePresenterImpl<ForgetPasswordView> implements ForgetPasswordPresenter {
    private static final String TAG = "ForgetPassword" ;

    public ForgetPasswordPresenterImpl(ForgetPasswordView view) {
        super(view);
        getToken();
    }

    public void getToken() {
        String token = FirebaseInstanceId.getInstance().getToken();
        if (token == null || token.isEmpty()) {
            token = "null123456";
        }
        NetworkModule.getService().login(Key.registerUsername, Key.registerPassword, token, "password")
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
                        getView().onGetToken(token);
                    }

                });
    }

    @Override
    public void forgetPassword(String token, String email, String phone){
        Util.getIns().showLoadding(getView().gContext());
        NetworkModule.getService().forgetPassword("Bearer " + token, email, phone)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<String>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError:" + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<String> stringResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + stringResponse);
                        if (stringResponse.getStatus() == 1){
                            getView().onSuccess(stringResponse.getData());
                        }else {
                            getView().onFail(stringResponse.getMessage());
                        }
                    }

                });
    }
}
