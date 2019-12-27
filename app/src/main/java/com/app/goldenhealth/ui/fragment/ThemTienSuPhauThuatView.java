package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.TienSuPhauThuat;
import com.app.goldenhealth.presenter.ThemTienSuPhauThuatPresenter;

public interface ThemTienSuPhauThuatView extends BaseView<ThemTienSuPhauThuatPresenter> {


    Context gContext();

    void onCreateSuccess();

    void onFail(String message);

    void onGetInfo(TienSuPhauThuat data);
}