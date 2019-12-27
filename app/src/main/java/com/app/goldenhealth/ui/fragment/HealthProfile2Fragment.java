package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.TinhTrangLucSinh;
import com.app.goldenhealth.presenter.HealthProfile2Presenter;
import com.app.goldenhealth.presenter.impl.HealthProfile2PresenterImpl;
import com.app.goldenhealth.util.Util;

public class HealthProfile2Fragment extends BaseFragment<HealthProfile2Presenter> implements HealthProfile2View {

    @BindView(R.id.cb_de_thuong)
    RadioButton cbDeThuong;
    @BindView(R.id.cb_de_mo)
    RadioButton cbDeMo;
    @BindView(R.id.cb_de_thieu_thang)
    CheckBox cbDeThieuThang;
    @BindView(R.id.cb_bi_ngat_luc_de)
    CheckBox cbBiNgatLucDe;
    @BindView(R.id.edt_can_nang)
    EditText edtCanNang;
    @BindView(R.id.edt_chieu_dai)
    EditText edtChieuDai;
    @BindView(R.id.edt_di_tat)
    EditText edtDiTat;
    @BindView(R.id.edt_van_de_khac)
    EditText edtVanDeKhac;
    private TinhTrangLucSinh tinhTrangLucSinh;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_health_profile_2;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getTinhTrangLucSinh();
    }

    @Override
    public HealthProfile2Presenter createPresenter() {
        return new HealthProfile2PresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetInfo(TinhTrangLucSinh data) {
        tinhTrangLucSinh = data;
        if (data.getDETHUONG() == 1) {
            cbDeThuong.setChecked(true);
        } else {
            cbDeMo.setChecked(true);
        }

        if (data.getDETHIEUTHANG() == 1) {
            cbDeThieuThang.setChecked(true);
        } else {
            cbDeThieuThang.setChecked(false);
        }

        if (data.getBINGAT() == 1) {
            cbBiNgatLucDe.setChecked(true);
        } else {
            cbBiNgatLucDe.setChecked(false);
        }

        edtCanNang.setText(data.getCANNANG().toString());
        edtChieuDai.setText(data.getCHIEUDAI().toString());
        edtDiTat.setText(data.getDITAT());
        edtVanDeKhac.setText(data.getVANDEKHAC());
    }

    public void update() {
        int deThuong = 0;
        if (cbDeThuong.isChecked()) {
            deThuong = 1;
        }

        int biNgat = cbBiNgatLucDe.isChecked() ? 1 : 0;
        int deThieuThang = cbDeThieuThang.isChecked() ? 1 : 0;
        double canNang = Double.parseDouble(edtCanNang.getText().toString());
        double chieuDai = Double.parseDouble(edtChieuDai.getText().toString());
        String diTat = edtDiTat.getText().toString();
        String vanDeKhac = edtVanDeKhac.getText().toString();

        getPresenter().update(deThuong, biNgat, deThieuThang, canNang, chieuDai, diTat, vanDeKhac);
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