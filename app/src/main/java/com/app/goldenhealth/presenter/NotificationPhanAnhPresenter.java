package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;
import com.app.goldenhealth.model.ThongBao;

import java.util.ArrayList;


public interface NotificationPhanAnhPresenter extends BasePresenter {

    void getThongBao(int group, boolean isRefresh);

    void updateThongBao(int id);

    ArrayList<ThongBao> getListThongBao();
}