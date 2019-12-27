package com.app.goldenhealth.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.app.goldenhealth.App;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.Dashboard;
import com.app.goldenhealth.model.User;
import com.app.goldenhealth.network.TokenAuthenticator;
import com.app.goldenhealth.presenter.HomePresenter;
import com.app.goldenhealth.presenter.impl.HomePresenterImpl;
import com.app.goldenhealth.ui.activity.HealthProfileActivity;
import com.app.goldenhealth.ui.activity.MainActivity;
import com.app.goldenhealth.ui.activity.NotificationActivity;
import com.app.goldenhealth.ui.adapter.MainPagerAdapter;
import com.app.goldenhealth.util.PrefUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import de.hdodenhof.circleimageview.CircleImageView;

import java.io.IOException;
import java.util.ArrayList;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeView {
    public static final int[] COLOR = {Color.rgb(47, 148, 173),
            Color.rgb(179, 44, 173),
            Color.rgb(226, 95, 39)};
    private static final int REQUEST_CODE_NOTIFICATION = 456;
    @BindView(R.id.img_avatar)
    CircleImageView imgAvatar;
    @BindView(R.id.txt_name)
    TextView txtName;
    @BindView(R.id.edt_search)
    EditText edtSearch;
    @BindView(R.id.txt_notifi_badge)
    TextView txtNotifiBadge;
    @BindView(R.id.btn_notify)
    RelativeLayout btnNotify;
    @BindView(R.id.btn_health_profile)
    TextView btnHealthRecords;
    @BindView(R.id.btn_personal_information)
    TextView btnPersonalInformation;
    @BindView(R.id.btn_medical_exam_schedule)
    TextView btnMedicalExamSchedule;
    @BindView(R.id.btn_hotline)
    TextView btnHotline;
    @BindView(R.id.txt_blood_group)
    TextView txtBloodGroup;
    @BindView(R.id.txt_height)
    TextView txtHeight;
    @BindView(R.id.txt_weight)
    TextView txtWeight;
    @BindView(R.id.view_patient)
    LinearLayout viewPatient;
    @BindView(R.id.txt_number_children)
    TextView txtNumberChildren;
    @BindView(R.id.txt_children)
    TextView txtChildren;
    @BindView(R.id.sb_children)
    View sbChildren;
    @BindView(R.id.txt_ratio_children)
    TextView txtRatioChildren;
    @BindView(R.id.txt_percent_children)
    TextView txtPercentChildren;
    @BindView(R.id.txt_number_woman)
    TextView txtNumberWoman;
    @BindView(R.id.txt_woman)
    TextView txtWoman;
    @BindView(R.id.sb_woman)
    View sbWoman;
    @BindView(R.id.txt_ratio_woman)
    TextView txtRatioWoman;
    @BindView(R.id.txt_percent_woman)
    TextView txtPercentWoman;
    @BindView(R.id.txt_number_elderly)
    TextView txtNumberElderly;
    @BindView(R.id.txt_elderly)
    TextView txtElderly;
    @BindView(R.id.sb_elderly)
    View sbElderly;
    @BindView(R.id.txt_ratio_elderly)
    TextView txtRatioElderly;
    @BindView(R.id.txt_percent_elderly)
    TextView txtPercentElderly;
    @BindView(R.id.txt_number_total)
    TextView txtNumberTotal;
    @BindView(R.id.txt_total)
    TextView txtTotal;
    @BindView(R.id.sb_total)
    View sbTotal;
    @BindView(R.id.txt_ratio_total)
    TextView txtRatioTotal;
    @BindView(R.id.txt_percent_total)
    TextView txtPercentTotal;
    @BindView(R.id.txt_char_name)
    TextView txtCharName;
    @BindView(R.id.pie_char)
    PieChart pieChar;
    @BindView(R.id.line_chart)
    LineChart lineChart;
    @BindView(R.id.view_doctor)
    LinearLayout viewDoctor;
    @BindView(R.id.btn_add)
    FloatingActionButton btnAdd;
    @BindView(R.id.btn_khao_sat)
    TextView btnKhaoSat;
    @BindView(R.id.sb_background)
    View sbBackground;
    @BindView(R.id.txt_type)
    TextView txtType;
    @BindView(R.id.txt_work_place)
    TextView txtWorkPlace;

    private int maxWidth;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);
        sbBackground.post(new Runnable() {
            @Override
            public void run() {
                maxWidth = sbBackground.getWidth();
            }
        });
        getPresenter().getNumberNotifiUnread();
        User user = PrefUtil.getDataUser(getContext());
        txtName.setText(user.getFullName());
        Glide.with(getContext()).load(user.getAvatar()).apply(new RequestOptions().placeholder(R.drawable.ic_avatar)).into(imgAvatar);
        txtBloodGroup.setText(user.getNhomMau() == null ? getString(R.string.chua_xac_dinh) : user.getNhomMau());
        txtWeight.setText(user.getCanNang() == null ? getString(R.string.chua_xac_dinh) : (user.getCanNang() + " kg"));
        txtHeight.setText(user.getChieuCao() == null ? getString(R.string.chua_xac_dinh) : (user.getChieuCao() + " cm"));
        if (user.getRoleId() == Key.DOCTOR || user.getRoleId() == Key.FACILITY) {
            viewDoctor.setVisibility(View.VISIBLE);
            btnAdd.setVisibility(View.VISIBLE);
            viewPatient.setVisibility(View.GONE);
            if (user.getRoleId() == Key.DOCTOR ){
                txtType.setVisibility(View.VISIBLE);
                txtType.setText(R.string.doctor);
            }
            txtWorkPlace.setVisibility(View.VISIBLE);
            txtWorkPlace.setText(user.getBenhVien());
            getPresenter().getDashboard();
        } else {
            viewDoctor.setVisibility(View.GONE);
            btnAdd.setVisibility(View.GONE);
            viewPatient.setVisibility(View.VISIBLE);
        }
        setupPieChart(pieChar, 65.0f, 70.0f, "Hello");

    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenterImpl(this);
    }

    @OnClick({R.id.btn_notify, R.id.btn_health_profile, R.id.btn_personal_information,
            R.id.btn_medical_exam_schedule, R.id.btn_hotline, R.id.edt_search, R.id.img_avatar, R.id.txt_name,
            R.id.btn_khao_sat, R.id.btn_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_notify:
                startActivityForResult(new Intent(getContext(), NotificationActivity.class), REQUEST_CODE_NOTIFICATION);
                break;
            case R.id.btn_health_profile:
                if (PrefUtil.getDataUser(getContext()).getMaytecanhan() == null ||
                        PrefUtil.getDataUser(getContext()).getMaytecanhan().isEmpty()) {
                    CapNhatMaYTCNFragment capNhatMaYTCNFragment = new CapNhatMaYTCNFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, capNhatMaYTCNFragment)
                            .addToBackStack(null).commit();
                } else {
                    startActivity(new Intent(getContext(), HealthProfileActivity.class));
                }
                break;
            case R.id.btn_personal_information:
            case R.id.img_avatar:
            case R.id.txt_name:
//                if (PrefUtil.getDataUser(getContext()).getMaytecanhan() == null ||
//                        PrefUtil.getDataUser(getContext()).getMaytecanhan().isEmpty()){
//                    CapNhatMaYTCNFragment capNhatMaYTCNFragment = new CapNhatMaYTCNFragment();
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, capNhatMaYTCNFragment)
//                            .addToBackStack(null).commit();
//                }else {
//                    PersonalInfoFragment personalInfoFragment = new PersonalInfoFragment();
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, personalInfoFragment)
//                            .addToBackStack(null).commit();
//                }

                PersonalInfoFragment personalInfoFragment = new PersonalInfoFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, personalInfoFragment)
                        .addToBackStack(null).commit();
                break;

            case R.id.btn_medical_exam_schedule:
                if (PrefUtil.getDataUser(getContext()).getMaytecanhan() == null ||
                        PrefUtil.getDataUser(getContext()).getMaytecanhan().isEmpty()) {
                    CapNhatMaYTCNFragment capNhatMaYTCNFragment = new CapNhatMaYTCNFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, capNhatMaYTCNFragment)
                            .addToBackStack(null).commit();
                } else {
                    LichSuKhamChuaBenhFragment lichSuKhamChuaBenhFragment = new LichSuKhamChuaBenhFragment();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, lichSuKhamChuaBenhFragment)
                            .addToBackStack(null).commit();
                }
                break;
            case R.id.btn_hotline:
                ((MainActivity) getActivity()).getmContent().setCurrentItem(MainPagerAdapter.QUESTION_INDEX);
                break;

            case R.id.edt_search:
                SearchFragment searchFragment = new SearchFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, searchFragment)
                        .addToBackStack(null).commit();
                break;

            case R.id.btn_khao_sat:
                KhaoSatFragment khaoSatFragment = new KhaoSatFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, khaoSatFragment)
                        .addToBackStack(null).commit();
                break;
            case R.id.btn_add:
                YBaFragment yBaFragment = new YBaFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putBoolean(Key.TITLE, true);
                yBaFragment.setArguments(bundle1);
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, yBaFragment)
                        .addToBackStack(null).commit();
                break;
            default:

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_NOTIFICATION) {
            getPresenter().getNumberNotifiUnread();
        }
    }

    private void setupPieChart(PieChart pieChart, float good, float bad, String name) {
        pieChart.setUsePercentValues(true);
        ArrayList<PieEntry> yvalues = new ArrayList<PieEntry>();


        PieEntry pieEntry1 = new PieEntry(100.0f, 0);
        pieEntry1.setLabel("Chưa lập hồ sơ");

        PieEntry pieEntry2 = new PieEntry(300.0f, 0);
        pieEntry2.setLabel("Đã khởi tạo hồ sơ");

        PieEntry pieEntry3 = new PieEntry(500.0f, 0);
        pieEntry3.setLabel("Đã lập hồ sơ");

        yvalues.add(pieEntry1);
        yvalues.add(pieEntry2);
        yvalues.add(pieEntry3);


        PieDataSet dataSet = new PieDataSet(yvalues, "");
        PieData data = new PieData(dataSet);

        // In Percentage term
        data.setValueFormatter(new PercentFormatter());
        // Default value
        //data.setValueFormatter(new DefaultValueFormatter(0));
        pieChart.setData(data);


        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(70f);
        pieChart.setHoleRadius(60f);
        pieChart.getLegend().setTextColor(Color.WHITE);


        dataSet.setColors(COLOR);
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.WHITE);


        pieChart.getLegend().setEnabled(true);

        pieChart.getLegend().setTextColor(Color.BLACK);
        pieChart.animateXY(1400, 1400);
        pieChart.getLegend().setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        pieChart.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        pieChart.setEntryLabelColor(Color.WHITE);
        pieChart.setEntryLabelTextSize(12f);

        pieChart.setDescription(null);
        pieChart.setDrawEntryLabels(false);
        pieChart.setEntryLabelTypeface(Typeface.DEFAULT);
        pieChart.setCenterText(name);
        pieChart.setCenterTextSize(20);
        pieChart.setCenterTextTypeface(Typeface.DEFAULT_BOLD);
        pieChart.invalidate();

    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetNumberNotifiUnread(Integer data) {
        if (data == 0) {
            txtNotifiBadge.setVisibility(View.GONE);
        } else {
            txtNotifiBadge.setVisibility(View.VISIBLE);
            txtNotifiBadge.setText(String.valueOf(data));
        }

    }

    @Override
    public void onGetDashboard(Dashboard data) {
        if (data.getTSNGUOI() > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) sbChildren.getLayoutParams();
            layoutParams.width = (int) ((data.getTSTREEM() * 1.0 / data.getTSNGUOI()) * maxWidth);
            sbChildren.setLayoutParams(layoutParams);
            txtNumberChildren.setText(data.getTSTREEM());
            txtRatioChildren.setText(data.getTSTREEM() + "/" + data.getTSNGUOI() + " " + getString(R.string.nguoi));
            txtPercentChildren.setText((data.getTSTREEM() * 1.0 / data.getTSNGUOI()) + "%");
            layoutParams = (RelativeLayout.LayoutParams) sbWoman.getLayoutParams();
            layoutParams.width = (int) ((data.getTSPHUNU() * 1.0 / data.getTSNGUOI()) * maxWidth);
            sbWoman.setLayoutParams(layoutParams);
            txtNumberWoman.setText(data.getTSPHUNU());
            txtRatioWoman.setText(data.getTSPHUNU() + "/" + data.getTSNGUOI() + " " + getString(R.string.nguoi));
            txtPercentWoman.setText((data.getTSPHUNU() * 1.0 / data.getTSNGUOI()) + "%");
            layoutParams = (RelativeLayout.LayoutParams) sbElderly.getLayoutParams();
            layoutParams.width = (int) ((data.getTSNGCAOTUOI() * 1.0 / data.getTSNGUOI()) * maxWidth);
            sbElderly.setLayoutParams(layoutParams);
            txtNumberElderly.setText(data.getTSNGCAOTUOI());
            txtRatioElderly.setText(data.getTSNGCAOTUOI() + "/" + data.getTSNGUOI() + " " + getString(R.string.nguoi));
            txtPercentElderly.setText((data.getTSNGCAOTUOI() * 1.0 / data.getTSNGUOI()) + "%");
            layoutParams = (RelativeLayout.LayoutParams) sbTotal.getLayoutParams();
            layoutParams.width = (int) ((data.getTSHO() * 1.0 / data.getTSNGUOI()) * maxWidth);
            sbTotal.setLayoutParams(layoutParams);
            txtNumberTotal.setText(data.getTSHO());
            txtRatioTotal.setText(data.getTSHO() + "/" + data.getTSNGUOI() + " " + getString(R.string.nguoi));
            txtPercentTotal.setText((data.getTSHO() * 1.0 / data.getTSNGUOI()) + "%");
        }

    }

