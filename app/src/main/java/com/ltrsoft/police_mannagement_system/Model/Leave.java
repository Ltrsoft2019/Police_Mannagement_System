package com.ltrsoft.police_mannagement_system.Model;

import com.google.gson.annotations.SerializedName;

public class Leave {
    @SerializedName("leave_id")
    private String leaveId;

    @SerializedName("date")
    private String date;

    @SerializedName("type_of_leave")
    private String typeOfLeave;

    @SerializedName("duration")
    private String duration;

    @SerializedName("reason")
    private String reason;

    @SerializedName("remark")
    private String remark;

    @SerializedName("attachment_photo")
    private String attachmentPhoto;

    @SerializedName("police_id")
    private String policeId;

    @SerializedName("station_id")
    private String stationId;

    public Leave(String leaveId, String date, String typeOfLeave, String duration, String reason, String remark, String attachmentPhoto, String policeId, String stationId) {
        this.leaveId = leaveId;
        this.date = date;
        this.typeOfLeave = typeOfLeave;
        this.duration = duration;
        this.reason = reason;
        this.remark = remark;
        this.attachmentPhoto = attachmentPhoto;
        this.policeId = policeId;
        this.stationId = stationId;
    }

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTypeOfLeave() {
        return typeOfLeave;
    }

    public void setTypeOfLeave(String typeOfLeave) {
        this.typeOfLeave = typeOfLeave;
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

    public String getAttachmentPhoto() {
        return attachmentPhoto;
    }

    public void setAttachmentPhoto(String attachmentPhoto) {
        this.attachmentPhoto = attachmentPhoto;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }
}
