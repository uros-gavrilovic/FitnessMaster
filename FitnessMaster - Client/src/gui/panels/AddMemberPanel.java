package gui.panels;

import gui.lib.*;
import com.raven.datechooser.*;
import validator.ValidateOperation;
import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import controller.Controller;
import domain.Gender;
import domain.Member;
import java.awt.Color;
import java.net.Socket;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import gui.lib.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import validator.ValidateStatus;
import validator.Validator;

public class AddMemberPanel extends javax.swing.JPanel {
    Socket socket;

    public AddMemberPanel(Socket socket) {
        this.socket = socket;

        initComponents();
        prepareForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFirstName = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblPhoneNumber = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        cboxGender = new javax.swing.JComboBox<>();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        btnSaveMember = new CustomDarkButton();
        lblBirthdate = new javax.swing.JLabel();
        txtBirthDate = new javax.swing.JTextField();
        dateChooser = new DateChooser();
        dateChooser.setTextRefernce(txtBirthDate);
        lblHeader = new javax.swing.JLabel();
        MaskFormatter phoneFormatter = null;
        ftxtPhoneNumber =null;
        try{
            phoneFormatter = new MaskFormatter("###/##-##-###");
            phoneFormatter.setPlaceholderCharacter('_');
            ftxtPhoneNumber = new JFormattedTextField(phoneFormatter);
            lblRequiredFields = new javax.swing.JLabel();
            txtErrorFirstName = new javax.swing.JLabel();
            txtErrorPhoneNumber = new javax.swing.JLabel();
            txtErrorAddress = new javax.swing.JLabel();
            txtErrorLastName = new javax.swing.JLabel();
            txtErrorGender = new javax.swing.JLabel();
            txtErrorBirthDate = new javax.swing.JLabel();

            lblFirstName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            lblFirstName.setText("First name: *");

            lblGender.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            lblGender.setText("Gender:");

            lblLastName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            lblLastName.setText("Last name: *");

            lblPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            lblPhoneNumber.setText("Phone number:");

            lblAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            lblAddress.setText("Address:");

            cboxGender.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
            cboxGender.setMaximumRowCount(2);
            cboxGender.setBorder(javax.swing.BorderFactory.createLineBorder(Painter.DARK));

            txtFirstName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
            txtFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(Painter.DARK));

            txtLastName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
            txtLastName.setBorder(javax.swing.BorderFactory.createLineBorder(Painter.DARK));

            txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
            txtAddress.setBorder(javax.swing.BorderFactory.createLineBorder(Painter.DARK));

            btnSaveMember.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            btnSaveMember.setText("SAVE MEMBER");
            btnSaveMember.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSaveMemberActionPerformed(evt);
                }
            });

            lblBirthdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            lblBirthdate.setText("Date of Birth:");

            txtBirthDate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
            txtBirthDate.setBorder(javax.swing.BorderFactory.createLineBorder(Painter.DARK));

            lblHeader.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
            lblHeader.setText("<html><u>CREATE A NEW MEMBER</u></html>");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        ftxtPhoneNumber.setBorder(javax.swing.BorderFactory.createLineBorder(Painter.DARK));
        ftxtPhoneNumber.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        lblRequiredFields.setFont(new java.awt.Font("Segoe UI", 2, 17)); // NOI18N
        lblRequiredFields.setText("* - Required fields");

        txtErrorFirstName.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N

        txtErrorPhoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N

        txtErrorAddress.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N

        txtErrorLastName.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N

        txtErrorGender.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N

        txtErrorBirthDate.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLastName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBirthDate))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftxtPhoneNumber))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSaveMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRequiredFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtErrorFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtErrorPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(txtErrorAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(txtErrorLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(txtErrorGender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(txtErrorBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtErrorFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblLastName)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtErrorGender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblGender)
                                                .addComponent(cboxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblAddress)
                                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtErrorAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lblPhoneNumber)
                                            .addComponent(ftxtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtErrorPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtErrorLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBirthdate)
                            .addComponent(txtBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtErrorBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lblRequiredFields)
                .addGap(18, 18, 18)
                .addComponent(btnSaveMember, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveMemberActionPerformed
        clearErrorBorders();
        ValidateStatus validationStatus = Validator.getInstance().validate(ValidateOperation.VALIDATE_MEMBER_INFO, gatherData());
        
        if(validationStatus != ValidateStatus.OK) {
            showError(validationStatus);
            return;
        } else {
            clearErrorBorders();
        }
        
        try {
            Response response = Controller.getInstance(socket).saveMember(gatherData());

            if (response.getResponseType().equals(ResponseType.SUCCESS)) {
                JOptionPane.showMessageDialog(this, "Member sucessfully added!", "Adding new member", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error while adding new member!\n" + ex.getMessage(), "Adding new member", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveMemberActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveMember;
    private javax.swing.JComboBox<Gender> cboxGender;
    private javax.swing.JFormattedTextField ftxtPhoneNumber;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirthdate;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblRequiredFields;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirthDate;
    private com.raven.datechooser.DateChooser dateChooser;
    private javax.swing.JLabel txtErrorAddress;
    private javax.swing.JLabel txtErrorBirthDate;
    private javax.swing.JLabel txtErrorFirstName;
    private javax.swing.JLabel txtErrorGender;
    private javax.swing.JLabel txtErrorLastName;
    private javax.swing.JLabel txtErrorPhoneNumber;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        dateChooser.getTextRefernce().setText("");
        
        for(Gender g : Gender.values()) cboxGender.addItem(g);
        cboxGender.setSelectedItem(null);
    }
    private void clearForm() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAddress.setText("");
        ftxtPhoneNumber.setValue(null);
        txtBirthDate.setText("");
        cboxGender.setSelectedItem(null);
    }
    private HashMap<String, Object> gatherData() {
        HashMap<String, Object> data = new HashMap<>();

        data.put("firstName", txtFirstName.getText());
        data.put("lastName", txtLastName.getText());
        data.put("gender", cboxGender.getSelectedItem());
        data.put("address", txtAddress.getText());
        data.put("phoneNumber", lblPhoneNumber.getText());
        data.put("dateOfBirth", txtBirthDate.getText());

        return data;
    }

    private void showError(ValidateStatus status) {
        switch (status) {
            case ERROR_FIRST_NAME:
                addErrorBorder(txtFirstName, txtErrorFirstName, "Field first name musn't be empty!");
                return;
            case ERROR_LAST_NAME:
                addErrorBorder(txtBirthDate, txtErrorLastName, "Field last name musn't be empty!");
                return;
            case ERROR_BIRTH_DATE:
                addErrorBorder(txtBirthDate, txtErrorBirthDate, "Date of birth must not be after or equal to current date!");
                return;
        }
    }
    private void addErrorBorder(JTextField field, JLabel label, String message) {
        Border redBorder =  new LineBorder(Color.RED, 1); 
        label.setText(message);
    }
    private void clearErrorBorders(){
        Border defaultBorder =  new LineBorder(Painter.DARK, 1);
        
        JTextField fieldsArray[] = {txtFirstName, txtLastName, txtBirthDate};
        JLabel labelsArray[] = {txtErrorFirstName, txtErrorLastName, txtErrorBirthDate};
        
        for(int i=0; i<fieldsArray.length; i++){
            fieldsArray[i].setBorder(defaultBorder);
            labelsArray[i].setText("");
        }
    }
}
