package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;

public interface Login2Presenter extends BasePresenter {

    void login2(String username, String password);
    void loginMXH(String username,String password, int type);
    void registerMXH(String FullName,String phone,String emailID,int roleId,String avatar,String ID_Facebook,String ID_Google,String ID_Zalo);

}