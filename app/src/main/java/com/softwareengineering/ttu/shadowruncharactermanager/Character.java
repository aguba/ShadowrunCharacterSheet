package com.softwareengineering.ttu.shadowruncharactermanager;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Rafael Mallare
 * Singleton class to track character
 */
public class Character implements Serializable{
    private static Character ourInstance = new Character();

    private Character() {
        mFileName = "character0.txt";
        mFileIndex = 0;
        mName = "Character Name";
        mBiography = "Character Biography";
        mKarma = 0;
        mNuyen = 10000;

        mGearStore = new ArrayList<>();
        mWeaponStore = new ArrayList<>();
        mArmorStore = new ArrayList<>();

        mEquippedWeapon = null;
        mEquippedArmor = null;
        mGearKey = 0;
        mWeaponKey = 0;
        mArmorKey = 0;
        mAttributes = new HashMap<>();
        mSkills = new HashMap<>();
        for (int i = 0; i < 50; i++) {
            if (i < 9) {
                mAttributes.put(attributeNames[i], new Attribute(attributeNames[i]));
            }
            mSkills.put(skillNames[i], new Skill(skillNames[i]));
        }
    }

    private String[] attributeNames = {"Body","Agility","Reaction","Strength","Charisma","Intuition","Logic","Willpower", "Edge"};
    private String[] skillNames = {"Academic Knowledge", "Arcana", "Archery", "Armorer", "Artisan", "Automatics", "Blades", "Chemistry", "Climbing", "Clubs", "Computer", "Con", "Data Search", "Demolitions", "Disguise", "Diving", "Dodge", "Enchanting", "Escape Artist", "Etiquette", "First Aid", "Forgery", "Gunnery", "Gymnastics", "Hacking", "Heavy Weapons", "Infiltration", "Instruction", "Interests Knowledge", "Intimidation", "Leadership", "Locksmith", "Longarms", "Navigation", "Negotiation", "Palming", "Parachuting", "Perception", "Pilot Ground Craft", "Pilot Watercraft", "Pistols", "Professional Knowledge", "Running", "Shadowing", "Street Knowledge", "Survival", "Swimming", "Throwing Weapons", "Tracking", "Unarmed Combat"};

    private String mFileName;
    private int mFileIndex;

    private String mName;
    private String mMetaType;
    private String mImageURI;
    private String mBiography;
    private int mKarma;
    private int mNuyen;
    private HashMap<String, Attribute> mAttributes;
    private HashMap<String, Skill> mSkills;
    private ArrayList<Equipment> mGearStore;
    private ArrayList<Weapon> mWeaponStore;
    private ArrayList<Armor> mArmorStore;
    private Weapon mEquippedWeapon;
    private Armor mEquippedArmor;
    private int mGearKey;
    private int mWeaponKey;
    private int mArmorKey;

    public static Character getInstance() {

        return ourInstance;
    }

    public static void setInstance(Character instance){
        ourInstance = instance;
    }

    public String getFileName(){
        return mFileName;
    }

    public void reset(int fileIndex){
        mImageURI = null;
        mBiography = "Character Biography";
        mKarma = 0;
        mNuyen = 0;
        mFileIndex = fileIndex;
        mFileName = "character" + Integer.toString(mFileIndex) + ".txt";

        mGearStore.clear();
        mWeaponStore.clear();
        mArmorStore.clear();

        mEquippedWeapon = null;
        mEquippedArmor = null;
        mGearKey = 0;
        mWeaponKey = 0;
        mArmorKey = 0;

        for (int i = 0; i < 50; i++) {
            if (i < 9) {
                getAttribute(attributeNames[i]).clear();
            }
            getSkill(skillNames[i]).clear();
        }
    }

    public int getFileIndex(){
        return mFileIndex;
    }

    public void setName(String value){
        mName = value;
    }

    public String getName(){
        return mName;
    }

    public void setBio(String bio){
        mBiography = bio;
    }

