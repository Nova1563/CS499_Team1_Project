/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;

import java.awt.Component;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author kenda
 */
public class NewAppointmentForm extends javax.swing.JPanel {
    
        private DataBaseManager dataBase = null;
	private MainDashboard dashBoard = null;
	private Appointment activeAppointment = null;

    /**
     * Creates new form NewPatientForm
     */
    public NewAppointmentForm(MainDashboard _dashBoard) {
        initComponents();
        dataBase = DataBaseManager.getInstance();
	dashBoard = _dashBoard;
    }
    
    public void loadAppointment(Appointment theAppointment)
    {
        activeAppointment = theAppointment;
        AppointmentDateTextField.setText(formatDate(theAppointment.getApptDate().toString()));
        ReasonForVisit.setText(theAppointment.getReasonForVisit());
        nameTextField.setText(theAppointment.getPatientName());
    }
    
    public Boolean saveAppointmentInfo()
    {
        Boolean isSuccess = false;
        
        activeAppointment = dataBase.getNewAppointment(dashBoard.getActivePatient().getPatientID());
	
        
        try
        {
            activeAppointment.setPatientName(nameTextField.getText());
            
            
            if(AppointmentDateTextField.getText().equals(""))
            {
                activeAppointment.setApptDate(0);
            }
            
            else
            {
                activeAppointment.setApptDate(unformatDate(AppointmentDateTextField.getText()));
            }
            
            isSuccess = true;
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error: ");
            System.out.println("NewAppointmentForm.savePatientInfo() error: " + e.getMessage());
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
		
		for(Component itsComp : jPanel1.getComponents())
		{
			//	System.out.println(itsComp.getClass().getName());
			if (itsComp.getClass().getName().equals("javax.swing.JTextField"))
			{
				((JTextComponent)itsComp).setEnabled(false);
			}
		}
		
		if (dashBoard.getActivePatient() == null)
		{
			nameTextField.setText("No active patient selected.");
		}
		else
		{
			String patientName = dashBoard.getActivePatient().getName();
			nameTextField.setText(patientName);
			
			for(Component itsComp : this.getComponents())
			{
				//	System.out.println(itsComp.getClass().getName());
				if (itsComp.getClass().getName().equals("javax.swing.JTextField"))
				{
					((JTextComponent)itsComp).setEnabled(true);
				}
			}
			nameTextField.setEnabled(false);
			
		}
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AppointmentDateTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ReasonForVisit = new javax.swing.JTextField();
        Submit = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        ClearAll = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(53, 60, 81));

        jPanel1.setBackground(new java.awt.Color(57, 113, 177));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("New Appointment Form");

        jLabel2.setText("Name (First, Last):");

        nameTextField.setEnabled(false);
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Appointment Date:");

        AppointmentDateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppointmentDateTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Reason for visit:");

        ReasonForVisit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReasonForVisitActionPerformed(evt);
            }
        });

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        Cancel.setText("Cancel");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        ClearAll.setText("Clear All");
        ClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel2))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel5))
                                        .addComponent(jLabel4)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AppointmentDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ReasonForVisit, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(Submit)
                        .addGap(28, 28, 28)
                        .addComponent(Cancel)
                        .addGap(29, 29, 29)
                        .addComponent(ClearAll)))
                .addContainerGap(388, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AppointmentDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(ReasonForVisit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Submit)
                    .addComponent(Cancel)
                    .addComponent(ClearAll))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(57, 113, 177));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(350, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(334, 334, 334))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void AppointmentDateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppointmentDateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AppointmentDateTextFieldActionPerformed

    private void ReasonForVisitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReasonForVisitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReasonForVisitActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        // TODO add your handling code here:
        Boolean saveSuccess = saveAppointmentInfo();
		if (saveSuccess)
		{
			activeAppointment = null;
			dashBoard.showAppointmentDisplay();
		}
    }//GEN-LAST:event_SubmitActionPerformed

    private void ClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearAllActionPerformed
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
    }//GEN-LAST:event_ClearAllActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
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
    }//GEN-LAST:event_CancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AppointmentDateTextField;
    private javax.swing.JButton Cancel;
    private javax.swing.JButton ClearAll;
    private javax.swing.JTextField ReasonForVisit;
    private javax.swing.JButton Submit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField nameTextField;
    // End of variables declaration//GEN-END:variables
}
