package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TienSuPhauThuat {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("MA_DVKT")
    @Expose
    private String mADVKT;
    @SerializedName("MA_KCB_ID")
    @Expose
    private Integer mAKCBID;
    @SerializedName("TEN_KCB")
    @Expose
    private String tENKCB;
    @SerializedName("NGAY_THUC_HIEN")
    @Expose
    private String nGAYTHUCHIEN;
    @SerializedName("BO_PHAN_PHAU_THUAT")
    @Expose
    private String bOPHANPHAUTHUAT;
    @SerializedName("NAM_THUC_HIEN")
    @Expose
    private Integer nAMTHUCHIEN;
    @SerializedName("MT_PT")
    @Expose
    private String mTPT;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getMADVKT() {
        return mADVKT;
    }

    public void setMADVKT(String mADVKT) {
        this.mADVKT = mADVKT;
    }

    public Integer getMAKCBID() {
        return mAKCBID;
    }

    public void setMAKCBID(Integer mAKCBID) {
        this.mAKCBID = mAKCBID;
    }

    public String getTENKCB() {
        return tENKCB;
    }

    public void setTENKCB(String tENKCB) {
        this.tENKCB = tENKCB;
    }

    public String getNGAYTHUCHIEN() {
        return nGAYTHUCHIEN;
    }

    public void setNGAYTHUCHIEN(String nGAYTHUCHIEN) {
        this.nGAYTHUCHIEN = nGAYTHUCHIEN;
    }

    public String getBOPHANPHAUTHUAT() {
        return bOPHANPHAUTHUAT;
    }

    public void setBOPHANPHAUTHUAT(String bOPHANPHAUTHUAT) {
        this.bOPHANPHAUTHUAT = bOPHANPHAUTHUAT;
    }

    public Integer getNAMTHUCHIEN() {
        return nAMTHUCHIEN;
    }

    public void setNAMTHUCHIEN(Integer nAMTHUCHIEN) {
        this.nAMTHUCHIEN = nAMTHUCHIEN;
    }

    public String getMTPT() {
        return mTPT;
    }

    public void setMTPT(String mTPT) {
        this.mTPT = mTPT;
    }
}
