package com.app.goldenhealth.presenter.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.PhanAnh;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.PhanAnhChiTietPresenter;
import com.app.goldenhealth.ui.activity.PhanAnhChiTietView;
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
import java.text.ParseException;
import java.util.ArrayList;

public class PhanAnhChiTietPresenterImpl extends BasePresenterImpl<PhanAnhChiTietView> implements PhanAnhChiTietPresenter {

    private static final String TAG = "PhanAnhChiTiet" ;

    public PhanAnhChiTietPresenterImpl(PhanAnhChiTietView view) {
        super(view);
    }

    @Override
    public void getPhanAnhById(int id){
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().getPhanAnhById(token, uid, id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<PhanAnh>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<PhanAnh> phanAnhResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + phanAnhResponse);
                        try {
                            getView().onGetPhanAnh(phanAnhResponse.getData());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void addComment(int id, String noiDung, String hoten, String sdt, String email, String diaChi, ArrayList<String> images){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().addComment(token,uid, id, noiDung, hoten, sdt, email, diaChi)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Integer>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<Integer> integerResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + integerResponse);
                        if (integerResponse.getStatus() == 1){
                            if (images.size() > 0){
                                uploadImageComment(integerResponse.getData(), images);
                            }else {
                                getView().onCommentSuccess();
                            }

                        }
                    }

                });
    }

    @Override
    public void uploadImageComment(int id, ArrayList<String> images){
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

        NetworkModule.getService().uploadImageComment(token, rbID, listFile)
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
                            getView().onCommentSuccess();
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

    @Override
    public void addDanhGia(int id, float danhGia, String hoten, String sdt, String email, String diaChi){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        NetworkModule.getService().addDanhGia(token,uid, id, danhGia, hoten, sdt, email, diaChi)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + booleanResponse);
                        if (booleanResponse.getData()){
                            getView().onDanhGiaSuccess();
                        }
                        else {
                            getView().onDanhGiaFail(booleanResponse.getMessage());
                        }
                    }
                });
    }

    @Override
    public void traLoiPhanAnh(int id, String noiDung){
        Util.getIns().showLoadding(getView().gContext());
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        NetworkModule.getService().traLoiPhanAnh(token, id, noiDung)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();
                        Log.d(TAG, "onNext: " + booleanResponse);
                        if (booleanResponse.getData()){
                            getView().onTraLoiSuccess();
                        }
                    }

                });
    }
}