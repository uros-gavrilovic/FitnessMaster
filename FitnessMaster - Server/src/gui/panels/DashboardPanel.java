package gui.panels;

import gui.lib.*;
import java.awt.Color;
import server.Server;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import lib.PrintStream;

public class DashboardPanel extends javax.swing.JPanel {
     Server server;
     
     public DashboardPanel(Server server) {
          this.server = server;
          
          initComponents();
          prepareForm();
          
          PrintStream ps = new PrintStream(txtLogs);
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          lblLogs = new javax.swing.JLabel();
          txtStatus = new javax.swing.JTextField();
          jScrollPane1 = new javax.swing.JScrollPane();
          txtLogs = new javax.swing.JTextArea();
          lblStatus = new javax.swing.JLabel();
          btnStatus = new javax.swing.JButton();

          lblLogs.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          lblLogs.setText("CONSOLE LOGS:");

          txtStatus.setEditable(false);
          txtStatus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          txtStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          txtStatus.setText("<status>");
          txtStatus.setBorder(null);

          txtLogs.setEditable(false);
          txtLogs.setColumns(20);
          txtLogs.setRows(5);
          txtLogs.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, Painter.DARK));
          jScrollPane1.setViewportView(txtLogs);

          lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          lblStatus.setText("SERVER STATUS:");

          btnStatus.setBackground(Painter.DARK);
          btnStatus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          btnStatus.setForeground(new java.awt.Color(255, 255, 255));
          btnStatus.setText("<status>");
          btnStatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
          btnStatus.setFocusable(false);
          btnStatus.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          btnStatus.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btnStatusMouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    btnStatusMouseExited(evt);
               }
          });
          btnStatus.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnStatusActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
          this.setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGroup(layout.createSequentialGroup()
                              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                   .addComponent(lblLogs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                              .addGap(18, 18, 18)
                              .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(18, 18, 18)
                              .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(33, Short.MAX_VALUE))
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addComponent(lblLogs, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE))
          );
     }// </editor-fold>//GEN-END:initComponents

     private void btnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusActionPerformed
          try{
               if (server.isAlive()) {
                    server.stopServer();
               } else {
                    server.startServer();
               }
               prepareForm();
          } catch (Exception ex){
               
          }
     }//GEN-LAST:event_btnStatusActionPerformed

     private void btnStatusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatusMouseEntered
          Painter.setOnHoverColor((JButton) evt.getSource());
     }//GEN-LAST:event_btnStatusMouseEntered
     private void btnStatusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatusMouseExited
          Painter.setOffHoverColor((JButton) evt.getSource());
     }//GEN-LAST:event_btnStatusMouseExited


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton btnStatus;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JLabel lblLogs;
     private javax.swing.JLabel lblStatus;
     private javax.swing.JTextArea txtLogs;
     private javax.swing.JTextField txtStatus;
     // End of variables declaration//GEN-END:variables

     private void prepareForm() {
          if(server.isAlive()){
               txtStatus.setText("ACTIVE");
               txtStatus.setForeground(new Color(21,71,52));
               btnStatus.setText("DEACTIVATE");
          } else {
               txtStatus.setText("INACTIVE");
               txtStatus.setForeground(new Color(128,5,0));
               btnStatus.setText("ACTIVATE");
          }
     }
}
