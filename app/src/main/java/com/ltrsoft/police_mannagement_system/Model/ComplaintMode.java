package com.ltrsoft.police_mannagement_system.Model;

public class ComplaintMode {
    private String cmplaint_mode_id ,cmplaint_mode_name;

    public ComplaintMode(String cmplaint_mode_id, String cmplaint_mode_name) {
        this.cmplaint_mode_id = cmplaint_mode_id;
        this.cmplaint_mode_name = cmplaint_mode_name;
    }

    public String getCmplaint_mode_id() {
        return cmplaint_mode_id;
    }

    public void setCmplaint_mode_id(String cmplaint_mode_id) {
        this.cmplaint_mode_id = cmplaint_mode_id;
    }

    public String getCmplaint_mode_name() {
        return cmplaint_mode_name;
    }

    public void setCmplaint_mode_name(String cmplaint_mode_name) {
        this.cmplaint_mode_name = cmplaint_mode_name;
    }
}
