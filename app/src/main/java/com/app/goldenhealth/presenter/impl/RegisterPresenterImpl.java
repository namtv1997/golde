package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import android.widget.TextView;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.DanhMuc;
import com.app.goldenhealth.model.DanhMucType;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.RegisterPresenter;
import com.app.goldenhealth.ui.activity.RegisterView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import com.google.firebase.iid.FirebaseInstanceId;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class RegisterPresenterImpl extends BasePresenterImpl<RegisterView> implements RegisterPresenter {
    private static final String TAG = "Register";

    public RegisterPresenterImpl(RegisterView view) {
        super(view);
        getToken();
    }

    public void getToken() {
        String token = FirebaseInstanceId.getInstance().getToken();
        if (token == null || token.isEmpty()) {
            token = "null123456";
        }
        NetworkModule.getService().login(Key.registerUsername, Key.registerPassword, token, "password")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Token token) {
                        Log.d(TAG, "onNext: " + token);
                        PrefUtil.saveToken(token, getView().gContext());
                        getView().onGetToken(token);
                    }

                });
    }

    @Override
    public void checkExistUsername(Token token, String username){
        NetworkModule.getService().checkExistUsername("Bearer " + token.getAccessToken(), username)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: username :" + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        getView().onUserNameIsExist(booleanResponse.getData());
                    }

                });
    }

    @Override
    public void checkExistPhone(Token token, String phone){
        NetworkModule.getService().checkExistPhone("Bearer " + token.getAccessToken(), phone)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: phone: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        getView().onPhoneIsExist(booleanResponse.getData());
                    }

                });
    }

    @Override
    public void checkExistEmail(Token token, String email){
        NetworkModule.getService().checkExistEmail("Bearer " + token.getAccessToken(), email)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        getView().onEmailIsExist(booleanResponse.getData());
                    }

                });
    }

    @Override
    public void register(Token token, String name, String birthday, String phone, String email, String username, String password,
                         int roleId, String maBS, int benhVienID, String diaChi){
        Util.getIns().showLoadding(getView().gContext());
        NetworkModule.getService().register("Bearer " + token.getAccessToken(), 0, 0, email, username, password,
                                               roleId, 0, name, 0, phone, "", birthday, maBS, benhVienID,
                                                diaChi)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<String>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Util.showMessenger("Có lỗi xảy ra, vui lòng thử lại!", getView().gContext());
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<String> stringResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + stringResponse.toString());
                        if (stringResponse.getStatus() == 1){
                            getView().registerSuccess(stringResponse.getData());
                        }else {
                            getView().onFailure(stringResponse.getMessage());
                        }

                    }

                });
    }

    @Override
    public void getDanhMuc(String token, DanhMucType danhMucType){
        Util.getIns().showLoadding(getView().gContext());
        NetworkModule.getService().getListDanhMuc(danhMucType.getApiListPath(), "Bearer " + token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhMuc>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<DanhMuc>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListDanhMuc(arrayListResponse.getData());
                        }
                    }
                });
    }

}
