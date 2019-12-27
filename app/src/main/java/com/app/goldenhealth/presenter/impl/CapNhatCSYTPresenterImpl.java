package com.app.goldenhealth.presenter.impl;

import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.BenhVien;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.CapNhatCSYTPresenter;
import com.app.goldenhealth.ui.fragment.CapNhatCSYTView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.io.File;
import java.util.ArrayList;

public class CapNhatCSYTPresenterImpl extends BasePresenterImpl<CapNhatCSYTView> implements CapNhatCSYTPresenter {
    private static final String TAG = "UpdateBenhVien";

    public CapNhatCSYTPresenterImpl(CapNhatCSYTView view) {
        super(view);
    }

    @Override
    public void updateBenhVien(String ten, String diaChi,
                               String website, String hotline, String thoiGian, String email, String thanhTich,
                               ArrayList<Integer> dmKhoa){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        int id = PrefUtil.getDataUser(getView().gContext()).getBenhVienID();
        NetworkModule.getService().updateBenhVien(token, id, ten, diaChi, website,
                hotline, thoiGian, email, thanhTich, dmKhoa)
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
                            getView().onUpdateFail(booleanResponse.getMessage());
                        }
                    }

                });
    }

    @Override
    public void getBenhVienInfo(int id){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getBenhVienById(token, id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<BenhVien>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<BenhVien> benhVienResponse) {
                        Util.getIns().hideLoadding();
                        if (benhVienResponse.getStatus() == 1){
                            getView().onGetBenhVienInfo(benhVienResponse.getData());
                        }
                    }

                });
    }

    @Override
    public void updateAvatar(String image){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        RequestBody rbID = RequestBody.create(MediaType.parse("text/plain"), uid);
        MultipartBody.Part body;
        if (image.isEmpty()){
            body = null;
        }else {
            File file = new File(image);
            RequestBody fbody = RequestBody.create(MediaType.parse("image/*"), file);
            body = MultipartBody.Part.createFormData("fileName", file.getName(), fbody);
        }
        NetworkModule.getService().updateBenhVienAvatar(token, rbID, body)
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
                            getView().onUpdateAvatarSuccess();
                        }else {
                            getView().onUpdateFail(booleanResponse.getMessage());
                        }
                    }
                });
    }
}
