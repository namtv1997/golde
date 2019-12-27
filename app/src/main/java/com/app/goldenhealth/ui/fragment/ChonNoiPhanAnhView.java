package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.DiaDiemPhanAnh;
import com.app.goldenhealth.presenter.ChonNoiPhanAnhPresenter;

import java.util.ArrayList;

public interface ChonNoiPhanAnhView extends BaseView<ChonNoiPhanAnhPresenter> {

    Context gContext();

    void onGetDiaDiemPhanAnh(ArrayList<DiaDiemPhanAnh> data);
}