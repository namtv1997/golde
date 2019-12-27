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
import com.app.goldenhealth.model.TienSuBenhTat;
import com.app.goldenhealth.presenter.HealthProfile4Presenter;
import com.app.goldenhealth.presenter.impl.HealthProfile4PresenterImpl;
import com.app.goldenhealth.util.Util;

public class HealthProfile4Fragment extends BaseFragment<HealthProfile4Presenter> implements HealthProfile4View {


    @BindView(R.id.cb_benh_tim_mach)
    CheckBox cbBenhTimMach;
    @BindView(R.id.cb_dai_thao_duong)
    CheckBox cbDaiThaoDuong;
    @BindView(R.id.cb_benh_phoi_man_tinh)
    CheckBox cbBenhPhoiManTinh;
    @BindView(R.id.cb_benh_buou_co)
    CheckBox cbBenhBuouCo;
    @BindView(R.id.cb_tim_bam_sinh)
    CheckBox cbTimBamSinh;
    @BindView(R.id.cb_tu_ky)
    CheckBox cbTuKy;
    @BindView(R.id.cb_tang_huyet_ap)
    CheckBox cbTangHuyetAp;
    @BindView(R.id.cb_benh_da_day)
    CheckBox cbBenhDaDay;
    @BindView(R.id.cb_hen_suyen)
    CheckBox cbHenSuyen;
    @BindView(R.id.cb_viem_gan)
    CheckBox cbViemGan;
    @BindView(R.id.cb_tam_than)
    CheckBox cbTamThan;
    @BindView(R.id.cb_dong_kinh)
    CheckBox cbDongKinh;
    @BindView(R.id.cb_du_thuoc)
    CheckBox cbDuThuoc;
    @BindView(R.id.edt_du_thuoc)
    EditText edtDuThuoc;
    @BindView(R.id.du_hoa_chat)
    CheckBox duHoaChat;
    @BindView(R.id.edt_du_hoa_chat)
    EditText edtDuHoaChat;
    @BindView(R.id.cb_du_thuc_pham)
    CheckBox cbDuThucPham;
    @BindView(R.id.edt_du_thuc_pham)
    EditText edtDuThucPham;
    @BindView(R.id.cb_du_khac)
    CheckBox cbDuKhac;
    @BindView(R.id.edt_du_khac)
    EditText edtDuKhac;
    @BindView(R.id.edt_ung_thu)
    EditText edtUngThu;
    @BindView(R.id.edt_lao)
    EditText edtLao;
    @BindView(R.id.edt_khac)
    EditText edtKhac;
    private TienSuBenhTat tienSuBenhTat;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_health_profile_4;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getTienSuBenhTat();
    }

    @Override
    public HealthProfile4Presenter createPresenter() {
        return new HealthProfile4PresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetInfo(TienSuBenhTat data) {
        tienSuBenhTat = data;
        cbBenhTimMach.setChecked(data.getTIMMACH() == 1);
        cbDaiThaoDuong.setChecked(data.getDAITHAODUONG() == 1);
        cbBenhPhoiManTinh.setChecked(data.getPHOIMANTINH() == 1);
        cbBenhBuouCo.setChecked(data.getBUOUCO() == 1);
        cbTimBamSinh.setChecked(data.getTIMBAMSINH() == 1);
        cbTuKy.setChecked(data.getTUKY() == 1);
        cbTangHuyetAp.setChecked(data.getTANGHUYETAP() == 1);
        cbBenhDaDay.setChecked(data.getDADAY() == 1);
        cbHenSuyen.setChecked(data.getHENXUYEN() == 1);
        cbViemGan.setChecked(data.getVIEMGAN() == 1);
        cbTamThan.setChecked(data.getTAMTHAN() == 1);
        cbDongKinh.setChecked(data.getDONGKINH() == 1);

        cbDuThuoc.setChecked((data.getDUTHUOC() != null && !data.getDUTHUOC().isEmpty()));
        edtDuThuoc.setText(data.getDUTHUOC() == null ? "" : data.getDUTHUOC());
        duHoaChat.setChecked((data.getDUHOACHAT() != null && !data.getDUHOACHAT().isEmpty()));
        edtDuHoaChat.setText(data.getDUHOACHAT() == null ? "" : data.getDUHOACHAT());
        cbDuThucPham.setChecked((data.getDUTHUCPHAM() != null && !data.getDUTHUCPHAM().isEmpty()));
        edtDuThucPham.setText(data.getDUTHUCPHAM() == null ? "" : data.getDUTHUCPHAM());
        cbDuKhac.setChecked((data.getDUKHAC() != null && !data.getDUKHAC().isEmpty()));
        edtDuKhac.setText(data.getDUKHAC() == null ? "" : data.getDUKHAC());
        edtUngThu.setText(data.getUNGTHU() == null ? "" : data.getUNGTHU());
        edtLao.setText(data.getLAO() == null ? "" : data.getLAO());
        edtKhac.setText(data.getKHAC() == null ? "" : data.getKHAC());
    }

    public void update() {
        int timMach = cbBenhTimMach.isChecked() ? 1 : 0;
        int daiThaoDuong = cbDaiThaoDuong.isChecked() ? 1 : 0;
        int phoiManTinh = cbBenhPhoiManTinh.isChecked() ? 1 : 0;
        int buouCo = cbBenhBuouCo.isChecked() ? 1 : 0;
        int timBamSinh = cbTimBamSinh.isChecked() ? 1 : 0;
        int tuKy = cbTuKy.isChecked() ? 1 : 0;
        int tangHuyetAp = cbTangHuyetAp.isChecked() ? 1 : 0;
        int daday = cbBenhDaDay.isChecked() ? 1 : 0;
        int henXuyen = cbHenSuyen.isChecked() ? 1 : 0;
        int viemGan = cbViemGan.isChecked() ? 1 : 0;
        int tamThan = cbTamThan.isChecked() ? 1 : 0;
        int dongKinh = cbDongKinh.isChecked() ? 1 : 0;
        String ungThu = edtUngThu.getText().toString();
        String lao = edtLao.getText().toString();
        String khac = edtKhac.getText().toString();
        String duThuoc = edtDuThuoc.getText().toString();
        String duHoaChat = edtDuHoaChat.getText().toString();
        String duThucPham = edtDuThucPham.getText().toString();
        String duKhac = edtDuKhac.getText().toString();

        getPresenter().update(timMach, daiThaoDuong, phoiManTinh, buouCo, timBamSinh, tuKy, tangHuyetAp, daday, henXuyen,
                viemGan, tamThan, dongKinh, ungThu, lao, khac, duThuoc, duHoaChat, duThucPham, duKhac);
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