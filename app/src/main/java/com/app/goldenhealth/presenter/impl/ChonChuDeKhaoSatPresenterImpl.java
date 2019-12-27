package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.ChuDeKhaoSat;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.Thon;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.ChonChuDeKhaoSatPresenter;
import com.app.goldenhealth.ui.fragment.ChonChuDeKhaoSatView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class ChonChuDeKhaoSatPresenterImpl extends BasePresenterImpl<ChonChuDeKhaoSatView> implements ChonChuDeKhaoSatPresenter {

    private static final String TAG = "ChonChuDeKhaoSat" ;

    public ChonChuDeKhaoSatPresenterImpl(ChonChuDeKhaoSatView view) {
        super(view);
        getChuDeKhaoSat();
    }

    @Override
    public void getChuDeKhaoSat(){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getChuDeKS(token, uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<ChuDeKhaoSat>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<ChuDeKhaoSat>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListChuDeKS(arrayListResponse.getData());
                        }
                    }
                });
    }
}