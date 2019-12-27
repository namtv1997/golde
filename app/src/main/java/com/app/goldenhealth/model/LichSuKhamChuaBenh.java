package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LichSuKhamChuaBenh {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("NGAY_KHAM")
    @Expose
    private String nGAYKHAM;
    @SerializedName("NGAY_BAT_DAU")
    @Expose
    private String nGAYBATDAU;
    @SerializedName("NGAY_KET_THUC")
    @Expose
    private String nGAYKETTHUC;
    @SerializedName("CSKCB")
    @Expose
    private String cSKCB;
    @SerializedName("MA_CSKCB_ID")
    @Expose
    private Integer mACSKCBID;
    @SerializedName("LY_DO_KHAM")
    @Expose
    private String lYDOKHAM;
    @SerializedName("BENH_SU")
    @Expose
    private String bENHSU;
    @SerializedName("MACH")
    @Expose
    private Double mACH;
    @SerializedName("NHIET_DO")
    @Expose
    private Double nHIETDO;
    @SerializedName("HUYET_AP_TT")
    @Expose
    private Integer hUYETAPTT;
    @SerializedName("HUYET_AP_TD")
    @Expose
    private Integer hUYETAPTD;
    @SerializedName("NHIP_THO")
    @Expose
    private Integer nHIPTHO;
    @SerializedName("CHIEU_CAO")
    @Expose
    private Double cHIEUCAO;
    @SerializedName("CAN_NANG")
    @Expose
    private Double cANNANG;
    @SerializedName("CHI_SO_BMI")
    @Expose
    private Double cHISOBMI;
    @SerializedName("VONG_BUNG")
    @Expose
    private Double vONGBUNG;
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
    @SerializedName("KHAM_TIEU_HOA")
    @Expose
    private String kHAMTIEUHOA;
    @SerializedName("KHAM_TIET_NIEU")
    @Expose
    private String kHAMTIETNIEU;
    @SerializedName("KHAM_CXK")
    @Expose
    private String kHAMCXK;
    @SerializedName("KHAM_NOI_TIET")
    @Expose
    private String kHAMNOITIET;
    @SerializedName("KHAM_THAN_KINH")
    @Expose
    private String kHAMTHANKINH;
    @SerializedName("KHAM_CQ_KHAC")
    @Expose
    private String kHAMCQKHAC;
    @SerializedName("KHAM_MAT")
    @Expose
    private String kHAMMAT;
    @SerializedName("KHAM_TMH")
    @Expose
    private String kHAMTMH;
    @SerializedName("KHAM_RHM")
    @Expose
    private String kHAMRHM;
    @SerializedName("KHAM_DINH_DUONG")
    @Expose
    private String kHAMDINHDUONG;
    @SerializedName("XN_SINH_HOA_MAU")
    @Expose
    private String xNSINHHOAMAU;
    @SerializedName("XN_CONG_THUC_MAU")
    @Expose
    private String xNCONGTHUCMAU;
    @SerializedName("XQUANG")
    @Expose
    private String xQUANG;
    @SerializedName("SIEU_AM")
    @Expose
    private String sIEUAM;
    @SerializedName("XN_KHAC")
    @Expose
    private String xNKHAC;
    @SerializedName("TU_VAN")
    @Expose
    private String tUVAN;
    @SerializedName("HEN_LICH_KHAM")
    @Expose
    private String hENLICHKHAM;
    @SerializedName("MA_ICD_ID")
    @Expose
    private Integer mAICDID;
    @SerializedName("HS_KSK_LAP_HS_ID")
    @Expose
    private Integer hSKSKLAPHSID;
    @SerializedName("BAC_SI_KHAM")
    @Expose
    private String bACSIKHAM;
    @SerializedName("KHAM_DANH_GIA")
    @Expose
    private String kHAMDANHGIA;
    @SerializedName("KHAM_TAM_THAN")
    @Expose
    private String kHAMTAMTHAN;
    @SerializedName("KHAM_VAN_DONG")
    @Expose
    private String kHAMVANDONG;
    @SerializedName("HS_LAP")
    @Expose
    private Integer hSLAP;
    @SerializedName("MA_ICDS")
    @Expose
    private String mAICDS;
    @SerializedName("MA_ICDS_THEO_DOI")
    @Expose
    private String mAICDSTHEODOI;
    @SerializedName("ID_GOC")
    @Expose
    private String iDGOC;
    @SerializedName("TIEN_THUOC")
    @Expose
    private Double tIENTHUOC;
    @SerializedName("TIEN_VTYT")
    @Expose
    private Double tIENVTYT;
    @SerializedName("TIEN_TONG")
    @Expose
    private Double tIENTONG;
    @SerializedName("TIEN_BNTT")
    @Expose
    private Double tIENBNTT;
    @SerializedName("TIEN_BHTT")
    @Expose
    private Double tIENBHTT;
    @SerializedName("TIEN_NGUONKHAC")
    @Expose
    private Double tIENNGUONKHAC;
    @SerializedName("TIEN_NGOAIDS")
    @Expose
    private Double tIENNGOAIDS;
    @SerializedName("TIEN_XN")
    @Expose
    private Double tIENXN;
    @SerializedName("TIEN_CDHA")
    @Expose
    private Double tIENCDHA;
    @SerializedName("TIEN_TDCN")
    @Expose
    private Double tIENTDCN;
    @SerializedName("TIEN_THUOC_BHYT")
    @Expose
    private Double tIENTHUOCBHYT;
    @SerializedName("TIEN_THUOC_TTTL")
    @Expose
    private Double tIENTHUOCTTTL;
    @SerializedName("TIEN_MAU")
    @Expose
    private Double tIENMAU;
    @SerializedName("TIEN_PTTT")
    @Expose
    private Double tIENPTTT;
    @SerializedName("TIEN_DVKT")
    @Expose
    private Double tIENDVKT;
    @SerializedName("TIEN_VAN_CHUYEN")
    @Expose
    private Double tIENVANCHUYEN;
    @SerializedName("TIEN_KHAM")
    @Expose
    private Double tIENKHAM;
    @SerializedName("TIEN_GIUONG_NGOAI")
    @Expose
    private Double tIENGIUONGNGOAI;
    @SerializedName("TIEN_GIUONG_NOI")
    @Expose
    private Double tIENGIUONGNOI;
    @SerializedName("TIEN_THUOC_UNGTHU")
    @Expose
    private Double tIENTHUOCUNGTHU;
    @SerializedName("TIEN_VTYT_TYLE")
    @Expose
    private Double tIENVTYTTYLE;
    @SerializedName("TIEN_VTYT_BHYT")
    @Expose
    private Double tIENVTYTBHYT;
    @SerializedName("TIEN_BNCCT")
    @Expose
    private Double tIENBNCCT;
    @SerializedName("ICDs")
    @Expose
    private List<ICD> iCDs = null;
    @SerializedName("LS_KCB_CLSs")
    @Expose
    private List<LSKCBCLS> lSKCBCLSs = null;
    @SerializedName("LS_KCB_THUOCs")
    @Expose
    private List<LSKCBTHUOC> lSKCBTHUOCs = null;
    @SerializedName("LS_KCB_DVKTs")
    @Expose
    private List<LSKCBDVKT> lSKCBDVKTs = null;
    private String YEAR;

    public String getYEAR() {
        return YEAR;
    }

    public void setYEAR() {
        SimpleDateFormat formatFrom = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatTo = new SimpleDateFormat("yyyy");
        try {
            YEAR = formatTo.format(formatFrom.parse(nGAYBATDAU));
        } catch (ParseException e) {
            e.printStackTrace();
            YEAR = "0";
        }

    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getNGAYKHAM() {
        return nGAYKHAM;
    }

    public void setNGAYKHAM(String nGAYKHAM) {
        this.nGAYKHAM = nGAYKHAM;
    }

    public String getNGAYBATDAU() {
        return nGAYBATDAU;
    }

    public void setNGAYBATDAU(String nGAYBATDAU) {
        this.nGAYBATDAU = nGAYBATDAU;
    }

    public String getNGAYKETTHUC() {
        return nGAYKETTHUC;
    }

    public void setNGAYKETTHUC(String nGAYKETTHUC) {
        this.nGAYKETTHUC = nGAYKETTHUC;
    }

    public String getCSKCB() {
        return cSKCB;
    }

    public void setCSKCB(String cSKCB) {
        this.cSKCB = cSKCB;
    }

    public Integer getMACSKCBID() {
        return mACSKCBID;
    }

    public void setMACSKCBID(Integer mACSKCBID) {
        this.mACSKCBID = mACSKCBID;
    }

    public String getLYDOKHAM() {
        return lYDOKHAM;
    }

    public void setLYDOKHAM(String lYDOKHAM) {
        this.lYDOKHAM = lYDOKHAM;
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

    public Integer getHUYETAPTT() {
        return hUYETAPTT;
    }

    public void setHUYETAPTT(Integer hUYETAPTT) {
        this.hUYETAPTT = hUYETAPTT;
    }

    public Integer getHUYETAPTD() {
        return hUYETAPTD;
    }

    public void setHUYETAPTD(Integer hUYETAPTD) {
        this.hUYETAPTD = hUYETAPTD;
    }

    public Integer getNHIPTHO() {
        return nHIPTHO;
    }

    public void setNHIPTHO(Integer nHIPTHO) {
        this.nHIPTHO = nHIPTHO;
    }

    public Double getCHIEUCAO() {
        return cHIEUCAO;
    }

    public void setCHIEUCAO(Double cHIEUCAO) {
        this.cHIEUCAO = cHIEUCAO;
    }

    public Double getCANNANG() {
        return cANNANG;
    }

    public void setCANNANG(Double cANNANG) {
        this.cANNANG = cANNANG;
    }

    public Double getCHISOBMI() {
        return cHISOBMI;
    }

    public void setCHISOBMI(Double cHISOBMI) {
        this.cHISOBMI = cHISOBMI;
    }

    public Double getVONGBUNG() {
        return vONGBUNG;
    }

    public void setVONGBUNG(Double vONGBUNG) {
        this.vONGBUNG = vONGBUNG;
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

    public String getKHAMTIEUHOA() {
        return kHAMTIEUHOA;
    }

    public void setKHAMTIEUHOA(String kHAMTIEUHOA) {
        this.kHAMTIEUHOA = kHAMTIEUHOA;
    }

    public String getKHAMTIETNIEU() {
        return kHAMTIETNIEU;
    }

    public void setKHAMTIETNIEU(String kHAMTIETNIEU) {
        this.kHAMTIETNIEU = kHAMTIETNIEU;
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

    public String getKHAMCQKHAC() {
        return kHAMCQKHAC;
    }

    public void setKHAMCQKHAC(String kHAMCQKHAC) {
        this.kHAMCQKHAC = kHAMCQKHAC;
    }

    public String getKHAMMAT() {
        return kHAMMAT;
    }

    public void setKHAMMAT(String kHAMMAT) {
        this.kHAMMAT = kHAMMAT;
    }

    public String getKHAMTMH() {
        return kHAMTMH;
    }

    public void setKHAMTMH(String kHAMTMH) {
        this.kHAMTMH = kHAMTMH;
    }

    public String getKHAMRHM() {
        return kHAMRHM;
    }

    public void setKHAMRHM(String kHAMRHM) {
        this.kHAMRHM = kHAMRHM;
    }

    public String getKHAMDINHDUONG() {
        return kHAMDINHDUONG;
    }

    public void setKHAMDINHDUONG(String kHAMDINHDUONG) {
        this.kHAMDINHDUONG = kHAMDINHDUONG;
    }

    public String getXNSINHHOAMAU() {
        return xNSINHHOAMAU;
    }

    public void setXNSINHHOAMAU(String xNSINHHOAMAU) {
        this.xNSINHHOAMAU = xNSINHHOAMAU;
    }

    public String getXNCONGTHUCMAU() {
        return xNCONGTHUCMAU;
    }

    public void setXNCONGTHUCMAU(String xNCONGTHUCMAU) {
        this.xNCONGTHUCMAU = xNCONGTHUCMAU;
    }

    public String getXQUANG() {
        return xQUANG;
    }

    public void setXQUANG(String xQUANG) {
        this.xQUANG = xQUANG;
    }

    public String getSIEUAM() {
        return sIEUAM;
    }

    public void setSIEUAM(String sIEUAM) {
        this.sIEUAM = sIEUAM;
    }

    public String getXNKHAC() {
        return xNKHAC;
    }

    public void setXNKHAC(String xNKHAC) {
        this.xNKHAC = xNKHAC;
    }

    public String getTUVAN() {
        return tUVAN;
    }

    public void setTUVAN(String tUVAN) {
        this.tUVAN = tUVAN;
    }

    public String getHENLICHKHAM() {
        return hENLICHKHAM;
    }

    public void setHENLICHKHAM(String hENLICHKHAM) {
        this.hENLICHKHAM = hENLICHKHAM;
    }

    public Integer getMAICDID() {
        return mAICDID;
    }

    public void setMAICDID(Integer mAICDID) {
        this.mAICDID = mAICDID;
    }

    public Integer getHSKSKLAPHSID() {
        return hSKSKLAPHSID;
    }

    public void setHSKSKLAPHSID(Integer hSKSKLAPHSID) {
        this.hSKSKLAPHSID = hSKSKLAPHSID;
    }

    public String getBACSIKHAM() {
        return bACSIKHAM;
    }

    public void setBACSIKHAM(String bACSIKHAM) {
        this.bACSIKHAM = bACSIKHAM;
    }

    public String getKHAMDANHGIA() {
        return kHAMDANHGIA;
    }

    public void setKHAMDANHGIA(String kHAMDANHGIA) {
        this.kHAMDANHGIA = kHAMDANHGIA;
    }

    public String getKHAMTAMTHAN() {
        return kHAMTAMTHAN;
    }

    public void setKHAMTAMTHAN(String kHAMTAMTHAN) {
        this.kHAMTAMTHAN = kHAMTAMTHAN;
    }

    public String getKHAMVANDONG() {
        return kHAMVANDONG;
    }

    public void setKHAMVANDONG(String kHAMVANDONG) {
        this.kHAMVANDONG = kHAMVANDONG;
    }

    public Integer getHSLAP() {
        return hSLAP;
    }

    public void setHSLAP(Integer hSLAP) {
        this.hSLAP = hSLAP;
    }

    public String getMAICDS() {
        return mAICDS;
    }

    public void setMAICDS(String mAICDS) {
        this.mAICDS = mAICDS;
    }

    public String getMAICDSTHEODOI() {
        return mAICDSTHEODOI;
    }

    public void setMAICDSTHEODOI(String mAICDSTHEODOI) {
        this.mAICDSTHEODOI = mAICDSTHEODOI;
    }

    public String getIDGOC() {
        return iDGOC;
    }

    public void setIDGOC(String iDGOC) {
        this.iDGOC = iDGOC;
    }

    public Double getTIENTHUOC() {
        return tIENTHUOC;
    }

    public void setTIENTHUOC(Double tIENTHUOC) {
        this.tIENTHUOC = tIENTHUOC;
    }

    public Double getTIENVTYT() {
        return tIENVTYT;
    }

    public void setTIENVTYT(Double tIENVTYT) {
        this.tIENVTYT = tIENVTYT;
    }

    public Double getTIENTONG() {
        return tIENTONG;
    }

    public void setTIENTONG(Double tIENTONG) {
        this.tIENTONG = tIENTONG;
    }

    public Double getTIENBNTT() {
        return tIENBNTT;
    }

    public void setTIENBNTT(Double tIENBNTT) {
        this.tIENBNTT = tIENBNTT;
    }

    public Double getTIENBHTT() {
        return tIENBHTT;
    }

    public void setTIENBHTT(Double tIENBHTT) {
        this.tIENBHTT = tIENBHTT;
    }

    public Double getTIENNGUONKHAC() {
        return tIENNGUONKHAC;
    }

    public void setTIENNGUONKHAC(Double tIENNGUONKHAC) {
        this.tIENNGUONKHAC = tIENNGUONKHAC;
    }

    public Double getTIENNGOAIDS() {
        return tIENNGOAIDS;
    }

    public void setTIENNGOAIDS(Double tIENNGOAIDS) {
        this.tIENNGOAIDS = tIENNGOAIDS;
    }

    public Double getTIENXN() {
        return tIENXN;
    }

    public void setTIENXN(Double tIENXN) {
        this.tIENXN = tIENXN;
    }

    public Double getTIENCDHA() {
        return tIENCDHA;
    }

    public void setTIENCDHA(Double tIENCDHA) {
        this.tIENCDHA = tIENCDHA;
    }

    public Double getTIENTDCN() {
        return tIENTDCN;
    }

    public void setTIENTDCN(Double tIENTDCN) {
        this.tIENTDCN = tIENTDCN;
    }

    public Double getTIENTHUOCBHYT() {
        return tIENTHUOCBHYT;
    }

    public void setTIENTHUOCBHYT(Double tIENTHUOCBHYT) {
        this.tIENTHUOCBHYT = tIENTHUOCBHYT;
    }

    public Double getTIENTHUOCTTTL() {
        return tIENTHUOCTTTL;
    }

    public void setTIENTHUOCTTTL(Double tIENTHUOCTTTL) {
        this.tIENTHUOCTTTL = tIENTHUOCTTTL;
    }

    public Double getTIENMAU() {
        return tIENMAU;
    }

    public void setTIENMAU(Double tIENMAU) {
        this.tIENMAU = tIENMAU;
    }

    public Double getTIENPTTT() {
        return tIENPTTT;
    }

    public void setTIENPTTT(Double tIENPTTT) {
        this.tIENPTTT = tIENPTTT;
    }

    public Double getTIENDVKT() {
        return tIENDVKT;
    }

    public void setTIENDVKT(Double tIENDVKT) {
        this.tIENDVKT = tIENDVKT;
    }

    public Double getTIENVANCHUYEN() {
        return tIENVANCHUYEN;
    }

    public void setTIENVANCHUYEN(Double tIENVANCHUYEN) {
        this.tIENVANCHUYEN = tIENVANCHUYEN;
    }

    public Double getTIENKHAM() {
        return tIENKHAM;
    }

    public void setTIENKHAM(Double tIENKHAM) {
        this.tIENKHAM = tIENKHAM;
    }

    public Double getTIENGIUONGNGOAI() {
        return tIENGIUONGNGOAI;
    }

    public void setTIENGIUONGNGOAI(Double tIENGIUONGNGOAI) {
        this.tIENGIUONGNGOAI = tIENGIUONGNGOAI;
    }

    public Double getTIENGIUONGNOI() {
        return tIENGIUONGNOI;
    }

    public void setTIENGIUONGNOI(Double tIENGIUONGNOI) {
        this.tIENGIUONGNOI = tIENGIUONGNOI;
    }

    public Double getTIENTHUOCUNGTHU() {
        return tIENTHUOCUNGTHU;
    }

    public void setTIENTHUOCUNGTHU(Double tIENTHUOCUNGTHU) {
        this.tIENTHUOCUNGTHU = tIENTHUOCUNGTHU;
    }

    public Double getTIENVTYTTYLE() {
        return tIENVTYTTYLE;
    }

    public void setTIENVTYTTYLE(Double tIENVTYTTYLE) {
        this.tIENVTYTTYLE = tIENVTYTTYLE;
    }

    public Double getTIENVTYTBHYT() {
        return tIENVTYTBHYT;
    }

    public void setTIENVTYTBHYT(Double tIENVTYTBHYT) {
        this.tIENVTYTBHYT = tIENVTYTBHYT;
    }

    public Double getTIENBNCCT() {
        return tIENBNCCT;
    }

    public void setTIENBNCCT(Double tIENBNCCT) {
        this.tIENBNCCT = tIENBNCCT;
    }

    public List<ICD> getICDs() {
        return iCDs;
    }

    public void setICDs(List<ICD> iCDs) {
        this.iCDs = iCDs;
    }

    public List<LSKCBCLS> getLSKCBCLSs() {
        return lSKCBCLSs;
    }

    public void setLSKCBCLSs(List<LSKCBCLS> lSKCBCLSs) {
        this.lSKCBCLSs = lSKCBCLSs;
    }

    public List<LSKCBTHUOC> getLSKCBTHUOCs() {
        return lSKCBTHUOCs;
    }

    public void setLSKCBTHUOCs(List<LSKCBTHUOC> lSKCBTHUOCs) {
        this.lSKCBTHUOCs = lSKCBTHUOCs;
    }

    public List<LSKCBDVKT> getLSKCBDVKTs() {
        return lSKCBDVKTs;
    }

    public void setLSKCBDVKTs(List<LSKCBDVKT> lSKCBDVKTs) {
        this.lSKCBDVKTs = lSKCBDVKTs;
    }

}
