package com.app.goldenhealth.base;

public interface BaseView<BPresenter extends BasePresenter> {
    BPresenter getPresenter();

    BPresenter createPresenter();

}
