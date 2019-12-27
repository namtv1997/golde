package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SKSS_KHHGD {
    @SerializedName("BPTTs")
    @Expose
    private List<BPTT> bPTTs = null;
    @SerializedName("SO_LAN_CO_THAI")
    @Expose
    private Integer sOLANCOTHAI;
    @SerializedName("SO_LAN_SAY_THAI")
    @Expose
    private Integer sOLANSAYTHAI;
    @SerializedName("SO_LAN_PHA_THAI")
    @Expose
    private Integer sOLANPHATHAI;
    @SerializedName("SO_LAN_DE")
    @Expose
    private Integer sOLANDE;
    @SerializedName("DE_THUONG")
    @Expose
    private Integer dETHUONG;
    @SerializedName("DE_KHO")
    @Expose
    private Integer dEKHO;
    @SerializedName("SO_LAN_DE_DU_THANG")
    @Expose
    private Integer sOLANDEDUTHANG;
    @SerializedName("SO_CON_SONG")
    @Expose
    private Integer sOCONSONG;
    @SerializedName("BENH_PHU_KHOA")
    @Expose
    private String bENHPHUKHOA;
    @SerializedName("SO_LAN_DE_NON")
    @Expose
    private Integer sOLANDENON;
    @SerializedName("DE_MO")
    @Expose
    private Integer dEMO;
    @SerializedName("KY_THAI_CUOI")
    @Expose
    private String kYTHAICUOI;

    public List<BPTT> getBPTTs() {
        return bPTTs;
    }

    public void setBPTTs(List<BPTT> bPTTs) {
        this.bPTTs = bPTTs;
    }

    public Integer getSOLANCOTHAI() {
        return sOLANCOTHAI;
    }

    public void setSOLANCOTHAI(Integer sOLANCOTHAI) {
        this.sOLANCOTHAI = sOLANCOTHAI;
    }

    public Integer getSOLANSAYTHAI() {
        return sOLANSAYTHAI;
    }

    public void setSOLANSAYTHAI(Integer sOLANSAYTHAI) {
        this.sOLANSAYTHAI = sOLANSAYTHAI;
    }

    public Integer getSOLANPHATHAI() {
        return sOLANPHATHAI;
    }

    public void setSOLANPHATHAI(Integer sOLANPHATHAI) {
        this.sOLANPHATHAI = sOLANPHATHAI;
    }

    public Integer getSOLANDE() {
        return sOLANDE;
    }

    public void setSOLANDE(Integer sOLANDE) {
        this.sOLANDE = sOLANDE;
    }

    public Integer getDETHUONG() {
        return dETHUONG;
    }

    public void setDETHUONG(Integer dETHUONG) {
        this.dETHUONG = dETHUONG;
    }

    public Integer getDEKHO() {
        return dEKHO;
    }

    public void setDEKHO(Integer dEKHO) {
        this.dEKHO = dEKHO;
    }

    public Integer getSOLANDEDUTHANG() {
        return sOLANDEDUTHANG;
    }

    public void setSOLANDEDUTHANG(Integer sOLANDEDUTHANG) {
        this.sOLANDEDUTHANG = sOLANDEDUTHANG;
    }

    public Integer getSOCONSONG() {
        return sOCONSONG;
    }

    public void setSOCONSONG(Integer sOCONSONG) {
        this.sOCONSONG = sOCONSONG;
    }

    public String getBENHPHUKHOA() {
        return bENHPHUKHOA;
    }

    public void setBENHPHUKHOA(String bENHPHUKHOA) {
        this.bENHPHUKHOA = bENHPHUKHOA;
    }

    public Integer getSOLANDENON() {
        return sOLANDENON;
    }

    public void setSOLANDENON(Integer sOLANDENON) {
        this.sOLANDENON = sOLANDENON;
    }

    public Integer getDEMO() {
        return dEMO;
    }

    public void setDEMO(Integer dEMO) {
        this.dEMO = dEMO;
    }

    public String getKYTHAICUOI() {
        return kYTHAICUOI;
    }

    public void setKYTHAICUOI(String kYTHAICUOI) {
        this.kYTHAICUOI = kYTHAICUOI;
    }

    @Override
    public String toString() {
        return "SKSS_KHHGD{" +
                "bPTTs=" + bPTTs +
                ", sOLANCOTHAI=" + sOLANCOTHAI +
                ", sOLANSAYTHAI=" + sOLANSAYTHAI +
                ", sOLANPHATHAI=" + sOLANPHATHAI +
                ", sOLANDE=" + sOLANDE +
                ", dETHUONG=" + dETHUONG +
                ", dEKHO=" + dEKHO +
                ", sOLANDEDUTHANG=" + sOLANDEDUTHANG +
                ", sOCONSONG=" + sOCONSONG +
                ", bENHPHUKHOA='" + bENHPHUKHOA + '\'' +
                ", sOLANDENON=" + sOLANDENON +
                ", dEMO=" + dEMO +
                ", kYTHAICUOI='" + kYTHAICUOI + '\'' +
                '}';
    }
}
