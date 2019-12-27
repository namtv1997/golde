package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.KhuyetTat;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.TienSuPhauThuat;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.HealthProfile6Presenter;
import com.app.goldenhealth.ui.fragment.HealthProfile6View;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class HealthProfile6PresenterImpl extends BasePresenterImpl<HealthProfile6View> implements HealthProfile6Presenter {

    private static final String TAG = "TienSuPhauThuat";

    public HealthProfile6PresenterImpl(HealthProfile6View view) {
        super(view);
    }

    @Override
    public void getTienSuPhauThuat(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().getTienSuPhauThuats(token, maYTe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<TienSuPhauThuat>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<ArrayList<TienSuPhauThuat>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetInfo(arrayListResponse.getData());
                        }
                    }

                });
    }
}