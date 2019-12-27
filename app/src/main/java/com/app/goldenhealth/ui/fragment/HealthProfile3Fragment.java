package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.HoXi;
import com.app.goldenhealth.model.YeuToNguyCo;
import com.app.goldenhealth.presenter.HealthProfile3Presenter;
import com.app.goldenhealth.presenter.impl.HealthProfile3PresenterImpl;
import com.app.goldenhealth.util.Util;

import java.util.ArrayList;

public class HealthProfile3Fragment extends BaseFragment<HealthProfile3Presenter> implements HealthProfile3View {

    private static final String TAG = "YTNC";
    @BindView(R.id.rb_co_hut_thuoc)
    CheckBox rbCoHutThuoc;
    @BindView(R.id.rb_khong_hut_thuoc)
    CheckBox rbKhongHutThuoc;
    @BindView(R.id.rb_da_bo_hut_thuoc)
    CheckBox rbDaBoHutThuoc;
    @BindView(R.id.rb_co_hut_thuong_xuyen)
    CheckBox rbCoHutThuongXuyen;
    @BindView(R.id.rb_khong_hut_thuong_xuyen)
    CheckBox rbKhongHutThuongXuyen;
    @BindView(R.id.view_hut_thuong_xuyen)
    LinearLayout viewHutThuongXuyen;
    @BindView(R.id.rb_co_uong_ruou)
    CheckBox rbCoUongRuou;
    @BindView(R.id.rb_khong_uong_ruou)
    CheckBox rbKhongUongRuou;
    @BindView(R.id.edt_so_coc_mot_ngay)
    EditText edtSoCocMotNgay;
    @BindView(R.id.rb_da_bo_ruou)
    CheckBox rbDaBoRuou;
    @BindView(R.id.view_uong_thuong_xuyen)
    LinearLayout viewUongThuongXuyen;
    @BindView(R.id.rb_co_dung_ma_tuy)
    CheckBox rbCoDungMaTuy;
    @BindView(R.id.rb_khong_dung_ma_tuy)
    CheckBox rbKhongDungMaTuy;
    @BindView(R.id.rb_da_bo_ma_tuy)
    CheckBox rbDaBoMaTuy;
    @BindView(R.id.rb_co_dung_ma_tuy_thuong_xuyen)
    CheckBox rbCoDungMaTuyThuongXuyen;
    @BindView(R.id.rb_khong_dung_ma_tuy_thuong_xuyen)
    CheckBox rbKhongDungMaTuyThuongXuyen;
    @BindView(R.id.view_dung_ma_tuy_thuong_xuyen)
    LinearLayout viewDungMaTuyThuongXuyen;
    @BindView(R.id.rb_co_hoat_dong_the_luc)
    CheckBox rbCoHoatDongTheLuc;
    @BindView(R.id.rb_khong_hoat_dong_the_luc)
    CheckBox rbKhongHoatDongTheLuc;
    @BindView(R.id.rb_co_the_duc_thuong_xuyen)
    CheckBox rbCoTheDucThuongXuyen;
    @BindView(R.id.rb_khong_the_duc_thuong_xuyen)
    CheckBox rbKhongTheDucThuongXuyen;
    @BindView(R.id.view_the_duc_thuong_xuyen)
    LinearLayout viewTheDucThuongXuyen;
    @BindView(R.id.edt_moi_truong)
    EditText edtMoiTruong;
    @BindView(R.id.edt_thoi_gian_tiep_xuc)
    EditText edtThoiGianTiepXuc;
    @BindView(R.id.edt_loai_ho_xi)
    TextView edtLoaiHoXi;
    @BindView(R.id.edt_nguy_co_nghe_nghiep)
    EditText edtNguyCoNgheNghiep;
    @BindView(R.id.edt_nguy_co_khac)
    EditText edtNguyCoKhac;
    Unbinder unbinder;
    private String[] listHoXiName;
    private ArrayList<HoXi> hoXis;
    private int hoXiID;
    private YeuToNguyCo yeuToNguyCo;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_health_profile_3;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getYeuToNguyCo();
        getPresenter().getHoXi();

