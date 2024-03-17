package com.ltrsoft.police_mannagement_system.Model;

public class Stationmodel {
    private String stationname,stationcode,totalcases,totalpolice;

    public Stationmodel(String stationname, String stationcode, String totalcases, String totalpolice) {
        this.stationname = stationname;
        this.stationcode = stationcode;
        this.totalcases = totalcases;
        this.totalpolice = totalpolice;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
    }

    public String getStationcode() {
        return stationcode;
    }

    public void setStationcode(String stationcode) {
        this.stationcode = stationcode;
    }

    public String getTotalcases() {
        return totalcases;
    }

    public void setTotalcases(String totalcases) {
        this.totalcases = totalcases;
    }

    public String getTotalpolice() {
        return totalpolice;
    }

    public void setTotalpolice(String totalpolice) {
        this.totalpolice = totalpolice;
    }
}
