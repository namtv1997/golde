package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.ChuDeKhaoSat;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.TimKiemLoc;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.FilterPresenter;
import com.app.goldenhealth.ui.fragment.FilterView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class FilterPresenterImpl extends BasePresenterImpl<FilterView> implements FilterPresenter {
    public FilterPresenterImpl(FilterView view) {
        super(view);
        getLoaiTimKiem();
        getTimKiemUuKiem();
    }

    @Override
    public void getLoaiTimKiem(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getLoaiTimKiem(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<TimKiemLoc>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<TimKiemLoc>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetLoaiTimKiem(arrayListResponse.getData());
                        }
                    }
                });
    }

    @Override
    public void getTimKiemUuKiem(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getTimKiemUuTien(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<TimKiemLoc>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<TimKiemLoc>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetTimKiemUuTien(arrayListResponse.getData());
                        }
                    }
                });
    }
}
