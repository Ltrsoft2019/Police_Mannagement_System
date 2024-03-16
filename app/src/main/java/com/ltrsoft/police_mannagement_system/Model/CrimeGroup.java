package com.ltrsoft.police_mannagement_system.Model;

public class CrimeGroup {
    private String crime_grup_name,crime_grup_id;

    public CrimeGroup(String crime_grup_name, String crime_grup_id) {
        this.crime_grup_name = crime_grup_name;
        this.crime_grup_id = crime_grup_id;
    }

    public String getCrime_grup_name() {
        return crime_grup_name;
    }

    public void setCrime_grup_name(String crime_grup_name) {
        this.crime_grup_name = crime_grup_name;
    }

    public String getCrime_grup_id() {
        return crime_grup_id;
    }

    public void setCrime_grup_id(String crime_grup_id) {
        this.crime_grup_id = crime_grup_id;
    }
}
