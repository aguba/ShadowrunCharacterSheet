package com.softwareengineering.ttu.shadowruncharactermanager;

import com.firebase.client.Firebase;
/**
 * Created by dablackw on 4/14/2016.
 */
public class Shadowrun extends android.app.Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        // other setup code
    }

}
