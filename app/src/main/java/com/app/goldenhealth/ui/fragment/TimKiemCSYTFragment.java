package com.app.goldenhealth.ui.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.app.goldenhealth.Key;
import com.app.goldenhealth.R;
import com.app.goldenhealth.base.BaseFragment;
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.presenter.TimKiemCSYTPresenter;
import com.app.goldenhealth.presenter.impl.TimKiemCSYTPresenterImpl;
import com.app.goldenhealth.ui.adapter.CoSoYTeAdapter;
import com.app.goldenhealth.ui.adapter.CoSoYTeGanDayAdapter;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TimKiemCSYTFragment extends BaseFragment<TimKiemCSYTPresenter> implements TimKiemCSYTView, OnMapReadyCallback {
    private static final int REQUEST_LOCATION = 555;

    @BindView(R.id.view)
    View viewThayThe;
    @BindView(R.id.rcv_de_xuat)
    RecyclerView rcvDeXuat;
    @BindView(R.id.rcv_gan_day)
    RecyclerView rcvGanDay;
    @BindView(R.id.bottom_sheet)
    NestedScrollView bottomSheet;
    @BindView(R.id.edt_search)
    EditText edtSearch;


    private GoogleMap mMap;
    private View mapView;
    private FusedLocationProviderClient mFusedLocationClient;
    private CoSoYTeAdapter coSoYTeAdapter;
    private CoSoYTeGanDayAdapter coSoYTeGanDayAdapter;
    private String diadiem = "";
    private LatLng myLocation;

    BottomSheetBehavior sheetBehavior;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_tim_kiem_csyt;
    }

    @Override
    public void initializeComponents(View view) {
        ButterKnife.bind(this, view);

        ButterKnife.bind(this, view);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapView = mapFragment.getView();
        mapFragment.getMapAsync(this);

        sheetBehavior = BottomSheetBehavior.from(bottomSheet);
        sheetBehavior.setHideable(true);
        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:

                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        viewThayThe.setVisibility(View.VISIBLE);
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        viewThayThe.setVisibility(View.GONE);
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:

                        break;
                    case BottomSheetBehavior.STATE_SETTLING:

                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @Override
    public TimKiemCSYTPresenter createPresenter() {
        return new TimKiemCSYTPresenterImpl(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Get the button view
        View locationButton = ((View) mapView.findViewById(Integer.parseInt("1")).getParent()).findViewById(Integer.parseInt("2"));
        // and next place it, on bottom right (as Google Maps app)
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)
                locationButton.getLayoutParams();
        // position on right bottom
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        layoutParams.setMargins(0, 0, 30, 150);

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_LOCATION);
        } else {
            mMap.setMyLocationEnabled(true);
            mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                // Logic to handle location object
                                myLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 15));
                                diadiem = getAddress(location.getLatitude(), location.getLongitude());
                                Log.d("DanhBa", "onSuccess: " + diadiem);
                                getPresenter().getBenhVienDeXuat(diadiem);
                                getPresenter().getBenhVienGanDay(diadiem);
                            }
                        }
                    });
        }

        mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                LatLng latLng = mMap.getCameraPosition().target;
                getPresenter().getBenhVienDeXuat(getAddress(latLng.latitude, latLng.longitude));
                getPresenter().getBenhVienGanDay(getAddress(latLng.latitude, latLng.longitude));
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_LOCATION) {
            if (grantResults.length == 2
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                mMap.setMyLocationEnabled(true);
                mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
                mFusedLocationClient.getLastLocation()
                        .addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {
                                // Got last known location. In some rare situations this can be null.
                                if (location != null) {
                                    // Logic to handle location object
                                    myLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 15));
                                    diadiem = getAddress(location.getLatitude(), location.getLongitude());
                                    Log.d("DanhBa", "onSuccess: " + diadiem);
                                    getPresenter().getBenhVienDeXuat(diadiem);
                                    getPresenter().getBenhVienGanDay(diadiem);
                                }
                            }
                        });

            } else {
                // Permission was denied or request was cancelled
            }
        }
    }

    @Override
    public Context gContext() {
        return getContext();
    }

    @Override
    public void onGetListBenhVienDeXuat(ArrayList<BenhVien> data) {
        coSoYTeAdapter = new CoSoYTeAdapter(getContext(), data);
        coSoYTeAdapter.setOnItemClickListener(new CoSoYTeAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                CoSoYTeFragment coSoYTeFragment = new CoSoYTeFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(Key.ID, data.get(position).getID());
                coSoYTeFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, coSoYTeFragment)
                        .addToBackStack(null).commit();
            }
        });
        rcvDeXuat.setAdapter(coSoYTeAdapter);
    }

    @Override
    public void onGetListBenhVienGanDay(ArrayList<BenhVien> data) {
        ArrayList<BenhVien> benhViens = new ArrayList<>();
        if (data.size() > 5){
            benhViens.addAll(data.subList(0, 5));
        }else {
            benhViens.addAll(data);
        }
        coSoYTeGanDayAdapter = new CoSoYTeGanDayAdapter(getContext(), benhViens);
        coSoYTeGanDayAdapter.setOnItemClickListener(new CoSoYTeGanDayAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                CoSoYTeFragment coSoYTeFragment = new CoSoYTeFragment();
                Bundle bundle = new Bundle();
                bundle.putInt(Key.ID, benhViens.get(position).getID());
                coSoYTeFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, coSoYTeFragment)
                        .addToBackStack(null).commit();
            }
        });
        rcvGanDay.setAdapter(coSoYTeGanDayAdapter);
        rcvGanDay.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private String getAddress(double lat, double lng) {
        Geocoder geocoder;
        List<Address> addresses = new ArrayList<>();
        geocoder = new Geocoder(getContext(), Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(lat, lng, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (addresses.size() > 0) {
            String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            String city = addresses.get(0).getLocality();
            String state = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalCode = addresses.get(0).getPostalCode();
            String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL
            String locality = addresses.get(0).getLocality();
            return locality;
        } else {
            return "";
        }
    }

    public void showHideBottom() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_COLLAPSED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    @OnClick(R.id.edt_search)
    public void onViewClicked() {
        SearchFragment searchFragment = new SearchFragment();
        getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, searchFragment)
                .addToBackStack(null).commit();
    }

    @OnClick(R.id.btn_mơre)
    public void onMore() {
        CoSoYTeGanDayFragment coSoYTeGanDayFragment = new CoSoYTeGanDayFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Key.DIA_DIEM, diadiem);
        coSoYTeGanDayFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction().replace(android.R.id.content, coSoYTeGanDayFragment)
                .addToBackStack(null).commit();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            if (mMap != null && myLocation == null){
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                mMap.setMyLocationEnabled(true);
                mFusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
                mFusedLocationClient.getLastLocation()
                        .addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {
                                // Got last known location. In some rare situations this can be null.
                                if (location != null) {
                                    // Logic to handle location object
                                    myLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation, 15));
                                    diadiem = getAddress(location.getLatitude(), location.getLongitude());
                                    Log.d("DanhBa", "onSuccess: " + diadiem);
                                    getPresenter().getBenhVienDeXuat(diadiem);
                                    getPresenter().getBenhVienGanDay(diadiem);
                                }
                            }
                        });

            } else {
                // Permission was denied or request was cancelled
            }
        }
    }

}