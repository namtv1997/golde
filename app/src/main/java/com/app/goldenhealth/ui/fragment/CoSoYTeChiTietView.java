package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.presenter.CoSoYTeChiTietPresenter;

public interface CoSoYTeChiTietView extends BaseView<CoSoYTeChiTietPresenter> {


    Context gContext();

    void onGetBenhVienInfo(BenhVien data);
}