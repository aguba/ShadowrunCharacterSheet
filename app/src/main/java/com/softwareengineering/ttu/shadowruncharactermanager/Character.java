package com.softwareengineering.ttu.shadowruncharactermanager;

/**
 * Created by Rj on 2/27/2016.
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
    private int mAgility;
    private int mBody;
    private int mReaction;
    private int mStrength;
    private int mCharisma;
    private int mIntuition;
    private int mLogic;
    private int mWillpower;

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

    public void setAgility(int value){
        mAgility = value;
    }

    public int getAgility(){
        return mAgility;
    }

    public void setBody(int value){
        mBody = value;
    }

    public int getBody(){
        return mBody;
    }

    public void setReaction(int value){
        mReaction = value;
    }

    public int getReaction(){
        return mReaction;
    }

    public void setStrength(int value){
        mStrength = value;
    }

    public int getStrength(){
        return mStrength;
    }
}