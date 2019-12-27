package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class KhaoSatTraLoi implements Serializable {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("KS_DapAnId")
    @Expose
    private Integer kSDapAnId;
    @SerializedName("TraLoi")
    @Expose
    private String traLoi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKSDapAnId() {
        return kSDapAnId;
    }

    public void setKSDapAnId(Integer kSDapAnId) {
        this.kSDapAnId = kSDapAnId;
    }

    public String getTraLoi() {
        return traLoi;
    }

    public void setTraLoi(String traLoi) {
        this.traLoi = traLoi;
    }
}
