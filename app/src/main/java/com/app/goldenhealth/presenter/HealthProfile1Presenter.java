package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;


public interface HealthProfile1Presenter extends BasePresenter {
    void getThongTinTomTat();

    void update(String nhomMau, double canNang, double chieuCao);
}