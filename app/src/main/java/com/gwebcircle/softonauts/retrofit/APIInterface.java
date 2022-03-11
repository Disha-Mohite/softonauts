package com.gwebcircle.softonauts.retrofit;

import com.gwebcircle.softonauts.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIInterface {

    @FormUrlEncoded
    @POST("restaurantPartner/order-filter")
    Call<SrvRes<User>> registerUser(@Field("first_name") String firstname,
                                        @Field("middle_name") String middlename,
                                        @Field("last_name") String lastname);
}
