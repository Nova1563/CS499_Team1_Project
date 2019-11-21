/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author angelaallison
 */
public class MainDashboard extends javax.swing.JFrame {
    

    public PatientPortal patientPortal;
    public AppointmentDisplay appointmentPanel;
    public AppointmentForm appointmentForm;
    public InsurancePage insurancePanel;
    public HomePanel homePanel;
    public PatientPageTemplate viewPatientPage;
    public VisualAcuity visualAcuity;
    public OccularExResults occularExResults;
    public PatientForm patientForm;
    private Patient activePatient;
    private Appointment activeAppointment;
    
    /**
     * Creates new form MainWindow
     */
    public MainDashboard() {
    initComponents();


    patientPortal       = new PatientPortal(this);
    appointmentPanel    = new AppointmentDisplay(this);
    insurancePanel      = new InsurancePage();
    homePanel           = new HomePanel();
    viewPatientPage     = new PatientPageTemplate();
    patientForm		= new PatientForm(this);
    insurancePanel      = new InsurancePage();
    appointmentForm     = new AppointmentForm(this);
    visualAcuity        = new VisualAcuity(this);//***
    occularExResults    = new OccularExResults();
        
    mainPanel.add(homePanel);	
    mainPanel.add(patientPortal);
    mainPanel.add(patientForm);
    mainPanel.add(appointmentPanel);
    mainPanel.add(insurancePanel);
    mainPanel.add(viewPatientPage);
    mainPanel.add(appointmentForm);
    mainPanel.add(visualAcuity);
    mainPanel.add(occularExResults);
    
    

                
    }
	
	public void setActivePatient(Patient thePatient)
	{
		activePatient = thePatient;
		currentPatientTextBar.setText(activePatient.getName());
	}
	
	public Patient getActivePatient()
	{
		return activePatient;
	}
	
	public void setActiveAppointment(Appointment incomingAppt)
	{
		activeAppointment = incomingAppt;
	}
	
	public Appointment getActiveAppointment()
	{
		return activeAppointment;
	}
	
	public void showPatientPortal()
	{
            
            hideAllPanelComponents(mainPanel);
            patientPortal.loadTableAllEntries();
            patientPortal.setVisible(true);
	}
	
	public void showPatientForm()
	{

        hideAllPanelComponents(mainPanel);
        patientForm.setVisible(true);
	}
        
	public void showAppointmentForm()
	{

		hideAllPanelComponents(mainPanel);
		appointmentForm.setVisible(true);
	}       

	/*
	public void showAppointmentForm()
	{
		hideAllPanelComponents(mainPanel);
		newAppointmentForm.setVisable(true);

	}
	*/

	public void showPatientPage()
	{
		hideAllPanelComponents(mainPanel);
		viewPatientPage.setVisible(true);

	}
	
	public void showAppointmentDisplay()
	{
            hideAllPanelComponents(mainPanel);	
            appointmentPanel.loadTableAllEntries();
            appointmentPanel.setVisible(true);

	}
	
