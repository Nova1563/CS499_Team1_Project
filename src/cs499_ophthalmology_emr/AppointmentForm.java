/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author kenda
 */
public class AppointmentForm extends javax.swing.JPanel {
    
        private DataBaseManager dataBase = null;
	private MainDashboard dashBoard = null;
	private Appointment activeAppointment = null;

    /**
     * Creates new form NewPatientForm
     */
    public AppointmentForm(MainDashboard _dashBoard) {
        initComponents();
        dataBase = DataBaseManager.getInstance();
	dashBoard = _dashBoard;
    }
    
    public void loadAppointment(Appointment theAppointment)
    {
        activeAppointment = theAppointment;
        appointmentDateTextField.setText(formatDate(theAppointment.getApptDate().toString()));
        reasonForVisit.setText(theAppointment.getReasonForVisit());
        patientNameTextBox.setText(theAppointment.getPatientName());
		Integer arrivalStatus = theAppointment.getArrivalStatus();
		arrivalStatusComboBox.setSelectedItem(translateArrivalStatus(arrivalStatus));
		String apptTimeString = formatTime(theAppointment.getAppointmentTime());
		apptTimeTextField.setText(apptTimeString);
		setTimeComboBoxes(apptTimeString);
		doctorComboBox.setSelectedIndex(theAppointment.getDoctorToSee());
    }
	
	public void setUpFieldsForNewAppointment()
	{
		patientNameTextBox.setText(dashBoard.getActivePatient().getName());
		appointmentDateTextField.setText("MM/DD/YYYY");
		apptHourComboBox.setSelectedIndex(0);
		apptMinuteComboBox.setSelectedIndex(0);
		apptTimeTextField.setText("07:00 AM");
		doctorComboBox.setSelectedIndex(0);
		reasonForVisit.setText("");
		arrivalStatusComboBox.setSelectedIndex(0);
	}
	
