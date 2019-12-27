package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.TimKiem;
import com.app.goldenhealth.model.TimKiemLoc;
import com.app.goldenhealth.presenter.SearchPresenter;

import java.util.ArrayList;

public interface SearchView extends BaseView<SearchPresenter> {
    Context gContext();

    void onGetData(ArrayList<TimKiem> data);

    void onSearchFail(String message);

    void onGetLoaiTimKiem(ArrayList<TimKiemLoc> data);

    void onGetTimKiemUuTien(ArrayList<TimKiemLoc> data);
}
