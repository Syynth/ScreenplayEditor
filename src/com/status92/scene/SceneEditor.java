/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.status92.scene;

import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Ben
 */
public class SceneEditor extends javax.swing.JFrame {

    /**
     * Creates new form SceneEditor
     */
    public SceneEditor() {
        this.setLocationRelativeTo(null);
        try {
            project = new Project(new File("src/resources/testproject.xml").toURI().toURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(SceneEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        initProject();
        initTree();
    }
    
    private void initProject() {
        for (Character c : project.mCharacters) {
            c.findFaction();
        }
    }
    private void initTree() {
        actsNode = new DefaultMutableTreeNode("Acts");
        charactersNode = new DefaultMutableTreeNode("Characters");
        factionsNode = new DefaultMutableTreeNode("Factions");
        racesNode = new DefaultMutableTreeNode("Races");
        settingsNode = new DefaultMutableTreeNode("Settings");
        projectRootNode.add(actsNode);
        projectRootNode.add(charactersNode);
        projectRootNode.add(factionsNode);
        projectRootNode.add(racesNode);
        projectRootNode.add(settingsNode);
        
        for (Act a : project.mActs) {
            DefaultMutableTreeNode actNode = new DefaultMutableTreeNode(a.mTitle);
            actsNode.add(actNode);
            for (Scene s : a.mScenes) {
                DefaultMutableTreeNode sceneNode = new DefaultMutableTreeNode(s.mName);
                actNode.add(sceneNode);
                for (SceneVariant v : s.mVariants) {
                    DefaultMutableTreeNode variantNode = new DefaultMutableTreeNode(v.mName);
                    sceneNode.add(variantNode);
                }
            }
        }
        
        for (Character c : project.mCharacters) {
            DefaultMutableTreeNode characterNode = new DefaultMutableTreeNode(c.mName);
            charactersNode.add(characterNode);
            tabEditPane.addTab(c.mName, new CharacterForm(c));
        }
        for (Faction f : project.mFactions) {
            DefaultMutableTreeNode factionNode = new DefaultMutableTreeNode(f.mName);
            factionsNode.add(factionNode);
            tabEditPane.addTab(f.mName, new FactionForm(f));
        }
        for (Race r : project.mRaces) {
            DefaultMutableTreeNode raceNode = new DefaultMutableTreeNode(r.mName);
            racesNode.add(raceNode);
            tabEditPane.addTab(r.mName, new RaceForm(r));
        }
        for (Setting s : project.mSettings) {
            DefaultMutableTreeNode settingNode = new DefaultMutableTreeNode(s.mName);
            settingsNode.add(settingNode);
            tabEditPane.addTab(s.mName, new SettingForm(s));
        }
        for (int i = 0; i < projectTree.getRowCount(); ++i) {
            projectTree.expandRow(i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        leftScrollPane = new javax.swing.JScrollPane();
        projectRootNode = new DefaultMutableTreeNode(project.mName);
        projectTree = new javax.swing.JTree(projectRootNode);
        tabEditPane = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JEditorPane();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuNewProject = new javax.swing.JMenuItem();
        menuNewAct = new javax.swing.JMenuItem();
        fileSeperator1 = new javax.swing.JPopupMenu.Separator();
        menuOpenProject = new javax.swing.JMenuItem();
        menuSaveProject = new javax.swing.JMenuItem();
        menuSaveProjectAs = new javax.swing.JMenuItem();
        fileSeperator2 = new javax.swing.JPopupMenu.Separator();
        menuExport = new javax.swing.JMenu();
        menuExportPlainText = new javax.swing.JMenuItem();
        menuExportRichText = new javax.swing.JMenuItem();
        menuExportWordDoc = new javax.swing.JMenuItem();
        fileSeperator3 = new javax.swing.JPopupMenu.Separator();
        menuExit = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        menuCopy = new javax.swing.JMenuItem();
        menuCut = new javax.swing.JMenuItem();
        menuPaste = new javax.swing.JMenuItem();
        editSeperator1 = new javax.swing.JPopupMenu.Separator();
        menuFind = new javax.swing.JMenuItem();
        menuReplace = new javax.swing.JMenuItem();
        menuFindUsages = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        splitPane.setBorder(null);
        splitPane.setDividerLocation(200);

        projectTree.setDoubleBuffered(true);
        projectTree.setDragEnabled(true);
        projectTree.setEditable(true);
        leftScrollPane.setViewportView(projectTree);

        splitPane.setLeftComponent(leftScrollPane);

        tabEditPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textPane.setContentType("text/rtf"); // NOI18N
        textPane.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        textPane.setDoubleBuffered(true);
        textPane.setDragEnabled(true);
        jScrollPane1.setViewportView(textPane);

        tabEditPane.addTab("Home", jScrollPane1);

        splitPane.setRightComponent(tabEditPane);

        menuFile.setText("File");
        menuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFileActionPerformed(evt);
            }
        });

        menuNewProject.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuNewProject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/newProject.png"))); // NOI18N
        menuNewProject.setText("New Project");
        menuNewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewProjectActionPerformed(evt);
            }
        });
        menuFile.add(menuNewProject);

