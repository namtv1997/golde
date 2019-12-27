package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.BenhNhan;
import com.app.goldenhealth.presenter.YBaPresenter;

import java.util.ArrayList;

public interface YBaView extends BaseView<YBaPresenter> {


    Context gContext();

    void onGetListBenhNhan(ArrayList<BenhNhan> data);

    void onGetDataFailed(String message);
}