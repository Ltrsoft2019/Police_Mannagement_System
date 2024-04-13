package com.ltrsoft.police_mannagement_system.utils;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

public class ActionBarTitle  {
    public static void setTiltle(String title,AppCompatActivity activity){
        if (activity.getSupportActionBar()!=null){
            activity.getSupportActionBar().setTitle(title);
        }
    }

}
