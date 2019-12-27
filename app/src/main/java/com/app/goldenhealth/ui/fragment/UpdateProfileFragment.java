package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.*;
import com.app.goldenhealth.presenter.UpdateProfilePresenter;
import com.app.goldenhealth.presenter.impl.UpdateProfilePresenterImpl;
import com.app.goldenhealth.util.Toolbox;
import com.app.goldenhealth.util.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class UpdateProfileFragment extends BaseFragment<UpdateProfilePresenter> implements UpdateProfileView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.btn_update)
    ImageView btnUpdate;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.edt_ho_ten)
    EditText edtHoTen;
    @BindView(R.id.btn_ngay_sinh)
    TextView btnNgaySinh;
    @BindView(R.id.btn_gioi_tinh)
    TextView btnGioiTinh;
    @BindView(R.id.btn_dan_toc)
    TextView btnDanToc;
    @BindView(R.id.edt_cmnd)
    EditText edtCmnd;
    @BindView(R.id.btn_ngay_cap)
    TextView btnNgayCap;
    @BindView(R.id.edt_noi_cap)
    EditText edtNoiCap;
    @BindView(R.id.edt_ma_y_te_ca_nhan)
    TextView edtMaYTeCaNhan;
    @BindView(R.id.edt_ma_ho_gia_dinh)
    TextView edtMaHoGiaDinh;
    @BindView(R.id.edt_ten_chu_ho)
    TextView edtTenChuHo;
    @BindView(R.id.btn_quan_he_voi_chu_ho)
    TextView btnQuanHeVoiChuHo;
    @BindView(R.id.edt_so_BHYT)
    EditText edtSoBHYT;
    @BindView(R.id.btn_khai_sinh_tinh)
    TextView btnKhaiSinhTinh;
    @BindView(R.id.btn_quoc_tich)
    TextView btnQuocTich;
    @BindView(R.id.btn_ton_giao)
    TextView btnTonGiao;
    @BindView(R.id.btn_nghe_nghiep)
    TextView btnNgheNghiep;
    @BindView(R.id.btn_ht_tinh)
    TextView btnHtTinh;
    @BindView(R.id.btn_ht_huyen)
    TextView btnHtHuyen;
    @BindView(R.id.btn_ht_xa)
    TextView btnHtXa;
    @BindView(R.id.btn_ht_thon)
    TextView btnHtThon;
    @BindView(R.id.edt_dia_chi_hien_tai)
    EditText edtDiaChiHienTai;
    @BindView(R.id.cb_chon_hien_tai_la_thuong_tru)
    CheckBox cbChonHienTaiLaThuongTru;
    @BindView(R.id.btn_tt_tinh)
    TextView btnTtTinh;
    @BindView(R.id.btn_tt_huyen)
    TextView btnTtHuyen;
    @BindView(R.id.btn_tt_xa)
    TextView btnTtXa;
    @BindView(R.id.btn_tt_thon)
    TextView btnTtThon;
    @BindView(R.id.edt_dia_chi_thuong_tru)
    EditText edtDiaChiThuongTru;
    @BindView(R.id.edt_dtcd)
    EditText edtDtcd;
    @BindView(R.id.edt_dtdd)
    EditText edtDtdd;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_ho_ten_bo)
    EditText edtHoTenBo;
    @BindView(R.id.edt_ma_y_te_bo)
    EditText edtMaYTeBo;
    @BindView(R.id.edt_ho_ten_me)
    EditText edtHoTenMe;
    @BindView(R.id.edt_ma_y_te_me)
    EditText edtMaYTeMe;
    @BindView(R.id.edt_ho_ten_nguoi_cs)
    EditText edtHoTenNguoiCs;
    @BindView(R.id.btn_mqh_nguoi_cs)
    TextView btnMqhNguoiCs;
    @BindView(R.id.edt_nguoi_cs_dtcd)
    EditText edtNguoiCsDtcd;
    @BindView(R.id.edt_nguoi_cs_dtdd)
    EditText edtNguoiCsDtdd;
    @BindView(R.id.btn_trinh_do_hoc_van)
    TextView btnTrinhDoHocVan;
    @BindView(R.id.btn_tinh_trang_hon_nhan)
    TextView btnTinhTrangHonNhan;

    private int gioiTinhId = 0;
    private int danTocId = 0;
    private int quanHeChuHoId = 0;
    private int tinhKhaiSinhId = 0;
    private int quocTichId = 0;
    private int tonGiaoId = 0;
    private int ngheNghiepId = 0;
    private int htTinhId = 0;
    private String htTinhMa;
    private int htHuyenId = 0;
    private String htHuyenMa;
    private int htXaId = 0;
    private String htXaMa;
    private int htThonId = 0;
    private int ttTinhId = 0;
    private String ttTinhMa;
    private int ttHuyenId = 0;
    private String ttHuyenMa;
    private int ttXaId = 0;
    private String ttXaMa;
    private int ttThonId = 0;
    private int mqhNguoiCSId = 0;
    private int hocVanId = 0;
    private int honNhanID = 0;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_update_profile;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getThongTinCaNhan();

        cbChonHienTaiLaThuongTru.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btnTtTinh.setText(btnHtTinh.getText().toString());
                    ttTinhId = htTinhId;
                    ttTinhMa = htTinhMa;
                    btnTtHuyen.setText(btnHtHuyen.getText().toString());
                    ttHuyenId = htHuyenId;
                    ttHuyenMa = htHuyenMa;
                    btnTtXa.setText(btnHtXa.getText().toString());
                    ttXaId = htXaId;
                    ttXaMa = htXaMa;
                    btnTtThon.setText(btnHtThon.getText().toString());
                    ttThonId = htThonId;
                }
            }
        });
    }

    @Override
    public UpdateProfilePresenter createPresenter() {
        return new UpdateProfilePresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_update, R.id.btn_ngay_sinh, R.id.btn_gioi_tinh, R.id.btn_dan_toc, R.id.btn_ngay_cap, R.id.btn_khai_sinh_tinh, R.id.btn_quoc_tich, R.id.btn_ton_giao, R.id.btn_nghe_nghiep, R.id.btn_ht_tinh, R.id.btn_ht_huyen, R.id.btn_ht_xa, R.id.btn_ht_thon, R.id.btn_tt_tinh, R.id.btn_tt_huyen, R.id.btn_tt_xa, R.id.btn_tt_thon, R.id.btn_mqh_nguoi_cs, R.id.btn_trinh_do_hoc_van, R.id.btn_tinh_trang_hon_nhan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_update:
                update();
                break;
            case R.id.btn_ngay_sinh:
                Toolbox.selectDate(getContext(), null, new Date(), btnNgaySinh);
                break;
            case R.id.btn_gioi_tinh:
                getPresenter().getDanhMuc(DanhMucType.GioiTinh, btnGioiTinh, view.getId());
                break;
            case R.id.btn_dan_toc:
                getPresenter().getDanhMuc(DanhMucType.DanToc, btnDanToc, view.getId());
                break;
            case R.id.btn_ngay_cap:
                Toolbox.selectDate(getContext(), null, new Date(), btnNgayCap);
                break;
            case R.id.btn_khai_sinh_tinh:
                getPresenter().getDanhSachTinh(true, view.getId());
                break;
            case R.id.btn_quoc_tich:
                getPresenter().getDanhMuc(DanhMucType.QuocGia, btnQuocTich, view.getId());
                break;
            case R.id.btn_ton_giao:
                getPresenter().getDanhMuc(DanhMucType.TonGiao, btnTonGiao, view.getId());
                break;
            case R.id.btn_nghe_nghiep:
                getPresenter().getDanhMuc(DanhMucType.NgheNghiep, btnNgheNghiep, view.getId());
                break;
            case R.id.btn_ht_tinh:
                getPresenter().getDanhSachTinh(true, view.getId());
                break;
            case R.id.btn_ht_huyen:
                if (htTinhId == 0) {
                    Util.showMessenger("Vui lòng chọn tỉnh/thành phố trước!", getContext());
                } else {
                    getPresenter().getDanhSachHuyen(htTinhMa, true);
                }
                break;
            case R.id.btn_ht_xa:
                if (htHuyenId == 0) {
                    Util.showMessenger("Vui lòng chọn tỉnh/thành phố và quận/huyện trước!", getContext());
                } else {
                    getPresenter().getDanhSachXa(htHuyenMa, true);
                }
                break;
            case R.id.btn_ht_thon:
                if (htXaId == 0) {
                    Util.showMessenger("Vui lòng chọn tỉnh/thành phố, quận/huyện và xã/phường trước!", getContext());
                } else {
                    getPresenter().getDanhSachThon(htXaMa, true);
                }
                break;
            case R.id.btn_tt_tinh:
                getPresenter().getDanhSachTinh(false, view.getId());
                break;
            case R.id.btn_tt_huyen:
                if (ttTinhId == 0) {
                    Util.showMessenger("Vui lòng chọn tỉnh/thành phố trước!", getContext());
                } else {
                    getPresenter().getDanhSachHuyen(String.valueOf(ttTinhMa), false);
                }
                break;
            case R.id.btn_tt_xa:
                if (ttHuyenId == 0) {
                    Util.showMessenger("Vui lòng chọn tỉnh/thành phố và quận/huyện trước!", getContext());
                } else {
                    getPresenter().getDanhSachXa(String.valueOf(ttHuyenMa), false);
                }
                break;
            case R.id.btn_tt_thon:
                if (ttXaId == 0) {
                    Util.showMessenger("Vui lòng chọn tỉnh/thành phố, quận/huyện và xã/phường trước!", getContext());
                } else {
                    getPresenter().getDanhSachThon(String.valueOf(ttXaMa), false);
                }
                break;
            case R.id.btn_mqh_nguoi_cs:
                getPresenter().getDanhMuc(DanhMucType.QHGiaDinh, btnMqhNguoiCs, view.getId());
                break;
            case R.id.btn_trinh_do_hoc_van:
                getPresenter().getDanhMuc(DanhMucType.HocVan, btnTrinhDoHocVan, view.getId());
                break;
            case R.id.btn_tinh_trang_hon_nhan:
                getPresenter().getDanhMuc(DanhMucType.TinhTrangHonNhan, btnTinhTrangHonNhan, view.getId());
                break;
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetListDanhMuc(ArrayList<DanhMuc> data, DanhMucType danhMucType, TextView btnText, int viewID) {
        String[] list = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            list[i] = data.get(i).getTEN();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chọn ")
                .setItems(list, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        btnText.setText(list[which]);
                        switch (viewID) {
                            case R.id.btn_gioi_tinh:
                                gioiTinhId = data.get(which).getID();
                                break;
                            case R.id.btn_dan_toc:
                                danTocId = data.get(which).getID();
                                break;
                            case R.id.btn_quan_he_voi_chu_ho:
                                quanHeChuHoId = data.get(which).getID();
                                break;
                            case R.id.btn_quoc_tich:
                                quocTichId = data.get(which).getID();
                                break;
                            case R.id.btn_ton_giao:
                                tonGiaoId = data.get(which).getID();
                                break;
                            case R.id.btn_nghe_nghiep:
                                ngheNghiepId = data.get(which).getID();
                                break;
                            case R.id.btn_mqh_nguoi_cs:
                                mqhNguoiCSId = data.get(which).getID();
                                break;
                            case R.id.btn_trinh_do_hoc_van:
                                hocVanId = data.get(which).getID();
                                break;
                            case R.id.btn_tinh_trang_hon_nhan:
                                honNhanID = data.get(which).getID();
                                break;
                        }
                    }
                }).create().show();
    }

    @Override
    public void onGetListTinh(ArrayList<Tinh> data, boolean ht, int id) {
        String[] list = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            list[i] = data.get(i).getTEN();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chọn Tỉnh/Thành phố")
                .setItems(list, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (id == R.id.btn_khai_sinh_tinh) {
                            btnKhaiSinhTinh.setText(data.get(which).getTEN());
                            tinhKhaiSinhId = data.get(which).getID();
                        } else {
                            if (ht) {
                                btnHtTinh.setText(data.get(which).getTEN());
                                htTinhId = data.get(which).getID();
                                htTinhMa = data.get(which).getMA();
                            } else {
                                btnTtTinh.setText(data.get(which).getTEN());
                                ttTinhId = data.get(which).getID();
                                ttTinhMa = data.get(which).getMA();
                            }
                        }

                    }
                }).create().show();
    }

    @Override
    public void onGetListHuyen(ArrayList<Huyen> data, boolean ht) {
        String[] list = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            list[i] = data.get(i).getTEN();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chọn Quận/Huyện")
                .setItems(list, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (ht) {
                            btnHtHuyen.setText(data.get(which).getTEN());
                            htHuyenId = data.get(which).getID();
                            htHuyenMa = data.get(which).getMA();
                        } else {
                            btnTtHuyen.setText(data.get(which).getTEN());
                            ttHuyenId = data.get(which).getID();
                            ttHuyenMa = data.get(which).getMA();
                        }

                    }
                }).create().show();
    }

    @Override
    public void onGetListXa(ArrayList<Xa> data, boolean ht) {
        String[] list = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            list[i] = data.get(i).getTEN();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chọn Xã/Phường")
                .setItems(list, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (ht) {
                            btnHtXa.setText(data.get(which).getTEN());
                            htXaId = data.get(which).getID();
                            htXaMa = data.get(which).getMA();
                        } else {
                            btnTtXa.setText(data.get(which).getTEN());
                            ttXaId = data.get(which).getID();
                            ttXaMa = data.get(which).getMA();
                        }

                    }
                }).create().show();
    }

    @Override
    public void onGetListThon(ArrayList<Thon> data, boolean ht) {
        String[] list = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            list[i] = data.get(i).getTEN();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chọn Thôn Xóm")
                .setItems(list, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (ht) {
                            btnHtThon.setText(data.get(which).getTEN());
                            htThonId = data.get(which).getID();
                        } else {
                            btnTtThon.setText(data.get(which).getTEN());
                            ttThonId = data.get(which).getID();
                        }

                    }
                }).create().show();
    }

    @Override
    public void onGetInfo(ThongTinCaNhan data) {
        edtHoTen.setText(data.getHOTEN());
        btnNgaySinh.setText(data.getNGAYSINH());
        btnGioiTinh.setText(data.getGIOITINH());
        gioiTinhId = data.getGIOITINHID();
        btnDanToc.setText(data.getDANTOC());
        danTocId = data.getDANTOCID();
        edtCmnd.setText(data.getSOCMND());
        btnNgayCap.setText(data.getNGAYCAP());
        edtNoiCap.setText(data.getNOICAP());
        edtMaYTeCaNhan.setText(data.getMAYTECANHAN());
        edtMaHoGiaDinh.setText(data.getMAHOGIADINH());
        edtTenChuHo.setText(data.getTENCHUHO());
        btnQuanHeVoiChuHo.setText(data.getQUANHEVOICHUHO());
        quanHeChuHoId = data.getQUANHEVOICHUHOID();
        edtSoBHYT.setText(data.getMATHEBHYT());
        btnKhaiSinhTinh.setText(data.getKSTINH());
        tinhKhaiSinhId = data.getKSTINHID();
        btnQuocTich.setText(data.getQUOCTICH());
        quocTichId = data.getQUOCTICHID();
        btnTonGiao.setText(data.getTONGIAO());
        tonGiaoId = data.getTONGIAOID();
        btnNgheNghiep.setText(data.getNGHENGHIEP());
        ngheNghiepId = data.getNGHENGHIEPID();
        edtDiaChiHienTai.setText(data.getHTDIACHICHITIET());
        btnHtTinh.setText(data.getHTTINH());
        htTinhId = data.getHTTINHID();
        htTinhMa = data.getHTTINHMA();
        btnHtHuyen.setText(data.getHTHUYEN());
        htHuyenId = data.getHTHUYENID();
        htHuyenMa = data.getHTHUYENMA();
        btnHtXa.setText(data.getHTXA());
        htXaId = data.getHTXAID();
        htXaMa = data.getHTXAMA();
        btnHtThon.setText(data.getHTTHONXOM());
        htThonId = data.getHTTHONXOMID();
        edtDiaChiThuongTru.setText(data.getTTDIACHICHITIET());
        btnTtTinh.setText(data.getTTTINH());
        ttTinhId = data.getTTTINHID();
        ttTinhMa = data.getTTTINHMA();
        btnTtHuyen.setText(data.getTTHUYEN());
        ttHuyenId = data.getTTHUYENID();
        ttHuyenMa = data.getTTHUYENMA();
        btnTtXa.setText(data.getTTXA());
        ttXaId = data.getTTXAID();
        ttXaMa = data.getTTXAMA();
        btnTtThon.setText(data.getTTTHONXOM());
        ttThonId = data.getTTTHONXOMID();
        edtDtcd.setText(data.getDIENTHOAINR());
        edtDtdd.setText(data.getDIENTHOAIDD());
        edtEmail.setText(data.getEMAIL());
        edtHoTenBo.setText(data.getHOTENBO());
        edtMaYTeBo.setText(data.getMAYTBO());
        edtHoTenMe.setText(data.getHOTENME());
        edtMaYTeMe.setText(data.getMAYTME());
        edtHoTenNguoiCs.setText(data.getNGUOICHAMSOC());
        btnMqhNguoiCs.setText(data.getQHNGUOICS());
        mqhNguoiCSId = data.getQHNGUOICSID();
        edtNguoiCsDtcd.setText(data.getNCSDTNR());
        edtNguoiCsDtdd.setText(data.getNCSDTDD());
        btnTrinhDoHocVan.setText(data.getHOCVAN());
        hocVanId = data.getHOCVANID();
        btnTinhTrangHonNhan.setText(data.getHONNHAN());
        honNhanID = data.getTTHONNHANID();
    }

    private void update() {
        String hoten = edtHoTen.getText().toString();
        String ngaySinh = btnNgaySinh.getText().toString();
        String soCMND = edtCmnd.getText().toString();
        String ngayCap = btnNgayCap.getText().toString();
        String noiCap = edtNoiCap.getText().toString();
        String soTheMHYT = edtSoBHYT.getText().toString();
        String ttChiTiet = edtDiaChiThuongTru.getText().toString();
        String htChiTiet = edtDiaChiHienTai.getText().toString();
        String dtcd = edtDtcd.getText().toString();
        String dtdd = edtDtdd.getText().toString();
        String email = edtEmail.getText().toString();
        String hoTenBo = edtHoTenBo.getText().toString();
        String maYTeBo = edtMaYTeBo.getText().toString();
        String hoTenMe = edtMaYTeMe.getText().toString();
        String maYTeMe = edtMaYTeMe.getText().toString();
        String hoTenNguoiCS = edtHoTenNguoiCs.getText().toString();
        String dtcdNCS = edtNguoiCsDtcd.getText().toString();
        String dtddNCS = edtNguoiCsDtdd.getText().toString();

        getPresenter().updateProfile(hoten, ngaySinh, hoTenBo, hoTenMe, maYTeBo, maYTeMe, hoTenNguoiCS,
                soCMND, ngayCap, noiCap, ttChiTiet, htChiTiet, dtcd, dtdd, email, mqhNguoiCSId, hocVanId,
                ngheNghiepId, danTocId, ttTinhId, ttHuyenId, ttXaId, ttThonId, htTinhId, htHuyenId, htXaId,
                htThonId, quocTichId, gioiTinhId, honNhanID, tinhKhaiSinhId, tonGiaoId, dtcdNCS, dtddNCS, soTheMHYT);
    }

    @Override
    public void onUpdateSuccess() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Thông báo");
        builder.setMessage(getString(R.string.update_sucsess));
        builder.setCancelable(false);
        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, getContext());
    }
}