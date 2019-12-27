package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BVNHANXET {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("NHAN_XET")
    @Expose
    private String nHANXET;
    @SerializedName("DANH_GIA")
    @Expose
    private float dANHGIA;
    @SerializedName("NGAY_TAO")
    @Expose
    private String nGAYTAO;
    @SerializedName("MA_Y_TE_CA_NHAN")
    @Expose
    private String mAYTECANHAN;
    @SerializedName("HO_TEN_NNX")
    @Expose
    private String hOTENNNX;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getNHANXET() {
        return nHANXET;
    }

    public void setNHANXET(String nHANXET) {
        this.nHANXET = nHANXET;
    }

    public float getDANHGIA() {
        return dANHGIA;
    }

    public void setDANHGIA(float dANHGIA) {
        this.dANHGIA = dANHGIA;
    }

    public String getNGAYTAO() {
        return nGAYTAO;
    }

    public void setNGAYTAO(String nGAYTAO) {
        this.nGAYTAO = nGAYTAO;
    }

    public String getMAYTECANHAN() {
        return mAYTECANHAN;
    }

    public void setMAYTECANHAN(String mAYTECANHAN) {
        this.mAYTECANHAN = mAYTECANHAN;
    }

    public String getHOTENNNX() {
        return hOTENNNX;
    }

    public void setHOTENNNX(String hOTENNNX) {
        this.hOTENNNX = hOTENNNX;
    }

}
