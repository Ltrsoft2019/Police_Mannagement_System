package com.ltrsoft.police_mannagement_system.Model;

public class Social_comment {
    private String comment_id	,post_id	,all_user_id	,comment_description;

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getAll_user_id() {
        return all_user_id;
    }

    public void setAll_user_id(String all_user_id) {
        this.all_user_id = all_user_id;
    }

    public String getComment_description() {
        return comment_description;
    }

    public void setComment_description(String comment_description) {
        this.comment_description = comment_description;
    }
}
