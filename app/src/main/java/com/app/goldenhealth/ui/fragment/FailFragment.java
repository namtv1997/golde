package com.app.goldenhealth.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.FailPresenter;
import com.app.goldenhealth.presenter.impl.FailPresenterImpl;

public class FailFragment extends BaseFragment<FailPresenter> implements FailView {
    @BindView(R.id.btn_try_again)
    TextView btnTryAgain;
    Unbinder unbinder;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_fail;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public FailPresenter createPresenter() {
        return new FailPresenterImpl(this);
    }

    @OnClick(R.id.btn_try_again)
    public void onViewClicked() {
        getChildFragmentManager().popBackStack();
    }
}
