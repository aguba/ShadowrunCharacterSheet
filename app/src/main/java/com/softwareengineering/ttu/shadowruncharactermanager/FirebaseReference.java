package com.softwareengineering.ttu.shadowruncharactermanager;

import com.firebase.client.Firebase;

/**
 * Created by DABJ on 4/26/2016.
 */
public class FirebaseReference {
    public Firebase pHealthRef, sHealthRef, karmaRef, nuyenRef;
    public String username;

    private static FirebaseReference referenceInstance = null;

    /*constructor*/
    private FirebaseReference(String username)
    {
        this.username = username;

        pHealthRef = new Firebase("https://shadowrun6.firebaseio.com/user_" + username + "/char0/pHealth");
        sHealthRef = new Firebase("https://shadowrun6.firebaseio.com/user_" + username + "/char0/sHealth");
        karmaRef = new Firebase("https://shadowrun6.firebaseio.com/user_" + username + "/char0/karma");
        nuyenRef = new Firebase("https://shadowrun6.firebaseio.com/user_" + username + "/char0/nuyen");

    }

    /*returns singleton FirebaseReference object*/
    public static FirebaseReference getReferenceInstance(String username){
        if(referenceInstance == null){
            referenceInstance = new FirebaseReference(username);
        }
        return referenceInstance;
    }

}
