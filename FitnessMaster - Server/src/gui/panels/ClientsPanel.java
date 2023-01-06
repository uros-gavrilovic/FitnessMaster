package gui.panels;


import domain.Trainer;
import gui.models.ClientsTableModel;
import java.util.ArrayList;
import server.Server;

public class ClientsPanel extends javax.swing.JPanel {
     Server server;
     ArrayList<Trainer> clients;
     
     public ClientsPanel(Server server) {
          this.server = server;
          
          initComponents();
          prepareForm();
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jScrollPane1 = new javax.swing.JScrollPane();
          table = new javax.swing.JTable();

          table.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
          jScrollPane1.setViewportView(table);

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
          this.setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
                    .addContainerGap())
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE))
          );
     }// </editor-fold>//GEN-END:initComponents


     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JTable table;
     // End of variables declaration//GEN-END:variables

     private void prepareForm() {
          if (server == null) return;
     
          table.setModel(new ClientsTableModel(clients));
     }
}
