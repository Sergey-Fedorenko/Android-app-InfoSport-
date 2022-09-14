package com.example.infosport;

public class Gym {

    private int imageProfile;
    private String username, userDes;
    private String desc;
    private boolean isShrink = true;

    public Gym(int imageProfile, String username, String userDes,String desc) {
        this.imageProfile = imageProfile;
        this.username = username;
        this.userDes = userDes;
        this.desc = desc;
    }

    public boolean isShrink() {
        return isShrink;
    }

    public void setShrink(boolean shrink) {
        isShrink = shrink;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(int imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserDes() {
        return userDes;
    }

    public void setUserDes(String userDes) {
        this.userDes = userDes;
    }
}
