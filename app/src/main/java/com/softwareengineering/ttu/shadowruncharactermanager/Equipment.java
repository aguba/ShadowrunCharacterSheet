package com.softwareengineering.ttu.shadowruncharactermanager;

import java.io.Serializable;

/**
 * Rafael Mallare
 * Equipment Class
 */
public class Equipment implements Serializable{
    private String mName;
    private int mCost;
    private boolean mEquipped;
    private int mId;

    public Equipment() {
        mName = "Test Equipment";
        mCost = 999;
        mEquipped = false;
    }

    public Equipment(String name, int cost) {
        mName = name;
        mCost = cost;
        mEquipped = false;
    }

    public void setEquipped(boolean value) {
        mEquipped = value;
    }

    public boolean isEquipped() {
        return mEquipped;
    }

    public int getCost() {
        return mCost;
    }

    public void setCost(int cost) {
        mCost = cost;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setId(int Id){
        mId = Id;
    }

    public int getId(){
        return mId;
    }
}
