package com.app.goldenhealth.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;
import butterknife.ButterKnife;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseActivity;
import com.app.goldenhealth.presenter.LoginPresenter;
import com.app.goldenhealth.presenter.impl.LoginPresenterImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.d("print" ,hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.d("print", "printHashKey()", e);
        } catch (Exception e) {
            Log.d("print", "printHashKey()", e);
        }
    }

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onFailure(String s) {

    }

    @Override
    public void onLoginSuccess() {
        startActivity(MainActivity.getCallingIntent(this));
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
