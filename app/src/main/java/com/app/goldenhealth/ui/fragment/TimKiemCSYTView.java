package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.presenter.TimKiemCSYTPresenter;

import java.util.ArrayList;

public interface TimKiemCSYTView extends BaseView<TimKiemCSYTPresenter> {


    Context gContext();

    void onGetListBenhVienDeXuat(ArrayList<BenhVien> data);

    void onGetListBenhVienGanDay(ArrayList<BenhVien> data);
}