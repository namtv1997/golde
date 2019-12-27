package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import android.widget.TextView;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.*;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.HealthProfile9Presenter;
import com.app.goldenhealth.ui.fragment.HealthProfile9View;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class HealthProfile9PresenterImpl extends BasePresenterImpl<HealthProfile9View> implements HealthProfile9Presenter {

    private static final String TAG = "SKSS" ;

    public HealthProfile9PresenterImpl(HealthProfile9View view) {
        super(view);
    }

    @Override
    public void getSKSS(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().getSKSSAndKHHGĐ(token, maYTe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<SKSS_KHHGD>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<SKSS_KHHGD> skss_khhgdResponse) {
                        Util.getIns().hideLoadding();
                        if (skss_khhgdResponse.getStatus() == 1){
                            Log.d(TAG, "onNext: " + skss_khhgdResponse.getData().toString());
                            getView().onGetInfo(skss_khhgdResponse.getData());
                        }
                    }
                });
    }

    @Override
    public void getDanhMuc(DanhMucType danhMucType){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getListDanhMuc(danhMucType.getApiListPath(), token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhMuc>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<DanhMuc>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListDanhMuc(arrayListResponse.getData());
                        }
                    }
                });


    }

    @Override
    public void update(ArrayList<Integer> bptts, String kyThaiCuoi, int soLanCoThai, int soLanSayThai, int soLanPhaThai, int soLanDeDu,
                       int soLanDeNon, int soLanDe, int deThuong, int deMo, int deKho, int soConSong, String benhPhuKhoa){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().updateSKSSAndKHHGĐ(token, maYTe, bptts, kyThaiCuoi, soLanCoThai, soLanSayThai, soLanPhaThai,
                soLanDeDu, soLanDeNon, soLanDe, deThuong, deMo, deKho, soConSong, benhPhuKhoa )
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