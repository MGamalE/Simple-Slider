package com.project.slider.simlpeslider.model;

import com.google.gson.annotations.SerializedName;

public class PhotoSrc {

    @SerializedName("tiny")
    private String tiny;

    @SerializedName("original")
    private String original;

    @SerializedName("square")
    private String square;

    @SerializedName("landscape")
    private String landscape;

    @SerializedName("small")
    private String small;

    @SerializedName("portrait")

    private String portrait;

    @SerializedName("medium")

    private String medium;

    public String getTiny() {
        return tiny;
    }

    public void setTiny(String tiny) {
        this.tiny = tiny;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public String getLandscape() {
        return landscape;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge2x() {
        return large2x;
    }

    public void setLarge2x(String large2x) {
        this.large2x = large2x;
    }

    @SerializedName("large2x")

    private String large2x;


    @SerializedName("large")
    private String photoUrl;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
