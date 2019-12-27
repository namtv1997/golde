package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.VerifyPhonePresenter;
import com.app.goldenhealth.presenter.impl.VerifyPhonePresenterImpl;
import com.app.goldenhealth.ui.activity.LoginActivity;
import com.app.goldenhealth.util.Util;

import java.util.Objects;

public class VerifyPhoneFragment extends BaseFragment<VerifyPhonePresenter> implements VerifyPhoneView {
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.edt_otp)
    EditText edtOtp;
    @BindView(R.id.btn_send_again)
    TextView btnSendAgain;
    @BindView(R.id.btn_confirm)
    TextView btnConfirm;
    @BindView(R.id.btn_phone_again)
    TextView btnPhoneAgain;
    @BindView(R.id.btn_call)
    TextView btnCall;

    private String uid;
    private String token;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_verify_phone;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null){
            uid = bundle.getString(Key.UID);
            token = bundle.getString(Key.TOKEN);
        }
    }

    @Override
    public VerifyPhonePresenter createPresenter() {
        return new VerifyPhonePresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_send_again, R.id.btn_confirm, R.id.btn_phone_again, R.id.btn_call})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_send_again:
                getPresenter().resendVerifyCode(token, uid);
                break;
            case R.id.btn_confirm:
                String code = edtOtp.getText().toString();
                getPresenter().validateVerifyCode(token, uid, code);
                break;
            case R.id.btn_phone_again:
                NhapLaiSDTXacNhanFragment nhapLaiSDTXacNhanFragment = new NhapLaiSDTXacNhanFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, nhapLaiSDTXacNhanFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_call:
                break;
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onSuccess() {
        Toast.makeText(getContext(), R.string.register_success, Toast.LENGTH_SHORT).show();
        startActivity(LoginActivity.getCallingIntent(getContext()));
    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, getContext());
    }

    @Override
    public void onResend() {

    }
}
