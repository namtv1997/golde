package com.app.goldenhealth.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseActivity;
import com.app.goldenhealth.model.User;
import com.app.goldenhealth.presenter.MainPresenter;
import com.app.goldenhealth.presenter.impl.MainPresenterImpl;
import com.app.goldenhealth.ui.adapter.MainPagerAdapter;
import com.app.goldenhealth.util.PrefUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.content)
    ViewPager mContent;
    @BindView(R.id.container)
    LinearLayout container;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    private MainPagerAdapter mainPagerAdapter;
    private int id = -1;
    private int type = -1;

    public static Intent getCallingIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        setupBottomBar();
        setupViewPager();
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenterImpl(this);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Log.d("Main", "dispatchTouchEvent: 111");
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    private void setupViewPager() {

        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), this);
        mContent.setAdapter(mainPagerAdapter);
        mContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        navigation.setSelectedItemId(R.id.navigation_home);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.navigation_hotline);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.navigation_contact);
                        break;
                    case 3:
                        navigation.setSelectedItemId(R.id.navigation_setting);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mContent.setOffscreenPageLimit(3);
    }

    private void setupBottomBar() {
        User user = PrefUtil.getDataUser(this);
        if (user.getRoleId() != Key.USER){
            Menu menu = navigation.getMenu();
            menu.findItem(R.id.navigation_contact).setIcon(getResources().getDrawable(R.drawable.ic_contact));
            menu.findItem(R.id.navigation_contact).setTitle(getResources().getString(R.string.contact));
        }

        if (user.getRoleId() == Key.UNDEFINED){
            Menu menu = navigation.getMenu();
            menu.findItem(R.id.navigation_contact).setIcon(getResources().getDrawable(R.drawable.ic_login));
            menu.findItem(R.id.navigation_contact).setTitle(getResources().getString(R.string.login));
        }

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        mContent.setCurrentItem(MainPagerAdapter.HOME_INDEX);
                        return true;
                    case R.id.navigation_hotline:
                        mContent.setCurrentItem(MainPagerAdapter.QUESTION_INDEX);
                        return true;
                    case R.id.navigation_contact:
                        mContent.setCurrentItem(MainPagerAdapter.CONTACT_INDEX);
                        return true;
                    case R.id.navigation_setting:
                        mContent.setCurrentItem(MainPagerAdapter.SETTING_INDEX);
                        return true;
                }
                return false;
            }
        });


//        bottomBar.setOnTabSelectListener(tabId -> {
//            switch (tabId) {
//                case R.id.navigation_home:
//                    mContent.setCurrentItem(MainPagerAdapter.HOME_INDEX);
//                    txtTitle.setText(getString(R.string.home));
//                    viewTitle.setVisibility(View.GONE);
//                    break;
//                case R.id.navigation_room:
//                    mContent.setCurrentItem(MainPagerAdapter.QUESTION_INDEX);
//                    txtTitle.setText(getString(R.string.question));
//                    viewTitle.setVisibility(View.VISIBLE);
//                    break;
//                case R.id.navigation_contact:
//                    mContent.setCurrentItem(MainPagerAdapter.CONTACT_INDEX);
//                    txtTitle.setText(getString(R.string.contact));
//                    viewTitle.setVisibility(View.VISIBLE);
//                    break;
//                case R.id.navigation_setting:
//                    mContent.setCurrentItem(MainPagerAdapter.SETTING_INDEX);
//                    txtTitle.setText(getString(R.string.setting));
//                    viewTitle.setVisibility(View.VISIBLE);
//                    break;
//                default:
//                    break;
//            }
//        }, false);

    }


    public ViewPager getmContent() {
        return mContent;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
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
