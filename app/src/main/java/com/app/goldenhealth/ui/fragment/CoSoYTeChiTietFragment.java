package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.BVHINHANH;
import com.app.goldenhealth.model.BVNHANXET;
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.presenter.CoSoYTeChiTietPresenter;
import com.app.goldenhealth.presenter.impl.CoSoYTeChiTietPresenterImpl;
import com.app.goldenhealth.ui.adapter.ImageAdapter;
import com.app.goldenhealth.ui.adapter.NhanXetAdapter;
import com.app.goldenhealth.util.PrefUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CoSoYTeChiTietFragment extends BaseFragment<CoSoYTeChiTietPresenter> implements CoSoYTeChiTietView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.btn_edit)
    ImageView btnEdit;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.txt_ten)
    TextView txtTen;
    @BindView(R.id.txt_dia_chi)
    TextView txtDiaChi;
    @BindView(R.id.txt_trang_web)
    TextView txtTrangWeb;
    @BindView(R.id.txt_hotline)
    TextView txtHotline;
    @BindView(R.id.txt_email)
    TextView txtEmail;
    @BindView(R.id.txt_gio_lam_viec)
    TextView txtGioLamViec;
    @BindView(R.id.txt_chuyen_khoa)
    TextView txtChuyenKhoa;
    @BindView(R.id.txt_kinh_nghiem)
    TextView txtKinhNghiem;
    @BindView(R.id.txt_thanh_tich)
    TextView txtThanhTich;
    @BindView(R.id.txt_chi_tiet)
    TextView txtChiTiet;
    @BindView(R.id.rcv_image)
    RecyclerView rcvImage;
    Unbinder unbinder;

    private ImageAdapter adapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_co_so_y_te_chi_tiet;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getBenhVienInfo(PrefUtil.getDataUser(getContext()).getBenhVienID());
    }

    @Override
    public CoSoYTeChiTietPresenter createPresenter() {
        return new CoSoYTeChiTietPresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_edit:
                CapNhatCSYTFragment capNhatCSYTFragment = new CapNhatCSYTFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .add(android.R.id.content, capNhatCSYTFragment)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetBenhVienInfo(BenhVien data) {
        Glide.with(getContext()).load(data.getHINHANH())
                .apply(new RequestOptions().placeholder(R.drawable.image_logo)).into(image);
        txtTen.setText(data.getTEN());
        txtDiaChi.setText(data.getDIACHI());
        txtTrangWeb.setText(data.getWEBSITE());
        txtHotline.setText(data.getHOTLINE());
        txtEmail.setText(data.getEMAIL());
        txtGioLamViec.setText(data.getTHOIGIAN());
        txtChiTiet.setText(data.getMOTA());

        adapter = new ImageAdapter(getContext(), (ArrayList<BVHINHANH>) data.getBVHINHANHs());
        rcvImage.setAdapter(adapter);

    }

}