package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.CoSoYTeGanDayPresenter;
import com.app.goldenhealth.ui.fragment.CoSoYTeGanDayView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class CoSoYTeGanDayPresenterImpl extends BasePresenterImpl<CoSoYTeGanDayView> implements CoSoYTeGanDayPresenter {
    private static final String TAG = "CoSoYTeGanDay" ;

    public CoSoYTeGanDayPresenterImpl(CoSoYTeGanDayView view) {
        super(view);
    }

    @Override
    public void getBenhVienGanDay(String diaDiem){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getBenhViensByDiaDiem(token,diaDiem)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<BenhVien>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<BenhVien>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + arrayListResponse);
                        if (arrayListResponse.getStatus() == 1 && arrayListResponse.getData() != null){
                            getView().onGetListBenhVienGanDay(arrayListResponse.getData());
                        }
                    }

                });
    }
}
