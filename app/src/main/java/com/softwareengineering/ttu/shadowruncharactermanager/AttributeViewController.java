package com.softwareengineering.ttu.shadowruncharactermanager;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rj on 4/12/2016.
 */
public class AttributeViewController {
    private Character character = Character.getInstance();
    private LayoutInflater mInflater;
    private Context mContext;

    public AttributeViewController(LayoutInflater inflater, Context context){
        mInflater = inflater;
        mContext = context;
    };

    public View getAttributeView(final ViewGroup root, int index, final TextView karmaView){
        View layout = mInflater.inflate(R.layout.attribute_list_layout, root, false);
        final DiceRoller diceRoller = new DiceRoller(layout, mInflater);
        final Attribute attribute = character.getAttributeByIndex(index);
        final String attName = attribute.getName();

        final TextView name = (TextView) layout.findViewById(R.id.attribute_name);
        final TextView rtg = (TextView) layout.findViewById(R.id.attribute_rating);
        final ImageButton btnRoll = (ImageButton) layout.findViewById(R.id.btn_roll_dice);
        ImageButton btnUp = (ImageButton) layout.findViewById(R.id.btn_attribute_up);

        final View confirmLayout = mInflater.inflate(R.layout.popup_confirm, null, false);
        final TextView confirmText = (TextView) confirmLayout.findViewById(R.id.confirm_text);
        final Button btnCancel = (Button) confirmLayout.findViewById(R.id.btn_cancel);
        final Button btnOk = (Button) confirmLayout.findViewById(R.id.btn_OK);

        diceRoller.setButton(btnRoll, character.getAttribute(attName));

        name.setText(attName);
        rtg.setText(Integer.toString(attribute.getRating()));

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int karmaCost = (character.getAttribute(attName).getRating() + 1) * 5;
                final String karmaCostTxt = Integer.toString(karmaCost);

                confirmText.setText("Level up " + attName + " for " + karmaCostTxt + " Karma?");

                final PopupWindow attrConfirm = new PopupWindow(
                        confirmLayout,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        true);
                attrConfirm.setBackgroundDrawable(new ColorDrawable(0x80000000));
                attrConfirm.setAnimationStyle(android.R.style.Animation_Toast);

                attrConfirm.showAtLocation(root, Gravity.CENTER, 0, 0);

                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        attrConfirm.dismiss();
                    }
                });

                btnOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(character.getKarma() < karmaCost){
                            Toast karmaWarn = Toast.makeText(mContext, "Insufficient Karma", Toast.LENGTH_SHORT);
                            karmaWarn.show();
                        }
                        else {
                            character.subKarma(karmaCost);
                            karmaView.setText(Integer.toString(character.getKarma()));

                            character.upAttribute(attName);
                            rtg.setText(Integer.toString(character.getAttribute(attName).getRating()));

                            diceRoller.setButton(btnRoll, character.getAttribute(attName));

                            attrConfirm.dismiss();
                        }
                    }
                });
            }
        });

        return layout;
    }
}
