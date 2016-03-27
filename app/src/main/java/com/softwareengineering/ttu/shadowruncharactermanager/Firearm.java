package com.softwareengineering.ttu.shadowruncharactermanager;

/**
 * Created by Rj on 3/25/2016.
 */
public class Firearm extends Weapon {
    private boolean mModeSemiAuto;
    private boolean mModeBurst;
    private boolean mModeFullAuto;
    private int mRecoilComp;

    public Firearm(){
        mModeSemiAuto = true;
        mModeBurst = false;
        mModeFullAuto = false;
        mRecoilComp = 0;
    }

    public Firearm(String name, int cost, String type, int damage, int AP, boolean SA, boolean BF, boolean FA, int RC){
        super(name, cost, type, damage, AP);
        mModeSemiAuto = SA;
        mModeBurst = BF;
        mModeFullAuto = FA;
        mRecoilComp = RC;
    }

    public boolean isSemiAuto(){
        return mModeSemiAuto;
    }

    public boolean isBurst(){
        return mModeBurst;
    }

    public boolean isFullAuto(){
        return mModeFullAuto;
    }

    public int getRecoilComp(){
        return mRecoilComp;
    }
}
