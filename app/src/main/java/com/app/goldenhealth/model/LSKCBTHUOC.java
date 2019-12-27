package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LSKCBTHUOC {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("TEN_THUOC")
    @Expose
    private String tENTHUOC;
    @SerializedName("SO_LUONG")
    @Expose
    private Double sOLUONG;
    @SerializedName("LIEU_DUNG")
    @Expose
    private String lIEUDUNG;
    @SerializedName("DM_DUONG_DUNG_ID")
    @Expose
    private Integer dMDUONGDUNGID;
    @SerializedName("DM_DUONG_DUNG")
    @Expose
    private String dMDUONGDUNG;
    @SerializedName("SO_DANG_KY")
    @Expose
    private String sODANGKY;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getTENTHUOC() {
        return tENTHUOC;
    }

    public void setTENTHUOC(String tENTHUOC) {
        this.tENTHUOC = tENTHUOC;
    }

    public Double getSOLUONG() {
        return sOLUONG;
    }

    public void setSOLUONG(Double sOLUONG) {
        this.sOLUONG = sOLUONG;
    }

    public String getLIEUDUNG() {
        return lIEUDUNG;
    }

    public void setLIEUDUNG(String lIEUDUNG) {
        this.lIEUDUNG = lIEUDUNG;
    }

    public Integer getDMDUONGDUNGID() {
        return dMDUONGDUNGID;
    }

    public void setDMDUONGDUNGID(Integer dMDUONGDUNGID) {
        this.dMDUONGDUNGID = dMDUONGDUNGID;
    }

    public String getDMDUONGDUNG() {
        return dMDUONGDUNG;
    }

    public void setDMDUONGDUNG(String dMDUONGDUNG) {
        this.dMDUONGDUNG = dMDUONGDUNG;
    }

    public String getSODANGKY() {
        return sODANGKY;
    }

    public void setSODANGKY(String sODANGKY) {
        this.sODANGKY = sODANGKY;
    }
}
