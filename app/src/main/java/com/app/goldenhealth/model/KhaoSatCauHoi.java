package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class KhaoSatCauHoi implements Serializable {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("CauHoi")
    @Expose
    private String cauHoi;
    @SerializedName("KieuTL")
    @Expose
    private Integer kieuTL;
    @SerializedName("KS_DapAs")
    @Expose
    private List<KhaoSatDapAn> kSDapAs = null;
    @SerializedName("KS_TraLois")
    @Expose
    private List<KhaoSatTraLoi> kSTraLois = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public Integer getKieuTL() {
        return kieuTL;
    }

    public void setKieuTL(Integer kieuTL) {
        this.kieuTL = kieuTL;
    }

    public List<KhaoSatDapAn> getKSDapAs() {
        return kSDapAs;
    }

    public void setKSDapAs(List<KhaoSatDapAn> kSDapAs) {
        this.kSDapAs = kSDapAs;
    }

    public List<KhaoSatTraLoi> getKSTraLois() {
        return kSTraLois;
    }

    public void setKSTraLois(List<KhaoSatTraLoi> kSTraLois) {
        this.kSTraLois = kSTraLois;
    }
}
