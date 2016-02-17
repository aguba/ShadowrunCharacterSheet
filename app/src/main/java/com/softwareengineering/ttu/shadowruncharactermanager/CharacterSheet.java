package com.softwareengineering.ttu.shadowruncharactermanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;

public class CharacterSheet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_sheet);
/*
        TableRow r = (TableRow) findViewById(R.id.table_row_1);
        r.setVisibility(View.GONE);
        */
    }

}
