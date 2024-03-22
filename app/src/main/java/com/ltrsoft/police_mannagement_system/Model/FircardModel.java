package com.ltrsoft.police_mannagement_system.Model;

public class FircardModel {
    String FIR_ID ,
            FIRNo,
            UnitName,
            Unit_ID,
            FIR_Type,
            ActSection,
            IOName,
            KGID;

    public FircardModel(String FIR_ID, String FIRNo, String unitName, String unit_ID, String FIR_Type, String actSection, String IOName, String KGID) {
        this.FIR_ID = FIR_ID;
        this.FIRNo = FIRNo;
        this.UnitName = unitName;
        this.Unit_ID = unit_ID;
        this.FIR_Type = FIR_Type;
        this.ActSection = actSection;
        this.IOName = IOName;
        this.KGID = KGID;
    }

    public String getFIR_ID() {
        return FIR_ID;
    }

    public void setFIR_ID(String FIR_ID) {
        this.FIR_ID = FIR_ID;
    }

    public String getFIRNo() {
        return FIRNo;
    }

    public void setFIRNo(String FIRNo) {
        this.FIRNo = FIRNo;
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

    public String getFIR_Type() {
        return FIR_Type;
    }

    public void setFIR_Type(String FIR_Type) {
        this.FIR_Type = FIR_Type;
    }

    public String getActSection() {
        return ActSection;
    }

    public void setActSection(String actSection) {
        ActSection = actSection;
    }

    public String getIOName() {
        return IOName;
    }

    public void setIOName(String IOName) {
        this.IOName = IOName;
    }

    public String getKGID() {
        return KGID;
    }

    public void setKGID(String KGID) {
        this.KGID = KGID;
    }
}
