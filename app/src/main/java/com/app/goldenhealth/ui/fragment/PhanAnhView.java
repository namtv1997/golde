package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.ChuDePhanAnh;
import com.app.goldenhealth.presenter.PhanAnhPresenter;

import java.util.ArrayList;

public interface PhanAnhView extends BaseView<PhanAnhPresenter> {

    Context gContext();

    void onGetChuDePhanAnh(ArrayList<ChuDePhanAnh> data);

    void onGetDataFail();

    void onGetListPhanAnh();
}