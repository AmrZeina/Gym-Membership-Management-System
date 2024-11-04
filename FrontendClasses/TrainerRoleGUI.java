package FrontendClasses;

import BackendClasses.TrainerRole;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class TrainerRoleGUI extends javax.swing.JFrame {

    public TrainerRoleGUI() throws FileNotFoundException {
        this.trainer = new TrainerRole();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMemberButton = new javax.swing.JButton();
        viewMembersButton = new javax.swing.JButton();
        addClassButton = new javax.swing.JButton();
        viewClassesButton = new javax.swing.JButton();
        regMemberForClassButton = new javax.swing.JButton();
        cancelRegButton = new javax.swing.JButton();
        viewRegButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trainer Role");
        setBackground(java.awt.Color.gray);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        addMemberButton.setBackground(new java.awt.Color(0, 0, 0));
        addMemberButton.setForeground(new java.awt.Color(255, 255, 255));
        addMemberButton.setText("Add Member");
        addMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberButtonActionPerformed(evt);
            }
        });

        viewMembersButton.setBackground(new java.awt.Color(0, 0, 0));
        viewMembersButton.setForeground(new java.awt.Color(255, 255, 255));
        viewMembersButton.setText("View Members");

        addClassButton.setBackground(new java.awt.Color(0, 0, 0));
        addClassButton.setForeground(new java.awt.Color(255, 255, 255));
        addClassButton.setText("Add Class");
        addClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassButtonActionPerformed(evt);
            }
        });

        viewClassesButton.setBackground(new java.awt.Color(0, 0, 0));
        viewClassesButton.setForeground(new java.awt.Color(255, 255, 255));
        viewClassesButton.setText("View Classes");

        regMemberForClassButton.setBackground(new java.awt.Color(0, 0, 0));
        regMemberForClassButton.setForeground(new java.awt.Color(255, 255, 255));
        regMemberForClassButton.setText("Register Member For Class");
        regMemberForClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regMemberForClassButtonActionPerformed(evt);
            }
        });

        cancelRegButton.setBackground(new java.awt.Color(0, 0, 0));
        cancelRegButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelRegButton.setText("Cancel Registeration");
        cancelRegButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelRegButtonActionPerformed(evt);
            }
        });

        viewRegButton.setBackground(new java.awt.Color(0, 0, 0));
        viewRegButton.setForeground(new java.awt.Color(255, 255, 255));
        viewRegButton.setText("View Registerations");

        logoutButton.setBackground(new java.awt.Color(0, 0, 0));
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelRegButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(viewMembersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewClassesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regMemberForClassButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addClassButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addMemberButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(viewRegButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(addMemberButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewMembersButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addClassButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewClassesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regMemberForClassButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelRegButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewRegButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutButton)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberButtonActionPerformed
        AddMember window=new AddMember(trainer);
        window.setVisible(true);
    }//GEN-LAST:event_addMemberButtonActionPerformed

    private void regMemberForClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regMemberForClassButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regMemberForClassButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        try {
            trainer.logout();
        } catch (IOException ex) {
            Logger.getLogger(TrainerRoleGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
       System.exit(0);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void addClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassButtonActionPerformed
        AddClass window=new AddClass(trainer);
        window.setVisible(true);
    }//GEN-LAST:event_addClassButtonActionPerformed

    private void cancelRegButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelRegButtonActionPerformed
        CancelReg window=new CancelReg(trainer);
        window.setVisible(true);
    }//GEN-LAST:event_cancelRegButtonActionPerformed

    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TrainerRoleGUI().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TrainerRoleGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addClassButton;
    private javax.swing.JButton addMemberButton;
    private javax.swing.JButton cancelRegButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton regMemberForClassButton;
    private javax.swing.JButton viewClassesButton;
    private javax.swing.JButton viewMembersButton;
    private javax.swing.JButton viewRegButton;
    // End of variables declaration//GEN-END:variables
    private TrainerRole trainer;
}
