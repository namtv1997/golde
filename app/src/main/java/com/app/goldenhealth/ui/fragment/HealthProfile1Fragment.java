package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.ThongTinTomTat;
import com.app.goldenhealth.presenter.HealthProfile1Presenter;
import com.app.goldenhealth.presenter.impl.HealthProfile1PresenterImpl;
import com.app.goldenhealth.util.Util;

public class HealthProfile1Fragment extends BaseFragment<HealthProfile1Presenter> implements HealthProfile1View {


    @BindView(R.id.txt_thuoc)
    TextView txtThuoc;
    @BindView(R.id.txt_hoa_chat)
    TextView txtHoaChat;
    @BindView(R.id.txt_thuc_pham)
    TextView txtThucPham;
    @BindView(R.id.txt_khac)
    TextView txtKhac;
    @BindView(R.id.txt_benh)
    TextView txtBenh;
    @BindView(R.id.txt_bo_phan)
    TextView txtBoPhan;
    Unbinder unbinder;
    @BindView(R.id.edt_nhom_mau)
    EditText edtNhomMau;
    @BindView(R.id.edt_chieu_cao)
    EditText edtChieuCao;
    @BindView(R.id.edt_can_nang)
    EditText edtCanNang;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_health_profile_1;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getThongTinTomTat();
    }

    @Override
    public HealthProfile1Presenter createPresenter() {
        return new HealthProfile1PresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetInfo(ThongTinTomTat data) {
        edtNhomMau.setText(data.getNHOMMAU());
        edtChieuCao.setText(data.getCHIEUCAO().toString());
        edtCanNang.setText(data.getCANNANG().toString());
        txtThuoc.setText(data.getDUTHUOC());
        txtHoaChat.setText(data.getDUHOACHAT());
        txtThucPham.setText(data.getDUTHUCPHAM());
        txtKhac.setText(data.getDUKHAC());
        String benh = "";
        if (data.getHENXUYEN() == 1) {
            benh += "Hen xuyễn\n";
        }
        if (data.getPHOIMANTINH() == 1) {
            benh += "Phổi mãn tính\n";
        }
        if (data.getTIMMACH() == 1) {
            benh += "Tim mạch\n";
        }
        if (data.getDAITHAODUONG() == 1) {
            benh += "Đái tháo đường\n";
        }
        if (data.getDADAY() == 1) {
            benh += "Dạ dày\n";
        }
        if (data.getBUOUCO() == 1) {
            benh += "Bướu cổ\n";
        }
        if (data.getVIEMGAN() == 1) {
            benh += "Viêm gan\n";
        }
        if (data.getTAMTHAN() == 1) {
            benh += "Tâm thần\n";
        }
        if (data.getDONGKINH() == 1) {
            benh += "Động kinh\n";
        }
        if (data.getTUKY() == 1) {
            benh += "Tự kỷ\n";
        }
        if (!data.getUNGTHU().isEmpty()) {
            benh += data.getUNGTHU() + "\n";
        }
        if (!data.getLAO().isEmpty()) {
            benh += data.getLAO() + " \n";
        }
        if (!data.getKHAC().isEmpty()) {
            benh += data.getKHAC() + "\n";
        }
        if (data.getTANGHUYETAP() == 1) {
            benh += "Tăng huyết áp\n";
        }
        if (data.getTIMBAMSINH() == 1) {
            benh += "Tim bẩm sinh\n";
        }

        txtBenh.setText(benh);
    }

    public void update() {
        double canNang = Double.parseDouble(edtCanNang.getText().toString());
        double chieuCao = Double.parseDouble(edtChieuCao.getText().toString());
        String nhomMau = edtNhomMau.getText().toString();

        getPresenter().update(nhomMau, canNang, chieuCao);
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