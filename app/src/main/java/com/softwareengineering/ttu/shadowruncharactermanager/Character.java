package com.softwareengineering.ttu.shadowruncharactermanager;

import android.util.SparseArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Rafael Mallare
 * Singleton class to track character
 */
public class Character {
    private static Character ourInstance = new Character();

    private Character() {
        mName = "Character Name";
        mBiography = "Character Biography";
        mKarma = 0;
        mNuyen = 10000;
        mGearStore = new SparseArray<>();
        mWeaponStore = new SparseArray<>();
        mArmorStore = new SparseArray<>();
        mEquippedWeapon = new Weapon();
        mEquippedWeapon = null;
        mEquippedWeapon = null;
        mGearKey = 0;
        mWeaponKey = 0;
        mArmorKey = 0;
        mAttributes = new HashMap<>();
        mSkills = new HashMap<>();
        for(int i=0; i<50; i++){
            if(i<8){
                mAttributes.put(attributeNames[i], new Attribute(attributeNames[i]));
            }
            mSkills.put(skillNames[i], new Skill(skillNames[i]));
        }
    }
    private String[] attributeNames = {"Body","Agility","Reaction","Strength","Charisma","Intuition","Logic","Willpower"};
    private String[] skillNames = {"Academic Knowledge", "Arcana", "Archery", "Armorer", "Artisan", "Automatics", "Blades", "Chemistry", "Climbing", "Clubs", "Computer", "Con", "Data Search", "Demolitions", "Disguise", "Diving", "Dodge", "Enchanting", "Escape Artist", "Etiquette", "First Aid", "Forgery", "Gunnery", "Gymnastics", "Hacking", "Heavy Weapons", "Infiltration", "Instruction", "Interests Knowledge", "Intimidation", "Leadership", "Locksmith", "Longarms", "Navigation", "Negotiation", "Palming", "Parachuting", "Perception", "Pilot Ground Craft", "Pilot Watercraft", "Pistols", "Professional Knowledge", "Running", "Shadowing", "Street Knowledge", "Survival", "Swimming", "Throwing Weapons", "Tracking", "Unarmed Combat"};

    private String mName;
    private String mMetaType;
    private String mImageURI;
    private String mBiography;
    private int mKarma;
    private int mNuyen;
    private Map<String, Attribute> mAttributes;
    private Map<String, Skill> mSkills;
    private SparseArray<Equipment> mGearStore;
    private SparseArray<Weapon> mWeaponStore;
    private SparseArray<Armor> mArmorStore;
    private Weapon mEquippedWeapon;
    private Armor mEquippedArmor;
    private int mGearKey;
    private int mWeaponKey;
    private int mArmorKey;

    public static Character getInstance() {

        return ourInstance;
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

    public void subKarma(int karmaAmount){
        mKarma -= karmaAmount;
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

        return mWeaponKey - 1;
    }

    public int addArmor(Armor armor){
        mArmorStore.append(mArmorKey, armor);
        mArmorKey++;

        return mArmorKey - 1;
    }

    public Weapon getWeaponByIndex(int index){
        return mWeaponStore.valueAt(index);
    }

    public Armor getArmorByIndex(int index) {
        return mArmorStore.valueAt(index);
    }

    public Weapon getWeaponByID(int ID){
        return mWeaponStore.get(ID);
    }

    public Armor getArmorByID(int ID){
        return mArmorStore.get(ID);
    }

    public void removeWeapon(int key){
        mWeaponStore.delete(key);
    }

    public void removeArmor(int key){
        mArmorStore.delete(key);
    }

    public boolean hasWeapons(){
        return mWeaponStore.size() != 0;
    }

    public boolean hasArmor(){
        return mArmorStore.size() != 0;
    }

    public SparseArray<Weapon> getWeaponList(){
        return mWeaponStore;
    }

    public SparseArray<Armor> getArmorList(){
        return mArmorStore;
    }

    public void equipWeapon(Weapon weapon){
        mEquippedWeapon = weapon;
    }

    public void equipArmor(Armor armor){
        mEquippedArmor = armor;
    }

    public void unEquipArmor(){
        mEquippedWeapon = null;
    }

    public void unEquipWeapon(){
        mEquippedArmor = null;
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

    public void upSkill(String skillName){
        mSkills.get(skillName).ratingUp();
    }

    public Attribute getAttribute(String attributeName){
        return mAttributes.get(attributeName);
    }

    public void upAttribute(String attributeName){
        mAttributes.get(attributeName).upRating();
    }
}
