package com.example.imageapi;

public class ImageModel {
    int id;
    String title;
    String imageurl;
    String thumbnailurl;

    public ImageModel(int id, String title, String imageurl, String thumbnailurl) {
        this.id = id;
        this.title = title;
        this.imageurl = imageurl;
        this.thumbnailurl = thumbnailurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getThumbnailurl() {
        return thumbnailurl;
    }

    public void setThumbnailurl(String thumbnailurl) {
        this.thumbnailurl = thumbnailurl;
    }
}





