package com.retrofit_recyclerview_display_list.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Ramesh on 10/25/16.
 */

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    private ProgressDialog dialog = null;
    public void dismissProgressDialog() {
        try {
            if ((dialog != null)&&(dialog.isShowing())) dialog.dismiss();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    public void showProgressDialog(String message) {
        if (dialog == null) dialog = new ProgressDialog(this);
        dialog.setMessage(message);

        dialog.setCancelable(true);
        try {
            if (!dialog.isShowing()) dialog.show();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
}
