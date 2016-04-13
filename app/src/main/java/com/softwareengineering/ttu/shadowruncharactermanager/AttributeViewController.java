package com.softwareengineering.ttu.shadowruncharactermanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Rj on 4/12/2016.
 */
public class AttributeViewController {
    private Character character = Character.getInstance();
    private LayoutInflater mInflater;

    public AttributeViewController(LayoutInflater inflater){
        mInflater = inflater;
    };

    public View getAttributeView(ViewGroup root, int index, TextView karmaView){
        View layout = mInflater.inflate(R.layout.attribute_list_layout, root, false);
        final Attribute attribute = character.getAttributeByIndex(index);
        final String attName = attribute.getName();

        final TextView name = (TextView) layout.findViewById(R.id.attribute_name);
        final TextView rtg = (TextView) layout.findViewById(R.id.attribute_rating);
        ImageButton btnUp = (ImageButton) layout.findViewById(R.id.btn_attribute_up);

        name.setText(attName);
        rtg.setText(Integer.toString(attribute.getRating()));

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                character.upAttribute(attName);
                rtg.setText(Integer.toString(character.getAttribute(attName).getRating()));
            }
        });

        return layout;
    }
}
