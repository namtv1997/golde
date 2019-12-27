package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.ChuDePhanAnh;
import com.app.goldenhealth.model.DanhBa;
import com.app.goldenhealth.model.PhanAnh;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.PhanAnhPresenter;
import com.app.goldenhealth.ui.fragment.PhanAnhView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class PhanAnhPresenterImpl extends BasePresenterImpl<PhanAnhView> implements PhanAnhPresenter {

    private static final String TAG = "PhanAnh" ;
    private int pageSize = 20;
    private int pageNum = 1;
    private boolean isLoadmore = true;
    private ArrayList<PhanAnh> arrayList = new ArrayList<>();

    public PhanAnhPresenterImpl(PhanAnhView view) {
        super(view);
    }

    @Override
    public void getChuDePhanAnh(){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getChuDePhanAnh(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<ChuDePhanAnh>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<ChuDePhanAnh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetChuDePhanAnh(arrayListResponse.getData());
                        }
                    }
                });
    }

    @Override
    public void getPhanAnh(String key, int mucCongKhai, Integer mucPAId, Integer noiPAId, Integer orderBy,
                           boolean isRefresh){
        if (isRefresh){
            pageNum = 1;
            isLoadmore = true;
            Util.getIns().showLoadding(getView().gContext());
        }
        if (!isLoadmore){
            return;
        }
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getToken(getView().gContext()).getUid();
        NetworkModule.getService().getListPhanAnh(token,uid, key, mucCongKhai, mucPAId, noiPAId, orderBy, pageNum, pageSize)
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
                        getView().onGetDataFail();
                    }

                    @Override
                    public void onNext(Response<ArrayList<PhanAnh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            if (isRefresh){
                                arrayList.clear();
                            }
                            arrayList.addAll(arrayListResponse.getData());
                            getView().onGetListPhanAnh();
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
    public ArrayList<PhanAnh> getListPhanAnh() {
        return arrayList;
    }
}