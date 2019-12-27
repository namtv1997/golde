package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;
import com.app.goldenhealth.model.DanhBa;

import java.util.ArrayList;


public interface DanhBaDaLuuPresenter extends BasePresenter {
    void getDanhBa(boolean isRefresh);

    void getDanhBaByKey(String key, boolean isRefresh);

    ArrayList<DanhBa> getListDanhBa();
}