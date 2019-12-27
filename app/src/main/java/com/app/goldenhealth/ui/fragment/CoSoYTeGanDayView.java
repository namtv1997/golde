package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.presenter.CoSoYTeGanDayPresenter;

import java.util.ArrayList;

public interface CoSoYTeGanDayView extends BaseView<CoSoYTeGanDayPresenter> {
    Context gContext();

    void onGetListBenhVienGanDay(ArrayList<BenhVien> data);
}
