/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;

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
public class PatientPageTemplate extends javax.swing.JPanel {
	private final Integer APPT_ID_COLUMN = 3;
	private MainDashboard mainDash;
	private Patient currentPatient;
	private Appointment currentAppointment;
	private EyeTestResults currentResults;
	private ArrayList<Appointment> patientAppointments;
	private ArrayList<EyeTestResults> patientResults;
	private DataBaseManager dataBase;
	
    /**
     * Creates new form PatientPageTemplate
     */
    public PatientPageTemplate(MainDashboard _mainDash) {
		dataBase = DataBaseManager.getInstance();
		mainDash = _mainDash;
        initComponents();
		addRightClickListener();
		addressTextField.setEditable(false);
		ageTextField.setEditable(false);
		contractTextField.setEditable(false);
		copayTextField.setEditable(false);
		dobTextField.setEditable(false);
		effectiveTextField.setEditable(false);
		emailTextField.setEditable(false);
		emergName.setEditable(false);
		emergPhone.setEditable(false);
		genderTextField.setEditable(false);
		groupTextField.setEditable(false);
		homePhoneTextField.setEditable(false);
		mobilePhoneTextField.setEditable(false);
		nameTextField.setEditable(false);
		providerAddrTextField.setEditable(false);
		providerPhoneTextField.setEditable(false);
		providerTextField.setEditable(false);
		ssnTextField.setEditable(false);
		titleTextField.setEditable(false);
		workPhoneTextField.setEditable(false);
    }

	public void loadAllPatientInfo(Patient thePatient)
	{
		currentPatient = thePatient;
		
		loadGeneralInfo();
		loadInsuranceInfo();
		loadAppointmentsInfo();
	}
	
	private void loadGeneralInfo()
	{
		addressTextField.setText(currentPatient.getAddress());
		ageTextField.setText(currentPatient.getAge().toString());
		dobTextField.setText(formatDate(currentPatient.getDateOfBirth().toString()));
		emailTextField.setText(currentPatient.getEmailAddress());
		emergName.setText(currentPatient.getEmergContactName());
		emergPhone.setText(currentPatient.getEmergContactPhone());
		genderTextField.setText(currentPatient.getGender());
		homePhoneTextField.setText(currentPatient.getHomePhone());
		mobilePhoneTextField.setText(currentPatient.getMobilePhone());
		nameTextField.setText(currentPatient.getName());
		patientNameLeftBarTextBox.setText(currentPatient.getName());
		ssnTextField.setText(currentPatient.getSsn());
		titleTextField.setText(currentPatient.getTitle());
		workPhoneTextField.setText(currentPatient.getWorkPhone());
	}
	
	private void loadAppointmentsInfo()
	{
		patientAppointments = dataBase.getPatientAppointmentList(currentPatient);
		
        Integer doctorToSee = -1;
		String doctorString = null;
        Integer apptDate = -1;
		String apptDateString = null;
		Integer apptTime = -1;
		String reasonForVisit = null;
        Integer apptID = -1;
		Integer checkInCode = -1;
		String checkInString = null;
        
		DefaultTableModel tableModel = (DefaultTableModel) appointmentDisplayTable.getModel();
		
        tableModel.setRowCount(0);
        
        for (Appointment currentAppointment: patientAppointments)
        {
			doctorToSee = currentAppointment.getDoctorToSee();
			doctorString = translateDoctorToSeeCode(doctorToSee);
    
			apptDate = currentAppointment.getApptDate();
			apptDateString = formatDate(apptDate.toString());
			
            //apptTime = currentAppointment.getAppointmentTime();
            reasonForVisit = currentAppointment.getReasonForVisit();
            apptID = currentAppointment.getApptID();
            
            tableModel.addRow(new Object[] {apptDateString, reasonForVisit, doctorString, apptID});
        }
		tableModel.fireTableDataChanged();
		
	}
	
