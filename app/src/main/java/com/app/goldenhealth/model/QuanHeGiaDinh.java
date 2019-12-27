package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuanHeGiaDinh {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("MA")
    @Expose
    private Integer mA;
    @SerializedName("TEN")
    @Expose
    private String tEN;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getMA() {
        return mA;
    }

    public void setMA(Integer mA) {
        this.mA = mA;
    }

    public String getTEN() {
        return tEN;
    }

    public void setTEN(String tEN) {
        this.tEN = tEN;
    }
}
