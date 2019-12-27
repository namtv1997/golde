package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import com.app.goldenhealth.model.DiUng;
import com.app.goldenhealth.model.LoaiBenh;
import com.app.goldenhealth.model.QuanHeGiaDinh;
import com.app.goldenhealth.model.TienSuBenh;
import com.app.goldenhealth.presenter.ThemTienSuBenhPresenter;
import com.app.goldenhealth.presenter.impl.ThemTienSuBenhPresenterImpl;
import com.app.goldenhealth.util.Util;

import java.util.ArrayList;

public class ThemTienSuBenhFragment extends BaseFragment<ThemTienSuBenhPresenter> implements ThemTienSuBenhView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.btn_done)
    ImageView btnDone;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.txt_ten_benh)
    TextView txtTenBenh;
    @BindView(R.id.txt_nguoi_mac)
    TextView txtNguoiMac;
    @BindView(R.id.edt_mo_ta)
    EditText edtMoTa;
    Unbinder unbinder;

    private ArrayList<LoaiBenh> loaiBenhArrayList;
    private ArrayList<QuanHeGiaDinh> quanHeGiaDinhArrayList;
    private String[] listLoaiBenhName;
    private String[] listQuanHeName;
    private int loaiBenhId = -1;
    private int quanHeId = -1;
    private int id;
    private ThemTienSuDiUngFragment.OnCreateSuccess onCreateSuccess;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_them_tien_su_benh;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null){
            id = bundle.getInt(Key.ID);
        }
        if (id != 0){
            txtTitle.setText(R.string.cap_nhat_tien_su_benh);
            getPresenter().getTienSuBenh(id);
        }else {
            txtTitle.setText(R.string.them_tien_su_benh_tat);
        }
    }

    @Override
    public ThemTienSuBenhPresenter createPresenter() {
        return new ThemTienSuBenhPresenterImpl(this);
    }


    @OnClick({R.id.btn_back, R.id.btn_done, R.id.txt_ten_benh, R.id.txt_nguoi_mac})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_done:
                String moTa = edtMoTa.getText().toString();
                if (loaiBenhId == -1 || quanHeId == -1){
                    Util.showMessenger(getString(R.string.chon_loai_benh_va_nguoi_mac), getContext());
                }else {
                    if (id != 0){
                        getPresenter().update(id, loaiBenhId, quanHeId, moTa);
                    }else {
                        getPresenter().create(loaiBenhId, quanHeId, moTa);
                    }

                }
                break;
            case R.id.txt_ten_benh:
                if (loaiBenhArrayList != null){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(getString(R.string.loai_di_ung))
                            .setItems(listLoaiBenhName, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    txtTenBenh.setText(listLoaiBenhName[which]);
                                    loaiBenhId = loaiBenhArrayList.get(which).getID();
                                }
                            }).create().show();
                }
                break;
            case R.id.txt_nguoi_mac:
                if (quanHeGiaDinhArrayList != null){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(getString(R.string.nguoi_mac))
                            .setItems(listQuanHeName, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    txtNguoiMac.setText(listQuanHeName[which]);
                                    quanHeId = quanHeGiaDinhArrayList.get(which).getID();
                                }
                            }).create().show();
                }
                break;
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetDanhSachBenh(ArrayList<LoaiBenh> data) {
        loaiBenhArrayList = data;
        listLoaiBenhName = new String[data.size()];
        for (int i=0; i<data.size(); i++){
            listLoaiBenhName[i] = data.get(i).getTEN();
        }
    }

    @Override
    public void onGetQuanHeGiaDinh(ArrayList<QuanHeGiaDinh> data) {
        quanHeGiaDinhArrayList = data;
        listQuanHeName = new String[data.size()];
        for (int i=0; i<data.size(); i++){
            listQuanHeName[i] = data.get(i).getTEN();
        }
    }

    @Override
    public void onCreateSuccess() {
        onCreateSuccess.onSuccess();
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, getContext());
    }

    @Override
    public void onGetTienSuBenh(TienSuBenh data) {
        txtTenBenh.setText(data.getLOAIBENH());
        loaiBenhId = data.getLOAIBENHID();
        txtNguoiMac.setText(data.getLOAIQH());
        quanHeId = data.getLOAIQHID();
        edtMoTa.setText(data.getMOTA());
    }

    public void setOnCreateSuccess(ThemTienSuDiUngFragment.OnCreateSuccess onCreateSuccess) {
        this.onCreateSuccess = onCreateSuccess;
    }

    public interface OnCreateSuccess{
        void onSuccess();
    }
}