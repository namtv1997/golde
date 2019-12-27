package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.widget.TextView;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.*;
import com.app.goldenhealth.presenter.ThemHoSoCaNhanPresenter;

import java.util.ArrayList;

public interface ThemHoSoCaNhanView extends BaseView<ThemHoSoCaNhanPresenter> {


    Context gContext();

    void onGetListDanhMuc(ArrayList<DanhMuc> data, DanhMucType danhMucType, TextView btnText, int viewID);

    void onGetListTinh(ArrayList<Tinh> data, boolean ht, int id);

    void onGetListHuyen(ArrayList<Huyen> data, boolean ht);

    void onGetListXa(ArrayList<Xa> data, boolean ht);

    void onGetListThon(ArrayList<Thon> data, boolean ht);
}