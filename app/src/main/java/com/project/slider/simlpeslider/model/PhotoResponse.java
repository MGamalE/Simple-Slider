package com.project.slider.simlpeslider.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PhotoResponse {

    public String getPer_page() {
        return per_page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getNext_page() {
        return next_page;
    }

    public void setNext_page(String next_page) {
        this.next_page = next_page;
    }

    @SerializedName("per_page")
    private String per_page;

    @SerializedName("page")
    private String page;

    @SerializedName("next_page")
    private String next_page;

    @SerializedName("photos")
    ArrayList<Photos> photos;

    public ArrayList<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<Photos> photos) {
        this.photos = photos;
    }
}
