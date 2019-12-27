package com.app.goldenhealth.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseActivity;
import com.app.goldenhealth.presenter.NotificationPresenter;
import com.app.goldenhealth.presenter.impl.NotificationPresenterImpl;
import com.app.goldenhealth.ui.adapter.HealthProfilePagerAdapter;
import com.app.goldenhealth.ui.adapter.NotificationPagerAdapter;

public class NotificationActivity extends BaseActivity<NotificationPresenter> implements NotificationView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private NotificationPagerAdapter pagerAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_notification;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        pagerAdapter = new NotificationPagerAdapter(getSupportFragmentManager(), this);
        viewpager.setAdapter(pagerAdapter);
        viewpager.setOffscreenPageLimit(1);
        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    public NotificationPresenter createPresenter() {
        return new NotificationPresenterImpl(this);
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        onBackPressed();
    }
}