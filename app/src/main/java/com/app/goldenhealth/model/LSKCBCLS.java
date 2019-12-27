package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LSKCBCLS {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("MA_DICH_VU")
    @Expose
    private String mADICHVU;
    @SerializedName("NHOM_DICH_VU")
    @Expose
    private String nHOMDICHVU;
    @SerializedName("NHOM_DICH_VU_ID")
    @Expose
    private Integer nHOMDICHVUID;
    @SerializedName("TEN_DICH_VU")
    @Expose
    private String tENDICHVU;
    @SerializedName("KET_QUA")
    @Expose
    private String kETQUA;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getMADICHVU() {
        return mADICHVU;
    }

    public void setMADICHVU(String mADICHVU) {
        this.mADICHVU = mADICHVU;
    }

    public String getNHOMDICHVU() {
        return nHOMDICHVU;
    }

    public void setNHOMDICHVU(String nHOMDICHVU) {
        this.nHOMDICHVU = nHOMDICHVU;
    }

    public Integer getNHOMDICHVUID() {
        return nHOMDICHVUID;
    }

    public void setNHOMDICHVUID(Integer nHOMDICHVUID) {
        this.nHOMDICHVUID = nHOMDICHVUID;
    }

    public String getTENDICHVU() {
        return tENDICHVU;
    }

    public void setTENDICHVU(String tENDICHVU) {
        this.tENDICHVU = tENDICHVU;
    }

    public String getKETQUA() {
        return kETQUA;
    }

    public void setKETQUA(String kETQUA) {
        this.kETQUA = kETQUA;
    }
}
