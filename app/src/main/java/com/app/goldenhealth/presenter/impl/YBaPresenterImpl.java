package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.BenhNhan;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.TienSuDiUng;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.YBaPresenter;
import com.app.goldenhealth.ui.fragment.YBaView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class YBaPresenterImpl extends BasePresenterImpl<YBaView> implements YBaPresenter {

    private static final String TAG = "YBa";

    public YBaPresenterImpl(YBaView view) {
        super(view);
    }

    @Override
    public void getListBenhNhan(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().getListBenhNhan(token, uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<BenhNhan>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        getView().onGetDataFailed("Lỗi");
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<ArrayList<BenhNhan>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListBenhNhan(arrayListResponse.getData());
                        }else {
                            getView().onGetDataFailed(arrayListResponse.getMessage());
                        }
                    }
                });
    }
}