	public String formatTime(Integer timeInt)
	{
		String returnString;
		String timeString;
		
		if (timeInt < 959)
			timeString = "0" + timeInt.toString();
		else
			timeString = timeInt.toString();
		
		returnString = timeString.substring(0,2) + ":" + timeString.substring(2);
		
		return returnString;
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
	
	public void setTimeComboBoxes(String timeStr)
	{
		apptHourComboBox.setSelectedItem(timeStr.substring(0,2));
		apptMinuteComboBox.setSelectedItem(timeStr.substring(2));
	}
    
    public Boolean saveAppointmentInfo()
    {
        Boolean isSuccess = false;
        
		if (activeAppointment == null)
		{
			activeAppointment = dataBase.getNewAppointment(dashBoard.getActivePatient().getPatientID());
		}

        try
        {
            activeAppointment.setPatientName(patientNameTextBox.getText());
            
            if(appointmentDateTextField.getText().equals(""))
                activeAppointment.setApptDate(0);
            else
                activeAppointment.setApptDate(unformatDate(appointmentDateTextField.getText()));
			
			activeAppointment.setReasonForVisit(reasonForVisit.getText());
			activeAppointment.setDoctorToSee(doctorComboBox.getSelectedIndex());
			activeAppointment.setArrivalStatus(arrivalStatusComboBox.getSelectedIndex());
			String theTime = apptTimeTextField.getText();
			String temp = theTime.substring(0,2);
			temp = temp + theTime.substring(3,5);
            activeAppointment.setAppointmentTime(Integer.parseInt(temp));
			
            isSuccess = true;
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: ");
            System.out.println("AppointmentForm.saveAppointmentInfo() error: " + e.getMessage());
            isSuccess = false;
        }
        
        if (isSuccess)
        {
            dataBase.save(activeAppointment);
        }
        
        return isSuccess;
    }
	
	public void loadActivePatientInfo()
	{
		/*for(Component itsComp : this.getComponents())
		{
			//	System.out.println(itsComp.getClass().getName());
			if (itsComp.getClass().getName().equals("javax.swing.JTextField"))
			{
				((JTextComponent)itsComp).setEnabled(false);
			}
		}*/
		
		
		
		if (dashBoard.getActivePatient() == null)
		{
			for(Component itsComp : appointmentFormMainPanel.getComponents())
			{
				//	System.out.println(itsComp.getClass().getName());
				if (itsComp.getClass().getName().equals("javax.swing.JTextField"))
				{
					((JTextComponent)itsComp).setEditable(false);
				}
				if (itsComp.getClass().getName().equals("javax.swing.JComboBox"))
				{
					((JComboBox)itsComp).setEnabled(false);
				}
			}
			patientNameTextBox.setText("No active patient selected.");
		}
		else
		{
			String patientName = dashBoard.getActivePatient().getName();
			patientNameTextBox.setText(patientName);
			
			for(Component itsComp : appointmentFormMainPanel.getComponents())
			{
				//	System.out.println(itsComp.getClass().getName());
				if (itsComp.getClass().getName().equals("javax.swing.JTextField"))
				{
					((JTextComponent)itsComp).setEditable(true);
				}
				if (itsComp.getClass().getName().equals("javax.swing.JComboBox"))
				{
					((JComboBox)itsComp).setEnabled(true);
				}
			}
		}
		patientNameTextBox.setEditable(false);
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
        
		if (formattedStr.length() < 8)
			formattedStr = "0" + formattedStr;
		
        return formattedStr;
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
	
	private void updateApptTimeTextBox(String rawTimeText)
	{
		String hour = rawTimeText.substring(0,2);
		//String minute = rawTimeText.substring(3,5);
		String formattedString = "";
		if ((Integer.parseInt(hour) <= 7) && (Integer.parseInt(hour) <= 11)) // AM hour
		{
			formattedString = rawTimeText + " AM";
		}
		else
		{
			formattedString = rawTimeText + " PM";
		}
		 
		apptTimeTextField.setText(formattedString);
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        appointmentFormMainPanel = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        patientNameTextBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        appointmentDateTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        apptTimeTextField = new javax.swing.JTextField();
        apptHourComboBox = new javax.swing.JComboBox<>();
        apptMinuteComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        doctorComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        arrivalStatusComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        reasonForVisit = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(53, 60, 81));

        appointmentFormMainPanel.setBackground(new java.awt.Color(57, 113, 177));

        submitButton.setBackground(new java.awt.Color(102, 255, 102));
        submitButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        submitButton.setForeground(new java.awt.Color(0, 0, 0));
        submitButton.setText("SAVE");
        submitButton.setPreferredSize(new java.awt.Dimension(125, 38));
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(255, 51, 51));
        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(0, 0, 0));
        cancelButton.setText("CANCEL");
        cancelButton.setToolTipText("Cancel Appointment ");
        cancelButton.setPreferredSize(new java.awt.Dimension(125, 38));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(32, 33, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(1900, 66));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Appointment Form");
        jLabel1.setToolTipText("");
        jLabel1.setPreferredSize(new java.awt.Dimension(1900, 44));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(32, 33, 35));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(253, 252, 233)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name:");

        patientNameTextBox.setBackground(new java.awt.Color(204, 255, 255));
        patientNameTextBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        patientNameTextBox.setForeground(new java.awt.Color(0, 0, 0));
        patientNameTextBox.setToolTipText("Patient Name");
        patientNameTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientNameTextBoxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Appointment Date:");

        appointmentDateTextField.setBackground(new java.awt.Color(204, 255, 255));
        appointmentDateTextField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        appointmentDateTextField.setForeground(new java.awt.Color(0, 0, 0));
        appointmentDateTextField.setToolTipText("MMDDYYYY");
        appointmentDateTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                appointmentDateTextFieldFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Appointment Time:");

        apptTimeTextField.setEditable(false);
        apptTimeTextField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        apptTimeTextField.setForeground(new java.awt.Color(255, 255, 255));
        apptTimeTextField.setText("07:00 AM");

        apptHourComboBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        apptHourComboBox.setForeground(new java.awt.Color(255, 255, 255));
        apptHourComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07", "08", "09", "10", "11", "12", "01", "02", "03", "04", "05", "06" }));
        apptHourComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apptHourComboBoxActionPerformed(evt);
            }
        });

        apptMinuteComboBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        apptMinuteComboBox.setForeground(new java.awt.Color(255, 255, 255));
        apptMinuteComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ":00", ":15", ":30", ":45" }));
        apptMinuteComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apptMinuteComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Doctor to See:");

        doctorComboBox.setBackground(new java.awt.Color(204, 255, 255));
        doctorComboBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        doctorComboBox.setForeground(new java.awt.Color(0, 0, 0));
        doctorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dr. Coleman", "Dr. Lukins", "Dr. Woods", "Dr. Haley" }));
        doctorComboBox.setToolTipText("Select Doctor");
        doctorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorComboBoxActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Arrival Status:");

        arrivalStatusComboBox.setBackground(new java.awt.Color(204, 255, 255));
        arrivalStatusComboBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        arrivalStatusComboBox.setForeground(new java.awt.Color(0, 0, 0));
        arrivalStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not Arrived", "Checked-In", "Waiting", "In Exam", "Checked-Out" }));
        arrivalStatusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrivalStatusComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Reason for Visit:");
        jLabel5.setToolTipText("");

        reasonForVisit.setBackground(new java.awt.Color(204, 255, 255));
        reasonForVisit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        reasonForVisit.setToolTipText("Input the reason for visit");
        reasonForVisit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                reasonForVisitFocusLost(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(32, 33, 35));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(253, 252, 233)));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/emrlogo3.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel8)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(apptTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(apptHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apptMinuteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(patientNameTextBox)
                    .addComponent(appointmentDateTextField)
                    .addComponent(doctorComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(arrivalStatusComboBox, 0, 378, Short.MAX_VALUE)
                    .addComponent(reasonForVisit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(patientNameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(appointmentDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apptTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apptHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apptMinuteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(doctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(arrivalStatusComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(reasonForVisit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout appointmentFormMainPanelLayout = new javax.swing.GroupLayout(appointmentFormMainPanel);
        appointmentFormMainPanel.setLayout(appointmentFormMainPanelLayout);
        appointmentFormMainPanelLayout.setHorizontalGroup(
            appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appointmentFormMainPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(301, 301, 301))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        appointmentFormMainPanelLayout.setVerticalGroup(
            appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentFormMainPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appointmentFormMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(appointmentFormMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void patientNameTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientNameTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientNameTextBoxActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        Boolean saveSuccess = saveAppointmentInfo();
		if (saveSuccess)
		{
			activeAppointment = null;
			dashBoard.showAppointmentDisplay();
		}
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        for(Component itsComp : this.getComponents())
		{
			System.out.println(itsComp.getClass().getName());
			if (itsComp.getClass().getName().equals("javax.swing.JTextField"))
			{
				((JTextComponent)itsComp).setText("");
			}
		}
		activeAppointment = null;
		dashBoard.showAppointmentDisplay();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void apptHourComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apptHourComboBoxActionPerformed
		String apptHourString = (String) apptHourComboBox.getSelectedItem();
		String apptMinString = (String) apptMinuteComboBox.getSelectedItem();
		updateApptTimeTextBox(apptHourString + apptMinString);
    }//GEN-LAST:event_apptHourComboBoxActionPerformed

    private void apptMinuteComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apptMinuteComboBoxActionPerformed
        String apptHourString = (String) apptHourComboBox.getSelectedItem();
		String apptMinString = (String) apptMinuteComboBox.getSelectedItem();
		updateApptTimeTextBox(apptHourString + apptMinString);
    }//GEN-LAST:event_apptMinuteComboBoxActionPerformed

    private void arrivalStatusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrivalStatusComboBoxActionPerformed
		//if (activeAppointment != null)
		//activeAppointment.setArrivalStatus(arrivalStatusComboBox.getSelectedIndex());
    }//GEN-LAST:event_arrivalStatusComboBoxActionPerformed

    private void doctorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorComboBoxActionPerformed
       // if (activeAppointment != null)
		//	activeAppointment.setDoctorToSee(doctorComboBox.getSelectedIndex());
    }//GEN-LAST:event_doctorComboBoxActionPerformed

    private void appointmentDateTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_appointmentDateTextFieldFocusLost
        
		Boolean validDate = validateDate(appointmentDateTextField.getText());
		
		if (!validDate)
		{
			appointmentDateTextField.setText("MMDDYYYY");
			JOptionPane.showMessageDialog(null, "Enter date in MMDDYYYY format.");
			appointmentDateTextField.requestFocus(true);
		}
		else
		{
			String theDate = appointmentDateTextField.getText();

			activeAppointment.setApptDate(Integer.parseInt(theDate));

			appointmentDateTextField.setText(formatDate(theDate));
		}
    }//GEN-LAST:event_appointmentDateTextFieldFocusLost

    private void reasonForVisitFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_reasonForVisitFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_reasonForVisitFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField appointmentDateTextField;
    private javax.swing.JPanel appointmentFormMainPanel;
    private javax.swing.JComboBox<String> apptHourComboBox;
    private javax.swing.JComboBox<String> apptMinuteComboBox;
    private javax.swing.JTextField apptTimeTextField;
    private javax.swing.JComboBox<String> arrivalStatusComboBox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> doctorComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField patientNameTextBox;
    private javax.swing.JTextField reasonForVisit;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
