package com.app.goldenhealth.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.app.goldenhealth.presenter.VerifyEmailPresenter;
import com.app.goldenhealth.presenter.impl.VerifyEmailPresenterImpl;

import java.util.Objects;

public class VerifyEmailFragment extends BaseFragment<VerifyEmailPresenter> implements VerifyEmailView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.btn_send_again)
    TextView btnSendAgain;
    @BindView(R.id.btn_email_again)
    TextView btnEmailAgain;

    private String uid;
    private String token;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_verify_email;
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
    public VerifyEmailPresenter createPresenter() {
        return new VerifyEmailPresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_send_again, R.id.btn_email_again})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_send_again:

                break;
            case R.id.btn_email_again:
                NhapLaiEmailXacNhanFragment nhapLaiEmailXacNhanFragment = new NhapLaiEmailXacNhanFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, nhapLaiEmailXacNhanFragment)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
