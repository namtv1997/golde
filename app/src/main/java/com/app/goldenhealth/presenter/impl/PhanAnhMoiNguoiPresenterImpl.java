package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.PhanAnh;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.PhanAnhMoiNguoiPresenter;
import com.app.goldenhealth.ui.activity.PhanAnhMoiNguoiView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class PhanAnhMoiNguoiPresenterImpl extends BasePresenterImpl<PhanAnhMoiNguoiView> implements PhanAnhMoiNguoiPresenter {
    private static final String TAG ="PhanAnh" ;

    public PhanAnhMoiNguoiPresenterImpl(PhanAnhMoiNguoiView view) {
        super(view);
    }

    @Override
    public void getPhanAnhById(int id){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().getPhanAnhById(token, uid, id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<PhanAnh>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<PhanAnh> phanAnhResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + phanAnhResponse);
                        ArrayList<PhanAnh> phanAnhs = new ArrayList<>();
                        phanAnhs.add(phanAnhResponse.getData());
                        getView().onGetListPhanAnh(phanAnhs);
                    }
                });
    }

    @Override
    public void getPhanAnh(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().getPhanAnh(token, uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<PhanAnh>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<PhanAnh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + arrayListResponse);

                        getView().onGetListPhanAnh(arrayListResponse.getData());
                    }

                });
    }

    @Override
    public void getPhanAnhMoiNguoi(int id){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getPhanAnhMoiNguoi(token, id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<PhanAnh>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<PhanAnh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + arrayListResponse);

                        getView().onGetListPhanAnh(arrayListResponse.getData());
                    }

                });
    }

    @Override
    public void getPhanAnhCSYT(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        int idBenhVien = PrefUtil.getDataUser(getView().gContext()).getBenhVienID();
        NetworkModule.getService().getPhanAnhCSYT(token, idBenhVien)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<PhanAnh>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<PhanAnh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + arrayListResponse);

                        getView().onGetListPhanAnh(arrayListResponse.getData());
                    }

                });
    }

    @Override
    public void traLoiPhanAnh(int id, String noiDung){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().traLoiPhanAnh(token, id, noiDung)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + booleanResponse);
                        if (booleanResponse.getData()){
                            getView().onTraLoiSuccess();
                        }
                    }

                });
    }

    @Override
    public void addComment(int id, String noiDung){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().addComment(token,uid, id, noiDung, "", "", "", "")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Integer>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<Integer> integerResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + integerResponse);
                        if (integerResponse.getStatus() == 1){
                            getView().onTraLoiSuccess();
                        }else {

                        }
                    }

                });
    }
}
