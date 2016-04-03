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
}
