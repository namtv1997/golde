package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.GroupLichSuKhamChuaBenh;
import com.app.goldenhealth.model.LichSuKhamChuaBenh;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.model.TienSuDiUng;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.LichSuKhamChuaBenhPresenter;
import com.app.goldenhealth.ui.fragment.LichSuKhamChuaBenhView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LichSuKhamChuaBenhPresenterImpl extends BasePresenterImpl<LichSuKhamChuaBenhView> implements LichSuKhamChuaBenhPresenter {

    private static final String TAG = "LichSuKhamChua";

    public LichSuKhamChuaBenhPresenterImpl(LichSuKhamChuaBenhView view) {
        super(view);
    }

    @Override
    public void getLichSuKhamChua(){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().getLichSuKhamChuaBenhs(token, maYTe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<LichSuKhamChuaBenh>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: email: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<ArrayList<LichSuKhamChuaBenh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            ArrayList<LichSuKhamChuaBenh> arrayList = arrayListResponse.getData();
                            for (LichSuKhamChuaBenh lichSuKhamChuaBenh : arrayList){
                                lichSuKhamChuaBenh.setYEAR();
                            }

                            HashMap<String, ArrayList<LichSuKhamChuaBenh>> hashMap = new HashMap<String, ArrayList<LichSuKhamChuaBenh>>();
                            for (LichSuKhamChuaBenh lichSuKhamChuaBenh : arrayList){
                                if (!hashMap.containsKey(lichSuKhamChuaBenh.getYEAR())) {
                                    ArrayList<LichSuKhamChuaBenh> list = new ArrayList<LichSuKhamChuaBenh>();
                                    list.add(lichSuKhamChuaBenh);
                                    hashMap.put(lichSuKhamChuaBenh.getYEAR(), list);
                                } else {
                                    hashMap.get(lichSuKhamChuaBenh.getYEAR()).add(lichSuKhamChuaBenh);
                                }
                            }

                            ArrayList<GroupLichSuKhamChuaBenh> groupLichSuKhamChuaBenhs = new ArrayList<>();

                            for(Map.Entry<String, ArrayList<LichSuKhamChuaBenh>> entry : hashMap.entrySet()) {
                                String year = entry.getKey();
                                ArrayList<LichSuKhamChuaBenh> list = entry.getValue();
                                GroupLichSuKhamChuaBenh groupLichSuKhamChuaBenh = new GroupLichSuKhamChuaBenh(year, list);
                                groupLichSuKhamChuaBenhs.add(groupLichSuKhamChuaBenh);

                            }
                            getView().onGetLichSuKhamChua(groupLichSuKhamChuaBenhs);
                        }
                    }

                });
    }
}