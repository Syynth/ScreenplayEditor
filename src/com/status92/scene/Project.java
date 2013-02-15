/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.status92.scene;

import java.util.ArrayList;

/**
 *
 * @author Ben
 */
public class Project {
    
    public Project(String data) {
        parseXMLProject(data);
    }
    
    private boolean parseXMLProject(String xml) {
        
        return true;
    }
    
    private ArrayList<Act> mActs;
    private ArrayList<Character> mCharacters;
    private ArrayList<Faction> mFactions;
    private ArrayList<Race> mRaces;
    private ArrayList<Scene> mScenes;
    private ArrayList<Setting> mSettings;
    
}
