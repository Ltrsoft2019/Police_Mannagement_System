package com.ltrsoft.police_mannagement_system.Model;

public class PoliceTask {
    private String assign_task_id;
    private String task_id;
    private String police_id;
    private String created_at;
    private String updated_at;

    public PoliceTask(String assign_task_id, String task_id, String police_id, String created_at, String updated_at) {
        this.assign_task_id = assign_task_id;
        this.task_id = task_id;
        this.police_id = police_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getAssign_task_id() {
        return assign_task_id;
    }

    public void setAssign_task_id(String assign_task_id) {
        this.assign_task_id = assign_task_id;
    }

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public String getPolice_id() {
        return police_id;
    }

    public void setPolice_id(String police_id) {
        this.police_id = police_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
