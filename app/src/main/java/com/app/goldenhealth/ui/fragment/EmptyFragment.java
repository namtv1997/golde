package com.app.goldenhealth.ui.fragment;

import android.view.View;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.EmptyPresenter;
import com.app.goldenhealth.presenter.impl.EmptyPresenterImpl;

public class EmptyFragment extends BaseFragment<EmptyPresenter> implements EmptyView {
    @Override
    public int getContentViewId() {
        return R.layout.fragment_empty;
    }

    @Override
    public void initializeComponents(View view) {

    }

    @Override
    public EmptyPresenter createPresenter() {
        return new EmptyPresenterImpl(this);
    }
}