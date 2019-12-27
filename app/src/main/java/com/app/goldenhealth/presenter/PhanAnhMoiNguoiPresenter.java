package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;

public interface PhanAnhMoiNguoiPresenter extends BasePresenter {
    void getPhanAnhById(int id);

    void getPhanAnh();

    void getPhanAnhMoiNguoi(int id);

    void getPhanAnhCSYT();

    void traLoiPhanAnh(int id, String noiDung);

    void addComment(int id, String noiDung);
}
