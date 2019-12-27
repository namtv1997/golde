package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.KhuyetTat;
import com.app.goldenhealth.presenter.HealthProfile5Presenter;
import com.app.goldenhealth.presenter.impl.HealthProfile5PresenterImpl;
import com.app.goldenhealth.util.Util;

public class HealthProfile5Fragment extends BaseFragment<HealthProfile5Presenter> implements HealthProfile5View {


    @BindView(R.id.cb_thinh_luc)
    CheckBox cbThinhLuc;
    @BindView(R.id.edt_thinh_luc)
    EditText edtThinhLuc;
    @BindView(R.id.cb_thi_luc)
    CheckBox cbThiLuc;
    @BindView(R.id.edt_thi_luc)
    EditText edtThiLuc;
    @BindView(R.id.cb_tay)
    CheckBox cbTay;
    @BindView(R.id.edt_tay)
    EditText edtTay;
    @BindView(R.id.cb_chan)
    CheckBox cbChan;
    @BindView(R.id.edt_chan)
    EditText edtChan;
    @BindView(R.id.cb_cong_veo_cot_song)
    CheckBox cbCongVeoCotSong;
    @BindView(R.id.edt_cong_veo_cot_song)
    EditText edtCongVeoCotSong;
    @BindView(R.id.cb_khe_ho_moi)
    CheckBox cbKheHoMoi;
    @BindView(R.id.edt_khe_ho_moi)
    EditText edtKheHoMoi;
    @BindView(R.id.cb_khac)
    CheckBox cbKhac;
    @BindView(R.id.edt_khac)
    EditText edtKhac;

    private KhuyetTat khuyetTat;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_health_profile_5;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getKhuyetTat();
    }

    @Override
    public HealthProfile5Presenter createPresenter() {
        return new HealthProfile5PresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetInfo(KhuyetTat data) {
        khuyetTat = data;
        cbThinhLuc.setChecked(data.getTHINHLUC() == 1);
        cbThiLuc.setChecked(data.getTHILUC() == 1);
        cbTay.setChecked(data.getTAY() == 1);
        cbChan.setChecked(data.getCHAN() == 1);
        cbCongVeoCotSong.setChecked(data.getCONGVEOCS() == 1);
        cbKheHoMoi.setChecked(data.getMOIHO() == 1);


        edtThinhLuc.setText(data.getMTTHINHLUC() == null ? "" : data.getMTTHINHLUC());
        edtThiLuc.setText(data.getMTTHILUC() == null ? "" : data.getMTTHILUC());
        edtTay.setText(data.getMTTAY() == null ? "" : data.getMTTAY());
        edtChan.setText(data.getMTCHAN() == null ? "" : data.getMTCHAN());
        edtCongVeoCotSong.setText(data.getMTCONGVEOCS() == null ? "" : data.getMTCONGVEOCS());
        edtKheHoMoi.setText(data.getMTMOIHO() == null ? "" : data.getMTMOIHO());
        edtKhac.setText(data.getKHAC() == null ? "" : data.getKHAC());
    }

    public void update() {
        int thinhLuc = cbThinhLuc.isChecked() ? 1 : 0;
        int thiLuc = cbThiLuc.isChecked() ? 1 : 0;
        int tay = cbTay.isChecked() ? 1 : 0;
        int chan = cbChan.isChecked() ? 1 : 0;
        int congVeoCS = cbCongVeoCotSong.isChecked() ? 1 : 0;
        int hoMoi = cbKheHoMoi.isChecked() ? 1 : 0;

        String mtThinhLuc = edtThinhLuc.getText().toString();
        String mtThiLuc = edtThiLuc.getText().toString();
        String mtTay = edtTay.getText().toString();
        String mtChan = edtChan.getText().toString();
        String mtCongVeo = edtCongVeoCotSong.getText().toString();
        String mtHoMoi = edtKheHoMoi.getText().toString();
        String khac = edtKhac.getText().toString();

        getPresenter().update(thinhLuc, mtThinhLuc, thiLuc, mtThiLuc, tay, mtTay, chan, mtChan, congVeoCS, mtCongVeo
                            , hoMoi, mtHoMoi, khac);
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