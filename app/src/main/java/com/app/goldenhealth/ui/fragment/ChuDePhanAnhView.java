package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.ChuDePhanAnh;
import com.app.goldenhealth.presenter.ChuDePhanAnhPresenter;

import java.util.ArrayList;

public interface ChuDePhanAnhView extends BaseView<ChuDePhanAnhPresenter> {

    Context gContext();

    void onGetChuDePhanAnh(ArrayList<ChuDePhanAnh> data);
}