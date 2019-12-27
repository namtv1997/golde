package com.app.goldenhealth.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseActivity;
import com.app.goldenhealth.presenter.HealthProfilePresenter;
import com.app.goldenhealth.presenter.impl.HealthProfilePresenterImpl;
import com.app.goldenhealth.ui.adapter.HealthProfilePagerAdapter;
import com.app.goldenhealth.ui.fragment.*;

public class HealthProfileActivity extends BaseActivity<HealthProfilePresenter> implements HealthProfileView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.btn_done)
    ImageView btnDone;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private HealthProfilePagerAdapter pagerAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_health_profile;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        pagerAdapter = new HealthProfilePagerAdapter(getSupportFragmentManager(), this);
        viewpager.setAdapter(pagerAdapter);
        viewpager.setOffscreenPageLimit(1);
        tablayout.setupWithViewPager(viewpager);
        ViewGroup slidingTabStrip = (ViewGroup) tablayout.getChildAt(0);
        for (int i=0; i<slidingTabStrip.getChildCount()-1; i++) {
            View v = slidingTabStrip.getChildAt(i);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.rightMargin = 36;
        }

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                if (position == 0){
//                    btnDone.setImageResource(R.drawable.ic_edit_pencil);
//                }else {
//                    btnDone.setImageResource(R.drawable.ic_check);
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public HealthProfilePresenter createPresenter() {
        return new HealthProfilePresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_done})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_done:
                switch (viewpager.getCurrentItem()){
                    case 0:
                        ((HealthProfile1Fragment) pagerAdapter.getItem(0)).update();
                        break;
                    case 1:
                        ((HealthProfile2Fragment) pagerAdapter.getItem(1)).update();
                        break;
                    case 2:
                        ((HealthProfile3Fragment) pagerAdapter.getItem(2)).update();
                        break;
                    case 3:
                        ((HealthProfile4Fragment) pagerAdapter.getItem(3)).update();
                        break;
                    case 4:
                        ((HealthProfile5Fragment) pagerAdapter.getItem(4)).update();
                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:
                        ((HealthProfile9Fragment) pagerAdapter.getItem(7)).update();
                        break;
                    case 8:
                        ((HealthProfile8Fragment) pagerAdapter.getItem(8)).update();
                        break;
                    default:

                        break;
                }
                break;
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