/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.status92.scene;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Attribute;
import org.dom4j.io.SAXReader;

/**
 *
 * @author Ben
 */
public class Project {
    
    public static Project getCurrentProject() {
        return mProject;
    }
    
    public Project(URL projectLocation) {
        mProject = this;
        mActs = new ArrayList<>();
        mCharacters = new ArrayList<>();
        mFactions = new ArrayList<>();
        mRaces = new ArrayList<>();
        mSettings = new ArrayList<>();
        try {
            SAXReader reader = new SAXReader();
            parseXMLProject(reader.read(projectLocation));
        } catch (DocumentException ex) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Invalid Project File: " + projectLocation.getPath() + "!" +
                    "\n" + ex);
        }
    }
    
    private boolean parseXMLProject(Document proj) {
        Element root = proj.getRootElement();
        List acts = root.selectNodes("/project/acts/act");
        for (Iterator i = acts.iterator(); i.hasNext();) {
            Element act = (Element)i.next(); // get the act element
            Act a = new Act(act.attributeValue("title"));
            mActs.add(a);
            List scenes = act.selectNodes("scene");
            for (Iterator j = scenes.iterator(); j.hasNext();) {
                Element scene = (Element) j.next();
                Scene s = new Scene(scene.attributeValue("name"));
                a.mScenes.add(s);
                List variants = scene.selectNodes("variant");
                for (Iterator k = variants.iterator(); k.hasNext();) {
                    Element variant = (Element)k.next();
                    SceneVariant v = new SceneVariant(variant.attributeValue("name"));
                    s.mVariants.add(v);
                    List texts = variant.selectNodes("text");
                    for (Iterator l = texts.iterator(); l.hasNext();) {
                        Element text = (Element)l.next();
                        Text t = new Text(text.attributeValue("type"), text.getTextTrim());
                        v.mContent.add(t);
                    }
                }
            }
        }
        
        List chars = root.selectNodes("/project/characters/character");
        for (Iterator i = chars.iterator(); i.hasNext();) {
            Element character = (Element)i.next();
            Element name = (Element)character.selectSingleNode("name");
            Element description = (Element)character.selectSingleNode("description");
            Element type = (Element)character.selectSingleNode("type");
            Element affiliation = (Element)character.selectSingleNode("affiliation");
            mCharacters.add(new Character(name.getTextTrim(), description.getTextTrim(), type.getTextTrim(), affiliation.getTextTrim()));
        }
        List factions = root.selectNodes("");
        for (Iterator i = factions.iterator(); i.hasNext();) {
            Element faction = (Element)i.next();
            Element name = (Element)faction.selectSingleNode("name");
            Element description  = (Element)faction.selectSingleNode("description");
            Element goal = (Element)faction.selectSingleNode("goal");
            List members = faction.selectNodes("members/member");
            ArrayList<Character> mems = new ArrayList<>();
            for (Iterator j = members.iterator(); j.hasNext();) {
                Element e = (Element)j.next();
                if (findCharacter(e.getTextTrim()) == null) {
                    mems.add(new Character(e.getTextTrim(), ""));
                } else {
                    mems.add(findCharacter(e.getTextTrim()));
                }
            }
            mFactions.add(new Faction(name.getTextTrim(), description.getTextTrim(), goal.getTextTrim(), mems));
        }
        System.out.println(mActs);
        return true;
    }
    
    public Act findAct(String name) {
        for (Act act : mActs) {
            if (act.mTitle.equals(name)) {
                return act;
            }
        }
        return null;
    }
    
    public Character findCharacter(String name) {
        for (Character c : mCharacters) {
            if (c.mName.equals(name)) {
                return c;
            }
        }
        return null;
    }
    
    public Faction findFaction(String name) {
        for (Faction f : mFactions) {
            if (f.mName.equals(name)) {
                return f;
            }
        }
        return null;
    }
    
    public Race findRace(String name) {
        for (Race r : mRaces) {
            if (r.mName.equals(name)) {
                return r;
            }
        }
        return null;
    }
    
    public Setting findSetting(String name) {
        for (Setting s : mSettings) {
            if (s.mName.equals(name)) {
                return s;
            }
        }
        return null;
    }
    
    
    
    ArrayList<Act> mActs;
    ArrayList<Character> mCharacters;
    ArrayList<Faction> mFactions;
    ArrayList<Race> mRaces;
    ArrayList<Setting> mSettings;
    
    static Project mProject;
}
