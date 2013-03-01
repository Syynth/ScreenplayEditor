/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.status92.scene;

/**
 *
 * @author Ben
 */
public class Character extends Data {
    
    public Character() {
        this("", "", "", "");
    }
    
    public Character(String name, String description) {
        this(name, description, "false", "");
    }
    
    public Character(String name, String description, String important, String faction) {
        mName = name;
        mDescription = description;
        mImportant = Boolean.parseBoolean(important);
        //mFaction = Project.getCurrentProject().findFaction(faction);
        if (mFaction == null) {
            mFaction = new Faction(faction, "");
        }
    }
    
    public void changeFaction(Faction f) {
        
    }
    
    public void changeFaction(String s) {
        
    }
    
    boolean mImportant;
    private Faction mFaction;
    
}
