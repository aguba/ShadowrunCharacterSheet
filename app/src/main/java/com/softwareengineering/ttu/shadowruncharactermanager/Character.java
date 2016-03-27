package com.softwareengineering.ttu.shadowruncharactermanager;

import android.util.SparseArray;

import java.util.ArrayList;

/**
 * Rafael Mallare
 * Singleton class to track character
 */
public class Character {
    private static Character ourInstance = new Character();

    private Character() {
        mName = "Character Name";
        mKarma = 0;
        mNuyen = 10000;
        mGearStore = new SparseArray<>();
        mWeaponStore = new SparseArray<>();
        mHasGear = false;
        mGearKey = 0;
        mWeaponKey = 0;
    }

    private String mName;
    private String mMetaType;
    private String mImageURI;
    private int mKarma;
    private int mNuyen;
    private SparseArray<Equipment> mGearStore;
    private SparseArray<Weapon> mWeaponStore;
    private boolean mHasGear;
    private int mGearKey;
    private int mWeaponKey;

    public static Character getInstance() {

        return ourInstance;
    }

    public void setName(String value){
        mName = value;
    }

    public String getName(){
        return mName;
    }

    public void setMetaType(String value){
        mMetaType = value;
    }

    public String getMetaType(){
        return mMetaType;
    }

    public void setImageURI(String value){
        mImageURI = value;
    }

    public String getImageURI(){
        return mImageURI;
    }

    public void setKarma(int value){
        mKarma = value;
    }

    public int getKarma(){
        return mKarma;
    }

    public void setNuyen(int value){
        mNuyen = value;
    }

    public int getNuyen(){
        return mNuyen;
    }

    public void addNuyen(int nuyenAmount){
        mNuyen += nuyenAmount;
    }

    public void subNuyen(int nuyenAmount){
        mNuyen -= nuyenAmount;
    }

    public int addGear(Equipment gear){
        mGearStore.append(mGearKey, gear);
        mGearKey++;

        return mGearKey-1;
    }

    public Equipment getGear(int index){
        return mGearStore.valueAt(index);
    }

    public void removeGear(int key){
        mGearStore.delete(key);
    }

    public boolean hasGear(){
        return mGearStore.size() != 0;
    }

    public SparseArray<Equipment> getGearList(){
        return mGearStore;
    }

    public int addWeapon(Weapon weapon){
        mWeaponStore.append(mWeaponKey, weapon);
        mWeaponKey++;

        return mWeaponKey-1;
    }

    public Weapon getWeapon(int index){
        return mWeaponStore.valueAt(index);
    }

    public void removeWeapon(int key){
        mWeaponStore.delete(key);
    }

    public boolean hasWeapons(){
        return mWeaponStore.size() != 0;
    }

    public SparseArray<Weapon> getWeaponList(){
        return mWeaponStore;
    }
}
