package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.ThongBao;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.ListPresenter;
import com.app.goldenhealth.ui.fragment.ListView;
import com.app.goldenhealth.ui.fragment.NotificationPhanAnhView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class ListPresenterImpl extends BasePresenterImpl<ListView> implements ListPresenter {

    private static final String TAG = "List";
    private int pageSize = 20;
    private int pageNum = 1;
    private boolean isLoadmore = true;
    private ArrayList<BenhVien> arrayList = new ArrayList<>();

    public ListPresenterImpl(ListView view) {
        super(view);
    }

    @Override
    public void getBenhVien(String token, boolean isRefresh){
        if (isRefresh){
            pageNum = 1;
            arrayList.clear();
            isLoadmore = true;
            Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore){
            return;
        }
        token = "Bearer " + token;
        NetworkModule.getService().getBenhVien(token, pageNum, pageSize)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<BenhVien>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<BenhVien>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            arrayList.addAll(arrayListResponse.getData());
                            getView().onGetListBenhVien();
                            pageNum++;
                            if (arrayListResponse.getData().size() < pageSize){
                                isLoadmore = false;
                            }
                        }
                    }

                });
    }

    @Override
    public ArrayList<BenhVien> getArrayList() {
        return arrayList;
    }
}