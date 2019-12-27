package com.app.goldenhealth.presenter.impl;

import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.presenter.NotificationPresenter;
import com.app.goldenhealth.ui.activity.NotificationView;

public class NotificationPresenterImpl extends BasePresenterImpl<NotificationView> implements NotificationPresenter {

    public NotificationPresenterImpl(NotificationView view) {
        super(view);
    }
}