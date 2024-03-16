package com.ltrsoft.police_mannagement_system.Model;

public class CrimeHeadName {
    private String crime_head_id,crime_head_name,crime_grup_id;

    public String getCrime_head_id() {
        return crime_head_id;
    }

    public void setCrime_head_id(String crime_head_id) {
        this.crime_head_id = crime_head_id;
    }

    public String getCrime_head_name() {
        return crime_head_name;
    }

    public void setCrime_head_name(String crime_head_name) {
        this.crime_head_name = crime_head_name;
    }

    public String getCrime_grup_id() {
        return crime_grup_id;
    }

    public void setCrime_grup_id(String crime_grup_id) {
        this.crime_grup_id = crime_grup_id;
    }

    public CrimeHeadName(String crime_head_id, String crime_head_name, String crime_grup_id) {
        this.crime_head_id = crime_head_id;
        this.crime_head_name = crime_head_name;
        this.crime_grup_id = crime_grup_id;
    }
}
