package com.ltrsoft.police_mannagement_system.Model;


public class District {
    String id, name, totalcase, totalpolice;


    public District(String id, String name, String totalcase, String totalpolice) {
        this.id = id;
        this.name = name;
        this.totalcase = totalcase;
        this.totalpolice = totalpolice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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