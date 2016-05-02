package com.softwareengineering.ttu.shadowruncharactermanager;

import java.io.Serializable;

/**
 * Created by Rj on 4/1/2016.
 */
public class Skill implements Serializable{
    private String mName;
    private int mRating;
    private int mDicepool;
    private String mSpecialization;
    private boolean mHidden;

    public String getName(){
        return mName;
    }

    public Skill(){
        mName = "Skill";
        mRating = 0;
        mDicepool = 0;
        mSpecialization = "None";
        mHidden = false;
    }

    public Skill(String name){
        mName = name;
        mRating = 0;
        mDicepool = 0;
        mSpecialization = "None";
    }

    public void ratingUp(){
        mRating += 1;
        dicepoolUp();
    }

    public void ratingDown(){
        mRating -= 1;
        dicepoolDown();
    }

    public void dicepoolUp(){
        mDicepool += 1;
    }

    public void dicepoolDown(){
        mDicepool -= 1;
    }

    public void dicepoolUp(int attributeValue){
        mDicepool = mRating + attributeValue;
    }

    public int getRating(){
        return mRating;
    }

    public int getDicepool(){
        return mDicepool;
    }

    public void isHidden(boolean hidden){
        mHidden = hidden;
    }

    public boolean isHidden(){
        return mHidden;
    }

    public void clear(){
        mRating = 0;
        mDicepool = 0;
        mSpecialization = "";
    }
}
