package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import android.widget.TextView;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.*;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.UpdateProfilePresenter;
import com.app.goldenhealth.ui.fragment.UpdateProfileView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class UpdateProfilePresenterImpl extends BasePresenterImpl<UpdateProfileView> implements UpdateProfilePresenter {

    private static final String TAG = "UpdateProfile" ;

    public UpdateProfilePresenterImpl(UpdateProfileView view) {
        super(view);
    }

    @Override
    public void getThongTinCaNhan(){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().getTTcaNhan(token, uid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ThongTinCaNhan>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<ThongTinCaNhan> thongTinCaNhanResponse) {
                        Util.getIns().hideLoadding();
                        if (thongTinCaNhanResponse.getStatus() == 1){
                            getView().onGetInfo(thongTinCaNhanResponse.getData());
                        }
                    }

                });
    }

    @Override
    public void getDanhMuc(DanhMucType danhMucType, TextView btnText, int viewID){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getListDanhMuc(danhMucType.getApiListPath(), token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<DanhMuc>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<DanhMuc>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListDanhMuc(arrayListResponse.getData(), danhMucType, btnText, viewID);
                        }
                    }
                });


    }

    @Override
    public void getDanhSachTinh(boolean ht, int id){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getTinhThanhPho(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<Tinh>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<Tinh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListTinh(arrayListResponse.getData(), ht, id);
                        }
                    }
                });
    }

    @Override
    public void getDanhSachHuyen(String maTinh, boolean ht){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getQuanHuyensByMaTinh(token, maTinh)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<Huyen>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<Huyen>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListHuyen(arrayListResponse.getData(), ht);
                        }
                    }
                });
    }

    @Override
    public void getDanhSachXa(String maHuyen, boolean ht){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getXaPhuongsByMaHuyen(token, maHuyen)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<Xa>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<Xa>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListXa(arrayListResponse.getData(), ht);
                        }
                    }
                });
    }

    @Override
    public void getDanhSachThon(String maXa, boolean ht){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getThonXomsByMaXa(token, maXa)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<Thon>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<Thon>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetListThon(arrayListResponse.getData(), ht);
                        }
                    }
                });
    }

    @Override
    public void updateProfile(String hoten, String ngaySinh, String hoTenBo, String hoTenMe, String maYTeBo,
                              String maYTeMe, String nguoiChamSoc, String soCMND, String ngayCap, String noiCap,
                              String ttChiTiet, String htChiTiet, String DTCD, String DTDD, String email, int mqhNguoCsId,
                              int hocVanId, int ngheNghiepId, int danTocId, int ttTinhID, int ttHuyenID,
                              int ttXaId, int ttThonID, int htTinhId, int htHuyenId, int htXaId, int htThonId, int quocTichId,
                              int gioiTinhId, int honNhanId, int tinhKSID, int tonGiaoId, String dtcdNCS, String dtddNCS,
                              String maTheBHYT){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().updateTTCaNhan(token, uid, hoten, "", 0, ngaySinh, hoTenBo, hoTenMe, maYTeBo,
                                                maYTeMe, nguoiChamSoc, soCMND, ngayCap, noiCap, ttChiTiet, htChiTiet, DTCD, DTDD,
                                                email, mqhNguoCsId, hocVanId, ngheNghiepId, 0, danTocId, ttTinhID,
                                                ttHuyenID, ttXaId, ttThonID, htTinhId, htHuyenId, htXaId, htThonId, quocTichId,
                                                gioiTinhId, honNhanId, tinhKSID, tonGiaoId, 0, dtcdNCS, dtddNCS, maTheBHYT, 0, "")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError:" + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + booleanResponse);
                        if (booleanResponse.getStatus() == 1){
                            getView().onUpdateSuccess();
                        }else {
                            getView().onFail(booleanResponse.getMessage());
                        }
                    }

                });
    }
}