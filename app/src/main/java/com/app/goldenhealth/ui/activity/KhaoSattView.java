package com.app.goldenhealth.ui.activity;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.KhaoSatCauHoi;
import com.app.goldenhealth.presenter.KhaoSattPresenter;

import java.util.ArrayList;

public interface KhaoSattView extends BaseView<KhaoSattPresenter> {


    Context gContext();

    void onGetListCauHoi(ArrayList<KhaoSatCauHoi> data);
}