package com.app.goldenhealth.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.presenter.Login2Presenter;
import com.app.goldenhealth.presenter.impl.Login2PresenterImpl;
import com.app.goldenhealth.ui.activity.MainActivity;
import com.facebook.*;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;
import com.zing.zalo.zalosdk.oauth.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Objects;

import static com.facebook.FacebookSdk.getApplicationContext;

public class Login2Fragment extends BaseFragment<Login2Presenter>  implements Login2View {


    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.btn1_facebook)
    ImageView btn1Facebook;
    @BindView(R.id.btn_google)
    ImageView btnGoogle;
    @BindView(R.id.btn_zalo)
    ImageView btnZalo;

    @BindView(R.id.btn_register)
    TextView btnRegister;
    @BindView(R.id.btn_forget_password)
    TextView btnForgetPassword;
    @BindView(R.id.txt_error)
    TextView txtError;

    @BindView(R.id.edt_username)
    EditText edtUsername;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_facebook)
    LoginButton btnFacebook;



    @BindView(R.id.sign_in_button)
    SignInButton signInButton;

    Unbinder unbinder;
    CallbackManager callbackManager;
    private  boolean mxh=false;
    private  boolean isRegister=false;
    private  int type_mxh;
    private  String account_id;
    private String  image_url, name;
    @SuppressLint("StaticFieldLeak")
    public static GoogleSignInClient mGoogleSignInClient;

    LoginListener listener;

    class LoginListener extends OAuthCompleteListener {

        @Override
        public void onAuthenError(int errorCode, String message) {
            Log.d("ddd","onAuthenError");
        }

        @Override
        public void onGetOAuthComplete(OauthResponse response) {
            super.onGetOAuthComplete(response);
            Log.d("ddd","onGetOAuthComplete");
            getProfile();

        }
    }


    @Override
    public int getContentViewId() {
        return R.layout.fragment_login;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        btnFacebook.setFragment(this);
        btnFacebook.setReadPermissions(Arrays.asList("public_profile", "email"));
        setLogin();
        listener = new LoginListener();

        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mxh= true;
                signIn();
            }
        });


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getContext(), gso);


        try {
            PackageInfo pInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
            String version = pInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void getProfile() {
        String [] Fields = {"id", "birthday", "gender", "picture", "name"};
        ZaloSDK.Instance.getProfile(getContext(), new ZaloOpenAPICallback() {
            @Override
            public void onResult(JSONObject jSONObject) {
                try {
                    Log.d("ddd",jSONObject.getString("id"));
                    Log.d("ddd",jSONObject.getString("name"));
                    Log.d("ddd",jSONObject.getString("gender"));
                    Log.d("ddd",jSONObject.getString("birthday"));
                    JSONObject data = jSONObject.getJSONObject("picture").getJSONObject("data");
                    Log.d("ddd",data.getString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("ddd",e.toString());
                }

            }
        },Fields);
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, Key.RC_SIGN_IN);

    }

    private void setLogin() {
        btnFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), (object, response) -> {
                    Log.d("JSON", response.getJSONObject().toString());
                    try {
                        account_id = object.getString("id");
                        name = object.getString("name");
                        image_url = object.getJSONObject("picture").getJSONObject("data").getString("url");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    // getPresenter().registerMXH(name, null, null, 2, image_url, id, null, null);
                    getPresenter().loginMXH(account_id, null, 1);
                    Log.d("ddd", account_id);
                    Log.d("ddd", name);
                    Log.d("ddd", image_url);

                });
                Bundle bundle = new Bundle();
                bundle.putString("fields", "name,email,picture.type(large)");
                graphRequest.setParameters(bundle);
                graphRequest.executeAsync();

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }


    @Override
    public Login2Presenter createPresenter() {

        return new Login2PresenterImpl(this);
    }

    @OnClick({R.id.btn_register, R.id.btn_forget_password, R.id.btn_login, R.id.btn1_facebook, R.id.btn_google, R.id.btn_zalo, R.id.ivBack})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                ChonLoaiTaiKhoanDangKyFragment chonLoaiTaiKhoanDangKyFragment = new ChonLoaiTaiKhoanDangKyFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, chonLoaiTaiKhoanDangKyFragment)
                        .addToBackStack(null).commit();
                break;

            case R.id.btn_forget_password:
                ForgetPasswordFragment forgetPasswordFragment = new ForgetPasswordFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, forgetPasswordFragment)
                        .addToBackStack(null).commit();
                break;

            case R.id.btn_login:
                mxh=false;
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                getPresenter().login2(username, password);
                break;

            case R.id.btn1_facebook:
                mxh=true;
                type_mxh=1;
                btnFacebook.performClick();
                break;

            case R.id.btn_google:
                type_mxh=2;
                mxh=true;
                signIn();
                break;

            case R.id.btn_zalo:

                ZaloSDK.Instance.authenticate((Activity) getContext(), LoginVia.WEB, listener);
                break;

            case R.id.ivBack:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == Key.RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
        ZaloSDK.Instance.onActivityResult((AppCompatActivity) getContext(), requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            Uri personPhoto = account.getPhotoUrl();
            account_id=account.getId();
            name=account.getDisplayName();
            image_url=personPhoto.toString();


            getPresenter().loginMXH(account_id, "", 2);

            Log.d("ddd", account_id);
            Log.d("ddd", name);
            Log.d("ddd", image_url);

        } catch (ApiException e) {

            Log.d("ddd1", e.toString());
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onFailure(String s) {
//       Util.showMessenger(s, this);
        if(mxh){
            mxh=false;
            isRegister=true;

            if(type_mxh==1){
                getPresenter().registerMXH(name, null, null, 2, image_url, account_id, null, null);
            }else if(type_mxh==2){
                getPresenter().registerMXH(name, "", "", 2, image_url, "", account_id, "");
            }
        }
        txtError.setText(s);
        txtError.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoginSuccess() {

        if(isRegister){
            getPresenter().loginMXH(account_id, "", type_mxh);
            isRegister=false;
        }else {
            startActivity(MainActivity.getCallingIntent(getContext()));
        }

    }


}


