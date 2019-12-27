package com.app.goldenhealth.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseActivity;
import com.app.goldenhealth.model.HoSoKhamLap;
import com.app.goldenhealth.presenter.KhamLapHoSoPresenter;
import com.app.goldenhealth.presenter.impl.KhamLapHoSoPresenterImpl;
import com.app.goldenhealth.util.Util;

import java.util.ArrayList;

public class KhamLapHoSoActivity extends BaseActivity<KhamLapHoSoPresenter> implements KhamlapHoSoView {

    @BindView(R.id.tvNameOfHospital)
    TextView tvNameOfHospital;
    @BindView(R.id.edtSick)
    EditText edtSick;
    @BindView(R.id.edtMach)
    EditText edtMach;
    @BindView(R.id.edtNhietDo)
    EditText edtNhietDo;
    @BindView(R.id.edtHuyetAp)
    EditText edtHuyetAp;
    @BindView(R.id.edtNhipTho)
    EditText edtNhipTho;
    @BindView(R.id.edtChieuCao)
    EditText edtChieuCao;
    @BindView(R.id.edtCanNang)
    EditText edtCanNang;
    @BindView(R.id.edtBmi)
    EditText edtBmi;
    @BindView(R.id.edtVongBung)
    EditText edtVongBung;
    @BindView(R.id.edtDa)
    EditText edtDa;
    @BindView(R.id.edtNiemMac)
    EditText edtNiemMac;
    @BindView(R.id.edtToanThanKhac)
    EditText edtToanThanKhac;
    @BindView(R.id.edtTimMach)
    EditText edtTimMach;
    @BindView(R.id.edtHoHap)
    EditText edtHoHap;
    @BindView(R.id.edtTieuHoa)
    EditText edtTieuHoa;
    @BindView(R.id.edtTietNieu)
    EditText edtTietNieu;
    @BindView(R.id.edtCoXuongKhop)
    EditText edtCoXuongKhop;
    @BindView(R.id.edtNoiTiet)
    EditText edtNoiTiet;
    @BindView(R.id.edtThanKinh)
    EditText edtThanKinh;
    @BindView(R.id.edtTamThan)
    EditText edtTamThan;
    @BindView(R.id.edtTaiMuiHong)
    EditText edtTaiMuiHong;
    @BindView(R.id.edtRangHamMat)
    EditText edtRangHamMat;
    @BindView(R.id.edtDinhDuong)
    EditText edtDinhDuong;
    @BindView(R.id.edtMat)
    EditText edtMat;
    @BindView(R.id.edtVanDong)
    EditText edtVanDong;
    @BindView(R.id.edtCoQuanKhac)
    EditText edtCoQuanKhac;
    @BindView(R.id.edtDanhGia)
    EditText edtDanhGia;
    @BindView(R.id.llSignal)
    LinearLayout llSignal;
    @BindView(R.id.llResultSick)
    LinearLayout llResultSick;
    @BindView(R.id.llTuVan)
    LinearLayout llTuVan;
    @BindView(R.id.ivArrowUpThamKhamLamSang)
    ImageView ivArrowUpThamKhamLamSang;
    @BindView(R.id.ivArrowDownThamKhamLamSang)
    ImageView ivArrowDownThamKhamLamSang;
    @BindView(R.id.ivArrowUpKetQuaLamSang)
    ImageView ivArrowUpKetQuaLamSang;
    @BindView(R.id.ivArrowDownKetQuaLamSang)
    ImageView ivArrowDownKetQuaLamSang;
    @BindView(R.id.ivArrowUpTuVan)
    ImageView ivArrowUpTuVan;
    @BindView(R.id.ivArrowDownTuVan)
    ImageView ivArrowDownTuVan;
    @BindView(R.id.edtHenTaiKham)
    EditText edtHenTaiKham;
    @BindView(R.id.edtNameOfDoctor)
    EditText edtNameOfDoctor;
    @BindView(R.id.edtConclude)
    EditText edtConclude;
    @BindView(R.id.tvDate)
    TextView tvDate;

