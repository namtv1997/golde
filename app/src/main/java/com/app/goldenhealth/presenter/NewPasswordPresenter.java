package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;

public interface NewPasswordPresenter extends BasePresenter {
    void changePassword(String token, String uid, String password);
}
