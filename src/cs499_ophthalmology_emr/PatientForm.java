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
public class PatientForm extends javax.swing.JPanel {
	private DataBaseManager dataBase = null;
	private MainDashboard dashBoard = null;
	private Patient activePatient = null;
    /**
     * Creates new form NewAppointmentForm
     */
    public PatientForm(MainDashboard _dashBoard) {
		dataBase = DataBaseManager.getInstance();
		dashBoard = _dashBoard;
        initComponents();
    }
	
	public void loadPatientInfo(Patient thePatient)
	{
		activePatient = thePatient;
		addressTextField.setText(thePatient.getAddress());
		ageTextField.setText(thePatient.getAge().toString());
		contractTextField.setText(thePatient.getInsContractNo());
		copayTextField.setText(String.valueOf(thePatient.getInsCoPayAmount()));
		dobTextField.setText(formatDate(thePatient.getDateOfBirth().toString()));
		effectiveTextField.setText(formatDate(thePatient.getInsEffectiveDate().toString()));
		emailTextField.setText(thePatient.getEmailAddress());
		emergName.setText(thePatient.getEmergContactName());
		emergPhone.setText(thePatient.getEmergContactPhone());
		genderTextField.setText(thePatient.getGender());
		groupTextField.setText(thePatient.getInsGroupNo());
		homePhoneTextField.setText(thePatient.getHomePhone());
		mobilePhoneTextField.setText(thePatient.getMobilePhone());
		nameTextField.setText(thePatient.getName());
		providerAddrTextField.setText(thePatient.getInsProviderAddr());
		providerPhoneTextField.setText(thePatient.getInsProviderPhone());
		providerTextField.setText(thePatient.getInsProvider());
		ssnTextField.setText(thePatient.getSsn());
		titleTextField.setText(thePatient.getTitle());
		workPhoneTextField.setText(thePatient.getWorkPhone());
	}
	
	public Boolean savePatientInfo()
	{
		Boolean isSuccess = false;
		if (activePatient == null)
		{
			activePatient = dataBase.getNewPatient();
		}
		try
		{
			activePatient.setName(nameTextField.getText());
			activePatient.setAddress(addressTextField.getText());
			if (ageTextField.getText().equals(""))
				activePatient.setAge(0);
			else
				activePatient.setAge(Integer.parseInt(ageTextField.getText()));
			
			if (dobTextField.getText().equals(""))
				activePatient.setDateOfBirth(0);
			else
				activePatient.setDateOfBirth(unformatDate(dobTextField.getText()));
			
			activePatient.setEmailAddress(emailTextField.getText());
			activePatient.setHomePhone(homePhoneTextField.getText());
			activePatient.setWorkPhone(workPhoneTextField.getText());
			activePatient.setMobilePhone(mobilePhoneTextField.getText());
			activePatient.setGender(genderTextField.getText());
			activePatient.setTitle(titleTextField.getText());
			activePatient.setSsn(ssnTextField.getText());
			activePatient.setEmergContactName(emergName.getText());
			activePatient.setEmergContactPhone(emergPhone.getText());
			activePatient.setInsProvider(providerTextField.getText());
			activePatient.setInsGroupNo(groupTextField.getText());
			activePatient.setInsContractNo(contractTextField.getText());
			if (effectiveTextField.getText().equals(""))
				activePatient.setInsEffectiveDate(0);
			else
				activePatient.setInsEffectiveDate(unformatDate(effectiveTextField.getText()));
			
			if (copayTextField.getText().equals(""))
				activePatient.setInsCoPayAmount(0.0);
			else
				activePatient.setInsCoPayAmount(Double.valueOf(copayTextField.getText()));
			
			activePatient.setInsProviderAddr(providerAddrTextField.getText());
			activePatient.setInsProviderPhone(providerPhoneTextField.getText());

			isSuccess = true;
		}
		catch(Exception e)
		{
			//dataBase.delete(activePatient);
			JOptionPane.showMessageDialog(null, "Error: ");
			System.out.println("PatientForm.savePatientInfo() error: " + e.getMessage());
			isSuccess = false;
		}
		if (isSuccess)
			dataBase.save(activePatient);

		return isSuccess;
	}
	
	private String formatDate(String theDate)
	{
		String formattedStr = "";
		
		for (Integer i = 0; i < theDate.length(); i++)
		{
			if ((i == 2) || (i == 4))
				formattedStr = formattedStr + "/" +theDate.charAt(i);
			else
				formattedStr = formattedStr +theDate.charAt(i);
		}
		return formattedStr;
	}
	
