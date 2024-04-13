package com.ltrsoft.police_mannagement_system.Model;

public class ComplaintSubType {

    private String 	id,	subtype_name	,complaint_type_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubtype_name() {
        return subtype_name;
    }

    public void setSubtype_name(String subtype_name) {
        this.subtype_name = subtype_name;
    }

    public String getComplaint_type_id() {
        return complaint_type_id;
    }

    public void setComplaint_type_id(String complaint_type_id) {
        this.complaint_type_id = complaint_type_id;
    }
}
