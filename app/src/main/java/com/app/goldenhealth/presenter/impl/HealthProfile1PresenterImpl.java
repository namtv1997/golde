package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.ThongTinTomTat;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.HealthProfile1Presenter;
import com.app.goldenhealth.ui.fragment.HealthProfile1View;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HealthProfile1PresenterImpl extends BasePresenterImpl<HealthProfile1View> implements HealthProfile1Presenter {

    private static final String TAG = "TomTat" ;

    public HealthProfile1PresenterImpl(HealthProfile1View view) {
        super(view);
    }

    @Override
    public void getThongTinTomTat(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().getThongTinTomTat(token, maYTe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ThongTinTomTat>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<ThongTinTomTat> thongTinTomTatResponse) {
                        Util.getIns().hideLoadding();
                       if (thongTinTomTatResponse.getStatus() == 1){
                           getView().onGetInfo(thongTinTomTatResponse.getData());
                       }
                    }

                });
    }

    @Override
    public void update(String nhomMau, double canNang, double chieuCao){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().updateThongTinCoBan(token, maYTe, nhomMau, chieuCao, canNang )
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