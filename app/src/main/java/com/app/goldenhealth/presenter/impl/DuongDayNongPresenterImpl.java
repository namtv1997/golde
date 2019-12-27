package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.LienKetMangXaHoi;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.DuongDayNongPresenter;
import com.app.goldenhealth.ui.fragment.DuongDayNongView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DuongDayNongPresenterImpl extends BasePresenterImpl<DuongDayNongView> implements DuongDayNongPresenter {

    private static final String TAG = "HoiDap";

    public DuongDayNongPresenterImpl(DuongDayNongView view) {
        super(view);
        getLienKetMangXaHoi();
    }

    @Override
    public void getLienKetMangXaHoi(){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getLienKetMangXaHoi(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<LienKetMangXaHoi>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<LienKetMangXaHoi> lienKetMangXaHoiResponse) {
                        Util.getIns().hideLoadding();
                        if (lienKetMangXaHoiResponse.getStatus() == 1){
                            getView().onGetLienKetMXH(lienKetMangXaHoiResponse.getData());
                        }
                    }

                });
    }
}