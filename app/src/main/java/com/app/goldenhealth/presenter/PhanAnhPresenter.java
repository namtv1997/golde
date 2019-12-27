package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;
import com.app.goldenhealth.model.PhanAnh;

import java.util.ArrayList;

public interface PhanAnhPresenter extends BasePresenter {

    void getChuDePhanAnh();

    void getPhanAnh(String key, int mucCongKhai, Integer mucPAId, Integer noiPAId, Integer orderBy,
                    boolean isRefresh);

    ArrayList<PhanAnh> getListPhanAnh();
}