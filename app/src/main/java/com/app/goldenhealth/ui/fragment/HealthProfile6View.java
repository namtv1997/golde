package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.TienSuPhauThuat;
import com.app.goldenhealth.presenter.HealthProfile6Presenter;

import java.util.ArrayList;

public interface HealthProfile6View extends BaseView<HealthProfile6Presenter> {


    Context gContext();

    void onGetInfo(ArrayList<TienSuPhauThuat> data);
}