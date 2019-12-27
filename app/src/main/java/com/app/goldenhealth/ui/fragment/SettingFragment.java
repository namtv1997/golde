package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.User;
import com.app.goldenhealth.presenter.SettingPresenter;
import com.app.goldenhealth.presenter.impl.SettingPresenterImpl;
import com.app.goldenhealth.util.Logout;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;

public class SettingFragment extends BaseFragment<SettingPresenter> implements SettingView {

    @BindView(R.id.sw_notify)
    Switch swNotify;

    @BindView(R.id.btn_language)
    LinearLayout btnLanguage;
    @BindView(R.id.btn_logout)
    LinearLayout btnLogout;

    private AppInfoFragment appInfoFragment;
    private PolicyFragment policyFragment;


    @Override
    public int getContentViewId() {
        return R.layout.fragment_setting;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);

        if (PrefUtil.getDataUser(getContext()).getNotifications() == 0){
            swNotify.setChecked(false);
        }else {
            swNotify.setChecked(true);
        }
        swNotify.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    getPresenter().setNotification(1);
                }else {
                    getPresenter().setNotification(0);
                }
            }
        });
    }

    @Override
    public SettingPresenter createPresenter() {
        return new SettingPresenterImpl(this);
    }


    @OnClick({ R.id.btn_language, R.id.btn_logout,R.id.btnDieuKhoan})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_language:
                break;

            case R.id.btn_logout:
                Logout.logout(getContext());
                break;

            case R.id.btnDieuKhoan:
                PolicyFragment policyFragment = new PolicyFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, policyFragment)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void onSuccess(int isNotify) {
        User user = PrefUtil.getDataUser(getContext());
        user.setNotifications(isNotify);
        PrefUtil.saveDataUser(user, getContext());
    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, getContext());
    }
}