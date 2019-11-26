/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author kenda
 */
public class PatientPortal extends javax.swing.JPanel {
	final Integer PATIENT_ID_COLUMN = 3;
	private MainDashboard mainDash = null;
	private ArrayList<Patient> patientList = null;
	private DataBaseManager dataBase = DataBaseManager.getInstance();
	private DefaultTableModel tableModel = null;
    /**
     * Creates new form PatientPortal
     */
    public PatientPortal(MainDashboard _mainFrame) {
		mainDash = _mainFrame;
        initComponents();		
		tableModel = (DefaultTableModel) patientPortalTable.getModel();
		addTableRowRightClickListener();
		loadTableAllEntries();
    }
	
	public void loadTableAllEntries()
	{
		String patientName = null;
		String patientAddr = null;
		String patientDoB = null;
		Integer patientID = null;
		
		patientList = dataBase.getAllPatients();
		tableModel.setRowCount(0);		// Clear all rows, in anticipation of update.
		
		for (Patient currentPatient: patientList)
		{
			patientName = currentPatient.getName();
			patientAddr = currentPatient.getAddress();
			patientDoB = formatDate(currentPatient.getDateOfBirth().toString());
			patientID = currentPatient.getPatientID();
			
			tableModel.addRow(new Object[] {patientName, patientAddr, patientDoB, patientID});
		}
		
	}
	
	public void loadTableFromList(ArrayList<Patient> theList)
	{
		String patientName = null;
		String patientAddr = null;
		String patientDoB = null;
		Integer patientID = null;
		
		patientList = theList;
		tableModel.setRowCount(0);		// Clear all rows, in anticipation of update.
		
		for (Patient currentPatient: patientList)
		{
			patientName = currentPatient.getName();
			patientAddr = currentPatient.getAddress();
			patientDoB = formatDate(currentPatient.getDateOfBirth().toString());
			patientID = currentPatient.getPatientID();
			
			tableModel.addRow(new Object[] {patientName, patientAddr, patientDoB, patientID});
		}
		
	}
	
	private void addTableRowRightClickListener()
	{
	patientPortalTable.addMouseListener(new MouseAdapter() {
    public void mouseReleased(MouseEvent e) {
        int r = patientPortalTable.rowAtPoint(e.getPoint());
        if (r >= 0 && r < patientPortalTable.getRowCount()) {
            patientPortalTable.setRowSelectionInterval(r, r);
        } else {
            patientPortalTable.clearSelection();
        }

        int rowindex = patientPortalTable.getSelectedRow();
        if (rowindex < 0)
            return;
        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
            JPopupMenu popup = createTableRowRightClickMenu();
            popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }

		
	});
	}
	
