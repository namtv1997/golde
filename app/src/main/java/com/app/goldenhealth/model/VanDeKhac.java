package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanDeKhac {
    @SerializedName("VAN_DE")
    @Expose
    private String vANDE;

    public String getVANDE() {
        return vANDE;
    }

    public void setVANDE(String vANDE) {
        this.vANDE = vANDE;
    }
}
