package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import com.app.goldenhealth.base.BaseView;

import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.model.ThongBao;
import com.app.goldenhealth.presenter.DanhBaPresenter;

import java.util.ArrayList;

public interface DanhBaView extends BaseView<DanhBaPresenter> {
    Context gContext();

}