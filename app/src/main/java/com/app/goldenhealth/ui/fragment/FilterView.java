package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.TimKiemLoc;
import com.app.goldenhealth.presenter.FilterPresenter;

import java.util.ArrayList;

public interface FilterView extends BaseView<FilterPresenter> {
    Context gContext();

    void onGetLoaiTimKiem(ArrayList<TimKiemLoc> data);

    void onGetTimKiemUuTien(ArrayList<TimKiemLoc> data);
}
