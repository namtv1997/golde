package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.LienKetMangXaHoi;
import com.app.goldenhealth.presenter.DuongDayNongPresenter;
import com.app.goldenhealth.presenter.impl.DuongDayNongPresenterImpl;

public class DuongDayNongFragment extends BaseFragment<DuongDayNongPresenter> implements DuongDayNongView {


    @BindView(R.id.btn_back)
    ImageView btnBack;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.view_title)
    RelativeLayout viewTitle;
    @BindView(R.id.btn_phone)
    LinearLayout btnPhone;
    @BindView(R.id.btn_facebook)
    ImageView btnFacebook;
    @BindView(R.id.btn_zalo)
    ImageView btnZalo;
    @BindView(R.id.btn_viber)
    ImageView btnViber;
    @BindView(R.id.btn_email)
    ImageView btnEmail;
    Unbinder unbinder;

    private LienKetMangXaHoi lienKetMangXaHoi;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_duong_day_nong;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.getBoolean(Key.IS_HOTLINE)) {
                viewTitle.setVisibility(View.VISIBLE);
            }else {
                viewTitle.setVisibility(View.GONE);
            }
        }else {
            viewTitle.setVisibility(View.GONE);
        }

    }

    @Override
    public DuongDayNongPresenter createPresenter() {
        return new DuongDayNongPresenterImpl(this);
    }

    @OnClick({R.id.btn_back, R.id.btn_phone, R.id.btn_facebook, R.id.btn_zalo, R.id.btn_viber, R.id.btn_email})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            case R.id.btn_phone:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + Key.HOTLINE));
                startActivity(intent);
                break;
            case R.id.btn_facebook:
                if (lienKetMangXaHoi != null){
                    openWebPage(lienKetMangXaHoi.getFacebook());
                }
                break;
            case R.id.btn_zalo:
                if (lienKetMangXaHoi != null){
                    openWebPage(lienKetMangXaHoi.getZalo());
                }
                break;
            case R.id.btn_viber:
                if (lienKetMangXaHoi != null){
                    openWebPage(lienKetMangXaHoi.getViber());
                }
                break;
            case R.id.btn_email:
                Intent intent1 = new Intent(Intent.ACTION_SENDTO);
                intent1.setType("*/*");
                intent1.setData(Uri.parse("mailto:"));
                String[] address = new String[]{Key.EMAIL};
                intent1.putExtra(Intent.EXTRA_EMAIL, address);
                if (intent1.resolveActivity(gContext().getPackageManager()) != null) {
                    startActivity(intent1);
                }
                break;
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetLienKetMXH(LienKetMangXaHoi data) {
        this.lienKetMangXaHoi = data;
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(gContext().getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}