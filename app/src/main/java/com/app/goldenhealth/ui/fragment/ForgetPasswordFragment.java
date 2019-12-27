package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.presenter.ForgetPasswordPresenter;
import com.app.goldenhealth.presenter.impl.ForgetPasswordPresenterImpl;
import com.app.goldenhealth.util.Util;

public class ForgetPasswordFragment extends BaseFragment<ForgetPasswordPresenter> implements ForgetPasswordView {
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.txt_error)
    TextView txtError;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.btn_send_request)
    TextView btnSendRequest;
    Unbinder unbinder;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    private Token token;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_forget_password;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public ForgetPasswordPresenter createPresenter() {
        return new ForgetPasswordPresenterImpl(this);
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public final static boolean isValidPhone(CharSequence target) {
        if (TextUtils.isEmpty(target) || target.toString().length() < 10 || target.toString().length() > 11) {
            return false;
        } else {
            return Patterns.PHONE.matcher(target).matches();
        }
    }



    @OnClick({R.id.btn_back, R.id.btn_send_request})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_send_request:
                String email = edtEmail.getText().toString();
                if (email.isEmpty()){
                    txtError.setVisibility(View.VISIBLE);
                    return;
                }
                if (isValidEmail(email)){
                    if (token != null){
                        getPresenter().forgetPassword(token.getAccessToken(), email, "");
                    }
                }
                break;
        }
    }

    @Override
    public void onGetToken(Token token) {
        this.token = token;
    }

    @Override
    public void onSuccess(String data) {
        ValidateVerifyCodeFragment validateVerifyCodeFragment = new ValidateVerifyCodeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Key.UID, data);
        bundle.putString(Key.TOKEN, token.getAccessToken());
        bundle.putString(Key.TITLE, getString(R.string.login));
        validateVerifyCodeFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, validateVerifyCodeFragment)
                .addToBackStack(null).commit();
    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, getContext());
    }

    @Override
    public Context gContext() {
        return getContext();
    }
}
