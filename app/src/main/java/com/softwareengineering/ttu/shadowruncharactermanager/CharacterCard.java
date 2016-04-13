package com.softwareengineering.ttu.shadowruncharactermanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    ImageButton btnAddKarma;
    ImageButton btnSubKarma;
    ImageButton btnAddNuyen;
    ImageButton btnSubNuyen;
    ImageButton btnEditBio;
    ImageButton btnDoneBio;
    ImageView picture;
    ImageView addImage;
    ImageLoader loadPicture = ImageLoader.getInstance();
    LinearLayout bioContainer;
    TextView bio;
    EditText editBio;

    String imageURI;
    boolean bioIsExpanded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_card);

        imageURI = character.getImageURI();

        charName = (TextView) findViewById(R.id.character_name2);
        charKarma = (TextView) findViewById(R.id.karma_value);
        charNuyen = (TextView) findViewById(R.id.nuyen_value);
        editCharName = (EditText) findViewById(R.id.character_name_edit);
        editCharKarma = (EditText) findViewById(R.id.karma_value_edit);
        editCharNuyen = (EditText) findViewById(R.id.nuyen_value_edit);
        btnEditCharacter = (ImageButton) findViewById(R.id.btn_edit_character);
        btnDoneEditCharacter = (ImageButton) findViewById(R.id.btn_done_edit_character);
        btnAddKarma = (ImageButton) findViewById(R.id.btn_add_karma);
        btnSubKarma = (ImageButton) findViewById(R.id.btn_sub_karma);
        btnAddNuyen = (ImageButton) findViewById(R.id.btn_add_nuyen);
        btnSubNuyen = (ImageButton) findViewById(R.id.btn_sub_nuyen);
        picture = (ImageView) findViewById(R.id.character_image2);
        addImage = (ImageView) findViewById(R.id.character_image_add);
        bioContainer = (LinearLayout) findViewById(R.id.bio_container);
        btnEditBio = (ImageButton) findViewById(R.id.btn_edit_bio);
        btnDoneBio = (ImageButton) findViewById(R.id.btn_done_bio);
        bio = (TextView) findViewById(R.id.biography_text);
        editBio = (EditText) findViewById(R.id.biography_edit);

        final ImageButton btnEditKarma = (ImageButton) findViewById(R.id.btn_karma_edit);
        final ImageButton btnEditNuyen = (ImageButton) findViewById(R.id.btn_nuyen_edit);

        final LinearLayout karmaPanel = (LinearLayout) findViewById(R.id.karma_btn_panel);
        final LinearLayout nuyenPanel = (LinearLayout) findViewById(R.id.nuyen_btn_panel);

        LinearLayout attributeContainer = (LinearLayout) findViewById(R.id.attribute_container);

        AttributeViewController avc = new AttributeViewController(getLayoutInflater(), this);

        bio.setText(character.getBio());
        bioIsExpanded = false;

        loadPicture.displayImage(imageURI, picture);
        charName.setText(character.getName());
        charKarma.setText(Integer.toString(character.getKarma()));
        charNuyen.setText(Integer.toString(character.getNuyen()));

        btnEditKarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNuyenKarma(charKarma, editCharKarma, karmaPanel, btnEditKarma);
            }
        });

        btnEditNuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNuyenKarma(charNuyen, editCharNuyen, nuyenPanel, btnEditNuyen);
            }
        });

        btnAddKarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character.addKarma(Integer.parseInt(editCharKarma.getText().toString()));
                doneNuyenKarma(charKarma, editCharKarma, karmaPanel, btnEditKarma, character.getKarma());
            }
        });
        btnSubKarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character.subKarma(Integer.parseInt(editCharKarma.getText().toString()));
                doneNuyenKarma(charKarma, editCharKarma, karmaPanel, btnEditKarma, character.getKarma());
            }
        });
        btnAddNuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character.addNuyen(Integer.parseInt(editCharNuyen.getText().toString()));
                doneNuyenKarma(charNuyen, editCharNuyen, nuyenPanel, btnEditNuyen, character.getNuyen());
            }
        });
        btnSubNuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character.subNuyen(Integer.parseInt(editCharNuyen.getText().toString()));
                doneNuyenKarma(charNuyen, editCharNuyen, nuyenPanel, btnEditNuyen, character.getNuyen());
            }
        });

        for(int i=0; i<9; i++){
            View attView = avc.getAttributeView(attributeContainer, i, charKarma);
            attributeContainer.addView(attView);
        }

    }

    public void expandBio(View view){
        if(!bioIsExpanded){
            bioContainer.setVisibility(View.VISIBLE);
            bioIsExpanded = true;
        }
        else{
            bioContainer.setVisibility(View.GONE);
            bioIsExpanded = false;
        }
    }

    public void editBioOn(View view){
        editBio.setText(bio.getText());

        btnEditBio.setVisibility(View.GONE);
        btnDoneBio.setVisibility(View.VISIBLE);

        bio.setVisibility(View.GONE);
        editBio.setVisibility(View.VISIBLE);
    }

    public void editBioOff(View view){
        character.setBio(editBio.getText().toString());
        bio.setText(character.getBio());

        btnDoneBio.setVisibility(View.GONE);
        btnEditBio.setVisibility(View.VISIBLE);

        editBio.setVisibility(View.GONE);
        bio.setVisibility(View.VISIBLE);
    }

    public void editOn(View view) {
        addImage.setVisibility(View.VISIBLE);
        btnEditCharacter.setVisibility(View.GONE);
        btnDoneEditCharacter.setVisibility(View.VISIBLE);
        charName.setVisibility(View.GONE);
        editCharName.setVisibility(View.VISIBLE);
        editCharName.setText(charName.getText().toString());
    }

    public void editOff(View view) {
        if (editCharName.getText().toString().trim().equals("")) {
            Toast blankFields = Toast.makeText(getApplicationContext(), "Character name cannot be blank", Toast.LENGTH_SHORT);
            blankFields.show();
        } else {
            addImage.setVisibility(View.GONE);
            btnDoneEditCharacter.setVisibility(View.GONE);
            btnEditCharacter.setVisibility(View.VISIBLE);
            character.setName(editCharName.getText().toString().trim());
            character.setImageURI(imageURI);
            editCharName.setVisibility(View.GONE);
            charName.setText(character.getName());
            charName.setVisibility(View.VISIBLE);
        }
    }

    public void chooseProfilePic(View view) {
        Intent profilePicker = new Intent(Intent.ACTION_PICK);
        profilePicker.setType("image/*");
        CharacterCard.this.startActivityForResult(profilePicker, 1);
    }

    public void editNuyenKarma(TextView textView, EditText editText, LinearLayout btnPanel, ImageButton btnEdit) {
        textView.setVisibility(View.GONE);
        editText.setVisibility(View.VISIBLE);
        editText.setText("");

        btnEdit.setVisibility(View.GONE);
        btnPanel.setVisibility(View.VISIBLE);
    }

    public void doneNuyenKarma(TextView textView, EditText editText, LinearLayout btnPanel, ImageButton btnEdit, int amount){
        textView.setText(Integer.toString(amount));

        editText.setVisibility(View.GONE);
        textView.setVisibility(View.VISIBLE);

        btnPanel.setVisibility(View.GONE);
        btnEdit.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                imageURI = data.getData().toString();
                loadPicture.displayImage(imageURI, picture);
            }
        }
    }

}
