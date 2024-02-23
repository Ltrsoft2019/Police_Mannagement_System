package com.ltrsoft.police_mannagement_system.Model;

public class Assigned_warrant {
    private String id,	warrant_id,	police_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWarrant_id() {
        return warrant_id;
    }

    public void setWarrant_id(String warrant_id) {
        this.warrant_id = warrant_id;
    }

    public String getPolice_id() {
        return police_id;
    }

    public void setPolice_id(String police_id) {
        this.police_id = police_id;
    }
}
