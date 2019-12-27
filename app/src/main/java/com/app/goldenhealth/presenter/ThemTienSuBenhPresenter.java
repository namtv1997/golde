package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;


public interface ThemTienSuBenhPresenter extends BasePresenter {
    void create(int loaiBenh, int loaiQuanHe, String moTa);

    void update(int id, int loaiBenh, int loaiQuanHe, String moTa);

    void getTienSuBenh(int id);
}