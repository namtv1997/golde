package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
import com.app.goldenhealth.model.*;
import com.app.goldenhealth.presenter.TaoPhanAnhPresenter;
import com.app.goldenhealth.presenter.impl.TaoPhanAnhPresenterImpl;
import com.app.goldenhealth.ui.activity.LoginActivity;
import com.app.goldenhealth.ui.activity.PhanAnhChiTietActivity;
import com.app.goldenhealth.ui.adapter.CauHoiThuongGapAdapter;
import com.app.goldenhealth.ui.adapter.ImageSelectedAdapter;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaoPhanAnhFragment extends BaseFragment<TaoPhanAnhPresenter> implements TaoPhanAnhView {

    @BindView(R.id.edt_noi_dung)
    EditText edtNoiDung;
    @BindView(R.id.txt_do_cong_khai)
    TextView txtDoCongKhai;
    @BindView(R.id.btn_gui)
    TextView btnGui;
    @BindView(R.id.btn_theo_doi_phan_hoi)
    TextView btnTheoDoiPhanHoi;
    @BindView(R.id.txt_chu_de)
    TextView txtChuDe;
    @BindView(R.id.txt_noi_phan_anh)
    TextView txtNoiPhanAnh;
    @BindView(R.id.btn_file_dinh_kem)
    TextView btnFileDinhKem;
    @BindView(R.id.rcv_image)
    RecyclerView rcvImage;
    Unbinder unbinder;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.edt_tieu_de)
    EditText edtTieuDe;

    private ArrayList<DanhMuc> doCongKhais;
    private ArrayList<ChuDePhanAnh> chuDePhanAnhs;
    private ArrayList<DiaDiemPhanAnh> diaDiemPhanAnhs;
    private int mucDoCongKhai = 0;
    private int chuDeID = 0;
    private int noiPAId = 0;
    private String[] list;
    private String[] listChuDe;
    private String[] listNoiPA;
    private CauHoiThuongGapAdapter adapter;
    private ImageSelectedAdapter imageSelectedAdapter;
    private ArrayList<String> listImage;
    private ChonNoiPhanAnhFragment chonNoiPhanAnhFragment;
    private ChuDePhanAnhFragment chuDePhanAnhFragment;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_tao_phan_anh;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getCauHoiThuongGap();
        Bundle bundle = getArguments();
        if (bundle != null) {
            boolean isTitle = bundle.getBoolean(Key.TITLE);
            if (isTitle) {
                viewTitle.setVisibility(View.VISIBLE);
            }
        }

        listImage = new ArrayList<>();
        imageSelectedAdapter = new ImageSelectedAdapter(listImage, getContext());
        rcvImage.setAdapter(imageSelectedAdapter);
    }

    @Override
    public TaoPhanAnhPresenter createPresenter() {
        return new TaoPhanAnhPresenterImpl(this);
    }


    @OnClick({R.id.btn_gui, R.id.btn_theo_doi_phan_hoi, R.id.txt_do_cong_khai, R.id.txt_chu_de, R.id.txt_noi_phan_anh,
            R.id.btn_file_dinh_kem, R.id.btn_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_gui:
                createPhanAnh();
                break;
            case R.id.btn_theo_doi_phan_hoi:
//                PhanHoiFragment phanHoiFragment = new PhanHoiFragment();
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(android.R.id.content, phanHoiFragment)
//                        .addToBackStack(null)
//                        .commit();
                break;

            case R.id.txt_do_cong_khai:
                if (doCongKhais == null) {
                    getPresenter().getDanhMuc(DanhMucType.MucDoCongKhai);
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(R.string.chon_muc_do_phan_anh)
                            .setItems(list, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    txtDoCongKhai.setText(doCongKhais.get(which).getTEN());
                                    mucDoCongKhai = doCongKhais.get(which).getID();
                                    if (mucDoCongKhai == Key.CONG_KHAI) {
                                        txtNoiPhanAnh.setVisibility(View.GONE);
                                        noiPAId = 0;
                                    } else {
                                        txtNoiPhanAnh.setVisibility(View.VISIBLE);
                                    }
                                }
                            }).create().show();
                }

                break;
            case R.id.txt_chu_de:
