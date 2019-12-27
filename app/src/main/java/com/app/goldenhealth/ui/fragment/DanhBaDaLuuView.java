package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.presenter.DanhBaDaLuuPresenter;

public interface DanhBaDaLuuView extends BaseView<DanhBaDaLuuPresenter> {


    Context gContext();

    void onGetListDanhBa();

    void onGetDataFail();
}