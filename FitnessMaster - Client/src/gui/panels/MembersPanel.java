package gui.panels;

import communication.*;
import controller.Controller;
import domain.Member;
import domain.Trainer;
import gui.AppForm;
import gui.DetailsUserDialog;
import gui.models.MemberTableModel;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import gui.lib.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MembersPanel extends javax.swing.JPanel {
    Trainer user;
    Socket socket;
    ArrayList<Member> members;
    
    public MembersPanel(Trainer user, Socket socket) {
        this.user = user;
        this.socket = socket;
        
        initComponents();
        prepareForm();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnDetails = new CustomDarkButton();
        btnRemoveMember = new CustomDarkButton();

        lblHeader.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblHeader.setText("<html><u>MEMBERS LIST</u></html>");

        table.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        table.setRowHeight(30);
        table.setSelectionBackground(Painter.GREEN);
        table.setShowGrid(false);
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        lblSearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSearch.setText("Search:");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnDetails.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDetails.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/details_light.png")),40, 40));
        btnDetails.setText("MORE DETAILS");
        btnDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDetailsMouseExited(evt);
            }
        });
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        btnRemoveMember.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRemoveMember.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/delete_member_light.png")),40, 40));
        btnRemoveMember.setText("REMOVE MEMBER");
        btnRemoveMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRemoveMemberMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRemoveMemberMouseExited(evt);
            }
        });
        btnRemoveMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveMemberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 410, Short.MAX_VALUE)
                        .addComponent(btnDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveMember, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 633, Short.MAX_VALUE)
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnRemoveMember, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchCriteria = txtSearch.getText().toLowerCase();            // PITANJE: Da li je bolje pretrazivati na osnovu liste u radnoj memoriji ili slati zahtev serveru da trazi po imenu?

        ArrayList<Member> membersFitCriteria = new ArrayList<>();
        
        for(Member m: members){
            String fullName = m.getFirstName().toLowerCase() + " " + m.getLastName().toLowerCase();
            if (fullName.contains(searchCriteria)) membersFitCriteria.add(m);
        }
        
        table.setModel(new MemberTableModel(membersFitCriteria));
    }//GEN-LAST:event_txtSearchKeyReleased

     private void btnDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetailsMouseEntered
         btnDetails.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/details_dark.png")), 40, 40));
     }//GEN-LAST:event_btnDetailsMouseEntered
     private void btnDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDetailsMouseExited
         btnDetails.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/details_light.png")), 40, 40));
     }//GEN-LAST:event_btnDetailsMouseExited
     private void btnRemoveMemberMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMemberMouseEntered
         btnRemoveMember.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/delete_member_dark.png")), 40, 40));
     }//GEN-LAST:event_btnRemoveMemberMouseEntered
     private void btnRemoveMemberMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMemberMouseExited
         btnRemoveMember.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/delete_member_light.png")), 40, 40));
     }//GEN-LAST:event_btnRemoveMemberMouseExited

     private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
          if(table.getSelectedRow() != -1){
               Member selectedMember = members.get(table.getSelectedRow());
              new DetailsUserDialog(null, true, selectedMember, socket).setVisible(true);
              
          } else {
               JOptionPane.showMessageDialog(this, "Please choose member you wish to see more details about", "Choose member", JOptionPane.WARNING_MESSAGE);
          }
     }//GEN-LAST:event_btnDetailsActionPerformed
    private void btnRemoveMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveMemberActionPerformed
        if (table.getSelectedRow() != -1) {
            int userResponse = JOptionPane.showConfirmDialog(this, "Are you sure that you want to delete this member?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (userResponse == JOptionPane.NO_OPTION) {
                return;
            }

            try {
                Member selectedMember = members.get(table.getSelectedRow());
                Response response = Controller.getInstance(socket).deleteMember(selectedMember);

                if (response.getResponseType().equals(ResponseType.SUCCESS)) {
                    JOptionPane.showMessageDialog(this, "Member sucessfully deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    prepareTable();
                }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error while deleting selected member!\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        } else {
            JOptionPane.showMessageDialog(this, "Please choose member you wish to delete.", "Choose member", JOptionPane.WARNING_MESSAGE);   
        }
    }//GEN-LAST:event_btnRemoveMemberActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnRemoveMember;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        prepareTable();
    }
    private void prepareTable() {
        try {
            Request request = new Request(Operation.GET_MEMBERS, null);
            new Sender(socket).send(request);
            
            Response response = (Response) new Receiver(socket).receive();
            if (response.getResponseType().equals(ResponseType.SUCCESS)) {
                members = (ArrayList<Member>) response.getResult();
                table.setModel(new MemberTableModel(members));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error retreiving members list.\n" + ex.getMessage(), "Retreiving members", JOptionPane.ERROR_MESSAGE);
        }
    }    
}
