package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DMKHOA {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("TEN")
    @Expose
    private String tEN;
    @SerializedName("MO_TA")
    @Expose
    private String mOTA;
    @SerializedName("MA_KHOA")
    @Expose
    private String mAKHOA;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
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

    public String getMAKHOA() {
        return mAKHOA;
    }

    public void setMAKHOA(String mAKHOA) {
        this.mAKHOA = mAKHOA;
    }

}
