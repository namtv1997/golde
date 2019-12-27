package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import android.widget.TextView;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.*;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.ThemHoSoCaNhanPresenter;
import com.app.goldenhealth.ui.fragment.ThemHoSoCaNhanView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class ThemHoSoCaNhanPresenterImpl extends BasePresenterImpl<ThemHoSoCaNhanView> implements ThemHoSoCaNhanPresenter {

    private static final String TAG = "ThemHoSoCaNhan" ;

    public ThemHoSoCaNhanPresenterImpl(ThemHoSoCaNhanView view) {
        super(view);
    }

    @Override
    public void getDanhMuc(DanhMucType danhMucType, TextView btnText, int viewID){
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
                            getView().onGetListDanhMuc(arrayListResponse.getData(), danhMucType, btnText, viewID);
                        }
                    }
                });


    }

    @Override
    public void getDanhSachTinh(boolean ht, int id){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getTinhThanhPho(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<Tinh>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<Tinh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListTinh(arrayListResponse.getData(), ht, id);
                        }
                    }
                });
    }

    @Override
    public void getDanhSachHuyen(String maTinh, boolean ht){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getQuanHuyensByMaTinh(token, maTinh)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<Huyen>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<Huyen>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListHuyen(arrayListResponse.getData(), ht);
                        }
                    }
                });
    }

    @Override
    public void getDanhSachXa(String maHuyen, boolean ht){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getXaPhuongsByMaHuyen(token, maHuyen)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<Xa>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<Xa>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListXa(arrayListResponse.getData(), ht);
                        }
                    }
                });
    }

    @Override
    public void getDanhSachThon(String maXa, boolean ht){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getThonXomsByMaXa(token, maXa)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<Thon>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<Thon>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListThon(arrayListResponse.getData(), ht);
                        }
                    }
                });
    }
}