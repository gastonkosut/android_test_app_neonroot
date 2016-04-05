package com.hattrick.nrapp.network;

import com.hattrick.nrapp.model.CollectionPeople;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by gastonkosut on 4/5/16.
 */

public interface ApiClient {

    @GET("people")
    Call<CollectionPeople> getPeople();
}
