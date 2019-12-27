package com.app.goldenhealth.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseActivity;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.model.User;
import com.app.goldenhealth.presenter.LoginOrRegisterPresenter;
import com.app.goldenhealth.presenter.impl.LoginOrRegisterPresenterImpl;
import com.app.goldenhealth.ui.fragment.ChonLoaiTaiKhoanDangKyFragment;
import com.app.goldenhealth.util.PrefUtil;

public class LoginOrRegisterActivity extends BaseActivity<LoginOrRegisterPresenter> implements LoginOrRegisterView {

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, LoginOrRegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_login_or_register;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
    }

    @Override
    public LoginOrRegisterPresenter createPresenter() {
        return new LoginOrRegisterPresenterImpl(this);
    }

    @OnClick({R.id.btn_login, R.id.btn_register, R.id.btn_phan_anh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                startActivity(new Intent(this, LoginActivity.class));

                break;
            case R.id.btn_register:
//                startActivity(new Intent(this, RegisterActivity.class));
                ChonLoaiTaiKhoanDangKyFragment chonLoaiTaiKhoanDangKyFragment = new ChonLoaiTaiKhoanDangKyFragment();
                getSupportFragmentManager().beginTransaction().replace(android.R.id.content, chonLoaiTaiKhoanDangKyFragment)
                        .addToBackStack(null).commit();
                break;

            case R.id.btn_phan_anh:
                getPresenter().getToken();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetToken(Token token) {
        User user = new User();
        user.setUID(token.getUid());
        user.setRoleId(Key.UNDEFINED);
        PrefUtil.saveDataUser(user, this);
        startActivity(MainActivity.getCallingIntent(this));
    }
}