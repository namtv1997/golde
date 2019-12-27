package com.app.goldenhealth.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseActivity;
import com.app.goldenhealth.model.PhanAnh;
import com.app.goldenhealth.presenter.PhanAnhMoiNguoiPresenter;
import com.app.goldenhealth.presenter.impl.PhanAnhMoiNguoiPresenterImpl;
import com.app.goldenhealth.ui.adapter.PhanAnhAdapter;
import com.app.goldenhealth.util.PrefUtil;

import java.util.ArrayList;

public class PhanAnhMoiNguoiActivity extends BaseActivity<PhanAnhMoiNguoiPresenter> implements PhanAnhMoiNguoiView {
    private final int CONG_KHAI = 1;
    private final int CA_NHAN = 2;

    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.rcv)
    RecyclerView rcv;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;

    private PhanAnhAdapter adapter;
    private ArrayList<PhanAnh> arrayList;
    private  int roleID;
    private int chuDeID;
    private int phanAnhID;

    @Override
    public int getContentViewId() {
        return R.layout.activity_phan_anh_moi_nguoi;
    }

    @Override
    public void initializeComponents() {
        ButterKnife.bind(this);

        roleID = PrefUtil.getDataUser(this).getRoleId();
        Intent intent = getIntent();
        if (intent != null){
            chuDeID = intent.getIntExtra(Key.ID, 0);
            phanAnhID = intent.getIntExtra(Key.PHAN_ANH_ID, 0);
        }

        if (phanAnhID != 0){
            getPresenter().getPhanAnhById(phanAnhID);
        }else {
            if (chuDeID != 0){
                getPresenter().getPhanAnhMoiNguoi(chuDeID);
            }else {
                if (roleID == Key.USER){
                    getPresenter().getPhanAnh();
                }else if (roleID == Key.FACILITY){
                    getPresenter().getPhanAnhCSYT();
                }
            }
        }

        arrayList = new ArrayList<>();
        adapter = new PhanAnhAdapter(this, arrayList);
        adapter.setOnItemClickListener(new PhanAnhAdapter.OnItemClickListener() {
            @Override
            public void onClick(int id) {

            }

        });
        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setAdapter(adapter);

        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (phanAnhID != 0){
                    getPresenter().getPhanAnhById(phanAnhID);
                }else {
                    if (chuDeID != 0){
                        getPresenter().getPhanAnhMoiNguoi(chuDeID);
                    }else {
                        if (roleID == Key.USER){
                            getPresenter().getPhanAnh();
                        }else if (roleID == Key.FACILITY){
                            getPresenter().getPhanAnhCSYT();
                        }
                    }
                }
            }
        });
    }

    @Override
    public PhanAnhMoiNguoiPresenter createPresenter() {
        return new PhanAnhMoiNguoiPresenterImpl(this);
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    public Context gContext() {
        return this;
    }

    @Override
    public void onGetListPhanAnh(ArrayList<PhanAnh> data) {
        if (data.size() > 0 && data.get(0).getMUCDOCONGKHAIID() == CA_NHAN){
            adapter.setIsCaNhan(true);
        }else {
            adapter.setIsCaNhan(false);
        }
        arrayList.clear();
        arrayList.addAll(data);
        adapter.notifyDataSetChanged();
        swipeLayout.setRefreshing(false);
    }

    @Override
    public void onTraLoiSuccess() {
        if (phanAnhID != 0){
            getPresenter().getPhanAnhById(phanAnhID);
        }else {
            if (chuDeID != 0){
                getPresenter().getPhanAnhMoiNguoi(chuDeID);
            }else {
                if (roleID == Key.USER){
                    getPresenter().getPhanAnh();
                }else if (roleID == Key.FACILITY){
                    getPresenter().getPhanAnhCSYT();
                }
            }
        }
    }
}
