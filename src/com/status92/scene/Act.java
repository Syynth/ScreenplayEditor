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
public class Act {
    
    public Act(String title) {
        mScenes = new ArrayList<>();
        mTitle = title;
    }
    
    @Override
    public String toString() {
        return mTitle + " " + mScenes;
    }
    
    ArrayList<Scene> mScenes;
    String mTitle;
    int mNumber;
    
}
