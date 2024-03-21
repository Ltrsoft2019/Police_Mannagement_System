package com.ltrsoft.police_mannagement_system.Model;

public class Bargraphscrollable {
    Float xaxis;
    String  yxis,colorcode;

    public Bargraphscrollable(Float xaxis, String yxis, String colorcode) {
        this.xaxis = xaxis;
        this.yxis = yxis;
        this.colorcode = colorcode;
    }

    public Float getXaxis() {
        return xaxis;
    }

    public void setXaxis(Float xaxis) {
        this.xaxis = xaxis;
    }

    public String getYxis() {
        return yxis;
    }

    public void setYxis(String yxis) {
        this.yxis = yxis;
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode;
    }
}
