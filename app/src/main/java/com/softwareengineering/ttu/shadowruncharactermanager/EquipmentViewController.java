package com.softwareengineering.ttu.shadowruncharactermanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

/**
 * Created by Rj on 4/3/2016.
 */
public class EquipmentViewController {

    public EquipmentViewController(LayoutInflater inflater){
        mInflater = inflater;
        mCharacter = Character.getInstance();
        mInventory = EquipmentInventory.getInstance();
        mBridge = WeaponSkillBridge.getInstance();
        mBridge.init(mCharacter);
    }

    private LayoutInflater mInflater;
    private Character mCharacter;
    private EquipmentInventory mInventory;
    WeaponSkillBridge mBridge;

    public View getWeaponPopupMiniView(ViewGroup root, int index) {
        View view = mInflater.inflate(R.layout.weapon_list_layout_mini, root, false);
        Weapon weapon = mInventory.getWeapon(index);

        TextView id = (TextView) view.findViewById(R.id.weapon_id);
        id.setText(Integer.toString(index));

        setWeaponView(view, weapon, 1);

        return view;
    }

    public View getArmorPopupMiniView(ViewGroup root, int index){
        View view = mInflater.inflate(R.layout.armor_list_layout_mini, root, false);
        Armor armor = mInventory.getArmor(index);

        TextView id = (TextView) view.findViewById(R.id.armor_id);
        id.setText(Integer.toString(index));

        setArmorView(view, armor);

        return view;
    }

    public View getWeaponPopupFullView(ViewGroup root, int index) {
        View view = mInflater.inflate(R.layout.weapon_list_layout, root, false);
        Weapon weapon = mInventory.getWeapon(index);

        TextView id = (TextView) view.findViewById(R.id.weapon_id);
        id.setText(Integer.toString(index));

        setWeaponView(view, weapon, 0);

        return view;
    }

    public View getArmorPopupFullView(ViewGroup root, int index) {
        View view = mInflater.inflate(R.layout.armor_list_layout, root, false);
        Armor armor = mInventory.getArmor(index);

        TextView id = (TextView) view.findViewById(R.id.armor_id);
        id.setText(Integer.toString(index));

        setArmorView(view, armor);

        return view;
    }

    public View getWeaponView(ViewGroup root, int index){
        View view = mInflater.inflate(R.layout.weapon_list_layout, root, false);
        Weapon weapon = mCharacter.getWeaponByIndex(index);
        String idString = Integer.toString(mCharacter.weaponKeyAt(index));

        TextView id = (TextView) view.findViewById(R.id.weapon_id);
        id.setText(idString);

        setWeaponView(view, weapon, 0);

        return view;
    }

    public View getWeaponViewSummary(LayoutInflater inflater, ViewGroup root, Weapon weapon){
        View view = inflater.inflate(R.layout.weapon_list_layout, root, false);
        setWeaponView(view, weapon, 0);

        TextView cost = (TextView) view.findViewById(R.id.weapon_cost);
        TextView costTxt = (TextView) view.findViewById(R.id.weapon_cost_txt);
        ImageButton btnMenu = (ImageButton) view.findViewById(R.id.weapon_menu);
        TextView equippedTitle = (TextView) view.findViewById(R.id.equipped_title);
        TextView equippedStatus = (TextView) view.findViewById(R.id.weapon_equipped);

        cost.setVisibility(View.GONE);
        costTxt.setVisibility(View.GONE);
        btnMenu.setVisibility(View.GONE);
        equippedTitle.setVisibility(View.GONE);
        equippedStatus.setVisibility(View.GONE);

        return view;
    }

    public View getArmorView(ViewGroup root, int index){
        View view = mInflater.inflate(R.layout.armor_list_layout, root, false);
        Armor armor = mCharacter.getArmorByIndex(index);
        String idString = Integer.toString(mCharacter.armorKeyAt(index));

        TextView id = (TextView) view.findViewById(R.id.armor_id);
        id.setText(idString);

        setArmorView(view, armor);

        return view;
    }