//                if (chuDePhanAnhs == null) {
//                    getPresenter().getChuDePhanAnh();
//                } else {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                    builder.setTitle(R.string.chu_de_phan_anh)
//                            .setItems(listChuDe, new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int which) {
//                                    txtChuDe.setText(chuDePhanAnhs.get(which).getNoiDung());
//                                    chuDeID = chuDePhanAnhs.get(which).getId();
//                                }
//                            }).create().show();
//                }

                if (chuDePhanAnhFragment == null){
                    chuDePhanAnhFragment = new ChuDePhanAnhFragment();
                }
                chuDePhanAnhFragment.setOnItemClickListener(new ChuDePhanAnhFragment.OnItemClickListener() {
                    @Override
                    public void onClick(ChuDePhanAnh chuDePhanAnh) {
                        txtChuDe.setText(chuDePhanAnh.getNoiDung());
                        chuDeID = chuDePhanAnh.getId();
                    }
                });
                getActivity().getSupportFragmentManager().beginTransaction().add(android.R.id.content, chuDePhanAnhFragment)
                        .addToBackStack(null).commit();
                break;
            case R.id.txt_noi_phan_anh:
                if (chonNoiPhanAnhFragment == null) {
                    chonNoiPhanAnhFragment = new ChonNoiPhanAnhFragment();
                }
                chonNoiPhanAnhFragment.setOnItemClickListener(new ChonNoiPhanAnhFragment.OnItemClickListener() {
                    @Override
                    public void onClick(DiaDiemPhanAnh diaDiemPhanAnh) {
                        noiPAId = diaDiemPhanAnh.getId();
                        txtNoiPhanAnh.setText(diaDiemPhanAnh.getName());
                    }
                });
                getActivity().getSupportFragmentManager().beginTransaction().add(android.R.id.content, chonNoiPhanAnhFragment)
                        .addToBackStack(null).commit();
                break;

            case R.id.btn_file_dinh_kem:
                ImagePicker.create(this).start();
                break;
            case R.id.btn_back:
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
                break;
        }
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

    private void showDialogNhapThongTin(){
        AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());
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
                    Util.showMessenger(getString(R.string.nhap_ho_ten), getContext());
                }else if (phone.isEmpty()){
                    Util.showMessenger(getString(R.string.nhap_sdt), getContext());
                }else if (email.isEmpty()){
                    Util.showMessenger(getString(R.string.nhap_email), getContext());
                }else if (address.isEmpty()){
                    Util.showMessenger(getString(R.string.nhap_dia_chi), getContext());
                }else {
                    User user = PrefUtil.getDataUser(getContext());
                    user.setFullName(name);
                    user.setPhone(phone);
                    user.setEmailID(email);
                    user.setDiaChi(address);
                    PrefUtil.saveDataUser(user, getContext());
                    dialog.dismiss();
                    createPhanAnh();
                    return ;
                }

            }
        });
        view.findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(LoginActivity.getCallingIntent(getContext()));
            }
        });
        view.findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.show();
    }

    private void createPhanAnh() {
        String noiDung = edtNoiDung.getText().toString();
        String tieuDe = edtTieuDe.getText().toString();

        if (noiDung.isEmpty()) {
            Util.showMessenger(getString(R.string.nhap_noi_dung), getContext());
            return;
        }
        if (mucDoCongKhai == 0) {
            Util.showMessenger("Vui lòng chọn mức độ công khai!", getContext());
            return;
        }

        int roleId = PrefUtil.getDataUser(getContext()).getRoleId();
        if (roleId == Key.UNDEFINED){
            if (PrefUtil.getDataUser(getContext()).getFullName() == null || PrefUtil.getDataUser(getContext()).getFullName().isEmpty()){
                showDialogNhapThongTin();
            }else {
                String hoten = PrefUtil.getDataUser(getContext()).getFullName();
                String sdt = PrefUtil.getDataUser(getContext()).getPhone();
                String email = PrefUtil.getDataUser(getContext()).getEmailID();
                String diaChi = PrefUtil.getDataUser(getContext()).getDiaChi();
                getPresenter().createPhanAnh(tieuDe, chuDeID, noiPAId, noiDung, mucDoCongKhai, hoten, sdt, email, diaChi );
            }
        }else {
            getPresenter().createPhanAnh(tieuDe, chuDeID, noiPAId, noiDung, mucDoCongKhai, "", "", "", "" );
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetListMucDoCongKhai(ArrayList<DanhMuc> data) {
        doCongKhais = data;
        list = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            list[i] = data.get(i).getTEN();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.chon_muc_do_phan_anh)
                .setItems(list, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        txtDoCongKhai.setText(doCongKhais.get(which).getTEN());
                        mucDoCongKhai = doCongKhais.get(which).getID();
                        if (mucDoCongKhai == Key.CONG_KHAI) {
                            txtNoiPhanAnh.setVisibility(View.GONE);
                            noiPAId = 0;
                        } else {
                            txtNoiPhanAnh.setVisibility(View.VISIBLE);
                        }
                    }
                }).create().show();
    }

    @Override
    public void onCreateSuccess(Integer data) {
        if (listImage.size() > 0) {
            getPresenter().updateAnh(data, listImage);
        } else {
            txtTitle.setText("");
            txtChuDe.setText("");
            chuDeID = 0;
            txtNoiPhanAnh.setText("");
            noiPAId = 0;
            edtNoiDung.setText("");
            txtDoCongKhai.setText(getString(R.string.muc_do_cong_khai));
            mucDoCongKhai = 0;
            Util.showMessenger(getString(R.string.gui_phan_anh_thanh_cong), getContext());
        }

    }

    @Override
    public void onCreateFail(String message) {
        Util.showMessenger(message, getContext());
    }

    @Override
    public void onGetCauHoiThuongGap(ArrayList<CauHoiThuongGap> data) {

    }

    @Override
    public void onGetChuDePhanAnh(ArrayList<ChuDePhanAnh> data) {
        chuDePhanAnhs = data;
        listChuDe = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            listChuDe[i] = data.get(i).getNoiDung();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.chu_de_phan_anh)
                .setItems(listChuDe, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        txtChuDe.setText(chuDePhanAnhs.get(which).getNoiDung());
                        chuDeID = chuDePhanAnhs.get(which).getId();
                    }
                }).create().show();
    }

    @Override
    public void onUploadImageSuccess() {
        txtChuDe.setText("");
        chuDeID = 0;
        txtNoiPhanAnh.setText("");
        noiPAId = 0;
        edtNoiDung.setText("");
        txtDoCongKhai.setText("");
        mucDoCongKhai = 0;
        listImage.clear();
        imageSelectedAdapter.notifyDataSetChanged();
        Util.showMessenger(getString(R.string.gui_phan_anh_thanh_cong), getContext());
    }

    @Override
    public void onUploadImageFail(String message) {
        Util.showMessenger(message, getContext());
    }

}