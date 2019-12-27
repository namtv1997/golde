package com.app.goldenhealth.ui.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.model.KhaoSatCauHoi;
import com.app.goldenhealth.ui.fragment.*;

import java.util.ArrayList;

public class KhaoSatPagerAdapter extends FragmentPagerAdapter {
    private final int CAU_HOI_MOT_LUA_CHON = 1;
    private final int CAU_HOI_NHIEU_LUA_CHON = 2;
    private final int CAU_HOI_TRA_LOI = 3;
    private ArrayList<KhaoSatCauHoi> cauHois;

    public KhaoSatPagerAdapter(FragmentManager fm, ArrayList<KhaoSatCauHoi> cauHois) {
        super(fm);
        this.cauHois = cauHois;
    }

    @Override
    public Fragment getItem(int position) {
        switch (cauHois.get(position).getKieuTL()){
            case CAU_HOI_MOT_LUA_CHON:
                CauHoiMotLuaChonFragment cauHoiMotLuaChonFragment = new CauHoiMotLuaChonFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable(Key.CAU_HOI, cauHois.get(position));
                cauHoiMotLuaChonFragment.setArguments(bundle);
                return cauHoiMotLuaChonFragment;
            case CAU_HOI_NHIEU_LUA_CHON:
                CauHoiNhieuLuaChonFragment cauHoiNhieuLuaChonFragment = new CauHoiNhieuLuaChonFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable(Key.CAU_HOI, cauHois.get(position));
                cauHoiNhieuLuaChonFragment.setArguments(bundle2);
                return cauHoiNhieuLuaChonFragment;
            case CAU_HOI_TRA_LOI:
                CauHoiTraLoiFragment cauHoiTraLoiFragment = new CauHoiTraLoiFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable(Key.CAU_HOI, cauHois.get(position));
                cauHoiTraLoiFragment.setArguments(bundle3);
                return cauHoiTraLoiFragment;
            default:
                return new CauHoiTraLoiFragment();
        }
    }

    @Override
    public int getCount() {
        return cauHois.size();
    }

}
