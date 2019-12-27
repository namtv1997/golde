package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.BVHINHANH;
import com.app.goldenhealth.model.BVNHANXET;
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.presenter.CoSoYTePresenter;
import com.app.goldenhealth.presenter.impl.CoSoYTePresenterImpl;
import com.app.goldenhealth.ui.adapter.ImageAdapter;
import com.app.goldenhealth.ui.adapter.NhanXetAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Objects;

public class CoSoYTeFragment extends BaseFragment<CoSoYTePresenter> implements CoSoYTeView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.edt_search)
    EditText edtSearch;
    @BindView(R.id.img_avatar)
    ImageView imgAvatar;
    @BindView(R.id.txt_ten)
    TextView txtTen;
    @BindView(R.id.txt_dia_chi)
    TextView txtDiaChi;
    @BindView(R.id.view_5_sao)
    View view5Sao;
    @BindView(R.id.view_4_sao)
    View view4Sao;
    @BindView(R.id.view_3_sao)
    View view3Sao;
    @BindView(R.id.view_2_sao)
    View view2Sao;
    @BindView(R.id.view_1_sao)
    View view1Sao;
    @BindView(R.id.view_sao)
    View viewSao;
    @BindView(R.id.txt_rating)
    TextView txtRating;
    @BindView(R.id.rating_bar)
    RatingBar ratingBar;
    @BindView(R.id.txt_so_luong_danh_gia)
    TextView txtSoLuongDanhGia;
    @BindView(R.id.btn_chi_duong)
    TextView btnChiDuong;
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
    @BindView(R.id.rvc_nhan_xet)
    RecyclerView rvcNhanXet;
    @BindView(R.id.btn_xem_them)
    TextView btnXemThem;
    @BindView(R.id.rating_bar_nhan_xet)
    RatingBar ratingBarNhanXet;
    @BindView(R.id.edt_nhan_xet)
    EditText edtNhanXet;
    Unbinder unbinder;

    private ImageAdapter imageAdapter;
    private NhanXetAdapter nhanXetAdapter;
    private ArrayList<BVNHANXET> bvnhanxets;
    private int maxWidth;
    private BenhVien benhVien;
    private int id;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_co_so_y_te;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();
        if (bundle != null){
            id = bundle.getInt(Key.ID, 0);
            getPresenter().getBenhVienInfo(id);
        }
    }

    @Override
    public CoSoYTePresenter createPresenter() {
        return new CoSoYTePresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_chi_duong, R.id.btn_xem_them, R.id.btn_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_chi_duong:
                break;
            case R.id.btn_xem_them:
                bvnhanxets.clear();
                bvnhanxets.addAll(benhVien.getBVNHANXETs());
                nhanXetAdapter.notifyDataSetChanged();
                break;
            case R.id.btn_send:

                break;
        }
    }

    @Override
    public Context gContext() {
        return getActivity();
    }

    @Override
    public void onGetBenhVienInfo(BenhVien data) {
        benhVien = data;
        Glide.with(getContext()).load(data.getHINHANH())
                .apply(new RequestOptions().placeholder(R.drawable.image_logo)).into(imgAvatar);
        txtTen.setText(data.getTEN());
        txtDiaChi.setText(data.getDIACHI());
        ratingBar.setRating(data.getCSDANHGIA());
        txtRating.setText(data.getCSDANHGIA() == null ? "0.0" : (data.getCSDANHGIA().toString().equals("NaN") ? "0.0" : data.getCSDANHGIA().toString()));
        txtTrangWeb.setText(data.getWEBSITE());
        txtHotline.setText(data.getHOTLINE());
        txtEmail.setText(data.getEMAIL());
        txtGioLamViec.setText(data.getTHOIGIAN());
        txtChiTiet.setText(data.getMOTA());
        txtThanhTich.setText(data.getTHANHTICH());

        if (data.getSLDANHGIA() > 0){
            viewSao.post(new Runnable() {
                @Override
                public void run() {
                    maxWidth = viewSao.getWidth();
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view1Sao.getLayoutParams();
                    layoutParams.width = (data.getSLDANHGIA1()*maxWidth/data.getSLDANHGIA()) + 10;
                    view1Sao.setLayoutParams(layoutParams);
                    layoutParams = (LinearLayout.LayoutParams) view2Sao.getLayoutParams();
                    layoutParams.width = (data.getSLDANHGIA2()*maxWidth/data.getSLDANHGIA()) + 10;
                    view2Sao.setLayoutParams(layoutParams);
                    layoutParams = (LinearLayout.LayoutParams) view3Sao.getLayoutParams();
                    layoutParams.width = (data.getSLDANHGIA3()*maxWidth/data.getSLDANHGIA()) + 10;
                    view3Sao.setLayoutParams(layoutParams);
                    layoutParams = (LinearLayout.LayoutParams) view4Sao.getLayoutParams();
                    layoutParams.width = (data.getSLDANHGIA4()*maxWidth/data.getSLDANHGIA()) + 10;
                    view4Sao.setLayoutParams(layoutParams);
                    layoutParams = (LinearLayout.LayoutParams) view5Sao.getLayoutParams();
                    layoutParams.width = (data.getSLDANHGIA5()*maxWidth/data.getSLDANHGIA()) + 10;
                    view5Sao.setLayoutParams(layoutParams);
                }
            });
        }

        imageAdapter = new ImageAdapter(getContext(), (ArrayList<BVHINHANH>) data.getBVHINHANHs());
        rcvImage.setAdapter(imageAdapter);

        bvnhanxets = (ArrayList<BVNHANXET>) data.getBVNHANXETs().subList(0, 5);
        nhanXetAdapter = new NhanXetAdapter(getContext(), bvnhanxets);
        rvcNhanXet.setAdapter(nhanXetAdapter);
        rvcNhanXet.setLayoutManager(new LinearLayoutManager(getContext()));
        if (data.getBVNHANXETs().size() > 5){
            btnXemThem.setVisibility(View.VISIBLE);
            btnXemThem.setText(getString(R.string.xem_them)  + (data.getBVNHANXETs().size() - 5) + getString(R.string.danh_gia));
        }else {
            btnXemThem.setVisibility(View.GONE);
        }
    }
}