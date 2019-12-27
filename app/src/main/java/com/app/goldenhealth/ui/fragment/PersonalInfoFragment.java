package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.User;
import com.app.goldenhealth.presenter.PersonalInfoPresenter;
import com.app.goldenhealth.presenter.impl.PersonalInfoPresenterImpl;
import com.app.goldenhealth.ui.activity.HealthProfileActivity;
import com.app.goldenhealth.ui.activity.KhamLapHoSoActivity;
import com.app.goldenhealth.util.PrefUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import de.hdodenhof.circleimageview.CircleImageView;

public class PersonalInfoFragment extends BaseFragment<PersonalInfoPresenter> implements PersonalInfoView {

    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.img_avatar)
    CircleImageView imgAvatar;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_bac_si)
    TextView txtBacSi;
    @BindView(R.id.txt_email)
    TextView txtEmail;
    @BindView(R.id.txt_gender)
    TextView txtGender;
    @BindView(R.id.txt_birthday)
    TextView txtBirthday;
    @BindView(R.id.txt_phone)
    TextView txtPhone;
    @BindView(R.id.view_nguoi_thuong)
    LinearLayout viewNguoiThuong;
    @BindView(R.id.txt_ma_bac_si)
    TextView txtMaBacSi;
    @BindView(R.id.txt_phone_bs)
    TextView txtPhoneBs;
    @BindView(R.id.view_bac_si)
    LinearLayout viewBacSi;
    @BindView(R.id.txt_sdt_csyt)
    TextView txtSdtCsyt;
    @BindView(R.id.txt_email_csyt)
    TextView txtEmailCsyt;
    @BindView(R.id.view_csyt)
    LinearLayout viewCsyt;
    @BindView(R.id.btn_thong_tin_chi_tiet)
    CardView btnThongTinChiTiet;
    @BindView(R.id.btn_profile)
    LinearLayout btnProfile;
    @BindView(R.id.btn_change_password)
    LinearLayout btnChangePassword;
    @BindView(R.id.btn_ho_so_suc_khoe)
    LinearLayout btnHoSoSucKhoe;
    Unbinder unbinder;
    @BindView(R.id.btn_scan)
    ImageView btnScan;
    @BindView(R.id.img_qr_code)
    ImageView imgQrCode;
    @BindView(R.id.view_qr_code)
    RelativeLayout viewQrCode;
    private ProfileFragment profileFragment;
    private DoiMatKhauFragment doiMatKhauFragment;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_personal_info;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        User user = PrefUtil.getDataUser(getContext());
        switch (user.getRoleId()) {
            case Key.USER:
                viewNguoiThuong.setVisibility(View.VISIBLE);
                viewBacSi.setVisibility(View.GONE);
                viewCsyt.setVisibility(View.GONE);
                btnThongTinChiTiet.setVisibility(View.GONE);
                btnProfile.setVisibility(View.VISIBLE);
                btnHoSoSucKhoe.setVisibility(View.VISIBLE);
                btnScan.setVisibility(View.VISIBLE);
                txtBacSi.setVisibility(View.GONE);
                txtEmail.setText(user.getEmailID());
                break;
            case Key.DOCTOR:
                viewNguoiThuong.setVisibility(View.GONE);
                viewBacSi.setVisibility(View.VISIBLE);
                viewCsyt.setVisibility(View.GONE);
                btnThongTinChiTiet.setVisibility(View.GONE);
                btnProfile.setVisibility(View.VISIBLE);
                btnHoSoSucKhoe.setVisibility(View.VISIBLE);
                btnScan.setVisibility(View.GONE);
                txtBacSi.setVisibility(View.VISIBLE);
                txtEmail.setText(user.getEmailID());
                break;
            case Key.FACILITY:
                viewNguoiThuong.setVisibility(View.GONE);
                viewBacSi.setVisibility(View.GONE);
                viewCsyt.setVisibility(View.VISIBLE);
                btnThongTinChiTiet.setVisibility(View.VISIBLE);
                btnProfile.setVisibility(View.GONE);
                btnHoSoSucKhoe.setVisibility(View.GONE);
                btnScan.setVisibility(View.GONE);
                txtBacSi.setVisibility(View.GONE);
                txtEmail.setText(user.getDiaChi());
                break;
        }
        Glide.with(getContext()).load(user.getAvatar()).apply(new RequestOptions().placeholder(R.drawable.ic_avatar)).into(imgAvatar);
        txtName.setText(user.getFullName());
        txtBirthday.setText(user.getBirthDay());
        txtPhone.setText(user.getPhone());
        txtMaBacSi.setText(user.getMaBS());
        txtPhoneBs.setText(user.getPhone());
        txtSdtCsyt.setText(user.getPhone());
        txtEmailCsyt.setText(user.getEmailID());

    }

    @Override
    public PersonalInfoPresenter createPresenter() {
        return new PersonalInfoPresenterImpl(this);
    }


    @OnClick({R.id.btn_back, R.id.btn_profile, R.id.btn_change_password, R.id.btn_ho_so_suc_khoe,
            R.id.btn_thong_tin_chi_tiet, R.id.btn_scan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                if (viewQrCode.getVisibility() == View.VISIBLE){
                    viewQrCode.setVisibility(View.GONE);
                }else {
                    getActivity().getSupportFragmentManager().popBackStack();
                }

                break;
            case R.id.btn_profile:
                if (profileFragment == null) {
                    profileFragment = new ProfileFragment();
                }
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, profileFragment)
                        .addToBackStack(null).commit();
                break;
            case R.id.btn_change_password:
                if (doiMatKhauFragment == null) {
                    doiMatKhauFragment = new DoiMatKhauFragment();
                }
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, doiMatKhauFragment)
                        .addToBackStack(null).commit();
                break;
            case R.id.btn_ho_so_suc_khoe:
                if (PrefUtil.getDataUser(getContext()).getMaytecanhan() == null ||
                        PrefUtil.getDataUser(getContext()).getMaytecanhan().isEmpty()) {
                    CapNhatMaYTCNFragment capNhatMaYTCNFragment = new CapNhatMaYTCNFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, capNhatMaYTCNFragment)
                            .addToBackStack(null).commit();
                } else {
                    startActivity(new Intent(getContext(), HealthProfileActivity.class));

                }
                break;
            case R.id.btn_thong_tin_chi_tiet:
                CoSoYTeChiTietFragment coSoYTeChiTietFragment = new CoSoYTeChiTietFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, coSoYTeChiTietFragment)
                        .addToBackStack(null).commit();
                break;

            case R.id.btn_scan:
                getPresenter().getQRCode();
                break;
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetQRCode(String data) {
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(data, BarcodeFormat.QR_CODE, 400, 400);
            viewQrCode.setVisibility(View.VISIBLE);
            imgQrCode.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