	private JPopupMenu createTableRowRightClickMenu() {
		JPopupMenu theMenu = new JPopupMenu();
		
		JMenuItem makeActivePatient = new JMenuItem("Set as active patient");
		JMenuItem viewPatientInfo = new JMenuItem("View info");
		JMenuItem addNewPatient = new JMenuItem("Add new patient");
		JMenuItem editPatient = new JMenuItem("Edit patient");
		JMenuItem deletePatient = new JMenuItem("Delete patient");
		
		theMenu.add(makeActivePatient);
		theMenu.add(viewPatientInfo);
		theMenu.add(addNewPatient);
		theMenu.add(editPatient);
		theMenu.addSeparator();
		theMenu.add(deletePatient);
		
		
		
		makeActivePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickMenuMakeActivePatient(evt);
            }
		});
		
		viewPatientInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickMenuViewPatient(evt);
            }
		});
		
		addNewPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickMenuAddNewPatient(evt);
            }
		});
		
		editPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickMenuEditPatient(evt);
            }
		});
		
		deletePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightClickMenuDeletePatient(evt);
            }
		});
		
		
		
		return theMenu;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableRowRightClickMenu = new javax.swing.JPopupMenu();
        makeCurrentPatientMenuItem = new javax.swing.JMenuItem();
        viewPatientInfoMenuItem = new javax.swing.JMenuItem();
        tableRightClickMenu = new javax.swing.JPopupMenu();
        addPatientMenuItem = new javax.swing.JMenuItem();
        patientSearchBar = new javax.swing.JTextField();
        patientSearchSubmitButton = new javax.swing.JButton();
        deletePatientButton = new javax.swing.JButton();
        editPatientButton = new javax.swing.JButton();
        addPatientButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        patientPortalTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        selectPatientButton = new javax.swing.JButton();

        tableRowRightClickMenu.setName("patientOptions"); // NOI18N

        makeCurrentPatientMenuItem.setText("Make Current Patient");
        makeCurrentPatientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeCurrentPatientMenuItemActionPerformed(evt);
            }
        });
        tableRowRightClickMenu.add(makeCurrentPatientMenuItem);
        makeCurrentPatientMenuItem.getAccessibleContext().setAccessibleParent(tableRowRightClickMenu);

        viewPatientInfoMenuItem.setText("View Patient Page");
        viewPatientInfoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPatientInfoMenuItemActionPerformed(evt);
            }
        });
        tableRowRightClickMenu.add(viewPatientInfoMenuItem);

        addPatientMenuItem.setText("Add new patient");
        addPatientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPatientMenuItemActionPerformed(evt);
            }
        });
        tableRightClickMenu.add(addPatientMenuItem);

        setBackground(new java.awt.Color(57, 113, 177));
        setMaximumSize(new java.awt.Dimension(1200, 700));
        setPreferredSize(new java.awt.Dimension(1800, 700));

        patientSearchBar.setBackground(new java.awt.Color(204, 255, 255));
        patientSearchBar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        patientSearchBar.setToolTipText("Search Patient by Name");
        patientSearchBar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        patientSearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                patientSearchBarKeyPressed(evt);
            }
        });

        patientSearchSubmitButton.setBackground(new java.awt.Color(102, 153, 255));
        patientSearchSubmitButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        patientSearchSubmitButton.setForeground(new java.awt.Color(253, 252, 233));
        patientSearchSubmitButton.setText("SEARCH");
        patientSearchSubmitButton.setToolTipText("Searching Patient");
        patientSearchSubmitButton.setPreferredSize(new java.awt.Dimension(176, 33));
        patientSearchSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientSearchSubmitButtonActionPerformed(evt);
            }
        });

        deletePatientButton.setBackground(new java.awt.Color(255, 0, 51));
        deletePatientButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deletePatientButton.setForeground(new java.awt.Color(253, 252, 233));
        deletePatientButton.setText("DELETE");
        deletePatientButton.setToolTipText("Delete Patient");
        deletePatientButton.setPreferredSize(new java.awt.Dimension(176, 33));
        deletePatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePatientButtonActionPerformed(evt);
            }
        });
        deletePatientButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deletePatientButtonKeyPressed(evt);
            }
        });

        editPatientButton.setBackground(new java.awt.Color(102, 153, 255));
        editPatientButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editPatientButton.setForeground(new java.awt.Color(253, 252, 233));
        editPatientButton.setText("EDIT");
        editPatientButton.setToolTipText("Edit Patient Info");
        editPatientButton.setPreferredSize(new java.awt.Dimension(176, 33));
        editPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPatientButtonActionPerformed(evt);
            }
        });

        addPatientButton.setBackground(new java.awt.Color(102, 153, 255));
        addPatientButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addPatientButton.setForeground(new java.awt.Color(253, 252, 233));
        addPatientButton.setText("ADD PATIENT");
        addPatientButton.setToolTipText("Add Patient to Portal");
        addPatientButton.setPreferredSize(new java.awt.Dimension(176, 33));
        addPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPatientButtonActionPerformed(evt);
            }
        });

        jScrollPane2.setComponentPopupMenu(tableRightClickMenu);

        patientPortalTable.setAutoCreateRowSorter(true);
        patientPortalTable.setBackground(new java.awt.Color(253, 252, 233));
        patientPortalTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(32, 33, 35)));
        patientPortalTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        patientPortalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Address", "DoB (MM/DD/YYYY)", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientPortalTable.setSelectionBackground(new java.awt.Color(153, 255, 255));
        patientPortalTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        patientPortalTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientPortalTableMouseClicked(evt);
            }
        });
        patientPortalTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                patientPortalTableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(patientPortalTable);
        if (patientPortalTable.getColumnModel().getColumnCount() > 0) {
            patientPortalTable.getColumnModel().getColumn(3).setMinWidth(50);
            patientPortalTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            patientPortalTable.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jPanel1.setBackground(new java.awt.Color(32, 33, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(1900, 66));
        jPanel1.setRequestFocusEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Patient Portal");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setPreferredSize(new java.awt.Dimension(1900, 44));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        selectPatientButton.setBackground(new java.awt.Color(102, 153, 255));
        selectPatientButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        selectPatientButton.setForeground(new java.awt.Color(253, 252, 233));
        selectPatientButton.setText("SET AS ACTIVE PATIENT");
        selectPatientButton.setToolTipText("Make an Active Patient");
        selectPatientButton.setPreferredSize(new java.awt.Dimension(176, 33));
        selectPatientButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectPatientButtonMouseClicked(evt);
            }
        });
        selectPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectPatientButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1800, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(patientSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patientSearchSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1654, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1114, 1114, 1114)
                        .addComponent(deletePatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientSearchBar)
                    .addComponent(patientSearchSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(deletePatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        getAccessibleContext().setAccessibleName("patientPortalPanel");
        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    private void patientSearchSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientSearchSubmitButtonActionPerformed
        System.out.println("Patient Portal: Search button");
		String patientName = patientSearchBar.getText();
		ArrayList<Patient> patientList = dataBase.searchForPatientName(patientName);
		loadTableFromList(patientList);
    }//GEN-LAST:event_patientSearchSubmitButtonActionPerformed

    private void editPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPatientButtonActionPerformed
        try
        {
             System.out.println("Patient Portal: Edit button");
		Integer selectedRow = patientPortalTable.getSelectedRow();
		Integer patientID = (Integer)patientPortalTable.getValueAt(selectedRow, PATIENT_ID_COLUMN);
		Patient thePatient = dataBase.getPatientByID(patientID);
		mainDash.patientForm.loadPatientInfo(thePatient);
		mainDash.showPatientForm();
        }
        
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(null, "A patient must be selected!");
        }

      
    }//GEN-LAST:event_editPatientButtonActionPerformed

    private void deletePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePatientButtonActionPerformed

            if (evt != null)
			System.out.println("Patient Portal: Delete button");
		else
			System.out.println("Patient Portal: Delete key");
		
		Integer selectedCol = patientPortalTable.getSelectedColumn();
		Integer selectedRow = patientPortalTable.getSelectedRow();
		if ((selectedRow >= 0) && (selectedCol >=0))
		{
			Integer patientID = (Integer)patientPortalTable.getValueAt(selectedRow, PATIENT_ID_COLUMN);

			tableModel.removeRow(selectedRow);

			Patient theVictim = dataBase.getPatientByID(patientID);
			dataBase.delete(theVictim);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "A patient must be selected!");
		}

    }//GEN-LAST:event_deletePatientButtonActionPerformed

    private void deletePatientButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deletePatientButtonKeyPressed
        
    }//GEN-LAST:event_deletePatientButtonKeyPressed

    private void patientPortalTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patientPortalTableKeyPressed
        //System.out.println("Patient Portal: Delete key");
		if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_DELETE)
		{
			deletePatientButtonActionPerformed(null);
		}
    }//GEN-LAST:event_patientPortalTableKeyPressed

    private void addPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPatientButtonActionPerformed
        System.out.println("Patient Portal: Add button");
		mainDash.setActivePatient(null);
		mainDash.patientForm.loadPatientInfo(null);
		mainDash.showPatientForm();
    }//GEN-LAST:event_addPatientButtonActionPerformed

    private void patientSearchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patientSearchBarKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER)
		{
			patientSearchSubmitButtonActionPerformed(null);
		}
    }//GEN-LAST:event_patientSearchBarKeyPressed

    private void viewPatientInfoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPatientInfoMenuItemActionPerformed
        System.out.println("Patient Portal: pop-up menu view patient page");
            mainDash.showPatientPage();
    }//GEN-LAST:event_viewPatientInfoMenuItemActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void selectPatientButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectPatientButtonMouseClicked
        
        try 
        {
                System.out.println("Patient Portal: Make active patient button");
		Integer selectedRow = patientPortalTable.getSelectedRow();
		Integer patientID = (Integer)patientPortalTable.getValueAt(selectedRow, PATIENT_ID_COLUMN);
		Patient activePatient = dataBase.getPatientByID(patientID);
		mainDash.setActivePatient(activePatient);
		//mainDash.currentPatientTextBar.setText(activePatient.getName());
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "A patient must be selected!");
        }
        
        
    }//GEN-LAST:event_selectPatientButtonMouseClicked

    private void makeCurrentPatientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeCurrentPatientMenuItemActionPerformed
        //System.out.println("bloop");
    }//GEN-LAST:event_makeCurrentPatientMenuItemActionPerformed

    private void patientPortalTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientPortalTableMouseClicked
		/*
		if(SwingUtilities.isRightMouseButton(evt) == true)
		{
			int row = patientPortalTable.rowAtPoint(evt.getPoint());
			patientPortalTable.clearSelection();
			patientPortalTable.addRowSelectionInterval(row,row);
			Point evtPoint = evt.getLocationOnScreen();
			int x = evtPoint.x;
			int y = evtPoint.y;
			rightClickMenu.setLocation(x,y);
			
			if (rightClickMenu.isVisible())
				rightClickMenu.setVisible(false);
			else
				rightClickMenu.setVisible(true);
		}*/
    }//GEN-LAST:event_patientPortalTableMouseClicked

    private void selectPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectPatientButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectPatientButtonActionPerformed

    private void addPatientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPatientMenuItemActionPerformed
        addPatientButtonActionPerformed(null);
    }//GEN-LAST:event_addPatientMenuItemActionPerformed
	
	private void rightClickMenuMakeActivePatient(java.awt.event.ActionEvent evt)
	{
		Integer selectedRow = patientPortalTable.getSelectedRow();
		Integer patientID = (Integer)patientPortalTable.getValueAt(selectedRow, PATIENT_ID_COLUMN);
		Patient activePatient = dataBase.getPatientByID(patientID);
		mainDash.setActivePatient(activePatient);
	}
	
	private void rightClickMenuAddNewPatient(java.awt.event.ActionEvent evt)
	{
		addPatientButtonActionPerformed(evt);
	}
	
	private void rightClickMenuEditPatient(java.awt.event.ActionEvent evt)
	{
		selectPatientButtonMouseClicked(null);
		editPatientButtonActionPerformed(evt);
	}
	
	private void rightClickMenuDeletePatient(java.awt.event.ActionEvent evt)
	{
		selectPatientButtonMouseClicked(null);
		deletePatientButtonActionPerformed(evt);
	}
	
	private void rightClickMenuViewPatient(java.awt.event.ActionEvent evt)
	{
		selectPatientButtonMouseClicked(null);
		viewPatientInfoMenuItemActionPerformed(evt);
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPatientButton;
    private javax.swing.JMenuItem addPatientMenuItem;
    private javax.swing.JButton deletePatientButton;
    private javax.swing.JButton editPatientButton;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem makeCurrentPatientMenuItem;
    private javax.swing.JTable patientPortalTable;
    private javax.swing.JTextField patientSearchBar;
    private javax.swing.JButton patientSearchSubmitButton;
    private javax.swing.JButton selectPatientButton;
    private javax.swing.JPopupMenu tableRightClickMenu;
    private javax.swing.JPopupMenu tableRowRightClickMenu;
    private javax.swing.JMenuItem viewPatientInfoMenuItem;
    // End of variables declaration//GEN-END:variables
}
