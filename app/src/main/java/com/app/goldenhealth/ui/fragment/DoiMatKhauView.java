package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.presenter.DoiMatKhauPresenter;

public interface DoiMatKhauView extends BaseView<DoiMatKhauPresenter> {


    Context gContext();

    void onSuccess();

    void onFail(String message);
}