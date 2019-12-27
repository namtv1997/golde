package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.DanhBaPresenter;
import com.app.goldenhealth.presenter.impl.DanhBaPresenterImpl;
import com.app.goldenhealth.ui.adapter.TimKiemCSYTPagerAdapter;

public class DanhBaFragment extends BaseFragment<DanhBaPresenter> implements DanhBaView {

    BottomSheetBehavior sheetBehavior;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.btn_tim_kiem_csyt)
    TextView btnTimKiemCsyt;
    @BindView(R.id.btn_danh_ba)
    TextView btnDanhBa;

    private TimKiemCSYTPagerAdapter adapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_danh_ba;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        adapter = new TimKiemCSYTPagerAdapter(getActivity().getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == TimKiemCSYTPagerAdapter.TIM_KIEM){
                    btnTimKiemCsyt.setTextColor(getResources().getColor(R.color.colorPrimary));
                    btnDanhBa.setTextColor(getResources().getColor(R.color.black));
                }else {
                    btnTimKiemCsyt.setTextColor(getResources().getColor(R.color.black));
                    btnDanhBa.setTextColor(getResources().getColor(R.color.colorPrimary));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public DanhBaPresenter createPresenter() {
        return new DanhBaPresenterImpl(this);
    }


    @Override
    public Context gContext() {
        return getContext();
    }


    @OnClick({R.id.btn_tim_kiem_csyt, R.id.btn_danh_ba})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_tim_kiem_csyt:
                if (viewpager.getCurrentItem() == TimKiemCSYTPagerAdapter.DANH_BA){
                    viewpager.setCurrentItem(TimKiemCSYTPagerAdapter.TIM_KIEM);
                }else {
                    ((TimKiemCSYTFragment) adapter.getItem(TimKiemCSYTPagerAdapter.TIM_KIEM)).showHideBottom();
                }
                break;
            case R.id.btn_danh_ba:
                viewpager.setCurrentItem(TimKiemCSYTPagerAdapter.DANH_BA);
                break;
        }
    }
}