//    private void setupLineChart(LineChart lineChart) {
//
//        // enable scaling and dragging
//        lineChart.setDragEnabled(true);
//        lineChart.setScaleEnabled(true);
//        lineChart.setDrawGridBackground(false);
//        lineChart.setHighlightPerDragEnabled(true);
//
//        // if disabled, scaling can be done on x- and y-axis separately
//        lineChart.setPinchZoom(true);
//
//        List<Entry> values = new ArrayList<>();
//        List<Entry> values1 = new ArrayList<>();
//        List<Entry> values2 = new ArrayList<>();
//
//        ArrayList<ChartRevenue> chartRevenues = (ArrayList<ChartRevenue>) charData.getChartRevenue();
//
//        for (ChartRevenue chartRevenue : chartRevenues) {
//            values.add(new Entry(chartRevenue.getMonth(), chartRevenue.getAmount()));
//            values1.add(new Entry(chartRevenue.getMonth(), chartRevenue.getSpend()));
//            values2.add(new Entry(chartRevenue.getMonth(), chartRevenue.getProfit()));
//        }
//
//        LineDataSet set1 = new LineDataSet(values, "Doanh thu");
//        set1.setFillAlpha(110);
//        set1.setColor(Color.RED);
//        set1.setLineWidth(3f);
//        set1.setDrawCircles(true);
//
//        LineDataSet set2 = new LineDataSet(values1, "Chi phí");
//        set2.setFillAlpha(110);
//        set2.setColor(Color.GREEN);
//        set2.setLineWidth(3f);
//        set2.setDrawCircles(true);
//
//        LineDataSet set3 = new LineDataSet(values2, "Lợi nhuận");
//        set3.setFillAlpha(110);
//        set3.setColor(Color.BLUE);
//        set3.setLineWidth(3f);
//        set3.setDrawCircles(true);
//
//        List<ILineDataSet> dataSets = new ArrayList<>();
//        dataSets.add(set1);
//        dataSets.add(set2);
//        dataSets.add(set3);
//
//        Description description = new Description();
//        description.setText("");
//
//        LineData data = new LineData(dataSets);
//        lineChart.setDescription(description);
//        lineChart.setData(data);
//        lineChart.invalidate();
//    }
}
