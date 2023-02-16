package gui;

import communication.Operation;
import communication.Request;
import communication.Sender;
import domain.Trainer;
import exceptions.SenderException;
import gui.panels.AddMemberPanel;
import gui.panels.DashboardPanel;
import gui.panels.ExercisesPanel;
import gui.panels.MembersPanel;
import gui.panels.WorkoutPlansPanel;
import javax.swing.JPanel;
import gui.lib.ImageResizer;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.ButtonGroup;
import gui.lib.Painter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

public class AppForm extends javax.swing.JFrame {
    Trainer user;
    Socket socket;

    public AppForm(Trainer user, Socket socket) {
        this.user = user;
        this.socket = socket;

        initComponents();
        initVisuals();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlWest = new javax.swing.JPanel();
        pnlWest.setLayout(new java.awt.GridLayout(0, 1));
        tbtnDashboard = new javax.swing.JToggleButton();
        tbtnAddMember = new javax.swing.JToggleButton();
        tbtnMembers = new javax.swing.JToggleButton();
        tbtnExercises = new javax.swing.JToggleButton();
        tbtnPlans = new javax.swing.JToggleButton();
        btnLogOut = new javax.swing.JButton();
        pnlCenter = new DashboardPanel(user, socket);
        pnlNorth = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("FitnessMaster");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/smallIcon_light.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        pnlWest.setBackground(new java.awt.Color(41, 42, 43));
        pnlWest.setMaximumSize(new java.awt.Dimension(250, 32767));
        pnlWest.setMinimumSize(new java.awt.Dimension(250, 10));
        pnlWest.setPreferredSize(new java.awt.Dimension(250, 10));
        pnlWest.setLayout(new java.awt.GridLayout(0, 1));

        tbtnDashboard.setBackground(Painter.GREEN);
        tbtnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        tbtnDashboard.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/home.png")), 50, 50));
        tbtnDashboard.setSelected(true);
        tbtnDashboard.setText("DASHBOARD");
        tbtnDashboard.setBorderPainted(false);
        tbtnDashboard.setContentAreaFilled(false);
        tbtnDashboard.setFocusable(false);
        tbtnDashboard.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbtnDashboardStateChanged(evt);
            }
        });
        tbtnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnDashboardActionPerformed(evt);
            }
        });
        pnlWest.add(tbtnDashboard);

        tbtnAddMember.setBackground(Painter.GREEN);
        tbtnAddMember.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnAddMember.setForeground(new java.awt.Color(255, 255, 255));
        tbtnAddMember.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/add_member.png")), 50, 50));
        tbtnAddMember.setText("ADD MEMBER");
        tbtnAddMember.setBorderPainted(false);
        tbtnAddMember.setContentAreaFilled(false);
        tbtnAddMember.setFocusable(false);
        tbtnAddMember.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbtnAddMemberStateChanged(evt);
            }
        });
        tbtnAddMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnAddMemberActionPerformed(evt);
            }
        });
        pnlWest.add(tbtnAddMember);

        tbtnMembers.setBackground(Painter.GREEN);
        tbtnMembers.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnMembers.setForeground(new java.awt.Color(255, 255, 255));
        tbtnMembers.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/member.png")), 50, 50));
        tbtnMembers.setText("MEMBERS");
        tbtnMembers.setBorderPainted(false);
        tbtnMembers.setContentAreaFilled(false);
        tbtnMembers.setFocusable(false);
        tbtnMembers.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbtnMembersStateChanged(evt);
            }
        });
        tbtnMembers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnMembersActionPerformed(evt);
            }
        });
        pnlWest.add(tbtnMembers);

        tbtnExercises.setBackground(Painter.GREEN);
        tbtnExercises.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnExercises.setForeground(new java.awt.Color(255, 255, 255));
        tbtnExercises.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/exercise.png")), 50, 50));
        tbtnExercises.setText("EXERCISES");
        tbtnExercises.setBorderPainted(false);
        tbtnExercises.setContentAreaFilled(false);
        tbtnExercises.setFocusable(false);
        tbtnExercises.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbtnExercisesStateChanged(evt);
            }
        });
        tbtnExercises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnExercisesActionPerformed(evt);
            }
        });
        pnlWest.add(tbtnExercises);

        tbtnPlans.setBackground(Painter.GREEN);
        tbtnPlans.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tbtnPlans.setForeground(new java.awt.Color(255, 255, 255));
        tbtnPlans.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/plan.png")), 50, 50));
        tbtnPlans.setText("WORKOUT PLANS");
        tbtnPlans.setBorderPainted(false);
        tbtnPlans.setContentAreaFilled(false);
        tbtnPlans.setFocusable(false);
        tbtnPlans.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbtnPlansStateChanged(evt);
            }
        });
        tbtnPlans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnPlansActionPerformed(evt);
            }
        });
        pnlWest.add(tbtnPlans);

        btnLogOut.setBackground(Painter.GREEN);
        btnLogOut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setIcon(new ImageResizer().resize(new javax.swing.ImageIcon(getClass().getResource("/gui/lib/img/exit.png")), 50, 50));
        btnLogOut.setText("LOG OUT");
        btnLogOut.setBorder(null);
        btnLogOut.setContentAreaFilled(false);
        btnLogOut.setFocusable(false);
        btnLogOut.setMaximumSize(new java.awt.Dimension(240, 40));
        btnLogOut.setMinimumSize(new java.awt.Dimension(240, 40));
        btnLogOut.setPreferredSize(new java.awt.Dimension(240, 40));
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        pnlWest.add(btnLogOut);

        getContentPane().add(pnlWest, java.awt.BorderLayout.WEST);
        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        pnlNorth.setBackground(new java.awt.Color(41, 42, 43));
        pnlNorth.setPreferredSize(new java.awt.Dimension(155, 70));

        lblLogo.setFont(new java.awt.Font("Segoe UI", 3, 22)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setText("FitnessMaster");
        lblLogo.setFocusable(false);
        lblLogo.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(582, Short.MAX_VALUE))
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirm logging-out",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
            disconnect();
            dispose();
            openMainMenu();
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void tbtnDashboardStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbtnDashboardStateChanged
        setUpToggleButton((JToggleButton) evt.getSource());
    }//GEN-LAST:event_tbtnDashboardStateChanged
    private void tbtnAddMemberStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbtnAddMemberStateChanged
        setUpToggleButton((JToggleButton) evt.getSource());
    }//GEN-LAST:event_tbtnAddMemberStateChanged
    private void tbtnMembersStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbtnMembersStateChanged
        setUpToggleButton((JToggleButton) evt.getSource());
    }//GEN-LAST:event_tbtnMembersStateChanged
    private void tbtnExercisesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbtnExercisesStateChanged
        setUpToggleButton((JToggleButton) evt.getSource());
    }//GEN-LAST:event_tbtnExercisesStateChanged
    private void tbtnPlansStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbtnPlansStateChanged
        setUpToggleButton((JToggleButton) evt.getSource());
    }//GEN-LAST:event_tbtnPlansStateChanged

    private void tbtnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnDashboardActionPerformed
        openPanel(new DashboardPanel(user, socket));
    }//GEN-LAST:event_tbtnDashboardActionPerformed
    private void tbtnAddMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnAddMemberActionPerformed
        openPanel(new AddMemberPanel(socket));
    }//GEN-LAST:event_tbtnAddMemberActionPerformed
    private void tbtnMembersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnMembersActionPerformed
        openPanel(new MembersPanel(user, socket));
    }//GEN-LAST:event_tbtnMembersActionPerformed
    private void tbtnExercisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnExercisesActionPerformed
        openPanel(new ExercisesPanel(socket));
    }//GEN-LAST:event_tbtnExercisesActionPerformed
    private void tbtnPlansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnPlansActionPerformed
        openPanel(new WorkoutPlansPanel(user, socket));
    }//GEN-LAST:event_tbtnPlansActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(response == JOptionPane.YES_OPTION) {
            disconnect();
            dispose();
            openMainMenu();
        }
    }//GEN-LAST:event_formWindowClosing
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE) formWindowClosing(null);
    }//GEN-LAST:event_formKeyPressed

    private void initVisuals() {
        this.setExtendedState(AppForm.MAXIMIZED_BOTH);
        this.setVisible(true);

        ButtonGroup tbtnGroup = new ButtonGroup();
        tbtnGroup.add(tbtnDashboard);
        tbtnGroup.add(tbtnAddMember);
        tbtnGroup.add(tbtnMembers);
        tbtnGroup.add(tbtnExercises);
        tbtnGroup.add(tbtnPlans);
//        tbtnGroup.add(tbtnTrainers);

        tbtnDashboard.setSelected(true);
        setUpToggleButton(tbtnDashboard);
    }

    private void setUpToggleButton(JToggleButton tbtn) {
        if (tbtn.isSelected()) {
            setSelectedColor(tbtn);
        } else {
            setUnselectColor(tbtn);
        }
    }
    private void openPanel(JPanel newPanel) {
        this.remove(pnlCenter);
        pnlCenter = newPanel;
        getContentPane().add(pnlCenter);
        this.revalidate();
    }
    private void openMainMenu() {
        new MainMenuForm().setVisible(true);
    }
    private void setSelectedColor(JToggleButton tbtn) {
        tbtn.setUI(new MetalButtonUI() {
            @Override
            protected Color getSelectColor() {
                return Painter.GREEN;
            }
        });
        tbtn.setContentAreaFilled(true);
    }
    private void setUnselectColor(JToggleButton tbtn) {
        tbtn.setOpaque(false);
        tbtn.setContentAreaFilled(false);
    }

    private void disconnect(){
        try {
            new Sender(socket).send(new Request(Operation.DISCONNECT, null));
            socket.close();
            System.out.println("Disconnected from the server.");
        } catch (SenderException ex) {
            System.err.println("ERROR: Failed to send log-out request.");
        } catch (IOException ex) {
            System.err.println("ERROR: Failed to close socket.");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JPanel pnlWest;
    private javax.swing.JToggleButton tbtnAddMember;
    private javax.swing.JToggleButton tbtnDashboard;
    private javax.swing.JToggleButton tbtnExercises;
    private javax.swing.JToggleButton tbtnMembers;
    private javax.swing.JToggleButton tbtnPlans;
    // End of variables declaration//GEN-END:variables
}
