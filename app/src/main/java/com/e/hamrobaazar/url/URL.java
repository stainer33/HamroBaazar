package com.e.hamrobaazar.url;

import com.e.hamrobaazar.API.ItemAPI;
import com.e.hamrobaazar.API.UserAPI;
import com.e.hamrobaazar.models.Item;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class URL {
    public static  final String base_url="http://10.0.2.2:3003/";


    public static final Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public static final UserAPI userAPI =retrofit.create(UserAPI.class);
    public static final ItemAPI itemAPI =retrofit.create(ItemAPI.class);
}
