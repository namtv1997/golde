package com.app.goldenhealth.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.app.goldenhealth.ui.fragment.*;

public class TimKiemCSYTPagerAdapter extends FragmentPagerAdapter {

    public static final int TIM_KIEM = 0;
    public static final int DANH_BA = 1;
    public static final int MAX_PAGES = 2;

    private TimKiemCSYTFragment timKiemCSYTFragment;
    private DanhBaDaLuuFragment danhBaDaLuuFragment;

    private boolean check;

    public TimKiemCSYTPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setNotifFragment(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TIM_KIEM:
                if (timKiemCSYTFragment == null){
                    timKiemCSYTFragment = new TimKiemCSYTFragment();
                }
                return timKiemCSYTFragment;
            case DANH_BA:
                if (danhBaDaLuuFragment == null){
                    danhBaDaLuuFragment = new DanhBaDaLuuFragment();
                }
                return danhBaDaLuuFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return MAX_PAGES;
    }

}
