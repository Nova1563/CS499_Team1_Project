/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kenda
 */
public class AppointmentDisplay extends javax.swing.JPanel {
    
    final Integer APPT_ID_COLUMN = 3;
    private MainDashboard mainDash = null;
    private ArrayList<Appointment> appointmentList = null;
    private DataBaseManager dataBase = DataBaseManager.getInstance();
    private DefaultTableModel tableModel = null;
    
 

    /**
     * Creates new form AppointmentDisplay
     */
    public AppointmentDisplay(MainDashboard _mainFrame) {
        initComponents();
        mainDash = _mainFrame;
        
        tableModel = (DefaultTableModel) appointmentDisplayTable.getModel();
        loadTable();
    }
    
    public void loadTable()
    {
        String patientName = null;
        Integer doctorToSee = null;
        Integer appointmentTime = null;
        String lool = null;
        
        appointmentList = dataBase.getAppointmentListByDate(1000);
        tableModel.setRowCount(0);
        
        for (Appointment currentAppointment: appointmentList)
        {
            patientName = currentAppointment.getPatientName();
            doctorToSee = currentAppointment.getDoctorToSee();
            appointmentTime = currentAppointment.getAppointmentTime();
            lool = currentAppointment.getReasonForVisit();
            
            tableModel.addRow(new Object[] {appointmentTime, patientName, lool, doctorToSee});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        appointmentDisplayTable = new javax.swing.JTable();
        newAppointmentButton = new javax.swing.JButton();
        futureAppointmentButton = new javax.swing.JButton();
        pastAppointmentButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(57, 113, 177));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointmentDisplayTable.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        appointmentDisplayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Appointment Time", "Name", "Arrival Time", "Doctor", "Not Arrived", "Waiting", "Being Seen", "Checked Out"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        appointmentDisplayTable.setPreferredSize(new java.awt.Dimension(1347, 48));
        appointmentDisplayTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(appointmentDisplayTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 123, 1096, 270));

        newAppointmentButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color1"));
        newAppointmentButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        newAppointmentButton.setText("New Appointment");
        newAppointmentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newAppointmentButtonMouseClicked(evt);
            }
        });
        newAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAppointmentButtonActionPerformed(evt);
            }
        });
        add(newAppointmentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 411, -1, -1));

        futureAppointmentButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color1"));
        futureAppointmentButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        futureAppointmentButton.setText("Future Appointments");
        futureAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                futureAppointmentButtonActionPerformed(evt);
            }
        });
        add(futureAppointmentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(962, 411, -1, -1));
        futureAppointmentButton.getAccessibleContext().setAccessibleName("");

        pastAppointmentButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color1"));
        pastAppointmentButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pastAppointmentButton.setText("Past Appointments");
        pastAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pastAppointmentButtonActionPerformed(evt);
            }
        });
        add(pastAppointmentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 411, -1, -1));

        jPanel1.setBackground(new java.awt.Color(32, 33, 35));
        jPanel1.setForeground(new java.awt.Color(126, 87, 194));
        jPanel1.setMinimumSize(new java.awt.Dimension(1620, 724));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darcula.selection.color1"));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Daily Appointment Display");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-250, 20, 1620, 46));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 33, 1620, 84));
    }// </editor-fold>//GEN-END:initComponents

    private void futureAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_futureAppointmentButtonActionPerformed
        // TODO add your handling code here:
        // ANGELA DID THIS 
        System.out.println("Future Appoinment Bttn Clicked");
       // mainDash.MainDashboard();
       // mainDash.showViewFutureAppointments();
        
    }//GEN-LAST:event_futureAppointmentButtonActionPerformed

    private void pastAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pastAppointmentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pastAppointmentButtonActionPerformed

    private void newAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAppointmentButtonActionPerformed
        System.out.println("Appointment: Add new button");

        mainDash.showNewAppt();

        
        
    }//GEN-LAST:event_newAppointmentButtonActionPerformed

    private void newAppointmentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newAppointmentButtonMouseClicked
        //
    }//GEN-LAST:event_newAppointmentButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable appointmentDisplayTable;
    private javax.swing.JButton futureAppointmentButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newAppointmentButton;
    private javax.swing.JButton pastAppointmentButton;
    // End of variables declaration//GEN-END:variables
}
