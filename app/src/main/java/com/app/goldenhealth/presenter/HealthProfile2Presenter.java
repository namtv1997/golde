package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;


public interface HealthProfile2Presenter extends BasePresenter {
    void getTinhTrangLucSinh();

    void update(int deThuong, int biNgat, int deThieuThang, double canNang,
                double chieuDai, String diTat, String vanDeKhac);
}