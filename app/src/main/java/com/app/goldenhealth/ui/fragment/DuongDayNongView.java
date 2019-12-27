package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.LienKetMangXaHoi;
import com.app.goldenhealth.presenter.DuongDayNongPresenter;

public interface DuongDayNongView extends BaseView<DuongDayNongPresenter> {


    Context gContext();

    void onGetLienKetMXH(LienKetMangXaHoi data);
}