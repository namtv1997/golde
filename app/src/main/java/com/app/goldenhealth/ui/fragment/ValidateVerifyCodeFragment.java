package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import com.app.goldenhealth.presenter.ValidateVerifyCodePresenter;
import com.app.goldenhealth.presenter.impl.ValidateVerifyCodePresenterImpl;
import com.app.goldenhealth.ui.activity.LoginActivity;
import com.app.goldenhealth.util.Util;

public class ValidateVerifyCodeFragment extends BaseFragment<ValidateVerifyCodePresenter> implements ValidateVerifyCodeView {

    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.edt_code)
    EditText edtCode;
    @BindView(R.id.btn_send_again)
    TextView btnSendAgain;
    @BindView(R.id.btn_confirm)
    TextView btnConfirm;

    private String uid;
    private String token;
    private String title;
    private CountDownTimer timer;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_validate_verify_code;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null){
            uid = bundle.getString(Key.UID);
            token = bundle.getString(Key.TOKEN);
            title = bundle.getString(Key.TITLE);
            txtTitle.setText(title);
        }


        btnSendAgain.setClickable(false);
        timer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                if (getActivity() != null){
                    btnSendAgain.setText(getString(R.string.resend_after) + " " + millisUntilFinished / 1000 + "s");
                }
            }

            public void onFinish() {
                if (getActivity() != null){
                    btnSendAgain.setText(getString(R.string.send_again));
                    btnSendAgain.setTextColor(getResources().getColor(R.color.black));
                    btnSendAgain.setClickable(true);
                }
            }
        }.start();
    }

    @Override
    public ValidateVerifyCodePresenter createPresenter() {
        return new ValidateVerifyCodePresenterImpl(this);
    }


    @OnClick({R.id.btn_back, R.id.btn_send_again, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_send_again:
                getPresenter().resendVerifyCode(token, uid);

                break;
            case R.id.btn_confirm:
                String code = edtCode.getText().toString();
                getPresenter().validateVerifyCode(token, uid, code);
                break;
        }
    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, getContext());
    }

    @Override
    public void onSuccess() {
        timer.cancel();
        if (title.equals(getString(R.string.register))){
            Toast.makeText(getContext(), R.string.register_success, Toast.LENGTH_SHORT).show();
            startActivity(LoginActivity.getCallingIntent(getContext()));
        }else if (title.equals(getString(R.string.login))){
            NewPasswordFragment newPasswordFragment = new NewPasswordFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Key.TOKEN, token);
            bundle.putString(Key.UID, uid);
            newPasswordFragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, newPasswordFragment)
                    .commit();
        }

    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onResend() {
        btnSendAgain.setClickable(false);
        btnSendAgain.setTextColor(getResources().getColor(R.color.colorPrimary));
        timer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                if (getActivity() != null){
                    btnSendAgain.setText(getString(R.string.resend_after) + " " + millisUntilFinished / 1000 + "s");
                }

            }

            public void onFinish() {
                if (getActivity() != null){
                    btnSendAgain.setText(getString(R.string.send_again));
                    btnSendAgain.setTextColor(getResources().getColor(R.color.black));
                    btnSendAgain.setClickable(true);
                }
            }
        }.start();
    }
}