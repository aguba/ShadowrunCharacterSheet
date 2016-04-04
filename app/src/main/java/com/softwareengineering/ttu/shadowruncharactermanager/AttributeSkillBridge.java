package com.softwareengineering.ttu.shadowruncharactermanager;

/**
 * Created by Rj on 4/4/2016.
 */
public class AttributeSkillBridge {
    private String mName;
    private Character character = Character.getInstance();

    public AttributeSkillBridge(String name){
        mName = name;
    }

    public void update(int attributeRating){
        switch (mName){
            case "Body"  :
                character.getSkill("Diving").dicepoolUp(attributeRating);
                character.getSkill("Parachuting").dicepoolUp(attributeRating);
                break;

            case "Reaction"  :
                character.getSkill("Dodge").dicepoolUp(attributeRating);
                character.getSkill("Pilot Ground Craft").dicepoolUp(attributeRating);
                character.getSkill("Pilot Water Craft").dicepoolUp(attributeRating);
                break;

            case "Strength"  :
                character.getSkill("Climbing").dicepoolUp(attributeRating);
                character.getSkill("Running").dicepoolUp(attributeRating);
                character.getSkill("Swimming").dicepoolUp(attributeRating);
                break;

            case "Charisma"  :
                character.getSkill("Con").dicepoolUp(attributeRating);
                character.getSkill("Etiquette").dicepoolUp(attributeRating);
                character.getSkill("Instruction").dicepoolUp(attributeRating);
                character.getSkill("Intimidation").dicepoolUp(attributeRating);
                character.getSkill("Leadership").dicepoolUp(attributeRating);
                character.getSkill("Negotiation").dicepoolUp(attributeRating);
                break;

            case "Intuition"  :
                character.getSkill("Artisan").dicepoolUp(attributeRating);
                character.getSkill("Disguise").dicepoolUp(attributeRating);
                character.getSkill("Interests Knowledge").dicepoolUp(attributeRating);
                character.getSkill("Navigation").dicepoolUp(attributeRating);
                character.getSkill("Perception").dicepoolUp(attributeRating);
                character.getSkill("Shadowing").dicepoolUp(attributeRating);
                character.getSkill("Street Knowledge").dicepoolUp(attributeRating);
                character.getSkill("Tracking").dicepoolUp(attributeRating);
                break;

            case "Logic"  :
                character.getSkill("Academic Knowledge").dicepoolUp(attributeRating);
                character.getSkill("Arcana").dicepoolUp(attributeRating);
                character.getSkill("Armorer").dicepoolUp(attributeRating);
                character.getSkill("Chemistry").dicepoolUp(attributeRating);
                character.getSkill("Computer").dicepoolUp(attributeRating);
                character.getSkill("Data Search ").dicepoolUp(attributeRating);
                character.getSkill("Demolitions").dicepoolUp(attributeRating);
                character.getSkill("Enchanting").dicepoolUp(attributeRating);
                character.getSkill("First Aid").dicepoolUp(attributeRating);
                character.getSkill("Hacking").dicepoolUp(attributeRating);
                character.getSkill("Professional Knowledge").dicepoolUp(attributeRating);
                break;

            case "Willpower"  :
                character.getSkill("Survival").dicepoolUp(attributeRating);
                break;

            case "Agility"  :
                character.getSkill("Archery").dicepoolUp(attributeRating);
                character.getSkill("Automatics").dicepoolUp(attributeRating);
                character.getSkill("Blades").dicepoolUp(attributeRating);
                character.getSkill("Clubs").dicepoolUp(attributeRating);
                character.getSkill("Escape Artist").dicepoolUp(attributeRating);
                character.getSkill("Forgery").dicepoolUp(attributeRating);
                character.getSkill("Gunnery").dicepoolUp(attributeRating);
                character.getSkill("Gymnastics").dicepoolUp(attributeRating);
                character.getSkill("Heavy Weapons").dicepoolUp(attributeRating);
                character.getSkill("Infiltration").dicepoolUp(attributeRating);
                character.getSkill("Locksmith").dicepoolUp(attributeRating);
                character.getSkill("Longarms").dicepoolUp(attributeRating);
                character.getSkill("Palming").dicepoolUp(attributeRating);
                character.getSkill("Pistols").dicepoolUp(attributeRating);
                character.getSkill("Throwing Weapons").dicepoolUp(attributeRating);
                character.getSkill("Unarmed Combat").dicepoolUp(attributeRating);
                break;
        }
    }
}
