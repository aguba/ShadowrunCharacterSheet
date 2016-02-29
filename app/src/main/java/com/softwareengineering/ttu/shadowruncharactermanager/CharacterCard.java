package com.softwareengineering.ttu.shadowruncharactermanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class CharacterCard extends AppCompatActivity {
    TextView charName;
    EditText editCharName;
    ImageButton btnEditCharacter;
    ImageButton btnDoneEditCharacter;
    ImageButton btnSaveCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_card);

        charName = (TextView) findViewById(R.id.character_name2);
        editCharName = (EditText) findViewById(R.id.character_name_edit);
        btnEditCharacter = (ImageButton) findViewById(R.id.btn_edit_character);
        btnDoneEditCharacter = (ImageButton) findViewById(R.id.btn_done_edit_character);
        btnSaveCharacter = (ImageButton) findViewById(R.id.btn_save_character);

        editCharName.setVisibility(View.GONE);
        btnDoneEditCharacter.setVisibility(View.GONE);
        btnSaveCharacter.setEnabled(false);
        charName.setText(Character.getInstance().getName());
    }

    public void editOn(View view){
        btnEditCharacter.setVisibility(View.GONE);
        btnDoneEditCharacter.setVisibility(View.VISIBLE);
        charName.setVisibility(View.GONE);
        editCharName.setVisibility(View.VISIBLE);
        editCharName.setText(charName.getText().toString());
    }

    public void editOff(View view){
        btnEditCharacter.setVisibility(View.VISIBLE);
        btnSaveCharacter.setEnabled(true);
        btnDoneEditCharacter.setVisibility(View.GONE);
        charName.setVisibility(View.VISIBLE);
        editCharName.setVisibility(View.GONE);
        charName.setText(editCharName.getText().toString());
    }

    public void saveCharacter(View view){
        Character.getInstance().setName(charName.getText().toString());
        CharacterSheet.charName.setText(Character.getInstance().getName());
        Toast saveMessage = Toast.makeText(getApplicationContext(), "Changes saved", Toast.LENGTH_SHORT);
        saveMessage.show();
    }

}
