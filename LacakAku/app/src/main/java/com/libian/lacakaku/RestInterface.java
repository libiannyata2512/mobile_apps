package com.libian.lacakaku;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestInterface {
    @FormUrlEncoded
    @POST("/api/location")
    Call<ServerResponse> post(
            @Field("salesman") String salesman,
            @Field("distributor") String distributor,
            @Field("battery") int battery,
            @Field("lat") String lat,
            @Field("lng") String lng
    );
}
