package gui.panels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import server.Server;

public class SettingsPanel extends javax.swing.JPanel {
     Server server;
     boolean changesMade = false;

     public SettingsPanel(Server server) {
          this.server = server;

          initComponents();
          prepareForm();
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
          txtPassword = new javax.swing.JPasswordField();
          lblPassword = new javax.swing.JLabel();
          lblUsername = new javax.swing.JLabel();
          txtUsername = new javax.swing.JTextField();
          btnSave = new javax.swing.JButton();
          btnDefault = new javax.swing.JButton();

          jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Server settings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18))); // NOI18N

          lblPort.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          lblPort.setText("PORT NUMBER:");

          ftxtPort.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          ftxtPort.setFont(new java.awt.Font("Segoe UI", 1, 18));
          ftxtPort.setMinimumSize(new java.awt.Dimension(260, 22));
          NumberFormat nf = new DecimalFormat("####");
          NumberFormatter portFormatter = new NumberFormatter(nf);
          portFormatter.setValueClass(Integer.class);
          //portFormatter.setAllowsInvalid(false);
          portFormatter.setMinimum(1024);
          portFormatter.setMaximum(9999);
          ftxtPort = new JFormattedTextField(portFormatter);
          ftxtPort.setFont(new java.awt.Font("Segoe UI", 1, 18));
          ftxtPort.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          ftxtPort.addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyTyped(java.awt.event.KeyEvent evt) {
                    ftxtPortKeyTyped(evt);
               }
          });

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(lblPort, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ftxtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(17, 17, 17))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(30, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(ftxtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(lblPort, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(16, 16, 16))
          );

          jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Database settings", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18))); // NOI18N

          lblUrl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          lblUrl.setText("DATABASE URL:");

          txtUrl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          txtUrl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          txtUrl.addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyTyped(java.awt.event.KeyEvent evt) {
                    txtUrlKeyTyped(evt);
               }
          });

          txtPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseEntered(java.awt.event.MouseEvent evt) {
                    txtPasswordMouseEntered(evt);
               }
               public void mouseExited(java.awt.event.MouseEvent evt) {
                    txtPasswordMouseExited(evt);
               }
          });
          txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyTyped(java.awt.event.KeyEvent evt) {
                    txtPasswordKeyTyped(evt);
               }
          });

          lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          lblPassword.setText("PASSWORD:");

          lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          lblUsername.setText("USERNAME:");

          txtUsername.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
          txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyTyped(java.awt.event.KeyEvent evt) {
                    txtUsernameKeyTyped(evt);
               }
          });

          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
          jPanel2.setLayout(jPanel2Layout);
          jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                         .addGap(39, 39, 39)
                         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                              .addComponent(lblUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addContainerGap(394, Short.MAX_VALUE)))
          );
          jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(txtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)
                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(32, 32, 32))
               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                         .addGap(30, 30, 30)
                         .addComponent(lblUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(18, 18, 18)
                         .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addContainerGap(95, Short.MAX_VALUE)))
          );

          btnSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          btnSave.setText("SAVE SETTINGS");
          btnSave.setEnabled(false);
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addGroup(layout.createSequentialGroup()
                              .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(btnDefault, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(167, Short.MAX_VALUE))
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
                    .addContainerGap(41, Short.MAX_VALUE))
          );
     }// </editor-fold>//GEN-END:initComponents

     private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
          int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to save changes?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          if(response == JOptionPane.YES_OPTION){
               try {
                    Properties serverProperties = new Properties();
                    serverProperties.load(new FileInputStream("config/serverConfig.properties"));
                    serverProperties.setProperty("port",ftxtPort.getText().trim());
                    serverProperties.store(new FileOutputStream("config/serverConfig.properties"), "");
                    
                    Properties databaseProperties = new Properties();
                    databaseProperties.load(new FileInputStream("config/dbconfig.properties"));
                    databaseProperties.setProperty("url", txtUrl.getText().trim());
                    databaseProperties.setProperty("username", txtUsername.getText().trim());
                    databaseProperties.setProperty("password", String.copyValueOf(((JPasswordField) txtPassword).getPassword()));
                    databaseProperties.store(new FileOutputStream("config/dbconfig.properties"), "");
               } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Failed to save changes.", "Error", JOptionPane.ERROR_MESSAGE);
               }
               
               JOptionPane.showMessageDialog(this, "Changes succesfully saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
               btnSave.setEnabled(false);
          }
     }//GEN-LAST:event_btnSaveActionPerformed
     private void btnDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefaultActionPerformed
          // TODO add your handling code here:
     }//GEN-LAST:event_btnDefaultActionPerformed

     private void txtPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseEntered
          // Zasto ne radi?
          String password = String.valueOf(((JPasswordField) txtPassword).getPassword());
          txtPassword = new JTextField(password);
          
     }//GEN-LAST:event_txtPasswordMouseEntered

     private void txtPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseExited
          String password = txtPassword.getText();
          txtPassword = new JPasswordField(password);
     }//GEN-LAST:event_txtPasswordMouseExited

     private void txtUrlKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUrlKeyTyped
          changesMade = true;
          btnSave.setEnabled(true);
     }//GEN-LAST:event_txtUrlKeyTyped

     private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
          changesMade = true;
          btnSave.setEnabled(true);
     }//GEN-LAST:event_txtUsernameKeyTyped

     private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
          changesMade = true;
          btnSave.setEnabled(true);
     }//GEN-LAST:event_txtPasswordKeyTyped

     private void ftxtPortKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtPortKeyTyped
          changesMade = true;
          btnSave.setEnabled(true);
     }//GEN-LAST:event_ftxtPortKeyTyped

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
     private javax.swing.JTextField txtPassword;
     private javax.swing.JTextField txtUrl;
     private javax.swing.JTextField txtUsername;
     // End of variables declaration//GEN-END:variables

     private void prepareForm() {
          try {
               loadSettings();
          } catch (Exception ex) {
               Logger.getLogger(SettingsPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
     }

     private void loadSettings() throws Exception {
          Properties serverProperties = new Properties();
          serverProperties.load(new FileInputStream("config/serverConfig.properties"));
          
          String serverPort = serverProperties.getProperty("port");
          
          ftxtPort.setText(serverPort);
          
          Properties dataBaseProperties = new Properties();
          dataBaseProperties.load(new FileInputStream("config/dbConfig.properties"));
          
          String url = dataBaseProperties.getProperty("url");
          String username = dataBaseProperties.getProperty("username");
          String password = dataBaseProperties.getProperty("password");
          
          txtUrl.setText(url);
          txtUsername.setText(username);
          txtPassword.setText(password);
     }
}
