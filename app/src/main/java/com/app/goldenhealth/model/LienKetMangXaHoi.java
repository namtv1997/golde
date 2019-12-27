package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LienKetMangXaHoi {
    @SerializedName("Facebook")
    @Expose
    private String facebook;
    @SerializedName("Zalo")
    @Expose
    private String zalo;
    @SerializedName("Viber")
    @Expose
    private String viber;

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getZalo() {
        return zalo;
    }

    public void setZalo(String zalo) {
        this.zalo = zalo;
    }

    public String getViber() {
        return viber;
    }

    public void setViber(String viber) {
        this.viber = viber;
    }
}
