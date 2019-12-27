package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Huyen {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("MA")
    @Expose
    private String mA;
    @SerializedName("TEN")
    @Expose
    private String tEN;
    @SerializedName("MO_TA")
    @Expose
    private String mOTA;
    @SerializedName("MA_TINH")
    @Expose
    private String mATINH;
    @SerializedName("CAP")
    @Expose
    private String cAP;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getMA() {
        return mA;
    }

    public void setMA(String mA) {
        this.mA = mA;
    }

    public String getTEN() {
        return tEN;
    }

    public void setTEN(String tEN) {
        this.tEN = tEN;
    }

    public String getMOTA() {
        return mOTA;
    }

    public void setMOTA(String mOTA) {
        this.mOTA = mOTA;
    }

    public String getMATINH() {
        return mATINH;
    }

    public void setMATINH(String mATINH) {
        this.mATINH = mATINH;
    }

    public String getCAP() {
        return cAP;
    }

    public void setCAP(String cAP) {
        this.cAP = cAP;
    }
}
