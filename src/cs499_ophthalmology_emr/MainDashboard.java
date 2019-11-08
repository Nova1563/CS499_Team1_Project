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
    
    public PatientPortal pPanel;
    public JPanel mainWindow;		// TODO: Remove this.
	public AppointmentDisplay appointmentPanel;
	public InsurancePage insurancePanel;
    /**
     * Creates new form MainWindow
     */
    public MainDashboard() {
        initComponents();
		//mainWindow = new JPanel();	// This JPanel doesn't exist anywhere. Use mainPanel to display cards and stuff
                pPanel = new PatientPortal();
		appointmentPanel = new AppointmentDisplay();
		insurancePanel = new InsurancePage();
		
        mainPanel.add(pPanel);
		mainPanel.add(appointmentPanel);
		mainPanel.add(insurancePanel);
                mainPanel.setVisible(true);
                
      
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
        helpBttb = new javax.swing.JLabel();
        sideMenu = new javax.swing.JPanel();
        patientPortalBttn = new javax.swing.JLabel();
        insuranceBttn = new javax.swing.JLabel();
        appointmentBttn = new javax.swing.JLabel();
        sideMenuDivider = new javax.swing.JPanel();
        sideMenuDivider1 = new javax.swing.JPanel();
        sideMenuDivider2 = new javax.swing.JPanel();
        patientPortalTxt = new javax.swing.JLabel();
        appointmentsTxt = new javax.swing.JLabel();
        insuranceTxt = new javax.swing.JLabel();
        copyRightsTxt = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        emrLogo = new javax.swing.JLabel();
        weclcomeTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 1024));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1280, 730));

        toolBarJPanel.setBackground(new java.awt.Color(0, 0, 0));
        toolBarJPanel.setForeground(new java.awt.Color(0, 0, 0));

        homeBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/homeIcon.png"))); // NOI18N
        homeBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBttnMouseClicked(evt);
            }
        });

        helpBttb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/helpIcon.png"))); // NOI18N

        javax.swing.GroupLayout toolBarJPanelLayout = new javax.swing.GroupLayout(toolBarJPanel);
        toolBarJPanel.setLayout(toolBarJPanelLayout);
        toolBarJPanelLayout.setHorizontalGroup(
            toolBarJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeBttn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 845, Short.MAX_VALUE)
                .addComponent(helpBttb)
                .addGap(15, 15, 15))
        );
        toolBarJPanelLayout.setVerticalGroup(
            toolBarJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolBarJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toolBarJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, toolBarJPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(helpBttb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(homeBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        sideMenu.setBackground(new java.awt.Color(184, 134, 11));
        sideMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 3, new java.awt.Color(0, 0, 0)));
        sideMenu.setLayout(null);

        patientPortalBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/patientIcon_1.png"))); // NOI18N
        patientPortalBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientPortalBttnMouseClicked(evt);
            }
        });
        sideMenu.add(patientPortalBttn);
        patientPortalBttn.setBounds(30, 110, 59, 80);

        insuranceBttn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        insuranceBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/insuranceIcon_1.png"))); // NOI18N
        insuranceBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insuranceBttnMouseClicked(evt);
            }
        });
        sideMenu.add(insuranceBttn);
        insuranceBttn.setBounds(30, 480, 61, 80);

        appointmentBttn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointmentBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/appointmentIcon1_1.png"))); // NOI18N
        appointmentBttn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentBttnMouseClicked(evt);
            }
        });
        sideMenu.add(appointmentBttn);
        appointmentBttn.setBounds(20, 290, 80, 80);

        sideMenuDivider.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout sideMenuDividerLayout = new javax.swing.GroupLayout(sideMenuDivider);
        sideMenuDivider.setLayout(sideMenuDividerLayout);
        sideMenuDividerLayout.setHorizontalGroup(
            sideMenuDividerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        sideMenuDividerLayout.setVerticalGroup(
            sideMenuDividerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        sideMenu.add(sideMenuDivider);
        sideMenuDivider.setBounds(0, 620, 120, 10);

        sideMenuDivider1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout sideMenuDivider1Layout = new javax.swing.GroupLayout(sideMenuDivider1);
        sideMenuDivider1.setLayout(sideMenuDivider1Layout);
        sideMenuDivider1Layout.setHorizontalGroup(
            sideMenuDivider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        sideMenuDivider1Layout.setVerticalGroup(
            sideMenuDivider1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        sideMenu.add(sideMenuDivider1);
        sideMenuDivider1.setBounds(0, 440, 120, 10);

        sideMenuDivider2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout sideMenuDivider2Layout = new javax.swing.GroupLayout(sideMenuDivider2);
        sideMenuDivider2.setLayout(sideMenuDivider2Layout);
        sideMenuDivider2Layout.setHorizontalGroup(
            sideMenuDivider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        sideMenuDivider2Layout.setVerticalGroup(
            sideMenuDivider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        sideMenu.add(sideMenuDivider2);
        sideMenuDivider2.setBounds(0, 250, 120, 10);

        patientPortalTxt.setFont(new java.awt.Font("DecoType Naskh", 1, 15)); // NOI18N
        patientPortalTxt.setForeground(new java.awt.Color(0, 0, 0));
        patientPortalTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientPortalTxt.setText("Patient Portal");
        patientPortalTxt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sideMenu.add(patientPortalTxt);
        patientPortalTxt.setBounds(-6, 204, 130, 20);

        appointmentsTxt.setFont(new java.awt.Font("DecoType Naskh", 1, 15)); // NOI18N
        appointmentsTxt.setForeground(new java.awt.Color(0, 0, 0));
        appointmentsTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointmentsTxt.setText(" Appointments");
        sideMenu.add(appointmentsTxt);
        appointmentsTxt.setBounds(0, 380, 120, 20);
        appointmentsTxt.getAccessibleContext().setAccessibleName("dadLabel");

        insuranceTxt.setFont(new java.awt.Font("DecoType Naskh", 1, 15)); // NOI18N
        insuranceTxt.setForeground(new java.awt.Color(0, 0, 0));
        insuranceTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        insuranceTxt.setText("Insurance");
        sideMenu.add(insuranceTxt);
        insuranceTxt.setBounds(0, 570, 120, 20);
        insuranceTxt.getAccessibleContext().setAccessibleName("InsuranceLabel");

        copyRightsTxt.setFont(new java.awt.Font("DecoType Naskh", 2, 13)); // NOI18N
        copyRightsTxt.setForeground(new java.awt.Color(0, 0, 0));
        copyRightsTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyRightsTxt.setText("CopyRights");
        sideMenu.add(copyRightsTxt);
        copyRightsTxt.setBounds(20, 670, 80, 16);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setMaximumSize(new java.awt.Dimension(1000, 1000));
        mainPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                mainPanelComponentShown(evt);
            }
        });
        mainPanel.setLayout(new java.awt.CardLayout());

        emrLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cs499_ophthalmology_emr/images/eyelogo.png"))); // NOI18N
        mainPanel.add(emrLogo, "card2");

        weclcomeTxt.setFont(new java.awt.Font("DecoType Naskh", 3, 48)); // NOI18N
        weclcomeTxt.setForeground(new java.awt.Color(0, 0, 0));
        weclcomeTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weclcomeTxt.setText("Welcome");
        mainPanel.add(weclcomeTxt, "card3");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBarJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(sideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(toolBarJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(sideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );

        mainPanel.getAccessibleContext().setAccessibleName("mainPanel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_mainPanelComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_mainPanelComponentShown

    private void patientPortalBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientPortalBttnMouseClicked
        // TODO add your handling code here:
        
        System.out.print("Patient Portal Bttn Clicked: " + evt.getClickCount());
        
        hideAllPanelComponents(mainPanel);
        pPanel.setVisible(true);
    }//GEN-LAST:event_patientPortalBttnMouseClicked

    private void appointmentBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentBttnMouseClicked
        // TODO add your handling code here:
        System.out.print("Appointment Bttn Clicked: " + evt.getClickCount());
        hideAllPanelComponents(mainPanel);
        appointmentPanel.setVisible(true);
    }//GEN-LAST:event_appointmentBttnMouseClicked

    private void insuranceBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insuranceBttnMouseClicked
        // TODO add your handling code here:
        
        System.out.print("Insurance Bttn Clicked: " + evt.getClickCount());
        hideAllPanelComponents(mainPanel);
	insurancePanel.setVisible(true);
    }//GEN-LAST:event_insuranceBttnMouseClicked

    private void homeBttnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBttnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_homeBttnMouseClicked

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
    private javax.swing.JLabel appointmentBttn;
    private javax.swing.JLabel appointmentsTxt;
    private javax.swing.JPanel background;
    private javax.swing.JLabel copyRightsTxt;
    private javax.swing.JLabel emrLogo;
    private javax.swing.JLabel helpBttb;
    private javax.swing.JLabel homeBttn;
    private javax.swing.JLabel insuranceBttn;
    private javax.swing.JLabel insuranceTxt;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel patientPortalBttn;
    private javax.swing.JLabel patientPortalTxt;
    private javax.swing.JPanel sideMenu;
    private javax.swing.JPanel sideMenuDivider;
    private javax.swing.JPanel sideMenuDivider1;
    private javax.swing.JPanel sideMenuDivider2;
    private javax.swing.JPanel toolBarJPanel;
    private javax.swing.JLabel weclcomeTxt;
    // End of variables declaration//GEN-END:variables
}
