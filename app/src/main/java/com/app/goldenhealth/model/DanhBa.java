package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DanhBa {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("BENH_VIEN_ID")
    @Expose
    private Integer bENHVIENID;
    @SerializedName("BENH_VIEN")
    @Expose
    private String bENHVIEN;
    @SerializedName("BAC_SI_ID")
    @Expose
    private Integer bACSIID;
    @SerializedName("BAC_SI")
    @Expose
    private String bACSI;
    @SerializedName("BV_BAC_SI_ID")
    @Expose
    private Integer bVBACSIID;
    @SerializedName("BV_BAC_SI")
    @Expose
    private String bVBACSI;
    @SerializedName("AVATAR")
    @Expose
    private String aVATAR;
    @SerializedName("SL_DANH_GIA")
    @Expose
    private Integer sLDANHGIA;
    @SerializedName("CS_DANH_GIA")
    @Expose
    private Float cSDANHGIA;
    @SerializedName("TYPE")
    @Expose
    private Integer tYPE;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getBENHVIENID() {
        return bENHVIENID;
    }

    public void setBENHVIENID(Integer bENHVIENID) {
        this.bENHVIENID = bENHVIENID;
    }

    public String getBENHVIEN() {
        return bENHVIEN;
    }

    public void setBENHVIEN(String bENHVIEN) {
        this.bENHVIEN = bENHVIEN;
    }

    public Integer getBACSIID() {
        return bACSIID;
    }

    public void setBACSIID(Integer bACSIID) {
        this.bACSIID = bACSIID;
    }

    public String getBACSI() {
        return bACSI;
    }

    public void setBACSI(String bACSI) {
        this.bACSI = bACSI;
    }

    public Integer getBVBACSIID() {
        return bVBACSIID;
    }

    public void setBVBACSIID(Integer bVBACSIID) {
        this.bVBACSIID = bVBACSIID;
    }

    public String getBVBACSI() {
        return bVBACSI;
    }

    public void setBVBACSI(String bVBACSI) {
        this.bVBACSI = bVBACSI;
    }

    public String getAVATAR() {
        return aVATAR;
    }

    public void setAVATAR(String aVATAR) {
        this.aVATAR = aVATAR;
    }

    public Integer getSLDANHGIA() {
        return sLDANHGIA;
    }

    public void setSLDANHGIA(Integer sLDANHGIA) {
        this.sLDANHGIA = sLDANHGIA;
    }

    public Float getCSDANHGIA() {
        return cSDANHGIA;
    }

    public void setCSDANHGIA(Float cSDANHGIA) {
        this.cSDANHGIA = cSDANHGIA;
    }

    public Integer getTYPE() {
        return tYPE;
    }

    public void setTYPE(Integer tYPE) {
        this.tYPE = tYPE;
    }

}
