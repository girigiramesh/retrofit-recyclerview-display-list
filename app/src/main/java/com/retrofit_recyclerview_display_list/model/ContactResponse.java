package com.retrofit_recyclerview_display_list.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramesh on 10/26/16.
 */

public class ContactResponse {
    @SerializedName("contacts")
    @Expose
    private List<Contact> contacts = new ArrayList<Contact>();

    /**
     *
     * @return
     * The contacts
     */
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     *
     * @param contacts
     * The contacts
     */
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
