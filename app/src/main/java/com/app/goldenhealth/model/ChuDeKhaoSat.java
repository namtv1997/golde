package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChuDeKhaoSat {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("STT")
    @Expose
    private Integer sTT;
    @SerializedName("Ten")
    @Expose
    private String ten;
    @SerializedName("Mota")
    @Expose
    private String mota;
    @SerializedName("NgayTao")
    @Expose
    private String ngayTao;
    private boolean isSelected;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSTT() {
        return sTT;
    }

    public void setSTT(Integer sTT) {
        this.sTT = sTT;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
