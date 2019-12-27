package com.app.goldenhealth.ui.activity;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.PhanAnh;
import com.app.goldenhealth.presenter.PhanAnhMoiNguoiPresenter;

import java.util.ArrayList;

public interface PhanAnhMoiNguoiView extends BaseView<PhanAnhMoiNguoiPresenter> {
    Context gContext();

    void onGetListPhanAnh(ArrayList<PhanAnh> data);

    void onTraLoiSuccess();
}
