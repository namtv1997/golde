package com.app.goldenhealth.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DanhMuc {
    @SerializedName("ID")
    @Expose
    private Integer ID;
    @SerializedName("TEN")
    @Expose
    private String TEN;
    @SerializedName("MA")
    @Expose
    private String MA;
    @SerializedName("MO_TA")
    @Expose
    private String MO_TA;
    @SerializedName("TEN_KHAC")
    @Expose
    private String TEN_KHAC;
    @SerializedName("GIOI_TINH_ID")
    @Expose
    private Integer GIOI_TINH_ID;
    @SerializedName("DS_BENH")
    @Expose
    private String DS_BENH;
    @SerializedName("MA_DT")
    @Expose
    private String MA_DT;
    @SerializedName("DT_MAX")
    @Expose
    private Integer DT_MAX;
    @SerializedName("DT_MIN")
    @Expose
    private Integer DT_MIN;
    @SerializedName("NGHE_NGHIEP_ID")
    @Expose
    private Integer NGHE_NGHIEP_ID;
    @SerializedName("TEN_TIENG_ANH")
    @Expose
    private String TEN_TIENG_ANH;
    @SerializedName("MA_CAP1")
    @Expose
    private String MA_CAP1;
    @SerializedName("MA_CAP2")
    @Expose
    private String MA_CAP2;
    @SerializedName("MA_CAP3")
    @Expose
    private String MA_CAP3;
    @SerializedName("MA_CAP4")
    @Expose
    private String MA_CAP4;
    @SerializedName("ID_CHA")
    @Expose
    private Integer ID_CHA;
    @SerializedName("THU_TU")
    @Expose
    private Integer THU_TU;
    @SerializedName("CAP")
    @Expose
    private String CAP;
    @SerializedName("TEN_QUOC_TICH")
    @Expose
    private String TEN_QUOC_TICH;
    @SerializedName("MA_TINH")
    @Expose
    private String MA_TINH;
    @SerializedName("MA_HUYEN")
    @Expose
    private String MA_HUYEN;
    @SerializedName("MA_XA")
    @Expose
    private String MA_XA;
    @SerializedName("MA_BCCS")
    @Expose
    private String MA_BCCS;
    @SerializedName("QUY_TAC_TIEM")
    @Expose
    private String QUY_TAC_TIEM;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTEN() {
        return TEN;
    }

    public void setTEN(String TEN) {
        this.TEN = TEN;
    }

    public String getMA() {
        return MA;
    }

    public void setMA(String MA) {
        this.MA = MA;
    }

    public String getMO_TA() {
        return MO_TA;
    }

    public void setMO_TA(String MO_TA) {
        this.MO_TA = MO_TA;
    }

    public String getTEN_KHAC() {
        return TEN_KHAC;
    }

    public void setTEN_KHAC(String TEN_KHAC) {
        this.TEN_KHAC = TEN_KHAC;
    }

    public Integer getGIOI_TINH_ID() {
        return GIOI_TINH_ID;
    }

    public void setGIOI_TINH_ID(Integer GIOI_TINH_ID) {
        this.GIOI_TINH_ID = GIOI_TINH_ID;
    }

    public String getDS_BENH() {
        return DS_BENH;
    }

    public void setDS_BENH(String DS_BENH) {
        this.DS_BENH = DS_BENH;
    }

    public String getMA_DT() {
        return MA_DT;
    }

    public void setMA_DT(String MA_DT) {
        this.MA_DT = MA_DT;
    }

    public Integer getDT_MAX() {
        return DT_MAX;
    }

    public void setDT_MAX(Integer DT_MAX) {
        this.DT_MAX = DT_MAX;
    }

    public Integer getDT_MIN() {
        return DT_MIN;
    }

    public void setDT_MIN(Integer DT_MIN) {
        this.DT_MIN = DT_MIN;
    }

    public Integer getNGHE_NGHIEP_ID() {
        return NGHE_NGHIEP_ID;
    }

    public void setNGHE_NGHIEP_ID(Integer NGHE_NGHIEP_ID) {
        this.NGHE_NGHIEP_ID = NGHE_NGHIEP_ID;
    }

    public String getTEN_TIENG_ANH() {
        return TEN_TIENG_ANH;
    }

    public void setTEN_TIENG_ANH(String TEN_TIENG_ANH) {
        this.TEN_TIENG_ANH = TEN_TIENG_ANH;
    }

    public String getMA_CAP1() {
        return MA_CAP1;
    }

    public void setMA_CAP1(String MA_CAP1) {
        this.MA_CAP1 = MA_CAP1;
    }

    public String getMA_CAP2() {
        return MA_CAP2;
    }

    public void setMA_CAP2(String MA_CAP2) {
        this.MA_CAP2 = MA_CAP2;
    }

    public String getMA_CAP3() {
        return MA_CAP3;
    }

    public void setMA_CAP3(String MA_CAP3) {
        this.MA_CAP3 = MA_CAP3;
    }

    public String getMA_CAP4() {
        return MA_CAP4;
    }

    public void setMA_CAP4(String MA_CAP4) {
        this.MA_CAP4 = MA_CAP4;
    }

    public Integer getID_CHA() {
        return ID_CHA;
    }

    public void setID_CHA(Integer ID_CHA) {
        this.ID_CHA = ID_CHA;
    }

    public Integer getTHU_TU() {
        return THU_TU;
    }

    public void setTHU_TU(Integer THU_TU) {
        this.THU_TU = THU_TU;
    }

    public String getCAP() {
        return CAP;
    }

    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    public String getTEN_QUOC_TICH() {
        return TEN_QUOC_TICH;
    }

    public void setTEN_QUOC_TICH(String TEN_QUOC_TICH) {
        this.TEN_QUOC_TICH = TEN_QUOC_TICH;
    }

    public String getMA_TINH() {
        return MA_TINH;
    }

    public void setMA_TINH(String MA_TINH) {
        this.MA_TINH = MA_TINH;
    }

    public String getMA_HUYEN() {
        return MA_HUYEN;
    }

    public void setMA_HUYEN(String MA_HUYEN) {
        this.MA_HUYEN = MA_HUYEN;
    }

    public String getMA_XA() {
        return MA_XA;
    }

    public void setMA_XA(String MA_XA) {
        this.MA_XA = MA_XA;
    }

    public String getMA_BCCS() {
        return MA_BCCS;
    }

    public void setMA_BCCS(String MA_BCCS) {
        this.MA_BCCS = MA_BCCS;
    }

    public String getQUY_TAC_TIEM() {
        return QUY_TAC_TIEM;
    }

    public void setQUY_TAC_TIEM(String QUY_TAC_TIEM) {
        this.QUY_TAC_TIEM = QUY_TAC_TIEM;
    }

    @Override
    public String toString() {
        return "DanhMuc{" +
                "ID=" + ID +
                ", TEN='" + TEN + '\'' +
                ", MA='" + MA + '\'' +
                ", MO_TA='" + MO_TA + '\'' +
                ", TEN_KHAC='" + TEN_KHAC + '\'' +
                ", GIOI_TINH_ID=" + GIOI_TINH_ID +
                ", DS_BENH='" + DS_BENH + '\'' +
                ", MA_DT='" + MA_DT + '\'' +
                ", DT_MAX=" + DT_MAX +
                ", DT_MIN=" + DT_MIN +
                ", NGHE_NGHIEP_ID=" + NGHE_NGHIEP_ID +
                ", TEN_TIENG_ANH='" + TEN_TIENG_ANH + '\'' +
                ", MA_CAP1='" + MA_CAP1 + '\'' +
                ", MA_CAP2='" + MA_CAP2 + '\'' +
                ", MA_CAP3='" + MA_CAP3 + '\'' +
                ", MA_CAP4='" + MA_CAP4 + '\'' +
                ", ID_CHA=" + ID_CHA +
                ", THU_TU=" + THU_TU +
                ", CAP='" + CAP + '\'' +
                ", TEN_QUOC_TICH='" + TEN_QUOC_TICH + '\'' +
                ", MA_TINH='" + MA_TINH + '\'' +
                ", MA_HUYEN='" + MA_HUYEN + '\'' +
                ", MA_XA='" + MA_XA + '\'' +
                ", MA_BCCS='" + MA_BCCS + '\'' +
                ", QUY_TAC_TIEM='" + QUY_TAC_TIEM + '\'' +
                '}';
    }
}