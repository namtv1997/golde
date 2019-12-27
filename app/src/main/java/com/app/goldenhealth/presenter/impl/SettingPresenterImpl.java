package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.User;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.SettingPresenter;
import com.app.goldenhealth.ui.fragment.SettingView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SettingPresenterImpl extends BasePresenterImpl<SettingView> implements SettingPresenter {

    private static final String TAG = "Setting";

    public SettingPresenterImpl(SettingView view) {
        super(view);
    }

    @Override
    public void setNotification(int isNotify){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        User user = PrefUtil.getDataUser(getView().gContext());
        NetworkModule.getService().updateUser(token, user.getUID(), isNotify, user.getFullName(), user.getBirthDay(),
                user.getChieuCao(), user.getCanNang(), user.getNhomMau(), user.getEmailID(), user.getPhone(), user.getMaBS(),
                user.getDiaChi(),user.getBenhVienID())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError:" + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + booleanResponse);
                        if (booleanResponse.getStatus() == 1){
                            getView().onSuccess(isNotify);
                        }else {
                            getView().onFail(booleanResponse.getMessage());
                        }
                    }

                });
    }
}