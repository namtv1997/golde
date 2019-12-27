package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.ChuDePhanAnh;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.ThongTinCaNhan;
import com.app.goldenhealth.model.ThongTinTomTat;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.PersonalInfoPresenter;
import com.app.goldenhealth.ui.fragment.PersonalInfoView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class PersonalInfoPresenterImpl extends BasePresenterImpl<PersonalInfoView> implements PersonalInfoPresenter {
    private static final String TAG = "PersonalInfo" ;

    public PersonalInfoPresenterImpl(PersonalInfoView view) {
        super(view);
    }

    @Override
    public void getQRCode(){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTCN =PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().getQRCode(token, maYTCN)
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
                            getView().onGetQRCode(stringResponse.getData());
                        }
                    }
                });
    }


}
