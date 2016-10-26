package com.retrofit_recyclerview_display_list.network;


import com.retrofit_recyclerview_display_list.model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ramesh on 10/25/16.
 */

public class RetrofitHandler  {
    private static RetrofitHandler ourInstance = new RetrofitHandler();

    public static RetrofitHandler getInstance() {
        return ourInstance;
    }

    private Retrofit ipApiService = new Retrofit.Builder()
            .baseUrl("http://api.androidhive.info")
            .addConverterFactory(StringConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private HumOsStaging service = ipApiService.create(HumOsStaging.class);

    private RetrofitHandler() {
    }
    public Call<Contact> getContactList() {
        return service.getContactList();
    }
}
//http://api.androidhive.info/contacts/