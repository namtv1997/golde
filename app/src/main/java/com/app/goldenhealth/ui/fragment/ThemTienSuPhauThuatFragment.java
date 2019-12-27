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
import com.app.goldenhealth.model.TienSuPhauThuat;
import com.app.goldenhealth.presenter.ThemTienSuPhauThuatPresenter;
import com.app.goldenhealth.presenter.impl.ThemTienSuPhauThuatPresenterImpl;
import com.app.goldenhealth.util.Util;

public class ThemTienSuPhauThuatFragment extends BaseFragment<ThemTienSuPhauThuatPresenter> implements ThemTienSuPhauThuatView {


    @BindView(R.id.edt_bo_phan)
    EditText edtBoPhan;
    @BindView(R.id.edt_nam_pt)
    EditText edtNamPt;
    @BindView(R.id.edt_mo_ta)
    EditText edtMoTa;
    @BindView(R.id.edt_noi_thuc_hien)
    EditText edtNoiThucHien;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.btn_done)
    ImageView btnDone;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    Unbinder unbinder;
    private OnCreateSuccess onCreateSuccess;
    private int id;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_them_tien_su_phau_thuat;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null){
            id = bundle.getInt(Key.ID);
        }
        if (id != 0){
            txtTitle.setText(R.string.cap_nhat_tien_su_phau_thuat);
            getPresenter().getTienSuPhauThuat(id);
        }else {
            txtTitle.setText(R.string.them_tien_su_phau_thuat);
        }
    }

    @Override
    public ThemTienSuPhauThuatPresenter createPresenter() {
        return new ThemTienSuPhauThuatPresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_done, R.id.edt_nam_pt, R.id.edt_noi_thuc_hien})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_done:
                String boPhan = edtBoPhan.getText().toString();
                int nam = edtNamPt.getText().toString().isEmpty() ? 0 : Integer.parseInt(edtNamPt.getText().toString());
                String noiPT = edtNoiThucHien.getText().toString();
                String moTa = edtMoTa.getText().toString();

                if (id == 0){
                    getPresenter().create(boPhan, nam, moTa, noiPT);
                }else {
                    getPresenter().upadte(id, boPhan, nam, moTa, noiPT);
                }

                break;
            case R.id.edt_noi_thuc_hien:
                break;
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onCreateSuccess() {
        onCreateSuccess.onSuccess();
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, getContext());
    }

    @Override
    public void onGetInfo(TienSuPhauThuat data) {
        edtBoPhan.setText(data.getBOPHANPHAUTHUAT());
        edtNamPt.setText(data.getNAMTHUCHIEN().toString());
        edtMoTa.setText(data.getMTPT());
    }

    public void setOnCreateSuccess(OnCreateSuccess onCreateSuccess) {
        this.onCreateSuccess = onCreateSuccess;
    }

    public interface OnCreateSuccess{
        void onSuccess();
    }
}