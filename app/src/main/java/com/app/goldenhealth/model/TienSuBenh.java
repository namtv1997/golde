package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TienSuBenh {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("LOAI_BENH")
    @Expose
    private String lOAIBENH;
    @SerializedName("LOAI_BENH_ID")
    @Expose
    private Integer lOAIBENHID;
    @SerializedName("MO_TA")
    @Expose
    private String mOTA;
    @SerializedName("LOAI_QH_ID")
    @Expose
    private Integer lOAIQHID;
    @SerializedName("LOAI_QH")
    @Expose
    private String lOAIQH;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getLOAIBENH() {
        return lOAIBENH;
    }

    public void setLOAIBENH(String lOAIBENH) {
        this.lOAIBENH = lOAIBENH;
    }

    public Integer getLOAIBENHID() {
        return lOAIBENHID;
    }

    public void setLOAIBENHID(Integer lOAIBENHID) {
        this.lOAIBENHID = lOAIBENHID;
    }

    public String getMOTA() {
        return mOTA;
    }

    public void setMOTA(String mOTA) {
        this.mOTA = mOTA;
    }

    public Integer getLOAIQHID() {
        return lOAIQHID;
    }

    public void setLOAIQHID(Integer lOAIQHID) {
        this.lOAIQHID = lOAIQHID;
    }

    public String getLOAIQH() {
        return lOAIQH;
    }

    public void setLOAIQH(String lOAIQH) {
        this.lOAIQH = lOAIQH;
    }
}
