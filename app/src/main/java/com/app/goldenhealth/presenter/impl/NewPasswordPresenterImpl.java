package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.NewPasswordPresenter;
import com.app.goldenhealth.ui.fragment.NewPasswordView;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewPasswordPresenterImpl extends BasePresenterImpl<NewPasswordView> implements NewPasswordPresenter {
    private static final String TAG = "ChangePassword" ;

    public NewPasswordPresenterImpl(NewPasswordView view) {
        super(view);
    }

    @Override
    public void changePassword(String token, String uid, String password){
        Util.getIns().showLoadding(getView().gContext());
        NetworkModule.getService().changePassword("Bearer " + token, uid, password)
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
}
