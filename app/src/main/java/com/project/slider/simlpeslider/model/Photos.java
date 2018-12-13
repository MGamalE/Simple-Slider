package com.project.slider.simlpeslider.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Photos {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPhotographer_url() {
        return photographer_url;
    }

    public void setPhotographer_url(String photographer_url) {
        this.photographer_url = photographer_url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("id")
    private String id;

    @SerializedName("height")
    private String height;

    @SerializedName("photographer_url")
    private String photographer_url;

    @SerializedName("width")
    private String width;

    @SerializedName("photographer")
    private String photographer;


    @SerializedName("url")
    private String url;

    @SerializedName("src")
    PhotoSrc photoSrc;

    public PhotoSrc getPhotoSrc() {
        return photoSrc;
    }

    public void setPhotoSrc(PhotoSrc photoSrc) {
        this.photoSrc = photoSrc;
    }
}
