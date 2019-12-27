package com.app.goldenhealth.presenter.impl;

import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.presenter.HealthProfilePresenter;
import com.app.goldenhealth.ui.activity.HealthProfileView;

public class HealthProfilePresenterImpl extends BasePresenterImpl<HealthProfileView> implements HealthProfilePresenter {

    public HealthProfilePresenterImpl(HealthProfileView view) {
        super(view);
    }
}