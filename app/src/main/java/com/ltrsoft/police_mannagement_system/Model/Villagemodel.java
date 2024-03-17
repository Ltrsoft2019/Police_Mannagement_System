package com.ltrsoft.police_mannagement_system.Model;

public class Villagemodel {
   private String villagename,bitname,totalcases;

    public Villagemodel(String villagename, String bitname, String totalcases) {
        this.villagename = villagename;
        this.bitname = bitname;
        this.totalcases = totalcases;
    }

    public String getVillagename() {
        return villagename;
    }

    public void setVillagename(String villagename) {
        this.villagename = villagename;
    }

    public String getBitname() {
        return bitname;
    }

    public void setBitname(String bitname) {
        this.bitname = bitname;
    }

    public String getTotalcases() {
        return totalcases;
    }

    public void setTotalcases(String totalcases) {
        this.totalcases = totalcases;
    }
}
