package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TinhTrangLucSinh {
    @SerializedName("DE_THUONG")
    @Expose
    private Integer dETHUONG;
    @SerializedName("BI_NGAT")
    @Expose
    private Integer bINGAT;
    @SerializedName("DE_THIEU_THANG")
    @Expose
    private Integer dETHIEUTHANG;
    @SerializedName("CAN_NANG")
    @Expose
    private Double cANNANG;
    @SerializedName("KHOC_KHI_SINH")
    @Expose
    private Integer kHOCKHISINH;
    @SerializedName("DI_TAT")
    @Expose
    private String dITAT;
    @SerializedName("VAN_DE_KHAC")
    @Expose
    private String vANDEKHAC;
    @SerializedName("MA_KCB_ID")
    @Expose
    private Integer mAKCBID;
    @SerializedName("CHIEU_DAI")
    @Expose
    private Double cHIEUDAI;

    public Integer getDETHUONG() {
        return dETHUONG;
    }

    public void setDETHUONG(Integer dETHUONG) {
        this.dETHUONG = dETHUONG;
    }

    public Integer getBINGAT() {
        return bINGAT;
    }

    public void setBINGAT(Integer bINGAT) {
        this.bINGAT = bINGAT;
    }

    public Integer getDETHIEUTHANG() {
        return dETHIEUTHANG;
    }

    public void setDETHIEUTHANG(Integer dETHIEUTHANG) {
        this.dETHIEUTHANG = dETHIEUTHANG;
    }

    public Double getCANNANG() {
        return cANNANG;
    }

    public void setCANNANG(Double cANNANG) {
        this.cANNANG = cANNANG;
    }

    public Integer getKHOCKHISINH() {
        return kHOCKHISINH;
    }

    public void setKHOCKHISINH(Integer kHOCKHISINH) {
        this.kHOCKHISINH = kHOCKHISINH;
    }

    public String getDITAT() {
        return dITAT;
    }

    public void setDITAT(String dITAT) {
        this.dITAT = dITAT;
    }

    public String getVANDEKHAC() {
        return vANDEKHAC;
    }

    public void setVANDEKHAC(String vANDEKHAC) {
        this.vANDEKHAC = vANDEKHAC;
    }

    public Integer getMAKCBID() {
        return mAKCBID;
    }

    public void setMAKCBID(Integer mAKCBID) {
        this.mAKCBID = mAKCBID;
    }

    public Double getCHIEUDAI() {
        return cHIEUDAI;
    }

    public void setCHIEUDAI(Double cHIEUDAI) {
        this.cHIEUDAI = cHIEUDAI;
    }
}
