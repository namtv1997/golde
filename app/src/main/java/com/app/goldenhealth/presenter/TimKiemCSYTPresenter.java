package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;


public interface TimKiemCSYTPresenter extends BasePresenter {
    void getBenhVienDeXuat(String diaDiem);

    void getBenhVienGanDay(String diaDiem);
}