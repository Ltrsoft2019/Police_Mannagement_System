package com.ltrsoft.police_mannagement_system.Model;

public class FirModel {
    String fir_id,fir_name,type,address;

    public FirModel(String fir_id, String fir_name, String type, String address) {
        this.fir_id = fir_id;
        this.fir_name = fir_name;
        this.type = type;
        this.address = address;
    }

    public String getFir_id() {
        return fir_id;
    }

    public void setFir_id(String fir_id) {
        this.fir_id = fir_id;
    }

    public String getFir_name() {
        return fir_name;
    }

    public void setFir_name(String fir_name) {
        this.fir_name = fir_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
