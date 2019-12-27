package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.app.goldenhealth.R;
import com.app.goldenhealth.ui.fragment.*;

public class HealthProfilePagerAdapter extends FragmentStatePagerAdapter {

    public static final int MAX_PAGES = 9;
    private String tabTitles[]; 
    private Context context;
    private HealthProfile1Fragment healthProfile1Fragment;
    private HealthProfile2Fragment healthProfile2Fragment;
    private HealthProfile3Fragment healthProfile3Fragment;
    private HealthProfile4Fragment healthProfile4Fragment;
    private HealthProfile5Fragment healthProfile5Fragment;
    private HealthProfile6Fragment healthProfile6Fragment;
    private HealthProfile7Fragment healthProfile7Fragment;
    private HealthProfile8Fragment healthProfile8Fragment;
    private HealthProfile9Fragment healthProfile9Fragment;

    public HealthProfilePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        tabTitles = new String[] { context.getString(R.string.tom_tat_thong_tin), context.getString(R.string.tinh_trang_luc_sinh), context.getString(R.string.yeu_to_nguy_co),
                context.getString(R.string.tien_su_benh_tat), context.getString(R.string.khuyet_tat), context.getString(R.string.tien_su_phau_thuat),
                context.getString(R.string.tien_su_gia_dinh),context.getString(R.string.skss_khhgd),  context.getString(R.string.van_de_khac)};
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (healthProfile1Fragment == null){
                    healthProfile1Fragment = new HealthProfile1Fragment();
                }
                return healthProfile1Fragment;
            case 1:
                if (healthProfile2Fragment == null){
                    healthProfile2Fragment = new HealthProfile2Fragment();
                }
                return healthProfile2Fragment;
            case 2:
                if (healthProfile3Fragment == null){
                    healthProfile3Fragment = new HealthProfile3Fragment();
                }
                return healthProfile3Fragment;
            case 3:
                if (healthProfile4Fragment == null){
                    healthProfile4Fragment = new HealthProfile4Fragment();
                }
                return healthProfile4Fragment;
            case 4:
                if (healthProfile5Fragment == null){
                    healthProfile5Fragment = new HealthProfile5Fragment();
                }
                return healthProfile5Fragment;
            case 5:
                if (healthProfile6Fragment == null){
                    healthProfile6Fragment = new HealthProfile6Fragment();
                }
                return healthProfile6Fragment;
            case 6:
                if (healthProfile7Fragment == null){
                    healthProfile7Fragment = new HealthProfile7Fragment();
                }
                return healthProfile7Fragment;
            case 7:
                if (healthProfile9Fragment == null){
                    healthProfile9Fragment = new HealthProfile9Fragment();
                }
                return healthProfile9Fragment;
            case 8:
                if (healthProfile8Fragment == null){
                    healthProfile8Fragment = new HealthProfile8Fragment();
                }
                return healthProfile8Fragment;
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
