package com.ltrsoft.police_mannagement_system.Model;

public class YearModel {
    public String name,totalcases;

    public YearModel(String name, String totalcases) {
        this.name = name;
        this.totalcases = totalcases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotalcases() {
        return totalcases;
    }

    public void setTotalcases(String totalcases) {
        this.totalcases = totalcases;
    }
}
