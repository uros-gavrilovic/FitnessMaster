package gui;

import javax.swing.*;
import gui.lib.*;
import client.Client;
import gui.lib.Painter;
import java.awt.event.KeyEvent;
import java.net.Socket;

public class MainMenuForm extends javax.swing.JFrame {
    public MainMenuForm() {
        setSize(400, 380);
        setLocationRelativeTo(null);
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          panel = new javax.swing.JPanel();
          btnStart = new CustomLightButton();
          btnSettings = new CustomLightButton();
          btnExit = new CustomLightButton();
          lblLogo = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          setTitle("FitnessMaster ");
          setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
          setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/smallIcon_light.png")).getImage());
          setResizable(false);
          setSize(new java.awt.Dimension(400, 382));
          addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyPressed(java.awt.event.KeyEvent evt) {
                    formKeyPressed(evt);
               }
          });

          panel.setBackground(Painter.DARK);

          btnStart.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
          btnStart.setText("START PROGRAM");
          btnStart.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnStartActionPerformed(evt);
               }
          });

          btnSettings.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
          btnSettings.setText("SETTINGS");
          btnSettings.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSettingsActionPerformed(evt);
               }
          });

          btnExit.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
          btnExit.setText("EXIT");
          btnExit.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnExitActionPerformed(evt);
               }
          });

          lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          lblLogo.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/logo.png")),220, 220));
          lblLogo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

          javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
          panel.setLayout(panelLayout);
          panelLayout.setHorizontalGroup(
               panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addGroup(panelLayout.createSequentialGroup()
                              .addGap(18, 18, 18)
                              .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(btnSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addGap(0, 18, Short.MAX_VALUE)))
                    .addContainerGap())
          );
          panelLayout.setVerticalGroup(
               panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE))
          );

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        Client client = new Client();
        Socket socket = client.connect();

        if (socket != null) {
            dispose();
            openLogInForm(socket);
        } else {
            JOptionPane.showMessageDialog(this, "Unable to connect to the server!\n"
                    + "Please contact your administrator.", "Connectivity issues", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnStartActionPerformed
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) dispose();
    }//GEN-LAST:event_btnExitActionPerformed
    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed

    }//GEN-LAST:event_btnSettingsActionPerformed
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        keyboardShortcutEvent(evt);
    }//GEN-LAST:event_formKeyPressed

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton btnExit;
     private javax.swing.JButton btnSettings;
     private javax.swing.JButton btnStart;
     private javax.swing.JLabel lblLogo;
     private javax.swing.JPanel panel;
     // End of variables declaration//GEN-END:variables

    private void keyboardShortcutEvent(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnStartActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
        }
    }
    private void openLogInForm(Socket socket) {
        new LogInForm(socket).setVisible(true);
    }
}
