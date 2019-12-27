package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;


public interface HealthProfile4Presenter extends BasePresenter {
    void getTienSuBenhTat();

    void update(int timMach, int daiThaoDuong, int phoiManTinh, int buouCo,
                int timBamSinh, int tuKy, int tangHuyetAp, int daDay,
                int henXuyen, int viemGan, int tamThan, int dongKinh,
                String ungThu, String lao, String khac, String duThuoc, String duHoaChat,
                String duThucPham, String duKhac);
}