package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thon {
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
    @SerializedName("MA_HUYEN")
    @Expose
    private String mAHUYEN;
    @SerializedName("MA_XA")
    @Expose
    private String mAXA;

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

    public String getMAHUYEN() {
        return mAHUYEN;
    }

    public void setMAHUYEN(String mAHUYEN) {
        this.mAHUYEN = mAHUYEN;
    }

    public String getMAXA() {
        return mAXA;
    }

    public void setMAXA(String mAXA) {
        this.mAXA = mAXA;
    }

}
