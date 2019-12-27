package com.app.goldenhealth.presenter;

import com.app.goldenhealth.base.BasePresenter;

import java.util.ArrayList;

public interface KhamLapHoSoPresenter extends BasePresenter {
    void getHoSoKhamLap();

    void upDate( String NGAY_KHAM, String BENH_SU,
                Double MACH, Double NHIET_DO, Integer HUYET_AP_TD, Integer HUYET_AP_TT, Integer NHIP_THO,
                Double CAN_NANG, Double CHIEU_CAO, Double VONG_BUNG, Double BMI,
                Integer MAT_PHAI_KK, Integer MAT_TRAI_KK, Integer MAT_PHAI_CK, Integer MAT_TRAI_CK,
                String KHAM_DA, String KHAM_NIEM_MAC, String KHAM_TT_KHAC,
                String KHAM_TIM_MACH, String KHAM_HO_HAP, String KHAM_TIET_NIEU,
                String KHAM_TIEU_HOA, String KHAM_CXK, String KHAM_NOI_TIET, String KHAM_THAN_KINH,
                String KHAM_TAM_THAN, String KHAM_NGOAI_KHOA, String KHAM_SAN_PHU_KHOA,
                String KHAM_TAI_MUI_HONG, String KHAM_RANG_HAM_MAT, String KHAM_MAT,
                String KHAM_DA_LIEU, String KHAM_DINH_DUONG, String KHAM_VAN_DONG,
                String KHAM_CQ_KHAC, String KHAM_DANH_GIA, Integer NGUY_CO_SUY_DINH_DUONG,
                Integer NGUY_CO_BEO_PHI, Integer TU_VE_SINH_CA_NHAN,
                Integer TU_DI_LAI, Integer TU_MAC_QUAN_AO, Integer DAI_TIEU_TIEN_TC, Integer TU_AN_UONG,
                Integer TU_SU_DUNG_DT, Integer TU_MUA_BAN, Integer TU_NAU_AN,
                Integer TU_DON_DEP, Integer TU_GIAT_GIU, Integer TU_UONG_HAY_CHICH_THUOC,
                Integer GIAM_TRI_NHO, Integer GIA_DINH_CO_NG_MAC, String SO_LOAI_THUOC_SU_DUNG,
                String XN_NHOM_MAU_ABO, String XN_NHOM_MAU_RH, String XN_CONG_THUC_MAU,
                String XN_SINH_HOA_MAU, String XN_SH_NUOC_TIEU, String XN_SIEU_AM,
                ArrayList<Integer> LOAI_IDCs,Integer ID_BENH_VIEN,
                String BAC_SI_KHAM,ArrayList<Integer> BENH_THEO_DOIs,String NGAY_HEN_KHAM);
}
