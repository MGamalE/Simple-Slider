package com.project.slider.simlpeslider.network;

import com.project.slider.simlpeslider.BuildConfig;
import com.project.slider.simlpeslider.model.PhotoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface PhotoEndPoint {

    @Headers(BuildConfig.THE_PHOTO_DB_API_TOKEN)
    @GET("curated")
    Call<PhotoResponse> getPhotos(@Query("per_page") int perPage, @Query("page") int page);


}
