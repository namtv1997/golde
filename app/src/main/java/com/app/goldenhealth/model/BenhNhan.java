package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BenhNhan {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("IdUser")
    @Expose
    private Integer idUser;
    @SerializedName("User_Name")
    @Expose
    private String userName;
    @SerializedName("User_MaYTeCaNhan")
    @Expose
    private String userMaYTeCaNhan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMaYTeCaNhan() {
        return userMaYTeCaNhan;
    }

    public void setUserMaYTeCaNhan(String userMaYTeCaNhan) {
        this.userMaYTeCaNhan = userMaYTeCaNhan;
    }
}
