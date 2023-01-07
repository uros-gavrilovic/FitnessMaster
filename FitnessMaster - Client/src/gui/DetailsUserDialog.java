
package gui;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import domain.Member;
import gui.lib.*;
import gui.models.MemberTableModel;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DetailsUserDialog extends javax.swing.JDialog {
     Member member;
     
     public DetailsUserDialog(java.awt.Frame parent, boolean modal, Member member, Socket socket) {
          super(parent, modal);
          
          this.member = member;
          
          initComponents();
          prepareForm();
     }

     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          pnlWest = new javax.swing.JPanel();
          lblPicture = new javax.swing.JLabel();
          lblFirstname = new javax.swing.JLabel();
          lblLastname = new javax.swing.JLabel();
          jPanel1 = new javax.swing.JPanel();
          jPanel2 = new javax.swing.JPanel();
          jScrollPane1 = new javax.swing.JScrollPane();
          table = new javax.swing.JTable();
          jLabel1 = new javax.swing.JLabel();
          jButton1 = new CustomDarkButton();
          jButton2 = new CustomDarkButton();
          jButton3 = new CustomDarkButton();
          jPanel3 = new javax.swing.JPanel();
          jLabel5 = new javax.swing.JLabel();
          txtAddress = new javax.swing.JTextField();
          txtPhone = new javax.swing.JTextField();
          jLabel6 = new javax.swing.JLabel();
          txtBirthdate = new javax.swing.JTextField();
          jLabel7 = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

          pnlWest.setBackground(Painter.DARK);
          pnlWest.setPreferredSize(new java.awt.Dimension(200, 698));

          lblPicture.setMinimumSize(new java.awt.Dimension(190, 200));
          lblPicture.setPreferredSize(new java.awt.Dimension(200, 200));

          lblFirstname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          lblFirstname.setForeground(new java.awt.Color(255, 255, 255));

          lblLastname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          lblLastname.setForeground(new java.awt.Color(255, 255, 255));

          javax.swing.GroupLayout pnlWestLayout = new javax.swing.GroupLayout(pnlWest);
          pnlWest.setLayout(pnlWestLayout);
          pnlWestLayout.setHorizontalGroup(
               pnlWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(pnlWestLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(lblFirstname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(lblLastname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlWestLayout.createSequentialGroup()
                              .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 188, Short.MAX_VALUE)
                              .addContainerGap())))
          );
          pnlWestLayout.setVerticalGroup(
               pnlWestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(pnlWestLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(lblFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(383, Short.MAX_VALUE))
          );

          getContentPane().add(pnlWest, java.awt.BorderLayout.LINE_START);

          jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MEMBERSHIP HISTORY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 1, 20))); // NOI18N

          table.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
               },
               new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
               }
          ));
          jScrollPane1.setViewportView(table);

          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
          jPanel2.setLayout(jPanel2Layout);
          jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap())
          );
          jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addContainerGap())
          );

          jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
          jLabel1.setText("CLIENT DETAILS");

          jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          jButton1.setText("EDIT");

          jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          jButton2.setText("DELETE");

          jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
          jButton3.setText("ADD MEMBERSHIP");

          jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GENERAL INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 1, 20))); // NOI18N

          jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
          jLabel5.setText("Address:");

          txtAddress.setEditable(false);
          txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

          txtPhone.setEditable(false);
          txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

          jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
          jLabel6.setText("Phone number:");

          txtBirthdate.setEditable(false);
          txtBirthdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

          jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
          jLabel7.setText("Date of Birth:");

          javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
          jPanel3.setLayout(jPanel3Layout);
          jPanel3Layout.setHorizontalGroup(
               jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addGroup(jPanel3Layout.createSequentialGroup()
                              .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(18, 18, 18)
                              .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE))
                         .addGroup(jPanel3Layout.createSequentialGroup()
                              .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(18, 18, 18)
                              .addComponent(txtPhone))
                         .addGroup(jPanel3Layout.createSequentialGroup()
                              .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addGap(18, 18, 18)
                              .addComponent(txtBirthdate)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );
          jPanel3Layout.setVerticalGroup(
               jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          );

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addContainerGap()
                              .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addGap(0, 126, Short.MAX_VALUE)))
                    .addContainerGap())
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                         .addContainerGap()
                         .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addContainerGap()))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                         .addGap(102, 102, 102)
                         .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addContainerGap(421, Short.MAX_VALUE)))
          );

          getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

          pack();
     }// </editor-fold>//GEN-END:initComponents

     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton jButton1;
     private javax.swing.JButton jButton2;
     private javax.swing.JButton jButton3;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JLabel jLabel7;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JPanel jPanel3;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JLabel lblFirstname;
     private javax.swing.JLabel lblLastname;
     private javax.swing.JLabel lblPicture;
     private javax.swing.JPanel pnlWest;
     private javax.swing.JTable table;
     private javax.swing.JTextField txtAddress;
     private javax.swing.JTextField txtBirthdate;
     private javax.swing.JTextField txtPhone;
     // End of variables declaration//GEN-END:variables

     private void prepareForm() {
          lblFirstname.setText(member.getFirstName());
          lblLastname.setText(member.getLastName());
          lblPicture.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/user_picture.png")),188, 170));
          
          txtAddress.setText(member.getAddress());
          txtBirthdate.setText(member.getDateOfBirth().toString());
          txtPhone.setText(member.getPhoneNumber());
          
//          try {
//               Request request = new Request(Operation.GET_MEMBERSHIPS, null);
//               new Sender(socket).send(request);
//
//               Response response = (Response) new Receiver(socket).receive();
//               if (response.getResponseType().equals(ResponseType.SUCCESS)) {
//                    members = (ArrayList<Member>) response.getResult();
//                    table.setModel(new MemberTableModel(members));
//               }
//          } catch (Exception ex) {
//               JOptionPane.showMessageDialog(this, "Error retreiving members list.\n" + ex.getMessage(), "Retreiving members", JOptionPane.ERROR_MESSAGE);
//          }
     }
}
