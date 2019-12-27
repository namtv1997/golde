package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.VanDeKhac;
import com.app.goldenhealth.presenter.HealthProfile8Presenter;
import com.app.goldenhealth.presenter.impl.HealthProfile8PresenterImpl;
import com.app.goldenhealth.util.Util;

public class HealthProfile8Fragment extends BaseFragment<HealthProfile8Presenter> implements HealthProfile8View {


    @BindView(R.id.edt_van_de_khac)
    EditText edtVanDeKhac;
    private VanDeKhac vanDeKhac;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_health_profile_8;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getVanDeKhac();
    }

    @Override
    public HealthProfile8Presenter createPresenter() {
        return new HealthProfile8PresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetInfo(VanDeKhac data) {
        vanDeKhac = data;
        edtVanDeKhac.setText(data.getVANDE());
    }

    public void update() {
        String vanDe = edtVanDeKhac.getText().toString();
        getPresenter().update(vanDe);
    }

    @Override
    public void onUpdateSuccess() {
        Util.showMessenger(getString(R.string.update_sucsess), getContext());
    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, getContext());
    }

}