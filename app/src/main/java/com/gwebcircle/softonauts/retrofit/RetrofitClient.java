package com.gwebcircle.softonauts.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitClient {
    public static final String BASE_URL = "https://softonauts.com/clients/";

    private static Retrofit retrofit = null;
    private static Retrofit retrofitNew = null;

    private RetrofitClient() {

    }
    private static Retrofit getAPIClient(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .client(client)
                    .build();
        }

        return retrofit;
    }



    public static APIInterface getInterface() {
        return getAPIClient().create(APIInterface.class);
    }
}
