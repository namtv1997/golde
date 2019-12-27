package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.ChuDePhanAnh;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.ChuDePhanAnhPresenter;
import com.app.goldenhealth.ui.fragment.ChuDePhanAnhView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class ChuDePhanAnhPresenterImpl extends BasePresenterImpl<ChuDePhanAnhView> implements ChuDePhanAnhPresenter {

    private static final String TAG = "ChuDePhanAnh";

    public ChuDePhanAnhPresenterImpl(ChuDePhanAnhView view) {
        super(view);
    }

    @Override
    public void getChuDePhanAnh(){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getChuDePhanAnh(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<ChuDePhanAnh>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<ChuDePhanAnh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetChuDePhanAnh(arrayListResponse.getData());
                        }
                    }
                });
    }
}