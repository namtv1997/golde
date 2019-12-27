package com.app.goldenhealth.presenter.impl;

import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.presenter.EmptyPresenter;
import com.app.goldenhealth.ui.fragment.EmptyView;

public class EmptyPresenterImpl extends BasePresenterImpl<EmptyView> implements EmptyPresenter {

    public EmptyPresenterImpl(EmptyView view) {
        super(view);
    }
}