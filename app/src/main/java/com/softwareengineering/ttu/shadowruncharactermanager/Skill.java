package com.softwareengineering.ttu.shadowruncharactermanager;

/**
 * Created by Rj on 4/1/2016.
 */
public class Skill {
    private String mName;
    private int mRating;
    private int mDicepool;
    private String mSpecialization;

    public Skill(){
        mName = "Skill";
        mRating = 0;
        mDicepool = 0;
        mSpecialization = "None";
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
}
