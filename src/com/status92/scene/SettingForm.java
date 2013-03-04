/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.status92.scene;

/**
 *
 * @author bcochrane
 */
public class SettingForm extends javax.swing.JPanel {

    /**
     * Creates new form SettingForm
     */
    public SettingForm() {
        initComponents();
    }
    
    public SettingForm(Setting s) {
        this();
        nameField.setText(s.mName);
        descriptionField.setText(s.description());
        lookAndFeelField.setText(s.mLookAndFeel);
        for (Race r : s.mRaces) {
            inhabitantsField.append(r.mName + "\n");
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

        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        lookAndFeelLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lookAndFeelField = new javax.swing.JTextArea();
        inhabitantsLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        inhabitantsField = new javax.swing.JTextArea();

        nameLabel.setText("Name:");

        descriptionLabel.setText("Description:");

        descriptionField.setColumns(20);
        descriptionField.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        descriptionField.setLineWrap(true);
        descriptionField.setRows(5);
        jScrollPane1.setViewportView(descriptionField);

        lookAndFeelLabel.setText("Look And Feel:");

        lookAndFeelField.setColumns(20);
        lookAndFeelField.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lookAndFeelField.setLineWrap(true);
        lookAndFeelField.setRows(5);
        jScrollPane2.setViewportView(lookAndFeelField);

        inhabitantsLabel.setText("Inhabitants:");

        inhabitantsField.setColumns(20);
        inhabitantsField.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        inhabitantsField.setLineWrap(true);
        inhabitantsField.setRows(5);
        jScrollPane3.setViewportView(inhabitantsField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(inhabitantsLabel)
                            .addComponent(lookAndFeelLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descriptionLabel)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(lookAndFeelLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inhabitantsLabel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextArea inhabitantsField;
    private javax.swing.JLabel inhabitantsLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea lookAndFeelField;
    private javax.swing.JLabel lookAndFeelLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
}