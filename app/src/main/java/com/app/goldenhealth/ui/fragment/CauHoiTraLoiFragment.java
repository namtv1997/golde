package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.KhaoSatCauHoi;
import com.app.goldenhealth.presenter.CauHoiTraLoiPresenter;
import com.app.goldenhealth.presenter.impl.CauHoiTraLoiPresenterImpl;
import com.app.goldenhealth.ui.activity.KhaoSattActivity;
import com.app.goldenhealth.util.Util;

import java.util.Objects;

public class CauHoiTraLoiFragment extends BaseFragment<CauHoiTraLoiPresenter> implements CauHoiTraLoiView {

    @BindView(R.id.txt_cau_hoi)
    TextView txtCauHoi;
    @BindView(R.id.edt_cau_tra_loi)
    EditText edtCauTraLoi;
    @BindView(R.id.btn_next)
    Button btnNext;

    private KhaoSatCauHoi cauHoi;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_cau_hoi_tra_loi;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        if (bundle != null) {
            cauHoi = (KhaoSatCauHoi) bundle.getSerializable(Key.CAU_HOI);
            txtCauHoi.setText(cauHoi.getCauHoi());
        }
    }

    @Override
    public CauHoiTraLoiPresenter createPresenter() {
        return new CauHoiTraLoiPresenterImpl(this);
    }

    @OnClick(R.id.btn_next)
    public void onViewClicked() {
        if (cauHoi != null){
            String traLoi = edtCauTraLoi.getText().toString();
            if (traLoi.isEmpty()){
                Util.showMessenger("Vui lòng nhập câu trả lời!", getContext());
                return;
            }
            getPresenter().traLoi(cauHoi.getId(), traLoi);
        }else {
            ((KhaoSattActivity) Objects.requireNonNull(getActivity())).next();
        }

    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onSuccess() {
        ((KhaoSattActivity) Objects.requireNonNull(getActivity())).next();
    }

    @Override
    public void onFail(String message) {
        Util.showMessenger(message, gContext());
    }
}