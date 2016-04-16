package com.softwareengineering.ttu.shadowruncharactermanager;

import android.content.Context;
import android.util.SparseArray;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.WriteAbortedException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Rafael Mallare
 * Singleton class to track character
 */
public class Character {
    private static Character ourInstance = new Character();

    private Character() {
        mFileName = "character1";
        mWeaponFileName = mFileName + "weapons";
        mArmorFileName = mFileName + "armor";

        mName = "Character Name";
        mBiography = "Character Biography";
        mKarma = 0;
        mNuyen = 10000;
        mGearStore = new TreeMap<>();
        mWeaponStore = new TreeMap<>();
        mArmorStore = new TreeMap<>();
        mEquippedWeapon = new Weapon();
        mEquippedWeapon = null;
        mEquippedWeapon = null;
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

    private String mSaveData;
    private String mWeaponData;
    private String mArmorData;
    private String mFileName;
    private String mWeaponFileName;
    private String mArmorFileName;

    private String mName;
    private String mMetaType;
    private String mImageURI;
    private String mBiography;
    private int mKarma;
    private int mNuyen;
    private Map<String, Attribute> mAttributes;
    private Map<String, Skill> mSkills;
    private TreeMap<Integer, Equipment> mGearStore;
    private TreeMap<Integer, Weapon> mWeaponStore;
    private TreeMap<Integer, Armor> mArmorStore;
    private Weapon mEquippedWeapon;
    private Armor mEquippedArmor;
    private int mGearKey;
    private int mWeaponKey;
    private int mArmorKey;

    public static Character getInstance() {

        return ourInstance;
    }

    public void save(Context context){
        Gson gson = new Gson();
        File file = new File(context.getFilesDir(), mFileName);
        File weaponFile = new File(context.getFilesDir(), mWeaponFileName);
        File armorFile = new File(context.getFilesDir(), mArmorFileName);

        mSaveData = gson.toJson(ourInstance, Character.class);

        if(!file.exists()){
            try{
            file.createNewFile();
            }
            catch (IOException e){

            }
        }

        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(mSaveData);
            fileWriter.flush();
            fileWriter.close();

        }
        catch (IOException e){

        }
    }

    public void load(Context context){
        Gson gson = new Gson();
        File file = new File(context.getFilesDir(), mFileName);
        File weaponFile = new File(context.getFilesDir(), mWeaponFileName);
        File armorFile = new File(context.getFilesDir(), mArmorFileName);

        if(file.exists()) {
            try {
                FileInputStream inputStream = new FileInputStream(file);
                byte[] buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
                inputStream.close();
                String data = new String(buffer);
                ourInstance = gson.fromJson(data, Character.class);

            } catch (IOException e) {

            }
        }
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
        mGearStore.put(mGearKey, gear);
        mGearKey++;

        return mGearKey-1;
    }

    public Equipment getGear(int index){
        Integer key = (Integer)mGearStore.keySet().toArray()[index];
        return mGearStore.get(key);
    }

    public void removeGear(int key){
        mGearStore.remove(key);
    }

    public boolean hasGear(){
        return mGearStore.size() != 0;
    }

    public TreeMap<Integer, Equipment> getGearList(){
        return mGearStore;
    }

    public int addWeapon(Weapon weapon){
        mWeaponStore.put(mWeaponKey, weapon);
        mWeaponKey++;

        return mWeaponKey - 1;
    }

    public int addArmor(Armor armor){
        mArmorStore.put(mArmorKey, armor);
        mArmorKey++;

        return mArmorKey - 1;
    }

    public Weapon getWeaponByIndex(int index){
        Integer key = (Integer)mWeaponStore.keySet().toArray()[index];
        return mWeaponStore.get(key);
    }

    public Armor getArmorByIndex(int index) {
        Integer key = (Integer)mArmorStore.keySet().toArray()[index];
        return mArmorStore.get(key);
    }

    public int weaponKeyAt(int index){
        return (Integer)mWeaponStore.keySet().toArray()[index];
    }

    public int armorKeyAt(int index){
        return (Integer)mArmorStore.keySet().toArray()[index];
    }

    public int gearKeyAt(int index){
        return (Integer)mGearStore.keySet().toArray()[index];
    }

    public Weapon getWeaponByID(int ID){
        return mWeaponStore.get(ID);
    }

    public Armor getArmorByID(int ID){
        return mArmorStore.get(ID);
    }

    public void removeWeapon(int key){
        mWeaponStore.remove(key);
    }

    public void removeArmor(int key){
        mArmorStore.remove(key);
    }

    public boolean hasWeapons(){
        return mWeaponStore.size() != 0;
    }

    public boolean hasArmor(){
        return mArmorStore.size() != 0;
    }

    public TreeMap<Integer, Weapon> getWeaponList(){
        return mWeaponStore;
    }

    public TreeMap<Integer, Armor> getArmorList(){
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

    public Attribute getAttributeByIndex(int index){
        return mAttributes.get(attributeNames[index]);
    }

    public void upAttribute(String attributeName){
        mAttributes.get(attributeName).upRating();
    }
}
