package com.app.goldenhealth.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.ui.fragment.*;
import com.app.goldenhealth.util.PrefUtil;

public class MainPagerAdapter extends FragmentPagerAdapter {

    public static final int HOME_INDEX = 0;
    public static final int QUESTION_INDEX = 1;
    public static final int CONTACT_INDEX = 2;
    public static final int SETTING_INDEX = 3;
    public static final int MAX_PAGES = 4;

    private HomeFragment homeFragment;
    private DanhBaFragment danhBaFragment;
    private SettingFragment settingFragment;
    private YBaFragment yBaFragment;
    private PhanAnhFragment phanAnhFragment;
    private TaoPhanAnhFragment taoPhanAnhFragment;
    private Login2Fragment login2Fragment;

    private boolean check;
    private Context context;

    public MainPagerAdapter(FragmentManager fm, Context context)
    {
        super(fm);
        this.context = context;
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
            case HOME_INDEX:
                if (PrefUtil.getDataUser(context).getRoleId() == Key.UNDEFINED){
                    if (phanAnhFragment == null){
                        phanAnhFragment = new PhanAnhFragment();
                    }
                    return phanAnhFragment;
                }else {
                    if (homeFragment == null){
                    homeFragment = new HomeFragment();
                    }
                    return homeFragment;
                }
            case QUESTION_INDEX:
                if (PrefUtil.getDataUser(context).getRoleId() == Key.UNDEFINED ){
                    if (taoPhanAnhFragment == null){
                        taoPhanAnhFragment = new TaoPhanAnhFragment();
                    }
                    return taoPhanAnhFragment;
                }else if (PrefUtil.getDataUser(context).getRoleId() == Key.USER || PrefUtil.getDataUser(context).getRoleId() == Key.MANAGER ) {
                    if (phanAnhFragment == null){
                        phanAnhFragment = new PhanAnhFragment();
                    }
                    return phanAnhFragment;
                }else {
                    return new EmptyFragment();
                }

            case CONTACT_INDEX:
                if (PrefUtil.getDataUser(context).getRoleId() == Key.UNDEFINED ){
                    if (login2Fragment == null){
                        login2Fragment = new Login2Fragment();
                    }
                    return login2Fragment;
                }else if (PrefUtil.getDataUser(context).getRoleId() == Key.USER){
                    if (danhBaFragment == null){
                        danhBaFragment = new DanhBaFragment();
                    }
                    return danhBaFragment;
                }else {
                    if (yBaFragment == null){
                        yBaFragment = new YBaFragment();
                    }
                    return yBaFragment;
                }
            case SETTING_INDEX:
                if (PrefUtil.getDataUser(context).getRoleId() != Key.UNDEFINED){
                    if (settingFragment == null){
                        settingFragment = new SettingFragment();
                    }
                    return settingFragment;
                }else {
                    return new EmptyFragment();
                }
        }
        return null;
    }

    @Override
    public int getCount() {
        return MAX_PAGES;
    }

}
