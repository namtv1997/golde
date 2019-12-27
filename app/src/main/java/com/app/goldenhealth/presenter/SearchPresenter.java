package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;

import java.util.ArrayList;

public interface SearchPresenter extends BasePresenter {
    void search(String keyword, ArrayList<Integer> loaiTimKiem, ArrayList<Integer> timKiemUuTien);
}
