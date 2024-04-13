package com.ltrsoft.police_mannagement_system.utils;

import androidx.fragment.app.Fragment;

public class TaskFactory {
    private Fragment fragment;
    private String taskname;

    public Fragment getTaskFragment(String taskname){
        switch (taskname){
            case "duty allotment task":
                return null;
            case "case allotment":
                return null;
            case "service approve":
                return null;
            case "complaint to FIR":
                return null;
            case "leave Grant":
                return null;
            case "Police Transfer":
                return null;
            case "Notification to police":
                return null;
            case "Warrant add":
                return null;
            default:
                return null;
        }
    }

}
