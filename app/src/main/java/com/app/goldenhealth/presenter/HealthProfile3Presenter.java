package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;


public interface HealthProfile3Presenter extends BasePresenter {
    void getYeuToNguyCo();

    void getHoXi();

    void update(int hutThuoc, int hutLienTuc, int daBoThuoc, int uongRuouBia,
                double donViRuou, int daBoRuou, int suDungMaTuy, int dungMaTuyLienTuc,
                int daBoMaTuy, int hoatDongTheLuc, int thuongXuyenTapTheDuc,
                String moiTruong, double thoiGianTiepXuc, int loaiHoXi, String nguyCoNN,
                String nguyCoKhac);
}