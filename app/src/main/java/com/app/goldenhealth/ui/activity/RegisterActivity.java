package com.app.goldenhealth.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseActivity;
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.model.DanhMuc;
import com.app.goldenhealth.model.DanhMucType;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.presenter.RegisterPresenter;
import com.app.goldenhealth.presenter.impl.RegisterPresenterImpl;
import com.app.goldenhealth.ui.fragment.ListFragment;
import com.app.goldenhealth.ui.fragment.LuaChonPhuongThucXacThucFragment;
import com.app.goldenhealth.ui.fragment.ValidateVerifyCodeFragment;
import com.app.goldenhealth.util.Toolbox;
import com.app.goldenhealth.util.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class RegisterActivity extends BaseActivity<RegisterPresenter> implements RegisterView {

    private static final int REQUEST_CODE_PDF = 1236;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_dia_chi)
    EditText edtDiaChi;
    @BindView(R.id.edt_birthday)
    EditText edtBirthday;
    @BindView(R.id.edt_phone)
    EditText edtPhone;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.btn_csyt_lam_viec)
    EditText btnCsytLamViec;
    @BindView(R.id.edt_ma_bac_si)
    EditText edtMaBacSi;
    @BindView(R.id.edt_username)
    EditText edtUsername;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.edt_password_again)
    EditText edtPasswordAgain;
    @BindView(R.id.cb_agree_policy)
    CheckBox cbAgreePolicy;
    @BindView(R.id.btn_register)
    TextView btnRegister;
    @BindView(R.id.btn_login)
    TextView btnLogin;

    private Token token;
    private int roleId;
    private int benhVienID = 0;

    @Override
    public int getContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        roleId = getIntent().getIntExtra(Key.ROLE_ID, Key.USER);
        switch (roleId){
            case Key.USER:
                edtName.setHint(getString(R.string.name));
                edtDiaChi.setVisibility(View.GONE);
                btnCsytLamViec.setVisibility(View.GONE);
                edtMaBacSi.setVisibility(View.GONE);
                break;

            case Key.DOCTOR:
                edtName.setHint(getString(R.string.name));
                edtDiaChi.setVisibility(View.GONE);
                break;
            case Key.FACILITY:
                edtName.setHint(getString(R.string.ten_csyt));
                btnCsytLamViec.setVisibility(View.GONE);
                edtMaBacSi.setVisibility(View.GONE);
                edtBirthday.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public RegisterPresenter createPresenter() {
        return new RegisterPresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.edt_birthday, R.id.btn_csyt_lam_viec, R.id.btn_register, R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.edt_birthday:
                Toolbox.selectDate(this, null, new Date(), edtBirthday);
                break;
            case R.id.btn_csyt_lam_viec:
//                getPresenter().getDanhMuc(token.getAccessToken(), DanhMucType.BenhVien);
                ListFragment listFragment = new ListFragment();
                Bundle bundle = new Bundle();
                bundle.putString(Key.TOKEN, token.getAccessToken());
                listFragment.setArguments(bundle);
                listFragment.setOnItemSelectedistener(new ListFragment.OnItemSelectedistener() {
                    @Override
                    public void onSelected(BenhVien benhVien) {
                        btnCsytLamViec.setText(benhVien.getTEN());
                        benhVienID = benhVien.getID();
                    }
                });
                getSupportFragmentManager().beginTransaction().replace(android.R.id.content, listFragment)
                        .addToBackStack(null).commit();
                break;
            case R.id.btn_register:
                register();
                break;
            case R.id.btn_login:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }

    private void register() {
        if (cbAgreePolicy.isChecked()) {
            String name = edtName.getText().toString();
            String birthday = edtBirthday.getText().toString();
            String phone = edtPhone.getText().toString();
            String email = edtEmail.getText().toString();
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();
            String passwordAgain = edtPasswordAgain.getText().toString();

            if (name.isEmpty()) {
                edtName.setError(getString(R.string.enter_name));
            } else if (username.isEmpty()) {
                edtUsername.setError(getString(R.string.enter_username));
            } else if (phone.isEmpty()) {
                edtPhone.setError(getString(R.string.enter_phone));
            } else if (password.isEmpty()) {
                edtPassword.setError(getString(R.string.enter_password));
            } else if (passwordAgain.isEmpty()) {
                edtPasswordAgain.setError(getString(R.string.enter_password_again_));
            } else if (!password.equals(passwordAgain)) {
                Util.showMessenger(getString(R.string.password_not_match), this);
            } else if (token != null) {
                getPresenter().checkExistUsername(token, username);
            }

        } else {
            Util.showMessenger("Vui lòng đọc và đồng ý các điều khoản sử dụng trước khi đăng ký!", this);
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onFailure(String s) {
        Util.showMessenger(s, this);
    }

    @Override
    public void onUserNameIsExist(Boolean data) {
        if (data) {
            Util.showMessenger(getString(R.string.username_is_exist), this);
        } else {
            getPresenter().checkExistPhone(token, edtPhone.getText().toString());
        }
    }

    @Override
    public void onPhoneIsExist(Boolean data) {
        if (data) {
            Util.showMessenger(getString(R.string.phone_is_exist), this);
        } else {
            if (!edtEmail.getText().toString().isEmpty()) {
                getPresenter().checkExistEmail(token, edtEmail.getText().toString());
            } else {
                String name = edtName.getText().toString();
                String birthday = edtBirthday.getText().toString();
                String phone = edtPhone.getText().toString();
                String email = edtEmail.getText().toString();
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                String passwordAgain = edtPasswordAgain.getText().toString();
                String maBS = edtMaBacSi.getText().toString();
                String diaChi = edtDiaChi.getText().toString();
                getPresenter().register(token, name, birthday, phone, email, username, password, roleId, maBS, benhVienID, diaChi);
            }
        }
    }

    @Override
    public void onEmailIsExist(Boolean data) {
        if (data) {
            Util.showMessenger(getString(R.string.email_is_exist), this);
        } else {
            String name = edtName.getText().toString();
            String birthday = edtBirthday.getText().toString();
            String phone = edtPhone.getText().toString();
            String email = edtEmail.getText().toString();
            String username = edtUsername.getText().toString();
            String password = edtPassword.getText().toString();
            String passwordAgain = edtPasswordAgain.getText().toString();
            String maBS = edtMaBacSi.getText().toString();
            String diaChi = edtDiaChi.getText().toString();
            getPresenter().register(token, name, birthday, phone, email, username, password, roleId, maBS, benhVienID, diaChi);
        }
    }

    @Override
    public void onGetToken(Token token) {
        this.token = token;
    }

    @Override
    public void registerSuccess(String data) {
        ValidateVerifyCodeFragment validateVerifyCodeFragment = new ValidateVerifyCodeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Key.UID, data);
        bundle.putString(Key.TOKEN, token.getAccessToken());
        bundle.putString(Key.TITLE, getString(R.string.register));
        validateVerifyCodeFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, validateVerifyCodeFragment)
                .commit();

//        LuaChonPhuongThucXacThucFragment luaChonPhuongThucXacThucFragment = new LuaChonPhuongThucXacThucFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(Key.UID, data);
//        bundle.putString(Key.TOKEN, token.getAccessToken());
//        luaChonPhuongThucXacThucFragment.setArguments(bundle);
//        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, luaChonPhuongThucXacThucFragment)
//                .commit();
    }

    @Override
    public void onGetListDanhMuc(ArrayList<DanhMuc> data) {
        String[] list = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            list[i] = data.get(i).getTEN();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.chon_csyt_lam_viec)
                .setItems(list, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        btnCsytLamViec.setText(data.get(which).getTEN());
                        benhVienID = data.get(which).getID();
                    }
                }).create().show();
    }

}
