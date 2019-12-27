package com.app.goldenhealth.ui.activity;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.DanhMuc;
import com.app.goldenhealth.model.Token;
import com.app.goldenhealth.presenter.RegisterPresenter;

import java.util.ArrayList;

public interface RegisterView extends BaseView<RegisterPresenter> {
    Context gContext();

    void onFailure(String s);

    void onUserNameIsExist(Boolean data);

    void onPhoneIsExist(Boolean data);

    void onEmailIsExist(Boolean data);

    void onGetToken(Token token);

    void registerSuccess(String data);

    void onGetListDanhMuc(ArrayList<DanhMuc> data);
}
