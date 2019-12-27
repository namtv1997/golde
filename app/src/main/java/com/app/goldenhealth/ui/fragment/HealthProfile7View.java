package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.TienSuBenh;
import com.app.goldenhealth.model.TienSuDiUng;
import com.app.goldenhealth.presenter.HealthProfile7Presenter;

import java.util.ArrayList;

public interface HealthProfile7View extends BaseView<HealthProfile7Presenter> {


    Context gContext();

    void onGetTienSuDiUng(ArrayList<TienSuDiUng> data);

    void onGetTienSuBenh(ArrayList<TienSuBenh> data);
}