    ArrayList<Integer> arrListInteger = new ArrayList<>();
    private Integer IDbenhVien;

    @Override
    public int getContentViewId() {
        return R.layout.activity_kham_lap_ho_so;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        getPresenter().getHoSoKhamLap();

    }

    @Override
    public Context gContext() {
        return this;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onGetInfo(HoSoKhamLap data) {
        tvNameOfHospital.setText(data.getIBENHVIEN());
        edtSick.setText(data.getBENHSU());
        edtHuyetAp.setText(data.getHUYETAPTD());
        edtMach.setText(data.getMACH().toString());
        edtNhietDo.setText(data.getNHIETDO().toString());
        edtNhipTho.setText(data.getNHIPTHO().toString());
        edtChieuCao.setText(data.getCHIEUCAO().toString());
        edtCanNang.setText(data.getCANNANG().toString());
        edtBmi.setText(data.getBMI().toString());
        edtVongBung.setText(data.getVONGBUNG().toString());
        edtDa.setText(data.getKHAMDA());
        edtNiemMac.setText(data.getKHAMNIEMMAC());
        edtToanThanKhac.setText(data.getKHAMTTKHAC());
        edtTimMach.setText(data.getKHAMTIMMACH());
        edtHoHap.setText(data.getKHAMHOHAP());
        edtTieuHoa.setText(data.getKHAMTIEUHOA());
        edtTietNieu.setText(data.getKHAMTIETNIEU());
        edtCoXuongKhop.setText(data.getKHAMCXK());
        edtNoiTiet.setText(data.getKHAMNOITIET());
        edtThanKinh.setText(data.getKHAMTHANKINH());
        edtTamThan.setText(data.getKHAMTAMTHAN());
        edtTaiMuiHong.setText(data.getKHAMTAIMUIHONG());
        edtRangHamMat.setText(data.getKHAMRANGHAMMAT());
        edtDinhDuong.setText(data.getKHAMDINHDUONG());
        edtMat.setText(data.getKHAMMAT());
        edtVanDong.setText(data.getKHAMVANDONG());
        edtCoQuanKhac.setText(data.getKHAMCQKHAC());
        edtDanhGia.setText(data.getKHAMDANHGIA());
        edtHenTaiKham.setText(data.getNGAYHENKHAM());
        edtNameOfDoctor.setText(data.getBACSIKHAM());
        for (int i = 0; i < data.getLOAIIDCs().size() - 1; i++) {
            edtConclude.setText(data.getLOAIIDCs().get(i).getTEN());
            arrListInteger.add(data.getLOAIIDCs().get(i).getID());
        }
        IDbenhVien = data.getIDBENHVIEN();

        tvDate.setText(data.getNGAYKHAM());

    }

    @Override
    public void onUpdateSuccess() {
        Util.showMessenger(getString(R.string.update_sucsess), this);
    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, this);
    }

