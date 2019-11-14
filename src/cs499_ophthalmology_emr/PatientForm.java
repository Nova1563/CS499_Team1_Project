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

        setBackground(new java.awt.Color(185, 134, 11));

        titleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleTextFieldActionPerformed(evt);
            }
        });

        ageTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ageTextFieldFocusLost(evt);
            }
        });

        dobTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dobTextFieldFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Address:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Home Phone #:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Work Phone #:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Date of Birth:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Gender:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Title:");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Age:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("E-mail Address:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Social Security #:");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Mobile Phone #:");

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Emergency Contact Name:");

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Emergency Contact Phone #:");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel14.setText("Patient Information");

        saveButton.setText("Submit");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear All");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        effectiveTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                effectiveTextFieldFocusLost(evt);
            }
        });

        copayTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                copayTextFieldFocusLost(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setText("Insurance Information");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Provider:");

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("Contract #:");

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("Group #:");

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setText("Effective Date:");

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel20.setText("Co-pay:");

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setText("Provider Phone #:");

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setText("Provider Address:");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ssnTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                                    .addComponent(emailTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mobilePhoneTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(workPhoneTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(homePhoneTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addressTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dobTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ageTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(genderTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(providerTextField)
                                        .addComponent(contractTextField)
                                        .addComponent(effectiveTextField)
                                        .addComponent(groupTextField)
                                        .addComponent(copayTextField)
                                        .addComponent(providerPhoneTextField)
                                        .addComponent(providerAddrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(emergName, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cancelButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(clearButton))
                                    .addComponent(emergPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel14))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(homePhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(workPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mobilePhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(providerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contractTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(groupTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(effectiveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(copayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(providerPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(providerAddrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ssnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emergName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emergPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(clearButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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
