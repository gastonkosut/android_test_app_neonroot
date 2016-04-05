package com.hattrick.nrapp.network;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gastonkosut on 4/5/16.
 */
public class ServiceGenerator {

    private static Retrofit mRetrofit;

    public static final String API_BASE_URL = "http://swapi.co/api/";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        mRetrofit = builder.client(httpClient.build()).build();
        return mRetrofit.create(serviceClass);
    }

    public static Retrofit retrofit() {
        return mRetrofit;
    }
}