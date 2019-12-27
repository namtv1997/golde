package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.DiaDiemPhanAnh;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.ChonNoiPhanAnhPresenter;
import com.app.goldenhealth.ui.fragment.ChonNoiPhanAnhView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class ChonNoiPhanAnhPresenterImpl extends BasePresenterImpl<ChonNoiPhanAnhView> implements ChonNoiPhanAnhPresenter {

    private static final String TAG = "ChonNoiPhanAnh" ;

    public ChonNoiPhanAnhPresenterImpl(ChonNoiPhanAnhView view) {
        super(view);
        getDiaDiemPhanAnh();
    }

    public void getDiaDiemPhanAnh(){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getDiaDiemPhanAnh(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DiaDiemPhanAnh>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<DiaDiemPhanAnh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetDiaDiemPhanAnh(arrayListResponse.getData());
                        }
                    }
                });
    }
}