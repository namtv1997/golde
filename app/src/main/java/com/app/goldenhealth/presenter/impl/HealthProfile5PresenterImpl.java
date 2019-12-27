package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.KhuyetTat;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.TienSuBenhTat;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.HealthProfile5Presenter;
import com.app.goldenhealth.ui.fragment.HealthProfile5View;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HealthProfile5PresenterImpl extends BasePresenterImpl<HealthProfile5View> implements HealthProfile5Presenter {

    private static final String TAG = "KhuyetTat" ;

    public HealthProfile5PresenterImpl(HealthProfile5View view) {
        super(view);
    }

    @Override
    public void getKhuyetTat(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().getKhuyetTat(token, maYTe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<KhuyetTat>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<KhuyetTat> khuyetTatResponse) {
                        Util.getIns().hideLoadding();
                        if (khuyetTatResponse.getStatus() == 1){
                            getView().onGetInfo(khuyetTatResponse.getData());
                        }
                    }

                });
    }

    @Override
    public void update(int thinhLuc, String mtThinhLuc, int thiLuc, String mtThiLuc, int tay,String mtTay
                       , int chan, String mtChan, int congVeoCS, String mtCongVeo, int hoMoi, String mtHoMoi, String khac){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().updateKhuyetTat(token, maYTe, thinhLuc, mtThinhLuc, thiLuc, mtThiLuc, tay, mtTay, chan,
                mtChan, congVeoCS, mtCongVeo, hoMoi, mtHoMoi, khac)
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
                            getView().onUpdateSuccess();
                        }else {
                            getView().onFail(booleanResponse.getMessage());
                        }
                    }

                });
    }
}