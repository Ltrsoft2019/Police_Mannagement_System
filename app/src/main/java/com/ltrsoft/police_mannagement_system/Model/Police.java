package com.ltrsoft.police_mannagement_system.Model;

public class Police {
    private String position_id,io_number,kgrd,police_name,police_id;

    public Police(String position_id, String io_number, String kgrd, String police_name, String police_id) {
        this.position_id = position_id;
        this.io_number = io_number;
        this.kgrd = kgrd;
        this.police_name = police_name;
        this.police_id = police_id;
    }

    public String getPosition_id() {
        return position_id;
    }

    public void setPosition_id(String position_id) {
        this.position_id = position_id;
    }

    public String getIo_number() {
        return io_number;
    }

    public void setIo_number(String io_number) {
        this.io_number = io_number;
    }

    public String getKgrd() {
        return kgrd;
    }

    public void setKgrd(String kgrd) {
        this.kgrd = kgrd;
    }

    public String getPolice_name() {
        return police_name;
    }

    public void setPolice_name(String police_name) {
        this.police_name = police_name;
    }

    public String getPolice_id() {
        return police_id;
    }

    public void setPolice_id(String police_id) {
        this.police_id = police_id;
    }
}
