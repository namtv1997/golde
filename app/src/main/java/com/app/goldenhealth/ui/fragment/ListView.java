package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.presenter.ListPresenter;

public interface ListView extends BaseView<ListPresenter> {

    Context gContext();

    void onGetListBenhVien();
}