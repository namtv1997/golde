package com.app.goldenhealth.presenter.impl;

import android.accounts.Account;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.ErrorPojoClass;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.model.User;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.LoginPresenter;
import com.app.goldenhealth.ui.activity.LoginView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import com.esafirm.imagepicker.features.common.BasePresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginPresenterImpl extends BasePresenterImpl<LoginView> implements LoginPresenter {
    private static final String TAG = "Login" ;
    private FirebaseAuth mAuth;

    public LoginPresenterImpl(LoginView view) {
        super(view);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void login(String username, String password) {
        Util.getIns().showLoadding(getView().gContext());
        String token = FirebaseInstanceId.getInstance().getToken();
        if (token == null || token.isEmpty()) {
            token = "null123456";
        }
        NetworkModule.getService().login(username, password, token,"password")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Token>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        getView().onFailure(getView().gContext().getString(R.string.username_or_password_incorrect));
                        Log.d(TAG, "onError: " + e.getMessage());
                        Log.d(TAG, "onError: " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(Token token) {
                        PrefUtil.saveToken(token, getView().gContext());
                        Log.d(TAG, "onNext: " + token);
                        getUserDetail(token);
                    }

                });
    }

    @Override
    public void login2(String username, String password){
        String token = FirebaseInstanceId.getInstance().getToken();
        if (token == null || token.isEmpty()) {
            token = "null123456";
        }

        NetworkModule.getService().login2(username, password, token,"password")
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {
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
                                    Log.d(TAG, "onResponse: " + mError.getErrorDescription());
                                } catch (IOException e) {
                                    // handle failure to read error
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {

                    }
                });
    }

    private void getUserDetail(Token token){
        NetworkModule.getService().getUser("Bearer " + token.getAccessToken(), token.getUid())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<User>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<User> userResponse) {
                        Util.getIns().hideLoadding();
                        PrefUtil.saveDataUser(userResponse.getData(), getView().gContext());
                        Log.d(TAG, "onNext: " + userResponse.toString());
                        getView().onLoginSuccess();
                    }
                });
    }
}
