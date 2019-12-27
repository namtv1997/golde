package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;


public interface ValidateVerifyCodePresenter extends BasePresenter {
    void validateVerifyCode(String token, String uid, String code);

    void resendVerifyCode(String token, String uid);
}