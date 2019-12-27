package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("UID")
    @Expose
    private String uID;
    @SerializedName("Avatar")
    @Expose
    private String avatar;
    @SerializedName("EmailID")
    @Expose
    private String emailID;
    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("RoleId")
    @Expose
    private Integer roleId;
    @SerializedName("DateCreate")
    @Expose
    private String dateCreate;
    @SerializedName("FullName")
    @Expose
    private String fullName;
    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("maytecanhan")
    @Expose
    private String maytecanhan;
    @SerializedName("BirthDay")
    @Expose
    private String birthDay;
    @SerializedName("FirebaseToken")
    @Expose
    private String firebaseToken;
    @SerializedName("MaGH")
    @Expose
    private String maGH;
    @SerializedName("Notifications")
    @Expose
    private Integer notifications;
    @SerializedName("ChieuCao")
    @Expose
    private Double chieuCao;
    @SerializedName("CanNang")
    @Expose
    private Double canNang;
    @SerializedName("NhomMau")
    @Expose
    private String nhomMau;
    @SerializedName("BenhVienID")
    @Expose
    private Integer benhVienID;
    @SerializedName("BenhVien")
    @Expose
    private String benhVien;
    @SerializedName("MaBS")
    @Expose
    private String maBS;
    @SerializedName("DiaChi")
    @Expose
    private String diaChi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUID() {
        return uID;
    }

    public void setUID(String uID) {
        this.uID = uID;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMaytecanhan() {
        return maytecanhan;
    }

    public void setMaytecanhan(String maytecanhan) {
        this.maytecanhan = maytecanhan;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getFirebaseToken() {
        return firebaseToken;
    }

    public void setFirebaseToken(String firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    public String getMaGH() {
        return maGH;
    }

    public void setMaGH(String maGH) {
        this.maGH = maGH;
    }

    public Integer getNotifications() {
        return notifications;
    }

    public void setNotifications(Integer notifications) {
        this.notifications = notifications;
    }

    public Double getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(Double chieuCao) {
        this.chieuCao = chieuCao;
    }

    public Double getCanNang() {
        return canNang;
    }

    public void setCanNang(Double canNang) {
        this.canNang = canNang;
    }

    public String getNhomMau() {
        return nhomMau;
    }

    public void setNhomMau(String nhomMau) {
        this.nhomMau = nhomMau;
    }

    public Integer getBenhVienID() {
        return benhVienID;
    }

    public void setBenhVienID(Integer benhVienID) {
        this.benhVienID = benhVienID;
    }

    public String getBenhVien() {
        return benhVien;
    }

    public void setBenhVien(String benhVien) {
        this.benhVien = benhVien;
    }

    public String getMaBS() {
        return maBS;
    }

    public void setMaBS(String maBS) {
        this.maBS = maBS;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

}
