package com.app.goldenhealth.presenter;

import android.widget.TextView;
import com.app.goldenhealth.base.BasePresenter;
import com.app.goldenhealth.model.DanhMucType;


public interface ThemHoSoCaNhanPresenter extends BasePresenter {
    void getDanhMuc(DanhMucType danhMucType, TextView btnText, int viewID);

    void getDanhSachTinh(boolean ht, int id);

    void getDanhSachHuyen(String maTinh, boolean ht);

    void getDanhSachXa(String maHuyen, boolean ht);

    void getDanhSachThon(String maXa, boolean ht);
}