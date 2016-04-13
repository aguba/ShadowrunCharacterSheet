package com.softwareengineering.ttu.shadowruncharactermanager;

/**
 * Created by Rj on 4/1/2016.
 */
public class Attribute {
    private String mName;
    private int mRating;
    private AttributeSkillBridge mUpdater = AttributeSkillBridge.getInstance();

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
        mUpdater.update(mName, mRating);
    }

    public String getName(){
        return mName;
    }

    public void downRating(){
        mRating -= 1;
    }

    public int getRating(){
        return mRating;
    }
}