	private void loadInsuranceInfo()
	{
		groupTextField.setText(currentPatient.getInsGroupNo());
		contractTextField.setText(currentPatient.getInsContractNo());
		copayTextField.setText(String.valueOf(currentPatient.getInsCoPayAmount()));
		effectiveTextField.setText(formatDate(currentPatient.getInsEffectiveDate().toString()));
		providerAddrTextField.setText(currentPatient.getInsProviderAddr());
		providerPhoneTextField.setText(currentPatient.getInsProviderPhone());
		providerTextField.setText(currentPatient.getInsProvider());
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
		
		JMenuItem viewAppt = new JMenuItem("View Appointment Info");
		JMenuItem viewExam = new JMenuItem("View Exam Results");

		theMenu.add(viewAppt);
		theMenu.add(viewExam);

		viewAppt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickMenuViewAppt(evt);
            }
		});
		
		viewExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickMenuViewExam(evt);
            }
		});
		
		return theMenu;
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
        patientNameLeftBarTextBox = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
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
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        providerTextField = new javax.swing.JTextField();
        contractTextField = new javax.swing.JTextField();
        groupTextField = new javax.swing.JTextField();
        effectiveTextField = new javax.swing.JTextField();
        copayTextField = new javax.swing.JTextField();
        providerPhoneTextField = new javax.swing.JTextField();
        providerAddrTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        appointmentDisplayTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(53, 60, 81));
        setMaximumSize(new java.awt.Dimension(1900, 800));
        setPreferredSize(new java.awt.Dimension(1900, 800));

        jPanel1.setBackground(new java.awt.Color(32, 33, 35));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        patientNameLeftBarTextBox.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        patientNameLeftBarTextBox.setForeground(new java.awt.Color(255, 255, 255));
        patientNameLeftBarTextBox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientNameLeftBarTextBox.setText("John Doe");
        patientNameLeftBarTextBox.setToolTipText("Active Patient");
        jPanel1.add(patientNameLeftBarTextBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 30, 160, 26));

        jPanel8.setBackground(new java.awt.Color(57, 113, 177));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/drColeman2.png"))); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel23)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 160, 230));

        jTabbedPane1.setBackground(new java.awt.Color(53, 60, 81));
        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTabbedPane1.setName("P.I"); // NOI18N

        jPanel2.setBackground(new java.awt.Color(253, 252, 233));
        jPanel2.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        jPanel2.setInheritsPopupMenu(true);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(32, 33, 35));
        jLabel4.setText("Name:");
        jLabel4.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(32, 33, 35));
        jLabel5.setText("Title:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(32, 33, 35));
        jLabel6.setText("Gender:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(32, 33, 35));
        jLabel7.setText("Age:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(32, 33, 35));
        jLabel8.setText("Date of Birth:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(32, 33, 35));
        jLabel9.setText("Address:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(32, 33, 35));
        jLabel10.setText("Home Phone #:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(32, 33, 35));
        jLabel11.setText("Work Phone #:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(32, 33, 35));
        jLabel12.setText("Mobile Phone #:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(32, 33, 35));
        jLabel13.setText("E-mail Address:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(32, 33, 35));
        jLabel14.setText("SSN:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(32, 33, 35));
        jLabel15.setText("Emergency Contact:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(32, 33, 35));
        jLabel16.setText("Emergency Contact #:");

        nameTextField.setBackground(new java.awt.Color(204, 255, 255));
        nameTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        titleTextField.setBackground(new java.awt.Color(204, 255, 255));
        titleTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        genderTextField.setBackground(new java.awt.Color(204, 255, 255));
        genderTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ageTextField.setBackground(new java.awt.Color(204, 255, 255));
        ageTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageTextFieldActionPerformed(evt);
            }
        });

        dobTextField.setBackground(new java.awt.Color(204, 255, 255));
        dobTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        addressTextField.setBackground(new java.awt.Color(204, 255, 255));
        addressTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        homePhoneTextField.setBackground(new java.awt.Color(204, 255, 255));
        homePhoneTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        homePhoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homePhoneTextFieldActionPerformed(evt);
            }
        });

        workPhoneTextField.setBackground(new java.awt.Color(204, 255, 255));
        workPhoneTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        mobilePhoneTextField.setBackground(new java.awt.Color(204, 255, 255));
        mobilePhoneTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        emailTextField.setBackground(new java.awt.Color(204, 255, 255));
        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ssnTextField.setBackground(new java.awt.Color(204, 255, 255));
        ssnTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        emergName.setBackground(new java.awt.Color(204, 255, 255));
        emergName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        emergPhone.setBackground(new java.awt.Color(204, 255, 255));
        emergPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(165, 165, 165)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(workPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobilePhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(homePhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(ssnTextField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emergPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emergName, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(ssnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(emergName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(emergPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 45, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(53, 53, 53)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(homePhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(workPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(mobilePhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );

        jTabbedPane1.addTab("General", jPanel2);

        jPanel3.setBackground(new java.awt.Color(253, 252, 233));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 33, 35));
        jLabel2.setText("Provider:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(32, 33, 35));
        jLabel17.setText("Contract #:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(32, 33, 35));
        jLabel18.setText("Group #:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(32, 33, 35));
        jLabel19.setText("Effective Date:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(32, 33, 35));
        jLabel20.setText("Co-pay:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(32, 33, 35));
        jLabel21.setText("Provider Phone #:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(32, 33, 35));
        jLabel22.setText("Provider Address:");

        providerTextField.setBackground(new java.awt.Color(204, 255, 255));
        providerTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        contractTextField.setBackground(new java.awt.Color(204, 255, 255));
        contractTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        groupTextField.setBackground(new java.awt.Color(204, 255, 255));
        groupTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        effectiveTextField.setBackground(new java.awt.Color(204, 255, 255));
        effectiveTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        copayTextField.setBackground(new java.awt.Color(204, 255, 255));
        copayTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        providerPhoneTextField.setBackground(new java.awt.Color(204, 255, 255));
        providerPhoneTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        providerAddrTextField.setBackground(new java.awt.Color(204, 255, 255));
        providerAddrTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(providerTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                    .addComponent(contractTextField)
                    .addComponent(groupTextField)
                    .addComponent(effectiveTextField)
                    .addComponent(copayTextField)
                    .addComponent(providerPhoneTextField)
                    .addComponent(providerAddrTextField))
                .addContainerGap(899, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(providerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contractTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(effectiveTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(copayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(providerPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(providerAddrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel19))
                .addGap(190, 190, 190))
        );

        jTabbedPane1.addTab("Insurance", jPanel3);

        jPanel4.setBackground(new java.awt.Color(253, 252, 233));

        appointmentDisplayTable.setAutoCreateRowSorter(true);
        appointmentDisplayTable.setBackground(new java.awt.Color(204, 255, 255));
        appointmentDisplayTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        appointmentDisplayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Reason for Visit", "Doctor", "ApptID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        appointmentDisplayTable.setSelectionBackground(new java.awt.Color(255, 255, 204));
        appointmentDisplayTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(appointmentDisplayTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1692, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Appointments", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("pInfo");
    }// </editor-fold>//GEN-END:initComponents

    private void ageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageTextFieldActionPerformed

    private void homePhoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homePhoneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homePhoneTextFieldActionPerformed

	public void rightClickMenuViewAppt(java.awt.event.ActionEvent evt)
	{
        try
        {
		mainDash.appointmentForm.panelToReturnTo = 1;	// Return to PatientInfoSummary after done in PatientForm.
        Integer selectedRow = appointmentDisplayTable.getSelectedRow();
		Integer apptID = (Integer)appointmentDisplayTable.getValueAt(selectedRow, APPT_ID_COLUMN);
		Appointment theAppointment = dataBase.getAppointmentByID(apptID);
		mainDash.appointmentForm.loadAppointment(theAppointment);
		mainDash.showAppointmentForm();
        }
            
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Select an appointment to continue.");
        }
	}
	
	public void rightClickMenuViewExam(java.awt.event.ActionEvent evt)
	{
        try 
        {
			mainDash.occularExResults.panelToReturnTo = 1;
            Integer selectedRow = appointmentDisplayTable.getSelectedRow();
			Integer apptID = (Integer)appointmentDisplayTable.getValueAt(selectedRow, APPT_ID_COLUMN);
			Appointment theAppointment = dataBase.getAppointmentByID(apptID);
			mainDash.setActiveAppointment(theAppointment);
		
			Integer patientID = theAppointment.getPatientID();
			Patient thePatient = dataBase.getPatientByID(patientID);
			mainDash.setActivePatient(thePatient);
	
			mainDash.showVisualAcuity();
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Select an appointment to continue.");
        }
 
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTextField;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JTable appointmentDisplayTable;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField mobilePhoneTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel patientNameLeftBarTextBox;
    private javax.swing.JTextField providerAddrTextField;
    private javax.swing.JTextField providerPhoneTextField;
    private javax.swing.JTextField providerTextField;
    private javax.swing.JTextField ssnTextField;
    private javax.swing.JTextField titleTextField;
    private javax.swing.JTextField workPhoneTextField;
    // End of variables declaration//GEN-END:variables
}
