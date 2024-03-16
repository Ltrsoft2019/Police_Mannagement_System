package com.ltrsoft.police_mannagement_system.Model;

public class Monthmodel {
    public String monthname,totalcases;

    public Monthmodel(String monthname, String totalcases) {
        this.monthname = monthname;
        this.totalcases = totalcases;
    }

    public String getMonthname() {
        return monthname;
    }

    public void setMonthname(String monthname) {
        this.monthname = monthname;
    }

    public String getTotalcases() {
        return totalcases;
    }

    public void setTotalcases(String totalcases) {
        this.totalcases = totalcases;
    }
}
