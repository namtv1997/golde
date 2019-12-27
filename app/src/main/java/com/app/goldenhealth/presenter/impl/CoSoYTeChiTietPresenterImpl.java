package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.CoSoYTeChiTietPresenter;
import com.app.goldenhealth.ui.fragment.CoSoYTeChiTietView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CoSoYTeChiTietPresenterImpl extends BasePresenterImpl<CoSoYTeChiTietView> implements CoSoYTeChiTietPresenter {

    private static final String TAG = "CoSoYTeChiTiet";

    public CoSoYTeChiTietPresenterImpl(CoSoYTeChiTietView view) {
        super(view);
    }

    @Override
    public void getBenhVienInfo(int id){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getBenhVienById(token, id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<BenhVien>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<BenhVien> benhVienResponse) {
                        Util.getIns().hideLoadding();
                        if (benhVienResponse.getStatus() == 1){
                            getView().onGetBenhVienInfo(benhVienResponse.getData());
                        }
                    }

                });
    }
}