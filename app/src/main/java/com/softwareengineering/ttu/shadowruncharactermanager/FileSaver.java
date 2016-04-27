package com.softwareengineering.ttu.shadowruncharactermanager;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Rj on 4/26/2016.
 */
public class FileSaver {
    public FileSaver(){}

    public void newCharacter(Character character, String characterName, int index, Context context){
        character.setName(characterName);
//        character.setFileName("character" + Integer.toString(index) + ".txt");

        character.reset(index);
        save(character, context);
    }

    public void save(Character character, Context context){
        File file = new File(context.getFilesDir(), character.getFileName());

        if(!file.exists()){
            try{
                file.createNewFile();
            }
            catch (IOException e){}
        }

        try{
            FileOutputStream fOut = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(fOut);
            objOut.writeObject(Character.getInstance());
            objOut.close();
        }
        catch (IOException e){}
    }

    public void save(ArrayList<String> characterList, Context context){
        File file = new File(context.getFilesDir(), "characterList.txt");

        if(!file.exists()){
            try{
                file.createNewFile();
            }
            catch (IOException e){}
        }

        try{
            FileOutputStream fOut = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(fOut);
            objOut.writeObject(characterList);
            objOut.close();
        }
        catch (IOException e){}
    }

    public void loadCharacter(String fileName, Context context){
        File file = new File(context.getFilesDir(), fileName);

        if(file.exists()) {
            try {
                FileInputStream fIn = new FileInputStream(file);
                ObjectInputStream objIn = new ObjectInputStream(fIn);
                Character.setInstance((Character)objIn.readObject());
                objIn.close();
            } catch (Exception e) {}
        }
    }

    public ArrayList<String> loadCharacterList(ArrayList<String> characterList, Context context){
        File file = new File(context.getFilesDir(), "characterList.txt");
        ArrayList<String> list = new ArrayList<>();

        if(file.exists()) {
            try {
                FileInputStream fIn = new FileInputStream(file);
                ObjectInputStream objIn = new ObjectInputStream(fIn);
                list = (ArrayList<String>)objIn.readObject();
                objIn.close();
            } catch (Exception e) {}

            return list;
        }
        else{
            return characterList;
        }
    }
}
