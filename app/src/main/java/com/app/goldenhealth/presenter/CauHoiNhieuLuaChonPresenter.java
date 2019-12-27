package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;

import java.util.ArrayList;


public interface CauHoiNhieuLuaChonPresenter extends BasePresenter {
    void traLoi(int cauHoiId, ArrayList<Integer> dapAns);
}