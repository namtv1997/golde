package com.app.goldenhealth.presenter;

import android.widget.TextView;
import com.app.goldenhealth.base.BasePresenter;
import com.app.goldenhealth.model.DanhMucType;


public interface UpdateProfilePresenter extends BasePresenter {
    void getThongTinCaNhan();

    void getDanhMuc(DanhMucType danhMucType, TextView btnText, int viewID);

    void getDanhSachTinh(boolean ht, int id);

    void getDanhSachHuyen(String maTinh, boolean ht);

    void getDanhSachXa(String maHuyen, boolean ht);

    void getDanhSachThon(String maXa, boolean ht);

    void updateProfile(String hoten, String ngaySinh, String hoTenBo, String hoTenMe, String maYTeBo,
                       String maYTeMe, String nguoiChamSoc, String soCMND, String ngayCap, String noiCap,
                       String ttChiTiet, String htChiTiet, String DTCD, String DTDD, String email, int mqhNguoCsId,
                       int hocVanId, int ngheNghiepId, int danTocId, int ttTinhID, int ttHuyenID,
                       int ttXaId, int ttThonID, int htTinhId, int htHuyenId, int htXaId, int htThonId, int quocTichId,
                       int gioiTinhId, int honNhanId, int tinhKSID, int tonGiaoId, String dtcdNCS, String dtddNCS,
                       String maTheBHYT);
}