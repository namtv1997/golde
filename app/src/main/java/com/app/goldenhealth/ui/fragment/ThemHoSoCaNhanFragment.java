package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import com.app.goldenhealth.model.*;
import com.app.goldenhealth.presenter.ThemHoSoCaNhanPresenter;
import com.app.goldenhealth.presenter.impl.ThemHoSoCaNhanPresenterImpl;
import com.app.goldenhealth.util.Toolbox;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ThemHoSoCaNhanFragment extends BaseFragment<ThemHoSoCaNhanPresenter> implements ThemHoSoCaNhanView {


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
    @BindView(R.id.edt_ma_y_te_ca_nhan)
    EditText edtMaYTeCaNhan;
    @BindView(R.id.btn_khai_sinh_tinh)
    TextView btnKhaiSinhTinh;
    @BindView(R.id.btn_dan_toc)
    TextView btnDanToc;
    @BindView(R.id.btn_quoc_tich)
    TextView btnQuocTich;
    @BindView(R.id.btn_ton_giao)
    TextView btnTonGiao;
    @BindView(R.id.btn_nghe_nghiep)
    TextView btnNgheNghiep;
    @BindView(R.id.edt_cmnd)
    EditText edtCmnd;
    @BindView(R.id.edt_dia_chi_hien_tai)
    EditText edtDiaChiHienTai;
    @BindView(R.id.edt_dia_chi_thuong_tru)
    EditText edtDiaChiThuongTru;
    @BindView(R.id.edt_dtdd)
    EditText edtDtdd;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.btn_trinh_do_hoc_van)
    TextView btnTrinhDoHocVan;
    @BindView(R.id.btn_tinh_trang_hon_nhan)
    TextView btnTinhTrangHonNhan;
    Unbinder unbinder;

    private int gioiTinhId = 0;
    private int danTocId = 0;
    private int quanHeChuHoId = 0;
    private int tinhKhaiSinhId = 0;
    private int quocTichId = 0;
    private int tonGiaoId = 0;
    private int ngheNghiepId = 0;
    private int hocVanId = 0;
    private int honNhanID = 0;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_them_ho_so_ca_nhan;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public ThemHoSoCaNhanPresenter createPresenter() {
        return new ThemHoSoCaNhanPresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_update, R.id.btn_ngay_sinh, R.id.btn_gioi_tinh, R.id.btn_khai_sinh_tinh, R.id.btn_dan_toc, R.id.btn_quoc_tich, R.id.btn_ton_giao, R.id.btn_nghe_nghiep, R.id.btn_trinh_do_hoc_van, R.id.btn_tinh_trang_hon_nhan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_update:
                break;
            case R.id.btn_ngay_sinh:
                Toolbox.selectDate(getContext(), null, new Date(), btnNgaySinh);
                break;
            case R.id.btn_gioi_tinh:
                getPresenter().getDanhMuc(DanhMucType.GioiTinh, btnGioiTinh, view.getId());
                break;
            case R.id.btn_khai_sinh_tinh:
                getPresenter().getDanhSachTinh(true, view.getId());
                break;
            case R.id.btn_dan_toc:
                getPresenter().getDanhMuc(DanhMucType.DanToc, btnDanToc, view.getId());
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
                        }
                    }
                }).create().show();
    }

    @Override
    public void onGetListHuyen(ArrayList<Huyen> data, boolean ht) {

    }

    @Override
    public void onGetListXa(ArrayList<Xa> data, boolean ht) {

    }

    @Override
    public void onGetListThon(ArrayList<Thon> data, boolean ht) {

    }
}