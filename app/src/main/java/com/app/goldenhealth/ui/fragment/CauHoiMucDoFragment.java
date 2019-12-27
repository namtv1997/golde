package com.app.goldenhealth.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.KhaoSatCauHoi;
import com.app.goldenhealth.presenter.CauHoiMucDoPresenter;
import com.app.goldenhealth.presenter.impl.CauHoiMucDoPresenterImpl;

public class CauHoiMucDoFragment extends BaseFragment<CauHoiMucDoPresenter> implements CauHoiMucDoView {

    @BindView(R.id.txt_cau_hoi)
    TextView txtCauHoi;

    private KhaoSatCauHoi cauHoi;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_cau_hoi_muc_do;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            cauHoi = (KhaoSatCauHoi) bundle.getSerializable(Key.CAU_HOI);
            assert cauHoi != null;
            txtCauHoi.setText(cauHoi.getCauHoi());
        }
    }

    @Override
    public CauHoiMucDoPresenter createPresenter() {
        return new CauHoiMucDoPresenterImpl(this);
    }

}