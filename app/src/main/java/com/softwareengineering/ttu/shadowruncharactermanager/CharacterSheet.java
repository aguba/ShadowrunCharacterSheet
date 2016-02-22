package com.softwareengineering.ttu.shadowruncharactermanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;

public class CharacterSheet extends AppCompatActivity {

    TextView pHealth;
    TextView sHealth;
    SeekBar pHealthBar;
    SeekBar sHealthBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);
        initialize();
/*
        TableRow r = (TableRow) findViewById(R.id.table_row_1);
        r.setVisibility(View.GONE);
        */

        pHealthBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pHealth.setText(String.valueOf(progress));
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
                sHealth.setText(String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    void initialize(){
        pHealth = (TextView) findViewById(R.id.physical_health_value);
        pHealthBar = (SeekBar) findViewById(R.id.physical_health_bar);
        sHealth = (TextView) findViewById(R.id.stun_health_value);
        sHealthBar = (SeekBar) findViewById(R.id.stun_health_bar);
    }



}
