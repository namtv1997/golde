package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.ui.fragment.*;

public class NotificationPagerAdapter extends FragmentPagerAdapter {

    public static final int MAX_PAGES = 2;
    public static final int PHAN_HOI = 0;
    public static final int UNG_DUNG = 1;
    private String tabTitles[];
    private Context context;
    private NotificationPhanAnhFragment notificationPhanAnhFragment;
    private NotificationPhanAnhFragment notificationUngDungFragment;

    public NotificationPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabTitles = new String[] { context.getString(R.string.phan_anh), context.getString(R.string.ung_dung)};
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case PHAN_HOI:
                if (notificationPhanAnhFragment == null){
                    notificationPhanAnhFragment = new NotificationPhanAnhFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt(Key.NOTIFICATION_TYPE, Key.PHAN_ANH);
                    notificationPhanAnhFragment.setArguments(bundle);
                }
                return notificationPhanAnhFragment;
            case UNG_DUNG:
                if (notificationUngDungFragment == null){
                    notificationUngDungFragment = new NotificationPhanAnhFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt(Key.NOTIFICATION_TYPE, Key.UNG_DUNG);
                    notificationUngDungFragment.setArguments(bundle);
                }
                return notificationUngDungFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return MAX_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
