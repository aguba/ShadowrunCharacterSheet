package com.softwareengineering.ttu.shadowruncharactermanager;

/**
 * Created by DABJ on 4/19/2016.
 */
public class User {
    public String name, username, password;

    private static User userInstance = null;

    //constructors ----------------------------------------------------------
    private User(String name, String username, String password)
    {
        this.name = name;
        this.username = username;
        this.password = password;
    }
    private User(String username, String password)
    {
        this.name = "";
        this.username = username;
        this.password = password;
    }
    private User(String username)
    {
        this.name = "";
        this.username = username;
        this.password = "";
    }
    //-----------------------------------------------------------------------------
    /*returns the singleton user object*/
    public static User getUserInstance(String name, String username, String password){
        if(userInstance == null){
            userInstance = new User(name, username, password);
        }
        return userInstance;
    }

    public String getUsername(){
        return username;
    }
}
