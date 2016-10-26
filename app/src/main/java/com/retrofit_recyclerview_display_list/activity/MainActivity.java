package com.retrofit_recyclerview_display_list.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.retrofit_recyclerview_display_list.R;
import com.retrofit_recyclerview_display_list.adapter.ResponseAdapter;
import com.retrofit_recyclerview_display_list.model.Contact;
import com.retrofit_recyclerview_display_list.network.RetrofitHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    private RecyclerView rv_response;
    private ResponseAdapter adapter;
//    private ResponseList responseAdapter;
//    private ArrayList<Response> contactList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_response = (RecyclerView) findViewById(R.id.rv_response);

        showProgressDialog("please wait...!");
        RetrofitHandler.getInstance().getContactList().enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                dismissProgressDialog();
                if (response.isSuccessful()) {

                    JSONObject jsonRootObject = new JSONObject();
                    JSONArray jsonArray = jsonRootObject.optJSONArray("contacts");

                    List<Contact> responseList = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject finalObject = jsonArray.getJSONObject(i);
                           Contact contacts =new Contact();
                            contacts.setId(finalObject.getString("id"));
                            contacts.setName(finalObject.getString("name"));
                            contacts.setEmail(finalObject.getString("email"));
                            contacts.setAddress(finalObject.getString("address"));
                            contacts.setGender(finalObject.getString("gender"));
                            responseList.add(contacts);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
//                    Gson gson = new Gson();
//                    for (int i = 0; i <jsonArray.length() ; i++) {
//                        try {
//                            JSONObject jsonObject = jsonArray.getJSONObject(i);
//                            Contact contactModel = gson.fromJson(jsonObject.toString(), Contact.class);
//                            responseList.add(contactModel);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                    buildList(responseList);

                } else {
                    Log.e(TAG, "onResponse: " + response.raw());
                }
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                dismissProgressDialog();
                Log.e(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

    }

    private void buildList(List<Contact> lists) {
        if (rv_response.getAdapter() == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rv_response.setLayoutManager(linearLayoutManager);
            adapter = new ResponseAdapter(lists, this);
            rv_response.setAdapter(adapter);
        } else {
            adapter.notifyData(lists);
        }
    }
}
