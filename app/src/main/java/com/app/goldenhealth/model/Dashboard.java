package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dashboard {
    @SerializedName("TS_NGUOI")
    @Expose
    private Integer tSNGUOI;
    @SerializedName("TS_TRE_EM")
    @Expose
    private Integer tSTREEM;
    @SerializedName("TS_GT_NAM")
    @Expose
    private Integer tSGTNAM;
    @SerializedName("TS_GT_NU")
    @Expose
    private Integer tSGTNU;
    @SerializedName("TS_PHU_NU")
    @Expose
    private Integer tSPHUNU;
    @SerializedName("TS_NG_CAO_TUOI")
    @Expose
    private Integer tSNGCAOTUOI;
    @SerializedName("TS_HO")
    @Expose
    private Integer tSHO;

    public Integer getTSNGUOI() {
        return tSNGUOI;
    }

    public void setTSNGUOI(Integer tSNGUOI) {
        this.tSNGUOI = tSNGUOI;
    }

    public Integer getTSTREEM() {
        return tSTREEM;
    }

    public void setTSTREEM(Integer tSTREEM) {
        this.tSTREEM = tSTREEM;
    }

    public Integer getTSGTNAM() {
        return tSGTNAM;
    }

    public void setTSGTNAM(Integer tSGTNAM) {
        this.tSGTNAM = tSGTNAM;
    }

    public Integer getTSGTNU() {
        return tSGTNU;
    }

    public void setTSGTNU(Integer tSGTNU) {
        this.tSGTNU = tSGTNU;
    }

    public Integer getTSPHUNU() {
        return tSPHUNU;
    }

    public void setTSPHUNU(Integer tSPHUNU) {
        this.tSPHUNU = tSPHUNU;
    }

    public Integer getTSNGCAOTUOI() {
        return tSNGCAOTUOI;
    }

    public void setTSNGCAOTUOI(Integer tSNGCAOTUOI) {
        this.tSNGCAOTUOI = tSNGCAOTUOI;
    }

    public Integer getTSHO() {
        return tSHO;
    }

    public void setTSHO(Integer tSHO) {
        this.tSHO = tSHO;
    }

}
