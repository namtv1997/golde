package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;

public interface LoginPresenter extends BasePresenter {
    void login(String username, String password);

    void login2(String username, String password);
}
