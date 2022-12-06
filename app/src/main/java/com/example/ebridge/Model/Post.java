package com.example.ebridge.Model;


import android.media.Image;


public class Post {
    private String title;
    private String details;
    private Image img;

    public Post(String title, String details, Image img) {
        this.title = title;
        this.details = details;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }


}
