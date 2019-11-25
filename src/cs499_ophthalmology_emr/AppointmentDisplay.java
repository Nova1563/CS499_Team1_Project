/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
		addRightClickListener();
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
        String doctorToSee = null;
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
            doctorToSee = translateDoctorToSeeCode(currentAppointment.getDoctorToSee());
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
	
	private void addRightClickListener()
	{
	appointmentDisplayTable.addMouseListener(new MouseAdapter() {
    public void mouseReleased(MouseEvent e) {
        int r = appointmentDisplayTable.rowAtPoint(e.getPoint());
        if (r >= 0 && r < appointmentDisplayTable.getRowCount()) {
            appointmentDisplayTable.setRowSelectionInterval(r, r);
        } else {
            appointmentDisplayTable.clearSelection();
        }

        int rowindex = appointmentDisplayTable.getSelectedRow();
        if (rowindex < 0)
            return;
        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
            JPopupMenu popup = createRightClickMenu();
            popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }

		
	});
	}
	
	private JPopupMenu createRightClickMenu() {
		JPopupMenu theMenu = new JPopupMenu();
		
		JMenuItem beginExam = new JMenuItem("Begin Eye Exam");
		JMenuItem addNewAppt = new JMenuItem("Add new appointment");
		JMenuItem editAppt = new JMenuItem("Edit appointment");
		JMenuItem deleteAppt = new JMenuItem("Delete appointment");
		
		theMenu.add(beginExam);
		theMenu.addSeparator();
		theMenu.add(addNewAppt);
		theMenu.add(editAppt);
		theMenu.addSeparator();
		theMenu.add(deleteAppt);
		

		beginExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickMenuBeginExam(evt);
            }
		});
		
		addNewAppt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickMenuNewAppt(evt);
            }
		});
		
		editAppt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickEditAppt(evt);
            }
		});
		
		deleteAppt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickDeleteAppt(evt);
            }
		});
		
		return theMenu;
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
	
	public String translateDoctorToSeeCode(Integer doctorCode)
	{
		String returnString = "";
		switch (doctorCode)
		{
			case(0):	// Coleman
				returnString = "Dr. Coleman";
				break;
				
			case(1):	// Lukins
				returnString = "Dr. Lukins";
				break;
				
			case(2):	// Woods
				returnString = "Dr. Woods";
				break;
						
			case(3):	// Haley
				returnString = "Dr. Haley";
				break;
			default:
				returnString = "translateDoctorToSeeCode(" + doctorCode.toString() + ") error.";
		}
		return returnString;
	}
    
    public void loadTableFromList(ArrayList<Appointment> theList)
    {
        String patientName = null;
        Integer doctorToSee = -1;
		String doctorString = null;
        Integer apptDate = -1;
		String apptDateString = null;
		Integer apptTime = -1;
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
			doctorString = translateDoctorToSeeCode(doctorToSee);
    
			apptDate = currentAppointment.getApptDate();
			apptDateString = formatDate(apptDate.toString());
			
            //apptTime = currentAppointment.getAppointmentTime();
            reasonForVisit = currentAppointment.getReasonForVisit();
            apptID = currentAppointment.getApptID();
            checkInCode = currentAppointment.getArrivalStatus();
			checkInString = translateArrivalStatus(checkInCode);
            
            tableModel.addRow(new Object[] {apptDateString, patientName, doctorString, reasonForVisit, checkInString, apptID});
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
	
	private Boolean validateDate(String theDate)
    {
		Boolean isValid = true;
		
		String trimmedDate = "";
		
		for (Integer i=0; i < theDate.length(); i++)
		{
			if (Character.isDigit(theDate.charAt(i)))
			{
				trimmedDate += theDate.charAt(i);
			}
		}
		if (trimmedDate.equals(""))
		{
			isValid = false;
		}
		if (trimmedDate.length() != 8)
		{
			isValid = false;
		}
		
		return isValid;
    }
	
	private Integer unformatDate(String theDate)
    {
        String formattedStr = "";
        
        for (Integer i = 0; i < theDate.length(); i++)
	{
            if (Character.isDigit(theDate.charAt(i)))
            {
                formattedStr += theDate.charAt(i);
            }
	}
        
        return Integer.parseInt(formattedStr);
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
        jLabel1 = new javax.swing.JLabel();
        showAllButton = new javax.swing.JButton();
        displayDateTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(57, 113, 177));
        setPreferredSize(new java.awt.Dimension(1900, 900));

        newAppointmentButton.setBackground(new java.awt.Color(204, 255, 255));
        newAppointmentButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        newAppointmentButton.setForeground(new java.awt.Color(0, 0, 0));
        newAppointmentButton.setText("ADD NEW APPOINTMENT");
        newAppointmentButton.setToolTipText("Add New Appointment");
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
        jPanel1.setPreferredSize(new java.awt.Dimension(1900, 66));
        jPanel1.setRequestFocusEnabled(false);

        jLabel2.setBackground(new java.awt.Color(32, 33, 35));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Daily Appointment Display");
        jLabel2.setOpaque(true);
        jLabel2.setPreferredSize(new java.awt.Dimension(1900, 44));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        deleteButton.setBackground(new java.awt.Color(204, 255, 255));
        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(0, 0, 0));
        deleteButton.setText("DELETE");
        deleteButton.setToolTipText("Delete Selected Appointment");
        deleteButton.setPreferredSize(new java.awt.Dimension(176, 33));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(204, 255, 255));
        editButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(0, 0, 0));
        editButton.setText("EDIT");
        editButton.setToolTipText("Edit Selected Appointment");
        editButton.setPreferredSize(new java.awt.Dimension(176, 33));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        appointmentDisplayTable.setAutoCreateRowSorter(true);
        appointmentDisplayTable.setBackground(new java.awt.Color(204, 204, 204));
        appointmentDisplayTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(32, 33, 35)));
        appointmentDisplayTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        appointmentDisplayTable.setForeground(new java.awt.Color(0, 0, 0));
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
        appointmentDisplayTable.setPreferredSize(new java.awt.Dimension(1900, 655));
        jScrollPane2.setViewportView(appointmentDisplayTable);

        beginExamButton.setBackground(new java.awt.Color(204, 255, 255));
        beginExamButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        beginExamButton.setForeground(new java.awt.Color(0, 0, 0));
        beginExamButton.setText("OPEN EXAMS");
        beginExamButton.setToolTipText("Open Exams for selected Patient");
        beginExamButton.setPreferredSize(new java.awt.Dimension(176, 33));
        beginExamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginExamButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Date to display:");

        showAllButton.setBackground(new java.awt.Color(204, 255, 255));
        showAllButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        showAllButton.setForeground(new java.awt.Color(0, 0, 0));
        showAllButton.setText("SHOW ALL");
        showAllButton.setToolTipText("Show All Appointments");
        showAllButton.setPreferredSize(new java.awt.Dimension(176, 33));
        showAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAllButtonActionPerformed(evt);
            }
        });

        displayDateTextField.setBackground(new java.awt.Color(204, 255, 255));
        displayDateTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        displayDateTextField.setForeground(new java.awt.Color(0, 0, 0));
        displayDateTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        displayDateTextField.setText("01/02/1234");
        displayDateTextField.setToolTipText("MMDDYYYY");
        displayDateTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                displayDateTextFieldFocusLost(evt);
            }
        });
        displayDateTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                displayDateTextFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1906, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(displayDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(showAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newAppointmentButton)
                .addGap(395, 395, 395)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(beginExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(displayDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(beginExamButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newAppointmentButton)))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAppointmentButtonActionPerformed
        System.out.println("Appointment: Add new button");
		mainDash.appointmentForm.loadActivePatientInfo();
		mainDash.setActiveAppointment(null);
		mainDash.appointmentForm.setUpFieldsForNewAppointment();
        mainDash.showAppointmentForm();
    }//GEN-LAST:event_newAppointmentButtonActionPerformed

    private void newAppointmentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newAppointmentButtonMouseClicked
        //
    }//GEN-LAST:event_newAppointmentButtonMouseClicked

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

    private void displayDateTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_displayDateTextFieldFocusLost
        Boolean validDate = validateDate(displayDateTextField.getText());
		
		if (validDate)
		{
			Integer sqlCompatibleDate = unformatDate(displayDateTextField.getText());
			ArrayList<Appointment> theDatesAppts = dataBase.getAppointmentListByDate(sqlCompatibleDate);
			loadTableFromList(theDatesAppts);
		}
    }//GEN-LAST:event_displayDateTextFieldFocusLost

    private void displayDateTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_displayDateTextFieldKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER)
			displayDateTextFieldFocusLost(null);
    }//GEN-LAST:event_displayDateTextFieldKeyPressed

    private void showAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAllButtonActionPerformed
        try
		{
			loadTableAllEntries();
		}
		catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Select an active patient from Patient Portal to continue.");
		}
    }//GEN-LAST:event_showAllButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
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
	
	private void rightClickMenuBeginExam(java.awt.event.ActionEvent evt) {
		try
		{
			beginExamButtonActionPerformed(evt);
		}
		catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Select an active patient from Patient Portal to continue.");
		}
	}
	
	private void rightClickMenuNewAppt(java.awt.event.ActionEvent evt) {
		try
		{
			newAppointmentButtonActionPerformed(evt);
		}
		catch(NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Select an active patient from Patient Portal to continue.");
		}
	}

	private void rightClickEditAppt(java.awt.event.ActionEvent evt) {
		editButtonActionPerformed(evt);
	}
	
	private void rightClickDeleteAppt(java.awt.event.ActionEvent evt) {
		deleteButtonActionPerformed(evt);
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable appointmentDisplayTable;
    private javax.swing.JButton beginExamButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField displayDateTextField;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton newAppointmentButton;
    private javax.swing.JButton showAllButton;
    // End of variables declaration//GEN-END:variables

}
