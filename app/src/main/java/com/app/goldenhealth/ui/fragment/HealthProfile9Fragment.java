package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.BPTT;
import com.app.goldenhealth.model.DanhMuc;
import com.app.goldenhealth.model.DanhMucType;
import com.app.goldenhealth.model.SKSS_KHHGD;
import com.app.goldenhealth.presenter.HealthProfile9Presenter;
import com.app.goldenhealth.presenter.impl.HealthProfile9PresenterImpl;
import com.app.goldenhealth.util.Util;

import java.util.ArrayList;

public class HealthProfile9Fragment extends BaseFragment<HealthProfile9Presenter> implements HealthProfile9View {

    @BindView(R.id.edt_bien_phap_tranh_thai)
    TextView edtBienPhapTranhThai;
    @BindView(R.id.edt_ky_co_thai_cuoi)
    EditText edtKyCoThaiCuoi;
    @BindView(R.id.edt_so_lan_co_thai)
    EditText edtSoLanCoThai;
    @BindView(R.id.edt_so_lan_sinh_de)
    EditText edtSoLanSinhDe;
    @BindView(R.id.edt_so_lan_say_thai)
    EditText edtSoLanSayThai;
    @BindView(R.id.edt_de_thuong)
    EditText edtDeThuong;
    @BindView(R.id.edt_so_lan_pha_thai)
    EditText edtSoLanPhaThai;
    @BindView(R.id.edt_de_mo)
    EditText edtDeMo;
    @BindView(R.id.edt_so_lan_de_du_thang)
    EditText edtSoLanDeDuThang;
    @BindView(R.id.edt_de_kho)
    EditText edtDeKho;
    @BindView(R.id.edt_so_lan_de_non)
    EditText edtSoLanDeNon;
    @BindView(R.id.edt_so_con_hien_song)
    EditText edtSoConHienSong;
    @BindView(R.id.edt_benh_phu_khoa)
    EditText edtBenhPhuKhoa;
    Unbinder unbinder;

    private ArrayList<Integer> bptts;
    private SKSS_KHHGD skss_khhgd;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_health_profile_9;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        getPresenter().getSKSS();
        bptts = new ArrayList<>();
    }

    @Override
    public HealthProfile9Presenter createPresenter() {
        return new HealthProfile9PresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetInfo(SKSS_KHHGD data) {
        skss_khhgd = data;
        for (BPTT bptt : data.getBPTTs()){
            bptts.add(bptt.getID());
            edtBienPhapTranhThai.append(bptt.getTEN() + ",");
        }
        edtKyCoThaiCuoi.setText(data.getKYTHAICUOI());
        edtSoLanCoThai.setText(data.getSOLANCOTHAI() + "");
        edtSoLanSayThai.setText(data.getSOLANSAYTHAI() + "");
        edtSoLanPhaThai.setText(data.getSOLANPHATHAI() + "");
        edtSoLanDeDuThang.setText(data.getSOLANDEDUTHANG() + "");
        edtSoLanDeNon.setText(data.getSOLANDENON() + "");
        edtSoLanSinhDe.setText(data.getSOLANDE() + "");
        edtDeThuong.setText(data.getDETHUONG() + "");
        edtDeMo.setText(data.getDEMO() + "");
        edtDeKho.setText(data.getDEKHO() + "");
        edtSoConHienSong.setText(data.getSOCONSONG() + "");
        edtBenhPhuKhoa.setText(data.getBENHPHUKHOA());
    }

    @OnClick(R.id.edt_bien_phap_tranh_thai)
    public void onViewClicked() {
        getPresenter().getDanhMuc(DanhMucType.BienPhapTranhThai);
    }

    @Override
    public void onUpdateSuccess() {
        Util.showMessenger(getString(R.string.update_sucsess), getContext());
    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, getContext());
    }

    @Override
    public void onGetListDanhMuc(ArrayList<DanhMuc> data) {
        String[] list = new String[data.size()];
        boolean[] checkeds = new boolean[data.size()];
        for (int i = 0; i < data.size(); i++) {
            list[i] = data.get(i).getTEN();
            if (bptts.contains(data.get(i).getID())){
                checkeds[i] = true;
            }else {
                checkeds[i] = false;
            }
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chọn ")
                .setMultiChoiceItems(list, checkeds,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    bptts.add(data.get(which).getID());
                                } else {
                                    // Else, if the item is already in the array, remove it
                                    for (int i=0; i<bptts.size(); i++){
                                        if (bptts.get(i).equals(data.get(which).getID())){
                                            bptts.remove(i);
                                            i--;
                                        }
                                    }
                                }
                            }
                        })
                .setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edtBienPhapTranhThai.setText("");
                        for (DanhMuc bptt : data){
                            if (bptts.contains(bptt.getID())){
                                edtBienPhapTranhThai.append(bptt.getTEN() + ", ");
                            }
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();

    }

    public void update(){

        String kyThaiCuoi = edtKyCoThaiCuoi.getText().toString();
        int soLanCoThai = Integer.parseInt(edtSoLanCoThai.getText().toString().isEmpty() ? "0" : edtSoLanCoThai.getText().toString());
        int soLanSayThai = Integer.parseInt(edtSoLanSayThai.getText().toString().isEmpty() ? "0" : edtSoLanSayThai.getText().toString());
        int soLanPhaThai = Integer.parseInt(edtSoLanPhaThai.getText().toString().isEmpty() ? "0" : edtSoLanPhaThai.getText().toString());
        int soLanDeDuThang = Integer.parseInt(edtSoLanDeDuThang.getText().toString().isEmpty() ? "0" : edtSoLanDeDuThang.getText().toString());
        int soLanDeNon = Integer.parseInt(edtSoLanDeNon.getText().toString().isEmpty() ? "0" : edtSoLanDeNon.getText().toString());
        int soLanDe = Integer.parseInt(edtSoLanSinhDe.getText().toString().isEmpty() ? "0" : edtSoLanSinhDe.getText().toString());
        int deThuong = Integer.parseInt(edtDeThuong.getText().toString().isEmpty() ? "0" : edtDeThuong.getText().toString());
        int deMo = Integer.parseInt(edtDeMo.getText().toString().isEmpty() ? "0" : edtDeMo.getText().toString());
        int deKho = Integer.parseInt(edtDeKho.getText().toString().isEmpty() ? "0" : edtDeKho.getText().toString());
        int soConSong = Integer.parseInt(edtSoConHienSong.getText().toString().isEmpty() ? "0" : edtSoConHienSong.getText().toString());
        String benhPhuKhoa = edtBenhPhuKhoa.getText().toString();

        getPresenter().update(bptts, kyThaiCuoi, soLanCoThai, soLanSayThai, soLanPhaThai, soLanDeDuThang, soLanDeNon, soLanDe,
                deThuong, deMo, deKho, soConSong, benhPhuKhoa);
    }

}