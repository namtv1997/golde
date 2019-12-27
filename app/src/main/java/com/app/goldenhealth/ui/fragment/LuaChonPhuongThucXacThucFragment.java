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
import com.app.goldenhealth.presenter.LuaChonPhuongThucXacThucPresenter;
import com.app.goldenhealth.presenter.impl.LuaChonPhuongThucXacThucPresenterImpl;

import java.util.Objects;

public class LuaChonPhuongThucXacThucFragment extends BaseFragment<LuaChonPhuongThucXacThucPresenter> implements LuaChonPhuongThucXacThucView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.btn_email)
    TextView btnEmail;
    @BindView(R.id.btn_phone)
    TextView btnPhone;
    Unbinder unbinder;
    private String uid;
    private String token;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_lua_chon_xac_thuc;
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
    public LuaChonPhuongThucXacThucPresenter createPresenter() {
        return new LuaChonPhuongThucXacThucPresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_email, R.id.btn_phone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                Objects.requireNonNull(getActivity()).onBackPressed();
                break;
            case R.id.btn_email:
                VerifyEmailFragment verifyEmailFragment = new VerifyEmailFragment();
                Bundle bundle = new Bundle();
                bundle.putString(Key.UID, uid);
                bundle.putString(Key.TOKEN, token);
                verifyEmailFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, verifyEmailFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_phone:
                VerifyPhoneFragment verifyPhoneFragment = new VerifyPhoneFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putString(Key.UID, uid);
                bundle1.putString(Key.TOKEN, token);
                verifyPhoneFragment.setArguments(bundle1);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, verifyPhoneFragment)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}