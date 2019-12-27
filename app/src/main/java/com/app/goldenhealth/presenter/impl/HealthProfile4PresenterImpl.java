package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.TienSuBenhTat;
import com.app.goldenhealth.model.YeuToNguyCo;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.HealthProfile4Presenter;
import com.app.goldenhealth.ui.fragment.HealthProfile4View;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HealthProfile4PresenterImpl extends BasePresenterImpl<HealthProfile4View> implements HealthProfile4Presenter {

    private static final String TAG = "TienSuBenhTat" ;

    public HealthProfile4PresenterImpl(HealthProfile4View view) {
        super(view);
    }

    @Override
    public void getTienSuBenhTat(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().getTienSuBenhTat(token, maYTe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<TienSuBenhTat>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<TienSuBenhTat> tienSuBenhTatResponse) {
                        Util.getIns().hideLoadding();
                        if (tienSuBenhTatResponse.getStatus() == 1){
                            getView().onGetInfo(tienSuBenhTatResponse.getData());
                        }
                    }


                });
    }

    @Override
    public void update(int timMach, int daiThaoDuong, int phoiManTinh, int buouCo,
                       int timBamSinh, int tuKy, int tangHuyetAp, int daDay,
                       int henXuyen, int viemGan, int tamThan, int dongKinh,
                       String ungThu, String lao, String khac, String duThuoc, String duHoaChat,
                       String duThucPham, String duKhac){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().updateTienSuBenhTat(token, maYTe, timMach, daiThaoDuong, phoiManTinh,
                buouCo, timBamSinh, tuKy, tangHuyetAp, daDay, henXuyen, viemGan,
                tamThan, dongKinh, ungThu, lao, khac, duThuoc, duHoaChat, duThucPham, duKhac )
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