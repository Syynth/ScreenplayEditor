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
    
    public Project(URL projectLocation) {
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
                        Text t = new Text(text.attributeValue("type"), text.getText());
                        v.mContent.add(t);
                    }
                }
            }
        }
        System.out.println(mActs);
        return true;
    }
    
    ArrayList<Act> mActs;
    ArrayList<Character> mCharacters;
    ArrayList<Faction> mFactions;
    ArrayList<Race> mRaces;
    ArrayList<Setting> mSettings;
    
}
