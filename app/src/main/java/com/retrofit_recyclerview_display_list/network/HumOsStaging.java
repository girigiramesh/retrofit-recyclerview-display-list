package com.retrofit_recyclerview_display_list.network;


import com.retrofit_recyclerview_display_list.model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ramesh on 10/25/16.
 */

public interface HumOsStaging {

    @GET("/contacts/")
    Call<Contact> getContactList();
}
