package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.ThongTinCaNhan;
import com.app.goldenhealth.presenter.ProfilePresenter;

public interface ProfileView extends BaseView<ProfilePresenter> {


    Context gContext();

    void onGetInfo(ThongTinCaNhan data);
}