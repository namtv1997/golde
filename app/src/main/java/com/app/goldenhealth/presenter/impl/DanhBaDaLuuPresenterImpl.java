package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.DanhBa;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.ThongBao;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.DanhBaDaLuuPresenter;
import com.app.goldenhealth.ui.fragment.DanhBaDaLuuView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class DanhBaDaLuuPresenterImpl extends BasePresenterImpl<DanhBaDaLuuView> implements DanhBaDaLuuPresenter {
    private static final String TAG = "ThongBao";
    private int pageSize = 20;
    private int pageNum = 1;
    private boolean isLoadmore = true;
    private ArrayList<DanhBa> arrayList = new ArrayList<>();

    public DanhBaDaLuuPresenterImpl(DanhBaDaLuuView view) {
        super(view);
    }

    @Override
    public void getDanhBa(boolean isRefresh){
        if (isRefresh){
            pageNum = 1;
            arrayList.clear();
            isLoadmore = true;
            Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore){
            return;
        }
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getDanhBasPage(token,uid, pageNum, pageSize)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhBa>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<DanhBa>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            arrayList.addAll(arrayListResponse.getData());
                            getView().onGetListDanhBa();
                            pageNum++;
                            if (arrayListResponse.getData().size() < pageSize){
                                isLoadmore = false;
                            }
                        }else {
                            getView().onGetDataFail();
                        }
                    }

                });
    }

    @Override
    public void getDanhBaByKey(String key, boolean isRefresh){
        if (isRefresh){
            pageNum = 1;
            arrayList.clear();
            isLoadmore = true;
        }
        if (!isLoadmore){
            return;
        }
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getDanhBasPageByKey(token,uid, key, pageNum, pageSize)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhBa>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<DanhBa>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            arrayList.addAll(arrayListResponse.getData());
                            getView().onGetListDanhBa();
                            pageNum++;
                            if (arrayListResponse.getData().size() < pageSize){
                                isLoadmore = false;
                            }
                        }else {
                            getView().onGetDataFail();
                        }
                    }

                });
    }

    @Override
    public ArrayList<DanhBa> getListDanhBa() {
        return arrayList;
    }
}