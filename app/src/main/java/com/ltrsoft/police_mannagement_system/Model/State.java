package com.ltrsoft.police_mannagement_system.Model;

public class State {
    public static final String GETSTATE = "https://rj.ltr-soft.com/public/police_api/country/select_country.php";
    private String state_id,state_name,country_id;

    public State(String state_id, String state_name, String country_id) {
        this.state_id = state_id;
        this.state_name = state_name;
        this.country_id = country_id;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }
}
