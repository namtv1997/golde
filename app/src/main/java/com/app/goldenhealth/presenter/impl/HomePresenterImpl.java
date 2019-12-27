package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.*;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.HomePresenter;
import com.app.goldenhealth.ui.fragment.HomeView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class HomePresenterImpl extends BasePresenterImpl<HomeView> implements HomePresenter {

    private static final String TAG = "Home";

    public HomePresenterImpl(HomeView view) {
        super(view);
    }

    @Override
    public void getDanhMuc(DanhMucType danhMucType){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();

        NetworkModule.getService().getListDanhMuc(danhMucType.getApiListPath(), token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhMuc>>>() {
                               @Override
                               public void onCompleted() {

                               }

                               @Override
                               public void onError(Throwable e) {
                                   Log.d(TAG, "onError: " + e);
                               }

                               @Override
                               public void onNext(Response<ArrayList<DanhMuc>> arrayListResponse) {
                                   Log.d(TAG, "onNext: " + arrayListResponse.getData().toString());
                               }
                });
    }

    @Override
    public void getNumberNotifiUnread(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().countThongBaosByIsRead(token, uid, 0)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Integer>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError:" + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<Integer> integerResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + integerResponse.getStatus());
                        if (integerResponse.getStatus() == 1){
                            getView().onGetNumberNotifiUnread(integerResponse.getData());
                        }
                    }

                });
    }

    @Override
    public void getDashboard(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getDashboard(token, uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Dashboard>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<Dashboard> dashboardResponse) {
                        Util.getIns().hideLoadding();
                        if (dashboardResponse.getStatus() == 1){
                            getView().onGetDashboard(dashboardResponse.getData());
                        }
                    }
                });
    }
}
