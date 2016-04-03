package com.softwareengineering.ttu.shadowruncharactermanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
    ImageButton btnAddKarma;
    ImageButton btnSubKarma;
    ImageButton btnAddNuyen;
    ImageButton btnSubNuyen;
    ImageButton btnDoneKarma;
    ImageButton btnDoneNuyen;
    ImageView picture;
    ImageView addImage;
    ImageLoader loadPicture = ImageLoader.getInstance();

    String imageURI;
    String karmaEditMode;
    String nuyenEditMode;

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
        btnDoneKarma = (ImageButton) findViewById(R.id.btn_done_karma);
        btnDoneNuyen = (ImageButton) findViewById(R.id.btn_done_nuyen);
        picture = (ImageView) findViewById(R.id.character_image2);
        addImage = (ImageView) findViewById(R.id.character_image_add);

        loadPicture.displayImage(imageURI, picture);
        charName.setText(character.getName());
        charKarma.setText(Integer.toString(character.getKarma()));
        charNuyen.setText(Integer.toString(character.getNuyen()));

        btnAddKarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                karmaEditMode = "add";
                editNuyenKarma("Karma");
            }
        });
        btnSubKarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                karmaEditMode = "sub";
                editNuyenKarma("Karma");
            }
        });
        btnAddNuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuyenEditMode = "add";
                editNuyenKarma("Nuyen");
            }
        });
        btnSubNuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nuyenEditMode = "sub";
                editNuyenKarma("Nuyen");
            }
        });

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

    public void editNuyenKarma(String item) {
        if (item.equals("Karma")) {
            charKarma.setVisibility(View.GONE);
            editCharKarma.setVisibility(View.VISIBLE);
            editCharKarma.setText("");
            btnAddKarma.setVisibility(View.GONE);
            btnSubKarma.setVisibility(View.GONE);
            btnDoneKarma.setVisibility(View.VISIBLE);
        } else if (item.equals("Nuyen")) {
            charNuyen.setVisibility(View.GONE);
            editCharNuyen.setVisibility(View.VISIBLE);
            editCharNuyen.setText("");
            btnAddNuyen.setVisibility(View.GONE);
            btnSubNuyen.setVisibility(View.GONE);
            btnDoneNuyen.setVisibility(View.VISIBLE);
        }
    }

    public void editKarmaOff(View view) {
        int karmaAmount;
        if (editCharKarma.getText().toString().equals("")) {
            karmaAmount = 0;
        } else {
            karmaAmount = Integer.parseInt(editCharKarma.getText().toString());
        }

        if (karmaEditMode.equals("add")) {
            character.addKarma(karmaAmount);
        } else if (karmaEditMode.equals("sub")) {
            character.subKarma(karmaAmount);
        }

        btnDoneKarma.setVisibility(View.GONE);
        btnAddKarma.setVisibility(View.VISIBLE);
        btnSubKarma.setVisibility(View.VISIBLE);
        editCharKarma.setVisibility(View.GONE);
        charKarma.setText(Integer.toString(character.getKarma()));
        charKarma.setVisibility(View.VISIBLE);
    }

    public void editNuyenOff(View view) {
        int nuyenAmount;
        if (editCharNuyen.getText().toString().equals("")) {
            nuyenAmount = 0;
        } else {
            nuyenAmount = Integer.parseInt(editCharNuyen.getText().toString());
        }

        if (nuyenEditMode.equals("add")) {
            character.addNuyen(nuyenAmount);
        } else if (nuyenEditMode.equals("sub")) {
            character.subNuyen(nuyenAmount);
        }

        btnDoneNuyen.setVisibility(View.GONE);
        btnAddNuyen.setVisibility(View.VISIBLE);
        btnSubNuyen.setVisibility(View.VISIBLE);
        editCharNuyen.setVisibility(View.GONE);
        charNuyen.setText(Integer.toString(character.getNuyen()));
        charNuyen.setVisibility(View.VISIBLE);
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
