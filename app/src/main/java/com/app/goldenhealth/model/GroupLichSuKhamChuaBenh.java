package com.app.goldenhealth.model;

import java.util.ArrayList;

public class GroupLichSuKhamChuaBenh {
    private String year;
    private ArrayList<LichSuKhamChuaBenh> listLSKCB;

    public GroupLichSuKhamChuaBenh(String year, ArrayList<LichSuKhamChuaBenh> listLSKCB) {
        this.year = year;
        this.listLSKCB = listLSKCB;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<LichSuKhamChuaBenh> getListLSKCB() {
        return listLSKCB;
    }

    public void setListLSKCB(ArrayList<LichSuKhamChuaBenh> listLSKCB) {
        this.listLSKCB = listLSKCB;
    }
}
