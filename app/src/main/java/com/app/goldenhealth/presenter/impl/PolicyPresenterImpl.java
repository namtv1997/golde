package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.LienKetMangXaHoi;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.PolicyPresenter;
import com.app.goldenhealth.ui.fragment.PolicyView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PolicyPresenterImpl extends BasePresenterImpl<PolicyView> implements PolicyPresenter {

    private static final String TAG = "Policy" ;

    public PolicyPresenterImpl(PolicyView view) {
        super(view);
    }

    @Override
    public void getDieuKhoanSuDung(){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getDieuKhoanSuDung(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<String> stringResponse) {
                        Util.getIns().hideLoadding();
                        if (stringResponse.getStatus() == 1){
                            getView().onGetDieuKhoanSuDung(stringResponse.getData());
                        }
                    }

                });
    }

}