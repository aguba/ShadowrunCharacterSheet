package com.softwareengineering.ttu.shadowruncharactermanager;

/**
 * Created by Rj on 4/3/2016.
 */
public class Armor extends Equipment {
    private int mBallistic;
    private int mImpact;

    public Armor(String name, int cost, int ballisticRating, int impactRating){
        super(name, cost);
        mBallistic = ballisticRating;
        mImpact = impactRating;
    }

    public int getBallisticRating(){
        return mBallistic;
    }

    public int getImpactRating(){
        return mImpact;
    }

    public boolean isEquipped(){
        Armor armor = (Armor) this;
        return armor == Character.getInstance().getEquippedArmor();
    }
}
