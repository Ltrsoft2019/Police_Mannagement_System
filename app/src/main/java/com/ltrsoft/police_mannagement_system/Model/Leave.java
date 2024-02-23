package com.ltrsoft.police_mannagement_system.Model;

public class Leave {
    private String leave_id	,date	,type_of_leave	,duration	,reason	,remark	,attachment_photo	,police_id
            ,station_id;

    public String getLeave_id() {
        return leave_id;
    }

    public void setLeave_id(String leave_id) {
        this.leave_id = leave_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType_of_leave() {
        return type_of_leave;
    }

    public void setType_of_leave(String type_of_leave) {
        this.type_of_leave = type_of_leave;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAttachment_photo() {
        return attachment_photo;
    }

    public void setAttachment_photo(String attachment_photo) {
        this.attachment_photo = attachment_photo;
    }

    public String getPolice_id() {
        return police_id;
    }

    public void setPolice_id(String police_id) {
        this.police_id = police_id;
    }

    public String getStation_id() {
        return station_id;
    }

    public void setStation_id(String station_id) {
        this.station_id = station_id;
    }
}
