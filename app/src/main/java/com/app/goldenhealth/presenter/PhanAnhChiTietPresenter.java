package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;

import java.util.ArrayList;

public interface PhanAnhChiTietPresenter extends BasePresenter {

    void getPhanAnhById(int id);

    void addComment(int id, String noiDung, String hoten, String sdt, String email, String diaChi, ArrayList<String> images);

    void uploadImageComment(int id, ArrayList<String> images);

    void addDanhGia(int id, float danhGia, String hoten, String sdt, String email, String diaChi);

    void traLoiPhanAnh(int id, String noiDung);
}