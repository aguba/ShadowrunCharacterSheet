package com.softwareengineering.ttu.shadowruncharactermanager;

/**
 * Rafael Mallare
 * Equipment Class
 */
public class EquipmentClass {
    private String mName;
    private int mCost;
    private boolean mEquipped;

    public EquipmentClass(){
        mName = "Test Equipment";
        mCost = 999;
        mEquipped = false;
    }

    public void setEquipped(boolean value){
        mEquipped = value;
    }

    public boolean isEquipped(){
        return mEquipped;
    }

    public int getCost(){
        return mCost;
    }

    public String getName(){
        return mName;
    }
}
