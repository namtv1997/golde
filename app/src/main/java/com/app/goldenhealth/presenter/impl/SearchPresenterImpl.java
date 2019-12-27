package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.TimKiem;
import com.app.goldenhealth.model.TimKiemLoc;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.SearchPresenter;
import com.app.goldenhealth.ui.fragment.SearchView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class SearchPresenterImpl extends BasePresenterImpl<SearchView> implements SearchPresenter {

    private static final String TAG = "Search" ;

    public SearchPresenterImpl(SearchView view) {
        super(view);
        getLoaiTimKiem();
    }

    @Override
    public void search(String keyword, ArrayList<Integer> loaiTimKiem, ArrayList<Integer> timKiemUuTien){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().timKiem(token, keyword, loaiTimKiem, timKiemUuTien)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<TimKiem>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError:" + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<ArrayList<TimKiem>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + arrayListResponse);
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetData(arrayListResponse.getData());
                        }else {
                            getView().onSearchFail(arrayListResponse.getMessage());
                        }
                    }

                });
    }

    public void getLoaiTimKiem(){
        Util.getIns().showLoadding(getView().gContext());
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
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetLoaiTimKiem(arrayListResponse.getData());
                            getTimKiemUuKiem();
                        }
                    }
                });
    }

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
