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
		
		if (theDate.length() < 8)
		{
			theDate = "0" + theDate;
		}
		
		for (Integer i = 0; i < theDate.length(); i++)
		{
			if ((i == 2) || (i == 4))
				formattedStr = formattedStr + "/" +theDate.charAt(i);
			else
				formattedStr = formattedStr +theDate.charAt(i);
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

        saveButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        addressTextField = new javax.swing.JTextField();
        homePhoneTextField = new javax.swing.JTextField();
        workPhoneTextField = new javax.swing.JTextField();
        mobilePhoneTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        ssnTextField = new javax.swing.JTextField();
        emergName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        genderTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ageTextField = new javax.swing.JTextField();
        dobTextField = new javax.swing.JTextField();
        emergPhone = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        providerTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        contractTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        groupTextField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        effectiveTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        copayTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        providerPhoneTextField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        providerAddrTextField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(57, 113, 177));
        setPreferredSize(new java.awt.Dimension(1900, 900));

        saveButton.setBackground(new java.awt.Color(102, 255, 102));
        saveButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 0, 0));
        saveButton.setText("SUBMIT");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        clearButton.setBackground(new java.awt.Color(255, 0, 51));
        clearButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        clearButton.setForeground(new java.awt.Color(0, 0, 0));
        clearButton.setText("CLEAR ALL");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(255, 0, 51));
        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(0, 0, 0));
        cancelButton.setText("CANCEL");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(32, 33, 35));
        jPanel2.setPreferredSize(new java.awt.Dimension(1900, 66));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Patient Information");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(32, 33, 35));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(253, 252, 233)));
        jPanel1.setPreferredSize(new java.awt.Dimension(2626, 671));

        addressTextField.setBackground(new java.awt.Color(204, 255, 255));
        addressTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addressTextField.setForeground(new java.awt.Color(0, 0, 0));

        homePhoneTextField.setBackground(new java.awt.Color(204, 255, 255));
        homePhoneTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        homePhoneTextField.setForeground(new java.awt.Color(0, 0, 0));
        homePhoneTextField.setToolTipText("Enter Patient's Home Number");

        workPhoneTextField.setBackground(new java.awt.Color(204, 255, 255));
        workPhoneTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        workPhoneTextField.setForeground(new java.awt.Color(0, 0, 0));
        workPhoneTextField.setToolTipText("Enter Patient's Work Phone Number");

        mobilePhoneTextField.setBackground(new java.awt.Color(204, 255, 255));
        mobilePhoneTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mobilePhoneTextField.setForeground(new java.awt.Color(0, 0, 0));
        mobilePhoneTextField.setToolTipText("Enter Patient's Mobile Contact");

        emailTextField.setBackground(new java.awt.Color(204, 255, 255));
        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailTextField.setForeground(new java.awt.Color(0, 0, 0));
        emailTextField.setToolTipText("Enter Patient Email Address");

        ssnTextField.setBackground(new java.awt.Color(204, 255, 255));
        ssnTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ssnTextField.setForeground(new java.awt.Color(0, 0, 0));
        ssnTextField.setToolTipText("SSS-SS-SSSS");

        emergName.setBackground(new java.awt.Color(204, 255, 255));
        emergName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emergName.setForeground(new java.awt.Color(0, 0, 0));
        emergName.setToolTipText("Enter Emergency Contact");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Address:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Home Phone #:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Work Phone #:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date of Birth:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Gender:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Title:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Age:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("E-mail Address:");

        nameTextField.setBackground(new java.awt.Color(204, 255, 255));
        nameTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameTextField.setToolTipText("Enter Patient's Name");
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Social Security #:");

        titleTextField.setBackground(new java.awt.Color(204, 255, 255));
        titleTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        titleTextField.setForeground(new java.awt.Color(0, 0, 0));
        titleTextField.setToolTipText("(Mr./Mrs./Ms/Miss/Jr./Sr.)");
        titleTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleTextFieldActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mobile Phone #:");

        genderTextField.setBackground(new java.awt.Color(204, 255, 255));
        genderTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        genderTextField.setForeground(new java.awt.Color(0, 0, 0));
        genderTextField.setToolTipText("(Male/Female/They)");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Emergency Contact Name:");

        ageTextField.setBackground(new java.awt.Color(204, 255, 255));
        ageTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ageTextField.setForeground(new java.awt.Color(0, 0, 0));
        ageTextField.setToolTipText("Enter Patient's");
        ageTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ageTextFieldFocusLost(evt);
            }
        });

        dobTextField.setBackground(new java.awt.Color(204, 255, 255));
        dobTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dobTextField.setForeground(new java.awt.Color(0, 0, 0));
        dobTextField.setToolTipText("Enter Patient's Date of Birth");
        dobTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dobTextFieldFocusLost(evt);
            }
        });
        dobTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobTextFieldActionPerformed(evt);
            }
        });

        emergPhone.setBackground(new java.awt.Color(204, 255, 255));
        emergPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emergPhone.setForeground(new java.awt.Color(0, 0, 0));
        emergPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emergPhoneActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Emergency Contact Phone #:");

        jPanel3.setBackground(new java.awt.Color(32, 33, 35));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(253, 252, 233)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Insurance Information:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Provider:");

        providerTextField.setBackground(new java.awt.Color(204, 255, 255));
        providerTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        providerTextField.setForeground(new java.awt.Color(0, 0, 0));
        providerTextField.setToolTipText("Enter Inusrance Provider");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Contract #:");

        contractTextField.setBackground(new java.awt.Color(204, 255, 255));
        contractTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contractTextField.setForeground(new java.awt.Color(0, 0, 0));
        contractTextField.setToolTipText("Enter Contact Number");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Group #:");

        groupTextField.setBackground(new java.awt.Color(204, 255, 255));
        groupTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        groupTextField.setForeground(new java.awt.Color(0, 0, 0));
        groupTextField.setToolTipText("Enter patient's Group Number");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Effective Date:");

        effectiveTextField.setBackground(new java.awt.Color(204, 255, 255));
        effectiveTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        effectiveTextField.setForeground(new java.awt.Color(0, 0, 0));
        effectiveTextField.setToolTipText("MMDDYYYYY");
        effectiveTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                effectiveTextFieldFocusLost(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Co-pay:");

        copayTextField.setBackground(new java.awt.Color(204, 255, 255));
        copayTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        copayTextField.setForeground(new java.awt.Color(0, 0, 0));
        copayTextField.setToolTipText("Enter Co-Pay Amount");
        copayTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                copayTextFieldFocusLost(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Provider Phone #:");

        providerPhoneTextField.setBackground(new java.awt.Color(204, 255, 255));
        providerPhoneTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        providerPhoneTextField.setForeground(new java.awt.Color(0, 0, 0));
        providerPhoneTextField.setToolTipText("Enter Insurance Provider's Phone Number");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Provider Address:");

        providerAddrTextField.setBackground(new java.awt.Color(204, 255, 255));
        providerAddrTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        providerAddrTextField.setForeground(new java.awt.Color(0, 0, 0));
        providerAddrTextField.setToolTipText("Enter Insurance Address");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(contractTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(145, 145, 145)
                                        .addComponent(providerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel19))
                                        .addGap(100, 100, 100)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(groupTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(effectiveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(copayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(providerPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(providerAddrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(providerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(contractTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(groupTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(effectiveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(copayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(providerPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(providerAddrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emergPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emergName, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ssnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobilePhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(workPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(homePhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 354, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(853, 853, 853))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(homePhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(workPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(mobilePhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(ssnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(emergName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(emergPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 422, Short.MAX_VALUE)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(392, 392, 392)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(307, 307, 307))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton)
                    .addComponent(cancelButton)
                    .addComponent(saveButton))
                .addGap(38, 38, 38))
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
			dataBase.updateApptsWithPatientNameChange(activePatient);
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
		else
		{
			Integer unformattedDate = unformatDate(dobTextField.getText());
			dobTextField.setText(formatDate(unformattedDate.toString()));
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
		else
		{
			Integer unformattedDate = unformatDate(effectiveTextField.getText());
			effectiveTextField.setText(formatDate(unformattedDate.toString()));
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

    private void emergPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emergPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emergPhoneActionPerformed

    private void dobTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobTextFieldActionPerformed


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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
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
