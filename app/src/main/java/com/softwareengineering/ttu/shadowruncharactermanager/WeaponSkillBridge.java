package com.softwareengineering.ttu.shadowruncharactermanager;

import java.util.HashMap;

/**
 * Created by Rj on 5/2/2016.
 */
public class WeaponSkillBridge {
    private static WeaponSkillBridge ourInstance = new WeaponSkillBridge();

    private WeaponSkillBridge(){
        typeSkillMap = new HashMap<>();
    }

    public static WeaponSkillBridge getInstance(){
        return ourInstance;
    }

    private HashMap<String, Skill> typeSkillMap;

    public void init(Character character){
        typeSkillMap.put("Heavy Pistol", character.getSkill("Pistols"));
        typeSkillMap.put("Assault Rifle", character.getSkill("Automatics"));
        typeSkillMap.put("Sniper Rifle", character.getSkill("Longarms"));
        typeSkillMap.put("Blade", character.getSkill("Blades"));
    }

    public Skill getSkill(String weaponType){
        return typeSkillMap.get(weaponType);
    }

}
