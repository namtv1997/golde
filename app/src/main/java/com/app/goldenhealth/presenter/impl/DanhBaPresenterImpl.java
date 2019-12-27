package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.ThongBao;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.DanhBaPresenter;
import com.app.goldenhealth.ui.fragment.DanhBaView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class DanhBaPresenterImpl extends BasePresenterImpl<DanhBaView> implements DanhBaPresenter {

    private static final String TAG = "DanhBa";

    public DanhBaPresenterImpl(DanhBaView view) {
        super(view);
    }

}