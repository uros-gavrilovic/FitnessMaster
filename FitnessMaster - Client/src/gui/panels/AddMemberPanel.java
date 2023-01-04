package gui.panels;

import gui.lib.Painter;
import com.raven.datechooser.*;
import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
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
import javax.swing.JOptionPane;

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
        btnSaveMember = new javax.swing.JButton();
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
        if (validateData() == false) return;
            String firstName = txtFirstName.getText();
            String lastName = txtLastName.getText();

            Gender gender;
            try {
                gender = (Gender) cboxGender.getSelectedItem();
            } catch (Exception e) {
                gender = null;
            }

            String address;
            if (!txtAddress.getText().isBlank()) {
                address = txtAddress.getText();
            } else {
                address = null;
            }

            String phoneNumber;
            if (!ftxtPhoneNumber.getText().matches("___/__-__-___")) { // TODO: Postoji li bolji nacin da se vidi da li je korisnik ostavio prazno
                phoneNumber = ftxtPhoneNumber.getText();
            } else {
                phoneNumber = null;
            }

            LocalDate birthDate;
            if (!txtBirthDate.getText().isBlank()) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
                birthDate = LocalDate.parse(txtBirthDate.getText(), formatter);
            } else {
                birthDate = null;
            }

            Member member = new Member(firstName, lastName, gender, address, phoneNumber, birthDate);
            Request request = new Request(Operation.ADD_MEMBER, member);

            try {
                new Sender(socket).send(request);
                Response response = (Response) new Receiver(socket).receive();
                
                if(response.getResponseType().equals(ResponseType.SUCCESS)){
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

    private boolean validateData() {
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
//        Object gender = cboxGender.getSelectedItem();
//        String address = txtAddress.getText();
//        String phoneNumber = lblPhoneNumber.getText();
        // OPTIONAL FIELDS

        Border defaultBorder = new LineBorder(Painter.DARK, 1);
        Border redBorder = new LineBorder(Color.RED, 1);

        if (firstName.trim().isEmpty()) {
            txtFirstName.setBorder(redBorder);
            txtErrorFirstName.setText("First name must be entered!");
            return false;
        } else {
            txtFirstName.setBorder(defaultBorder);
            txtErrorFirstName.setVisible(false);
        }

        if (lastName.trim().isEmpty()) {
            txtLastName.setBorder(redBorder);
            txtErrorLastName.setText("Last name must be entered!");
            return false;
        } else {
            txtLastName.setBorder(defaultBorder);
            txtErrorLastName.setVisible(false);
        }

        if (!txtBirthDate.getText().trim().isEmpty()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
            LocalDate birthDate = LocalDate.parse(txtBirthDate.getText(), formatter);
            if (birthDate.isAfter(LocalDate.now()) || birthDate.isEqual(LocalDate.now())) {
                txtBirthDate.setBorder(redBorder);
                txtErrorBirthDate.setText("Date of birth must not be after or equal to current date.");
                return false;
            } else {
                txtBirthDate.setBorder(defaultBorder);
                txtErrorBirthDate.setVisible(false);
            }
        }

        return true;
    }

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
}
