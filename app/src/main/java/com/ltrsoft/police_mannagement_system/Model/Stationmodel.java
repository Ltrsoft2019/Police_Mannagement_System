package com.ltrsoft.police_mannagement_system.Model;

public class Stationmodel {
    private String UnitName,Unit_ID;

    public Stationmodel(String unitName, String unit_ID) {
        UnitName = unitName;
        Unit_ID = unit_ID;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public String getUnit_ID() {
        return Unit_ID;
    }

    public void setUnit_ID(String unit_ID) {
        Unit_ID = unit_ID;
    }
}
