package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.CauHoiThuongGap;
import com.app.goldenhealth.model.ChuDePhanAnh;
import com.app.goldenhealth.model.DanhMuc;
import com.app.goldenhealth.presenter.TaoPhanAnhPresenter;

import java.util.ArrayList;

public interface TaoPhanAnhView extends BaseView<TaoPhanAnhPresenter> {


    Context gContext();

    void onGetListMucDoCongKhai(ArrayList<DanhMuc> data);

    void onCreateSuccess(Integer data);

    void onCreateFail(String message);

    void onGetCauHoiThuongGap(ArrayList<CauHoiThuongGap> data);

    void onGetChuDePhanAnh(ArrayList<ChuDePhanAnh> data);

    void onUploadImageSuccess();

    void onUploadImageFail(String message);
}