package com.ltrsoft.police_mannagement_system.Model;

public class District {
    public static final String GETSISTRICT ="";

    private String district_id,district_name,state_id;

    public District(String district_id, String district_name, String state_id) {
        this.district_id = district_id;
        this.district_name = district_name;
        this.state_id = state_id;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }
}
