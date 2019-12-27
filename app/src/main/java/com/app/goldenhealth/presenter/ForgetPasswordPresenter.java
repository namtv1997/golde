package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;

public interface ForgetPasswordPresenter extends BasePresenter {
    void forgetPassword(String token, String email, String phone);
}
