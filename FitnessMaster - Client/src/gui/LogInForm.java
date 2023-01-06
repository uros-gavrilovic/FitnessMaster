package gui;

import communication.*;
import domain.Trainer;
import gui.lib.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import communication.Receiver;
import exceptions.ReceiverException;
import exceptions.SenderException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogInForm extends javax.swing.JDialog {
    Socket socket;
    
    public LogInForm(Socket socket) {
        this.socket = socket;
        
        setSize(350, 335);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          lblUsername1 = new javax.swing.JLabel();
          panel = new javax.swing.JPanel();
          lblLogo = new javax.swing.JLabel();
          lblUsername = new javax.swing.JLabel();
          lblPassword = new javax.swing.JLabel();
          txtUsername = new javax.swing.JTextField();
          txtPassword = new javax.swing.JPasswordField();
          btnLogin = new CustomLightButton();

          lblUsername1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
          lblUsername1.setText("KORISNIČKO IME:");

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setTitle("FitnessMaster - Early Access");
          setBackground(new java.awt.Color(41, 42, 43));
          setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/smallIcon_light.png")).getImage());
          setResizable(false);
          setSize(new java.awt.Dimension(350, 335));
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

          panel.setBackground(new java.awt.Color(41, 42, 43));
          panel.setForeground(new java.awt.Color(253, 253, 253));

          lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          lblLogo.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/logo.png")),200, 200));

          lblUsername.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
          lblUsername.setForeground(new java.awt.Color(238, 238, 238));
          lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          lblUsername.setText("USERNAME:");
          lblUsername.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

          lblPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 15)); // NOI18N
          lblPassword.setForeground(new java.awt.Color(238, 238, 238));
          lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
          lblPassword.setText("PASSWORD:");
          lblPassword.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

          txtUsername.setBackground(new java.awt.Color(41, 42, 43));
          txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
          txtUsername.setForeground(new java.awt.Color(238, 238, 238));
          txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(238, 238, 238)));
          txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyPressed(java.awt.event.KeyEvent evt) {
                    txtUsernameKeyPressed(evt);
               }
          });

          txtPassword.setBackground(new java.awt.Color(41, 42, 43));
          txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
          txtPassword.setForeground(new java.awt.Color(255, 255, 255));
          txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(238, 238, 238)));
          txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyPressed(java.awt.event.KeyEvent evt) {
                    txtPasswordKeyPressed(evt);
               }
          });

          btnLogin.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
          btnLogin.setText("SIGN IN");
          btnLogin.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnLoginActionPerformed(evt);
               }
          });

          javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
          panel.setLayout(panelLayout);
          panelLayout.setHorizontalGroup(
               panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(panelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addGroup(panelLayout.createSequentialGroup()
                              .addGap(12, 12, 12)
                              .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                   .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPassword))
                                   .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addGap(0, 21, Short.MAX_VALUE)))
                    .addContainerGap())
          );
          panelLayout.setVerticalGroup(
               panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                    .addContainerGap(24, Short.MAX_VALUE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(lblUsername)
                         .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addComponent(lblPassword)
                         .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
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

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
           if(validateForm() == false) return;  
           
           String username = txtUsername.getText();
           String password = String.valueOf(txtPassword.getPassword());

           Trainer trainer = new Trainer();
//           trainer.setUsername(username);
//           trainer.setPassword(password);
           trainer.setUsername("admin");     // TESTING
           trainer.setPassword("admin");     // TESTING

           
            Request request = new Request();
            request.setArgument(trainer);
            request.setOperation(Operation.LOG_IN);
            
            try {
                new Sender(socket).send(request);
                Response response = (Response) new Receiver(socket).receive();
                
                if (response.getResponseType().equals(ResponseType.SUCCESS)) {
                    dispose();
                    openAppForm((Trainer) response.getResult(), socket);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password.", "Unable to log in", JOptionPane.INFORMATION_MESSAGE);
                }   
            } catch (SenderException ex) {
                System.err.println("ERROR: Failed to send request.");
            } catch (ReceiverException ex) {
                System.out.println("ERROR: Failed to receive response.");
        }
    }//GEN-LAST:event_btnLoginActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        disconnect();
    }//GEN-LAST:event_formWindowClosing
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        keyboardShortcutEvent(evt);
    }//GEN-LAST:event_formKeyPressed
    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        keyboardShortcutEvent(evt);
    }//GEN-LAST:event_txtUsernameKeyPressed
    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        keyboardShortcutEvent(evt);
    }//GEN-LAST:event_txtPasswordKeyPressed

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton btnLogin;
     private javax.swing.JLabel lblLogo;
     private javax.swing.JLabel lblPassword;
     private javax.swing.JLabel lblUsername;
     private javax.swing.JLabel lblUsername1;
     private javax.swing.JPanel panel;
     private javax.swing.JPasswordField txtPassword;
     private javax.swing.JTextField txtUsername;
     // End of variables declaration//GEN-END:variables

    private void keyboardShortcutEvent(KeyEvent evt){
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                btnLoginActionPerformed(null);
                break;
            case KeyEvent.VK_ESCAPE:
                disconnect();
                dispose();
                openMainMenu();
                break;
        }
    }
    private boolean validateForm() {
         return true;    // TESTING
         
//        String username = txtUsername.getText();
//        String password = String.valueOf(txtPassword.getPassword());
//        
//        if(username.isBlank() || password.isBlank()){
//            JOptionPane.showMessageDialog(this, "Please enter your username and password", "Login error", JOptionPane.INFORMATION_MESSAGE);
//            return false;
//        } else {
//            return true;
//        }
    }
    
    private void openMainMenu() {
        new MainMenuForm().setVisible(true);
    }
    private void openAppForm(Trainer user, Socket socket) {
        new AppForm(user, socket).setVisible(true);
    }

    private void disconnect() {
        try {
            new Sender(socket).send(new Request(Operation.DISCONNECT, null));
            socket.close();
        } catch (SenderException ex) {
            System.err.println("ERROR: Failed to send disconnect request.");
        } catch (IOException ex) {
            System.err.println("ERROR: Failed to close socket.");
        }
    }
}
