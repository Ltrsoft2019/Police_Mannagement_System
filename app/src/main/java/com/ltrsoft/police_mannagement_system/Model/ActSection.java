package com.ltrsoft.police_mannagement_system.Model;

public class ActSection {
    private String actsection_id,actsection_name;

    public ActSection(String actsection_id, String actsection_name) {
        this.actsection_id = actsection_id;
        this.actsection_name = actsection_name;
    }

    public String getActsection_id() {
        return actsection_id;
    }

    public void setActsection_id(String actsection_id) {
        this.actsection_id = actsection_id;
    }

    public String getActsection_name() {
        return actsection_name;
    }

    public void setActsection_name(String actsection_name) {
        this.actsection_name = actsection_name;
    }
}
