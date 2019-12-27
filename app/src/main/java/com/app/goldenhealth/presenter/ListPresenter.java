package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;
import com.app.goldenhealth.model.BenhVien;

import java.util.ArrayList;

public interface ListPresenter extends BasePresenter {

    void getBenhVien(String token, boolean isRefresh);

    ArrayList<BenhVien> getArrayList();
}