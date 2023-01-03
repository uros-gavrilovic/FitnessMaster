package gui.panels;

import server.Server;

public class ClientsPanel extends javax.swing.JPanel {
     Server server;
     
     public ClientsPanel(Server server) {
          this.server = server;
          
          initComponents();
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
          this.setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 761, Short.MAX_VALUE)
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGap(0, 524, Short.MAX_VALUE)
          );
     }// </editor-fold>//GEN-END:initComponents


     // Variables declaration - do not modify//GEN-BEGIN:variables
     // End of variables declaration//GEN-END:variables
}
