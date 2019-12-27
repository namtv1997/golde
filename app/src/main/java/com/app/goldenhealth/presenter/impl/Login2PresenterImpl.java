package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.ErrorPojoClass;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.model.User;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.Login2Presenter;
import com.app.goldenhealth.ui.fragment.Login2View;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Callback;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.io.IOException;

public class Login2PresenterImpl extends BasePresenterImpl<Login2View> implements Login2Presenter {



    public Login2PresenterImpl(Login2View view) {
        super(view);
    }

    @Override
    public void login2(String username, String password){
        String token = FirebaseInstanceId.getInstance().getToken();
        if (token == null || token.isEmpty()) {
            token = "null123456";
        }

        Util.getIns().showLoadding(getView().gContext());
        NetworkModule.getService().login2(username, password, token,"password")
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {
                        Util.getIns().hideLoadding();
                        if(response.isSuccessful()) {
                            Gson gson = new Gson();
                            Token token = gson.fromJson(response.body(), Token.class);
                            PrefUtil.saveToken(token, getView().gContext());
                            getUserDetail(token);
                        }else {
                            int statusCode  = response.code();
                            // handle request errors depending on status code
                            if (response.code() == 400) {
                                Gson gson = new GsonBuilder().create();
                                ErrorPojoClass mError=new ErrorPojoClass();
                                try {
                                    mError= gson.fromJson(response.errorBody().string(),ErrorPojoClass .class);
                                    getView().onFailure(mError.getErrorDescription());
                                } catch (IOException e) {
                                    // handle failure to read error
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Util.getIns().hideLoadding();
                    }
                });
    }

    @Override
    public void loginMXH(String username, String password, int type) {
        String token = FirebaseInstanceId.getInstance().getToken();
        if (token == null || token.isEmpty()) {
            token = "null123456";
        }

        Util.getIns().showLoadding(getView().gContext());
        NetworkModule.getService().loginFaceBook(username, password, token,"password",1)
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {
                        Util.getIns().hideLoadding();
                        if(response.isSuccessful()) {
                            Gson gson = new Gson();
                            Token token = gson.fromJson(response.body(), Token.class);
                            PrefUtil.saveToken(token, getView().gContext());
                            getUserDetail(token);
                        }else {
                            int statusCode  = response.code();
                            // handle request errors depending on status code
                            if (response.code() == 400) {
                                Gson gson = new GsonBuilder().create();
                                ErrorPojoClass mError=new ErrorPojoClass();
                                try {
                                    mError= gson.fromJson(response.errorBody().string(),ErrorPojoClass .class);
                                    getView().onFailure(mError.getErrorDescription());
                                } catch (IOException e) {
                                    // handle failure to read error
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Util.getIns().hideLoadding();
                    }
                });

    }

    @Override
    public void registerMXH( String FullName,String phone,String emailID,int roleId,String avatar,String ID_Facebook,String ID_Google,String ID_Zalo) {

        String token = FirebaseInstanceId.getInstance().getToken();
        if (token == null || token.isEmpty()) {
            token = "null123456";
        }
        Util.getIns().showLoadding(getView().gContext());
        NetworkModule.getService().registerMXH(token,FullName,phone,emailID,roleId,avatar,ID_Facebook,ID_Google,ID_Zalo)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                        Log.d("KK", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<String> stringResponse) {
                        Util.getIns().hideLoadding();
                        Log.d("KK", "onNext: " + stringResponse.toString());
                        if (stringResponse.getStatus() == 1){
                            getView().onLoginSuccess();
                        }else {
                            getView().onFailure(stringResponse.getMessage());
                        }

                    }

                });
    }

    private void getUserDetail(Token token){
        Util.getIns().showLoadding(getView().gContext());
        NetworkModule.getService().getUser("Bearer " + token.getAccessToken(), token.getUid())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<User>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();

                    }

                    @Override
                    public void onNext(Response<User> userResponse) {
                        Util.getIns().hideLoadding();
                        PrefUtil.saveDataUser(userResponse.getData(), getView().gContext());

                        getView().onLoginSuccess();
                    }
                });
    }
}