	private Integer unformatDate(String theDate)
	{
		String formattedStr = "";
		
		for (Integer i = 0; i < theDate.length(); i++)
		{
			if (Character.isDigit(theDate.charAt(i)))
				formattedStr += theDate.charAt(i);
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

        nameTextField = new javax.swing.JTextField();
        titleTextField = new javax.swing.JTextField();
        genderTextField = new javax.swing.JTextField();
        ageTextField = new javax.swing.JTextField();
        dobTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        homePhoneTextField = new javax.swing.JTextField();
        workPhoneTextField = new javax.swing.JTextField();
        mobilePhoneTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        ssnTextField = new javax.swing.JTextField();
        emergName = new javax.swing.JTextField();
        emergPhone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        providerTextField = new javax.swing.JTextField();
        contractTextField = new javax.swing.JTextField();
        groupTextField = new javax.swing.JTextField();
        effectiveTextField = new javax.swing.JTextField();
        copayTextField = new javax.swing.JTextField();
        providerPhoneTextField = new javax.swing.JTextField();
        providerAddrTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(53, 60, 81));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 67, 260, -1));

        titleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleTextFieldActionPerformed(evt);
            }
        });
        add(titleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 97, 260, -1));
        add(genderTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 128, 260, -1));

        ageTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ageTextFieldFocusLost(evt);
            }
        });
        add(ageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 158, 260, -1));

        dobTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dobTextFieldFocusLost(evt);
            }
        });
        add(dobTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 188, 260, -1));
        add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 218, 260, -1));
        add(homePhoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 248, 260, -1));
        add(workPhoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 278, 260, -1));
        add(mobilePhoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 308, 260, -1));
        add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 338, 260, -1));
        add(ssnTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 368, 260, -1));
        add(emergName, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 398, 260, -1));
        add(emergPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 428, 260, -1));
        dobTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //dobTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 74, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Address:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 221, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Home Phone #:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 251, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Work Phone #:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 281, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date of Birth:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 191, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gender:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 131, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Title:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Age:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(191, 161, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("E-mail Address:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 341, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Social Security #:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 371, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mobile Phone #:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 311, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Emergency Contact Name:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 401, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Emergency Contact Phone #:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 431, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Patient Information");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        saveButton.setBackground(new java.awt.Color(57, 113, 177));
        saveButton.setText("Submit");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 476, 81, -1));

        clearButton.setText("Clear All");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        add(clearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 476, -1, -1));
        add(providerTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 158, 260, -1));
        add(contractTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 188, 260, -1));
        add(groupTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 218, 260, -1));

        effectiveTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                effectiveTextFieldFocusLost(evt);
            }
        });
        add(effectiveTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 248, 260, -1));

        copayTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                copayTextFieldFocusLost(evt);
            }
        });
        add(copayTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 278, 260, -1));
        add(providerPhoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 308, 260, -1));
        add(providerAddrTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 338, 260, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Insurance Information");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 127, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Provider:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 161, -1, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Contract #:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 191, -1, -1));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Group #:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 221, -1, -1));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Effective Date:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 251, -1, -1));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Co-pay:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 281, -1, -1));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Provider Phone #:");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 311, -1, -1));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Provider Address:");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 341, -1, -1));

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 476, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void titleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleTextFieldActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        System.out.println("New Patient Form: Clear Button");
		for(Component itsComp : this.getComponents())
		{
			System.out.println(itsComp.getClass().getName());
			if (itsComp.getClass().getName().equals("javax.swing.JTextField"))
			{
				((JTextComponent)itsComp).setText(" ");
			}
		}
		activePatient = null;
    }//GEN-LAST:event_clearButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        for(Component itsComp : this.getComponents())
		{
			System.out.println(itsComp.getClass().getName());
			if (itsComp.getClass().getName().equals("javax.swing.JTextField"))
			{
				((JTextComponent)itsComp).setText("");
			}
		}
		activePatient = null;
		dashBoard.showPatientPortal();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Boolean saveSuccess = savePatientInfo();
		if (saveSuccess)
		{
			activePatient = null;
			dashBoard.showPatientPortal();
		}
    }//GEN-LAST:event_saveButtonActionPerformed

    private void dobTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dobTextFieldFocusLost
        Boolean validDate = validateDate(dobTextField.getText());
		
		if (!validDate)
		{
			dobTextField.setText("MMDDYYYY");
			JOptionPane.showMessageDialog(null, "Enter date in MMDDYYYY format.");
			dobTextField.requestFocus(true);
		}
    }//GEN-LAST:event_dobTextFieldFocusLost

    private void effectiveTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_effectiveTextFieldFocusLost
        Boolean validDate = validateDate(effectiveTextField.getText());
		
		if (!validDate)
		{
			effectiveTextField.setText("MMDDYYYY");
			JOptionPane.showMessageDialog(null, "Enter date in MMDDYYYY format.");
			effectiveTextField.requestFocus(true);
		}
    }//GEN-LAST:event_effectiveTextFieldFocusLost

    private void copayTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_copayTextFieldFocusLost
        Boolean validFloat = validateFloat(copayTextField.getText());
		
		if (!validFloat)
		{
			copayTextField.setText("0.00");
			JOptionPane.showMessageDialog(null, "Enter copay as decimal. Ex: 4.50");
			copayTextField.requestFocus(true);
		}
    }//GEN-LAST:event_copayTextFieldFocusLost

    private void ageTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ageTextFieldFocusLost
        Boolean isValid = true;
		
		String ageString = ageTextField.getText();
		
		for (Integer i=0; i < ageString.length(); i++)
		{
			if (!(Character.isDigit(ageString.charAt(i))))
			{
				isValid = false;
			}
		}
		if (ageString.equals(""))
		{
			isValid = false;
		}
		//if (ageString.length() > 3)
		//{
		//	isValid = false;
		//}
		if (!isValid)
		{
			ageTextField.setText("0");
			JOptionPane.showMessageDialog(null, "Enter valid age.");
			ageTextField.requestFocus(true);
		}
    }//GEN-LAST:event_ageTextFieldFocusLost

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTextField;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField contractTextField;
    private javax.swing.JTextField copayTextField;
    private javax.swing.JTextField dobTextField;
    private javax.swing.JTextField effectiveTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField emergName;
    private javax.swing.JTextField emergPhone;
    private javax.swing.JTextField genderTextField;
    private javax.swing.JTextField groupTextField;
    private javax.swing.JTextField homePhoneTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mobilePhoneTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField providerAddrTextField;
    private javax.swing.JTextField providerPhoneTextField;
    private javax.swing.JTextField providerTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField ssnTextField;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JTextField workPhoneTextField;
    // End of variables declaration//GEN-END:variables
}
