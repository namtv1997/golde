package com.app.goldenhealth.base;


public class BasePresenterImpl<BView extends BaseView> implements BasePresenter {
    private BView view;

    public BasePresenterImpl(BView view) {
        this.view = view;
    }

    public BView getView() {
        return view;
    }

}
