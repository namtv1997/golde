package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.AppInfoPresenter;
import com.app.goldenhealth.ui.fragment.AppInfoView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AppInfoPresenterImpl extends BasePresenterImpl<AppInfoView> implements AppInfoPresenter {

    private static final String TAG = "AppInfo";

    public AppInfoPresenterImpl(AppInfoView view) {
        super(view);
    }

    @Override
    public void getThongTinApp(){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getThongTinApp(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<String> stringResponse) {
                        Util.getIns().hideLoadding();
                        if (stringResponse.getStatus() == 1){
                            getView().onGetThongTinApp(stringResponse.getData());
                        }
                    }

                });
    }
}