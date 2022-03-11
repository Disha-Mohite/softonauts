package com.gwebcircle.softonauts.retrofit;

import com.gwebcircle.softonauts.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIInterface {

    String AUTHORIZE_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MX0.By2r2BwheJsbrEGrHOaMQwrrmlY7wHVFzWtuEmv39fM";

    @FormUrlEncoded
    @POST("Android/register-user")
    Call<Void> registerUser(@Header("Authorization") String authorizekey,
                                    @Field("first_name") String firstname,
                                    @Field("middle_name") String middlename,
                                    @Field("last_name") String lastname,
                                    @Field("dob") String dob,
                                    @Field("gender") String gender,
                                    @Field("contact_number") String contact,
                                    @Field("email") String email,
                                    @Field("address_one") String addresstwo,
                                    @Field("adderss_two") String addressone,
                                    @Field("city") String city,
                                    @Field("state") String state,
                                    @Field("zipcode") int zipcode,
                                    @Field("password") String password,
                                    @Field("login_type") String logintype,
                                    @Field("ssn_digits") int ssndigit);

    @FormUrlEncoded
    @POST("Android/user-login")
    Call<SrvRes<User>> loginUser(@Header("Authorization") String authorizekey,
                                    @Field("username") String firstname,
                                    @Field("password") String middlename,
                                    @Field("fcm_id") String lastname);
}
