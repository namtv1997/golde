package com.app.goldenhealth.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import butterknife.ButterKnife;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseActivity;
import com.app.goldenhealth.presenter.SplashPresenter;
import com.app.goldenhealth.presenter.impl.SplashPresenterImpl;
import com.app.goldenhealth.util.NetUtil;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashView {
    @Override
    public int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);

        if(!NetUtil.isNetworkAvailable(this)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Thông báo!")
                    .setMessage("Vui lòng kiểm tra lại kết nối mạng của bạn và khởi động lại app!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .create().show();

            return;
        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(PrefUtil.getDataUser(SplashActivity.this) != null){
                    login();
                }else {
                    showLogin();
                }
            }
        }, 1000);
    }

    @Override
    public SplashPresenter createPresenter() {
        return new SplashPresenterImpl(this);
    }

    public void login() {
        // Xử lý khi mở app từ notification
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null){
            Log.d("Splash", "initializeComponents: id " + intent.getExtras().get("id"));
            Log.d("Splash", "initializeComponents: type " + intent.getExtras().get("type"));

            if (intent.getExtras().get("id") != null && intent.getExtras().get("type") != null ){
                int type =  Integer.parseInt((String) intent.getExtras().get("type"));
                int id =  Integer.parseInt((String) intent.getExtras().get("id"));
                switch (type){
                    case 1:
                        Intent intent1 = new Intent(this, PhanAnhChiTietActivity.class);
                        intent1.putExtra(Key.PHAN_ANH_ID, id);
                        startActivity(intent);
                        finish();
                    default:
                        getPresenter().getUserDetail();
                }
            }else {
                getPresenter().getUserDetail();
            }
        }else {
            getPresenter().getUserDetail();
        }
        this.finish();
    }

    public void showLogin() {
        startActivity(LoginOrRegisterActivity.getCallingIntent(SplashActivity.this));
        SplashActivity.this.finish();
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetDataSuccess() {
        startActivity(MainActivity.getCallingIntent(this));
        finish();
    }

    @Override
    public void onGetDataFail() {
        showLogin();
    }
}
