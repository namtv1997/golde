package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.ThongTinCaNhan;
import com.app.goldenhealth.presenter.PersonalInfoPresenter;

public interface PersonalInfoView extends BaseView<PersonalInfoPresenter> {

    Context gContext();

    void onGetQRCode(String data);
}
