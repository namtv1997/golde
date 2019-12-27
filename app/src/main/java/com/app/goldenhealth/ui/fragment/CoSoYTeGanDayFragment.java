package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.presenter.CoSoYTeGanDayPresenter;
import com.app.goldenhealth.presenter.impl.CoSoYTeGanDayPresenterImpl;
import com.app.goldenhealth.ui.adapter.CoSoYTeGanDayAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class CoSoYTeGanDayFragment extends BaseFragment<CoSoYTeGanDayPresenter> implements CoSoYTeGanDayView {
    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.rcv_gan_day)
    RecyclerView rcvGanDay;
    Unbinder unbinder;

    private CoSoYTeGanDayAdapter coSoYTeGanDayAdapter;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_co_so_y_te_gan_day;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null){
            String diaDiem = bundle.getString(Key.DIA_DIEM);
            getPresenter().getBenhVienGanDay(diaDiem);
        }
    }

    @Override
    public CoSoYTeGanDayPresenter createPresenter() {
        return new CoSoYTeGanDayPresenterImpl(this);
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetListBenhVienGanDay(ArrayList<BenhVien> data) {
        coSoYTeGanDayAdapter = new CoSoYTeGanDayAdapter(getContext(), data);
        coSoYTeGanDayAdapter.setOnItemClickListener(new CoSoYTeGanDayAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                CoSoYTeFragment coSoYTeFragment = new CoSoYTeFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(Key.ID, data.get(position).getID());
                coSoYTeFragment.setArguments(bundle);
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction().replace(android.R.id.content, coSoYTeFragment)
                        .addToBackStack(null).commit();
            }
        });
        rcvGanDay.setAdapter(coSoYTeGanDayAdapter);
        rcvGanDay.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
    }
}
