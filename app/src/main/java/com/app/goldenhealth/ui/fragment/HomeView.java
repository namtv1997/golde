package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.Dashboard;
import com.app.goldenhealth.presenter.HomePresenter;

public interface HomeView extends BaseView<HomePresenter> {
    Context gContext();

    void onGetNumberNotifiUnread(Integer data);

    void onGetDashboard(Dashboard data);
}
