package com.softwareengineering.ttu.shadowruncharactermanager;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


public class CharacterSheet extends AppCompatActivity {
    Character character = Character.getInstance();
    CharacterSelector characterSelector = CharacterSelector.getInstance();
    SkillViewController skillViewController;

    FloatingActionButton btnSave;

    ActionBarDrawerToggle drawerToggle;

    TextView pHealth;
    TextView sHealth;
    SeekBar pHealthBar;
    SeekBar sHealthBar;
    ImageView picture;
    TextView charName;
    TextView karmaVal;
    TextView nuyenVal;
    ImageLoader mainLoader;

    LinearLayout skillContainer;

    TextView weaponDefaultTxt;
    LinearLayout weaponContainer;
    View weaponView;

    DrawerLayout drawer;
    LinearLayout drawerContainer;
    LinearLayout btnNewChar;

    FileSaver fileSaver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        skillViewController = new SkillViewController(this, character, getLayoutInflater());

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        characterSelector.init(this, drawer);

        fileSaver = new FileSaver();

        fileSaver.loadCharacter("character0.txt", this);
        AttributeSkillBridge.setCharacter();

        btnSave = (FloatingActionButton) findViewById(R.id.FAB);

        skillContainer = (LinearLayout)findViewById(R.id.skill_container);

        picture = (ImageView) findViewById(R.id.character_image);
        pHealth = (TextView) findViewById(R.id.physical_health_value);
        pHealthBar = (SeekBar) findViewById(R.id.physical_health_bar);
        sHealth = (TextView) findViewById(R.id.stun_health_value);
        sHealthBar = (SeekBar) findViewById(R.id.stun_health_bar);
        karmaVal = (TextView) findViewById(R.id.karma_value);
        nuyenVal = (TextView) findViewById(R.id.nuyen_value);
        charName = (TextView) findViewById(R.id.character_name);
        mainLoader = ImageLoader.getInstance();

        drawerContainer = (LinearLayout) findViewById(R.id.character_drawer);

        drawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawer){
                super.onDrawerOpened(drawer);

                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawer){
                super.onDrawerClosed(drawer);

                loadValues();
                invalidateOptionsMenu();
            }
        };


        drawer.addDrawerListener(drawerToggle);

        btnNewChar = (LinearLayout) findViewById(R.id.btn_new_character);
        btnNewChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View pLayout = getLayoutInflater().inflate(R.layout.popup_confirm, drawerContainer, false);
                Button btnOK = (Button) pLayout.findViewById(R.id.btn_OK);
                Button btnCancel = (Button) pLayout.findViewById(R.id.btn_cancel);
                TextView title = (TextView) pLayout.findViewById(R.id.title);
                TextView txt = (TextView) pLayout.findViewById(R.id.confirm_text);
                final EditText editText = (EditText) pLayout.findViewById(R.id.confirm_edit);

                txt.setVisibility(View.GONE);
                editText.setVisibility(View.VISIBLE);
                editText.setHint("Character Name");
                title.setText("Create Character");

                final PopupWindow pWindow = new PopupWindow(
                        pLayout,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        true);
                pWindow.setBackgroundDrawable(new ColorDrawable(0x80000000));
                pWindow.setAnimationStyle(android.R.style.Animation_Toast);

                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!editText.getText().toString().trim().equals("")) {
                            characterSelector.addCharacter(editText.getText().toString().trim(), drawerContainer);
                            pWindow.dismiss();
                            drawer.closeDrawers();
                        }
                    }
                });

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pWindow.dismiss();
                    }
                });

                pWindow.showAtLocation(drawer, Gravity.CENTER, 0, 0);
            }
        });

        weaponDefaultTxt = (TextView) findViewById(R.id.no_equipped_weapon);
        weaponContainer = (LinearLayout) findViewById(R.id.weapon_view_container);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .build();
        ImageLoader.getInstance().init(config);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character = Character.getInstance();
                characterSelector.save(character);
                Toast.makeText(CharacterSheet.this, character.getName() + " saved", Toast.LENGTH_SHORT).show();
            }
        });

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

        loadValues();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadValues() {
        character = Character.getInstance();
        CharacterSelector characterSelector = CharacterSelector.getInstance();
        skillViewController = new SkillViewController(this, character, getLayoutInflater());

        drawerContainer.removeAllViews();
        for (int i = 0; i < characterSelector.size(); i++) {
            drawerContainer.addView(characterSelector.fillDrawer(drawerContainer, i));
        }

        skillContainer.removeAllViews();
        for(int i = 0; i < 50; i++){
            skillContainer.addView(skillViewController.getSkillView(skillContainer, i, karmaVal, true));
        }

        mainLoader.displayImage(character.getImageURI(), picture);
        karmaVal.setText(Integer.toString(character.getKarma()));
        nuyenVal.setText(Integer.toString(character.getNuyen()));
        charName.setText(character.getName());

        int maxPHealth = (int) (Math.ceil((double) character.getAttribute("Body").getRating() / 2));
        int maxSHealth = (int) (Math.ceil((double) character.getAttribute("Willpower").getRating() / 2));
        pHealthBar.setMax(8 + maxPHealth);
        sHealthBar.setMax(8 + maxSHealth);

        pHealthBar.setProgress(pHealthBar.getMax());
        sHealthBar.setProgress(sHealthBar.getMax());

        pHealth.setText(String.valueOf(pHealthBar.getMax()) + "/" + String.valueOf(pHealthBar.getMax()));
        sHealth.setText(String.valueOf(sHealthBar.getMax()) + "/" + String.valueOf(sHealthBar.getMax()));

        weaponContainer.removeAllViews();
        if (character.packingHeat()) {
            weaponDefaultTxt.setVisibility(View.GONE);
            weaponView = new EquipmentViewController(getLayoutInflater()).getWeaponViewSummary(getLayoutInflater(), weaponContainer, character.getEquippedWeapon());
            weaponContainer.addView(weaponView);
        } else {
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
