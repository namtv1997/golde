package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;


public interface DoiMatKhauPresenter extends BasePresenter {
    void changePassword(String token, String uid, String password);
}