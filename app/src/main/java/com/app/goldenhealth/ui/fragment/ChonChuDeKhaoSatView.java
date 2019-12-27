package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.ChuDeKhaoSat;
import com.app.goldenhealth.presenter.ChonChuDeKhaoSatPresenter;

import java.util.ArrayList;

public interface ChonChuDeKhaoSatView extends BaseView<ChonChuDeKhaoSatPresenter> {


    Context gContext();

    void onGetListChuDeKS(ArrayList<ChuDeKhaoSat> data);
}