package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ThongTinTomTat {
    @SerializedName("NHOM_MAU")
    @Expose
    private String nHOMMAU;
    @SerializedName("CHIEU_CAO")
    @Expose
    private Double cHIEUCAO;
    @SerializedName("CAN_NANG")
    @Expose
    private Double cANNANG;
    @SerializedName("DU_THUOC")
    @Expose
    private String dUTHUOC;
    @SerializedName("DU_HOA_CHAT")
    @Expose
    private String dUHOACHAT;
    @SerializedName("DU_THUC_PHAM")
    @Expose
    private String dUTHUCPHAM;
    @SerializedName("DU_KHAC")
    @Expose
    private String dUKHAC;
    @SerializedName("HEN_XUYEN")
    @Expose
    private Integer hENXUYEN;
    @SerializedName("PHOI_MAN_TINH")
    @Expose
    private Integer pHOIMANTINH;
    @SerializedName("TIM_MACH")
    @Expose
    private Integer tIMMACH;
    @SerializedName("DAI_THAO_DUONG")
    @Expose
    private Integer dAITHAODUONG;
    @SerializedName("DA_DAY")
    @Expose
    private Integer dADAY;
    @SerializedName("BUOU_CO")
    @Expose
    private Integer bUOUCO;
    @SerializedName("VIEM_GAN")
    @Expose
    private Integer vIEMGAN;
    @SerializedName("TAM_THAN")
    @Expose
    private Integer tAMTHAN;
    @SerializedName("DONG_KINH")
    @Expose
    private Integer dONGKINH;
    @SerializedName("TU_KY")
    @Expose
    private Integer tUKY;
    @SerializedName("UNG_THU")
    @Expose
    private String uNGTHU;
    @SerializedName("LAO")
    @Expose
    private String lAO;
    @SerializedName("KHAC")
    @Expose
    private String kHAC;
    @SerializedName("TANG_HUYET_AP")
    @Expose
    private Integer tANGHUYETAP;
    @SerializedName("TIM_BAM_SINH")
    @Expose
    private Integer tIMBAMSINH;
    @SerializedName("TS_PHAU_THUATS")
    @Expose
    private List<TSPhauThuat> tSPHAUTHUATS = null;

    public String getNHOMMAU() {
        return nHOMMAU;
    }

    public void setNHOMMAU(String nHOMMAU) {
        this.nHOMMAU = nHOMMAU;
    }

    public Double getCHIEUCAO() {
        return cHIEUCAO;
    }

    public void setCHIEUCAO(Double cHIEUCAO) {
        this.cHIEUCAO = cHIEUCAO;
    }

    public Double getCANNANG() {
        return cANNANG;
    }

    public void setCANNANG(Double cANNANG) {
        this.cANNANG = cANNANG;
    }

    public String getDUTHUOC() {
        return dUTHUOC;
    }

    public void setDUTHUOC(String dUTHUOC) {
        this.dUTHUOC = dUTHUOC;
    }

    public String getDUHOACHAT() {
        return dUHOACHAT;
    }

    public void setDUHOACHAT(String dUHOACHAT) {
        this.dUHOACHAT = dUHOACHAT;
    }

    public String getDUTHUCPHAM() {
        return dUTHUCPHAM;
    }

    public void setDUTHUCPHAM(String dUTHUCPHAM) {
        this.dUTHUCPHAM = dUTHUCPHAM;
    }

    public String getDUKHAC() {
        return dUKHAC;
    }

    public void setDUKHAC(String dUKHAC) {
        this.dUKHAC = dUKHAC;
    }

    public Integer getHENXUYEN() {
        return hENXUYEN;
    }

    public void setHENXUYEN(Integer hENXUYEN) {
        this.hENXUYEN = hENXUYEN;
    }

    public Integer getPHOIMANTINH() {
        return pHOIMANTINH;
    }

    public void setPHOIMANTINH(Integer pHOIMANTINH) {
        this.pHOIMANTINH = pHOIMANTINH;
    }

    public Integer getTIMMACH() {
        return tIMMACH;
    }

    public void setTIMMACH(Integer tIMMACH) {
        this.tIMMACH = tIMMACH;
    }

    public Integer getDAITHAODUONG() {
        return dAITHAODUONG;
    }

    public void setDAITHAODUONG(Integer dAITHAODUONG) {
        this.dAITHAODUONG = dAITHAODUONG;
    }

    public Integer getDADAY() {
        return dADAY;
    }

    public void setDADAY(Integer dADAY) {
        this.dADAY = dADAY;
    }

    public Integer getBUOUCO() {
        return bUOUCO;
    }

    public void setBUOUCO(Integer bUOUCO) {
        this.bUOUCO = bUOUCO;
    }

    public Integer getVIEMGAN() {
        return vIEMGAN;
    }

    public void setVIEMGAN(Integer vIEMGAN) {
        this.vIEMGAN = vIEMGAN;
    }

    public Integer getTAMTHAN() {
        return tAMTHAN;
    }

    public void setTAMTHAN(Integer tAMTHAN) {
        this.tAMTHAN = tAMTHAN;
    }

    public Integer getDONGKINH() {
        return dONGKINH;
    }

    public void setDONGKINH(Integer dONGKINH) {
        this.dONGKINH = dONGKINH;
    }

    public Integer getTUKY() {
        return tUKY;
    }

    public void setTUKY(Integer tUKY) {
        this.tUKY = tUKY;
    }

    public String getUNGTHU() {
        return uNGTHU;
    }

    public void setUNGTHU(String uNGTHU) {
        this.uNGTHU = uNGTHU;
    }

    public String getLAO() {
        return lAO;
    }

    public void setLAO(String lAO) {
        this.lAO = lAO;
    }

    public String getKHAC() {
        return kHAC;
    }

    public void setKHAC(String kHAC) {
        this.kHAC = kHAC;
    }

    public Integer getTANGHUYETAP() {
        return tANGHUYETAP;
    }

    public void setTANGHUYETAP(Integer tANGHUYETAP) {
        this.tANGHUYETAP = tANGHUYETAP;
    }

    public Integer getTIMBAMSINH() {
        return tIMBAMSINH;
    }

    public void setTIMBAMSINH(Integer tIMBAMSINH) {
        this.tIMBAMSINH = tIMBAMSINH;
    }

    public List<TSPhauThuat> getTSPHAUTHUATS() {
        return tSPHAUTHUATS;
    }

    public void setTSPHAUTHUATS(List<TSPhauThuat> tSPHAUTHUATS) {
        this.tSPHAUTHUATS = tSPHAUTHUATS;
    }


}
