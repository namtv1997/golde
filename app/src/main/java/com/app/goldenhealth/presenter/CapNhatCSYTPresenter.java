package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;

import java.util.ArrayList;

public interface CapNhatCSYTPresenter extends BasePresenter {

    void updateBenhVien(String ten, String diaChi,
                        String website, String hotline, String thoiGian, String email, String thanhTich,
                        ArrayList<Integer> dmKhoa);

    void getBenhVienInfo(int id);

    void updateAvatar(String image);
}
