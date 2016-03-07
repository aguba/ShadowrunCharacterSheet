package com.softwareengineering.ttu.shadowruncharactermanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

public class CharacterCard extends AppCompatActivity {
    Character character = Character.getInstance();

    TextView charName;
    TextView charKarma;
    TextView charNuyen;
    EditText editCharName;
    EditText editCharKarma;
    EditText editCharNuyen;
    ImageButton btnEditCharacter;
    ImageButton btnDoneEditCharacter;
    ImageButton btnSaveCharacter;
    ImageView picture;
    ImageView addImage;
    ImageLoader loadPicture = ImageLoader.getInstance();

    String imageURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_card);

        imageURI = character.getImageURI();

        charName = (TextView) findViewById(R.id.character_name2);
        charKarma = (TextView) findViewById(R.id.karma2_value);
        charNuyen = (TextView) findViewById(R.id.nuyen2_value);
        editCharName = (EditText) findViewById(R.id.character_name_edit);
        editCharKarma = (EditText) findViewById(R.id.karma2_value_edit);
        editCharNuyen = (EditText) findViewById(R.id.nuyen2_value_edit);
        btnEditCharacter = (ImageButton) findViewById(R.id.btn_edit_character);
        btnDoneEditCharacter = (ImageButton) findViewById(R.id.btn_done_edit_character);
        btnSaveCharacter = (ImageButton) findViewById(R.id.btn_save_character);
        picture = (ImageView) findViewById(R.id.character_image2);
        addImage = (ImageView) findViewById(R.id.character_image_add);

        loadPicture.displayImage(imageURI, picture);
        btnSaveCharacter.setEnabled(false);
        charName.setText(character.getName());
        charKarma.setText(Integer.toString(character.getKarma()));
        charNuyen.setText(Integer.toString(character.getNuyen()));
    }

    public void editOn(View view){
        addImage.setVisibility(View.VISIBLE);
        btnEditCharacter.setVisibility(View.GONE);
        btnDoneEditCharacter.setVisibility(View.VISIBLE);
        charName.setVisibility(View.GONE);
        charKarma.setVisibility(View.GONE);
        charNuyen.setVisibility(View.GONE);
        editCharName.setVisibility(View.VISIBLE);
        editCharKarma.setVisibility(View.VISIBLE);
        editCharNuyen.setVisibility(View.VISIBLE);
        editCharName.setText(charName.getText().toString());
        editCharKarma.setText(charKarma.getText());
        editCharNuyen.setText(charNuyen.getText());
    }

    public void editOff(View view){
        addImage.setVisibility(View.GONE);
        btnEditCharacter.setVisibility(View.VISIBLE);
        btnSaveCharacter.setEnabled(true);
        btnDoneEditCharacter.setVisibility(View.GONE);
        charName.setVisibility(View.VISIBLE);
        charKarma.setVisibility(View.VISIBLE);
        charNuyen.setVisibility(View.VISIBLE);
        editCharName.setVisibility(View.GONE);
        editCharKarma.setVisibility(View.GONE);
        editCharNuyen.setVisibility(View.GONE);
        charName.setText(editCharName.getText().toString());
        charKarma.setText(editCharKarma.getText().toString());
        charNuyen.setText(editCharNuyen.getText().toString());
    }

    public void saveCharacter(View view){
        character.setName(charName.getText().toString());
        CharacterSheet.charName.setText(character.getName());

        character.setImageURI(imageURI);
        CharacterSheet.mainLoader.displayImage(character.getImageURI(), CharacterSheet.picture);

        character.setKarma(Integer.parseInt(charKarma.getText().toString()));
        character.setNuyen(Integer.parseInt(charNuyen.getText().toString()));
        CharacterSheet.karmaVal.setText(Integer.toString(character.getKarma()));
        CharacterSheet.nuyenVal.setText(Integer.toString(character.getNuyen()));

        Toast saveMessage = Toast.makeText(getApplicationContext(), "Changes saved", Toast.LENGTH_SHORT);
        saveMessage.show();
    }

    public void chooseProfilePic(View view){
        Intent profilePicker = new Intent(Intent.ACTION_PICK);
        profilePicker.setType("image/*");
        CharacterCard.this.startActivityForResult(profilePicker, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                imageURI = data.getData().toString();

                loadPicture.displayImage(imageURI, picture);
            }
        }
    }

}
