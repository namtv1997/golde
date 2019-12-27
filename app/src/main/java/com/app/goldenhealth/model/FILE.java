package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FILE {
    @SerializedName("FILE_NAME")
    @Expose
    private String fILENAME;
    @SerializedName("FILE")
    @Expose
    private String fILE;

    public String getFILENAME() {
        return fILENAME;
    }

    public void setFILENAME(String fILENAME) {
        this.fILENAME = fILENAME;
    }

    public String getFILE() {
        return fILE;
    }

    public void setFILE(String fILE) {
        this.fILE = fILE;
    }

}
