package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.BVHINHANH;
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.presenter.CapNhatCSYTPresenter;
import com.app.goldenhealth.presenter.impl.CapNhatCSYTPresenterImpl;
import com.app.goldenhealth.ui.adapter.ImageAdapter;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CapNhatCSYTFragment extends BaseFragment<CapNhatCSYTPresenter> implements CapNhatCSYTView {
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.btn_save)
    ImageView btnSave;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.img_avatar)
    ImageView imgAvatar;
    @BindView(R.id.edt_trang_web)
    EditText edtTrangWeb;
    @BindView(R.id.edt_hotline)
    EditText edtHotline;
    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_gio_lam_viec)
    EditText edtGioLamViec;
    @BindView(R.id.edt_chuyen_khoa)
    EditText edtChuyenKhoa;
    @BindView(R.id.edt_kinh_nghiem)
    EditText edtKinhNghiem;
    @BindView(R.id.edt_thanh_tich)
    EditText edtThanhTich;
    @BindView(R.id.rcv_image)
    RecyclerView rcvImage;
    @BindView(R.id.edt_ten)
    EditText edtTen;
    @BindView(R.id.edt_dia_chi)
    EditText edtDiaChi;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_cap_nhat_co_so_y_te;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getBenhVienInfo(PrefUtil.getDataUser(getContext()).getBenhVienID());
    }

    @Override
    public CapNhatCSYTPresenter createPresenter() {
        return new CapNhatCSYTPresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @OnClick({R.id.btn_back, R.id.btn_save, R.id.img_avatar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
                break;
            case R.id.img_avatar:
                ImagePicker.create(this).limit(1).start();
                break;
            case R.id.btn_save:
                updateThongTin();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            // Get a list of picked images
            List<Image> images = ImagePicker.getImages(data);
            // or get a single image only
            Image image = ImagePicker.getFirstImageOrNull(data);

            Glide.with(getContext()).load(image.getPath()).into(imgAvatar);
            getPresenter().updateAvatar(image.getPath());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void updateThongTin(){
        String ten = edtTen.getText().toString();
        String diaChi = edtDiaChi.getText().toString();
        String trangWeb = edtTrangWeb.getText().toString();
        String hotline = edtHotline.getText().toString();
        String email = edtEmail.getText().toString();
        String gioLamViec = edtGioLamViec.getText().toString();
        String kinhNghiem = edtKinhNghiem.getText().toString();
        String thanhTich = edtThanhTich.getText().toString();
        ArrayList<Integer> dmKhoa = new ArrayList<>();

        getPresenter().updateBenhVien(ten, diaChi, trangWeb, hotline,
                gioLamViec, email, thanhTich, dmKhoa);
    }

    @Override
    public void onUpdateSuccess() {
        Util.showMessenger(getString(R.string.update_sucsess), getContext());
    }

    @Override
    public void onUpdateFail(String message) {
        Util.showMessenger(message, getContext());
    }

    @Override
    public void onGetBenhVienInfo(BenhVien data) {
        Glide.with(getContext()).load(data.getHINHANH())
                .apply(new RequestOptions().placeholder(R.drawable.image_logo)).into(imgAvatar);
        edtTen.setText(data.getTEN());
        edtDiaChi.setText(data.getDIACHI());
        edtTrangWeb.setText(data.getWEBSITE());
        edtHotline.setText(data.getHOTLINE());
        edtEmail.setText(data.getEMAIL());
        edtGioLamViec.setText(data.getTHOIGIAN());
        edtThanhTich.setText(data.getTHANHTICH());
//        adapter = new ImageAdapter(getContext(), (ArrayList<BVHINHANH>) data.getBVHINHANHs());
//        rcvImage.setAdapter(adapter);
    }

    @Override
    public void onUpdateAvatarSuccess() {
        Toast.makeText(getContext(), "Cập nhật ảnh thành công!", Toast.LENGTH_SHORT).show();
    }
}
