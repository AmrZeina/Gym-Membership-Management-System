/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FrontendClasses;

import BackendClasses.TrainerRole;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Reem
 */
public class RegMember extends javax.swing.JFrame {

    /**
     * Creates new form RegMember
     */
    public RegMember(TrainerRole trainer) {
        this.trainer = trainer;
        initComponents();
        LocalDate date = LocalDate.now();
        String dateString = date.toString();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { dateString }));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        memberIDField = new javax.swing.JTextField();
        classIdField = new javax.swing.JTextField();
        label3 = new java.awt.Label();
        addRegButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        backButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register Member");

        label1.setBackground(new java.awt.Color(153, 255, 153));
        label1.setText("Member ID");

        label2.setBackground(new java.awt.Color(153, 255, 153));
        label2.setText("Class ID");

        memberIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberIDFieldActionPerformed(evt);
            }
        });

        classIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classIdFieldActionPerformed(evt);
            }
        });

        label3.setBackground(new java.awt.Color(153, 255, 153));
        label3.setText("Registration Date");

        addRegButton.setBackground(new java.awt.Color(0, 0, 0));
        addRegButton.setForeground(new java.awt.Color(255, 255, 255));
        addRegButton.setText("Add Registration");
        addRegButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRegButtonActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        backButton1.setBackground(new java.awt.Color(0, 0, 0));
        backButton1.setForeground(new java.awt.Color(255, 255, 255));
        backButton1.setText("Back");
        backButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(memberIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(classIdField)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(addRegButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(backButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(memberIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(classIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jComboBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRegButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void memberIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberIDFieldActionPerformed

    private void classIdFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classIdFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classIdFieldActionPerformed

    private void addRegButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRegButtonActionPerformed
        if (memberIDField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "please fill out Member ID");
        } else if (classIdField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "please fill out class ID");
        } else if (jComboBox1.equals(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "please enter today's date correctly");
        } else {
            trainer.registerMemberForClass(memberIDField.getText(), classIdField.getText(), LocalDate.now());
            this.dispose();
        }
    }//GEN-LAST:event_addRegButtonActionPerformed

    private void backButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_backButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRegButton;
    private javax.swing.JButton backButton1;
    private javax.swing.JTextField classIdField;
    private javax.swing.JComboBox<String> jComboBox1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JTextField memberIDField;
    // End of variables declaration//GEN-END:variables
    private TrainerRole trainer;
}