package com.app.goldenhealth.presenter.impl;


import android.util.Log;
import com.app.goldenhealth.base.BasePresenterImpl;
import com.app.goldenhealth.model.HoSoKhamLap;
import com.app.goldenhealth.model.Response;
import com.app.goldenhealth.network.NetworkModule;
import com.app.goldenhealth.presenter.KhamLapHoSoPresenter;
import com.app.goldenhealth.ui.activity.KhamlapHoSoView;
import com.app.goldenhealth.util.PrefUtil;
import com.app.goldenhealth.util.Util;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import java.util.ArrayList;

public class KhamLapHoSoPresenterImpl extends BasePresenterImpl<KhamlapHoSoView> implements KhamLapHoSoPresenter {

    public KhamLapHoSoPresenterImpl(KhamlapHoSoView view) {
        super(view);
    }

    @Override
    public void getHoSoKhamLap() {
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().getHoSoKhamLap(token,maYTe)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<Response<HoSoKhamLap>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<HoSoKhamLap> hoSoKhamLapResponse) {

                        Util.getIns().hideLoadding();
                        if (hoSoKhamLapResponse.getStatus() == 1){
                            getView().onGetInfo(hoSoKhamLapResponse.getData());
                        }
                    }
                });

    }

    @Override
    public void upDate( String NGAY_KHAM, String BENH_SU, Double MACH,
                       Double NHIET_DO, Integer HUYET_AP_TD, Integer HUYET_AP_TT, Integer NHIP_THO, Double CAN_NANG,
                       Double CHIEU_CAO, Double VONG_BUNG, Double BMI, Integer MAT_PHAI_KK, Integer MAT_TRAI_KK,
                       Integer MAT_PHAI_CK, Integer MAT_TRAI_CK, String KHAM_DA, String KHAM_NIEM_MAC,
                       String KHAM_TT_KHAC, String KHAM_TIM_MACH, String KHAM_HO_HAP, String KHAM_TIET_NIEU,
                       String KHAM_TIEU_HOA, String KHAM_CXK, String KHAM_NOI_TIET, String KHAM_THAN_KINH,
                       String KHAM_TAM_THAN, String KHAM_NGOAI_KHOA, String KHAM_SAN_PHU_KHOA, String KHAM_TAI_MUI_HONG,
                       String KHAM_RANG_HAM_MAT, String KHAM_MAT, String KHAM_DA_LIEU, String KHAM_DINH_DUONG,
                       String KHAM_VAN_DONG, String KHAM_CQ_KHAC, String KHAM_DANH_GIA, Integer NGUY_CO_SUY_DINH_DUONG,
                       Integer NGUY_CO_BEO_PHI, Integer TU_VE_SINH_CA_NHAN, Integer TU_DI_LAI, Integer TU_MAC_QUAN_AO,
                       Integer DAI_TIEU_TIEN_TC, Integer TU_AN_UONG, Integer TU_SU_DUNG_DT, Integer TU_MUA_BAN,
                       Integer TU_NAU_AN, Integer TU_DON_DEP, Integer TU_GIAT_GIU, Integer TU_UONG_HAY_CHICH_THUOC,
                       Integer GIAM_TRI_NHO, Integer GIA_DINH_CO_NG_MAC, String SO_LOAI_THUOC_SU_DUNG,
                       String XN_NHOM_MAU_ABO, String XN_NHOM_MAU_RH, String XN_CONG_THUC_MAU, String XN_SINH_HOA_MAU,
                       String XN_SH_NUOC_TIEU, String XN_SIEU_AM, ArrayList<Integer> LOAI_IDCs, Integer ID_BENH_VIEN,
                       String BAC_SI_KHAM, ArrayList<Integer> BENH_THEO_DOIs, String NGAY_HEN_KHAM)
    {
        String token = "Bearer " + PrefUtil.getToken(getView().gContext()).getAccessToken();
        String uid = PrefUtil.getDataUser(getView().gContext()).getUID();
        String maYTe = PrefUtil.getDataUser(getView().gContext()).getMaytecanhan();
        NetworkModule.getService().updatePhieuKhamLap(token,maYTe, uid,NGAY_KHAM,BENH_SU,
                MACH,NHIET_DO,HUYET_AP_TD,HUYET_AP_TT,NHIP_THO,CAN_NANG,CHIEU_CAO,VONG_BUNG,BMI,MAT_PHAI_KK,MAT_TRAI_KK,
                MAT_PHAI_CK,MAT_TRAI_CK,KHAM_DA,KHAM_NIEM_MAC,KHAM_TT_KHAC,KHAM_TIM_MACH,KHAM_HO_HAP,KHAM_TIET_NIEU,
                KHAM_TIEU_HOA,KHAM_CXK,KHAM_NOI_TIET,KHAM_THAN_KINH,KHAM_TAM_THAN,KHAM_NGOAI_KHOA,KHAM_SAN_PHU_KHOA,
                KHAM_TAI_MUI_HONG,KHAM_RANG_HAM_MAT,KHAM_MAT,KHAM_DA_LIEU,KHAM_DINH_DUONG,KHAM_VAN_DONG,KHAM_CQ_KHAC,
                KHAM_DANH_GIA,NGUY_CO_SUY_DINH_DUONG,NGUY_CO_BEO_PHI,TU_VE_SINH_CA_NHAN,TU_DI_LAI,TU_MAC_QUAN_AO,
                DAI_TIEU_TIEN_TC,TU_AN_UONG,TU_SU_DUNG_DT,TU_MUA_BAN,TU_NAU_AN,TU_DON_DEP,TU_GIAT_GIU,
                TU_UONG_HAY_CHICH_THUOC,GIAM_TRI_NHO,GIA_DINH_CO_NG_MAC,SO_LOAI_THUOC_SU_DUNG,XN_NHOM_MAU_ABO,
                XN_NHOM_MAU_RH,XN_CONG_THUC_MAU,XN_SINH_HOA_MAU,XN_SH_NUOC_TIEU,XN_SIEU_AM,LOAI_IDCs,ID_BENH_VIEN,
                BAC_SI_KHAM,BENH_THEO_DOIs,NGAY_HEN_KHAM)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Response<Boolean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Response<Boolean> booleanResponse) {
                        Util.getIns().hideLoadding();

                        if (booleanResponse.getStatus() == 1){
                            if (booleanResponse.getData()){
                                getView().onUpdateSuccess();
                            }else {
                                getView().onFail(booleanResponse.getMessage());
                            }
                        }else {
                            getView().onFail(booleanResponse.getMessage());
                        }
                    }
                });
    }





}
