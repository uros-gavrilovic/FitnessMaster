package gui.panels;

import domain.Trainer;
import java.net.Socket;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class WorkoutPlansPanel extends javax.swing.JPanel {
    Trainer user;
    Socket socket;
    
    public WorkoutPlansPanel(Trainer user, Socket socket) {
        initComponents();
        
        prepareForm();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        calendarCustom1 = new calendar.CalendarCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();

        lblHeader.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lblHeader.setText("<html><u>WORKOUT PLANS</u></html>");

        tree.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        tree.setRootVisible(false);
        jScrollPane1.setViewportView(tree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(calendarCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(calendarCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(167, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private calendar.CalendarCustom calendarCustom1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        createJTree();
    }
    
    private JTree createJTree() {
        tree.setRootVisible(false);

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("EXERCISES");
        DefaultTreeModel defaultTreeModel = new DefaultTreeModel(rootNode);
        tree.setModel(defaultTreeModel);

        DefaultMutableTreeNode node;

        node = new DefaultMutableTreeNode("Bench Press");
        addNode(defaultTreeModel, rootNode, node);
        addNode(defaultTreeModel, node, new DefaultMutableTreeNode("5 sets x 10 reps"));

        node = new DefaultMutableTreeNode("Pull Ups");
        addNode(defaultTreeModel, rootNode, node);
        addNode(defaultTreeModel, node, new DefaultMutableTreeNode("3 sets x 15 reps"));
        
        expandAllNodes(tree, 0, tree.getRowCount());
        return tree;
    }
    private static void addNode(DefaultTreeModel treeModel, DefaultMutableTreeNode parentNode, DefaultMutableTreeNode node) {
        treeModel.insertNodeInto(node, parentNode, parentNode.getChildCount());

        if (parentNode == treeModel.getRoot()) {
            treeModel.nodeStructureChanged((DefaultMutableTreeNode) treeModel.getRoot());
        }
    }
    private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
        for (int i = startingIndex; i < rowCount; ++i) {
            tree.expandRow(i);
        }
        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }
}
