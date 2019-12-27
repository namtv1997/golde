package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.ChuDeKhaoSat;
import com.app.goldenhealth.model.KhaoSatCauHoi;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.KhaoSattPresenter;
import com.app.goldenhealth.ui.activity.KhaoSattView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class KhaoSattPresenterImpl extends BasePresenterImpl<KhaoSattView> implements KhaoSattPresenter {

    private static final String TAG = "KhaoSatt";

    public KhaoSattPresenterImpl(KhaoSattView view) {
        super(view);

    }

    @Override
    public void getCauHoiKhaoSat(int id){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getCauHoi(token,id, uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<KhaoSatCauHoi>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<KhaoSatCauHoi>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListCauHoi(arrayListResponse.getData());
                        }
                    }

                });
    }
}