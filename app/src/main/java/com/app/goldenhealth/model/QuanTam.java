package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuanTam {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("UID")
    @Expose
    private String uID;
    @SerializedName("AVATAR")
    @Expose
    private String aVATAR;
    @SerializedName("NGAY_TAO")
    @Expose
    private String nGAYTAO;
    @SerializedName("HO_TEN")
    @Expose
    private String hOTEN;
    @SerializedName("EMAIL")
    @Expose
    private String eMAIL;
    @SerializedName("SDT")
    @Expose
    private String sDT;
    @SerializedName("DIA_CHI")
    @Expose
    private String dIACHI;
    @SerializedName("IsAnonymous")
    @Expose
    private Boolean isAnonymous;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUID() {
        return uID;
    }

    public void setUID(String uID) {
        this.uID = uID;
    }

    public String getAVATAR() {
        return aVATAR;
    }

    public void setAVATAR(String aVATAR) {
        this.aVATAR = aVATAR;
    }

    public String getNGAYTAO() {
        return nGAYTAO;
    }

    public void setNGAYTAO(String nGAYTAO) {
        this.nGAYTAO = nGAYTAO;
    }

    public String getHOTEN() {
        return hOTEN;
    }

    public void setHOTEN(String hOTEN) {
        this.hOTEN = hOTEN;
    }

    public String getEMAIL() {
        return eMAIL;
    }

    public void setEMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public String getSDT() {
        return sDT;
    }

    public void setSDT(String sDT) {
        this.sDT = sDT;
    }

    public String getDIACHI() {
        return dIACHI;
    }

    public void setDIACHI(String dIACHI) {
        this.dIACHI = dIACHI;
    }

    public Boolean getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Boolean isAnonymous) {
        this.isAnonymous = isAnonymous;
    }
}
