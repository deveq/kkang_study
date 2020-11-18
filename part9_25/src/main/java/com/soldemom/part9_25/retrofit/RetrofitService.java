package com.soldemom.part9_25.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("/v2/everything")
    Call<PageListModel> getList(@Query("q") String q,
                                @Query("api") String apiKey,
                                @Query("page") long page,
                                @Query("pageSize") int pageSize);
}
