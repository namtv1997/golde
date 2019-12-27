package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.presenter.CapNhatCSYTPresenter;

public interface CapNhatCSYTView extends BaseView<CapNhatCSYTPresenter> {
    Context gContext();

    void onUpdateSuccess();

    void onUpdateFail(String message);

    void onGetBenhVienInfo(BenhVien data);

    void onUpdateAvatarSuccess();
}
