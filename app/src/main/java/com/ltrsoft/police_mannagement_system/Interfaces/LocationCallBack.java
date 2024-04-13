package com.ltrsoft.police_mannagement_system.Interfaces;

import android.location.Location;

public interface LocationCallBack {
    public void onLocationGet(Location latLng);
    public void onError(String error);

}
