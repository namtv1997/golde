package com.app.goldenhealth.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.presenter.ChonLoaiTaiKhoanDangKyPresenter;
import com.app.goldenhealth.presenter.impl.ChonLoaiTaiKhoanDangKyPresenterImpl;
import com.app.goldenhealth.ui.activity.RegisterActivity;

public class ChonLoaiTaiKhoanDangKyFragment extends BaseFragment<ChonLoaiTaiKhoanDangKyPresenter> implements ChonLoaiTaiKhoanDangKyView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.btn_nguoi_dung_thuong)
    TextView btnNguoiDungThuong;
    @BindView(R.id.btn_bac_sy)
    TextView btnBacSy;
    @BindView(R.id.btn_csyt)
    TextView btnCsyt;
    Unbinder unbinder;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_chon_tai_loai_tai_khoan_dang_ky;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    public ChonLoaiTaiKhoanDangKyPresenter createPresenter() {
        return new ChonLoaiTaiKhoanDangKyPresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_nguoi_dung_thuong, R.id.btn_bac_sy, R.id.btn_csyt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_nguoi_dung_thuong:
                Intent intent = new Intent(getContext(), RegisterActivity.class);
                intent.putExtra(Key.ROLE_ID, Key.USER);
                startActivity(intent);
                break;
            case R.id.btn_bac_sy:
                Intent intent2 = new Intent(getContext(), RegisterActivity.class);
                intent2.putExtra(Key.ROLE_ID, Key.DOCTOR);
                startActivity(intent2);
                break;
            case R.id.btn_csyt:
                Intent intent3 = new Intent(getContext(), RegisterActivity.class);
                intent3.putExtra(Key.ROLE_ID, Key.FACILITY);
                startActivity(intent3);
                break;
        }
    }
}