	public void showInsurancePage()
	{
                hideAllPanelComponents(mainPanel);
                insurancePanel.setVisible(true);
	}
        public void showVisualAcuity()
	{
                hideAllPanelComponents(mainPanel);
                visualAcuity.setVisible(true);
	}
        public void showOccularExResults()
	{
                hideAllPanelComponents(mainPanel);
                occularExResults.setVisible(true);
	}
        public void showHomePanel()
	{
                hideAllPanelComponents(mainPanel);
                homePanel.setVisible(true);
                
	}
        public void showViewFutureAppointments()
	{ 
                hideAllPanelComponents(mainPanel);
            
	}
	public void hideAllPanelComponents(JPanel theComp)
	{
		for(Component itsComp : theComp.getComponents())
		{
			itsComp.setVisible(false);
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

        background = new javax.swing.JPanel();
        toolBarJPanel = new javax.swing.JPanel();
        homeBttn = new javax.swing.JLabel();
        infoBttb = new javax.swing.JLabel();
        appointmentBttn = new javax.swing.JLabel();
        patientPortalBttn = new javax.swing.JLabel();
        insuranceBttn = new javax.swing.JLabel();
        eyeTestBttn = new javax.swing.JLabel();
        helpBttn = new javax.swing.JLabel();
        emrToolsTxt = new javax.swing.JLabel();
        helpToolsTxt = new javax.swing.JLabel();
        homeTxt = new javax.swing.JLabel();
        emrToolsTxt1 = new javax.swing.JLabel();
        CurrentPatientLabel = new javax.swing.JLabel();
        currentPatientTextBar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(getPreferredSize());

        background.setBackground(new java.awt.Color(57, 113, 177));
        background.setPreferredSize(new java.awt.Dimension(1800, 900));

        toolBarJPanel.setBackground(new java.awt.Color(53, 60, 81));
        toolBarJPanel.setAutoscrolls(true);
        toolBarJPanel.setMaximumSize(new java.awt.Dimension(2147483647, 100));
        toolBarJPanel.setMinimumSize(new java.awt.Dimension(1190, 100));
        toolBarJPanel.setPreferredSize(new java.awt.Dimension(1620, 90));
        toolBarJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/homeIcon.png"))); // NOI18N
        homeBttn.setDisabledIcon(null);
        homeBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBttnMouseClicked(evt);
            }
        });
        toolBarJPanel.add(homeBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, -1));

        infoBttb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/infoIcon2.png"))); // NOI18N
        toolBarJPanel.add(infoBttb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, -1, 50));

        appointmentBttn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointmentBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/appointmentIcon.png"))); // NOI18N
        appointmentBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentBttnMouseClicked(evt);
            }
        });
        toolBarJPanel.add(appointmentBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, 70));

        patientPortalBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/patientIcon.png"))); // NOI18N
        patientPortalBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientPortalBttnMouseClicked(evt);
            }
        });
        toolBarJPanel.add(patientPortalBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, 70));

        insuranceBttn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        insuranceBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/insuranceIcon.png"))); // NOI18N
        insuranceBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insuranceBttnMouseClicked(evt);
            }
        });
        toolBarJPanel.add(insuranceBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, -1, 70));

        eyeTestBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/eyeTestIcon.png"))); // NOI18N
        eyeTestBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eyeTestBttnMouseClicked(evt);
            }
        });
        toolBarJPanel.add(eyeTestBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, -1, 70));

        helpBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/infoIcon.png"))); // NOI18N
        toolBarJPanel.add(helpBttn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 50, 70));

        emrToolsTxt.setBackground(new java.awt.Color(255, 255, 255));
        emrToolsTxt.setFont(new java.awt.Font("Corsiva Hebrew", 2, 14)); // NOI18N
        emrToolsTxt.setForeground(new java.awt.Color(255, 255, 255));
        emrToolsTxt.setText("EMR Tools");
        toolBarJPanel.add(emrToolsTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, 20));

        helpToolsTxt.setBackground(new java.awt.Color(255, 255, 255));
        helpToolsTxt.setFont(new java.awt.Font("Corsiva Hebrew", 2, 14)); // NOI18N
        helpToolsTxt.setForeground(new java.awt.Color(255, 255, 255));
        helpToolsTxt.setText("Help Tools");
        toolBarJPanel.add(helpToolsTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 70, -1, 20));

        homeTxt.setBackground(new java.awt.Color(255, 255, 255));
        homeTxt.setFont(new java.awt.Font("Corsiva Hebrew", 2, 14)); // NOI18N
        homeTxt.setForeground(new java.awt.Color(255, 255, 255));
        homeTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeTxt.setText("Home");
        toolBarJPanel.add(homeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 50, 20));

        emrToolsTxt1.setBackground(new java.awt.Color(255, 255, 255));
        emrToolsTxt1.setFont(new java.awt.Font("Corsiva Hebrew", 2, 14)); // NOI18N
        emrToolsTxt1.setText("EMR Tools");
        toolBarJPanel.add(emrToolsTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, 20));

        CurrentPatientLabel.setFont(helpToolsTxt.getFont());
        CurrentPatientLabel.setForeground(new java.awt.Color(255, 255, 255));
        CurrentPatientLabel.setText("Current Patient");
        toolBarJPanel.add(CurrentPatientLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, -1, -1));

        currentPatientTextBar.setBackground(new java.awt.Color(255, 255, 255));
        currentPatientTextBar.setFont(helpToolsTxt.getFont());
        currentPatientTextBar.setOpaque(true);
        toolBarJPanel.add(currentPatientTextBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 40, 240, 20));
        toolBarJPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        mainPanel.setBackground(new java.awt.Color(57, 113, 177));
        mainPanel.setMaximumSize(new java.awt.Dimension(1000, 1000));
        mainPanel.setPreferredSize(new java.awt.Dimension(1700, 900));
        mainPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                mainPanelComponentShown(evt);
            }
        });
        mainPanel.setLayout(new java.awt.CardLayout());
        mainPanel.add(jDesktopPane1, "card2");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBarJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(toolBarJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.getAccessibleContext().setAccessibleName("mainPanel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_mainPanelComponentShown
        // TODO add your handling code here:
        showHomePanel();
    }//GEN-LAST:event_mainPanelComponentShown

    private void patientPortalBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientPortalBttnMouseClicked

        System.out.println("Patient Portal Bttn Clicked: " + evt.getClickCount());
        showPatientPortal();
    }//GEN-LAST:event_patientPortalBttnMouseClicked

    private void appointmentBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentBttnMouseClicked

        System.out.println("Appointment Bttn Clicked: " + evt.getClickCount());
	showAppointmentDisplay();
    }//GEN-LAST:event_appointmentBttnMouseClicked

    private void insuranceBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insuranceBttnMouseClicked
        
        System.out.print("Insurance Bttn Clicked: " + evt.getClickCount());
	showInsurancePage();       
    }//GEN-LAST:event_insuranceBttnMouseClicked

    private void homeBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBttnMouseClicked
        hideAllPanelComponents(mainPanel);	
        showHomePanel();
        
    }//GEN-LAST:event_homeBttnMouseClicked

    private void eyeTestBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eyeTestBttnMouseClicked
        // TODO add your handling code here:
        System.out.print("EyeTest Bttn Bttn Clicked: " + evt.getClickCount());
        showVisualAcuity();
    }//GEN-LAST:event_eyeTestBttnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDashboard().setVisible(true);
                
                
                //MainWindow.add(new PatientPortal);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CurrentPatientLabel;
    private javax.swing.JLabel appointmentBttn;
    private javax.swing.JPanel background;
    public javax.swing.JLabel currentPatientTextBar;
    private javax.swing.JLabel emrToolsTxt;
    private javax.swing.JLabel emrToolsTxt1;
    private javax.swing.JLabel eyeTestBttn;
    private javax.swing.JLabel helpBttn;
    private javax.swing.JLabel helpToolsTxt;
    private javax.swing.JLabel homeBttn;
    private javax.swing.JLabel homeTxt;
    private javax.swing.JLabel infoBttb;
    private javax.swing.JLabel insuranceBttn;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel patientPortalBttn;
    private javax.swing.JPanel toolBarJPanel;
    // End of variables declaration//GEN-END:variables
}
