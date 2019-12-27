package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.KhaoSatCauHoi;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.ThongBao;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.NotificationPhanAnhPresenter;
import com.app.goldenhealth.ui.fragment.NotificationPhanAnhView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class NotificationPhanAnhPresenterImpl extends BasePresenterImpl<NotificationPhanAnhView> implements NotificationPhanAnhPresenter {

    private static final String TAG = "ThongBao";
    private int pageSize = 20;
    private int pageNum = 1;
    private boolean isLoadmore = true;
    private ArrayList<ThongBao> arrayList = new ArrayList<>();

    public NotificationPhanAnhPresenterImpl(NotificationPhanAnhView view) {
        super(view);
    }

    @Override
    public void getThongBao(int group, boolean isRefresh){
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
        NetworkModule.getService().getThongBaosByGroupPage(token,uid, group, pageNum, pageSize)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<ThongBao>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<ThongBao>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            arrayList.addAll(arrayListResponse.getData());
                            getView().onGetListThongBao();
                            pageNum++;
                            if (arrayListResponse.getData().size() < pageSize){
                                isLoadmore = false;
                            }
                        }
                    }

                });
    }

    @Override
    public void updateThongBao(int id){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().updateThongBao(token, id, 1)
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
                        Log.d(TAG, "onNext: " + booleanResponse.getStatus());
                        if (booleanResponse.getStatus() == 1){
                            getView().onUpdateNotify();
                        }
                    }

                });
    }

    @Override
    public ArrayList<ThongBao> getListThongBao() {
        return arrayList;
    }
}