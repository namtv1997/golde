package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.GroupLichSuKhamChuaBenh;
import com.app.goldenhealth.presenter.LichSuKhamChuaBenhPresenter;

import java.util.ArrayList;

public interface LichSuKhamChuaBenhView extends BaseView<LichSuKhamChuaBenhPresenter> {


    Context gContext();

    void onGetLichSuKhamChua(ArrayList<GroupLichSuKhamChuaBenh> data);
}