        menuNewAct.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuNewAct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/newAct.png"))); // NOI18N
        menuNewAct.setText("New Act");
        menuFile.add(menuNewAct);
        menuFile.add(fileSeperator1);

        menuOpenProject.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuOpenProject.setText("Open Project");
        menuOpenProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenProjectActionPerformed(evt);
            }
        });
        menuFile.add(menuOpenProject);

        menuSaveProject.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSaveProject.setText("Save Project");
        menuFile.add(menuSaveProject);

        menuSaveProjectAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuSaveProjectAs.setText("Save Project As..");
        menuSaveProjectAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveProjectAsActionPerformed(evt);
            }
        });
        menuFile.add(menuSaveProjectAs);
        menuFile.add(fileSeperator2);

        menuExport.setText("Export Project to...");

        menuExportPlainText.setText("Plaintext (.txt)");
        menuExport.add(menuExportPlainText);

        menuExportRichText.setText("Rich Text (.rtf)");
        menuExport.add(menuExportRichText);

        menuExportWordDoc.setText("Word (.docx)");
        menuExportWordDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExportWordDocActionPerformed(evt);
            }
        });
        menuExport.add(menuExportWordDoc);

        menuFile.add(menuExport);
        menuFile.add(fileSeperator3);

        menuExit.setText("Exit");
        menuFile.add(menuExit);

        menuBar.add(menuFile);

        menuEdit.setText("Edit");

        menuCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menuCopy.setText("Copy");
        menuEdit.add(menuCopy);

        menuCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuCut.setText("Cut");
        menuEdit.add(menuCut);

        menuPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menuPaste.setText("Paste");
        menuEdit.add(menuPaste);
        menuEdit.add(editSeperator1);

        menuFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        menuFind.setText("Find Next");
        menuEdit.add(menuFind);

        menuReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        menuReplace.setText("Replace");
        menuEdit.add(menuReplace);

        menuFindUsages.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, java.awt.event.InputEvent.ALT_MASK));
        menuFindUsages.setText("Find Usages");
        menuEdit.add(menuFindUsages);

        menuBar.add(menuEdit);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void menuNewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNewProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuNewProjectActionPerformed
    private void menuOpenProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpenProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuOpenProjectActionPerformed
    private void menuSaveProjectAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSaveProjectAsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSaveProjectAsActionPerformed
    private void menuExportWordDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExportWordDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuExportWordDocActionPerformed
    private void menuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFileActionPerformed
        //loadProject();
    }//GEN-LAST:event_menuFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            // handle exception
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SceneEditor().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu.Separator editSeperator1;
    private javax.swing.JPopupMenu.Separator fileSeperator1;
    private javax.swing.JPopupMenu.Separator fileSeperator2;
    private javax.swing.JPopupMenu.Separator fileSeperator3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane leftScrollPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuCopy;
    private javax.swing.JMenuItem menuCut;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuExport;
    private javax.swing.JMenuItem menuExportPlainText;
    private javax.swing.JMenuItem menuExportRichText;
    private javax.swing.JMenuItem menuExportWordDoc;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuFind;
    private javax.swing.JMenuItem menuFindUsages;
    private javax.swing.JMenuItem menuNewAct;
    private javax.swing.JMenuItem menuNewProject;
    private javax.swing.JMenuItem menuOpenProject;
    private javax.swing.JMenuItem menuPaste;
    private javax.swing.JMenuItem menuReplace;
    private javax.swing.JMenuItem menuSaveProject;
    private javax.swing.JMenuItem menuSaveProjectAs;
    private DefaultMutableTreeNode actsNode;
    private DefaultMutableTreeNode charactersNode;
    private DefaultMutableTreeNode factionsNode;
    private DefaultMutableTreeNode racesNode;
    private DefaultMutableTreeNode settingsNode;
    private Project project;
    private DefaultMutableTreeNode projectRootNode;
    private javax.swing.JTree projectTree;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JTabbedPane tabEditPane;
    private javax.swing.JEditorPane textPane;
    // End of variables declaration//GEN-END:variables
}