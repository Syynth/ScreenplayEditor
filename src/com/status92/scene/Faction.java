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
public class Faction extends Data {
    
    public Faction() {
        this("", "", "", new ArrayList<Character>());
    }
    
    public Faction(String name, String description) {
        this(name, description, "", new ArrayList<Character>());
    }
    
    public Faction(String name, String description, String goal, ArrayList<Character> members) {
        mName = name;
        mDescription = description;
        mGoal = goal;
        mMembers = members;
    }
    
    private String mGoal;
    private ArrayList<Character> mMembers;
    
}
