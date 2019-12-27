package com.app.goldenhealth.ui.fragment;

import android.view.View;
import butterknife.ButterKnife;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.SuaThongTinPresenter;
import com.app.goldenhealth.presenter.impl.SuaThongTinPresenterImpl;

public class SuaThongTinFragment extends BaseFragment<SuaThongTinPresenter> implements SuaThongTinView {


    @Override
    public int getContentViewId() {
        return R.layout.fragment_sua_thong_tin;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public SuaThongTinPresenter createPresenter() {
        return new SuaThongTinPresenterImpl(this);
    }
}