package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhanAnh {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("ID_MUC_PHAN_ANH")
    @Expose
    private Integer iDMUCPHANANH;
    @SerializedName("ID_NOI_PHAN_ANH")
    @Expose
    private Integer iDNOIPHANANH;
    @SerializedName("TIEU_DE_PA")
    @Expose
    private String tIEUDEPA;
    @SerializedName("MUC_PHAN_ANH")
    @Expose
    private String mUCPHANANH;
    @SerializedName("NOI_PHAN_ANH")
    @Expose
    private String nOIPHANANH;
    @SerializedName("MA_PHAN_ANH")
    @Expose
    private String mAPHANANH;
    @SerializedName("NG_PHAN_ANH")
    @Expose
    private String nGPHANANH;
    @SerializedName("NOI_DUNG")
    @Expose
    private String nOIDUNG;
    @SerializedName("TRA_LOI")
    @Expose
    private String tRALOI;
    @SerializedName("TRANG_THAI")
    @Expose
    private Integer tRANGTHAI;
    @SerializedName("MUC_DO_CONG_KHAI")
    @Expose
    private String mUCDOCONGKHAI;
    @SerializedName("MUC_DO_CONG_KHAI_ID")
    @Expose
    private Integer mUCDOCONGKHAIID;
    @SerializedName("AVATAR_NG_PA")
    @Expose
    private String aVATARNGPA;
    @SerializedName("AVATAR_NG_TL")
    @Expose
    private String aVATARNGTL;
    @SerializedName("TEN_NG_TL")
    @Expose
    private String tENNGTL;
    @SerializedName("NGAY_TAO")
    @Expose
    private String nGAYTAO;
    @SerializedName("NGAY_TAO_ORD")
    @Expose
    private String nGAYTAOORD;
    @SerializedName("NGAY_TL")
    @Expose
    private String nGAYTL;
    @SerializedName("FILEs")
    @Expose
    private List<FILE> fILEs = null;
    @SerializedName("COMMENTS")
    @Expose
    private List<Comment> cOMMENTS = null;
    @SerializedName("QUAN_TAMS")
    @Expose
    private List<QuanTam> qUANTAMS = null;
    @SerializedName("SL_QUAN_TAM")
    @Expose
    private Integer sLQUANTAM;
    @SerializedName("SL_CHIA_SE")
    @Expose
    private Integer sLCHIASE;
    @SerializedName("SL_BINH_LUAN")
    @Expose
    private Integer sLBINHLUAN;
    @SerializedName("SL_DANH_GIA")
    @Expose
    private Integer sLDANHGIA;
    @SerializedName("DANH_GIA")
    @Expose
    private Float dANHGIA;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getIDMUCPHANANH() {
        return iDMUCPHANANH;
    }

    public void setIDMUCPHANANH(Integer iDMUCPHANANH) {
        this.iDMUCPHANANH = iDMUCPHANANH;
    }

    public Integer getIDNOIPHANANH() {
        return iDNOIPHANANH;
    }

    public void setIDNOIPHANANH(Integer iDNOIPHANANH) {
        this.iDNOIPHANANH = iDNOIPHANANH;
    }

    public String getTIEUDEPA() {
        return tIEUDEPA;
    }

    public void setTIEUDEPA(String tIEUDEPA) {
        this.tIEUDEPA = tIEUDEPA;
    }

    public String getMUCPHANANH() {
        return mUCPHANANH;
    }

    public void setMUCPHANANH(String mUCPHANANH) {
        this.mUCPHANANH = mUCPHANANH;
    }

    public String getNOIPHANANH() {
        return nOIPHANANH;
    }

    public void setNOIPHANANH(String nOIPHANANH) {
        this.nOIPHANANH = nOIPHANANH;
    }

    public String getMAPHANANH() {
        return mAPHANANH;
    }

    public void setMAPHANANH(String mAPHANANH) {
        this.mAPHANANH = mAPHANANH;
    }

    public String getNGPHANANH() {
        return nGPHANANH;
    }

    public void setNGPHANANH(String nGPHANANH) {
        this.nGPHANANH = nGPHANANH;
    }

    public String getNOIDUNG() {
        return nOIDUNG;
    }

    public void setNOIDUNG(String nOIDUNG) {
        this.nOIDUNG = nOIDUNG;
    }

    public String getTRALOI() {
        return tRALOI;
    }

    public void setTRALOI(String tRALOI) {
        this.tRALOI = tRALOI;
    }

    public Integer getTRANGTHAI() {
        return tRANGTHAI;
    }

    public void setTRANGTHAI(Integer tRANGTHAI) {
        this.tRANGTHAI = tRANGTHAI;
    }

    public String getMUCDOCONGKHAI() {
        return mUCDOCONGKHAI;
    }

    public void setMUCDOCONGKHAI(String mUCDOCONGKHAI) {
        this.mUCDOCONGKHAI = mUCDOCONGKHAI;
    }

    public Integer getMUCDOCONGKHAIID() {
        return mUCDOCONGKHAIID;
    }

    public void setMUCDOCONGKHAIID(Integer mUCDOCONGKHAIID) {
        this.mUCDOCONGKHAIID = mUCDOCONGKHAIID;
    }

    public String getAVATARNGPA() {
        return aVATARNGPA;
    }

    public void setAVATARNGPA(String aVATARNGPA) {
        this.aVATARNGPA = aVATARNGPA;
    }

    public String getAVATARNGTL() {
        return aVATARNGTL;
    }

    public void setAVATARNGTL(String aVATARNGTL) {
        this.aVATARNGTL = aVATARNGTL;
    }

    public String getTENNGTL() {
        return tENNGTL;
    }

    public void setTENNGTL(String tENNGTL) {
        this.tENNGTL = tENNGTL;
    }

    public String getNGAYTAO() {
        return nGAYTAO;
    }

    public void setNGAYTAO(String nGAYTAO) {
        this.nGAYTAO = nGAYTAO;
    }

    public String getNGAYTAOORD() {
        return nGAYTAOORD;
    }

    public void setNGAYTAOORD(String nGAYTAOORD) {
        this.nGAYTAOORD = nGAYTAOORD;
    }

    public String getNGAYTL() {
        return nGAYTL;
    }

    public void setNGAYTL(String nGAYTL) {
        this.nGAYTL = nGAYTL;
    }

    public List<FILE> getFILEs() {
        return fILEs;
    }

    public void setFILEs(List<FILE> fILEs) {
        this.fILEs = fILEs;
    }

    public List<Comment> getCOMMENTS() {
        return cOMMENTS;
    }

    public void setCOMMENTS(List<Comment> cOMMENTS) {
        this.cOMMENTS = cOMMENTS;
    }

    public List<QuanTam> getQUANTAMS() {
        return qUANTAMS;
    }

    public void setQUANTAMS(List<QuanTam> qUANTAMS) {
        this.qUANTAMS = qUANTAMS;
    }

    public Integer getSLQUANTAM() {
        return sLQUANTAM;
    }

    public void setSLQUANTAM(Integer sLQUANTAM) {
        this.sLQUANTAM = sLQUANTAM;
    }

    public Integer getSLCHIASE() {
        return sLCHIASE;
    }

    public void setSLCHIASE(Integer sLCHIASE) {
        this.sLCHIASE = sLCHIASE;
    }

    public Integer getSLBINHLUAN() {
        return sLBINHLUAN;
    }

    public void setSLBINHLUAN(Integer sLBINHLUAN) {
        this.sLBINHLUAN = sLBINHLUAN;
    }

    public Integer getiD() {
        return iD;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }

    public Integer getsLDANHGIA() {
        return sLDANHGIA;
    }

    public void setsLDANHGIA(Integer sLDANHGIA) {
        this.sLDANHGIA = sLDANHGIA;
    }

    public float getdANHGIA() {
        return dANHGIA;
    }

    public void setdANHGIA(float dANHGIA) {
        this.dANHGIA = dANHGIA;
    }
}
