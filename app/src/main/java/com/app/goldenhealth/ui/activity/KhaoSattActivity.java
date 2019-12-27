package com.app.goldenhealth.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseActivity;
import com.app.goldenhealth.model.KhaoSatCauHoi;
import com.app.goldenhealth.presenter.KhaoSattPresenter;
import com.app.goldenhealth.presenter.impl.KhaoSattPresenterImpl;
import com.app.goldenhealth.ui.adapter.KhaoSatPagerAdapter;
import com.app.goldenhealth.ui.fragment.KhaoSatXongFragment;
import com.app.goldenhealth.widget.CustomViewPager;
import me.relex.circleindicator.CircleIndicator;

import java.util.ArrayList;

public class KhaoSattActivity extends BaseActivity<KhaoSattPresenter> implements KhaoSattView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.content)
    CustomViewPager content;
    @BindView(R.id.indicator)
    CircleIndicator indicator;

    private KhaoSatPagerAdapter adapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_khao_sat;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null) {
            int id = intent.getIntExtra(Key.ID, 0);
            getPresenter().getCauHoiKhaoSat(id);
        }
    }

    @Override
    public KhaoSattPresenter createPresenter() {
        return new KhaoSattPresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetListCauHoi(ArrayList<KhaoSatCauHoi> data) {
        adapter = new KhaoSatPagerAdapter(getSupportFragmentManager(), data);
        content.setAdapter(adapter);
        content.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        content.disableScroll(true);
        content.setOffscreenPageLimit(3);
        indicator.setViewPager(content);
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        onBackPressed();
    }

    public void next(){
        if (content.getCurrentItem() < adapter.getCount()-1){
            content.setCurrentItem(content.getCurrentItem() +1);
        }else {
            KhaoSatXongFragment khaoSatXongFragment = new KhaoSatXongFragment();
            getSupportFragmentManager().beginTransaction().replace(android.R.id.content, khaoSatXongFragment)
                    .addToBackStack(null).commit();
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}