    @Override
    public KhamLapHoSoPresenter createPresenter() {
        return new KhamLapHoSoPresenterImpl(this);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @OnClick({R.id.llMedicalExamination, R.id.llResult, R.id.llAdvisory, R.id.ivBack, R.id.btnLuu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llMedicalExamination:
                Expand(llSignal, ivArrowDownThamKhamLamSang, ivArrowUpThamKhamLamSang);
                break;
            case R.id.llResult:
                Expand(llResultSick, ivArrowDownKetQuaLamSang, ivArrowUpKetQuaLamSang);
                break;
            case R.id.llAdvisory:
                Expand(llTuVan, ivArrowDownTuVan, ivArrowUpTuVan);
                break;
            case R.id.ivBack:
                finish();
                break;
            case R.id.btnLuu:
                upDate();
                break;
        }
    }

    void Expand(LinearLayout linearLayout, ImageView imgGone, ImageView imgVisible) {
        if (linearLayout.getVisibility() == View.GONE) {
            imgGone.setVisibility(View.VISIBLE);
            linearLayout.setVisibility(View.VISIBLE);
            imgVisible.setVisibility(View.GONE);
        } else {
            linearLayout.setVisibility(View.GONE);
            imgGone.setVisibility(View.GONE);
            imgVisible.setVisibility(View.VISIBLE);
        }


    }

    void upDate() {
        if (!edtMach.getText().toString().isEmpty() &&
                !edtNhietDo.getText().toString().isEmpty() &&
                !edtHuyetAp.getText().toString().isEmpty() &&
                !edtNhipTho.getText().toString().isEmpty() &&
                !edtCanNang.getText().toString().isEmpty() &&
                !edtChieuCao.getText().toString().isEmpty() &&
                !edtVongBung.getText().toString().isEmpty() &&
                !edtBmi.getText().toString().isEmpty()) {

            String benhsu = edtSick.getText().toString().trim();
            double mach = Double.parseDouble(edtMach.getText().toString());
            double nhietdo = Double.parseDouble(edtNhietDo.getText().toString());
            int huyetAp = Integer.parseInt(edtHuyetAp.getText().toString());
            int nhipTho = Integer.parseInt(edtNhipTho.getText().toString());
            double canNang = Double.parseDouble(edtCanNang.getText().toString());
            double chieuCao = Double.parseDouble(edtChieuCao.getText().toString());
            double vongBung = Double.parseDouble(edtVongBung.getText().toString());
            double BMI = Double.parseDouble(edtBmi.getText().toString());
            String khamDa = edtDa.getText().toString().trim();
            String khamNiemMac = edtNiemMac.getText().toString().trim();
            String khamTTKhac = edtNiemMac.getText().toString().trim();
            String khamTimMach = edtTimMach.getText().toString().trim();
            String khamHoHap = edtHoHap.getText().toString().trim().trim();
            String khamTietNieu = edtTietNieu.getText().toString().trim();
            String khamTieuHoa = edtTieuHoa.getText().toString().trim();
            String khamCXK = edtCoXuongKhop.getText().toString().trim();
            String khamnoitiet = edtNoiTiet.getText().toString().trim();
            String khamthankinh = edtThanKinh.getText().toString().trim();
            String khamtamthan = edtTamThan.getText().toString().trim();
            String khamTaiMuiHong = edtTaiMuiHong.getText().toString().trim();
            String khamRangHamMat = edtRangHamMat.getText().toString().trim();
            String khamMat = edtMat.getText().toString().trim();
            String khamDaLieu = edtDa.getText().toString().trim();
            String khamDinhDuong = edtDinhDuong.getText().toString().trim();
            String khamVanDong = edtVanDong.getText().toString().trim();
            String khamCQKhac = edtCoQuanKhac.getText().toString().trim();
            String khamDanhGia = edtDanhGia.getText().toString().trim();
            String bacSiKham = edtNameOfDoctor.getText().toString().trim();
            String ngayHenKham = edtHenTaiKham.getText().toString().trim();
            Log.d("ggg",ngayHenKham);


            getPresenter().upDate(null, benhsu, mach, nhietdo, huyetAp,
                    null, nhipTho, canNang, chieuCao, vongBung,
                    BMI, null, null, null, null,
                    khamDa, khamNiemMac, khamTTKhac, khamTimMach, khamHoHap, khamTietNieu,
                    khamTieuHoa, khamCXK, khamnoitiet, khamthankinh, khamtamthan, null,
                    null, khamTaiMuiHong, khamRangHamMat, khamMat, khamDaLieu, khamDinhDuong, khamVanDong,
                    khamCQKhac, khamDanhGia, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null, null,
                    null, null, null, null,
                    null, null, null, null,
                    null, arrListInteger, IDbenhVien, bacSiKham, null, ngayHenKham);
        }

    }
}
