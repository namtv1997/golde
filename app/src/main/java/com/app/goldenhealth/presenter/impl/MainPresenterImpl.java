package com.app.goldenhealth.presenter.impl;

import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.presenter.MainPresenter;
import com.app.goldenhealth.ui.activity.MainView;

public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter {
    public MainPresenterImpl(MainView view) {
        super(view);
    }
}
