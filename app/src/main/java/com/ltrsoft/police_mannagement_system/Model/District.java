package com.ltrsoft.police_mannagement_system.Model;


public class District {
    String district_id, district_name, totalcase, totalpolice;
    public District(String id, String name, String totalcase, String totalpolice) {
        this.district_id = id;
        this.district_name = name;
        this.totalcase = totalcase;
        this.totalpolice = totalpolice;
    }


    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getTotalcase() {
        return totalcase;
    }

    public void setTotalcase(String totalcase) {
        this.totalcase = totalcase;
    }

    public String getTotalpolice() {
        return totalpolice;
    }

    public void setTotalpolice(String totalpolice) {
        this.totalpolice = totalpolice;
    }

}