package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.LoaiBenh;
import com.app.goldenhealth.model.QuanHeGiaDinh;
import com.app.goldenhealth.model.TienSuBenh;
import com.app.goldenhealth.presenter.ThemTienSuBenhPresenter;

import java.util.ArrayList;

public interface ThemTienSuBenhView extends BaseView<ThemTienSuBenhPresenter> {


    Context gContext();

    void onGetDanhSachBenh(ArrayList<LoaiBenh> data);

    void onGetQuanHeGiaDinh(ArrayList<QuanHeGiaDinh> data);

    void onCreateSuccess();

    void onFail(String message);

    void onGetTienSuBenh(TienSuBenh data);
}