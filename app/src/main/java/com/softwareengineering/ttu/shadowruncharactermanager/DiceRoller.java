package com.softwareengineering.ttu.shadowruncharactermanager;

import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by Rj on 4/8/2016.
 */
public class DiceRoller {
    private int mDicepool;
    private View mRoot;
    private LayoutInflater mInflater;

    public DiceRoller(View view, LayoutInflater inflater){
        mDicepool = 0;
        mRoot = view;
        mInflater = inflater;
    }

    public void rollDice(ViewGroup view, final LayoutInflater inflater){
    }

    public void setRoller(View view, final String rollNameText){
        View layout = view;
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View rollLayout = mInflater.inflate(R.layout.popup_dice_roller, null, false);
                final Button btnOK = (Button) rollLayout.findViewById(R.id.btn_OK);
                final TextView rollResult = (TextView) rollLayout.findViewById(R.id.result);
                final TextView rollName = (TextView) rollLayout.findViewById(R.id.roll_name);

                final PopupWindow rollWindow = new PopupWindow(
                        rollLayout,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        true);
                rollWindow.setBackgroundDrawable(new ColorDrawable(0x80000000));
                rollWindow.setAnimationStyle(android.R.style.Animation_Toast);

                rollName.setText(rollNameText);

                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rollWindow.dismiss();
                    }
                });

                rollWindow.showAtLocation(mRoot, Gravity.CENTER, 0, 0);
            }
        });
    }
}
