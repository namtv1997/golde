package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class KhaoSatDapAn implements Serializable {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("DapAn")
    @Expose
    private String dapAn;
    @SerializedName("STT")
    @Expose
    private Integer sTT;
    private boolean isChecked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDapAn() {
        return dapAn;
    }

    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }

    public Integer getSTT() {
        return sTT;
    }

    public void setSTT(Integer sTT) {
        this.sTT = sTT;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
