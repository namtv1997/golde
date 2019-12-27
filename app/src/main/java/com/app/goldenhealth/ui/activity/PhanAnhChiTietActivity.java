package com.app.goldenhealth.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseActivity;
import com.app.goldenhealth.model.Comment;
import com.app.goldenhealth.model.FILE;
import com.app.goldenhealth.model.PhanAnh;
import com.app.goldenhealth.model.User;
import com.app.goldenhealth.presenter.PhanAnhChiTietPresenter;
import com.app.goldenhealth.presenter.impl.PhanAnhChiTietPresenterImpl;
import com.app.goldenhealth.ui.adapter.BinhLuanAdapter;
import com.app.goldenhealth.ui.adapter.ImageSelectedAdapter;
import com.app.goldenhealth.ui.adapter.ImageViewPagerAdapter;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import com.app.goldenhealth.widget.SlideImage;
import com.bumptech.glide.Glide;
import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;
import de.hdodenhof.circleimageview.CircleImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PhanAnhChiTietActivity extends BaseActivity<PhanAnhChiTietPresenter> implements PhanAnhChiTietView {

    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.vp_image_task)
    ViewPager vpImageTask;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_time)
    TextView txtTime;
    @BindView(R.id.txt_dia_diem)
    TextView txtDiaDiem;
    @BindView(R.id.txt_content)
    TextView txtContent;
    @BindView(R.id.edt_tra_loi)
    EditText edtTraLoi;
    @BindView(R.id.btn_send_answer)
    ImageView btnSendAnswer;
    @BindView(R.id.view_tra_loi)
    RelativeLayout viewTraLoi;
    @BindView(R.id.img_avatar_tra_loi)
    CircleImageView imgAvatarTraLoi;
    @BindView(R.id.txt_ten_tra_loi)
    TextView txtTenTraLoi;
    @BindView(R.id.txt_noi_dung_tra_loi)
    TextView txtNoiDungTraLoi;
    @BindView(R.id.view_cau_tra_loi)
    LinearLayout viewCauTraLoi;
    @BindView(R.id.txt_rating)
    TextView txtRating;
    @BindView(R.id.rating_bar)
    RatingBar ratingBar;
    @BindView(R.id.txt_number_rating)
    TextView txtNumberRating;
    @BindView(R.id.view_rating)
    LinearLayout viewRating;
    @BindView(R.id.rating_bar_nhan_xet)
    RatingBar ratingBarNhanXet;
    @BindView(R.id.btn_gui_danh_gia)
    TextView btnGuiDanhGia;
    @BindView(R.id.view_danh_gia)
    LinearLayout viewDanhGia;
    @BindView(R.id.txt_quan_tam)
    TextView txtQuanTam;
    @BindView(R.id.txt_binh_luan)
    TextView txtBinhLuan;
    @BindView(R.id.txt_chia_se)
    TextView txtChiaSe;
    @BindView(R.id.rcv_cmt)
    RecyclerView rcvCmt;
    @BindView(R.id.edt_binh_luan)
    EditText edtBinhLuan;
    @BindView(R.id.btn_send)
    ImageView btnSend;
    @BindView(R.id.btn_attach)
    ImageView btnAttach;
    @BindView(R.id.rcv_image)
    RecyclerView rcvImage;
    @BindView(R.id.view_binh_luan)
    RelativeLayout viewBinhLuan;
    @BindView(R.id.view_comment)
    LinearLayout viewComment;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;
    @BindView(R.id.btn_xem_them)
    TextView btnXemThem;
    @BindView(R.id.txt_dang_cho_phan_hoi)
    TextView txtDangChoPhanHoi;
    @BindView(R.id.view_button)
    LinearLayout viewButton;

    private ImageViewPagerAdapter imagePagerAdapter;
    private ImageSelectedAdapter imageSelectedAdapter;
    private BinhLuanAdapter binhLuanAdapter;
    private ArrayList<String> listImage;
    private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss");
    private final SimpleDateFormat formatTo = new SimpleDateFormat("dd' tháng 'MM' lúc 'HH:mm");
    private PhanAnh phanAnh;
    private int id;
    private int roleId;

    @Override
    public int getContentViewId() {
        return R.layout.activity_phan_anh_chi_tiet;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);
        roleId = PrefUtil.getDataUser(this).getRoleId();
        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getIntExtra(Key.PHAN_ANH_ID, 0);
            if (id != 0) {
                getPresenter().getPhanAnhById(id);
            }
        }

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                phanAnh = null;
                getPresenter().getPhanAnhById(id);
            }
        });

        listImage = new ArrayList<>();
        imageSelectedAdapter = new ImageSelectedAdapter(listImage, this);
        rcvImage.setAdapter(imageSelectedAdapter);
    }

    @Override
    public PhanAnhChiTietPresenter createPresenter() {
        return new PhanAnhChiTietPresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_send_answer, R.id.img_avatar_tra_loi, R.id.btn_gui_danh_gia, R.id.btn_send,
            R.id.btn_attach, R.id.btn_xem_them})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_send_answer:
                String answer = edtTraLoi.getText().toString();
                if (!answer.isEmpty()) {
                    traLoi(answer);
                }
                break;
            case R.id.img_avatar_tra_loi:
                break;
            case R.id.btn_gui_danh_gia:
                float rating = ratingBarNhanXet.getRating();
                danhGia(rating);
                break;
            case R.id.btn_send:
                String binhLuan = edtBinhLuan.getText().toString();
                if (!binhLuan.isEmpty()) {
                    addComment(binhLuan);
                    edtBinhLuan.setText("");
                }

                break;
            case R.id.btn_attach:
                ImagePicker.create(this).start();
                break;
            case R.id.btn_xem_them:
                binhLuanAdapter.setArrayList((ArrayList<Comment>) phanAnh.getCOMMENTS());
                binhLuanAdapter.notifyDataSetChanged();
                btnXemThem.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            // Get a list of picked images
            List<Image> images = ImagePicker.getImages(data);
            for (Image image : images) {
                listImage.add(image.getPath());
            }
            imageSelectedAdapter.notifyDataSetChanged();

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onGetPhanAnh(PhanAnh data) throws ParseException {
        swipeLayout.setRefreshing(false);
        if (phanAnh == null) {
            phanAnh = data;
            if (data.getFILEs().size() == 0) {
                vpImageTask.setVisibility(View.GONE);
            } else {
                ArrayList<String> images = new ArrayList<>();
                for (FILE file : data.getFILEs()) {
                    images.add(file.getFILE());
                }
                imagePagerAdapter = new ImageViewPagerAdapter(this, images);
                imagePagerAdapter.setOnItemClickListener(new ImageViewPagerAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(int position) {
                        Intent intent = SlideImage.getCallingIntent(PhanAnhChiTietActivity.this);
                        intent.putExtra(Key.ARRIMG, images);
                        intent.putExtra(Key.POSITION, position);
                        startActivity(intent);
                    }
                });
                vpImageTask.setAdapter(imagePagerAdapter);
                vpImageTask.setVisibility(View.VISIBLE);
            }
            txtTitle.setText(data.getTIEUDEPA());
            txtTime.setText(formatTo.format(format.parse(data.getNGAYTAO())));
            txtDiaDiem.setText(data.getNOIPHANANH());
            txtContent.setText(data.getNOIDUNG());
            int roleId = PrefUtil.getDataUser(this).getRoleId();
            if (data.getMUCDOCONGKHAIID() == Key.CA_NHAN) {
                if (roleId == Key.USER) {
                    viewRating.setVisibility(View.GONE);
                    viewDanhGia.setVisibility(View.GONE);
                    viewButton.setVisibility(View.GONE);
                    viewComment.setVisibility(View.GONE);
                    viewTraLoi.setVisibility(View.GONE);
                    if (data.getTRANGTHAI() == Key.DA_TRA_LOI) {
                        viewCauTraLoi.setVisibility(View.VISIBLE);
                        txtDangChoPhanHoi.setVisibility(View.GONE);
                    } else {
                        viewCauTraLoi.setVisibility(View.GONE);
                        txtDangChoPhanHoi.setVisibility(View.VISIBLE);
                    }
                } else if (roleId == Key.MANAGER) {
                    viewDanhGia.setVisibility(View.GONE);
                    viewComment.setVisibility(View.GONE);
                    txtDangChoPhanHoi.setVisibility(View.GONE);
                    if (data.getTRANGTHAI() == Key.DA_TRA_LOI) {
                        viewCauTraLoi.setVisibility(View.VISIBLE);
                        viewTraLoi.setVisibility(View.GONE);
                        viewRating.setVisibility(View.VISIBLE);
                        viewButton.setVisibility(View.VISIBLE);
                    } else {
                        viewCauTraLoi.setVisibility(View.GONE);
                        viewTraLoi.setVisibility(View.VISIBLE);
                        viewRating.setVisibility(View.GONE);
                        viewButton.setVisibility(View.GONE);
                    }
                }
            } else {
                viewComment.setVisibility(View.VISIBLE);
                viewButton.setVisibility(View.VISIBLE);
                viewTraLoi.setVisibility(View.GONE);
                txtDangChoPhanHoi.setVisibility(View.GONE);
                if (data.getTRANGTHAI() == Key.DA_TRA_LOI) {
                    viewCauTraLoi.setVisibility(View.VISIBLE);
                    viewRating.setVisibility(View.VISIBLE);
                    viewDanhGia.setVisibility(View.VISIBLE);
                } else {
                    viewCauTraLoi.setVisibility(View.GONE);
                    viewRating.setVisibility(View.GONE);
                    viewDanhGia.setVisibility(View.GONE);
                }
            }

            Glide.with(this).load(data.getAVATARNGTL()).into(imgAvatarTraLoi);
            txtTenTraLoi.setText(data.getTENNGTL());
            txtNoiDungTraLoi.setText(data.getTRALOI());
            ratingBar.setRating(data.getdANHGIA());
            txtRating.setText(data.getdANHGIA() + "");
            txtNumberRating.setText(data.getsLDANHGIA() + " " + getString(R.string.danh_gia));

            ArrayList<Comment> comments = new ArrayList<>();
            if (data.getCOMMENTS().size() > 10) {
                comments.addAll(data.getCOMMENTS().subList(0, 10));
            } else {
                comments.addAll(data.getCOMMENTS());
            }
            binhLuanAdapter = new BinhLuanAdapter(this, comments);
            rcvCmt.setLayoutManager(new LinearLayoutManager(this));
            rcvCmt.setAdapter(binhLuanAdapter);

            if (data.getCOMMENTS().size() > 10) {
                btnXemThem.setVisibility(View.VISIBLE);
            } else {
                btnXemThem.setVisibility(View.GONE);
            }

        } else {
            phanAnh = data;
            binhLuanAdapter.setArrayList((ArrayList<Comment>) phanAnh.getCOMMENTS());
            binhLuanAdapter.notifyDataSetChanged();

            ratingBar.setRating(data.getdANHGIA());
            txtRating.setText(data.getdANHGIA() + "");
            txtNumberRating.setText(data.getsLDANHGIA() + " " + getString(R.string.danh_gia));
        }
    }

    @Override
    public void onCommentSuccess() {
        getPresenter().getPhanAnhById(id);
        listImage.clear();
        imageSelectedAdapter.notifyDataSetChanged();
    }

    @Override
    public void onUploadImageFail(String message) {
        Util.showMessenger(message, this);
    }

    @Override
    public void onDanhGiaSuccess() {
        getPresenter().getPhanAnhById(id);
        btnGuiDanhGia.setVisibility(View.INVISIBLE);
        ratingBarNhanXet.setIsIndicator(true);
    }

    @Override
    public void onDanhGiaFail(String message) {
        Util.showMessenger(message, this);
        btnGuiDanhGia.setVisibility(View.INVISIBLE);
        ratingBarNhanXet.setIsIndicator(true);
    }

    @Override
    public void onTraLoiSuccess() {
        getPresenter().getPhanAnhById(id);
        setResult(RESULT_OK);
    }

    private void showDialogNhapThongTin(OnNhapThongTinListener onNhapThongTinListener){
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_nhap_thong_tin, null);
        builder2.setView(view);
        AlertDialog dialog = builder2.create();
        EditText edtName = view.findViewById(R.id.edt_name);
        EditText edtPhone = view.findViewById(R.id.edt_phone);
        EditText edtEmail = view.findViewById(R.id.edt_email);
        EditText edtAddress = view.findViewById(R.id.edt_dia_chi);
        view.findViewById(R.id.btn_tiep_tuc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String phone = edtPhone.getText().toString();
                String email = edtEmail.getText().toString();
                String address = edtAddress.getText().toString();

                if (name.isEmpty()){
                    Util.showMessenger(getString(R.string.nhap_ho_ten), PhanAnhChiTietActivity.this);
                }else if (phone.isEmpty()){
                    Util.showMessenger(getString(R.string.nhap_sdt), PhanAnhChiTietActivity.this);
                }else if (email.isEmpty()){
                    Util.showMessenger(getString(R.string.nhap_email), PhanAnhChiTietActivity.this);
                }else if (address.isEmpty()){
                    Util.showMessenger(getString(R.string.nhap_dia_chi), PhanAnhChiTietActivity.this);
                }else {
                    User user = PrefUtil.getDataUser(PhanAnhChiTietActivity.this);
                    user.setFullName(name);
                    user.setPhone(phone);
                    user.setEmailID(email);
                    user.setDiaChi(address);
                    PrefUtil.saveDataUser(user, PhanAnhChiTietActivity.this);
                    dialog.dismiss();
                    onNhapThongTinListener.onFinish();
                }

            }
        });
        view.findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(LoginActivity.getCallingIntent(PhanAnhChiTietActivity.this));
            }
        });
        view.findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.show();
    }

    private void addComment(String binhLuan){
        if (roleId == Key.UNDEFINED){
            if (PrefUtil.getDataUser(this).getFullName() == null || PrefUtil.getDataUser(this).getFullName().isEmpty()){
                showDialogNhapThongTin(new OnNhapThongTinListener() {
                    @Override
                    public void onFinish() {
                        addComment(binhLuan);
                    }
                });
            }else {
                String hoten = PrefUtil.getDataUser(this).getFullName();
                String sdt = PrefUtil.getDataUser(this).getPhone();
                String email = PrefUtil.getDataUser(this).getEmailID();
                String diaChi = PrefUtil.getDataUser(this).getDiaChi();
                getPresenter().addComment(id, binhLuan, hoten, sdt, email, diaChi, listImage);
            }
        }else {
            getPresenter().addComment(id, binhLuan, "", "", "", "", listImage);
        }

    }

    private void traLoi(String answer){
        getPresenter().traLoiPhanAnh(id, answer);
    }

    private void danhGia(float rating){
        if (roleId == Key.UNDEFINED){
            if (PrefUtil.getDataUser(this).getFullName() == null || PrefUtil.getDataUser(this).getFullName().isEmpty()){
                showDialogNhapThongTin(new OnNhapThongTinListener() {
                    @Override
                    public void onFinish() {
                        danhGia(rating);
                    }
                });
            }else {
                String hoten = PrefUtil.getDataUser(this).getFullName();
                String sdt = PrefUtil.getDataUser(this).getPhone();
                String email = PrefUtil.getDataUser(this).getEmailID();
                String diaChi = PrefUtil.getDataUser(this).getDiaChi();
                getPresenter().addDanhGia(id, rating, hoten, sdt, email, diaChi);
            }
        }else {
            getPresenter().addDanhGia(id, rating, "", "", "", "");
        }
    }

    public interface OnNhapThongTinListener{
        void onFinish();
    }
}