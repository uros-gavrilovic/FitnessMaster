package gui.panels;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import controller.Controller;
import domain.BodyPart;
import domain.Category;
import domain.Exercise;
import gui.lib.*;
import gui.models.ExerciseTableModel;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import gui.lib.Painter;
import java.util.HashMap;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import validator.ValidateOperation;
import validator.ValidateStatus;
import validator.Validator;

public class ExercisesPanel extends javax.swing.JPanel {
    Socket socket;
    ArrayList<Exercise> exercises;
    
    public ExercisesPanel(Socket socket) {
        this.socket = socket;

        try {
            Response response = Controller.getInstance(socket).getExercises();
            if (response.getResponseType().equals(ResponseType.SUCCESS)) {
                exercises = (ArrayList<Exercise>) response.getResult();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error retreiving exercises list.\n" + ex.getMessage(), "Retreiving exercises", JOptionPane.ERROR_MESSAGE);
        }
        
        initComponents();
        prepareForm();
        clearSearch();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        lblNumOfEntries = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        pnlAddExercise = new javax.swing.JPanel();
        lblAddName = new javax.swing.JLabel();
        txtAddName = new javax.swing.JTextField();
        btnCreateExercise = new CustomDarkButton();
        lblAddCategory = new javax.swing.JLabel();
        lblAddBodyPart = new javax.swing.JLabel();
        cboxAddCategory = new javax.swing.JComboBox<>();
        cboxAddBodyPart = new javax.swing.JComboBox<>();
        pnlAddExercise1 = new javax.swing.JPanel();
        lblEditID = new javax.swing.JLabel();
        txtEditID = new javax.swing.JTextField();
        txtEditName = new javax.swing.JTextField();
        lblEditName = new javax.swing.JLabel();
        cboxEditCategory = new javax.swing.JComboBox<>();
        lblEditCategory = new javax.swing.JLabel();
        lblEditBodyPart = new javax.swing.JLabel();
        cboxEditBodyPart = new javax.swing.JComboBox<>();
        btnDeleteExercise = new CustomDarkButton();
        btnUpdateExercise = new CustomDarkButton();
        tbtnEditing = new CustomDarkToggleButton();
        lblRequiredFields = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNumOfEntries1 = new javax.swing.JLabel();
        cboxSearchCategory = new javax.swing.JComboBox<>();
        cboxSearchBodyPart = new javax.swing.JComboBox<>();
        customDarkButton1 = new gui.lib.CustomDarkButton();

        lblHeader.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblHeader.setText("<html><u>EXERCISES LIST</u></html>");

        lblNumOfEntries.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNumOfEntries.setText("Category:");

        table.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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

        pnlAddExercise.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ADD NEW EXERCISE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        lblAddName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAddName.setText("Name: *");

        txtAddName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        btnCreateExercise.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCreateExercise.setText("CREATE EXERCISE");
        btnCreateExercise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateExerciseActionPerformed(evt);
            }
        });

        lblAddCategory.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAddCategory.setText("Category: *");

        lblAddBodyPart.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAddBodyPart.setText("Body part: *");

        cboxAddCategory.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        cboxAddBodyPart.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N

        javax.swing.GroupLayout pnlAddExerciseLayout = new javax.swing.GroupLayout(pnlAddExercise);
        pnlAddExercise.setLayout(pnlAddExerciseLayout);
        pnlAddExerciseLayout.setHorizontalGroup(
            pnlAddExerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddExerciseLayout.createSequentialGroup()
                .addGroup(pnlAddExerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddExerciseLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlAddExerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddExerciseLayout.createSequentialGroup()
                                .addComponent(lblAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboxAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddExerciseLayout.createSequentialGroup()
                                .addComponent(lblAddBodyPart, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboxAddBodyPart, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddExerciseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlAddExerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreateExercise, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddExerciseLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblAddName, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtAddName, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnlAddExerciseLayout.setVerticalGroup(
            pnlAddExerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddExerciseLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlAddExerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddName)
                    .addComponent(txtAddName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAddExerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddCategory))
                .addGap(18, 18, 18)
                .addGroup(pnlAddExerciseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxAddBodyPart)
                    .addComponent(lblAddBodyPart))
                .addGap(26, 26, 26)
                .addComponent(btnCreateExercise, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pnlAddExercise1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MODIFY EXISTING EXERCISE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        lblEditID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEditID.setText("Exercise ID: *");

        txtEditID.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txtEditID.setEnabled(false);

        txtEditName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txtEditName.setEnabled(false);

        lblEditName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEditName.setText("Name: *");

        cboxEditCategory.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        cboxEditCategory.setEnabled(false);

        lblEditCategory.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEditCategory.setText("Category: *");

        lblEditBodyPart.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEditBodyPart.setText("Body part: *");

        cboxEditBodyPart.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        cboxEditBodyPart.setEnabled(false);
        cboxEditBodyPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxEditBodyPartActionPerformed(evt);
            }
        });

        btnDeleteExercise.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDeleteExercise.setText("DELETE EXERCISE");
        btnDeleteExercise.setEnabled(false);
        btnDeleteExercise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteExerciseActionPerformed(evt);
            }
        });

        btnUpdateExercise.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdateExercise.setText("UPDATE EXERCISE");
        btnUpdateExercise.setEnabled(false);
        btnUpdateExercise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateExerciseActionPerformed(evt);
            }
        });

        tbtnEditing.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnEditing.setText("ENABLE EDITING");
        tbtnEditing.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbtnEditingStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlAddExercise1Layout = new javax.swing.GroupLayout(pnlAddExercise1);
        pnlAddExercise1.setLayout(pnlAddExercise1Layout);
        pnlAddExercise1Layout.setHorizontalGroup(
            pnlAddExercise1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddExercise1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddExercise1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteExercise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateExercise, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddExercise1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlAddExercise1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddExercise1Layout.createSequentialGroup()
                                .addGroup(pnlAddExercise1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlAddExercise1Layout.createSequentialGroup()
                                        .addComponent(lblEditID)
                                        .addGap(8, 8, 8))
                                    .addGroup(pnlAddExercise1Layout.createSequentialGroup()
                                        .addComponent(lblEditName, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(pnlAddExercise1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEditName, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                    .addComponent(txtEditID)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddExercise1Layout.createSequentialGroup()
                                .addGroup(pnlAddExercise1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblEditCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEditBodyPart, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlAddExercise1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboxEditCategory, 0, 286, Short.MAX_VALUE)
                                    .addComponent(cboxEditBodyPart, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(tbtnEditing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlAddExercise1Layout.setVerticalGroup(
            pnlAddExercise1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddExercise1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlAddExercise1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditID)
                    .addComponent(txtEditID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAddExercise1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEditName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEditName))
                .addGap(18, 18, 18)
                .addGroup(pnlAddExercise1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxEditCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEditCategory))
                .addGap(18, 18, 18)
                .addGroup(pnlAddExercise1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxEditBodyPart)
                    .addComponent(lblEditBodyPart))
                .addGap(18, 18, 18)
                .addComponent(btnUpdateExercise, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteExercise, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(tbtnEditing, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblRequiredFields.setFont(new java.awt.Font("Segoe UI", 2, 17)); // NOI18N
        lblRequiredFields.setText("* - Required fields");

        jLabel1.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/category.png")),50, 50));
        jLabel1.setPreferredSize(new java.awt.Dimension(55, 55));

        jLabel2.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/body.png")),50, 50));
        jLabel2.setMaximumSize(new java.awt.Dimension(55, 55));
        jLabel2.setPreferredSize(new java.awt.Dimension(55, 55));

        lblNumOfEntries1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNumOfEntries1.setText("Body part:");

        cboxSearchCategory.setPreferredSize(new java.awt.Dimension(160, 22));
        cboxSearchCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxSearchCategoryItemStateChanged(evt);
            }
        });

        cboxSearchBodyPart.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxSearchBodyPartItemStateChanged(evt);
            }
        });

        customDarkButton1.setText("CLEAR");
        customDarkButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customDarkButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlAddExercise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAddExercise1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblRequiredFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumOfEntries, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumOfEntries1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboxSearchBodyPart, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customDarkButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtSearch)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlAddExercise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlAddExercise1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNumOfEntries)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboxSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNumOfEntries1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboxSearchBodyPart, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblSearch)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(customDarkButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRequiredFields)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbtnEditingStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbtnEditingStateChanged
        txtEditName.setEnabled(tbtnEditing.isSelected());
        cboxEditBodyPart.setEnabled(tbtnEditing.isSelected());
        cboxEditCategory.setEnabled(tbtnEditing.isSelected());

        btnUpdateExercise.setEnabled(tbtnEditing.isSelected());
        btnDeleteExercise.setEnabled(tbtnEditing.isSelected());

        if (tbtnEditing.isSelected()) { // toggled
            tbtnEditing.setText("DISABLE EDITING");
        } else { // untoggled
            tbtnEditing.setText("ENABLE EDITING");
        }
    }//GEN-LAST:event_tbtnEditingStateChanged
    private void cboxEditBodyPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxEditBodyPartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxEditBodyPartActionPerformed
    private void cboxSearchCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxSearchCategoryItemStateChanged
        if(cboxSearchCategory.getSelectedIndex() == -1) return;
        
        Category selectedCategory = (Category) cboxSearchCategory.getSelectedItem();
        ArrayList<Exercise> exercisesFitCriteria = new ArrayList<>();
        
        for(Exercise e : exercises) {
            if (e.getCategory().equals(selectedCategory)) exercisesFitCriteria.add(e);
        }
        
        table.setModel(new ExerciseTableModel(exercisesFitCriteria));
    }//GEN-LAST:event_cboxSearchCategoryItemStateChanged
    private void cboxSearchBodyPartItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxSearchBodyPartItemStateChanged
        if(cboxSearchBodyPart.getSelectedIndex()== -1) return;
        
        BodyPart selectedBodyPart = (BodyPart) cboxSearchBodyPart.getSelectedItem();
        ArrayList<Exercise> exercisesFitCriteria = new ArrayList<>();
        
        for(Exercise e : exercises) {
            if (e.getBodyPart().equals(selectedBodyPart)) exercisesFitCriteria.add(e);
        }
        
        table.setModel(new ExerciseTableModel(exercisesFitCriteria));
    }//GEN-LAST:event_cboxSearchBodyPartItemStateChanged
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchCriteria = txtSearch.getText().toLowerCase();

        ArrayList<Exercise> exercisesFitCriteria = new ArrayList<>();
        
        for(Exercise e: exercises){
            if (e.getName().toLowerCase().contains(searchCriteria)) exercisesFitCriteria.add(e);
        }
        
        table.setModel(new ExerciseTableModel(exercisesFitCriteria));
    }//GEN-LAST:event_txtSearchKeyReleased
    private void btnCreateExerciseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateExerciseActionPerformed
        ValidateStatus validationStatus = Validator.getInstance().validate(ValidateOperation.VALIDATE_EXERCISE_INFO, gatherCreateData());
        if(validationStatus != ValidateStatus.OK){
            showErrorMessage(validationStatus);
            return;
        } 
        
        try {
            Response response = Controller.getInstance(socket).saveExercise(gatherCreateData());

            if (response.getResponseType().equals(ResponseType.SUCCESS)) {
                JOptionPane.showMessageDialog(this, "Exercise sucessfully added!", "Adding new exercise", JOptionPane.INFORMATION_MESSAGE);
                prepareTable();
                clearSearch();
                clearAdd();
                clearEdit();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error while adding new exercise!\n" + ex.getMessage(), "Adding new exercise", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCreateExerciseActionPerformed
    private void btnUpdateExerciseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateExerciseActionPerformed
        ValidateStatus validationStatus = Validator.getInstance().validate(ValidateOperation.VALIDATE_EXERCISE_INFO, gatherEditData());
        if(validationStatus != ValidateStatus.OK){
            showErrorMessage(validationStatus);
            return;
        } 
        
        int userResponse = JOptionPane.showConfirmDialog(this, "Are you sure that you want to edit this exercise?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(userResponse == JOptionPane.NO_OPTION) return;

        try {
            Response response = Controller.getInstance(socket).updateExercise(gatherEditData());

            if (response.getResponseType().equals(ResponseType.SUCCESS)) {
                JOptionPane.showMessageDialog(this, "Exercise sucessfully edited!", "Editing exercise", JOptionPane.INFORMATION_MESSAGE);
                prepareTable();
                clearSearch();
                clearAdd();
                clearEdit();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error while editing selected exercise!\n" + ex.getMessage(), "Adding new exercise", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnUpdateExerciseActionPerformed
    private void btnDeleteExerciseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteExerciseActionPerformed
        if(table.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select an exercise to delete.", "Deleting exercise", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int userResponse = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete selected exercise?", "Deleting exercise", JOptionPane.YES_NO_OPTION);
        if (userResponse == JOptionPane.NO_OPTION) return;

        try {
            Exercise selectedExercise = ((ExerciseTableModel) table.getModel()).getExerciseAt(table.getSelectedRow());
            Response response = Controller.getInstance(socket).deleteExercise(selectedExercise);
            
            if (response.getResponseType().equals(ResponseType.SUCCESS)) {
                JOptionPane.showMessageDialog(this, "Exercise succesfully deleted!", "Deleting exercise", JOptionPane.INFORMATION_MESSAGE);
                prepareTable();
                clearSearch();
                clearAdd();
                clearEdit();
            }
        } catch (Exception ex){
                JOptionPane.showMessageDialog(this, "Error while editing selected exercise!\n" + ex.getMessage(), "Delete exercise", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteExerciseActionPerformed

    private void customDarkButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customDarkButton1ActionPerformed
        clearSearch();
    }//GEN-LAST:event_customDarkButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateExercise;
    private javax.swing.JButton btnDeleteExercise;
    private javax.swing.JButton btnUpdateExercise;
    private javax.swing.JComboBox<BodyPart> cboxAddBodyPart;
    private javax.swing.JComboBox<Category> cboxAddCategory;
    private javax.swing.JComboBox<BodyPart> cboxEditBodyPart;
    private javax.swing.JComboBox<Category> cboxEditCategory;
    private javax.swing.JComboBox<BodyPart> cboxSearchBodyPart;
    private javax.swing.JComboBox<Category> cboxSearchCategory;
    private gui.lib.CustomDarkButton customDarkButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddBodyPart;
    private javax.swing.JLabel lblAddCategory;
    private javax.swing.JLabel lblAddName;
    private javax.swing.JLabel lblEditBodyPart;
    private javax.swing.JLabel lblEditCategory;
    private javax.swing.JLabel lblEditID;
    private javax.swing.JLabel lblEditName;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblNumOfEntries;
    private javax.swing.JLabel lblNumOfEntries1;
    private javax.swing.JLabel lblRequiredFields;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JPanel pnlAddExercise;
    private javax.swing.JPanel pnlAddExercise1;
    private javax.swing.JTable table;
    private javax.swing.JToggleButton tbtnEditing;
    private javax.swing.JTextField txtAddName;
    private javax.swing.JTextField txtEditID;
    private javax.swing.JTextField txtEditName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        prepareTable();

        for (BodyPart bp : BodyPart.values()) {
            cboxSearchBodyPart.addItem(bp);
            cboxAddBodyPart.addItem(bp);
            cboxEditBodyPart.addItem(bp);
        }        
        cboxSearchBodyPart.setSelectedItem(null);
        cboxAddBodyPart.setSelectedItem(null);
        cboxEditBodyPart.setSelectedItem(null);

        for (Category c : Category.values()) {
            cboxSearchCategory.addItem(c);
            cboxAddCategory.addItem(c);
            cboxEditCategory.addItem(c);
        }
        cboxSearchCategory.setSelectedItem(null);
        cboxAddCategory.setSelectedItem(null);
        cboxEditCategory.setSelectedItem(null);

    }

    private void prepareTable() {
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if(table.getSelectedRow() != -1){
                    Exercise selectedExercise = ((ExerciseTableModel) table.getModel()).getExerciseAt(table.getSelectedRow());

                    cboxEditCategory.setSelectedItem(selectedExercise.getCategory());
                    cboxEditBodyPart.setSelectedItem(selectedExercise.getBodyPart());
                    txtEditName.setText(selectedExercise.getName());
                    txtEditID.setText(Integer.toString(selectedExercise.getExerciseID()));
                }
            }
        });
        
        try {
            Request request = new Request(Operation.GET_EXERCISES, null);
            new Sender(socket).send(request);

            Response response = (Response) new Receiver(socket).receive();
            if (response.getResponseType().equals(ResponseType.SUCCESS)) {
                exercises = (ArrayList<Exercise>) response.getResult();
                table.setModel(new ExerciseTableModel(exercises));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error retreiving exercises list.\n"+ ex.getMessage(), "Retreiving exercises", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearSearch() {
        txtSearch.setText("");
        cboxSearchBodyPart.setSelectedItem(null);
        cboxSearchCategory.setSelectedItem(null);
        
        txtSearchKeyReleased(null); // TODO: Find a better way.
    }
    private void clearEdit(){
        tbtnEditing.setSelected(false);
        
        txtEditID.setText("");
        txtEditName.setText("");
        cboxEditBodyPart.setSelectedItem(null);
        cboxEditCategory.setSelectedItem(null);
    }
    private void clearAdd() {
        txtAddName.setText("");
        cboxAddBodyPart.setSelectedItem(null);
        cboxAddCategory.setSelectedItem(null);
    }

    private HashMap<String, Object> gatherCreateData() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", txtAddName.getText());
        data.put("bodyPart", (BodyPart) cboxAddBodyPart.getSelectedItem());
        data.put("category", (Category) cboxAddCategory.getSelectedItem());
        
        return data;
    }
    private HashMap<String, Object> gatherEditData() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", txtEditID.getText());
        data.put("name", txtEditName.getText());
        data.put("bodyPart", (BodyPart) cboxEditBodyPart.getSelectedItem());
        data.put("category", (Category) cboxEditCategory.getSelectedItem());

        return data;
    }

    private void showErrorMessage(ValidateStatus status) {
        switch (status) {
            case OK:
                return;
            case ERROR_EXERCISE_NAME:
                JOptionPane.showMessageDialog(this, "Name of the exercise is a required field.", "Invalid data entered", JOptionPane.WARNING_MESSAGE);
                return;
            case ERROR_EXERCISE_BODYPART:
                JOptionPane.showMessageDialog(this, "Body part of exercise is required field", "Invalid data entered", JOptionPane.WARNING_MESSAGE);
                return;
            case ERROR_EXERCISE_CATEGORY:
                JOptionPane.showMessageDialog(this, "Category of exercise is required field.", "Invalid data entered", JOptionPane.WARNING_MESSAGE);
                return;
        }
    }
}
