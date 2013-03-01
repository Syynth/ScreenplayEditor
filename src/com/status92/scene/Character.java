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
        mFactionRef = faction;
    }
    
    public void findFaction() {
        mFaction = Project.getCurrentProject().findFaction(mFactionRef);
        if (mFaction == null) {
            mFaction = new Faction(mFactionRef, "");
        }
    }
    
    public void changeFaction(Faction f) {
        mFaction = f;
        mFactionRef = mFaction.mName;
    }
    
    public void changeFaction(String s) {
        mFactionRef = s;
        findFaction();
    }
    
    boolean mImportant;
    private Faction mFaction;
    private String mFactionRef;
    
}
