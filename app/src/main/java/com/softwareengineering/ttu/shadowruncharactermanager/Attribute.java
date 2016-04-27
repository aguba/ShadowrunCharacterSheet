package com.softwareengineering.ttu.shadowruncharactermanager;

import java.io.Serializable;

/**
 * Created by Rj on 4/1/2016.
 */
public class Attribute implements Serializable{
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

    public void clear(){
        mRating = 0;
    }
}
