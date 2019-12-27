package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.ThongTinCaNhan;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.ProfilePresenter;
import com.app.goldenhealth.ui.fragment.ProfileView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ProfilePresenterImpl extends BasePresenterImpl<ProfileView> implements ProfilePresenter {

    private static final String TAG = "Profile";

    public ProfilePresenterImpl(ProfileView view) {
        super(view);
    }

    @Override
    public void getThongTinCaNhan(){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().getTTcaNhan(token, uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ThongTinCaNhan>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<ThongTinCaNhan> thongTinCaNhanResponse) {
                        Util.getIns().hideLoadding();
                        if (thongTinCaNhanResponse.getStatus() == 1){
                            getView().onGetInfo(thongTinCaNhanResponse.getData());
                        }
                    }

                });
    }
}