package com.softwareengineering.ttu.shadowruncharactermanager;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rj on 4/22/2016.
 */
public class CharacterSelector {
    private static CharacterSelector ourInstance = new CharacterSelector();

    public static CharacterSelector getInstance() {
        return ourInstance;
    }

    private CharacterSelector() {
        mFileSaver = new FileSaver();
        mCharacterList = new ArrayList<>();
        mCharacterList.add("Character Name");
    }

    private ArrayList<String> mCharacterList;
    private LayoutInflater mInflater;
    private FileSaver mFileSaver;
    private Context mContext;
    private DrawerLayout mDrawer;

    public void init(Context context, DrawerLayout drawer){
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDrawer = drawer;
        mCharacterList = mFileSaver.loadCharacterList(mCharacterList, mContext);
    }

    public void save(Character character){
        mFileSaver.save(mCharacterList, mContext);
        mFileSaver.save(character, mContext);
    }

    public void updateCharName(String characterName, int index){
        mCharacterList.set(index, characterName);
    }

    public void addCharacter(String characterName, ViewGroup root) {
        mCharacterList.add(characterName);
        addView(characterName, root, mCharacterList.size() - 1);
        mFileSaver.newCharacter(Character.getInstance(), characterName, mCharacterList.size() - 1, mContext);
        mFileSaver.loadCharacter("character" + Integer.toString(mCharacterList.size() - 1) + ".txt", mContext);
        mFileSaver.save(mCharacterList, mContext);
    }

    public void setInflater(LayoutInflater inflater) {
        mInflater = inflater;
    }

    public int size(){
        return mCharacterList.size();
    }

    public View fillDrawer(ViewGroup root, int index){
        return addView(mCharacterList.get(index), root, index);
    }

    private View addView(String characterName, ViewGroup root, int index) {
        View layout = mInflater.inflate(R.layout.character_drawer_list_layout, root, false);
        TextView name = (TextView) layout.findViewById(R.id.name);
        RelativeLayout container = (RelativeLayout)layout.findViewById(R.id.container);

        final String fileName = "character" + Integer.toString(index) + ".txt";

        name.setText(characterName);

        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFileSaver.loadCharacter(fileName, mContext);
                mDrawer.closeDrawers();
            }
        });

        return layout;
    }
}
