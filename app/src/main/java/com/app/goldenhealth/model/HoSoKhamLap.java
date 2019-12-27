package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HoSoKhamLap {
    @SerializedName("MA_Y_TE_CA_NHAN")
    @Expose
    private String mAYTECANHAN;
    @SerializedName("NGAY_KHAM")
    @Expose
    private String nGAYKHAM;
    @SerializedName("BENH_SU")
    @Expose
    private String bENHSU;
    @SerializedName("MACH")
    @Expose
    private Double mACH;
    @SerializedName("NHIET_DO")
    @Expose
    private Double nHIETDO;
    @SerializedName("HUYET_AP_TD")
    @Expose
    private Integer hUYETAPTD;
    @SerializedName("HUYET_AP_TT")
    @Expose
    private Integer hUYETAPTT;
    @SerializedName("NHIP_THO")
    @Expose
    private Integer nHIPTHO;
    @SerializedName("CAN_NANG")
    @Expose
    private Double cANNANG;
    @SerializedName("CHIEU_CAO")
    @Expose
    private Double cHIEUCAO;
    @SerializedName("VONG_BUNG")
    @Expose
    private Double vONGBUNG;
    @SerializedName("BMI")
    @Expose
    private Double bMI;
    @SerializedName("MAT_PHAI_KK")
    @Expose
    private Integer mATPHAIKK;
    @SerializedName("MAT_TRAI_KK")
    @Expose
    private Integer mATTRAIKK;
    @SerializedName("MAT_PHAI_CK")
    @Expose
    private Integer mATPHAICK;
    @SerializedName("MAT_TRAI_CK")
    @Expose
    private Integer mATTRAICK;
    @SerializedName("KHAM_DA")
    @Expose
    private String kHAMDA;
    @SerializedName("KHAM_NIEM_MAC")
    @Expose
    private String kHAMNIEMMAC;
    @SerializedName("KHAM_TT_KHAC")
    @Expose
    private String kHAMTTKHAC;
    @SerializedName("KHAM_TIM_MACH")
    @Expose
    private String kHAMTIMMACH;
    @SerializedName("KHAM_HO_HAP")
    @Expose
    private String kHAMHOHAP;
    @SerializedName("KHAM_TIET_NIEU")
    @Expose
    private String kHAMTIETNIEU;
    @SerializedName("KHAM_TIEU_HOA")
    @Expose
    private String kHAMTIEUHOA;
    @SerializedName("KHAM_CXK")
    @Expose
    private String kHAMCXK;
    @SerializedName("KHAM_NOI_TIET")
    @Expose
    private String kHAMNOITIET;
    @SerializedName("KHAM_THAN_KINH")
    @Expose
    private String kHAMTHANKINH;
    @SerializedName("KHAM_TAM_THAN")
    @Expose
    private String kHAMTAMTHAN;
    @SerializedName("KHAM_NGOAI_KHOA")
    @Expose
    private String kHAMNGOAIKHOA;
    @SerializedName("KHAM_SAN_PHU_KHOA")
    @Expose
    private String kHAMSANPHUKHOA;
    @SerializedName("KHAM_TAI_MUI_HONG")
    @Expose
    private String kHAMTAIMUIHONG;
    @SerializedName("KHAM_RANG_HAM_MAT")
    @Expose
    private String kHAMRANGHAMMAT;
    @SerializedName("KHAM_MAT")
    @Expose
    private String kHAMMAT;
    @SerializedName("KHAM_DA_LIEU")
    @Expose
    private String kHAMDALIEU;
    @SerializedName("KHAM_DINH_DUONG")
    @Expose
    private String kHAMDINHDUONG;
    @SerializedName("KHAM_VAN_DONG")
    @Expose
    private String kHAMVANDONG;
    @SerializedName("KHAM_CQ_KHAC")
    @Expose
    private String kHAMCQKHAC;
    @SerializedName("KHAM_DANH_GIA")
    @Expose
    private String kHAMDANHGIA;
    @SerializedName("NGUY_CO_SUY_DINH_DUONG")
    @Expose
    private Integer nGUYCOSUYDINHDUONG;
    @SerializedName("NGUY_CO_BEO_PHI")
    @Expose
    private Integer nGUYCOBEOPHI;
    @SerializedName("TU_VE_SINH_CA_NHAN")
    @Expose
    private Integer tUVESINHCANHAN;
    @SerializedName("TU_DI_LAI")
    @Expose
    private Integer tUDILAI;
    @SerializedName("TU_MAC_QUAN_AO")
    @Expose
    private Integer tUMACQUANAO;
    @SerializedName("DAI_TIEU_TIEN_TC")
    @Expose
    private Integer dAITIEUTIENTC;
    @SerializedName("TU_AN_UONG")
    @Expose
    private Integer tUANUONG;
    @SerializedName("TU_SU_DUNG_DT")
    @Expose
    private Integer tUSUDUNGDT;
    @SerializedName("TU_MUA_BAN")
    @Expose
    private Integer tUMUABAN;
    @SerializedName("TU_NAU_AN")
    @Expose
    private Integer tUNAUAN;
    @SerializedName("TU_DON_DEP")
    @Expose
    private Integer tUDONDEP;
    @SerializedName("TU_GIAT_GIU")
    @Expose
    private Integer tUGIATGIU;
    @SerializedName("TU_UONG_HAY_CHICH_THUOC")
    @Expose
    private Integer tUUONGHAYCHICHTHUOC;
    @SerializedName("GIAM_TRI_NHO")
    @Expose
    private Integer gIAMTRINHO;
    @SerializedName("GIA_DINH_CO_NG_MAC")
    @Expose
    private Integer gIADINHCONGMAC;
    @SerializedName("SO_LOAI_THUOC_SU_DUNG")
    @Expose
    private String sOLOAITHUOCSUDUNG;
    @SerializedName("XN_NHOM_MAU_ABO")
    @Expose
    private String xNNHOMMAUABO;
    @SerializedName("XN_NHOM_MAU_RH")
    @Expose
    private String xNNHOMMAURH;
    @SerializedName("XN_CONG_THUC_MAU")
    @Expose
    private String xNCONGTHUCMAU;
    @SerializedName("XN_SINH_HOA_MAU")
    @Expose
    private String xNSINHHOAMAU;
    @SerializedName("XN_SH_NUOC_TIEU")
    @Expose
    private String xNSHNUOCTIEU;
    @SerializedName("XN_SIEU_AM")
    @Expose
    private String xNSIEUAM;
    @SerializedName("LOAI_IDCs")
    @Expose
    private List<LOAIIDC> lOAIIDCs = null;
    @SerializedName("ID_BENH_VIEN")
    @Expose
    private Integer iDBENHVIEN;
    @SerializedName("IBENH_VIEN")
    @Expose
    private String iBENHVIEN;
    @SerializedName("BAC_SI_KHAM")
    @Expose
    private String bACSIKHAM;
    @SerializedName("BENH_THEO_DOIs")
    @Expose
    private List<BENHTHEODOI> bENHTHEODOIs = null;
    @SerializedName("NGAY_HEN_KHAM")
    @Expose
    private String nGAYHENKHAM;

    public String getMAYTECANHAN() {
        return mAYTECANHAN;
    }

    public void setMAYTECANHAN(String mAYTECANHAN) {
        this.mAYTECANHAN = mAYTECANHAN;
    }

    public String getNGAYKHAM() {
        return nGAYKHAM;
    }

    public void setNGAYKHAM(String nGAYKHAM) {
        this.nGAYKHAM = nGAYKHAM;
    }

    public String getBENHSU() {
        return bENHSU;
    }

    public void setBENHSU(String bENHSU) {
        this.bENHSU = bENHSU;
    }

    public Double getMACH() {
        return mACH;
    }

    public void setMACH(Double mACH) {
        this.mACH = mACH;
    }

    public Double getNHIETDO() {
        return nHIETDO;
    }

    public void setNHIETDO(Double nHIETDO) {
        this.nHIETDO = nHIETDO;
    }

    public Integer getHUYETAPTD() {
        return hUYETAPTD;
    }

    public void setHUYETAPTD(Integer hUYETAPTD) {
        this.hUYETAPTD = hUYETAPTD;
    }

    public Integer getHUYETAPTT() {
        return hUYETAPTT;
    }

    public void setHUYETAPTT(Integer hUYETAPTT) {
        this.hUYETAPTT = hUYETAPTT;
    }

    public Integer getNHIPTHO() {
        return nHIPTHO;
    }

    public void setNHIPTHO(Integer nHIPTHO) {
        this.nHIPTHO = nHIPTHO;
    }

    public Double getCANNANG() {
        return cANNANG;
    }

    public void setCANNANG(Double cANNANG) {
        this.cANNANG = cANNANG;
    }

    public Double getCHIEUCAO() {
        return cHIEUCAO;
    }

    public void setCHIEUCAO(Double cHIEUCAO) {
        this.cHIEUCAO = cHIEUCAO;
    }

    public Double getVONGBUNG() {
        return vONGBUNG;
    }

    public void setVONGBUNG(Double vONGBUNG) {
        this.vONGBUNG = vONGBUNG;
    }

    public Double getBMI() {
        return bMI;
    }

    public void setBMI(Double bMI) {
        this.bMI = bMI;
    }

    public Integer getMATPHAIKK() {
        return mATPHAIKK;
    }

    public void setMATPHAIKK(Integer mATPHAIKK) {
        this.mATPHAIKK = mATPHAIKK;
    }

    public Integer getMATTRAIKK() {
        return mATTRAIKK;
    }

    public void setMATTRAIKK(Integer mATTRAIKK) {
        this.mATTRAIKK = mATTRAIKK;
    }

    public Integer getMATPHAICK() {
        return mATPHAICK;
    }

    public void setMATPHAICK(Integer mATPHAICK) {
        this.mATPHAICK = mATPHAICK;
    }

    public Integer getMATTRAICK() {
        return mATTRAICK;
    }

    public void setMATTRAICK(Integer mATTRAICK) {
        this.mATTRAICK = mATTRAICK;
    }

    public String getKHAMDA() {
        return kHAMDA;
    }

    public void setKHAMDA(String kHAMDA) {
        this.kHAMDA = kHAMDA;
    }

    public String getKHAMNIEMMAC() {
        return kHAMNIEMMAC;
    }

    public void setKHAMNIEMMAC(String kHAMNIEMMAC) {
        this.kHAMNIEMMAC = kHAMNIEMMAC;
    }

    public String getKHAMTTKHAC() {
        return kHAMTTKHAC;
    }

    public void setKHAMTTKHAC(String kHAMTTKHAC) {
        this.kHAMTTKHAC = kHAMTTKHAC;
    }

    public String getKHAMTIMMACH() {
        return kHAMTIMMACH;
    }

    public void setKHAMTIMMACH(String kHAMTIMMACH) {
        this.kHAMTIMMACH = kHAMTIMMACH;
    }

    public String getKHAMHOHAP() {
        return kHAMHOHAP;
    }

    public void setKHAMHOHAP(String kHAMHOHAP) {
        this.kHAMHOHAP = kHAMHOHAP;
    }

    public String getKHAMTIETNIEU() {
        return kHAMTIETNIEU;
    }

    public void setKHAMTIETNIEU(String kHAMTIETNIEU) {
        this.kHAMTIETNIEU = kHAMTIETNIEU;
    }

    public String getKHAMTIEUHOA() {
        return kHAMTIEUHOA;
    }

    public void setKHAMTIEUHOA(String kHAMTIEUHOA) {
        this.kHAMTIEUHOA = kHAMTIEUHOA;
    }

    public String getKHAMCXK() {
        return kHAMCXK;
    }

    public void setKHAMCXK(String kHAMCXK) {
        this.kHAMCXK = kHAMCXK;
    }

    public String getKHAMNOITIET() {
        return kHAMNOITIET;
    }

    public void setKHAMNOITIET(String kHAMNOITIET) {
        this.kHAMNOITIET = kHAMNOITIET;
    }

    public String getKHAMTHANKINH() {
        return kHAMTHANKINH;
    }

    public void setKHAMTHANKINH(String kHAMTHANKINH) {
        this.kHAMTHANKINH = kHAMTHANKINH;
    }

    public String getKHAMTAMTHAN() {
        return kHAMTAMTHAN;
    }

    public void setKHAMTAMTHAN(String kHAMTAMTHAN) {
        this.kHAMTAMTHAN = kHAMTAMTHAN;
    }

    public String getKHAMNGOAIKHOA() {
        return kHAMNGOAIKHOA;
    }

    public void setKHAMNGOAIKHOA(String kHAMNGOAIKHOA) {
        this.kHAMNGOAIKHOA = kHAMNGOAIKHOA;
    }

    public String getKHAMSANPHUKHOA() {
        return kHAMSANPHUKHOA;
    }

    public void setKHAMSANPHUKHOA(String kHAMSANPHUKHOA) {
        this.kHAMSANPHUKHOA = kHAMSANPHUKHOA;
    }

    public String getKHAMTAIMUIHONG() {
        return kHAMTAIMUIHONG;
    }

    public void setKHAMTAIMUIHONG(String kHAMTAIMUIHONG) {
        this.kHAMTAIMUIHONG = kHAMTAIMUIHONG;
    }

    public String getKHAMRANGHAMMAT() {
        return kHAMRANGHAMMAT;
    }

    public void setKHAMRANGHAMMAT(String kHAMRANGHAMMAT) {
        this.kHAMRANGHAMMAT = kHAMRANGHAMMAT;
    }

    public String getKHAMMAT() {
        return kHAMMAT;
    }

    public void setKHAMMAT(String kHAMMAT) {
        this.kHAMMAT = kHAMMAT;
    }

    public String getKHAMDALIEU() {
        return kHAMDALIEU;
    }

    public void setKHAMDALIEU(String kHAMDALIEU) {
        this.kHAMDALIEU = kHAMDALIEU;
    }

    public String getKHAMDINHDUONG() {
        return kHAMDINHDUONG;
    }

    public void setKHAMDINHDUONG(String kHAMDINHDUONG) {
        this.kHAMDINHDUONG = kHAMDINHDUONG;
    }

    public String getKHAMVANDONG() {
        return kHAMVANDONG;
    }

    public void setKHAMVANDONG(String kHAMVANDONG) {
        this.kHAMVANDONG = kHAMVANDONG;
    }

    public String getKHAMCQKHAC() {
        return kHAMCQKHAC;
    }

    public void setKHAMCQKHAC(String kHAMCQKHAC) {
        this.kHAMCQKHAC = kHAMCQKHAC;
    }

    public String getKHAMDANHGIA() {
        return kHAMDANHGIA;
    }

    public void setKHAMDANHGIA(String kHAMDANHGIA) {
        this.kHAMDANHGIA = kHAMDANHGIA;
    }

    public Integer getNGUYCOSUYDINHDUONG() {
        return nGUYCOSUYDINHDUONG;
    }

    public void setNGUYCOSUYDINHDUONG(Integer nGUYCOSUYDINHDUONG) {
        this.nGUYCOSUYDINHDUONG = nGUYCOSUYDINHDUONG;
    }

    public Integer getNGUYCOBEOPHI() {
        return nGUYCOBEOPHI;
    }

    public void setNGUYCOBEOPHI(Integer nGUYCOBEOPHI) {
        this.nGUYCOBEOPHI = nGUYCOBEOPHI;
    }

    public Integer getTUVESINHCANHAN() {
        return tUVESINHCANHAN;
    }

    public void setTUVESINHCANHAN(Integer tUVESINHCANHAN) {
        this.tUVESINHCANHAN = tUVESINHCANHAN;
    }

    public Integer getTUDILAI() {
        return tUDILAI;
    }

    public void setTUDILAI(Integer tUDILAI) {
        this.tUDILAI = tUDILAI;
    }

    public Integer getTUMACQUANAO() {
        return tUMACQUANAO;
    }

    public void setTUMACQUANAO(Integer tUMACQUANAO) {
        this.tUMACQUANAO = tUMACQUANAO;
    }

    public Integer getDAITIEUTIENTC() {
        return dAITIEUTIENTC;
    }

    public void setDAITIEUTIENTC(Integer dAITIEUTIENTC) {
        this.dAITIEUTIENTC = dAITIEUTIENTC;
    }

    public Integer getTUANUONG() {
        return tUANUONG;
    }

    public void setTUANUONG(Integer tUANUONG) {
        this.tUANUONG = tUANUONG;
    }

    public Integer getTUSUDUNGDT() {
        return tUSUDUNGDT;
    }

    public void setTUSUDUNGDT(Integer tUSUDUNGDT) {
        this.tUSUDUNGDT = tUSUDUNGDT;
    }

    public Integer getTUMUABAN() {
        return tUMUABAN;
    }

    public void setTUMUABAN(Integer tUMUABAN) {
        this.tUMUABAN = tUMUABAN;
    }

    public Integer getTUNAUAN() {
        return tUNAUAN;
    }

    public void setTUNAUAN(Integer tUNAUAN) {
        this.tUNAUAN = tUNAUAN;
    }

    public Integer getTUDONDEP() {
        return tUDONDEP;
    }

    public void setTUDONDEP(Integer tUDONDEP) {
        this.tUDONDEP = tUDONDEP;
    }

    public Integer getTUGIATGIU() {
        return tUGIATGIU;
    }

    public void setTUGIATGIU(Integer tUGIATGIU) {
        this.tUGIATGIU = tUGIATGIU;
    }

    public Integer getTUUONGHAYCHICHTHUOC() {
        return tUUONGHAYCHICHTHUOC;
    }

    public void setTUUONGHAYCHICHTHUOC(Integer tUUONGHAYCHICHTHUOC) {
        this.tUUONGHAYCHICHTHUOC = tUUONGHAYCHICHTHUOC;
    }

    public Integer getGIAMTRINHO() {
        return gIAMTRINHO;
    }

    public void setGIAMTRINHO(Integer gIAMTRINHO) {
        this.gIAMTRINHO = gIAMTRINHO;
    }

    public Integer getGIADINHCONGMAC() {
        return gIADINHCONGMAC;
    }

    public void setGIADINHCONGMAC(Integer gIADINHCONGMAC) {
        this.gIADINHCONGMAC = gIADINHCONGMAC;
    }

    public String getSOLOAITHUOCSUDUNG() {
        return sOLOAITHUOCSUDUNG;
    }

    public void setSOLOAITHUOCSUDUNG(String sOLOAITHUOCSUDUNG) {
        this.sOLOAITHUOCSUDUNG = sOLOAITHUOCSUDUNG;
    }

    public String getXNNHOMMAUABO() {
        return xNNHOMMAUABO;
    }

    public void setXNNHOMMAUABO(String xNNHOMMAUABO) {
        this.xNNHOMMAUABO = xNNHOMMAUABO;
    }

    public String getXNNHOMMAURH() {
        return xNNHOMMAURH;
    }

    public void setXNNHOMMAURH(String xNNHOMMAURH) {
        this.xNNHOMMAURH = xNNHOMMAURH;
    }

    public String getXNCONGTHUCMAU() {
        return xNCONGTHUCMAU;
    }

    public void setXNCONGTHUCMAU(String xNCONGTHUCMAU) {
        this.xNCONGTHUCMAU = xNCONGTHUCMAU;
    }

    public String getXNSINHHOAMAU() {
        return xNSINHHOAMAU;
    }

    public void setXNSINHHOAMAU(String xNSINHHOAMAU) {
        this.xNSINHHOAMAU = xNSINHHOAMAU;
    }

    public String getXNSHNUOCTIEU() {
        return xNSHNUOCTIEU;
    }

    public void setXNSHNUOCTIEU(String xNSHNUOCTIEU) {
        this.xNSHNUOCTIEU = xNSHNUOCTIEU;
    }

    public String getXNSIEUAM() {
        return xNSIEUAM;
    }

    public void setXNSIEUAM(String xNSIEUAM) {
        this.xNSIEUAM = xNSIEUAM;
    }

    public List<LOAIIDC> getLOAIIDCs() {
        return lOAIIDCs;
    }

    public void setLOAIIDCs(List<LOAIIDC> lOAIIDCs) {
        this.lOAIIDCs = lOAIIDCs;
    }

    public Integer getIDBENHVIEN() {
        return iDBENHVIEN;
    }

    public void setIDBENHVIEN(Integer iDBENHVIEN) {
        this.iDBENHVIEN = iDBENHVIEN;
    }

    public String getIBENHVIEN() {
        return iBENHVIEN;
    }

    public void setIBENHVIEN(String iBENHVIEN) {
        this.iBENHVIEN = iBENHVIEN;
    }

    public String getBACSIKHAM() {
        return bACSIKHAM;
    }

    public void setBACSIKHAM(String bACSIKHAM) {
        this.bACSIKHAM = bACSIKHAM;
    }

    public List<BENHTHEODOI> getBENHTHEODOIs() {
        return bENHTHEODOIs;
    }

    public void setBENHTHEODOIs(List<BENHTHEODOI> bENHTHEODOIs) {
        this.bENHTHEODOIs = bENHTHEODOIs;
    }

    public String getNGAYHENKHAM() {
        return nGAYHENKHAM;
    }

    public void setNGAYHENKHAM(String nGAYHENKHAM) {
        this.nGAYHENKHAM = nGAYHENKHAM;
    }
}
