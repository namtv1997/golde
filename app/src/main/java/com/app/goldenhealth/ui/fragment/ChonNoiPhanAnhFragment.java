package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.DiaDiemPhanAnh;
import com.app.goldenhealth.presenter.ChonNoiPhanAnhPresenter;
import com.app.goldenhealth.presenter.impl.ChonNoiPhanAnhPresenterImpl;
import com.app.goldenhealth.ui.adapter.NoiPhanAnhAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class ChonNoiPhanAnhFragment extends BaseFragment<ChonNoiPhanAnhPresenter> implements ChonNoiPhanAnhView {
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.edt_search)
    EditText edtSearch;
    @BindView(R.id.rcv)
    RecyclerView rcv;
    private NoiPhanAnhAdapter adapter;
    private ArrayList<DiaDiemPhanAnh> arrayList;
    private OnItemClickListener onItemClickListener;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_chon_noi_phan_anh;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);

    }

    @Override
    public ChonNoiPhanAnhPresenter createPresenter() {
        return new ChonNoiPhanAnhPresenterImpl(this);
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetDiaDiemPhanAnh(ArrayList<DiaDiemPhanAnh> data) {
        arrayList = data;
        adapter = new NoiPhanAnhAdapter(getContext(), arrayList);
        adapter.setOnItemClickListener(new NoiPhanAnhAdapter.OnItemClickListener() {
            @Override
            public void onClick(DiaDiemPhanAnh diaDiemPhanAnh) {
                onItemClickListener.onClick(diaDiemPhanAnh);
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
            }
        });
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.filter(s.toString());
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(DiaDiemPhanAnh diaDiemPhanAnh);
    }
}