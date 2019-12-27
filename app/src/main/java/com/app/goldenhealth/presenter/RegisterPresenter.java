package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;
import com.app.goldenhealth.model.DanhMucType;
import com.app.goldenhealth.model.Token;

public interface RegisterPresenter extends BasePresenter {
    void checkExistUsername(Token token, String username);

    void checkExistPhone(Token token, String phone);

    void checkExistEmail(Token token, String email);

    void register(Token token, String name, String birthday, String phone, String email, String username, String password,
                  int roleId, String maBS, int benhVienID, String diaChi);

    void getDanhMuc(String token, DanhMucType danhMucType);
}
