package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.VerifyPhonePresenter;
import com.app.goldenhealth.ui.fragment.VerifyPhoneView;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VerifyPhonePresenterImpl extends BasePresenterImpl<VerifyPhoneView> implements VerifyPhonePresenter {
    private static final String TAG = "VerifyPhone" ;

    public VerifyPhonePresenterImpl(VerifyPhoneView view) {
        super(view);
    }

    @Override
    public void validateVerifyCode(String token, String uid, String code){
        Util.getIns().showLoadding(getView().gContext());
        NetworkModule.getService().validateVerifyCode("Bearer " + token, uid, code)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + booleanResponse);
                        if (booleanResponse.getStatus() == 1){
                            if (booleanResponse.getData()){
                                getView().onSuccess();
                            }else {
                                getView().onFail(booleanResponse.getMessage());
                            }
                        }else {
                            getView().onFail(booleanResponse.getMessage());
                        }
                    }

                });
    }

    @Override
    public void resendVerifyCode(String token, String uid){
        Util.getIns().showLoadding(getView().gContext());
        NetworkModule.getService().reSendVerifyCodeRegister("Bearer " + token, uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + booleanResponse);
                        if (booleanResponse.getStatus() == 1){
                            if (booleanResponse.getData()){
                                getView().onResend();
                            }else {
                                getView().onFail(booleanResponse.getMessage());
                            }
                        }
                    }

                });
    }
}
