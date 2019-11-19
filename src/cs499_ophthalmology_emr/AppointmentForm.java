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
        nameTextField.setText(theAppointment.getPatientName());
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
            activeAppointment.setPatientName(nameTextField.getText());
            
            if(appointmentDateTextField.getText().equals(""))
                activeAppointment.setApptDate(0);
            else
                activeAppointment.setApptDate(unformatDate(appointmentDateTextField.getText()));
			
			activeAppointment.setReasonForVisit(reasonForVisit.getText());
            
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
			nameTextField.setText("No active patient selected.");
		}
		else
		{
			String patientName = dashBoard.getActivePatient().getName();
			nameTextField.setText(patientName);
			
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
		nameTextField.setEditable(false);
	}
    
    private String formatDate(String theDate)
    {
        String formattedStr = "";
        
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
    
    
    private Boolean validateFloat(String theString)
    {
		Boolean isValid = true;
		Boolean decimalFound = false;
		Integer remainingDecimalPlaces = 2;
		
		String trimmedFloat = "";
		
		for (Integer i=0; i < theString.length(); i++)
		{
			if (Character.isDigit(theString.charAt(i)))
			{
				if (decimalFound)
				{
					--remainingDecimalPlaces;
					if (remainingDecimalPlaces < 0)
					{
						isValid = false;
					}
				}
				trimmedFloat += theString.charAt(i);
			}
			
			
			
			if (theString.charAt(i) == '.')
			{
				if (decimalFound == true)
				{
					isValid = false;
				}
				else
				{
					decimalFound = true;
				}
			}
		}
		if (remainingDecimalPlaces != 0)
		{
			isValid = false;
		}
		if (trimmedFloat.equals(""))
		{
			isValid = false;
		}
		return (isValid && decimalFound);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        appointmentDateTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        reasonForVisit = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        clearAllButton = new javax.swing.JButton();
        apptHourComboBox = new javax.swing.JComboBox<>();
        apptMinuteComboBox = new javax.swing.JComboBox<>();
        apptTimeTextField = new javax.swing.JTextField();
        doctorComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        arrivalStatusComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(53, 60, 81));

        appointmentFormMainPanel.setBackground(new java.awt.Color(57, 113, 177));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Appointment Form");

        jLabel2.setText("Name:");

        nameTextField.setEditable(false);
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Appointment Date:");

        appointmentDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentDateTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Reason for visit:");

        reasonForVisit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reasonForVisitActionPerformed(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        clearAllButton.setText("Clear All");
        clearAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllButtonActionPerformed(evt);
            }
        });

        apptHourComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "07", "08", "09", "10", "11", "12", "01", "02", "03", "04", "05", "06" }));
        apptHourComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apptHourComboBoxActionPerformed(evt);
            }
        });

        apptMinuteComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ":00", ":15", ":30", ":45" }));
        apptMinuteComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apptMinuteComboBoxActionPerformed(evt);
            }
        });

        apptTimeTextField.setEditable(false);
        apptTimeTextField.setText("07:00 AM");

        doctorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dr. Coleman", "Dr. Lukins", "Dr. Woods", "Dr. Haley" }));

        jLabel3.setText("Appointment Time:");

        jLabel6.setText("Doctor to See:");

        jLabel7.setText("Arrival Status:");

        arrivalStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Not arrived", "Checked in, waiting", "In Examination", "Checked out" }));

        javax.swing.GroupLayout appointmentFormMainPanelLayout = new javax.swing.GroupLayout(appointmentFormMainPanel);
        appointmentFormMainPanel.setLayout(appointmentFormMainPanelLayout);
        appointmentFormMainPanelLayout.setHorizontalGroup(
            appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentFormMainPanelLayout.createSequentialGroup()
                .addGroup(appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(appointmentFormMainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(appointmentFormMainPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(appointmentDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reasonForVisit, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(appointmentFormMainPanelLayout.createSequentialGroup()
                                        .addComponent(apptTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(apptHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(apptMinuteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(appointmentFormMainPanelLayout.createSequentialGroup()
                                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(arrivalStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(doctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(appointmentFormMainPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(submitButton)
                        .addGap(28, 28, 28)
                        .addComponent(cancelButton)
                        .addGap(29, 29, 29)
                        .addComponent(clearAllButton)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        appointmentFormMainPanelLayout.setVerticalGroup(
            appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointmentFormMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(arrivalStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appointmentDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apptHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apptMinuteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apptTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(7, 7, 7)
                .addGroup(appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reasonForVisit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addGroup(appointmentFormMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(cancelButton)
                    .addComponent(clearAllButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appointmentFormMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appointmentFormMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void appointmentDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentDateTextFieldActionPerformed

    private void reasonForVisitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reasonForVisitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reasonForVisitActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        Boolean saveSuccess = saveAppointmentInfo();
		if (saveSuccess)
		{
			activeAppointment = null;
			dashBoard.showAppointmentDisplay();
		}
    }//GEN-LAST:event_submitButtonActionPerformed

    private void clearAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("New Appointment Form: Clear Button");
		for(Component itsComp : this.getComponents())
		{
			System.out.println(itsComp.getClass().getName());
			if (itsComp.getClass().getName().equals("javax.swing.JTextField"))
			{
				((JTextComponent)itsComp).setText(" ");
			}
		}
		activeAppointment = null;
    }//GEN-LAST:event_clearAllButtonActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField appointmentDateTextField;
    private javax.swing.JPanel appointmentFormMainPanel;
    private javax.swing.JComboBox<String> apptHourComboBox;
    private javax.swing.JComboBox<String> apptMinuteComboBox;
    private javax.swing.JTextField apptTimeTextField;
    private javax.swing.JComboBox<String> arrivalStatusComboBox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton clearAllButton;
    private javax.swing.JComboBox<String> doctorComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField reasonForVisit;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
