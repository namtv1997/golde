package com.app.goldenhealth.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.KhaoSatXongPresenter;
import com.app.goldenhealth.presenter.impl.KhaoSatXongPresenterImpl;
import com.app.goldenhealth.ui.activity.MainActivity;

public class KhaoSatXongFragment extends BaseFragment<KhaoSatXongPresenter> implements KhaoSatXongView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.btn_done)
    Button btnDone;
    Unbinder unbinder;

    @Override
    public int getContentViewId() {
        return R.layout.activity_khao_sat_xong;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public KhaoSatXongPresenter createPresenter() {
        return new KhaoSatXongPresenterImpl(this);
    }


    @OnClick({R.id.btn_back, R.id.btn_done})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_done:
                startActivity(MainActivity.getCallingIntent(getContext()));
                break;
        }
    }
}