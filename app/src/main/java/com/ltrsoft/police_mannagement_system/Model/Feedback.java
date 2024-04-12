package com.ltrsoft.police_mannagement_system.Model;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Feedback implements Serializable {
    @SerializedName("overall_satisfaction")
    private String overall_satisfaction;

    @SerializedName("usability_navigation")
    private String usability_navigation;

    @SerializedName("training_support")
    private String training_support;

    @SerializedName("alert_notification")
    private String alert_notification;

    @SerializedName("security_privacy")
    private String security_privacy;

    @SerializedName("relevance_info")
    private String relevance_info;

    @SerializedName("average_prating")
    private String average_prating;

    @SerializedName("police_id")
    private String police_id;

    public Feedback(String overall_satisfaction, String usability_navigation, String training_support, String alert_notification, String security_privacy, String relevance_info, String average_prating, String police_id) {
        this.overall_satisfaction = overall_satisfaction;
        this.usability_navigation = usability_navigation;
        this.training_support = training_support;
        this.alert_notification = alert_notification;
        this.security_privacy = security_privacy;
        this.relevance_info = relevance_info;
        this.average_prating = average_prating;
        this.police_id = police_id;
    }

    public String getOverall_satisfaction() {
        return overall_satisfaction;
    }

    public void setOverall_satisfaction(String overall_satisfaction) {
        this.overall_satisfaction = overall_satisfaction;
    }

    public String getUsability_navigation() {
        return usability_navigation;
    }

    public void setUsability_navigation(String usability_navigation) {
        this.usability_navigation = usability_navigation;
    }

    public String getTraining_support() {
        return training_support;
    }

    public void setTraining_support(String training_support) {
        this.training_support = training_support;
    }

    public String getAlert_notification() {
        return alert_notification;
    }

    public void setAlert_notification(String alert_notification) {
        this.alert_notification = alert_notification;
    }

    public String getSecurity_privacy() {
        return security_privacy;
    }

    public void setSecurity_privacy(String security_privacy) {
        this.security_privacy = security_privacy;
    }

    public String getRelevance_info() {
        return relevance_info;
    }

    public void setRelevance_info(String relevance_info) {
        this.relevance_info = relevance_info;
    }

    public String getAverage_prating() {
        return average_prating;
    }

    public void setAverage_prating(String average_prating) {
        this.average_prating = average_prating;
    }

    public String getPolice_id() {
        return police_id;
    }

    public void setPolice_id(String police_id) {
        this.police_id = police_id;
    }
}

