package com.softwareengineering.ttu.shadowruncharactermanager;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

public class SkillsCardActivity extends AppCompatActivity {
    Character character = Character.getInstance();
    SkillViewController skillViewController;

    LinearLayout skillContainer;
    TextView karma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills_card);

        skillViewController = new SkillViewController(this, character, getLayoutInflater());

        skillContainer = (LinearLayout)findViewById(R.id.skill_container);
        karma = (TextView)findViewById(R.id.karma);

        karma.setText(Integer.toString(character.getKarma()));

        for(int i = 0; i < 50; i++){
            View skillView = skillViewController.getSkillView(skillContainer, i, karma, false);
            skillContainer.addView(skillView);
        }

    }

}
