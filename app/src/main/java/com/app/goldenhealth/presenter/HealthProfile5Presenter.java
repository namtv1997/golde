package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;


public interface HealthProfile5Presenter extends BasePresenter {
    void getKhuyetTat();

    void update(int thinhLuc, String mtThinhLuc, int thiLuc, String mtThiLuc, int tay, String mtTay
            , int chan, String mtChan, int congVeoCS, String mtCongVeo, int hoMoi, String mtHoMoi, String khac);
}