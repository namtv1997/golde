package com.app.goldenhealth.presenter.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.*;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.TaoPhanAnhPresenter;
import com.app.goldenhealth.ui.fragment.TaoPhanAnhView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class TaoPhanAnhPresenterImpl extends BasePresenterImpl<TaoPhanAnhView> implements TaoPhanAnhPresenter {

    private static final String TAG = "HoiDap";

    public TaoPhanAnhPresenterImpl(TaoPhanAnhView view) {
        super(view);
    }

    @Override
    public void getDanhMuc(DanhMucType danhMucType){
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
                            getView().onGetListMucDoCongKhai(arrayListResponse.getData());
                        }
                    }
                });
    }

    @Override
    public void createPhanAnh(String tieuDe, int chuDe, int noiPA, String noiDung, int mucDoCongKhai, String hoTen, String SDT,
                              String email, String diaChi){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().createPhanAnh(token, uid, tieuDe, chuDe, noiPA, noiDung, mucDoCongKhai, hoTen, SDT, email, diaChi)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Integer>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError:" + e.getMessage());
                    }

                    @Override
                    public void onNext(Response<Integer> response) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + response);
                        if (response.getStatus() == 1){
                            getView().onCreateSuccess(response.getData());
                        }else {
                            getView().onCreateFail(response.getMessage());
                        }
                    }

                });
    }

    @Override
    public void getCauHoiThuongGap(){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getCauHoiThuongGap(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<CauHoiThuongGap>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<CauHoiThuongGap>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetCauHoiThuongGap(arrayListResponse.getData());
                        }
                    }

                });
    }

    @Override
    public void getChuDePhanAnh(){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().getChuDePhanAnh(token)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<ArrayList<ChuDePhanAnh>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<ArrayList<ChuDePhanAnh>> arrayListResponse) {
                        Util.getIns().hideLoadding();
                        if (arrayListResponse.getStatus() == 1){
                            getView().onGetChuDePhanAnh(arrayListResponse.getData());
                        }
                    }
                });
    }

    @Override
    public void updateAnh(int id, ArrayList<String> images){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        RequestBody rbID = RequestBody.create(MediaType.parse("text/plain"), String.valueOf(id));

        ArrayList<MultipartBody.Part> listFile = new ArrayList<>();
        if (images.size() == 1){
            MultipartBody.Part body;
            File file = saveBitmapToFile(new File(images.get(0)));
            RequestBody fbody = RequestBody.create(MediaType.parse("image/*"), file);
            body = MultipartBody.Part.createFormData("fileName", file.getName(), fbody);
            listFile.add(body);

        }else {
            MultipartBody.Part body;
            File file;
            RequestBody fbody;
            for (int i = 0; i<images.size(); i++){
                file = saveBitmapToFile(new File(images.get(i)));
                fbody = RequestBody.create(MediaType.parse("image/*"), file);
                body = MultipartBody.Part.createFormData("fileName" + (i+1), file.getName(), fbody);
                listFile.add(body);
            }
        }

        NetworkModule.getService().updateAnhPhanAnh(token, rbID, listFile)
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
                        getView().onUploadImageFail("Có lỗi xảy ra");
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + booleanResponse);
                        if (booleanResponse.getStatus() == 1){
                            getView().onUploadImageSuccess();
                        }else {
                            getView().onUploadImageFail(booleanResponse.getMessage());
                        }
                    }
                });
    }

    public File saveBitmapToFile(File file){
        try {

            // BitmapFactory options to downsize the image
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            o.inSampleSize = 6;
            // factor of downsizing the image

            FileInputStream inputStream = new FileInputStream(file);
            //Bitmap selectedBitmap = null;
            BitmapFactory.decodeStream(inputStream, null, o);
            inputStream.close();

            // The new size we want to scale to
            final int REQUIRED_SIZE=75;

            // Find the correct scale value. It should be the power of 2.
            int scale = 1;
            while(o.outWidth / scale / 2 >= REQUIRED_SIZE &&
                    o.outHeight / scale / 2 >= REQUIRED_SIZE) {
                scale *= 2;
            }

            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            inputStream = new FileInputStream(file);

            Bitmap selectedBitmap = BitmapFactory.decodeStream(inputStream, null, o2);
            inputStream.close();

            // here i override the original image file
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);

            selectedBitmap.compress(Bitmap.CompressFormat.JPEG, 100 , outputStream);

            return file;
        } catch (Exception e) {
            return null;
        }
    }
}