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
public class Scene {
    
    public Scene(String name) {
        mName = name;
        mVariants = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return "{" + mName + ": " + mVariants + "}";
    }
    
    String mName;
    ArrayList<SceneVariant> mVariants;
    
}
