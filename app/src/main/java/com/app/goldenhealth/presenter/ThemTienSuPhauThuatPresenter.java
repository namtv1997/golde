package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;


public interface ThemTienSuPhauThuatPresenter extends BasePresenter {

    void create(String boPhan, int nam, String moTa, String moiPt);

    void upadte(int id, String boPhan, int nam, String moTa, String noiPt);

    void getTienSuPhauThuat(int id);
}