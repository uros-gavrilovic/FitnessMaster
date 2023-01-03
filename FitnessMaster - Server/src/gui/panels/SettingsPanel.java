package gui.panels;

import server.Server;

public class SettingsPanel extends javax.swing.JPanel {
     Server server;
     
     public SettingsPanel(Server server) {
          this.server = server;
          
          initComponents();
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jPanel1 = new javax.swing.JPanel();
          lblPort = new javax.swing.JLabel();
          ftxtPort = new javax.swing.JFormattedTextField();
          jPanel2 = new javax.swing.JPanel();
          lblUrl = new javax.swing.JLabel();
          txtUrl = new javax.swing.JTextField();
          txtUsername = new javax.swing.JTextField();
          lblPassword = new javax.swing.JLabel();
          lblUsername = new javax.swing.JLabel();
          txtStatus5 = new javax.swing.JTextField();
          btnSave = new javax.swing.JButton();
          btnDefault = new javax.swing.JButton();

          jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Server settings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18))); // NOI18N

          lblPort.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          lblPort.setText("PORT NUMBER:");

          ftxtPort.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          ftxtPort.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          ftxtPort.setMinimumSize(new java.awt.Dimension(260, 22));
          ftxtPort.setPreferredSize(new java.awt.Dimension(64, 31));

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ftxtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41))
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                         .addGap(39, 39, 39)
                         .addComponent(lblPort, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addContainerGap(318, Short.MAX_VALUE)))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addComponent(ftxtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16))
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                         .addGap(30, 30, 30)
                         .addComponent(lblPort, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          );

          jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Database settings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18))); // NOI18N

          lblUrl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          lblUrl.setText("DATABASE URL:");

          txtUrl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          txtUrl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          txtUrl.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtUrlActionPerformed(evt);
               }
          });

          txtUsername.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          txtUsername.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtUsernameActionPerformed(evt);
               }
          });

          lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          lblPassword.setText("PASSWORD:");

          lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          lblUsername.setText("USERNAME:");

          txtStatus5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          txtStatus5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          txtStatus5.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    txtStatus5ActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
          jPanel2.setLayout(jPanel2Layout);
          jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 514, Short.MAX_VALUE)
               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                         .addGap(39, 39, 39)
                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                              .addGroup(jPanel2Layout.createSequentialGroup()
                                   .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addGap(18, 18, 18)
                                   .addComponent(txtStatus5))
                              .addGroup(jPanel2Layout.createSequentialGroup()
                                   .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGap(18, 18, 18)
                                   .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                        .addComponent(txtUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))))
                         .addContainerGap(40, Short.MAX_VALUE)))
          );
          jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 235, Short.MAX_VALUE)
               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                         .addGap(30, 30, 30)
                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(lblUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(18, 18, 18)
                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                              .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGroup(jPanel2Layout.createSequentialGroup()
                                   .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                   .addGap(1, 1, 1)))
                         .addGap(18, 18, 18)
                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(txtStatus5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addContainerGap(31, Short.MAX_VALUE)))
          );

          btnSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          btnSave.setText("SAVE SETTINGS");
          btnSave.setFocusable(false);
          btnSave.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          btnSave.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSaveActionPerformed(evt);
               }
          });

          btnDefault.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          btnDefault.setText("RESET TO DEFAULT");
          btnDefault.setFocusable(false);
          btnDefault.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          btnDefault.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnDefaultActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
          this.setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                         .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addGroup(layout.createSequentialGroup()
                              .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(btnDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(243, Short.MAX_VALUE))
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btnDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(47, Short.MAX_VALUE))
          );
     }// </editor-fold>//GEN-END:initComponents

     private void txtUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUrlActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_txtUrlActionPerformed

     private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_txtUsernameActionPerformed

     private void txtStatus5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatus5ActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_txtStatus5ActionPerformed

     private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_btnSaveActionPerformed

     private void btnDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefaultActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_btnDefaultActionPerformed


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton btnDefault;
     private javax.swing.JButton btnSave;
     private javax.swing.JFormattedTextField ftxtPort;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JLabel lblPassword;
     private javax.swing.JLabel lblPort;
     private javax.swing.JLabel lblUrl;
     private javax.swing.JLabel lblUsername;
     private javax.swing.JTextField txtStatus5;
     private javax.swing.JTextField txtUrl;
     private javax.swing.JTextField txtUsername;
     // End of variables declaration//GEN-END:variables
}
