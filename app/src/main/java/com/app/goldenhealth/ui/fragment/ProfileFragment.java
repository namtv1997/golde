package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.ThongTinCaNhan;
import com.app.goldenhealth.presenter.ProfilePresenter;
import com.app.goldenhealth.presenter.impl.ProfilePresenterImpl;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends BaseFragment<ProfilePresenter> implements ProfileView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.btn_edit)
    ImageView btnEdit;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.img_avatar)
    CircleImageView imgAvatar;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.txt_birthday)
    TextView txtBirthday;
    @BindView(R.id.txt_gender)
    TextView txtGender;
    @BindView(R.id.txt_dan_toc)
    TextView txtDanToc;
    @BindView(R.id.txt_cmnd)
    TextView txtCmnd;
    @BindView(R.id.txt_ngay_cap)
    TextView txtNgayCap;
    @BindView(R.id.txt_noi_cap)
    TextView txtNoiCap;
    @BindView(R.id.txt_ma_y_te)
    TextView txtMaYTe;
    @BindView(R.id.txt_ma_ho_gia_dinh)
    TextView txtMaHoGiaDinh;
    @BindView(R.id.txt_ten_chu_ho)
    TextView txtTenChuHo;
    @BindView(R.id.txt_quan_he_voi_chu_ho)
    TextView txtQuanHeVoiChuHo;
    @BindView(R.id.txt_so_the_BHYT)
    TextView txtSoTheBHYT;
    @BindView(R.id.txt_tinh_dang_ki_khai_sinh)
    TextView txtTinhDangKiKhaiSinh;
    @BindView(R.id.txt_quoc_tich)
    TextView txtQuocTich;
    @BindView(R.id.txt_ton_giao)
    TextView txtTonGiao;
    @BindView(R.id.txt_nghe_nghiep)
    TextView txtNgheNghiep;
    @BindView(R.id.txt_dia_chi_hien_tai)
    TextView txtDiaChiHienTai;
    @BindView(R.id.txt_dia_chi_thuong_tru)
    TextView txtDiaChiThuongTru;
    @BindView(R.id.txt_dien_thoai_co_dinh)
    TextView txtDienThoaiCoDinh;
    @BindView(R.id.txt_dien_thoai_di_dong)
    TextView txtDienThoaiDiDong;
    @BindView(R.id.txt_email)
    TextView txtEmail;
    @BindView(R.id.txt_ho_ten_bo)
    TextView txtHoTenBo;
    @BindView(R.id.txt_ma_y_te_bo)
    TextView txtMaYTeBo;
    @BindView(R.id.txt_ho_ten_me)
    TextView txtHoTenMe;
    @BindView(R.id.txt_ma_y_te_me)
    TextView txtMaYTeMe;
    @BindView(R.id.txt_ho_ten_nguoi_cs)
    TextView txtHoTenNguoiCs;
    @BindView(R.id.txt_mqh_nguoi_cs)
    TextView txtMqhNguoiCs;
    @BindView(R.id.txt_dtcd_nguoi_cs)
    TextView txtDtcdNguoiCs;
    @BindView(R.id.txt_dtdd_nguoi_cs)
    TextView txtDtddNguoiCs;
    @BindView(R.id.txt_trinh_do_hoc_van)
    TextView txtTrinhDoHocVan;
    @BindView(R.id.txt_tinh_trang_hon_nhan)
    TextView txtTinhTrangHonNhan;
    Unbinder unbinder;

    private UpdateProfileFragment updateProfileFragment;


    @Override
    public int getContentViewId() {
        return R.layout.fragment_profile;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getThongTinCaNhan();
    }

    @Override
    public ProfilePresenter createPresenter() {
        return new ProfilePresenterImpl(this);
    }


    @OnClick({R.id.btn_back, R.id.btn_edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_edit:
                if (updateProfileFragment == null){
                    updateProfileFragment = new UpdateProfileFragment();
                }
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(android.R.id.content, updateProfileFragment)
                        .addToBackStack(null).commit();
                break;
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetInfo(ThongTinCaNhan data) {
        Glide.with(getContext()).load(data.getAVATAR()).apply(new RequestOptions().placeholder(R.drawable.ic_avatar)).into(imgAvatar);
        txtName.setText(data.getHOTEN());
        txtBirthday.setText(data.getNGAYSINH());
        txtGender.setText(data.getGIOITINH());
        txtDanToc.setText(data.getDANTOC());
        txtCmnd.setText(data.getSOCMND());
        txtNgayCap.setText(data.getNGAYCAP());
        txtNoiCap.setText(data.getNOICAP());
        txtMaYTe.setText(data.getMAYTECANHAN());
        txtMaHoGiaDinh.setText(data.getMAHOGIADINH());
        txtTenChuHo.setText(data.getTENCHUHO());
        txtQuanHeVoiChuHo.setText(data.getQUANHEVOICHUHO());
        txtSoTheBHYT.setText(data.getMATHEBHYT());
        txtTinhDangKiKhaiSinh.setText(data.getKSTINH());
        txtQuocTich.setText(data.getQUOCTICH());
        txtTonGiao.setText(data.getTONGIAO());
        txtNgheNghiep.setText(data.getNGHENGHIEP());
        txtDiaChiHienTai.setText(data.getHTDIACHICHITIET());
        txtDiaChiThuongTru.setText(data.getTTDIACHICHITIET());
        txtDienThoaiCoDinh.setText(data.getDIENTHOAINR());
        txtDienThoaiDiDong.setText(data.getDIENTHOAIDD());
        txtEmail.setText(data.getEMAIL());
        txtHoTenBo.setText(data.getHOTENBO());
        txtMaYTeBo.setText(data.getMAYTBO());
        txtHoTenMe.setText(data.getHOTENME());
        txtMaYTeMe.setText(data.getMAYTME());
        txtHoTenNguoiCs.setText(data.getNGUOICHAMSOC());
        txtMqhNguoiCs.setText(data.getQHNGUOICS());
        txtDtcdNguoiCs.setText(data.getNCSDTNR());
        txtDtddNguoiCs.setText(data.getNCSDTDD());
        txtTrinhDoHocVan.setText(data.getHOCVAN());
        txtTinhTrangHonNhan.setText(data.getHONNHAN());
    }
}