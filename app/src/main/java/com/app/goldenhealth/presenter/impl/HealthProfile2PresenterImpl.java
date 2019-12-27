package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenter;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.ThongTinTomTat;
import com.app.goldenhealth.model.TinhTrangLucSinh;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.HealthProfile2Presenter;
import com.app.goldenhealth.ui.fragment.HealthProfile2View;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HealthProfile2PresenterImpl extends BasePresenterImpl<HealthProfile2View> implements HealthProfile2Presenter {

    private static final String TAG = "TinhTrangSinh" ;

    public HealthProfile2PresenterImpl(HealthProfile2View view) {
        super(view);
    }

    @Override
    public void getTinhTrangLucSinh(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().getTinhTrangLucSinh(token, maYTe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<TinhTrangLucSinh>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<TinhTrangLucSinh> tinhTrangLucSinhResponse) {
                        Util.getIns().hideLoadding();
                        if (tinhTrangLucSinhResponse.getStatus() == 1){
                            getView().onGetInfo(tinhTrangLucSinhResponse.getData());
                        }
                    }

                });
    }

    @Override
    public void update(int deThuong, int biNgat, int deThieuThang, double canNang,
                       double chieuDai, String diTat, String vanDeKhac){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().updateTinhTrangLucSinh(token, maYTe, deThuong, biNgat, deThieuThang,
                canNang, chieuDai, 0, diTat, vanDeKhac )
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