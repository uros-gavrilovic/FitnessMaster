package gui;

import gui.lib.ImageResizer;
import gui.lib.Painter;
import javax.swing.JPanel;
import gui.panels.*;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalButtonUI;
import server.Server;

public class ServerForm extends javax.swing.JFrame {
     Server server;
     
     public ServerForm() {
          server = new Server();
          
          initComponents();
          prepareForm();
     }
     
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          pnlNorth = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          pnlWest = new javax.swing.JPanel();
          lblInfo = new javax.swing.JLabel();
          tbtnDashboard = new javax.swing.JToggleButton();
          tbtnClients = new javax.swing.JToggleButton();
          lblProperties = new javax.swing.JLabel();
          tbtnSettings = new javax.swing.JToggleButton();
          lblActions = new javax.swing.JLabel();
          tbtnExit = new javax.swing.JToggleButton();
          pnlCenter = new DashboardPanel(server);

          setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
          setTitle("FitnessMaster - Server");
          setResizable(false);
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowClosing(java.awt.event.WindowEvent evt) {
                    formWindowClosing(evt);
               }
          });
          addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyPressed(java.awt.event.KeyEvent evt) {
                    formKeyPressed(evt);
               }
          });

          pnlNorth.setBackground(new java.awt.Color(41, 42, 43));
          pnlNorth.setMinimumSize(new java.awt.Dimension(210, 70));
          pnlNorth.setLayout(new java.awt.GridLayout(1, 0));

          jLabel1.setBackground(Painter.DARK);
          jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 22)); // NOI18N
          jLabel1.setForeground(new java.awt.Color(255, 255, 255));
          jLabel1.setText("FitnessMaster SERVER");
          jLabel1.setMaximumSize(new java.awt.Dimension(210, 70));
          jLabel1.setMinimumSize(new java.awt.Dimension(210, 70));
          jLabel1.setPreferredSize(new java.awt.Dimension(210, 70));
          pnlNorth.add(jLabel1);

          getContentPane().add(pnlNorth, java.awt.BorderLayout.PAGE_START);

          pnlWest.setBackground(new java.awt.Color(41, 42, 43));
          pnlWest.setPreferredSize(new java.awt.Dimension(210, 478));
          pnlWest.setLayout(new java.awt.GridLayout(0, 1));

          lblInfo.setBackground(Painter.DARK);
          lblInfo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
          lblInfo.setForeground(new java.awt.Color(255, 255, 255));
          lblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          lblInfo.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/home.png")), 50, 50));
          lblInfo.setText("<html><u>SERVER INFO</u></html>");
          lblInfo.setFocusable(false);
          lblInfo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          lblInfo.setMinimumSize(new java.awt.Dimension(210, 0));
          lblInfo.setPreferredSize(new java.awt.Dimension(210, 0));
          pnlWest.add(lblInfo);

          tbtnDashboard.setBackground(Painter.DARK);
          tbtnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          tbtnDashboard.setForeground(new java.awt.Color(255, 255, 255));
          tbtnDashboard.setText("DASHBOARD");
          tbtnDashboard.setBorder(null);
          tbtnDashboard.setBorderPainted(false);
          tbtnDashboard.setContentAreaFilled(false);
          tbtnDashboard.setFocusable(false);
          tbtnDashboard.setOpaque(true);
          tbtnDashboard.addChangeListener(new javax.swing.event.ChangeListener() {
               public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    tbtnDashboardStateChanged(evt);
               }
          });
          tbtnDashboard.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tbtnDashboardActionPerformed(evt);
               }
          });
          pnlWest.add(tbtnDashboard);

          tbtnClients.setBackground(Painter.DARK);
          tbtnClients.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          tbtnClients.setForeground(new java.awt.Color(255, 255, 255));
          tbtnClients.setText("CLIENTS");
          tbtnClients.setBorder(null);
          tbtnClients.setBorderPainted(false);
          tbtnClients.setContentAreaFilled(false);
          tbtnClients.setFocusable(false);
          tbtnClients.setOpaque(true);
          tbtnClients.addChangeListener(new javax.swing.event.ChangeListener() {
               public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    tbtnClientsStateChanged(evt);
               }
          });
          tbtnClients.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tbtnClientsActionPerformed(evt);
               }
          });
          pnlWest.add(tbtnClients);

          lblProperties.setBackground(Painter.DARK);
          lblProperties.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
          lblProperties.setForeground(new java.awt.Color(255, 255, 255));
          lblProperties.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          lblProperties.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/settings.png")), 50, 50));
          lblProperties.setText("<html><u>PROPERTIES</u></html>");
          lblProperties.setFocusable(false);
          lblProperties.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          lblProperties.setMinimumSize(new java.awt.Dimension(210, 0));
          lblProperties.setPreferredSize(new java.awt.Dimension(210, 0));
          pnlWest.add(lblProperties);

          tbtnSettings.setBackground(Painter.DARK);
          tbtnSettings.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          tbtnSettings.setForeground(new java.awt.Color(255, 255, 255));
          tbtnSettings.setText("SETTINGS");
          tbtnSettings.setBorder(null);
          tbtnSettings.setBorderPainted(false);
          tbtnSettings.setContentAreaFilled(false);
          tbtnSettings.setFocusable(false);
          tbtnSettings.setOpaque(true);
          tbtnSettings.addChangeListener(new javax.swing.event.ChangeListener() {
               public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    tbtnSettingsStateChanged(evt);
               }
          });
          tbtnSettings.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tbtnSettingsActionPerformed(evt);
               }
          });
          pnlWest.add(tbtnSettings);

          lblActions.setBackground(Painter.DARK);
          lblActions.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
          lblActions.setForeground(new java.awt.Color(255, 255, 255));
          lblActions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          lblActions.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/action.png")), 50, 50));
          lblActions.setText("<html><u>ACTIONS</u></html>");
          lblActions.setFocusable(false);
          lblActions.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
          lblActions.setMinimumSize(new java.awt.Dimension(210, 0));
          lblActions.setPreferredSize(new java.awt.Dimension(210, 0));
          pnlWest.add(lblActions);

          tbtnExit.setBackground(Painter.DARK);
          tbtnExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          tbtnExit.setForeground(new java.awt.Color(255, 255, 255));
          tbtnExit.setText("EXIT");
          tbtnExit.setBorder(null);
          tbtnExit.setBorderPainted(false);
          tbtnExit.setContentAreaFilled(false);
          tbtnExit.setFocusable(false);
          tbtnExit.setOpaque(true);
          tbtnExit.addChangeListener(new javax.swing.event.ChangeListener() {
               public void stateChanged(javax.swing.event.ChangeEvent evt) {
                    tbtnExitStateChanged(evt);
               }
          });
          tbtnExit.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    tbtnExitActionPerformed(evt);
               }
          });
          pnlWest.add(tbtnExit);

          getContentPane().add(pnlWest, java.awt.BorderLayout.LINE_START);

          javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
          pnlCenter.setLayout(pnlCenterLayout);
          pnlCenterLayout.setHorizontalGroup(
               pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 840, Short.MAX_VALUE)
          );
          pnlCenterLayout.setVerticalGroup(
               pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 508, Short.MAX_VALUE)
          );

          getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void tbtnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnDashboardActionPerformed
          openPanel(new DashboardPanel(server));
     }//GEN-LAST:event_tbtnDashboardActionPerformed
     private void tbtnClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnClientsActionPerformed
          openPanel(new ClientsPanel(server, new ArrayList<>()));
     }//GEN-LAST:event_tbtnClientsActionPerformed
     private void tbtnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnSettingsActionPerformed
          openPanel(new SettingsPanel(server));
     }//GEN-LAST:event_tbtnSettingsActionPerformed
     private void tbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnExitActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_tbtnExitActionPerformed

     private void tbtnDashboardStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbtnDashboardStateChanged
          setUpToggleButton((JToggleButton) evt.getSource());
     }//GEN-LAST:event_tbtnDashboardStateChanged
     private void tbtnClientsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbtnClientsStateChanged
          setUpToggleButton((JToggleButton) evt.getSource());
     }//GEN-LAST:event_tbtnClientsStateChanged
     private void tbtnSettingsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbtnSettingsStateChanged
          setUpToggleButton((JToggleButton) evt.getSource());
     }//GEN-LAST:event_tbtnSettingsStateChanged
     private void tbtnExitStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbtnExitStateChanged
          setUpToggleButton((JToggleButton) evt.getSource());
     }//GEN-LAST:event_tbtnExitStateChanged

     private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
          int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit server client?\nThis will result in clients disconnecting from the server.", "Exit confirmation", JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
          if (response == JOptionPane.OK_OPTION) {
               System.exit(0);
          }
     }//GEN-LAST:event_formWindowClosing

     private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
          // TODO add your handling code here:
     }//GEN-LAST:event_formKeyPressed

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel lblActions;
     private javax.swing.JLabel lblInfo;
     private javax.swing.JLabel lblProperties;
     private javax.swing.JPanel pnlCenter;
     private javax.swing.JPanel pnlNorth;
     private javax.swing.JPanel pnlWest;
     private javax.swing.JToggleButton tbtnClients;
     private javax.swing.JToggleButton tbtnDashboard;
     private javax.swing.JToggleButton tbtnExit;
     private javax.swing.JToggleButton tbtnSettings;
     // End of variables declaration//GEN-END:variables

     private void openPanel(JPanel newPanel) {
          this.remove(pnlCenter);
          pnlCenter = newPanel;
          getContentPane().add(pnlCenter);
          this.revalidate();
     }
     private void setUpToggleButton(JToggleButton tbtn) {
          if (tbtn.isSelected()) {
               setSelectedColor(tbtn);
          } else {
               setUnselectColor(tbtn);
          }
     }
     private void setSelectedColor(JToggleButton tbtn) {
          tbtn.setUI(new MetalButtonUI() {
               @Override
               protected Color getSelectColor() {
                    return Painter.GREEN;
               }
          });
          tbtn.setBackground(Painter.GREEN);
          tbtn.setForeground(Painter.DARK);
          tbtn.setContentAreaFilled(true);
     }
     private void setUnselectColor(JToggleButton tbtn) {
          tbtn.setContentAreaFilled(false);
          tbtn.setForeground(Color.WHITE);
     }
     private void prepareForm() {
          ButtonGroup tbtnGroup = new ButtonGroup();
          tbtnGroup.add(tbtnDashboard);
          tbtnGroup.add(tbtnClients);
          tbtnGroup.add(tbtnSettings);
          tbtnGroup.add(tbtnExit);

          openPanel(new DashboardPanel(server));
          tbtnDashboard.setSelected(true);
          setUpToggleButton(tbtnDashboard);
     }
}
