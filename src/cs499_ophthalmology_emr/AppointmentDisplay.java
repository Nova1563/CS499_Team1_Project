/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author kenda
 */
public class AppointmentDisplay extends javax.swing.JPanel {
    
    final Integer APPT_ID_COLUMN = 5;
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
		//JComboBox statusComboBox = new JComboBox();
		//statusComboBox.addItem("Not arrived");
		//statusComboBox.addItem("Checked in, waiting");
		//statusComboBox.addItem("In Exam");
		//statusComboBox.addItem("Checked out");
		//appointmentDisplayTable.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(statusComboBox));
        loadTableAllEntries();
    }
    
    public void loadTableAllEntries()
    {
        String patientName = null;
        Integer doctorToSee = -1;
        Integer apptDate = -1;
		String reasonForVisit = null;
        Integer apptID = -1;
		String formattedApptDate = null;
		Integer checkInCode = -1;
		String checkInString = null;
        
        appointmentList = dataBase.getAllAppointments();
        tableModel.setRowCount(0);
        
        for (Appointment currentAppointment: appointmentList)
        {
            patientName = currentAppointment.getPatientName();
            doctorToSee = currentAppointment.getDoctorToSee();
            apptDate = currentAppointment.getApptDate();
			formattedApptDate = formatDate(apptDate.toString());
            reasonForVisit = currentAppointment.getReasonForVisit();
            apptID = currentAppointment.getApptID();
            checkInCode = currentAppointment.getArrivalStatus();
			checkInString = translateArrivalStatus(checkInCode);
            
            tableModel.addRow(new Object[] {formattedApptDate, patientName, doctorToSee, reasonForVisit, checkInString, apptID});
        }
		tableModel.fireTableDataChanged();
		System.out.println("AppointmentDisplay.loadTableAllEntries() finished.");
		
    }
	
	public String translateArrivalStatus(Integer arrivalCode)
	{
		String theReturnString = "";
		switch (arrivalCode)
		{
			case 0:
				theReturnString = "Not arrived";
				break;
			case 1:
				theReturnString = "Checked in, waiting";
				break;
			case 2:
				theReturnString = "In Exam";
				break;
			case 3:
				theReturnString = "Checked out";
				break;
			default:
				theReturnString = "Invalid check in status.";
				System.out.println("AppointmentDisplay.translateArrivalStatus(" + arrivalCode + ") error.");
		}
		
		return theReturnString;
	}
    
    public void loadTableFromList(ArrayList<Appointment> theList)
    {
        String patientName = null;
        Integer doctorToSee = -1;
        Integer apptDate = -1;
		String reasonForVisit = null;
        Integer apptID = -1;
		Integer checkInCode = -1;
		String checkInString = null;
        
		if (theList != null)
		{
			appointmentList = theList;
		}
		
        tableModel.setRowCount(0);
        
        for (Appointment currentAppointment: appointmentList)
        {
            patientName = currentAppointment.getPatientName();
            doctorToSee = currentAppointment.getDoctorToSee();
            apptDate = currentAppointment.getAppointmentTime();
            reasonForVisit = currentAppointment.getReasonForVisit();
            apptID = currentAppointment.getApptID();
            checkInCode = currentAppointment.getArrivalStatus();
			checkInString = translateArrivalStatus(checkInCode);
            
            tableModel.addRow(new Object[] {apptDate, patientName, doctorToSee, reasonForVisit, checkInString, apptID});
        }
		tableModel.fireTableDataChanged();
    }
	
	private String formatDate(String theDate)
    {
        String formattedStr = "";
        
		if (theDate.length() < 8)
		{
			theDate = "0" + theDate;
		}
		for (Integer i = 0; i < theDate.length(); i++)
		{
			if ((i == 2) || (i == 4))
			{
				formattedStr = formattedStr + "/" + theDate.charAt(i);
			}

			else
			{
				formattedStr = formattedStr +theDate.charAt(i);
			}
		}

        return formattedStr;
    }
	
	/*
	public void setupCheckInColumn(JTable theTable, TableColumn theCol)
	{
		//Set up the editor for the sport cells.
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Not arrived");
        comboBox.addItem("Checked in, waiting");
        comboBox.addItem("In examination");
        comboBox.addItem("Checked out");
        theCol.setCellEditor(new DefaultCellEditor(comboBox));

        //Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer =
                new DefaultTableCellRenderer();
        renderer.setToolTipText("Click for combo box");
        theCol.setCellRenderer(renderer);
	}*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newAppointmentButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        appointmentDisplayTable = new javax.swing.JTable();
        beginExamButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(57, 113, 177));

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

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        appointmentDisplayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Name", "Doctor", "Reason For Visit", "Status", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(appointmentDisplayTable);

        beginExamButton.setText("Open Exam for Selected");
        beginExamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginExamButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1620, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newAppointmentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227)
                        .addComponent(beginExamButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editButton)
                        .addComponent(deleteButton)
                        .addComponent(beginExamButton))
                    .addComponent(newAppointmentButton))
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAppointmentButtonActionPerformed
        System.out.println("Appointment: Add new button");
		mainDash.appointmentForm.loadActivePatientInfo();
        mainDash.showAppointmentForm();
    }//GEN-LAST:event_newAppointmentButtonActionPerformed

    private void newAppointmentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newAppointmentButtonMouseClicked
        //
    }//GEN-LAST:event_newAppointmentButtonMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        Integer selectedCol = appointmentDisplayTable.getSelectedColumn();
	Integer selectedRow = appointmentDisplayTable.getSelectedRow();
	if ((selectedRow >= 0) && (selectedCol >=0))
	{
            Integer apptID = (Integer)appointmentDisplayTable.getValueAt(selectedRow, APPT_ID_COLUMN);

            tableModel.removeRow(selectedRow);

            Appointment theVictim = dataBase.getAppointmentByID(apptID);
            dataBase.delete(theVictim);
	}
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Patient Portal: Edit button");
		Integer selectedRow = appointmentDisplayTable.getSelectedRow();
		Integer apptID = (Integer)appointmentDisplayTable.getValueAt(selectedRow, APPT_ID_COLUMN);
		Appointment theAppointment = dataBase.getAppointmentByID(apptID);
		mainDash.appointmentForm.loadAppointment(theAppointment);
		mainDash.showAppointmentForm();
    }//GEN-LAST:event_editButtonActionPerformed

    private void beginExamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginExamButtonActionPerformed
        Integer selectedRow = appointmentDisplayTable.getSelectedRow();
		Integer apptID = (Integer)appointmentDisplayTable.getValueAt(selectedRow, APPT_ID_COLUMN);
		Appointment theAppointment = dataBase.getAppointmentByID(apptID);
		mainDash.setActiveAppointment(theAppointment);
		
		Integer patientID = theAppointment.getPatientID();
		Patient thePatient = dataBase.getPatientByID(patientID);
		mainDash.setActivePatient(thePatient);
		
        EyeTestResults theResults = dataBase.getExamResultsByApptID(apptID);
		if (theResults == null)
		{
			dataBase.getNewEyeTestResults(patientID, apptID);
		}
		mainDash.setActiveResults(theResults);
		
        //mainDash.visualAcuity.loadEyeTestResults();
		//mainDash.occularExResults.loadOcularResults();
		mainDash.showVisualAcuity();
    }//GEN-LAST:event_beginExamButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable appointmentDisplayTable;
    private javax.swing.JButton beginExamButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newAppointmentButton;
    // End of variables declaration//GEN-END:variables

}
