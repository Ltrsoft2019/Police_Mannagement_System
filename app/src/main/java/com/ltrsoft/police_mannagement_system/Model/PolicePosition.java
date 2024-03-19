package com.ltrsoft.police_mannagement_system.Model;

public class PolicePosition {
    private String KGID,IOName,Internal_IO,districts,Unit_ID ,UnitName;


//    public PolicePosition(String KGID, String IOName, String internal_IO, String districts) {
//        this.KGID = KGID;
//        this.IOName = IOName;
//        this.Internal_IO = internal_IO;
//        this.districts = districts;
//    }

    public PolicePosition(String KGID, String IOName, String internal_IO, String districts, String unit_ID, String unitName) {
        this.KGID = KGID;
        this.IOName = IOName;
        Internal_IO = internal_IO;
        this.districts = districts;
        Unit_ID = unit_ID;
        UnitName = unitName;
    }

    public String getUnit_ID() {
        return Unit_ID;
    }

    public void setUnit_ID(String unit_ID) {
        Unit_ID = unit_ID;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public String getKGID() {
        return KGID;
    }

    public void setKGID(String KGID) {
        this.KGID = KGID;
    }

    public String getIOName() {
        return IOName;
    }

    public void setIOName(String IOName) {
        this.IOName = IOName;
    }

    public String getInternal_IO() {
        return Internal_IO;
    }

    public void setInternal_IO(String internal_IO) {
        Internal_IO = internal_IO;
    }

    public String getDistricts() {
        return districts;
    }

    public void setDistricts(String districts) {
        this.districts = districts;
    }
}
