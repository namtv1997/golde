package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;
import com.app.goldenhealth.model.DanhMucType;

public interface HomePresenter extends BasePresenter {
    void getDanhMuc(DanhMucType danhMucType);

    void getNumberNotifiUnread();

    void getDashboard();
}
