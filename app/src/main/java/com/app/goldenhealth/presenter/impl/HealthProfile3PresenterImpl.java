package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.HoXi;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.TinhTrangLucSinh;
import com.app.goldenhealth.model.YeuToNguyCo;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.HealthProfile3Presenter;
import com.app.goldenhealth.ui.fragment.HealthProfile3View;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class HealthProfile3PresenterImpl extends BasePresenterImpl<HealthProfile3View> implements HealthProfile3Presenter {

    private static final String TAG = "YeuToNguyCo" ;

    public HealthProfile3PresenterImpl(HealthProfile3View view) {
        super(view);
    }

    @Override
    public void getYeuToNguyCo(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().getYeuToNguyCo(token, maYTe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<YeuToNguyCo>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<YeuToNguyCo> yeuToNguyCoResponse) {
                        Util.getIns().hideLoadding();
                        if (yeuToNguyCoResponse.getStatus() == 1){
                            getView().onGetInfo(yeuToNguyCoResponse.getData());
                        }
                    }

                });
    }

    @Override
    public void getHoXi(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getHoXi(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<HoXi>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<ArrayList<HoXi>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListHoXi(arrayListResponse.getData());
                        }
                    }

                });
    }

    @Override
    public void update(int hutThuoc, int hutLienTuc, int daBoThuoc, int uongRuouBia,
                       double donViRuou, int daBoRuou, int suDungMaTuy, int dungMaTuyLienTuc,
                       int daBoMaTuy, int hoatDongTheLuc, int thuongXuyenTapTheDuc,
                       String moiTruong, double thoiGianTiepXuc, int loaiHoXi, String nguyCoNN,
                       String nguyCoKhac){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().updateYeuToNguyCo(token, maYTe, hutThuoc, hutLienTuc, daBoThuoc,
                uongRuouBia, donViRuou, daBoRuou, suDungMaTuy, dungMaTuyLienTuc, daBoMaTuy, hoatDongTheLuc,
                thuongXuyenTapTheDuc, moiTruong, thoiGianTiepXuc, loaiHoXi, nguyCoNN, nguyCoKhac )
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