package com.softwareengineering.ttu.shadowruncharactermanager;

import java.util.ArrayList;

/**
 * Created by Rj on 3/25/2016.
 */
public class EquipmentInventory {
    private static EquipmentInventory ourInstance = new EquipmentInventory();

    public static EquipmentInventory getInstance() {
        return ourInstance;
    }

    private EquipmentInventory() {
        mWeaponArray = new ArrayList<>();
        mArmorArray = new ArrayList<>();

        mWeaponArray.add(new Firearm("Ares Predator IV", 350, "Heavy Pistol", 5, -1, true, false, false, 0));
        mWeaponArray.add(new Firearm("Ares Viper Silvergun", 500, "Heavy Pistol", 8, 2, true, true, false, 0));
        mWeaponArray.add(new Firearm("Colt Manhunter", 300, "Heavy Pistol", 5, -1, true, false, false, 0));
        mWeaponArray.add(new Firearm("Ruger Super Warhawk", 250, "Heavy Pistol", 6, -2, true, false, false, 0));
        mWeaponArray.add(new Firearm("Ares Alpha", 1700, "Assault Rifle", 6, -1, true, true, true, 2));
        mWeaponArray.add(new Firearm("Walter MA-2100", 5000, "Sniper Rifle", 7, -3, true, false, false, 1));
        mWeaponArray.add(new Melee("Katana", 1000, "Blade", 3, -1, 1));

        mArmorArray.add(new Armor("Leather Jacket", 200, 2, 2));
        mArmorArray.add(new Armor("Armor Clothing", 500, 4, 0));
        mArmorArray.add(new Armor("Full Body Armor", 6000, 10, 8));
        mArmorArray.add(new Armor("Helmet", 1000, 2, 2));
    }

    private ArrayList<Weapon> mWeaponArray;
    private ArrayList<Armor> mArmorArray;

    public Weapon getWeapon(int id){
        return mWeaponArray.get(id);
    }

    public int getWeaponCount(){
        return mWeaponArray.size();
    }

    public Armor getArmor(int id){
        return mArmorArray.get(id);
    }

    public int getArmorCount(){
        return mArmorArray.size();
    }
}
