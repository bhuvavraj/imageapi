package com.example.imageapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ImageApi {
    @GET("photos")
    Call<List<ImageModel>>getimagedata();



}
