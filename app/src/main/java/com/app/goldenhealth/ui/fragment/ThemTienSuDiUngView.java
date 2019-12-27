package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.DiUng;
import com.app.goldenhealth.model.QuanHeGiaDinh;
import com.app.goldenhealth.model.TienSuDiUng;
import com.app.goldenhealth.presenter.ThemTienSuDiUngPresenter;

import java.util.ArrayList;

public interface ThemTienSuDiUngView extends BaseView<ThemTienSuDiUngPresenter> {


    Context gContext();

    void onGetDanhSachDiUng(ArrayList<DiUng> data);

    void onGetQuanHeGiaDinh(ArrayList<QuanHeGiaDinh> data);

    void onCreateSuccess();

    void onFail(String message);

    void onGetTienSuDiUng(TienSuDiUng data);
}