    private void setWeaponView(View view, Weapon weapon, int identifier){
        TableLayout table = (TableLayout) view.findViewById(R.id.weapon_table);
        TextView name = (TextView) view.findViewById(R.id.weapon_name);
        TextView type = (TextView) view.findViewById(R.id.weapon_type);
        TextView cost = (TextView) view.findViewById(R.id.weapon_cost);
        TextView damage = (TextView) view.findViewById(R.id.weapon_damage);
        TextView mode = (TextView) view.findViewById(R.id.weapon_mode);
        TextView AP = (TextView) view.findViewById(R.id.weapon_AP);
        TextView RC = (TextView) view.findViewById(R.id.weapon_RC);
        TextView reach = (TextView) view.findViewById(R.id.weapon_reach);

        name.setText(weapon.getName());
        type.setText(weapon.getType());
        cost.setText(Integer.toString(weapon.getCost()));
        damage.setText(Integer.toString(weapon.getDamage()));
        AP.setText(Integer.toString(weapon.getArmorPen()));

        if (identifier == 0){
            DiceRoller diceRoller = new DiceRoller(view, mInflater);
            ImageButton btnRollDice = (ImageButton) view.findViewById(R.id.btn_roll_dice);
            TextView skillName = (TextView)view.findViewById(R.id.skill_name);
            TextView dicePool = (TextView)view.findViewById(R.id.dicepool);
            Skill skill = mBridge.getSkill(weapon.getType());
            int dPool = skill.getDicepool();

            skillName.setText("(" + skill.getName() + ")");
            dicePool.setText(Integer.toString(dPool));

            diceRoller.setButton(btnRollDice, weapon.getName(), dPool);
        }

        if(view.findViewById(R.id.weapon_equipped) != null) {
            TextView equipped = (TextView) view.findViewById(R.id.weapon_equipped);
            if (weapon.isEquipped()) {
                equipped.setText("Yes");
            } else {
                equipped.setText("No");
            }
        }

        if(weapon instanceof Firearm) {
            Firearm firearm = (Firearm) weapon;
            RC.setText(Integer.toString(firearm.getRecoilComp()));

            for(int i=0; i<4; i++){
                table.setColumnStretchable(i, true);
            }
            table.setColumnCollapsed(4, true);
            table.setColumnShrinkable(4, true);

            String modeText = "";
            if (firearm.isSemiAuto()) {
                modeText = "SA";
            }
            if (firearm.isBurst()) {
                if (!modeText.equals("")) {
                    modeText += "/";
                }
                modeText += "BF";
            }
            if (firearm.isFullAuto()) {
                if (!modeText.equals("")) {
                    modeText += "/";
                }
                modeText += "FA";
            }
            mode.setText(modeText);
        }
        else if(weapon instanceof Melee){
            Melee melee = (Melee) weapon;

            table.setColumnStretchable(0, true);
            table.setColumnStretchable(2, true);
            table.setColumnStretchable(4, true);

            table.setColumnCollapsed(1, true);
            table.setColumnShrinkable(1, true);
            table.setColumnCollapsed(3, true);
            table.setColumnShrinkable(3, true);

            reach.setText(Integer.toString(melee.getReach()));
        }
    }

    private void setArmorView(View view, Armor armor){
        TextView name = (TextView) view.findViewById(R.id.armor_name);
        TextView cost = (TextView) view.findViewById(R.id.armor_cost);
        TextView ballisticRtg = (TextView) view.findViewById(R.id.armor_ballistic);
        TextView impactRtg = (TextView) view.findViewById(R.id.armor_impact);

        if(view.findViewById(R.id.armor_equipped) != null){
            TextView equipped = (TextView) view.findViewById(R.id.armor_equipped);
            if (armor.isEquipped()) {
                equipped.setText("Yes");
            } else {
                equipped.setText("No");
            }
        }

        name.setText(armor.getName());
        cost.setText(Integer.toString(armor.getCost()));
        ballisticRtg.setText(Integer.toString(armor.getBallisticRating()));
        impactRtg.setText(Integer.toString(armor.getImpactRating()));
    }

}
