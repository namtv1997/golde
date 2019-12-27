package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;


public interface ThemTienSuDiUngPresenter extends BasePresenter {
    void create(int loaiDiUng, int loaiQuanHe, String moTa);

    void update(int id, int loaiDiUng, int loaiQuanHe, String moTa);

    void getTienSuDiUng(int id);
}