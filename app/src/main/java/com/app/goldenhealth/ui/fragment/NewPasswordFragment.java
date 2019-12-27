package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
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
import com.app.goldenhealth.presenter.NewPasswordPresenter;
import com.app.goldenhealth.presenter.impl.NewPasswordPresenterImpl;
import com.app.goldenhealth.util.Util;

public class NewPasswordFragment extends BaseFragment<NewPasswordPresenter> implements NewPasswordView {
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.edt_new_password)
    EditText edtNewPassword;
    @BindView(R.id.edt_password_again)
    EditText edtPasswordAgain;
    @BindView(R.id.btn_confirm)
    TextView btnConfirm;
    Unbinder unbinder;
    private String token = "";
    private String uid = "";

    @Override
    public int getContentViewId() {
        return R.layout.fragment_new_password;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null){
            token = bundle.getString(Key.TOKEN);
            uid = bundle.getString(Key.UID);
        }
    }

    @Override
    public NewPasswordPresenter createPresenter() {
        return new NewPasswordPresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_confirm:
                String password = edtNewPassword.getText().toString();
                String passwordAgain = edtPasswordAgain.getText().toString();
                if (password.isEmpty()){
                    edtNewPassword.setError(getString(R.string.enter_password));
                }else if (passwordAgain.isEmpty()) {
                    edtPasswordAgain.setError(getString(R.string.enter_password_again_));
                }else if (!password.equals(passwordAgain)){
                    Util.showMessenger(getString(R.string.password_not_match), getContext());
                }else if (token != null && !token.isEmpty()) {
                    getPresenter().changePassword(token, uid, password);
                }
                break;
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onSuccess() {
        DoneFragment doneFragment = new DoneFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, doneFragment)
                .commit();
    }

    @Override
    public void onFail(String message) {
        FailFragment failFragment = new FailFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, failFragment)
                .addToBackStack(null).commit();
    }
}
