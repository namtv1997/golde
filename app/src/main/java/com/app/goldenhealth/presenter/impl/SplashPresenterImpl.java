package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.model.User;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.SplashPresenter;
import com.app.goldenhealth.ui.activity.SplashView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SplashPresenterImpl extends BasePresenterImpl<SplashView> implements SplashPresenter {
    private static final String TAG = "Splash" ;

    public SplashPresenterImpl(SplashView view) {
        super(view);
    }

    @Override
    public void getUserDetail(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().getUser("Bearer " + token, uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<User>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e.getMessage());
                        getView().onGetDataFail();
                    }

                    @Override
                    public void onNext(Response<User> userResponse) {
                        Util.getIns().hideLoadding();
                        if (userResponse.getStatus() == 1){
                            PrefUtil.saveDataUser(userResponse.getData(), getView().gContext());
                            Log.d(TAG, "onNext: " + userResponse.toString());
                            getView().onGetDataSuccess();
                        }else {
                            getView().onGetDataFail();
                        }

                    }

                });
    }
}
