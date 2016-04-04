package com.softwareengineering.ttu.shadowruncharactermanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


public class CharacterSheet extends AppCompatActivity {
    Character character = Character.getInstance();

    TextView pHealth;
    TextView sHealth;
    SeekBar pHealthBar;
    SeekBar sHealthBar;
    ImageView picture;
    TextView charName;
    TextView karmaVal;
    TextView nuyenVal;
    ImageLoader mainLoader;

    TextView weaponDefaultTxt;
    LinearLayout weaponContainer;
    View weaponView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);

        picture = (ImageView) findViewById(R.id.character_image);
        pHealth = (TextView) findViewById(R.id.physical_health_value);
        pHealthBar = (SeekBar) findViewById(R.id.physical_health_bar);
        sHealth = (TextView) findViewById(R.id.stun_health_value);
        sHealthBar = (SeekBar) findViewById(R.id.stun_health_bar);
        karmaVal = (TextView) findViewById(R.id.karma_value);
        nuyenVal = (TextView) findViewById(R.id.nuyen_value);
        charName = (TextView) findViewById(R.id.character_name);
        mainLoader = ImageLoader.getInstance();

        weaponDefaultTxt = (TextView) findViewById(R.id.no_equipped_weapon);
        weaponContainer = (LinearLayout) findViewById(R.id.weapon_view_container);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .build();
        ImageLoader.getInstance().init(config);

        loadValues();

        pHealth.setText(String.valueOf(pHealthBar.getMax()) + "/" + String.valueOf(pHealthBar.getMax()));
        sHealth.setText(String.valueOf(sHealthBar.getMax()) + "/" + String.valueOf(sHealthBar.getMax()));
/*
        TableRow r = (TableRow) findViewById(R.id.table_row_1);
        r.setVisibility(View.GONE);
        */

        pHealthBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pHealth.setText(String.valueOf(progress) + "/" + String.valueOf(pHealthBar.getMax()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sHealthBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sHealth.setText(String.valueOf(progress) + "/" + String.valueOf(sHealthBar.getMax()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    void loadValues() {
        mainLoader.displayImage(character.getImageURI(), picture);
        karmaVal.setText(Integer.toString(character.getKarma()));
        nuyenVal.setText(Integer.toString(character.getNuyen()));
        charName.setText(character.getName());

        weaponContainer.removeAllViews();
        if(character.packingHeat()){
            weaponDefaultTxt.setVisibility(View.GONE);
            weaponView = new EquipmentViewController(getLayoutInflater()).getWeaponView(getLayoutInflater(), weaponContainer, character.getEquippedWeapon());
            ImageButton btnMenu = (ImageButton) weaponView.findViewById(R.id.weapon_menu);
            TextView equippedTitle = (TextView) weaponView.findViewById(R.id.equipped_title);
            TextView equippedStatus = (TextView) weaponView.findViewById(R.id.weapon_equipped);
            btnMenu.setVisibility(View.GONE);
            equippedTitle.setVisibility(View.GONE);
            equippedStatus.setVisibility(View.GONE);
            weaponContainer.addView(weaponView);
        }
        else{
            weaponDefaultTxt.setVisibility(View.VISIBLE);
        }
    }

    public void expandCharacter(View view) {
        Intent characterCard = new Intent(CharacterSheet.this, CharacterCard.class);
        CharacterSheet.this.startActivityForResult(characterCard, 1);
    }

    public void expandSkills(View view) {
        Intent skillsCard = new Intent(CharacterSheet.this, SkillsCardActivity.class);
        CharacterSheet.this.startActivityForResult(skillsCard, 2);
    }

    public void expandEquipment(View view) {
        Intent equipmentCard = new Intent(CharacterSheet.this, EquipmentActivity.class);
        CharacterSheet.this.startActivityForResult(equipmentCard, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        loadValues();
    }

}
