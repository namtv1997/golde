package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CauHoiThuongGap {
    @SerializedName("STT")
    @Expose
    private String sTT;
    @SerializedName("NoiDung")
    @Expose
    private String noiDung;

    public String getSTT() {
        return sTT;
    }

    public void setSTT(String sTT) {
        this.sTT = sTT;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
