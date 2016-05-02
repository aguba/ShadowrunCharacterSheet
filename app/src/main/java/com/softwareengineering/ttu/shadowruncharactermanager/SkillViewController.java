package com.softwareengineering.ttu.shadowruncharactermanager;

import android.content.Context;
import android.graphics.Interpolator;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rj on 5/1/2016.
 */
public class SkillViewController {

    public SkillViewController(Context context, Character character, LayoutInflater inflater){
        mContext = context;
        mCharacter = character;
        mInflater = inflater;
    }

    private Context mContext;
    private Character mCharacter;
    private LayoutInflater mInflater;

    public View getSkillView(final ViewGroup root, int index, final TextView karmaView, boolean hideMode){
        View layout = mInflater.inflate(R.layout.skill_list_layout, root, false);
        final DiceRoller diceRoller = new DiceRoller(layout, mInflater);
        final Skill skill = mCharacter.getSkillByIndex(index);
        final String skillName = skill.getName();

        final TextView name = (TextView) layout.findViewById(R.id.skill_name);
        final TextView rtg = (TextView) layout.findViewById(R.id.rating);
        final TextView dPool = (TextView) layout.findViewById(R.id.dicepool);
        final ImageButton btnRoll = (ImageButton) layout.findViewById(R.id.btn_roll_dice);
        ImageButton btnUp = (ImageButton) layout.findViewById(R.id.btn_skill_up);
        final CheckBox checkBox = (CheckBox)layout.findViewById(R.id.checkbox);

        final View confirmLayout = mInflater.inflate(R.layout.popup_confirm, null, false);
        final TextView confirmText = (TextView) confirmLayout.findViewById(R.id.confirm_text);
        final Button btnCancel = (Button) confirmLayout.findViewById(R.id.btn_cancel);
        final Button btnOk = (Button) confirmLayout.findViewById(R.id.btn_OK);

        diceRoller.setButton(btnRoll, mCharacter.getSkill(skillName));

        name.setText(skillName);
        rtg.setText(Integer.toString(skill.getRating()));
        dPool.setText(Integer.toString(skill.getDicepool()));

        if(hideMode){
            if(skill.isHidden() || skill.getDicepool() == 0){
                layout.setVisibility(View.GONE);
            }
            btnUp.setVisibility(View.GONE);
            checkBox.setVisibility(View.GONE);
        }else {
            if(skill.isHidden()){
                checkBox.setChecked(false);
            }
            if(skill.getDicepool() == 0){
                checkBox.setEnabled(false);
            }

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    skill.isHidden(!checkBox.isChecked());
                }
            });

            btnUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final int karmaCost = (mCharacter.getSkill(skillName).getRating() + 1) * 2;
                    final String karmaCostTxt = Integer.toString(karmaCost);

                    confirmText.setText("Level up " + skillName + " for " + karmaCostTxt + " Karma?");

                    final PopupWindow skillConfirm = new PopupWindow(
                            confirmLayout,
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            true);
                    skillConfirm.setBackgroundDrawable(new ColorDrawable(0x80000000));
                    skillConfirm.setAnimationStyle(android.R.style.Animation_Toast);

                    skillConfirm.showAtLocation(root, Gravity.CENTER, 0, 0);

                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            skillConfirm.dismiss();
                        }
                    });

                    btnOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mCharacter.getKarma() < karmaCost) {
                                Toast karmaWarn = Toast.makeText(mContext, "Insufficient Karma", Toast.LENGTH_SHORT);
                                karmaWarn.show();
                            } else {
                                mCharacter.subKarma(karmaCost);
                                karmaView.setText(Integer.toString(mCharacter.getKarma()));

                                mCharacter.upSkill(skillName);
                                rtg.setText(Integer.toString(mCharacter.getSkill(skillName).getRating()));
                                dPool.setText(Integer.toString(mCharacter.getSkill(skillName).getDicepool()));

                                diceRoller.setButton(btnRoll, mCharacter.getSkill(skillName));

                                checkBox.setEnabled(true);

                                skillConfirm.dismiss();
                            }
                        }
                    });
                }
            });
        }

        return layout;
    }
}
