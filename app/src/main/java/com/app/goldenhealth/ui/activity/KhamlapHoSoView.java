package com.app.goldenhealth.ui.activity;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.HoSoKhamLap;
import com.app.goldenhealth.presenter.KhamLapHoSoPresenter;

public interface KhamlapHoSoView extends BaseView<KhamLapHoSoPresenter> {

    Context gContext();

    void onGetInfo(HoSoKhamLap data);

    void onUpdateSuccess();

    void onFail(String message);
}
