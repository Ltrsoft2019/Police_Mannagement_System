package com.ltrsoft.police_mannagement_system.utils;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.SharedPreferences;

public class UserDataAccess {
    public String getKgid(Activity activity) {
        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
        return pref.getString("userID",null);
    }

    public void setKgid(String userId, Activity activity) {
        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("userID", userId)
                .apply();
    }
    public String getPosition(Activity activity) {
        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
        return pref.getString("position","ACP");
    }

    public void setPosition(String position, Activity activity) {
        SharedPreferences pref = activity.getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("position", position)
                .apply();
    }
}

