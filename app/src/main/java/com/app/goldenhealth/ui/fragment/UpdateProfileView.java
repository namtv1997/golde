package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.widget.TextView;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.*;
import com.app.goldenhealth.presenter.UpdateProfilePresenter;

import java.util.ArrayList;

public interface UpdateProfileView extends BaseView<UpdateProfilePresenter> {


    Context gContext();

    void onGetListDanhMuc(ArrayList<DanhMuc> data, DanhMucType danhMucType, TextView btnText, int viewID);

    void onGetListTinh(ArrayList<Tinh> data, boolean ht, int id);

    void onGetListHuyen(ArrayList<Huyen> data, boolean ht);

    void onGetListXa(ArrayList<Xa> data, boolean ht);

    void onGetListThon(ArrayList<Thon> data, boolean ht);

    void onGetInfo(ThongTinCaNhan data);

    void onUpdateSuccess();

    void onFail(String message);
}