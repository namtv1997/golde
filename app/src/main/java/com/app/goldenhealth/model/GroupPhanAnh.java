package com.app.goldenhealth.model;

import java.util.ArrayList;

public class GroupPhanAnh {
    private String date;
    private ArrayList<PhanAnh> listPhanAnh;

    public GroupPhanAnh(String date, ArrayList<PhanAnh> listPhanAnh) {
        this.date = date;
        this.listPhanAnh = listPhanAnh;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<PhanAnh> getListPhanAnh() {
        return listPhanAnh;
    }

    public void setListPhanAnh(ArrayList<PhanAnh> listPhanAnh) {
        this.listPhanAnh = listPhanAnh;
    }
}