    public String getBio(){
        return mBiography;
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

    public void addKarma(int karmaAmount){
        mKarma += karmaAmount;
    }

    public void subKarma(int karmaAmount) {
        if (karmaAmount > mKarma) {
            mKarma = 0;
        } else {
            mKarma -= karmaAmount;
        }
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

    public void subNuyen(int nuyenAmount) {
        if (nuyenAmount > mNuyen) {
            mNuyen = 0;
        } else {
            mNuyen -= nuyenAmount;
        }
    }

    public int addGear(Equipment gear){
        Equipment equip = gear;
        equip.setId(mGearKey);

        mGearStore.add(equip);
        mGearKey++;

        return mGearKey-1;
    }

    public Equipment getGear(int index){
        return mGearStore.get(index);
    }

    public void removeGear(int key){
        for(int i = 0; i < mGearStore.size(); i++){
            if(mGearStore.get(i).getId() == key){
                mGearStore.remove(i);
            }
        }
    }

    public boolean hasGear(){
        return mGearStore.size() != 0;
    }

    public ArrayList<Equipment> getGearList(){
        return mGearStore;
    }

    public int addWeapon(Weapon weapon){
        Weapon wep = weapon;
        wep.setId(mWeaponKey);

        mWeaponStore.add(wep);
        mWeaponKey++;

        return mWeaponKey - 1;
    }

    public int addArmor(Armor armor){
        Armor arm = armor;
        arm.setId(mArmorKey);

        mArmorStore.add(arm);
        mArmorKey++;

        return mArmorKey - 1;
    }

    public Weapon getWeaponByIndex(int index){
        return mWeaponStore.get(index);
    }

    public Armor getArmorByIndex(int index) {
        return mArmorStore.get(index);
    }

    public int weaponKeyAt(int index){
        return mWeaponStore.get(index).getId();
    }

    public int armorKeyAt(int index){
        return mArmorStore.get(index).getId();
    }

    public int gearKeyAt(int index){
        return mGearStore.get(index).getId();
    }

    public Weapon getWeaponByID(int ID){
        for(int i = 0; i < mWeaponStore.size(); i++){
            if(mWeaponStore.get(i).getId() == ID){
                return mWeaponStore.get(i);
            }
        }
        return null;
    }

    public Armor getArmorByID(int ID){
        for(int i = 0; i < mArmorStore.size(); i++){
            if(mArmorStore.get(i).getId() == ID){
                return mArmorStore.get(i);
            }
        }
        return null;
    }

    public void removeWeapon(int key){
        for(int i = 0; i < mWeaponStore.size(); i++){
            if(mWeaponStore.get(i).getId() == key){
                mWeaponStore.remove(i);
                break;
            }
        }
    }

    public void removeArmor(int key){
        for(int i = 0; i < mArmorStore.size(); i++){
            if(mArmorStore.get(i).getId() == key){
                mArmorStore.remove(i);
                break;
            }
        }
    }

    public boolean hasWeapons(){
        return mWeaponStore.size() != 0;
    }

    public boolean hasArmor(){
        return mArmorStore.size() != 0;
    }

    public ArrayList<Weapon> getWeaponList(){
        return mWeaponStore;
    }

    public ArrayList<Armor> getArmorList(){
        return mArmorStore;
    }

    public void equipWeapon(Weapon weapon){
        mEquippedWeapon = weapon;
    }

    public void equipArmor(Armor armor){
        mEquippedArmor = armor;
    }

    public void unEquipArmor(){
        mEquippedArmor = null;
    }

    public void unEquipWeapon(){
        mEquippedWeapon = null;
    }

    public Weapon getEquippedWeapon(){
        return mEquippedWeapon;
    }

    public Armor getEquippedArmor(){
        return mEquippedArmor;
    }

    public boolean packingHeat(){
        return getEquippedWeapon() != null;
    }

    public boolean isProtected(){
        return getEquippedArmor() != null;
    }

    public Skill getSkill(String skillName){
        return mSkills.get(skillName);
    }

    public Skill getSkillByIndex(int index){
        return mSkills.get(skillNames[index]);
    }

    public void upSkill(String skillName){
        mSkills.get(skillName).ratingUp();
    }

    public Attribute getAttribute(String attributeName){
        return mAttributes.get(attributeName);
    }

    public Attribute getAttributeByIndex(int index){
        return mAttributes.get(attributeNames[index]);
    }

    public void upAttribute(String attributeName){
        mAttributes.get(attributeName).upRating();
    }
}
