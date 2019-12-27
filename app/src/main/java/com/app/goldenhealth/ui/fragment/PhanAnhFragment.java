package com.app.goldenhealth.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
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
import com.app.goldenhealth.model.ChuDePhanAnh;
import com.app.goldenhealth.model.DiaDiemPhanAnh;
import com.app.goldenhealth.model.PhanAnh;
import com.app.goldenhealth.presenter.PhanAnhPresenter;
import com.app.goldenhealth.presenter.impl.PhanAnhPresenterImpl;
import com.app.goldenhealth.ui.activity.PhanAnhChiTietActivity;
import com.app.goldenhealth.ui.activity.PhanAnhMoiNguoiActivity;
import com.app.goldenhealth.ui.adapter.PhanAnhAdapter;
import com.app.goldenhealth.util.EndlessRecyclerViewScrollListener;
import com.app.goldenhealth.util.PrefUtil;

import java.util.ArrayList;

public class PhanAnhFragment extends BaseFragment<PhanAnhPresenter> implements PhanAnhView {
    private static final int REQUEST_CODE_PHAN_ANH = 999;
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.edt_search)
    EditText edtSearch;
    @BindView(R.id.btn_filter)
    ImageView btnFilter;
    @BindView(R.id.txt_chuyen_muc)
    TextView txtChuyenMuc;
    @BindView(R.id.txt_sap_xep)
    TextView txtSapXep;
    @BindView(R.id.txt_type)
    TextView txtType;
    @BindView(R.id.rcv)
    RecyclerView rcv;
    @BindView(R.id.btn_tao_phan_anh)
    Button btnTaoPhanAnh;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;

    private PhanAnhAdapter adapter;
    private ArrayList<PhanAnh> arrayList;
    private ChonNoiPhanAnhFragment chonNoiPhanAnhFragment;
    private TaoPhanAnhFragment taoPhanAnhFragment;
    private ChuDePhanAnhFragment chuDePhanAnhFragment;
    private int noiPAId;
    private int mucPAId;
    private int mucCongKhai;
    private int orderBy = 1;
    private String[] types = {"Công khai", "Cá nhân"};
    private ArrayList<ChuDePhanAnh> chuDePhanAnhs;
    private String[] listChuDe;
    private EndlessRecyclerViewScrollListener scrollListener;


    @Override
    public int getContentViewId() {
        return R.layout.fragment_phan_anh;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        int roleId = PrefUtil.getDataUser(getContext()).getRoleId();
        if (roleId == Key.UNDEFINED){
            txtType.setVisibility(View.GONE);
        }
        mucCongKhai = Key.CONG_KHAI;
        txtType.setText(R.string.cong_khai);
        getPresenter().getPhanAnh("", mucCongKhai , mucPAId, noiPAId, orderBy, false);
        adapter = new PhanAnhAdapter(getContext(), getPresenter().getListPhanAnh());
        adapter.setOnItemClickListener(new PhanAnhAdapter.OnItemClickListener() {
            @Override
            public void onClick(int id) {
                Intent intent = new Intent(getContext(), PhanAnhChiTietActivity.class);
                intent.putExtra(Key.PHAN_ANH_ID, id);
                startActivityForResult(intent, REQUEST_CODE_PHAN_ANH);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(linearLayoutManager);
        rcv.setAdapter(adapter);

        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                getPresenter().getPhanAnh(edtSearch.getText().toString(), mucCongKhai, mucPAId, noiPAId, orderBy, false);
            }
        };
        rcv.addOnScrollListener(scrollListener);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPresenter().getPhanAnh(edtSearch.getText().toString(), mucCongKhai, mucPAId, noiPAId, orderBy, true);
            }
        });
    }

    @Override
    public PhanAnhPresenter createPresenter() {
        return new PhanAnhPresenterImpl(this);
    }

    @OnClick({R.id.btn_filter, R.id.txt_chuyen_muc, R.id.txt_sap_xep, R.id.txt_type, R.id.btn_tao_phan_anh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_filter:
                if (chonNoiPhanAnhFragment == null) {
                    chonNoiPhanAnhFragment = new ChonNoiPhanAnhFragment();
                }
                chonNoiPhanAnhFragment.setOnItemClickListener(new ChonNoiPhanAnhFragment.OnItemClickListener() {
                    @Override
                    public void onClick(DiaDiemPhanAnh diaDiemPhanAnh) {
                        noiPAId = diaDiemPhanAnh.getId();
                    }
                });
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, chonNoiPhanAnhFragment)
                        .addToBackStack(null).commit();
                break;
            case R.id.txt_chuyen_muc:
                if (chuDePhanAnhFragment == null){
                    chuDePhanAnhFragment = new ChuDePhanAnhFragment();
                }
                chuDePhanAnhFragment.setOnItemClickListener(new ChuDePhanAnhFragment.OnItemClickListener() {
                    @Override
                    public void onClick(ChuDePhanAnh chuDePhanAnh) {
                        mucPAId = chuDePhanAnh.getId();
                        getPresenter().getPhanAnh(edtSearch.getText().toString(), mucCongKhai, mucPAId, noiPAId, orderBy, true);
                    }
                });
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, chuDePhanAnhFragment)
                        .addToBackStack(null).commit();
                break;
            case R.id.txt_sap_xep:
                showSapXepDialog();
                break;
            case R.id.txt_type:
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setItems(types, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        txtTitle.setText(types[which]);
                        if (which == 0){
                            mucCongKhai = Key.CONG_KHAI;
                            txtType.setText(getString(R.string.cong_khai));
                            getPresenter().getPhanAnh(edtSearch.getText().toString(), mucCongKhai, mucPAId, noiPAId, orderBy, true);
                        }else {
                            mucCongKhai = Key.CA_NHAN;
                            txtType.setText(getString(R.string.ca_nhan));
                            getPresenter().getPhanAnh(edtSearch.getText().toString(), mucCongKhai, mucPAId, noiPAId, orderBy, true);
                        }
                        dialog.dismiss();
                    }
                }).create().show();
                break;
            case R.id.btn_tao_phan_anh:
                if (taoPhanAnhFragment == null) {
                    taoPhanAnhFragment = new TaoPhanAnhFragment();
                }
                getActivity().getSupportFragmentManager().beginTransaction().add(android.R.id.content, taoPhanAnhFragment)
                        .addToBackStack(null).commit();
                break;
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PHAN_ANH && resultCode == Activity.RESULT_OK){
            getPresenter().getPhanAnh(edtSearch.getText().toString(), mucCongKhai, mucPAId, noiPAId, orderBy, true);
        }
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
                        txtChuyenMuc.setText(chuDePhanAnhs.get(which).getNoiDung());
                        mucPAId = chuDePhanAnhs.get(which).getId();
                    }
                }).create().show();
    }

    @Override
    public void onGetDataFail() {
        swipeLayout.setRefreshing(false);
    }

    @Override
    public void onGetListPhanAnh() {
        swipeLayout.setRefreshing(false);
        adapter.notifyDataSetChanged();
    }

    private void showSapXepDialog(){
        AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_sap_xep, null);
        builder2.setView(view);
        AlertDialog dialog = builder2.create();
        view.findViewById(R.id.btn_ngay_giam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderBy = 1;
                getPresenter().getPhanAnh(edtSearch.getText().toString(), mucCongKhai, mucPAId, noiPAId, orderBy, true);
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.btn_ngay_tang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderBy = 2;
                getPresenter().getPhanAnh(edtSearch.getText().toString(), mucCongKhai, mucPAId, noiPAId, orderBy, true);
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.btn_quan_tam_giam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderBy = 3;
                getPresenter().getPhanAnh(edtSearch.getText().toString(), mucCongKhai, mucPAId, noiPAId, orderBy, true);
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.btn_quan_tam_tang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderBy = 4;
                getPresenter().getPhanAnh(edtSearch.getText().toString(), mucCongKhai, mucPAId, noiPAId, orderBy, true);
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.btn_binh_luan_giam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderBy = 5;
                getPresenter().getPhanAnh(edtSearch.getText().toString(), mucCongKhai, mucPAId, noiPAId, orderBy, true);
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.btn_binh_luan_tang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderBy = 6;
                getPresenter().getPhanAnh(edtSearch.getText().toString(), mucCongKhai, mucPAId, noiPAId, orderBy, true);
                dialog.dismiss();
            }
        });

        dialog.show();
    }


}