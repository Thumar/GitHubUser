package com.app.androidkt.githubuser.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by brijesh on 24/5/17.
 */

public class User {

    @SerializedName("id")
    private int userId;

    @SerializedName("url")
    private String profileUrl;

    @SerializedName("avatar_url")
    private String profileImage;

    @SerializedName("name")
    private String name;

    @SerializedName("blog")
    private String blogUrl;

    @SerializedName("email")
    private String email;
    @SerializedName("created_at")
    private Date since;

    @SerializedName("location")
    private String address;

    @SerializedName("login")
    private String loginName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
