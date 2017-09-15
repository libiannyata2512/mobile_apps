package com.libian.lacakaku;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestInterface {
    @FormUrlEncoded
    @POST("/api/location")
    Call<ServerResponse> post(
            @Field("slsno") String salesman,
            @Field("dist") String distributor,
            @Field("battery") int battery,
            @Field("la") String lat,
            @Field("lg") String lng
    );
}
