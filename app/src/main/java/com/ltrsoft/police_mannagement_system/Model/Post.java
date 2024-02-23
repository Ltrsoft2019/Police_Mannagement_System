package com.ltrsoft.police_mannagement_system.Model;

public class Post {
    private String 	post_id	,all_user_id	,photo_video	,subject	,description	,post_likes;

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

    public String getPhoto_video() {
        return photo_video;
    }

    public void setPhoto_video(String photo_video) {
        this.photo_video = photo_video;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPost_likes() {
        return post_likes;
    }

    public void setPost_likes(String post_likes) {
        this.post_likes = post_likes;
    }
}
