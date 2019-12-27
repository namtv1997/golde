package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KhuyetTat {
    @SerializedName("THINH_LUC")
    @Expose
    private Integer tHINHLUC;
    @SerializedName("MT_THINH_LUC")
    @Expose
    private String mTTHINHLUC;
    @SerializedName("THI_LUC")
    @Expose
    private Integer tHILUC;
    @SerializedName("MT_THI_LUC")
    @Expose
    private String mTTHILUC;
    @SerializedName("TAY")
    @Expose
    private Integer tAY;
    @SerializedName("MT_TAY")
    @Expose
    private String mTTAY;
    @SerializedName("CHAN")
    @Expose
    private Integer cHAN;
    @SerializedName("MT_CHAN")
    @Expose
    private String mTCHAN;
    @SerializedName("CONG_VEO_CS")
    @Expose
    private Integer cONGVEOCS;
    @SerializedName("MT_CONG_VEO_CS")
    @Expose
    private String mTCONGVEOCS;
    @SerializedName("KHAC")
    @Expose
    private String kHAC;
    @SerializedName("MA_KCB_ID")
    @Expose
    private Integer mAKCBID;
    @SerializedName("MOI_HO")
    @Expose
    private Integer mOIHO;
    @SerializedName("MT_MOI_HO")
    @Expose
    private String mTMOIHO;

    public Integer getTHINHLUC() {
        return tHINHLUC;
    }

    public void setTHINHLUC(Integer tHINHLUC) {
        this.tHINHLUC = tHINHLUC;
    }

    public String getMTTHINHLUC() {
        return mTTHINHLUC;
    }

    public void setMTTHINHLUC(String mTTHINHLUC) {
        this.mTTHINHLUC = mTTHINHLUC;
    }

    public Integer getTHILUC() {
        return tHILUC;
    }

    public void setTHILUC(Integer tHILUC) {
        this.tHILUC = tHILUC;
    }

    public String getMTTHILUC() {
        return mTTHILUC;
    }

    public void setMTTHILUC(String mTTHILUC) {
        this.mTTHILUC = mTTHILUC;
    }

    public Integer getTAY() {
        return tAY;
    }

    public void setTAY(Integer tAY) {
        this.tAY = tAY;
    }

    public String getMTTAY() {
        return mTTAY;
    }

    public void setMTTAY(String mTTAY) {
        this.mTTAY = mTTAY;
    }

    public Integer getCHAN() {
        return cHAN;
    }

    public void setCHAN(Integer cHAN) {
        this.cHAN = cHAN;
    }

    public String getMTCHAN() {
        return mTCHAN;
    }

    public void setMTCHAN(String mTCHAN) {
        this.mTCHAN = mTCHAN;
    }

    public Integer getCONGVEOCS() {
        return cONGVEOCS;
    }

    public void setCONGVEOCS(Integer cONGVEOCS) {
        this.cONGVEOCS = cONGVEOCS;
    }

    public String getMTCONGVEOCS() {
        return mTCONGVEOCS;
    }

    public void setMTCONGVEOCS(String mTCONGVEOCS) {
        this.mTCONGVEOCS = mTCONGVEOCS;
    }

    public String getKHAC() {
        return kHAC;
    }

    public void setKHAC(String kHAC) {
        this.kHAC = kHAC;
    }

    public Integer getMAKCBID() {
        return mAKCBID;
    }

    public void setMAKCBID(Integer mAKCBID) {
        this.mAKCBID = mAKCBID;
    }

    public Integer getMOIHO() {
        return mOIHO;
    }

    public void setMOIHO(Integer mOIHO) {
        this.mOIHO = mOIHO;
    }

    public String getMTMOIHO() {
        return mTMOIHO;
    }

    public void setMTMOIHO(String mTMOIHO) {
        this.mTMOIHO = mTMOIHO;
    }

}