        rbCoHutThuoc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    viewHutThuongXuyen.setVisibility(View.VISIBLE);
                    rbKhongHutThuoc.setChecked(false);
                } else {
                    viewHutThuongXuyen.setVisibility(View.GONE);
                }
            }
        });

        rbKhongHutThuoc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbCoHutThuoc.setChecked(false);
                }
            }
        });

        rbCoHutThuongXuyen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    rbKhongHutThuongXuyen.setChecked(false);
                }
            }
        });

        rbKhongHutThuongXuyen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbCoHutThuongXuyen.setChecked(false);
                }
            }
        });

        rbCoUongRuou.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    viewUongThuongXuyen.setVisibility(View.VISIBLE);
                    rbKhongUongRuou.setChecked(false);
                } else {
                    viewUongThuongXuyen.setVisibility(View.GONE);
                }
            }
        });

        rbKhongUongRuou.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbCoUongRuou.setChecked(false);
                }
            }
        });

        rbCoDungMaTuy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    viewDungMaTuyThuongXuyen.setVisibility(View.VISIBLE);
                    rbKhongDungMaTuy.setChecked(false);
                } else {
                    viewDungMaTuyThuongXuyen.setVisibility(View.GONE);
                }
            }
        });

        rbKhongDungMaTuy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbCoDungMaTuy.setChecked(false);
                }
            }
        });

        rbCoDungMaTuyThuongXuyen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbKhongDungMaTuyThuongXuyen.setChecked(false);
                }
            }
        });

        rbKhongDungMaTuyThuongXuyen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbCoDungMaTuyThuongXuyen.setChecked(false);
                }
            }
        });

        rbCoHoatDongTheLuc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    viewTheDucThuongXuyen.setVisibility(View.VISIBLE);
                    rbKhongHoatDongTheLuc.setChecked(false);
                } else {
                    viewTheDucThuongXuyen.setVisibility(View.GONE);
                }
            }
        });

        rbKhongHoatDongTheLuc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbCoHoatDongTheLuc.setChecked(false);
                }
            }
        });

        rbCoTheDucThuongXuyen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbKhongTheDucThuongXuyen.setChecked(false);
                }

            }
        });

        rbKhongTheDucThuongXuyen.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    rbCoTheDucThuongXuyen.setChecked(false);
                }

            }
        });

    }

    @Override
    public HealthProfile3Presenter createPresenter() {
        return new HealthProfile3PresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetInfo(YeuToNguyCo data) {
        yeuToNguyCo = data;
        if (data.getHUTTHUOCLAO() == 1) {
            rbCoHutThuoc.setChecked(true);
        } else if (data.getHUTTHUOCLAO() == -1) {
            rbKhongHutThuoc.setChecked(true);
        }

        if (data.getHUTLIENTUC() == 1) {
            rbCoHutThuongXuyen.setChecked(true);
        } else if (data.getHUTLIENTUC() == -1) {
            rbKhongHutThuongXuyen.setChecked(true);
        }

        if (data.getDABOTHUOC() == 1) {
            rbDaBoHutThuoc.setChecked(true);
        }

        if (data.getUONGRUOUBIA() == 1) {
            rbCoUongRuou.setChecked(true);
        } else if (data.getUONGRUOUBIA() == -1) {
            rbKhongUongRuou.setChecked(true);
        }

        edtSoCocMotNgay.setText(data.getDONVIRUOU().toString());

        if (data.getDABORUOU() == 1) {
            rbDaBoRuou.setChecked(true);
        }

        if (data.getSDMATUY() == 1) {
            rbCoDungMaTuy.setChecked(true);
        } else if (data.getSDMATUY() == -1) {
            rbKhongDungMaTuy.setChecked(true);
        }

        if (data.getSDMTLIENTUC() == 1) {
            rbCoDungMaTuyThuongXuyen.setChecked(true);
        } else if (data.getSDMTLIENTUC() == -1) {
            rbKhongDungMaTuyThuongXuyen.setChecked(true);
        }

        if (data.getDABOMATUY() == 1) {
            rbDaBoMaTuy.setChecked(true);
        }

        if (data.getITHOATDONG() == 1) {
            rbCoHoatDongTheLuc.setChecked(true);
        } else if (data.getITHOATDONG() == -1) {
            rbKhongHoatDongTheLuc.setChecked(true);
        }

        if (data.getTXTAPTDTT() == 1) {
            rbCoTheDucThuongXuyen.setChecked(true);
        } else if (data.getTXTAPTDTT() == -1) {
            rbKhongTheDucThuongXuyen.setChecked(true);
        }

        edtMoiTruong.setText(data.getMOITRUONG());
        edtThoiGianTiepXuc.setText(data.getTGTIEPXUC().toString());
        edtLoaiHoXi.setText(data.getLOAIHOXI());
        edtNguyCoNgheNghiep.setText(data.getNGUYCONN() == null ? "" : data.getNGUYCONN());
        edtNguyCoKhac.setText(data.getNGUYCOKHAC() == null ? "" : data.getNGUYCOKHAC());
        hoXiID = data.getLOAIHOXIID();

        if (rbCoHutThuoc.isChecked()) {
            viewHutThuongXuyen.setVisibility(View.VISIBLE);
        } else {
            viewHutThuongXuyen.setVisibility(View.GONE);
        }

        if (rbCoUongRuou.isChecked()) {
            viewUongThuongXuyen.setVisibility(View.VISIBLE);
        } else {
            viewUongThuongXuyen.setVisibility(View.GONE);
        }

        if (rbCoDungMaTuy.isChecked()) {
            viewDungMaTuyThuongXuyen.setVisibility(View.VISIBLE);
        } else {
            viewDungMaTuyThuongXuyen.setVisibility(View.GONE);
        }

        if (rbCoHoatDongTheLuc.isChecked()) {
            viewTheDucThuongXuyen.setVisibility(View.VISIBLE);
        } else {
            viewTheDucThuongXuyen.setVisibility(View.GONE);
        }
    }

    @Override
    public void onGetListHoXi(ArrayList<HoXi> data) {
        hoXis = data;
        listHoXiName = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            listHoXiName[i] = data.get(i).getTEN();
        }
    }


    @OnClick(R.id.edt_loai_ho_xi)
    public void onViewClicked() {
        if (listHoXiName != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(getString(R.string.loai_ho_xi))
                    .setItems(listHoXiName, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            edtLoaiHoXi.setText(listHoXiName[which]);
                            hoXiID = hoXis.get(which).getID();
                        }
                    });
            builder.create().show();
        }

    }

    public void update() {
        int hutThuoc = rbCoHutThuoc.isChecked() ? 1 : (rbKhongHutThuoc.isChecked() ? -1 : 0);
        int hutThuongXuyen = rbCoHutThuongXuyen.isChecked() ? 1 : (rbKhongHutThuongXuyen.isChecked() ? -1 : 0);
        int daBoThuoc = rbDaBoHutThuoc.isChecked() ? 1 : 0;
        int uongRuou = rbCoUongRuou.isChecked() ? 1 : (rbKhongUongRuou.isChecked() ? -1 : 0);
        double soDonViRuou = Double.parseDouble(edtSoCocMotNgay.getText().toString().isEmpty() ?
                "0" : edtSoCocMotNgay.getText().toString());
        int daBoRuou = rbDaBoRuou.isChecked() ? 1 : 0;
        int dungMaTuy = rbCoDungMaTuy.isChecked() ? 1 : (rbKhongDungMaTuy.isChecked() ? -1 : 0);
        int dungMaTuyThuongXuyen = rbCoDungMaTuyThuongXuyen.isChecked() ? 1 : (rbKhongDungMaTuyThuongXuyen.isChecked() ? -1 : 0);
        int daBoMaTuy = rbDaBoMaTuy.isChecked() ? 1 : 0;
        int hoatDongTheLuc = rbCoHoatDongTheLuc.isChecked() ? 1 : (rbKhongHoatDongTheLuc.isChecked() ? -1 : 0);
        int thuongXuyenTapTheDuc = rbCoTheDucThuongXuyen.isChecked() ? 1 : (rbKhongTheDucThuongXuyen.isChecked() ? -1 : 0);
        String moiTruong = edtMoiTruong.getText().toString();
        double thoiGianTX = Double.parseDouble(edtThoiGianTiepXuc.getText().toString());
        String nguyCoNN = edtNguyCoNgheNghiep.getText().toString();
        String nguyCoKhac = edtNguyCoKhac.getText().toString();

        Log.d(TAG, "update: " + daBoThuoc);
        getPresenter().update(hutThuoc, hutThuongXuyen, daBoThuoc, uongRuou, soDonViRuou, daBoRuou, dungMaTuy,
                dungMaTuyThuongXuyen, daBoMaTuy, hoatDongTheLuc, thuongXuyenTapTheDuc, moiTruong, thoiGianTX,
                hoXiID, nguyCoNN, nguyCoKhac);
    }

    @Override
    public void onUpdateSuccess() {
        Util.showMessenger(getString(R.string.update_sucsess), getContext());
    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, getContext());
    }

}