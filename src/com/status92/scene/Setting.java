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
public class Setting extends Data {
    
    public Setting() {
        this("", "", "", "");
    }
    
    public Setting(String name, String description, String lookAndFeel, String race) {
        mRaces = new ArrayList<>();
        mRaceRefs = new ArrayList<>();
        mName = name;
        mDescription = description;
        mLookAndFeel = lookAndFeel;
        mRaceRefs.add(race);
    }
    
    String mLookAndFeel;
    ArrayList<Race> mRaces;
    ArrayList<String> mRaceRefs;
    
}
