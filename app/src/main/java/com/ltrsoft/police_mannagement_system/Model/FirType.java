package com.ltrsoft.police_mannagement_system.Model;

public class FirType {
    private String fir_type_id,fir_type_name;

    public FirType(String fir_type_id, String fir_type_name) {
        this.fir_type_id = fir_type_id;
        this.fir_type_name = fir_type_name;
    }

    public String getFir_type_id() {
        return fir_type_id;
    }

    public void setFir_type_id(String fir_type_id) {
        this.fir_type_id = fir_type_id;
    }

    public String getFir_type_name() {
        return fir_type_name;
    }

    public void setFir_type_name(String fir_type_name) {
        this.fir_type_name = fir_type_name;
    }
}
