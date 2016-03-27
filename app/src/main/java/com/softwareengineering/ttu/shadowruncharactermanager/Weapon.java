package com.softwareengineering.ttu.shadowruncharactermanager;

/**
 * Created by Rj on 3/25/2016.
 */
public class Weapon extends Equipment {
    private String mType;
    private int mDamage;
    private int mArmorPen;

    public Weapon(){
        mType = "Pistol";
        mDamage = 6;
        mArmorPen = 0;
    }

    public Weapon(String name, int cost, String type, int damage, int AP){
        super(name, cost);
        mType = type;
        mDamage = damage;
        mArmorPen = AP;
    }

    public String getType(){
        return mType;
    }

    public void setType(String type){
        mType = type;
    }

    public int getDamage(){
        return mDamage;
    }

    public void setDamage(int damage){
        mDamage = damage;
    }

    public int getArmorPen(){
        return mArmorPen;
    }

    public void setArmorPen(int AP){
        mArmorPen = AP;
    }
}
