package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TienSuDiUng {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("LOAI_DI_UNG")
    @Expose
    private String lOAIDIUNG;
    @SerializedName("LOAI_DI_UNG_ID")
    @Expose
    private Integer lOAIDIUNGID;
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

    public String getLOAIDIUNG() {
        return lOAIDIUNG;
    }

    public void setLOAIDIUNG(String lOAIDIUNG) {
        this.lOAIDIUNG = lOAIDIUNG;
    }

    public Integer getLOAIDIUNGID() {
        return lOAIDIUNGID;
    }

    public void setLOAIDIUNGID(Integer lOAIDIUNGID) {
        this.lOAIDIUNGID = lOAIDIUNGID;
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
