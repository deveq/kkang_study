package com.soldemom.part9_25.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("주소주소")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
