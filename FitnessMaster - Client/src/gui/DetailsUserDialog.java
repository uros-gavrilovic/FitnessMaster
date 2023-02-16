
package gui;

import com.raven.datechooser.DateChooser;
import communication.Response;
import communication.ResponseType;
import controller.Controller;
import domain.Gender;
import domain.Member;
import gui.lib.*;
import java.net.Socket;
import java.text.ParseException;
import java.util.HashMap;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.text.MaskFormatter;
import validator.ValidateOperation;
import validator.ValidateStatus;
import validator.Validator;

public class DetailsUserDialog extends javax.swing.JDialog {
     private Member member;
     private Socket socket;
     
     public DetailsUserDialog(java.awt.Frame parent, boolean modal, Member member, Socket socket) {
          super(parent, modal);

          this.socket = socket;
          this.member = member;
          
          initComponents();
          prepareForm();
         setLocationRelativeTo(null);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBirthDate = new javax.swing.JTextField();
        dateChooser = new DateChooser();
        dateChooser.setTextRefernce(txtBirthDate);
        jLabel8 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        MaskFormatter phoneFormatter = null;
        ftxtPhoneNumber =null;
        try{
            phoneFormatter = new MaskFormatter("###/##-##-###");
            phoneFormatter.setPlaceholderCharacter('_');
            ftxtPhoneNumber = new JFormattedTextField(phoneFormatter);
            cboxGender = new javax.swing.JComboBox<>();
            tbtnEdit = new gui.lib.CustomDarkToggleButton();
            btnDelete = new gui.lib.CustomDarkButton();
            btnSave = new gui.lib.CustomDarkButton();
            customDarkButton3 = new gui.lib.CustomDarkButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("FitnessMaster - More Details");
            setSize(new java.awt.Dimension(1050, 800));

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
                    .addContainerGap(377, Short.MAX_VALUE))
            );

            getContentPane().add(pnlWest, java.awt.BorderLayout.LINE_START);

            jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MEMBERSHIP HISTORY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 1, 20))); // NOI18N

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addContainerGap())
            );

            jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
            jLabel1.setText("CLIENT DETAILS");

            jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "GENERAL INFORMATION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Segoe UI", 1, 20))); // NOI18N

            jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            jLabel5.setText("Last name:");

            txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            txtAddress.setEnabled(false);

            jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            jLabel6.setText("Phone number:");

            jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            jLabel7.setText("Date of Birth:");

            txtBirthDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            txtBirthDate.setBorder(javax.swing.BorderFactory.createLineBorder(Painter.DARK));
            txtBirthDate.setEnabled(false);
            txtBirthDate.setPreferredSize(new java.awt.Dimension(64, 31));

            jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            jLabel8.setText("Address:");

            txtFirstName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            txtFirstName.setEnabled(false);

            jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            jLabel9.setText("First name:");

            txtLastName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            txtLastName.setEnabled(false);

            jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            jLabel10.setText("Gender:");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        ftxtPhoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Painter.DARK));
        ftxtPhoneNumber.setEnabled(false);
        ftxtPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        cboxGender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboxGender.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtPhoneNumber))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBirthDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        tbtnEdit.setText("EDIT");
        tbtnEdit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.setEnabled(false);
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setText("SAVE");
        btnSave.setEnabled(false);
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        customDarkButton3.setText("ADD MEMBERSHIP");
        customDarkButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tbtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customDarkButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                        .addGap(0, 16, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tbtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(customDarkButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnEditActionPerformed
        JToggleButton tbtn = (JToggleButton) evt.getSource();
        boolean isSelected = tbtn.isSelected();
        
        btnSave.setEnabled(tbtn.isSelected());
        btnDelete.setEnabled(tbtn.isSelected());
         
        txtFirstName.setEnabled(isSelected);
        txtLastName.setEnabled(isSelected);
        txtAddress.setEnabled(isSelected);
        txtBirthDate.setEnabled(isSelected);
        ftxtPhoneNumber.setEnabled(isSelected);
        cboxGender.setEnabled(isSelected);
        
        
        if(tbtn.isSelected()){
            tbtn.setText("DISABLE EDITING");
        } else {
            tbtn.setText("EDIT");
        }
    }//GEN-LAST:event_tbtnEditActionPerformed
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
         ValidateStatus validationStatus = Validator.getInstance().validate(ValidateOperation.VALIDATE_MEMBER_INFO, gatherData());
        if(validationStatus != ValidateStatus.OK){
            showErrorMessage(validationStatus);
            return;
        } 
        
        int userResponse = JOptionPane.showConfirmDialog(this, "Are you sure that you want to edit this member?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(userResponse == JOptionPane.NO_OPTION) return;

        try {
            Response response = Controller.getInstance(socket).updateMember(gatherData());
            
            if (response.getResponseType().equals(ResponseType.SUCCESS)) {
                JOptionPane.showMessageDialog(this, "Member sucessfully edited!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error while editing selected member!\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int userResponse = JOptionPane.showConfirmDialog(this, "Are you sure that you want to delete this member?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(userResponse == JOptionPane.NO_OPTION) return;
        
        try {
            Response response = Controller.getInstance(socket).deleteMember(member);

            System.out.println(response);
            if (response.getResponseType().equals(ResponseType.SUCCESS)) {
                JOptionPane.showMessageDialog(this, "Member sucessfully deleted!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error while deleting selected member!\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.lib.CustomDarkButton btnDelete;
    private gui.lib.CustomDarkButton btnSave;
    private javax.swing.JComboBox<Gender> cboxGender;
    private gui.lib.CustomDarkButton customDarkButton3;
    private javax.swing.JFormattedTextField ftxtPhoneNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JPanel pnlWest;
    private javax.swing.JTable table;
    private gui.lib.CustomDarkToggleButton tbtnEdit;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirthDate;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
          lblFirstname.setText(member.getFirstName());
          lblLastname.setText(member.getLastName());
          lblPicture.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/user_picture.png")),188, 170));
          
          txtFirstName.setText(member.getFirstName());
          txtLastName.setText(member.getLastName());
          txtAddress.setText(member.getAddress());
          ftxtPhoneNumber.setText(member.getPhoneNumber());
          try{
              txtBirthDate.setText(member.getDateOfBirth().toString());
          } catch (NullPointerException e) {
              txtBirthDate.setText("");
          }
          
          prepareCBox();
          cboxGender.setSelectedItem(member.getGender());
          
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
    private void prepareCBox() {
        cboxGender.addItem(Gender.MALE);
        cboxGender.addItem(Gender.FEMALE);
     }

    private HashMap<String, Object> gatherData() {
        HashMap<String, Object> data = new HashMap<>();

        data.put("id", member.getMemberID());
        data.put("firstName", txtFirstName.getText());
        data.put("lastName", txtLastName.getText());
        data.put("address", txtAddress.getText());
        if(ftxtPhoneNumber.isValid()){
            data.put("phoneNumber", ftxtPhoneNumber.getText());
        } else {
            data.put("phoneNumber", null);
        }
        data.put("dateOfBirth", txtBirthDate.getText());
        data.put("gender", cboxGender.getSelectedItem());

        return data;
    }
    private void showErrorMessage(ValidateStatus status) {
        switch (status) {
            case OK:
                return;
            case ERROR_FIRST_NAME:
                JOptionPane.showMessageDialog(this, "First name is a required field.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            case ERROR_LAST_NAME:
                JOptionPane.showMessageDialog(this, "Last name is required field", "Error", JOptionPane.WARNING_MESSAGE);
                return;
            case ERROR_BIRTH_DATE:
                JOptionPane.showMessageDialog(this, "Birth date must be before current date.", "Error", JOptionPane.WARNING_MESSAGE);
                return;
        }
    }
}
