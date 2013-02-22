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
public class SceneVariant {
    
    public SceneVariant(String name) {
        mName = name;
        mContent = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return mName + mContent;
    }
    
    String mName;
    ArrayList<Text> mContent;
    
}
