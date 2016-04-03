package com.softwareengineering.ttu.shadowruncharactermanager;

/**
 * Created by Rj on 4/1/2016.
 */
public class Attribute {
    private String mName;
    private int mRating;

    public Attribute(){
        mName = "Attribute";
        mRating = 0;
    }

    public Attribute(String name){
        mName = name;
        mRating = 0;
    }

    public void upRating(){
        mRating += 1;
    }

    public void downRating(){
        mRating -= 1;
    }
}
