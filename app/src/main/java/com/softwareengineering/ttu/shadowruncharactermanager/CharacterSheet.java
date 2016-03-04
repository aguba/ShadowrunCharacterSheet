package com.softwareengineering.ttu.shadowruncharactermanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.net.URI;

public class CharacterSheet extends AppCompatActivity {

    TextView pHealth;
    TextView sHealth;
    SeekBar pHealthBar;
    SeekBar sHealthBar;
    public static ImageView picture;
    public static TextView charName;
    public static ImageLoader mainLoader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);
        initialize();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
            .build();
        ImageLoader.getInstance().init(config);

        Character.getInstance().setName("Orion");
        charName.setText(Character.getInstance().getName());

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

    void initialize() {
        picture = (ImageView) findViewById(R.id.character_image);
        pHealth = (TextView) findViewById(R.id.physical_health_value);
        pHealthBar = (SeekBar) findViewById(R.id.physical_health_bar);
        sHealth = (TextView) findViewById(R.id.stun_health_value);
        sHealthBar = (SeekBar) findViewById(R.id.stun_health_bar);
        charName = (TextView) findViewById(R.id.character_name);
        mainLoader = ImageLoader.getInstance();
    }

    public void expandCharacter(View view){
        Intent characterCard = new Intent(CharacterSheet.this, CharacterCard.class);
        CharacterSheet.this.startActivity(characterCard);
    }

    public void expandSkills(View view){
        Intent skillsCard = new Intent(CharacterSheet.this, SkillsCardActivity.class);
        CharacterSheet.this.startActivity(skillsCard);
    }

    public void expandEquipment(View view){
        Intent equipmentCard = new Intent(CharacterSheet.this, EquipmentActivity.class);
        CharacterSheet.this.startActivity(equipmentCard);
    }

}
