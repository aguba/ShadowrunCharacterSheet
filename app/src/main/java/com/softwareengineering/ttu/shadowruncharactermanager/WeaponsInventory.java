package com.softwareengineering.ttu.shadowruncharactermanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rj on 3/25/2016.
 */
public class WeaponsInventory {
    private static WeaponsInventory ourInstance = new WeaponsInventory();

    public static WeaponsInventory getInstance() {
        return ourInstance;
    }

    private WeaponsInventory() {
        character = Character.getInstance();

        mWeaponArray = new ArrayList<>();

        mWeaponArray.add(aresPredator = new Firearm("Ares Predator IV", 350, "Heavy Pistol", 5, -1, true, false, false, 0));
        mWeaponArray.add(aresViperSilvergun = new Firearm("Ares Viper Silvergun", 500, "Heavy Pistol", 8, 2, true, true, false, 0));
        mWeaponArray.add(coltManhunter = new Firearm("Colt Manhunter", 300, "Heavy Pistol", 5, -1, true, false, false, 0));
        mWeaponArray.add(rugerSuperWarhawk = new Firearm("Ruger Super Warhawk", 250, "Heavy Pistol", 6, -2, true, false, false, 0));
        mWeaponArray.add(aresAlpha = new Firearm("Ares Alpha", 1700, "Assault Rifle", 6, -1, true, true, true, 2));
        mWeaponArray.add(walterMA2100 = new Firearm("Walter MA-2100", 5000, "Sniper Rifle", 7, -3, true, false, false, 1));
        mWeaponArray.add(katana = new Melee("Katana", 1000, "Blade", 3, -1, 1));
    }

    LayoutInflater mInflater;

    private Firearm aresPredator;
    private Firearm aresViperSilvergun;
    private Firearm coltManhunter;
    private Firearm rugerSuperWarhawk;
    private Firearm aresAlpha;
    private Firearm walterMA2100;
    private Melee katana;
    private ArrayList<Weapon> mWeaponArray;
    private Character character;

    public void setInflater(LayoutInflater inflater) {
        mInflater = inflater;
    }

    public Weapon getWeapon(int id){
        return mWeaponArray.get(id);
    }

    public int getWeaponCount(){
        return mWeaponArray.size();
    }

    public View getWeaponPopupMiniView(ViewGroup root, int index) {
        View view = mInflater.inflate(R.layout.weapon_list_layout_mini, root, false);
        Weapon weapon = getWeapon(index);

        TableLayout table = (TableLayout) view.findViewById(R.id.weapon_table);
        TextView name = (TextView) view.findViewById(R.id.weapon_name);
        TextView type = (TextView) view.findViewById(R.id.weapon_type);
        TextView cost = (TextView) view.findViewById(R.id.weapon_cost);
        TextView damage = (TextView) view.findViewById(R.id.weapon_damage);
        TextView mode = (TextView) view.findViewById(R.id.weapon_mode);
        TextView AP = (TextView) view.findViewById(R.id.weapon_AP);
        TextView RC = (TextView) view.findViewById(R.id.weapon_RC);
        TextView reach = (TextView) view.findViewById(R.id.weapon_reach);
        TextView id = (TextView) view.findViewById(R.id.weapon_id);

        id.setText(Integer.toString(index));
        name.setText(weapon.getName());
        type.setText(weapon.getType());
        cost.setText(Integer.toString(weapon.getCost()));
        damage.setText(Integer.toString(weapon.getDamage()));
        AP.setText(Integer.toString(weapon.getArmorPen()));

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

        return view;
    }

    public View getWeaponPopupFullView(ViewGroup root, int index) {
        View view = mInflater.inflate(R.layout.weapon_list_layout, root, false);
        Weapon weapon = getWeapon(index);

        TableLayout table = (TableLayout) view.findViewById(R.id.weapon_table);
        TextView name = (TextView) view.findViewById(R.id.weapon_name);
        TextView type = (TextView) view.findViewById(R.id.weapon_type);
        TextView cost = (TextView) view.findViewById(R.id.weapon_cost);
        TextView damage = (TextView) view.findViewById(R.id.weapon_damage);
        TextView mode = (TextView) view.findViewById(R.id.weapon_mode);
        TextView AP = (TextView) view.findViewById(R.id.weapon_AP);
        TextView RC = (TextView) view.findViewById(R.id.weapon_RC);
        TextView reach = (TextView) view.findViewById(R.id.weapon_reach);
        TextView id = (TextView) view.findViewById(R.id.weapon_id);

        id.setText(Integer.toString(index));
        name.setText(weapon.getName());
        type.setText(weapon.getType());
        cost.setText(Integer.toString(weapon.getCost()));
        damage.setText(Integer.toString(weapon.getDamage()));
        AP.setText(Integer.toString(weapon.getArmorPen()));

        if(weapon instanceof Firearm) {
            for(int i=0; i<4; i++){
                table.setColumnStretchable(i, true);
            }
            table.setColumnCollapsed(4, true);
            table.setColumnShrinkable(4, true);

            Firearm firearm = (Firearm) weapon;
            RC.setText(Integer.toString(firearm.getRecoilComp()));

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

        return view;
    }

    public View getWeaponView(ViewGroup root, int index){
        View view = mInflater.inflate(R.layout.weapon_list_layout, root, false);
        Weapon weapon = character.getWeapon(index);
        String idString = Integer.toString(character.getWeaponList().keyAt(index));

        TableLayout table = (TableLayout) view.findViewById(R.id.weapon_table);
        TextView name = (TextView) view.findViewById(R.id.weapon_name);
        TextView type = (TextView) view.findViewById(R.id.weapon_type);
        TextView cost = (TextView) view.findViewById(R.id.weapon_cost);
        TextView damage = (TextView) view.findViewById(R.id.weapon_damage);
        TextView mode = (TextView) view.findViewById(R.id.weapon_mode);
        TextView AP = (TextView) view.findViewById(R.id.weapon_AP);
        TextView RC = (TextView) view.findViewById(R.id.weapon_RC);
        TextView reach = (TextView) view.findViewById(R.id.weapon_reach);
        TextView id = (TextView) view.findViewById(R.id.weapon_id);

        id.setText(idString);
        name.setText(weapon.getName());
        type.setText(weapon.getType());
        cost.setText(Integer.toString(weapon.getCost()));
        damage.setText(Integer.toString(weapon.getDamage()));
        AP.setText(Integer.toString(weapon.getArmorPen()));

        if(weapon instanceof Firearm) {
            for(int i=0; i<4; i++){
                table.setColumnStretchable(i, true);
            }
            table.setColumnCollapsed(4, true);
            table.setColumnShrinkable(4, true);

            Firearm firearm = (Firearm) weapon;
            RC.setText(Integer.toString(firearm.getRecoilComp()));

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

        return view;
    }
}
