package com.softwareengineering.ttu.shadowruncharactermanager;

/**
 * Created by Rj on 3/26/2016.
 */
public class Melee extends Weapon {
    private int mReach;

    public Melee(){
        mReach = 1;
    }

    public Melee(String name, int cost, String type, int damage, int AP, int reach){
        super(name, cost, type, damage, AP);
        mReach = reach;
    }

    public int getReach(){
        return mReach;
    }
}
