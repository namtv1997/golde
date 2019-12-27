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
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.DoiMatKhauPresenter;
import com.app.goldenhealth.presenter.impl.DoiMatKhauPresenterImpl;
import com.app.goldenhealth.util.Util;

import java.util.Objects;

public class DoiMatKhauFragment extends BaseFragment<DoiMatKhauPresenter> implements DoiMatKhauView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.edt_old_pass)
    EditText edtOldPass;
    @BindView(R.id.edt_new_pass)
    EditText edtNewPass;
    @BindView(R.id.edt_new_pass_again)
    EditText edtNewPassAgain;
    @BindView(R.id.btn_save)
    TextView btnSave;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_doi_mat_khau;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public DoiMatKhauPresenter createPresenter() {
        return new DoiMatKhauPresenterImpl(this);
    }


    @OnClick({R.id.btn_back, R.id.btn_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_save:
                String matKhau = edtOldPass.getText().toString();
                String matKhauMoi = edtNewPass.getText().toString();
                String matKhauXacNhan = edtNewPassAgain.getText().toString();
                if (!matKhauMoi.equals(matKhauXacNhan)){
                    Util.showMessenger(getString(R.string.mat_khau_khong_giong_nhau), getContext());
                    return;
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

    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, getContext());
    }
}