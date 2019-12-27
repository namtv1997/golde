package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BVHINHANH {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("HINH_ANH")
    @Expose
    private String hINHANH;
    @SerializedName("DM_BENH_VIEN_ID")
    @Expose
    private Integer dMBENHVIENID;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getHINHANH() {
        return hINHANH;
    }

    public void setHINHANH(String hINHANH) {
        this.hINHANH = hINHANH;
    }

    public Integer getDMBENHVIENID() {
        return dMBENHVIENID;
    }

    public void setDMBENHVIENID(Integer dMBENHVIENID) {
        this.dMBENHVIENID = dMBENHVIENID;
    }
}
