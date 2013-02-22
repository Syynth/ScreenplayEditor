/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.status92.scene;

/**
 *
 * @author Ben
 */
public class Text {
    
    public Text(String type, String content) {
        mContent = content;
        switch (type) {
            case "heading": mType = Type.HEADING; break;
            case "action": mType = Type.ACTION; break;
            case "name": mType = Type.NAME; break;
            case "parenthetical": mType = Type.PARENTHETICAL; break;
            case "dialog": mType = Type.DIALOG; break;
            case "transition": mType = Type.TRANSITION; break;
        }
    }
    
    public Text(Type type, String content) {
        mContent = content;
        mType = type;
    }
    
    @Override
    public String toString() {
        return mContent;
    }
    
    Type mType;
    String mContent;
    
    public enum Type {
        HEADING,
        ACTION,
        NAME,
        PARENTHETICAL,
        DIALOG,
        TRANSITION
    }
}
