package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.presenter.CoSoYTePresenter;

public interface CoSoYTeView extends BaseView<CoSoYTePresenter> {


    Context gContext();

    void onGetBenhVienInfo(BenhVien data);
}