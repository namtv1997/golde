package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.TienSuBenh;
import com.app.goldenhealth.model.TienSuDiUng;
import com.app.goldenhealth.model.TienSuPhauThuat;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.HealthProfile7Presenter;
import com.app.goldenhealth.ui.fragment.HealthProfile7View;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class HealthProfile7PresenterImpl extends BasePresenterImpl<HealthProfile7View> implements HealthProfile7Presenter {

    private static final String TAG = "TienSuGiaDinh";

    public HealthProfile7PresenterImpl(HealthProfile7View view) {
        super(view);
    }

    @Override
    public void getTienSuDiUng(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().getTienSuDiUngGiaDinhs(token, maYTe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<TienSuDiUng>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<ArrayList<TienSuDiUng>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetTienSuDiUng(arrayListResponse.getData());
                        }
                    }

                });
    }

    @Override
    public void getTienSuBenh(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().getTienSuBenhGiaDinhs(token, maYTe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<TienSuBenh>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<ArrayList<TienSuBenh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetTienSuBenh(arrayListResponse.getData());
                        }
                    }

                });
    }
}