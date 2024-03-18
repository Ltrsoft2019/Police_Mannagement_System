package com.ltrsoft.police_mannagement_system.Model;

public class PolicePosition {
    private String KGID,IOName,Internal_IO;

    public PolicePosition(String kgid, String IOName, String internal_IO) {
       this.KGID=kgid;
        this.IOName = IOName;
        this.Internal_IO = internal_IO;
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
}
