package gui.panels;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import domain.Exercise;
import domain.Trainer;
import gui.lib.CustomTreeCellRenderer;
import java.net.Socket;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import gui.lib.Painter;
import gui.models.ExerciseTableModel;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class WorkoutPlansPanel extends javax.swing.JPanel {
    Trainer user;
    Socket socket;
    
    ArrayList<Exercise> exercises;
    
    public WorkoutPlansPanel(Trainer user, Socket socket) {
        this.user = user;
        this.socket = socket;
        
        initComponents();
        prepareForm();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        calendar = new calendar.CalendarCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        btnRemoveExercise = new gui.lib.CustomDarkButton();
        btnAddExercise = new gui.lib.CustomDarkButton();
        ftxtQuantity = null;
        jPanel1 = new javax.swing.JPanel();
        txtLastName = new javax.swing.JTextField();
        lblFirstName = new javax.swing.JLabel();
        btnSchedule = new gui.lib.CustomDarkButton();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        btnSelect = new gui.lib.CustomDarkButton();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnClear = new gui.lib.CustomDarkButton();

        lblHeader.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblHeader.setText("<html><u>WORKOUT PLANS</u></html>");

        tree.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        tree.setRootVisible(false);
        jScrollPane1.setViewportView(tree);

        btnRemoveExercise.setText("<<");
        btnRemoveExercise.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        btnAddExercise.setText(">>");
        btnAddExercise.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAddExercise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddExerciseActionPerformed(evt);
            }
        });

        MaskFormatter inputFormatter = null;
        try{
            inputFormatter = new MaskFormatter("## x ##");
            inputFormatter.setPlaceholderCharacter('_');
            ftxtQuantity = new JFormattedTextField(inputFormatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ftxtQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftxtQuantity.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ftxtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtQuantityActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Member Details\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 23))); // NOI18N

        txtLastName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtLastName.setBorder(javax.swing.BorderFactory.createLineBorder(Painter.DARK));

        lblFirstName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblFirstName.setText("First name: ");

        btnSchedule.setText("SCHEDULE WORKOUT");
        btnSchedule.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleActionPerformed(evt);
            }
        });

        txtFirstName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtFirstName.setBorder(javax.swing.BorderFactory.createLineBorder(Painter.DARK));

        lblLastName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblLastName.setText("Last name: ");

        btnSelect.setText("SELECT MEMBER");
        btnSelect.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFirstName))
                    .addComponent(btnSchedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSelect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstName)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastName)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSearch.setText("Search:");

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
        jScrollPane3.setViewportView(table);

        btnClear.setText("C");
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnRemoveExercise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAddExercise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ftxtQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                    .addComponent(btnClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddExercise, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ftxtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveExercise, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnScheduleActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchCriteria = txtSearch.getText().toLowerCase();

        ArrayList<Exercise> exercisesFitCriteria = new ArrayList<>();

        for(Exercise e: exercises){
            if (e.getName().toLowerCase().contains(searchCriteria)) exercisesFitCriteria.add(e);
        }

        table.setModel(new ExerciseTableModel(exercisesFitCriteria));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSelectActionPerformed

    private void ftxtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtQuantityActionPerformed

    private void btnAddExerciseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddExerciseActionPerformed
        if(table.getSelectedRow() != -1){
            Exercise selectedExercise = ((ExerciseTableModel)table.getModel()).getExerciseAt(table.getSelectedRow());
            
            String quantity[] = ftxtQuantity.getText().split(" x ");
            try{
                int reps = Integer.parseInt(quantity[0].toString());
                int sets = Integer.parseInt(quantity[1].toString());
                
                addExerciseToTree(selectedExercise, reps, sets);
                ftxtQuantity.commitEdit();
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Please input exercise quantity", "Adding exercises", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (ParseException ex) {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select exercise you wish to add", "Adding exercises", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAddExerciseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.lib.CustomDarkButton btnAddExercise;
    private gui.lib.CustomDarkButton btnClear;
    private gui.lib.CustomDarkButton btnRemoveExercise;
    private gui.lib.CustomDarkButton btnSchedule;
    private gui.lib.CustomDarkButton btnSelect;
    private calendar.CalendarCustom calendar;
    private javax.swing.JFormattedTextField ftxtQuantity;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable table;
    private javax.swing.JTree tree;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        prepareTree();
        prepareTable();
    }
    
    private JTree prepareTree() {
        tree.setRootVisible(false);

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("EXERCISES");
        DefaultTreeModel defaultTreeModel = new DefaultTreeModel(rootNode);
        tree.setModel(defaultTreeModel);
        tree.setCellRenderer(new CustomTreeCellRenderer());
        
        return tree;
    }
    private void addExerciseToTree(Exercise exercise, int reps, int sets){
                DefaultMutableTreeNode exerciseNode = new DefaultMutableTreeNode(exercise.getName() + " (" + exercise.getCategory() + ")");
                addNode((DefaultTreeModel) tree.getModel(), (DefaultMutableTreeNode) tree.getModel().getRoot(), exerciseNode);
                
                DefaultMutableTreeNode quantityNode = new DefaultMutableTreeNode(reps + " reps X " + sets + " sets");
                addNode((DefaultTreeModel) tree.getModel(), exerciseNode, quantityNode);
    }
    private void addNode(DefaultTreeModel treeModel, DefaultMutableTreeNode parentNode, DefaultMutableTreeNode node) {
        treeModel.insertNodeInto(node, parentNode, parentNode.getChildCount());

        if (parentNode == treeModel.getRoot()) {
            treeModel.nodeStructureChanged((DefaultMutableTreeNode) treeModel.getRoot());
        }
        
        expandAllNodes(tree, 0, tree.getRowCount());
    }
    private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; ++i) {
            tree.expandRow(i);
        }
        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }

    private void prepareTable() {
        try {
            Request request = new Request(Operation.GET_EXERCISES, null);
            new Sender(socket).send(request);

            Response response = (Response) new Receiver(socket).receive();
            if (response.getResponseType().equals(ResponseType.SUCCESS)) {
                exercises = (ArrayList<Exercise>) response.getResult();
                table.setModel(new ExerciseTableModel(exercises));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error retreiving exercises list.\n" + ex.getMessage(), "Retreiving exercises", JOptionPane.ERROR_MESSAGE);
        }
    }
}
