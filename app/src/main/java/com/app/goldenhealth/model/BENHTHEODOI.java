package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BENHTHEODOI {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("MA")
    @Expose
    private String mA;
    @SerializedName("TEN")
    @Expose
    private String tEN;
    @SerializedName("TEN_TIENG_ANH")
    @Expose
    private String tENTIENGANH;
    @SerializedName("MO_TA")
    @Expose
    private String mOTA;

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

    public String getTENTIENGANH() {
        return tENTIENGANH;
    }

    public void setTENTIENGANH(String tENTIENGANH) {
        this.tENTIENGANH = tENTIENGANH;
    }

    public String getMOTA() {
        return mOTA;
    }

    public void setMOTA(String mOTA) {
        this.mOTA = mOTA;
    }
}
