package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;
import com.app.goldenhealth.model.DanhMucType;

import java.util.ArrayList;


public interface HealthProfile9Presenter extends BasePresenter {
    void getSKSS();

    void getDanhMuc(DanhMucType danhMucType);

    void update(ArrayList<Integer> bptts, String kyThaiCuoi, int soLanCoThai, int soLanSayThai, int soLanPhaThai, int soLanDeDu,
                int soLanDeNon, int soLanDe, int deThuong, int deMo, int deKho, int soConSong, String benhPhuKhoa);
}