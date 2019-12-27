package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BenhVien {
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("MA_CSKCB")
    @Expose
    private String mACSKCB;
    @SerializedName("TEN")
    @Expose
    private String tEN;
    @SerializedName("MO_TA")
    @Expose
    private String mOTA;
    @SerializedName("DIA_CHI")
    @Expose
    private String dIACHI;
    @SerializedName("MA_TINH")
    @Expose
    private String mATINH;
    @SerializedName("MA_HUYEN")
    @Expose
    private String mAHUYEN;
    @SerializedName("MA_XA")
    @Expose
    private String mAXA;
    @SerializedName("TUYEN")
    @Expose
    private Integer tUYEN;
    @SerializedName("HANG")
    @Expose
    private Integer hANG;
    @SerializedName("MA_CAP_TREN")
    @Expose
    private String mACAPTREN;
    @SerializedName("HINH_ANH")
    @Expose
    private String hINHANH;
    @SerializedName("WEBSITE")
    @Expose
    private String wEBSITE;
    @SerializedName("HOTLINE")
    @Expose
    private String hOTLINE;
    @SerializedName("THOI_GIAN")
    @Expose
    private String tHOIGIAN;
    @SerializedName("EMAIL")
    @Expose
    private String eMAIL;
    @SerializedName("THANH_TICH")
    @Expose
    private String tHANHTICH;
    @SerializedName("DM_KHOAs")
    @Expose
    private List<DMKHOA> dMKHOAs = null;
    @SerializedName("BV_HINHANHs")
    @Expose
    private List<BVHINHANH> bVHINHANHs = null;
    @SerializedName("BV_NHAN_XETs")
    @Expose
    private List<BVNHANXET> bVNHANXETs = null;
    @SerializedName("SL_DANH_GIA")
    @Expose
    private Integer sLDANHGIA;
    @SerializedName("SL_DANH_GIA_1")
    @Expose
    private Integer sLDANHGIA1;
    @SerializedName("SL_DANH_GIA_2")
    @Expose
    private Integer sLDANHGIA2;
    @SerializedName("SL_DANH_GIA_3")
    @Expose
    private Integer sLDANHGIA3;
    @SerializedName("SL_DANH_GIA_4")
    @Expose
    private Integer sLDANHGIA4;
    @SerializedName("SL_DANH_GIA_5")
    @Expose
    private Integer sLDANHGIA5;
    @SerializedName("CS_DANH_GIA")
    @Expose
    private Float cSDANHGIA;

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getMACSKCB() {
        return mACSKCB;
    }

    public void setMACSKCB(String mACSKCB) {
        this.mACSKCB = mACSKCB;
    }

    public String getTEN() {
        return tEN;
    }

    public void setTEN(String tEN) {
        this.tEN = tEN;
    }

    public String getMOTA() {
        return mOTA;
    }

    public void setMOTA(String mOTA) {
        this.mOTA = mOTA;
    }

    public String getDIACHI() {
        return dIACHI;
    }

    public void setDIACHI(String dIACHI) {
        this.dIACHI = dIACHI;
    }

    public String getMATINH() {
        return mATINH;
    }

    public void setMATINH(String mATINH) {
        this.mATINH = mATINH;
    }

    public String getMAHUYEN() {
        return mAHUYEN;
    }

    public void setMAHUYEN(String mAHUYEN) {
        this.mAHUYEN = mAHUYEN;
    }

    public String getMAXA() {
        return mAXA;
    }

    public void setMAXA(String mAXA) {
        this.mAXA = mAXA;
    }

    public Integer getTUYEN() {
        return tUYEN;
    }

    public void setTUYEN(Integer tUYEN) {
        this.tUYEN = tUYEN;
    }

    public Integer getHANG() {
        return hANG;
    }

    public void setHANG(Integer hANG) {
        this.hANG = hANG;
    }

    public String getMACAPTREN() {
        return mACAPTREN;
    }

    public void setMACAPTREN(String mACAPTREN) {
        this.mACAPTREN = mACAPTREN;
    }

    public String getHINHANH() {
        return hINHANH;
    }

    public void setHINHANH(String hINHANH) {
        this.hINHANH = hINHANH;
    }

    public String getWEBSITE() {
        return wEBSITE;
    }

    public void setWEBSITE(String wEBSITE) {
        this.wEBSITE = wEBSITE;
    }

    public String getHOTLINE() {
        return hOTLINE;
    }

    public void setHOTLINE(String hOTLINE) {
        this.hOTLINE = hOTLINE;
    }

    public String getTHOIGIAN() {
        return tHOIGIAN;
    }

    public void setTHOIGIAN(String tHOIGIAN) {
        this.tHOIGIAN = tHOIGIAN;
    }

    public String getEMAIL() {
        return eMAIL;
    }

    public void setEMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public String getTHANHTICH() {
        return tHANHTICH;
    }

    public void setTHANHTICH(String tHANHTICH) {
        this.tHANHTICH = tHANHTICH;
    }

    public List<DMKHOA> getDMKHOAs() {
        return dMKHOAs;
    }

    public void setDMKHOAs(List<DMKHOA> dMKHOAs) {
        this.dMKHOAs = dMKHOAs;
    }

    public List<BVHINHANH> getBVHINHANHs() {
        return bVHINHANHs;
    }

    public void setBVHINHANHs(List<BVHINHANH> bVHINHANHs) {
        this.bVHINHANHs = bVHINHANHs;
    }

    public List<BVNHANXET> getBVNHANXETs() {
        return bVNHANXETs;
    }

    public void setBVNHANXETs(List<BVNHANXET> bVNHANXETs) {
        this.bVNHANXETs = bVNHANXETs;
    }

    public Integer getSLDANHGIA() {
        return sLDANHGIA;
    }

    public void setSLDANHGIA(Integer sLDANHGIA) {
        this.sLDANHGIA = sLDANHGIA;
    }

    public Integer getSLDANHGIA1() {
        return sLDANHGIA1;
    }

    public void setSLDANHGIA1(Integer sLDANHGIA1) {
        this.sLDANHGIA1 = sLDANHGIA1;
    }

    public Integer getSLDANHGIA2() {
        return sLDANHGIA2;
    }

    public void setSLDANHGIA2(Integer sLDANHGIA2) {
        this.sLDANHGIA2 = sLDANHGIA2;
    }

    public Integer getSLDANHGIA3() {
        return sLDANHGIA3;
    }

    public void setSLDANHGIA3(Integer sLDANHGIA3) {
        this.sLDANHGIA3 = sLDANHGIA3;
    }

    public Integer getSLDANHGIA4() {
        return sLDANHGIA4;
    }

    public void setSLDANHGIA4(Integer sLDANHGIA4) {
        this.sLDANHGIA4 = sLDANHGIA4;
    }

    public Integer getSLDANHGIA5() {
        return sLDANHGIA5;
    }

    public void setSLDANHGIA5(Integer sLDANHGIA5) {
        this.sLDANHGIA5 = sLDANHGIA5;
    }

    public Float getCSDANHGIA() {
        return cSDANHGIA;
    }

    public void setCSDANHGIA(Float cSDANHGIA) {
        this.cSDANHGIA = cSDANHGIA;
    }

}
