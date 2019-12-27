package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.*;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.ThemTienSuBenhPresenter;
import com.app.goldenhealth.ui.fragment.ThemTienSuBenhView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class ThemTienSuBenhPresenterImpl extends BasePresenterImpl<ThemTienSuBenhView> implements ThemTienSuBenhPresenter {

    private static final String TAG = "ThemTienSuBenh" ;

    public ThemTienSuBenhPresenterImpl(ThemTienSuBenhView view) {
        super(view);
        getDanhSachLoaiBenh();
        getDanhSachQuanHe();
    }

    private void getDanhSachLoaiBenh(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getDanhSachLoaiBenh(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<LoaiBenh>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG , "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<ArrayList<LoaiBenh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetDanhSachBenh(arrayListResponse.getData());
                        }
                    }

                });
    }

    private void getDanhSachQuanHe(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getQuanHeGiaDinh(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<QuanHeGiaDinh>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG , "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<ArrayList<QuanHeGiaDinh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetQuanHeGiaDinh(arrayListResponse.getData());
                        }
                    }

                });
    }

    @Override
    public void create(int loaiBenh, int loaiQuanHe, String moTa){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().themTienSuBenh(token, maYTe, loaiBenh, loaiQuanHe, moTa)
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
                            getView().onCreateSuccess();
                        }else {
                            getView().onFail(booleanResponse.getMessage());
                        }
                    }

                });
    }

    @Override
    public void update(int id, int loaiBenh, int loaiQuanHe, String moTa){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().updateTienSuBenh(token, id, maYTe, loaiBenh, loaiQuanHe, moTa)
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
                            getView().onCreateSuccess();
                        }else {
                            getView().onFail(booleanResponse.getMessage());
                        }
                    }

                });
    }

    @Override
    public void getTienSuBenh(int id){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().getTienSuBenhGiaDinhById(token, maYTe, id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<TienSuBenh>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<TienSuBenh> tienSuBenhResponse) {
                        Util.getIns().hideLoadding();
                        if (tienSuBenhResponse.getStatus() == 1){
                            getView().onGetTienSuBenh(tienSuBenhResponse.getData());
                        }
                    }

                });
    }
}