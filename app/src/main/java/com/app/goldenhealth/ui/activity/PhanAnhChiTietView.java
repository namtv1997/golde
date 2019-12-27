package com.app.goldenhealth.ui.activity;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.PhanAnh;
import com.app.goldenhealth.presenter.PhanAnhChiTietPresenter;

import java.text.ParseException;

public interface PhanAnhChiTietView extends BaseView<PhanAnhChiTietPresenter> {

    Context gContext();

    void onGetPhanAnh(PhanAnh data) throws ParseException;

    void onCommentSuccess();

    void onUploadImageFail(String message);

    void onDanhGiaSuccess();

    void onDanhGiaFail(String message);

    void onTraLoiSuccess();
}