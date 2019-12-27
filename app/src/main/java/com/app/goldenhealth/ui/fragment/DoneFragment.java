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
import com.app.goldenhealth.presenter.DonePresenter;
import com.app.goldenhealth.presenter.impl.DonePresenterImpl;
import com.app.goldenhealth.ui.activity.LoginActivity;

public class DoneFragment extends BaseFragment<DonePresenter> implements DoneView {
    @BindView(R.id.btn_done)
    TextView btnDone;
    Unbinder unbinder;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_done;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public DonePresenter createPresenter() {
        return new DonePresenterImpl(this);
    }

    @OnClick(R.id.btn_done)
    public void onViewClicked() {
        startActivity(LoginActivity.getCallingIntent(getContext()));
        getActivity().finish();
    }
}
