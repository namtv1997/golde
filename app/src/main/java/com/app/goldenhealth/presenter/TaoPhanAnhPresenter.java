package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;
import com.app.goldenhealth.model.DanhMucType;

import java.util.ArrayList;


public interface TaoPhanAnhPresenter extends BasePresenter {
    void getDanhMuc(DanhMucType danhMucType);

    void createPhanAnh(String tieuDe, int chuDe, int noiPA, String noiDung, int mucDoCongKhai, String hoTen, String SDT,
                       String email, String diaChi);

    void getCauHoiThuongGap();

    void getChuDePhanAnh();

    void updateAnh(int id, ArrayList<String> images);
}