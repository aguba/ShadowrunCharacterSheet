package com.softwareengineering.ttu.shadowruncharactermanager;

/**
 * Rafael Mallare
 * Singleton class to track character
 */
public class Character {
    private static Character ourInstance = new Character();

    private Character() {
    }

    private String mName;
    private String mMetaType;
    private String mImageURI;
    private int mKarma = 0;
    private int mNuyen = 0;

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
}
