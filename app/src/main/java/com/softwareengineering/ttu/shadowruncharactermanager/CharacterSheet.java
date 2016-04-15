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

//        character.load(this);
        AttributeSkillBridge.setCharacter();

        picture = (ImageView) findViewById(R.id.character_image);
        pHealth = (TextView) findViewById(R.id.physical_health_value);
        pHealthBar = (SeekBar) findViewById(R.id.physical_health_bar);
        sHealth = (TextView) findViewById(R.id.stun_health_value);
        sHealthBar = (SeekBar) findViewById(R.id.stun_health_bar);
        karmaVal = (TextView) findViewById(R.id.karma_value);
        nuyenVal = (TextView) findViewById(R.id.nuyen_value);
        charName = (TextView) findViewById(R.id.character_name);
        mainLoader = ImageLoader.getInstance();

        TextView akPool = (TextView) findViewById(R.id.academic_knowledge_pool);
        akPool.setText(Integer.toString(character.getSkill("Academic Knowledge").getDicepool()));
        TextView arcaPool = (TextView) findViewById(R.id.arcana_pool);
        arcaPool.setText(Integer.toString(character.getSkill("Arcana").getDicepool()));
        TextView arcPool = (TextView) findViewById(R.id.archery_pool);
        arcPool.setText(Integer.toString(character.getSkill("Archery").getDicepool()));
        TextView armPool = (TextView) findViewById(R.id.armorer_pool);
        armPool.setText(Integer.toString(character.getSkill("Armorer").getDicepool()));
        TextView artPool = (TextView) findViewById(R.id.artisan_pool);
        artPool.setText(Integer.toString(character.getSkill("Artisan").getDicepool()));
        TextView autoPool = (TextView) findViewById(R.id.automatics_pool);
        autoPool.setText(Integer.toString(character.getSkill("Automatics").getDicepool()));
        TextView bladePool = (TextView) findViewById(R.id.blades_pool);
        bladePool.setText(Integer.toString(character.getSkill("Blades").getDicepool()));
        TextView chemPool = (TextView) findViewById(R.id.chemistry_pool);
        chemPool.setText(Integer.toString(character.getSkill("Chemistry").getDicepool()));
        TextView climbPool = (TextView) findViewById(R.id.climbing_pool);
        climbPool.setText(Integer.toString(character.getSkill("Climbing").getDicepool()));
        TextView clubPool = (TextView) findViewById(R.id.clubs_pool);
        clubPool.setText(Integer.toString(character.getSkill("Clubs").getDicepool()));
        TextView comPool = (TextView) findViewById(R.id.computer_pool);
        comPool.setText(Integer.toString(character.getSkill("Computer").getDicepool()));
        TextView conPool = (TextView) findViewById(R.id.con_pool);
        conPool.setText(Integer.toString(character.getSkill("Con").getDicepool()));
        TextView dsPool = (TextView) findViewById(R.id.data_search_pool);
        dsPool.setText(Integer.toString(character.getSkill("Data Search").getDicepool()));
        TextView demPool = (TextView) findViewById(R.id.demolitions_pool);
        demPool.setText(Integer.toString(character.getSkill("Demolitions").getDicepool()));
        TextView disPool = (TextView) findViewById(R.id.disguise_pool);
        disPool.setText(Integer.toString(character.getSkill("Disguise").getDicepool()));
        TextView divPool = (TextView) findViewById(R.id.diving_pool);
        divPool.setText(Integer.toString(character.getSkill("Diving").getDicepool()));
        TextView dodPool = (TextView) findViewById(R.id.dodge_pool);
        dodPool.setText(Integer.toString(character.getSkill("Dodge").getDicepool()));
        TextView encPool = (TextView) findViewById(R.id.enchanting_pool);
        encPool.setText(Integer.toString(character.getSkill("Enchanting").getDicepool()));
        TextView eaPool = (TextView) findViewById(R.id.escape_artist_pool);
        eaPool.setText(Integer.toString(character.getSkill("Escape Artist").getDicepool()));
        TextView etiPool = (TextView) findViewById(R.id.etiquette_pool);
        etiPool.setText(Integer.toString(character.getSkill("Etiquette").getDicepool()));
        TextView faPool = (TextView) findViewById(R.id.first_aid_pool);
        faPool.setText(Integer.toString(character.getSkill("First Aid").getDicepool()));
        TextView forgPool = (TextView) findViewById(R.id.forgery_pool);
        forgPool.setText(Integer.toString(character.getSkill("Forgery").getDicepool()));
        TextView gunPool = (TextView) findViewById(R.id.gunnery_pool);
        gunPool.setText(Integer.toString(character.getSkill("Gunnery").getDicepool()));
        TextView gymPool = (TextView) findViewById(R.id.gymnastics_pool);
        gymPool.setText(Integer.toString(character.getSkill("Gymnastics").getDicepool()));
        TextView hackPool = (TextView) findViewById(R.id.hacking_pool);
        hackPool.setText(Integer.toString(character.getSkill("Hacking").getDicepool()));
        TextView hwPool = (TextView) findViewById(R.id.heavy_weapons_pool);
        hwPool.setText(Integer.toString(character.getSkill("Heavy Weapons").getDicepool()));
        TextView infilPool = (TextView) findViewById(R.id.infiltration_pool);
        infilPool.setText(Integer.toString(character.getSkill("Infiltration").getDicepool()));
        TextView instPool = (TextView) findViewById(R.id.instruction_pool);
        instPool.setText(Integer.toString(character.getSkill("Instruction").getDicepool()));
        TextView ikPool = (TextView) findViewById(R.id.interests_knowledge_pool);
        ikPool.setText(Integer.toString(character.getSkill("Interests Knowledge").getDicepool()));
        TextView intPool = (TextView) findViewById(R.id.intimidation_pool);
        intPool.setText(Integer.toString(character.getSkill("Intimidation").getDicepool()));
        TextView leadPool = (TextView) findViewById(R.id.leadership_pool);
        leadPool.setText(Integer.toString(character.getSkill("Leadership").getDicepool()));
        TextView lockPool = (TextView) findViewById(R.id.locksmith_pool);
        lockPool.setText(Integer.toString(character.getSkill("Locksmith").getDicepool()));
        TextView longPool = (TextView) findViewById(R.id.longarms_pool);
        longPool.setText(Integer.toString(character.getSkill("Longarms").getDicepool()));
        TextView navPool = (TextView) findViewById(R.id.navigation_pool);
        navPool.setText(Integer.toString(character.getSkill("Navigation").getDicepool()));
        TextView negPool = (TextView) findViewById(R.id.negotiation_pool);
        negPool.setText(Integer.toString(character.getSkill("Negotiation").getDicepool()));
        TextView palmPool = (TextView) findViewById(R.id.palming_pool);
        palmPool.setText(Integer.toString(character.getSkill("Palming").getDicepool()));
        TextView paraPool = (TextView) findViewById(R.id.parachuting_pool);
        paraPool.setText(Integer.toString(character.getSkill("Parachuting").getDicepool()));
        TextView perPool = (TextView) findViewById(R.id.perception_pool);
        perPool.setText(Integer.toString(character.getSkill("Perception").getDicepool()));
        TextView pgPool = (TextView) findViewById(R.id.pilot_ground_craft_pool);
        pgPool.setText(Integer.toString(character.getSkill("Pilot Ground Craft").getDicepool()));
        TextView pwPool = (TextView) findViewById(R.id.pilot_watercraft_pool);
        pwPool.setText(Integer.toString(character.getSkill("Pilot Watercraft").getDicepool()));
        TextView pistPool = (TextView) findViewById(R.id.pistols_pool);
        pistPool.setText(Integer.toString(character.getSkill("Pistols").getDicepool()));
        TextView pkPool = (TextView) findViewById(R.id.professional_knowledge_pool);
        pkPool.setText(Integer.toString(character.getSkill("Professional Knowledge").getDicepool()));
        TextView runPool = (TextView) findViewById(R.id.running_pool);
        runPool.setText(Integer.toString(character.getSkill("Running").getDicepool()));
        TextView shadowPool = (TextView) findViewById(R.id.shadowing_pool);
        shadowPool.setText(Integer.toString(character.getSkill("Shadowing").getDicepool()));
        TextView skPool = (TextView) findViewById(R.id.street_knowledge_pool);
        skPool.setText(Integer.toString(character.getSkill("Street Knowledge").getDicepool()));
        TextView survPool = (TextView) findViewById(R.id.survival_pool);
        survPool.setText(Integer.toString(character.getSkill("Survival").getDicepool()));
        TextView swimPool = (TextView) findViewById(R.id.swimming_pool);
        swimPool.setText(Integer.toString(character.getSkill("Swimming").getDicepool()));
        TextView twPool = (TextView) findViewById(R.id.throwing_weapons_pool);
        twPool.setText(Integer.toString(character.getSkill("Throwing Weapons").getDicepool()));
        TextView trackPool = (TextView) findViewById(R.id.tracking_pool);
        trackPool.setText(Integer.toString(character.getSkill("Tracking").getDicepool()));
        TextView ucPool = (TextView) findViewById(R.id.unarmed_combat_pool);
        ucPool.setText(Integer.toString(character.getSkill("Unarmed Combat").getDicepool()));

        weaponDefaultTxt = (TextView) findViewById(R.id.no_equipped_weapon);
        weaponContainer = (LinearLayout) findViewById(R.id.weapon_view_container);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .build();
        ImageLoader.getInstance().init(config);

        loadValues();

        pHealth.setText(String.valueOf(pHealthBar.getMax()) + "/" + String.valueOf(pHealthBar.getMax()));
        sHealth.setText(String.valueOf(sHealthBar.getMax()) + "/" + String.valueOf(sHealthBar.getMax()));

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

        int maxPHealth = (int)(Math.ceil((double)character.getAttribute("Body").getRating()/2));
        int maxSHealth = (int)(Math.ceil((double)character.getAttribute("Willpower").getRating()/2));
        pHealthBar.setMax(8 + maxPHealth);
        sHealthBar.setMax(8 + maxSHealth);

        weaponContainer.removeAllViews();
        if(character.packingHeat()){
            weaponDefaultTxt.setVisibility(View.GONE);
            weaponView = new EquipmentViewController(getLayoutInflater()).getWeaponViewSummary(getLayoutInflater(), weaponContainer, character.getEquippedWeapon());
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
//        character.save(this);
        loadValues();
    }

}
