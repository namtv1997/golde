package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.CauHoiNhieuLuaChonPresenter;
import com.app.goldenhealth.ui.fragment.CauHoiNhieuLuaChonView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class CauHoiNhieuLuaChonPresenterImpl extends BasePresenterImpl<CauHoiNhieuLuaChonView> implements CauHoiNhieuLuaChonPresenter {

    private static final String TAG = "CauHoiNhieuLuaChon";

    public CauHoiNhieuLuaChonPresenterImpl(CauHoiNhieuLuaChonView view) {
        super(view);
    }

    @Override
    public void traLoi(int cauHoiId, ArrayList<Integer> dapAns){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().traLoiCauHoi(token, uid, cauHoiId, dapAns, "")
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
                            getView().onSuccess();
                        }else {
                            getView().onFail(booleanResponse.getMessage());
                        }
                    }

                });
    }
}