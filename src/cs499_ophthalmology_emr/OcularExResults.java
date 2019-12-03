/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;

/**
 *
 * @author angela & andrew
 */
public class OcularExResults extends javax.swing.JPanel {
	public Integer panelToReturnTo = 0; // 0 = return view to AppointmentDisplay, 1 = return view to PatientInfoSummary when done here.
	MainDashboard mainDash;
	EyeTestResults currentResults;
	DataBaseManager dataBase;
    /**
     * Creates new form OccularExResults
     */
    public OcularExResults(MainDashboard _mainDash) {
		dataBase = DataBaseManager.getInstance();
		mainDash = _mainDash;
		initComponents();
		//dataBase.doTest();
		//EyeTestResults debugEyeResults = dataBase.getExamResultsByApptID(1);
		//currentResults = debugEyeResults;
		
        //loadOcularResults();
    }
	
	public void loadOcularResults()
	{
		currentResults = mainDash.getActiveResults();
		
		///////////////////// Posterior Segment Combo Boxes//////////////////////////
		// NOTE: a 1 suffix indicates OD fields here, while a 2 suffix indicates OS.
		vitreousComboBox1.setSelectedItem(currentResults.getVitreousOD());
		maculaComboBox1.setSelectedItem(currentResults.getMaculaOD());
		vasculatureComboBox1.setSelectedItem(currentResults.getVasculatureOD());
		posteriorPoleComboBox1.setSelectedItem(currentResults.getPosteriorPoleOD());
		peripheralRetinaComboBox1.setSelectedItem(currentResults.getPeripheralRetinaOD());
		miscRetinaComboBox1.setSelectedItem(currentResults.getMiscRetinaOD());
		diabeticEvalComboBox1.setSelectedItem(currentResults.getDiabeticEvalOD());
		htnEvaluationComboBox1.setSelectedItem(currentResults.getHtnEvalOD());
		armdComboBox1.setSelectedItem(currentResults.getArmdOD());
		custom1ComboBox1.setSelectedItem(currentResults.getCustom1OD());
		custom2ComboBox1.setSelectedItem(currentResults.getCustom2OD());
		custom3ComboBox1.setSelectedItem(currentResults.getCustom3OD());
		vitreousComboBox2.setSelectedItem(currentResults.getVitreousOS());
		maculaComboBox2.setSelectedItem(currentResults.getMaculaOS());
		vasculatureComboBox2.setSelectedItem(currentResults.getVasculatureOS());
		posteriorPoleComboBox2.setSelectedItem(currentResults.getPosteriorPoleOS());
		peripheralRetinaComboBox2.setSelectedItem(currentResults.getPeripheralRetinaOS());
		miscRetinaComboBox2.setSelectedItem(currentResults.getMiscRetinaOS());
		diabeticEvalComboBox2.setSelectedItem(currentResults.getDiabeticEvalOS());
		htnEvaluationComboBox2.setSelectedItem(currentResults.getHtnEvalOS());
		armdComboBox2.setSelectedItem(currentResults.getArmdOS());
		custom1ComboBox2.setSelectedItem(currentResults.getCustom1OS());
		custom2ComboBox2.setSelectedItem(currentResults.getCustom2OS());
		custom3ComboBox2.setSelectedItem(currentResults.getCustom3OS());
		///////////////////// OD Nerve Head Assessment Combo Boxes//////////////////////////
		odOpticNerveComboBox.setSelectedItem(currentResults.getOpticNerveOD());
		odNerveFiberLayerComboBox.setSelectedItem(currentResults.getNerveFiberLayerOD());
		///////////////////// OD Nerve Head Assessment Combo Boxes//////////////////////////
		osOpticNerveComboBox.setSelectedItem(currentResults.getOpticNerveOS());
		osNerveFiberLayerComboBox.setSelectedItem(currentResults.getNerveFiberLayerOS());
		
		///////////////////// Ophthalmic Indicators Radio Buttons //////////////////////////
		
		// OD Foveal Reflex
		odFovealReflexRadioButtonGroup.clearSelection();
		String odFovealReflexSelection = currentResults.getFovealReflexOD();
		if (odFovealReflexSelection != null)
		{
			switch (odFovealReflexSelection)
			{
				case "X":
					odFovealReflexXRadioButton1.setSelected(true);
					break;
				case "+":
					odFovealReflexPlusRadioButton1.setSelected(true);
					break;
				case "-":
					odFovealReflexMinusRadioButton1.setSelected(true);
					break;
				default:
					System.out.println("odFovealReflexSelection error: " + odFovealReflexSelection);
			}
		}
		// OS Foveal Reflex
		osFovealReflexRadioButtonGroup.clearSelection();
		
		String osFovealReflexSelection = currentResults.getFovealReflexOs();
		if (osFovealReflexSelection != null)
		{
		switch (osFovealReflexSelection)
			{
				case "X":
					osFovealReflexXRadioButton.setSelected(true);
					break;
				case "+":
					osFovealReflexPlusRadioButton.setSelected(true);
					break;
				case "-":
					osFovealReflexMinusRadioButton.setSelected(true);
					break;
				default:
					System.out.println("osFovealReflexSelection error: " + osFovealReflexSelection);
			}
		}
		// OD Spontaneous Veinous Pulsation
		odSpontaneousPulsationRadioButtonGroup.clearSelection();
		
		String odSponVeinPulsationSelection = currentResults.getSponVeinPulsOD();
		if (odSponVeinPulsationSelection != null)
		{
			switch (odSponVeinPulsationSelection)
			{
				case "X":
					odSpontaneousPulsationXRadioButton1.setSelected(true);
					break;
				case "+":
					odSpontaneousPulsationPlusRadioButton1.setSelected(true);
					break;
				case "-":
					odSpontaneousPulsationMinusRadioButton1.setSelected(true);
					break;
				default:
					System.out.println("odSponVeinPulsationSelection error: " + odSponVeinPulsationSelection);
			}
		}
		// OS Spontaneous Veinous Pulsation
		osSpontaneousPulsationRadioButtonGroup.clearSelection();
		
		String osSponVeinPulsationSelection = currentResults.getSponVeinPulsOS();
		if (osSponVeinPulsationSelection != null)
		{
			switch (osSponVeinPulsationSelection)
			{
				case "X":
					osSpontaneousPulsationXRadioButton.setSelected(true);
					break;
				case "+":
					osSpontaneousPulsationPlusRadioButton.setSelected(true);
					break;
				case "-":
					osSpontaneousPulsationMinusRadioButton.setSelected(true);
					break;
				default:
					System.out.println("osSponVeinPulsationSelection error: " + osSponVeinPulsationSelection);
			}
		}
		///////////////////// Fundus Options Radio Buttons //////////////////////////
		fundusOptionRadioButtonGroup.clearSelection();
		
		String fundusOptionSelection = currentResults.getMethodUsed();
		if (fundusOptionSelection != null)
		{
			switch (fundusOptionSelection)
			{
				case "Not Performed":
					fundusEvaluationNotPerformedRadioButton.setSelected(true);
					break;
				case "Undilated Eval":
					undilatedEvalRadioButton.setSelected(true);
					break;
				case "Small Pupil BIO":
					smallPupilBIORadioButton.setSelected(true);
					break;
				case "Optomap Imaging":
					optomapImagingRadioButton.setSelected(true);
					break;
				case "Dilated Eval":
					dilatedEvalRadioButton.setSelected(true);
					break;
				case "DFE with Optomap":
					dfeWithOptomapRadioButton.setSelected(true);
					break;
				default:
					System.out.println("fundusOptionSelection error: " + fundusOptionSelection);

			}
		}
		///////////////////// Dilation Radio Buttons and Combobox//////////////////////////
		
		dilationAgentComboBox.setSelectedItem(currentResults.getDilationAgent());
		fundusDilationRadioButtonGroup.clearSelection();
		
		if (currentResults.getGttOD().equals("1"))
			gtt1RadioButton.setSelected(true);
		else if (currentResults.getGttOD().equals("2"))
			gtt2RadioButton.setSelected(true);
		
		///////////////////// Fundus Evaluated With Checkboxes ////////////////////////////
		if (currentResults.getLens78dUsed())
			d78CheckBox.setSelected(true);
		else
			d78CheckBox.setSelected(false);
		
		if (currentResults.getLens90Dused())
			d90CheckBox.setSelected(true);
		else
			d90CheckBox.setSelected(false);
		
		if(currentResults.getLens20DbioUsed())
			d20BioCheckBox.setSelected(true);
		else
			d20BioCheckBox.setSelected(false);
		
		if(currentResults.getLensPR22bioUsed())
			pR2BioCheckBox4.setSelected(true);
		else
			pR2BioCheckBox4.setSelected(false);
		
		if(currentResults.getScleralDepUsed())
			sdepressionCheckBox.setSelected(true);
		else
			sdepressionCheckBox.setSelected(false);
		
		if (currentResults.getDirectOpthScopeUsed())
			dOpthalmpscopeCheckBox.setSelected(true);
		else
			dOpthalmpscopeCheckBox.setSelected(false);
		
		if (currentResults.getOtherNoteGiven())
		{
			otherCheckBox7.setSelected(true);
			otherTextField.setText(currentResults.getOtherNoteText());
		} else {
			otherCheckBox7.setSelected(false);
			otherTextField.setText("");
		}
		
		///////////////////// Fundus Notes Checkboxes ////////////////////////////
		
		if (currentResults.getPatientAdvisedDfe())
			DFE1CheckBox2.setSelected(true);
		else
			DFE1CheckBox2.setSelected(false);
			
		if (currentResults.getDfeResched())
			DFE2CheckBox.setSelected(true);
		else
			DFE2CheckBox.setSelected(false);
		
		if (currentResults.getDfeDeclined())
			DFEDeclinedCheckBox.setSelected(true);
		else	
			DFEDeclinedCheckBox.setSelected(false);
			
		if (currentResults.getFundusImgPerformed())
			FundusPerformedCheckBox1.setSelected(true);
		else
			FundusPerformedCheckBox1.setSelected(false);
			
		if (currentResults.getDfeRefusedAme())
			DFERefusedCheckBox.setSelected(true);
		else
			DFERefusedCheckBox.setSelected(false);
		
		if (currentResults.getDfeNotInd())
			DFENotIndicatedCheckBox1.setSelected(true);
		else
			DFENotIndicatedCheckBox1.setSelected(false);
			
		if (currentResults.getDfeContraind())
			DFEContraindicatedCheckBox.setSelected(true);
		else
			DFEContraindicatedCheckBox.setSelected(false);
			
		if (currentResults.getRecentDfe())
			recentDFECheckBox1.setSelected(true);
		else
			recentDFECheckBox1.setSelected(false);
			
		///////////////////// Cup Disk Ratio Tools //////////////////////////////////
		// OD
		odHorizontalTextField.setText(currentResults.getHorizOD().toString());
		odVerticalTextField.setText(currentResults.getVertOD().toString());
		
		Double scaledVal = currentResults.getHorizOD() * 100.0;
		Integer sliderVal = (int)Math.round(scaledVal);
		odHorizontalSlider.setValue(sliderVal);
		scaledVal = currentResults.getVertOD() * 100.0;
		sliderVal = (int)Math.round(scaledVal);
		odVerticalSlider.setValue(sliderVal);
		
		// OS
		osHorizontalTextField.setText(currentResults.getHorizOS().toString());
		osVerticalTextField.setText(currentResults.getVertOS().toString());
		
		scaledVal = currentResults.getHorizOS() * 100.0;
		sliderVal = (int)Math.round(scaledVal);
		osHorizontalSlider.setValue(sliderVal);
		scaledVal = currentResults.getVertOS() * 100.0;
		sliderVal = (int)Math.round(scaledVal);
		osVerticalSlider.setValue(sliderVal);
		
		///////////////////// Optic Nerve Descriptor Checkboxes /////////////////////
		//	OD
		if (currentResults.getDeepLaminaOD())
			odDeepLaminaCheckBox.setSelected(true);
		else
			odDeepLaminaCheckBox.setSelected(false);
			
		if (currentResults.getShallowOD())
			odShallowCheckBox.setSelected(true);
		else
			odShallowCheckBox.setSelected(false);
			
		if (currentResults.getRoundOD())
			odRoundCheckBox.setSelected(true);
		else
			odRoundCheckBox.setSelected(false);
		
		if (currentResults.getOvalOD())
			odOvalCheckBox.setSelected(true);
		else
			odOvalCheckBox.setSelected(false);
			
		if (currentResults.getTempSlopingOD())
			odTempSlopingCheckbox.setSelected(true);
		else
			odTempSlopingCheckbox.setSelected(false);
			
		if (currentResults.getUnderminingOD())
			odUnderminingCheckBox.setSelected(true);
		else
			odUnderminingCheckBox.setSelected(false);
			
		if (currentResults.getPeripapAtrophyOD())
			odPeripapAtrophyCheckBox.setSelected(true);
		else
			odPeripapAtrophyCheckBox.setSelected(false);
			
		if (currentResults.getScleralCrescentOD())
			odScleralCrescentCheckBox.setSelected(true);
		else
			odScleralCrescentCheckBox.setSelected(false);
			
		if (currentResults.getPigmentCrescentOD())
			odPigmentCrescentCheckBox.setSelected(true);
		else
			odPigmentCrescentCheckBox.setSelected(false);
			
		if (currentResults.getOpticPitOD())
			odOpticPitCheckBox.setSelected(true);
		else
			odOpticPitCheckBox.setSelected(false);
			
		if (currentResults.getMyelinationOD())
			odMylenationCheckBox.setSelected(true);
		else
			odMylenationCheckBox.setSelected(false);
		
		if (currentResults.getGlialRemOD())
			odGlialRemnantsCheckBox.setSelected(true);
		else
			odGlialRemnantsCheckBox.setSelected(false);
		
		// OS
				if (currentResults.getDeepLaminaOS())
			osDeepLaminaCheckBox.setSelected(true);
		else
			osDeepLaminaCheckBox.setSelected(false);
			
		if (currentResults.getShallowOS())
			osShallowCheckBox.setSelected(true);
		else
			osShallowCheckBox.setSelected(false);
			
		if (currentResults.getRoundOS())
			osRoundCheckBox.setSelected(true);
		else
			osRoundCheckBox.setSelected(false);
		
		if (currentResults.getOvalOS())
			osOvalCheckBox.setSelected(true);
		else
			osOvalCheckBox.setSelected(false);
			
		if (currentResults.getTempSlopingOS())
			osTempSlopingCheckBox.setSelected(true);
		else
			osTempSlopingCheckBox.setSelected(false);
			
		if (currentResults.getUnderminingOS())
			osUnderminingCheckBox.setSelected(true);
		else
			osUnderminingCheckBox.setSelected(false);
			
		if (currentResults.getPeripapAtrophyOS())
			osPeripapAtrophyCheckBox.setSelected(true);
		else
			osPeripapAtrophyCheckBox.setSelected(false);
			
		if (currentResults.getScleralCrescentOS())
			osScleralCrescentCheckBox.setSelected(true);
		else
			osScleralCrescentCheckBox.setSelected(false);
			
		if (currentResults.getPigmentCrescentOS())
			osPigmentCrescentCheckBox.setSelected(true);
		else
			osPigmentCrescentCheckBox.setSelected(false);
			
		if (currentResults.getOpticPitOS())
			osOpticPitCheckBox.setSelected(true);
		else
			osOpticPitCheckBox.setSelected(false);
			
		if (currentResults.getMyelinationOS())
			osMylenationCheckBox.setSelected(true);
		else
			osMylenationCheckBox.setSelected(false);
		
		if (currentResults.getGlialRemOS())
			osGlialRemnantsCheckBox.setSelected(true);
		else
			osGlialRemnantsCheckBox.setSelected(false);
		
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        osFovealReflexRadioButtonGroup = new javax.swing.ButtonGroup();
        odFovealReflexRadioButtonGroup = new javax.swing.ButtonGroup();
        osSpontaneousPulsationRadioButtonGroup = new javax.swing.ButtonGroup();
        odSpontaneousPulsationRadioButtonGroup = new javax.swing.ButtonGroup();
        fundusOptionRadioButtonGroup = new javax.swing.ButtonGroup();
        fundusDilationRadioButtonGroup = new javax.swing.ButtonGroup();
        titlePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        psPanel = new javax.swing.JPanel();
        posteriorSegTitlePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        odOpthalmicIndicatorsPanel = new javax.swing.JPanel();
        maculaComboBox1 = new javax.swing.JComboBox<>();
        vasculatureComboBox1 = new javax.swing.JComboBox<>();
        posteriorPoleComboBox1 = new javax.swing.JComboBox<>();
        peripheralRetinaComboBox1 = new javax.swing.JComboBox<>();
        miscRetinaComboBox1 = new javax.swing.JComboBox<>();
        diabeticEvalComboBox1 = new javax.swing.JComboBox<>();
        vitreousComboBox1 = new javax.swing.JComboBox<>();
        armdComboBox1 = new javax.swing.JComboBox<>();
        htnEvaluationComboBox1 = new javax.swing.JComboBox<>();
        custom2ComboBox1 = new javax.swing.JComboBox<>();
        custom3ComboBox1 = new javax.swing.JComboBox<>();
        custom1ComboBox1 = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        osOpthalmicIndicatorsPanel = new javax.swing.JPanel();
        maculaComboBox2 = new javax.swing.JComboBox<>();
        vasculatureComboBox2 = new javax.swing.JComboBox<>();
        posteriorPoleComboBox2 = new javax.swing.JComboBox<>();
        peripheralRetinaComboBox2 = new javax.swing.JComboBox<>();
        miscRetinaComboBox2 = new javax.swing.JComboBox<>();
        diabeticEvalComboBox2 = new javax.swing.JComboBox<>();
        vitreousComboBox2 = new javax.swing.JComboBox<>();
        armdComboBox2 = new javax.swing.JComboBox<>();
        htnEvaluationComboBox2 = new javax.swing.JComboBox<>();
        custom2ComboBox2 = new javax.swing.JComboBox<>();
        custom3ComboBox2 = new javax.swing.JComboBox<>();
        custom1ComboBox2 = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        opthalmicIndcPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        osFovealReflexPlusRadioButton = new javax.swing.JRadioButton();
        osFovealReflexMinusRadioButton = new javax.swing.JRadioButton();
        osFovealReflexXRadioButton = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        osSpontaneousPulsationPlusRadioButton = new javax.swing.JRadioButton();
        osSpontaneousPulsationMinusRadioButton = new javax.swing.JRadioButton();
        osSpontaneousPulsationXRadioButton = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        odFovealReflexPlusRadioButton1 = new javax.swing.JRadioButton();
        odFovealReflexMinusRadioButton1 = new javax.swing.JRadioButton();
        odFovealReflexXRadioButton1 = new javax.swing.JRadioButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel62 = new javax.swing.JLabel();
        odSpontaneousPulsationPlusRadioButton1 = new javax.swing.JRadioButton();
        odSpontaneousPulsationMinusRadioButton1 = new javax.swing.JRadioButton();
        odSpontaneousPulsationXRadioButton1 = new javax.swing.JRadioButton();
        fundusEvalMethodPanel = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        d78CheckBox = new javax.swing.JCheckBox();
        d90CheckBox = new javax.swing.JCheckBox();
        d20BioCheckBox = new javax.swing.JCheckBox();
        pR2BioCheckBox4 = new javax.swing.JCheckBox();
        otherCheckBox7 = new javax.swing.JCheckBox();
        sdepressionCheckBox = new javax.swing.JCheckBox();
        dOpthalmpscopeCheckBox = new javax.swing.JCheckBox();
        otherTextField = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        gtt2RadioButton = new javax.swing.JRadioButton();
        gtt1RadioButton = new javax.swing.JRadioButton();
        dilationAgentComboBox = new javax.swing.JComboBox<>();
        fundusOptionsBttnPanel = new javax.swing.JPanel();
        fundusEvaluationNotPerformedRadioButton = new javax.swing.JRadioButton();
        smallPupilBIORadioButton = new javax.swing.JRadioButton();
        dilatedEvalRadioButton = new javax.swing.JRadioButton();
        undilatedEvalRadioButton = new javax.swing.JRadioButton();
        optomapImagingRadioButton = new javax.swing.JRadioButton();
        dfeWithOptomapRadioButton = new javax.swing.JRadioButton();
        notesPanel = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        DFE2CheckBox = new javax.swing.JCheckBox();
        DFE1CheckBox2 = new javax.swing.JCheckBox();
        DFEDeclinedCheckBox = new javax.swing.JCheckBox();
        DFERefusedCheckBox = new javax.swing.JCheckBox();
        FundusPerformedCheckBox1 = new javax.swing.JCheckBox();
        DFENotIndicatedCheckBox1 = new javax.swing.JCheckBox();
        DFEContraindicatedCheckBox = new javax.swing.JCheckBox();
        recentDFECheckBox1 = new javax.swing.JCheckBox();
        cupDiscRatioPanel = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        odVerticalSlider = new javax.swing.JSlider();
        osVerticalSlider = new javax.swing.JSlider();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        odHorizontalSlider = new javax.swing.JSlider();
        osHorizontalSlider = new javax.swing.JSlider();
        odHorizontalTextField = new javax.swing.JTextField();
        osHorizontalTextField = new javax.swing.JTextField();
        osVerticalTextField = new javax.swing.JTextField();
        odVerticalTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        odOpticNerveComboBox = new javax.swing.JComboBox<>();
        odNerveFiberLayerComboBox = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        osOpticNerveComboBox = new javax.swing.JComboBox<>();
        osNerveFiberLayerComboBox = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        odOvalCheckBox = new javax.swing.JCheckBox();
        odShallowCheckBox = new javax.swing.JCheckBox();
        odTempSlopingCheckbox = new javax.swing.JCheckBox();
        odRoundCheckBox = new javax.swing.JCheckBox();
        odUnderminingCheckBox = new javax.swing.JCheckBox();
        osPeripapAtrophyCheckBox = new javax.swing.JCheckBox();
        osDeepLaminaCheckBox = new javax.swing.JCheckBox();
        osPigmentCrescentCheckBox = new javax.swing.JCheckBox();
        osScleralCrescentCheckBox = new javax.swing.JCheckBox();
        odMylenationCheckBox = new javax.swing.JCheckBox();
        odGlialRemnantsCheckBox = new javax.swing.JCheckBox();
        odOpticPitCheckBox = new javax.swing.JCheckBox();
        jLabel38 = new javax.swing.JLabel();
        odDeepLaminaCheckBox = new javax.swing.JCheckBox();
        osShallowCheckBox = new javax.swing.JCheckBox();
        osRoundCheckBox = new javax.swing.JCheckBox();
        osOvalCheckBox = new javax.swing.JCheckBox();
        osTempSlopingCheckBox = new javax.swing.JCheckBox();
        osUnderminingCheckBox = new javax.swing.JCheckBox();
        odPeripapAtrophyCheckBox = new javax.swing.JCheckBox();
        odScleralCrescentCheckBox = new javax.swing.JCheckBox();
        odPigmentCrescentCheckBox = new javax.swing.JCheckBox();
        osOpticPitCheckBox = new javax.swing.JCheckBox();
        osMylenationCheckBox = new javax.swing.JCheckBox();
        osGlialRemnantsCheckBox = new javax.swing.JCheckBox();
        saveButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(57, 113, 177));
        setMaximumSize(new java.awt.Dimension(1920, 900));
        setPreferredSize(new java.awt.Dimension(1900, 850));

        titlePanel.setBackground(new java.awt.Color(32, 33, 35));
        titlePanel.setPreferredSize(new java.awt.Dimension(1900, 66));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ocular Exam Findings");
        jLabel1.setPreferredSize(new java.awt.Dimension(1900, 44));

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        psPanel.setBackground(new java.awt.Color(32, 33, 35));
        psPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 4, 5, new java.awt.Color(253, 252, 233)));

        posteriorSegTitlePanel.setBackground(new java.awt.Color(135, 206, 250));

        jLabel2.setBackground(new java.awt.Color(32, 33, 35));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(32, 33, 35));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Posterior Segment");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout posteriorSegTitlePanelLayout = new javax.swing.GroupLayout(posteriorSegTitlePanel);
        posteriorSegTitlePanel.setLayout(posteriorSegTitlePanelLayout);
        posteriorSegTitlePanelLayout.setHorizontalGroup(
            posteriorSegTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        posteriorSegTitlePanelLayout.setVerticalGroup(
            posteriorSegTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, posteriorSegTitlePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(9, 9, 9))
        );

        jTabbedPane1.setBackground(new java.awt.Color(32, 33, 35));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        odOpthalmicIndicatorsPanel.setBackground(new java.awt.Color(32, 33, 35));
        odOpthalmicIndicatorsPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(253, 252, 233)));

        maculaComboBox1.setBackground(new java.awt.Color(253, 252, 233));
        maculaComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maculaComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        maculaComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        maculaComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maculaComboBox1ActionPerformed(evt);
            }
        });

        vasculatureComboBox1.setBackground(new java.awt.Color(253, 252, 233));
        vasculatureComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vasculatureComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        vasculatureComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        vasculatureComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vasculatureComboBox1ActionPerformed(evt);
            }
        });

        posteriorPoleComboBox1.setBackground(new java.awt.Color(253, 252, 233));
        posteriorPoleComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        posteriorPoleComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        posteriorPoleComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        posteriorPoleComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posteriorPoleComboBox1ActionPerformed(evt);
            }
        });

        peripheralRetinaComboBox1.setBackground(new java.awt.Color(253, 252, 233));
        peripheralRetinaComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        peripheralRetinaComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        peripheralRetinaComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        peripheralRetinaComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peripheralRetinaComboBox1ActionPerformed(evt);
            }
        });

        miscRetinaComboBox1.setBackground(new java.awt.Color(253, 252, 233));
        miscRetinaComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        miscRetinaComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        miscRetinaComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        miscRetinaComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miscRetinaComboBox1ActionPerformed(evt);
            }
        });

        diabeticEvalComboBox1.setBackground(new java.awt.Color(253, 252, 233));
        diabeticEvalComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        diabeticEvalComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        diabeticEvalComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        diabeticEvalComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diabeticEvalComboBox1ActionPerformed(evt);
            }
        });

        vitreousComboBox1.setBackground(new java.awt.Color(253, 252, 233));
        vitreousComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vitreousComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        vitreousComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        vitreousComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vitreousComboBox1ActionPerformed(evt);
            }
        });

        armdComboBox1.setBackground(new java.awt.Color(253, 252, 233));
        armdComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        armdComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        armdComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        armdComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                armdComboBox1ActionPerformed(evt);
            }
        });

        htnEvaluationComboBox1.setBackground(new java.awt.Color(253, 252, 233));
        htnEvaluationComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        htnEvaluationComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        htnEvaluationComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        htnEvaluationComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htnEvaluationComboBox1ActionPerformed(evt);
            }
        });

        custom2ComboBox1.setBackground(new java.awt.Color(253, 252, 233));
        custom2ComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        custom2ComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        custom2ComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        custom2ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom2ComboBox1ActionPerformed(evt);
            }
        });

        custom3ComboBox1.setBackground(new java.awt.Color(253, 252, 233));
        custom3ComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        custom3ComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        custom3ComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        custom3ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom3ComboBox1ActionPerformed(evt);
            }
        });

        custom1ComboBox1.setBackground(new java.awt.Color(253, 252, 233));
        custom1ComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        custom1ComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        custom1ComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        custom1ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom1ComboBox1ActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Vasculature:");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Diabetic Eval:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Macula:");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Posterior Pole:");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Misc Retina:");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Peripheral Retina:");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Vitreous:");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("< Custom 3 >:");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("HTN Evaluation:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("ARMD:");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("< Custom 1 >:");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("< Custom 2 >:");

        javax.swing.GroupLayout odOpthalmicIndicatorsPanelLayout = new javax.swing.GroupLayout(odOpthalmicIndicatorsPanel);
        odOpthalmicIndicatorsPanel.setLayout(odOpthalmicIndicatorsPanelLayout);
        odOpthalmicIndicatorsPanelLayout.setHorizontalGroup(
            odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(odOpthalmicIndicatorsPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vitreousComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(odOpthalmicIndicatorsPanelLayout.createSequentialGroup()
                        .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maculaComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vasculatureComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102)
                        .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(htnEvaluationComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(armdComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diabeticEvalComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(odOpthalmicIndicatorsPanelLayout.createSequentialGroup()
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(odOpthalmicIndicatorsPanelLayout.createSequentialGroup()
                            .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(posteriorPoleComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(peripheralRetinaComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(miscRetinaComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(odOpthalmicIndicatorsPanelLayout.createSequentialGroup()
                                    .addGap(96, 96, 96)
                                    .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(custom1ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(odOpthalmicIndicatorsPanelLayout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(custom2ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, odOpthalmicIndicatorsPanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(custom3ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        odOpthalmicIndicatorsPanelLayout.setVerticalGroup(
            odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(odOpthalmicIndicatorsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diabeticEvalComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vitreousComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(htnEvaluationComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maculaComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vasculatureComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(armdComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(posteriorPoleComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custom1ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(peripheralRetinaComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custom2ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(odOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(miscRetinaComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custom3ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("OD", odOpthalmicIndicatorsPanel);

        osOpthalmicIndicatorsPanel.setBackground(new java.awt.Color(32, 33, 35));
        osOpthalmicIndicatorsPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(253, 252, 233)));

        maculaComboBox2.setBackground(new java.awt.Color(253, 252, 233));
        maculaComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maculaComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        maculaComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        maculaComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maculaComboBox2ActionPerformed(evt);
            }
        });

        vasculatureComboBox2.setBackground(new java.awt.Color(253, 252, 233));
        vasculatureComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vasculatureComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        vasculatureComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        vasculatureComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vasculatureComboBox2ActionPerformed(evt);
            }
        });

        posteriorPoleComboBox2.setBackground(new java.awt.Color(253, 252, 233));
        posteriorPoleComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        posteriorPoleComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        posteriorPoleComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        posteriorPoleComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                posteriorPoleComboBox2ActionPerformed(evt);
            }
        });

        peripheralRetinaComboBox2.setBackground(new java.awt.Color(253, 252, 233));
        peripheralRetinaComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        peripheralRetinaComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        peripheralRetinaComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        peripheralRetinaComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peripheralRetinaComboBox2ActionPerformed(evt);
            }
        });

        miscRetinaComboBox2.setBackground(new java.awt.Color(253, 252, 233));
        miscRetinaComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        miscRetinaComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        miscRetinaComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        miscRetinaComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miscRetinaComboBox2ActionPerformed(evt);
            }
        });

        diabeticEvalComboBox2.setBackground(new java.awt.Color(253, 252, 233));
        diabeticEvalComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        diabeticEvalComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        diabeticEvalComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        diabeticEvalComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diabeticEvalComboBox2ActionPerformed(evt);
            }
        });

        vitreousComboBox2.setBackground(new java.awt.Color(253, 252, 233));
        vitreousComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vitreousComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        vitreousComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        vitreousComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vitreousComboBox2ActionPerformed(evt);
            }
        });

        armdComboBox2.setBackground(new java.awt.Color(253, 252, 233));
        armdComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        armdComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        armdComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        armdComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                armdComboBox2ActionPerformed(evt);
            }
        });

        htnEvaluationComboBox2.setBackground(new java.awt.Color(253, 252, 233));
        htnEvaluationComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        htnEvaluationComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        htnEvaluationComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        htnEvaluationComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                htnEvaluationComboBox2ActionPerformed(evt);
            }
        });

        custom2ComboBox2.setBackground(new java.awt.Color(253, 252, 233));
        custom2ComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        custom2ComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        custom2ComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        custom2ComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom2ComboBox2ActionPerformed(evt);
            }
        });

        custom3ComboBox2.setBackground(new java.awt.Color(253, 252, 233));
        custom3ComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        custom3ComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        custom3ComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        custom3ComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom3ComboBox2ActionPerformed(evt);
            }
        });

        custom1ComboBox2.setBackground(new java.awt.Color(253, 252, 233));
        custom1ComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        custom1ComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        custom1ComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        custom1ComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom1ComboBox2ActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Vasculature:");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Diabetic Eval:");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Macula:");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Posterior Pole:");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Misc Retina:");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Peripheral Retina:");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Vitreous:");

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("< Custom 3 >:");

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("HTN Evaluation:");

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("ARMD:");

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("< Custom 1 >:");

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("< Custom 2 >:");

        javax.swing.GroupLayout osOpthalmicIndicatorsPanelLayout = new javax.swing.GroupLayout(osOpthalmicIndicatorsPanel);
        osOpthalmicIndicatorsPanel.setLayout(osOpthalmicIndicatorsPanelLayout);
        osOpthalmicIndicatorsPanelLayout.setHorizontalGroup(
            osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(osOpthalmicIndicatorsPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vitreousComboBox2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, osOpthalmicIndicatorsPanelLayout.createSequentialGroup()
                        .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maculaComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(111, 111, 111)
                        .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(htnEvaluationComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diabeticEvalComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, osOpthalmicIndicatorsPanelLayout.createSequentialGroup()
                        .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vasculatureComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(posteriorPoleComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(111, 111, 111)
                        .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(custom1ComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(armdComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, osOpthalmicIndicatorsPanelLayout.createSequentialGroup()
                        .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(peripheralRetinaComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(miscRetinaComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(172, 172, 172)
                        .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(custom3ComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(custom2ComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        osOpthalmicIndicatorsPanelLayout.setVerticalGroup(
            osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(osOpthalmicIndicatorsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diabeticEvalComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vitreousComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maculaComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(htnEvaluationComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(armdComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vasculatureComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jLabel60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(posteriorPoleComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custom1ComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jLabel61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(peripheralRetinaComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custom2ComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(osOpthalmicIndicatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(miscRetinaComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custom3ComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("OS", osOpthalmicIndicatorsPanel);

        javax.swing.GroupLayout psPanelLayout = new javax.swing.GroupLayout(psPanel);
        psPanel.setLayout(psPanelLayout);
        psPanelLayout.setHorizontalGroup(
            psPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(posteriorSegTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        psPanelLayout.setVerticalGroup(
            psPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(psPanelLayout.createSequentialGroup()
                .addComponent(posteriorSegTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
        );

        opthalmicIndcPanel.setBackground(new java.awt.Color(32, 33, 35));
        opthalmicIndcPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 4, 5, new java.awt.Color(253, 252, 233)));

        jPanel5.setBackground(new java.awt.Color(135, 206, 250));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(32, 33, 35));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Opthalmic Indicators");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(32, 33, 35));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(253, 252, 233)));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("OS Foveal Reflex:");

        osFovealReflexPlusRadioButton.setBackground(new java.awt.Color(32, 33, 35));
        osFovealReflexRadioButtonGroup.add(osFovealReflexPlusRadioButton);
        osFovealReflexPlusRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        osFovealReflexPlusRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        osFovealReflexPlusRadioButton.setText("+");
        osFovealReflexPlusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osFovealReflexPlusRadioButtonActionPerformed(evt);
            }
        });

        osFovealReflexMinusRadioButton.setBackground(new java.awt.Color(32, 33, 35));
        osFovealReflexRadioButtonGroup.add(osFovealReflexMinusRadioButton);
        osFovealReflexMinusRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        osFovealReflexMinusRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        osFovealReflexMinusRadioButton.setText("-");
        osFovealReflexMinusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osFovealReflexMinusRadioButtonActionPerformed(evt);
            }
        });

        osFovealReflexXRadioButton.setBackground(new java.awt.Color(32, 33, 35));
        osFovealReflexRadioButtonGroup.add(osFovealReflexXRadioButton);
        osFovealReflexXRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        osFovealReflexXRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        osFovealReflexXRadioButton.setText("X");
        osFovealReflexXRadioButton.setToolTipText("");
        osFovealReflexXRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osFovealReflexXRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(osFovealReflexPlusRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(osFovealReflexMinusRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(osFovealReflexXRadioButton))
                    .addComponent(jLabel16))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(osFovealReflexPlusRadioButton)
                    .addComponent(osFovealReflexMinusRadioButton)
                    .addComponent(osFovealReflexXRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(32, 33, 35));
        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(253, 252, 233)));
        jPanel7.setToolTipText("");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("<html>OS Sponeaneous Veinous<br> Pulsation:");

        osSpontaneousPulsationPlusRadioButton.setBackground(new java.awt.Color(32, 33, 35));
        osSpontaneousPulsationRadioButtonGroup.add(osSpontaneousPulsationPlusRadioButton);
        osSpontaneousPulsationPlusRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        osSpontaneousPulsationPlusRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        osSpontaneousPulsationPlusRadioButton.setText("+");
        osSpontaneousPulsationPlusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osSpontaneousPulsationPlusRadioButtonActionPerformed(evt);
            }
        });

        osSpontaneousPulsationMinusRadioButton.setBackground(new java.awt.Color(32, 33, 35));
        osSpontaneousPulsationRadioButtonGroup.add(osSpontaneousPulsationMinusRadioButton);
        osSpontaneousPulsationMinusRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        osSpontaneousPulsationMinusRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        osSpontaneousPulsationMinusRadioButton.setText("-");
        osSpontaneousPulsationMinusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osSpontaneousPulsationMinusRadioButtonActionPerformed(evt);
            }
        });

        osSpontaneousPulsationXRadioButton.setBackground(new java.awt.Color(32, 33, 35));
        osSpontaneousPulsationRadioButtonGroup.add(osSpontaneousPulsationXRadioButton);
        osSpontaneousPulsationXRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        osSpontaneousPulsationXRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        osSpontaneousPulsationXRadioButton.setText("X");
        osSpontaneousPulsationXRadioButton.setToolTipText("");
        osSpontaneousPulsationXRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osSpontaneousPulsationXRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(osSpontaneousPulsationPlusRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(osSpontaneousPulsationMinusRadioButton)
                .addGap(18, 18, 18)
                .addComponent(osSpontaneousPulsationXRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel17)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(osSpontaneousPulsationPlusRadioButton)
                    .addComponent(osSpontaneousPulsationXRadioButton)
                    .addComponent(osSpontaneousPulsationMinusRadioButton))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(32, 33, 35));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(253, 252, 233)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("OD Foveal Reflex:");

        odFovealReflexPlusRadioButton1.setBackground(new java.awt.Color(32, 33, 35));
        odFovealReflexRadioButtonGroup.add(odFovealReflexPlusRadioButton1);
        odFovealReflexPlusRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        odFovealReflexPlusRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        odFovealReflexPlusRadioButton1.setText("+");
        odFovealReflexPlusRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odFovealReflexPlusRadioButton1ActionPerformed(evt);
            }
        });

        odFovealReflexMinusRadioButton1.setBackground(new java.awt.Color(32, 33, 35));
        odFovealReflexRadioButtonGroup.add(odFovealReflexMinusRadioButton1);
        odFovealReflexMinusRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        odFovealReflexMinusRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        odFovealReflexMinusRadioButton1.setText("-");
        odFovealReflexMinusRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odFovealReflexMinusRadioButton1ActionPerformed(evt);
            }
        });

        odFovealReflexXRadioButton1.setBackground(new java.awt.Color(32, 33, 35));
        odFovealReflexRadioButtonGroup.add(odFovealReflexXRadioButton1);
        odFovealReflexXRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        odFovealReflexXRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        odFovealReflexXRadioButton1.setText("X");
        odFovealReflexXRadioButton1.setToolTipText("");
        odFovealReflexXRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odFovealReflexXRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(odFovealReflexPlusRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(odFovealReflexMinusRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(odFovealReflexXRadioButton1))
                    .addComponent(jLabel18))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(odFovealReflexPlusRadioButton1)
                    .addComponent(odFovealReflexMinusRadioButton1)
                    .addComponent(odFovealReflexXRadioButton1))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel16.setBackground(new java.awt.Color(32, 33, 35));
        jPanel16.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(253, 252, 233)));
        jPanel16.setToolTipText("");

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("<html>OD Sponeaneous Veinous<br> Pulsation:");

        odSpontaneousPulsationPlusRadioButton1.setBackground(new java.awt.Color(32, 33, 35));
        odSpontaneousPulsationRadioButtonGroup.add(odSpontaneousPulsationPlusRadioButton1);
        odSpontaneousPulsationPlusRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        odSpontaneousPulsationPlusRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        odSpontaneousPulsationPlusRadioButton1.setText("+");
        odSpontaneousPulsationPlusRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odSpontaneousPulsationPlusRadioButton1ActionPerformed(evt);
            }
        });

        odSpontaneousPulsationMinusRadioButton1.setBackground(new java.awt.Color(32, 33, 35));
        odSpontaneousPulsationRadioButtonGroup.add(odSpontaneousPulsationMinusRadioButton1);
        odSpontaneousPulsationMinusRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        odSpontaneousPulsationMinusRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        odSpontaneousPulsationMinusRadioButton1.setText("-");
        odSpontaneousPulsationMinusRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odSpontaneousPulsationMinusRadioButton1ActionPerformed(evt);
            }
        });

        odSpontaneousPulsationXRadioButton1.setBackground(new java.awt.Color(32, 33, 35));
        odSpontaneousPulsationRadioButtonGroup.add(odSpontaneousPulsationXRadioButton1);
        odSpontaneousPulsationXRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        odSpontaneousPulsationXRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        odSpontaneousPulsationXRadioButton1.setText("X");
        odSpontaneousPulsationXRadioButton1.setToolTipText("");
        odSpontaneousPulsationXRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odSpontaneousPulsationXRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(odSpontaneousPulsationPlusRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(odSpontaneousPulsationMinusRadioButton1)
                .addGap(28, 28, 28)
                .addComponent(odSpontaneousPulsationXRadioButton1)
                .addContainerGap(67, Short.MAX_VALUE))
            .addComponent(jLabel62)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(odSpontaneousPulsationPlusRadioButton1)
                        .addComponent(odSpontaneousPulsationMinusRadioButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(odSpontaneousPulsationXRadioButton1)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout opthalmicIndcPanelLayout = new javax.swing.GroupLayout(opthalmicIndcPanel);
        opthalmicIndcPanel.setLayout(opthalmicIndcPanelLayout);
        opthalmicIndcPanelLayout.setHorizontalGroup(
            opthalmicIndcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(opthalmicIndcPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(opthalmicIndcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(opthalmicIndcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        opthalmicIndcPanelLayout.setVerticalGroup(
            opthalmicIndcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opthalmicIndcPanelLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(opthalmicIndcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(opthalmicIndcPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        fundusEvalMethodPanel.setBackground(new java.awt.Color(32, 33, 35));
        fundusEvalMethodPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 5, 4, 5, new java.awt.Color(253, 252, 233)));

        jPanel10.setBackground(new java.awt.Color(135, 206, 250));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(32, 33, 35));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Fundus Evaluation Method");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(16, 16, 16))
        );

        jPanel12.setBackground(new java.awt.Color(32, 33, 35));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(253, 252, 233)));
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Evaluated with:");

        d78CheckBox.setBackground(new java.awt.Color(32, 33, 35));
        d78CheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        d78CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        d78CheckBox.setText("78D Lens");
        d78CheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                d78CheckBoxItemStateChanged(evt);
            }
        });

        d90CheckBox.setBackground(new java.awt.Color(32, 33, 35));
        d90CheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        d90CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        d90CheckBox.setText("90D Lens");
        d90CheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                d90CheckBoxItemStateChanged(evt);
            }
        });

        d20BioCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        d20BioCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        d20BioCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        d20BioCheckBox.setText("20D BIO Lens");
        d20BioCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                d20BioCheckBoxItemStateChanged(evt);
            }
        });

        pR2BioCheckBox4.setBackground(new java.awt.Color(32, 33, 35));
        pR2BioCheckBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pR2BioCheckBox4.setForeground(new java.awt.Color(255, 255, 255));
        pR2BioCheckBox4.setText("PR 2.2 BIO Lens");
        pR2BioCheckBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pR2BioCheckBox4ItemStateChanged(evt);
            }
        });

        otherCheckBox7.setBackground(new java.awt.Color(32, 33, 35));
        otherCheckBox7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        otherCheckBox7.setForeground(new java.awt.Color(255, 255, 255));
        otherCheckBox7.setText("Other");
        otherCheckBox7.setToolTipText("");
        otherCheckBox7.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                otherCheckBox7ItemStateChanged(evt);
            }
        });

        sdepressionCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        sdepressionCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sdepressionCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        sdepressionCheckBox.setText("Scleral Depression");
        sdepressionCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sdepressionCheckBoxItemStateChanged(evt);
            }
        });

        dOpthalmpscopeCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        dOpthalmpscopeCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dOpthalmpscopeCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        dOpthalmpscopeCheckBox.setText("Direct Opthalmoscope");
        dOpthalmpscopeCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dOpthalmpscopeCheckBoxItemStateChanged(evt);
            }
        });

        otherTextField.setBackground(new java.awt.Color(204, 255, 255));
        otherTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        otherTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                otherTextFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(d90CheckBox)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(d78CheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pR2BioCheckBox4)
                                    .addComponent(d20BioCheckBox))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sdepressionCheckBox)
                                    .addComponent(dOpthalmpscopeCheckBox)))
                            .addComponent(jLabel21)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(otherCheckBox7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(otherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d20BioCheckBox)
                    .addComponent(sdepressionCheckBox)
                    .addComponent(d78CheckBox))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(d90CheckBox)
                    .addComponent(pR2BioCheckBox4)
                    .addComponent(dOpthalmpscopeCheckBox))
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(otherCheckBox7)
                    .addComponent(otherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel13.setBackground(new java.awt.Color(32, 33, 35));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(253, 252, 233)));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Dilated with:");

        gtt2RadioButton.setBackground(new java.awt.Color(32, 33, 35));
        fundusDilationRadioButtonGroup.add(gtt2RadioButton);
        gtt2RadioButton.setForeground(new java.awt.Color(255, 255, 255));
        gtt2RadioButton.setText("2gtt");
        gtt2RadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gtt2RadioButtonActionPerformed(evt);
            }
        });

        gtt1RadioButton.setBackground(new java.awt.Color(32, 33, 35));
        fundusDilationRadioButtonGroup.add(gtt1RadioButton);
        gtt1RadioButton.setForeground(new java.awt.Color(255, 255, 255));
        gtt1RadioButton.setText("1gtt");
        gtt1RadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gtt1RadioButtonActionPerformed(evt);
            }
        });

        dilationAgentComboBox.setBackground(new java.awt.Color(32, 33, 35));
        dilationAgentComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dilationAgentComboBox.setForeground(new java.awt.Color(255, 255, 255));
        dilationAgentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Cyclopentolate 0.25%", "Tropicamide 1%", "Phenylepherine 2.5%" }));
        dilationAgentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dilationAgentComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(gtt1RadioButton))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(gtt2RadioButton))
                        .addComponent(dilationAgentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dilationAgentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gtt1RadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gtt2RadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fundusOptionsBttnPanel.setBackground(new java.awt.Color(32, 33, 35));
        fundusOptionsBttnPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(253, 252, 233)));

        fundusEvaluationNotPerformedRadioButton.setBackground(new java.awt.Color(32, 33, 35));
        fundusOptionRadioButtonGroup.add(fundusEvaluationNotPerformedRadioButton);
        fundusEvaluationNotPerformedRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fundusEvaluationNotPerformedRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        fundusEvaluationNotPerformedRadioButton.setText("Not Perfomed");
        fundusEvaluationNotPerformedRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fundusEvaluationNotPerformedRadioButtonActionPerformed(evt);
            }
        });

        smallPupilBIORadioButton.setBackground(new java.awt.Color(32, 33, 35));
        fundusOptionRadioButtonGroup.add(smallPupilBIORadioButton);
        smallPupilBIORadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        smallPupilBIORadioButton.setForeground(new java.awt.Color(255, 255, 255));
        smallPupilBIORadioButton.setText("Small Pupil BIO");
        smallPupilBIORadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smallPupilBIORadioButtonActionPerformed(evt);
            }
        });

        dilatedEvalRadioButton.setBackground(new java.awt.Color(32, 33, 35));
        fundusOptionRadioButtonGroup.add(dilatedEvalRadioButton);
        dilatedEvalRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dilatedEvalRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        dilatedEvalRadioButton.setText("Dilated Eval");
        dilatedEvalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dilatedEvalRadioButtonActionPerformed(evt);
            }
        });

        undilatedEvalRadioButton.setBackground(new java.awt.Color(32, 33, 35));
        fundusOptionRadioButtonGroup.add(undilatedEvalRadioButton);
        undilatedEvalRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        undilatedEvalRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        undilatedEvalRadioButton.setText("Undilated Eval");
        undilatedEvalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undilatedEvalRadioButtonActionPerformed(evt);
            }
        });

        optomapImagingRadioButton.setBackground(new java.awt.Color(32, 33, 35));
        fundusOptionRadioButtonGroup.add(optomapImagingRadioButton);
        optomapImagingRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        optomapImagingRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        optomapImagingRadioButton.setText("Optomap Imaging");
        optomapImagingRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optomapImagingRadioButtonActionPerformed(evt);
            }
        });

        dfeWithOptomapRadioButton.setBackground(new java.awt.Color(32, 33, 35));
        fundusOptionRadioButtonGroup.add(dfeWithOptomapRadioButton);
        dfeWithOptomapRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dfeWithOptomapRadioButton.setForeground(new java.awt.Color(255, 255, 255));
        dfeWithOptomapRadioButton.setText("DFE with Optomap");
        dfeWithOptomapRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dfeWithOptomapRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fundusOptionsBttnPanelLayout = new javax.swing.GroupLayout(fundusOptionsBttnPanel);
        fundusOptionsBttnPanel.setLayout(fundusOptionsBttnPanelLayout);
        fundusOptionsBttnPanelLayout.setHorizontalGroup(
            fundusOptionsBttnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundusOptionsBttnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fundusOptionsBttnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(smallPupilBIORadioButton)
                    .addComponent(dilatedEvalRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fundusEvaluationNotPerformedRadioButton))
                .addGap(18, 18, 18)
                .addGroup(fundusOptionsBttnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(undilatedEvalRadioButton)
                    .addComponent(dfeWithOptomapRadioButton)
                    .addComponent(optomapImagingRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fundusOptionsBttnPanelLayout.setVerticalGroup(
            fundusOptionsBttnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundusOptionsBttnPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(fundusOptionsBttnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fundusEvaluationNotPerformedRadioButton)
                    .addComponent(undilatedEvalRadioButton))
                .addGap(18, 18, 18)
                .addGroup(fundusOptionsBttnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(smallPupilBIORadioButton)
                    .addComponent(optomapImagingRadioButton))
                .addGap(18, 18, 18)
                .addGroup(fundusOptionsBttnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dilatedEvalRadioButton)
                    .addComponent(dfeWithOptomapRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        notesPanel.setBackground(new java.awt.Color(32, 33, 35));
        notesPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(253, 252, 233)));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Notes:");

        DFE2CheckBox.setBackground(new java.awt.Color(32, 33, 35));
        DFE2CheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DFE2CheckBox.setForeground(new java.awt.Color(255, 255, 255));
        DFE2CheckBox.setText("DFE to be rescheduled");
        DFE2CheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DFE2CheckBoxItemStateChanged(evt);
            }
        });

        DFE1CheckBox2.setBackground(new java.awt.Color(32, 33, 35));
        DFE1CheckBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DFE1CheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        DFE1CheckBox2.setText("Patient advised of effect of DFE");
        DFE1CheckBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DFE1CheckBox2ItemStateChanged(evt);
            }
        });

        DFEDeclinedCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        DFEDeclinedCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DFEDeclinedCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        DFEDeclinedCheckBox.setText("DFE Declined");
        DFEDeclinedCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DFEDeclinedCheckBoxItemStateChanged(evt);
            }
        });

        DFERefusedCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        DFERefusedCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DFERefusedCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        DFERefusedCheckBox.setText("DFE refused AME");
        DFERefusedCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DFERefusedCheckBoxItemStateChanged(evt);
            }
        });

        FundusPerformedCheckBox1.setBackground(new java.awt.Color(32, 33, 35));
        FundusPerformedCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FundusPerformedCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        FundusPerformedCheckBox1.setText("Fundus imaging performed");
        FundusPerformedCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FundusPerformedCheckBox1ItemStateChanged(evt);
            }
        });

        DFENotIndicatedCheckBox1.setBackground(new java.awt.Color(32, 33, 35));
        DFENotIndicatedCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DFENotIndicatedCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        DFENotIndicatedCheckBox1.setText("DFE Not Indicated");
        DFENotIndicatedCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DFENotIndicatedCheckBox1ItemStateChanged(evt);
            }
        });

        DFEContraindicatedCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        DFEContraindicatedCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DFEContraindicatedCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        DFEContraindicatedCheckBox.setText("DFE contraindicated");
        DFEContraindicatedCheckBox.setToolTipText("");
        DFEContraindicatedCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DFEContraindicatedCheckBoxItemStateChanged(evt);
            }
        });

        recentDFECheckBox1.setBackground(new java.awt.Color(32, 33, 35));
        recentDFECheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        recentDFECheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        recentDFECheckBox1.setText("Recent DFE");
        recentDFECheckBox1.setToolTipText("");
        recentDFECheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                recentDFECheckBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout notesPanelLayout = new javax.swing.GroupLayout(notesPanel);
        notesPanel.setLayout(notesPanelLayout);
        notesPanelLayout.setHorizontalGroup(
            notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DFE1CheckBox2)
                    .addComponent(jLabel22)
                    .addComponent(DFE2CheckBox)
                    .addComponent(DFEDeclinedCheckBox)
                    .addComponent(FundusPerformedCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(DFEContraindicatedCheckBox, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(recentDFECheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DFENotIndicatedCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DFERefusedCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        notesPanelLayout.setVerticalGroup(
            notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(15, 15, 15)
                .addGroup(notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DFE1CheckBox2)
                    .addComponent(DFERefusedCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DFE2CheckBox)
                    .addComponent(DFENotIndicatedCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DFEDeclinedCheckBox)
                    .addComponent(DFEContraindicatedCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FundusPerformedCheckBox1)
                    .addComponent(recentDFECheckBox1))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        cupDiscRatioPanel.setBackground(new java.awt.Color(32, 33, 35));
        cupDiscRatioPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(253, 252, 233)));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Cup/Disc Ratio Tool:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("OD:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Vertical:");

        odVerticalSlider.setBackground(new java.awt.Color(32, 33, 35));
        odVerticalSlider.setForeground(new java.awt.Color(255, 255, 255));
        odVerticalSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                odVerticalSliderStateChanged(evt);
            }
        });
        odVerticalSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                odVerticalSliderMouseReleased(evt);
            }
        });

        osVerticalSlider.setBackground(new java.awt.Color(32, 33, 35));
        osVerticalSlider.setForeground(new java.awt.Color(255, 255, 255));
        osVerticalSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                osVerticalSliderStateChanged(evt);
            }
        });
        osVerticalSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                osVerticalSliderMouseReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("OS:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Horizontal:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Vertical:");

        odHorizontalSlider.setBackground(new java.awt.Color(32, 33, 35));
        odHorizontalSlider.setForeground(new java.awt.Color(255, 255, 255));
        odHorizontalSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                odHorizontalSliderStateChanged(evt);
            }
        });
        odHorizontalSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                odHorizontalSliderMouseReleased(evt);
            }
        });

        osHorizontalSlider.setBackground(new java.awt.Color(32, 33, 35));
        osHorizontalSlider.setForeground(new java.awt.Color(255, 255, 255));
        osHorizontalSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                osHorizontalSliderStateChanged(evt);
            }
        });
        osHorizontalSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                osHorizontalSliderMouseReleased(evt);
            }
        });

        odHorizontalTextField.setBackground(new java.awt.Color(32, 33, 35));
        odHorizontalTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odHorizontalTextField.setForeground(new java.awt.Color(255, 255, 255));
        odHorizontalTextField.setText("0.50");

        osHorizontalTextField.setBackground(new java.awt.Color(32, 33, 35));
        osHorizontalTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osHorizontalTextField.setForeground(new java.awt.Color(255, 255, 255));
        osHorizontalTextField.setText("0.50");

        osVerticalTextField.setBackground(new java.awt.Color(32, 33, 35));
        osVerticalTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osVerticalTextField.setForeground(new java.awt.Color(255, 255, 255));
        osVerticalTextField.setText("0.50");

        odVerticalTextField.setBackground(new java.awt.Color(32, 33, 35));
        odVerticalTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odVerticalTextField.setForeground(new java.awt.Color(255, 255, 255));
        odVerticalTextField.setText("0.50");
        odVerticalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odVerticalTextFieldActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Horizontal:");

        javax.swing.GroupLayout cupDiscRatioPanelLayout = new javax.swing.GroupLayout(cupDiscRatioPanel);
        cupDiscRatioPanel.setLayout(cupDiscRatioPanelLayout);
        cupDiscRatioPanelLayout.setHorizontalGroup(
            cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cupDiscRatioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(cupDiscRatioPanelLayout.createSequentialGroup()
                        .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel27))
                        .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cupDiscRatioPanelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(odHorizontalSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cupDiscRatioPanelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(osHorizontalSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(osVerticalSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(cupDiscRatioPanelLayout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(odVerticalSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(34, 34, 34)
                .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(odVerticalTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(odHorizontalTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(osHorizontalTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(osVerticalTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94))
        );
        cupDiscRatioPanelLayout.setVerticalGroup(
            cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cupDiscRatioPanelLayout.createSequentialGroup()
                .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cupDiscRatioPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23)
                        .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(cupDiscRatioPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cupDiscRatioPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel28)
                                .addGap(34, 34, 34))))
                    .addGroup(cupDiscRatioPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(odHorizontalSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(odHorizontalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(odVerticalSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(odVerticalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel25)
                        .addComponent(osHorizontalSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cupDiscRatioPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel27))
                    .addComponent(osHorizontalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cupDiscRatioPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel29))
                    .addGroup(cupDiscRatioPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cupDiscRatioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(osVerticalSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(osVerticalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(32, 33, 35));
        jPanel14.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(253, 252, 233)));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("OD Optic Nerve:");

        odOpticNerveComboBox.setBackground(new java.awt.Color(253, 252, 233));
        odOpticNerveComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odOpticNerveComboBox.setForeground(new java.awt.Color(0, 0, 0));
        odOpticNerveComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        odOpticNerveComboBox.setToolTipText("");
        odOpticNerveComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odOpticNerveComboBoxActionPerformed(evt);
            }
        });

        odNerveFiberLayerComboBox.setBackground(new java.awt.Color(253, 252, 233));
        odNerveFiberLayerComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odNerveFiberLayerComboBox.setForeground(new java.awt.Color(0, 0, 0));
        odNerveFiberLayerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        odNerveFiberLayerComboBox.setToolTipText("");
        odNerveFiberLayerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odNerveFiberLayerComboBoxActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("OS Nerve Fiber Layer:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Optic Nerve Head Assessment:");

        osOpticNerveComboBox.setBackground(new java.awt.Color(253, 252, 233));
        osOpticNerveComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osOpticNerveComboBox.setForeground(new java.awt.Color(0, 0, 0));
        osOpticNerveComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        osOpticNerveComboBox.setToolTipText("");
        osOpticNerveComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osOpticNerveComboBoxActionPerformed(evt);
            }
        });

        osNerveFiberLayerComboBox.setBackground(new java.awt.Color(253, 252, 233));
        osNerveFiberLayerComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osNerveFiberLayerComboBox.setForeground(new java.awt.Color(0, 0, 0));
        osNerveFiberLayerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORM", "LOW", "HIGH", "CRITICAL", "NOT CHECKED" }));
        osNerveFiberLayerComboBox.setToolTipText("");
        osNerveFiberLayerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osNerveFiberLayerComboBoxActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("OD Nerve Fiber Layer:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("OS Optic Nerve:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(osOpticNerveComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(odOpticNerveComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(osNerveFiberLayerComboBox, 0, 207, Short.MAX_VALUE)
                    .addComponent(odNerveFiberLayerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addGap(30, 30, 30)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(odOpticNerveComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(odNerveFiberLayerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(osOpticNerveComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(osNerveFiberLayerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        jPanel15.setBackground(new java.awt.Color(32, 33, 35));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 3, 2, 3, new java.awt.Color(253, 252, 233)));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Optic Nerve Descriptor:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("OD:");

        odOvalCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        odOvalCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odOvalCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        odOvalCheckBox.setText("Oval");
        odOvalCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odOvalCheckBoxActionPerformed(evt);
            }
        });

        odShallowCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        odShallowCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odShallowCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        odShallowCheckBox.setText("Shallow");
        odShallowCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odShallowCheckBoxActionPerformed(evt);
            }
        });

        odTempSlopingCheckbox.setBackground(new java.awt.Color(32, 33, 35));
        odTempSlopingCheckbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odTempSlopingCheckbox.setForeground(new java.awt.Color(255, 255, 255));
        odTempSlopingCheckbox.setText("Temp.sloping");
        odTempSlopingCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odTempSlopingCheckboxActionPerformed(evt);
            }
        });

        odRoundCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        odRoundCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odRoundCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        odRoundCheckBox.setText("Round");
        odRoundCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odRoundCheckBoxActionPerformed(evt);
            }
        });

        odUnderminingCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        odUnderminingCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odUnderminingCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        odUnderminingCheckBox.setText("Undermining");
        odUnderminingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odUnderminingCheckBoxActionPerformed(evt);
            }
        });

        osPeripapAtrophyCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        osPeripapAtrophyCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osPeripapAtrophyCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        osPeripapAtrophyCheckBox.setText("Peripap Atrophy");
        osPeripapAtrophyCheckBox.setToolTipText("");
        osPeripapAtrophyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osPeripapAtrophyCheckBoxActionPerformed(evt);
            }
        });

        osDeepLaminaCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        osDeepLaminaCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osDeepLaminaCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        osDeepLaminaCheckBox.setText("Deep/Lamina");
        osDeepLaminaCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                osDeepLaminaCheckBoxItemStateChanged(evt);
            }
        });

        osPigmentCrescentCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        osPigmentCrescentCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osPigmentCrescentCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        osPigmentCrescentCheckBox.setText("Pigment Cresent");
        osPigmentCrescentCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osPigmentCrescentCheckBoxActionPerformed(evt);
            }
        });

        osScleralCrescentCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        osScleralCrescentCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osScleralCrescentCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        osScleralCrescentCheckBox.setText("Scleral Cresent");
        osScleralCrescentCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osScleralCrescentCheckBoxActionPerformed(evt);
            }
        });

        odMylenationCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        odMylenationCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odMylenationCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        odMylenationCheckBox.setText("Myelination");
        odMylenationCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odMylenationCheckBoxActionPerformed(evt);
            }
        });

        odGlialRemnantsCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        odGlialRemnantsCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odGlialRemnantsCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        odGlialRemnantsCheckBox.setText("Glial Remnants");
        odGlialRemnantsCheckBox.setToolTipText("");
        odGlialRemnantsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odGlialRemnantsCheckBoxActionPerformed(evt);
            }
        });

        odOpticPitCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        odOpticPitCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odOpticPitCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        odOpticPitCheckBox.setText("Optic Pit");
        odOpticPitCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odOpticPitCheckBoxActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("OS:");

        odDeepLaminaCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        odDeepLaminaCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odDeepLaminaCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        odDeepLaminaCheckBox.setText("Deep/Lamina");
        odDeepLaminaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odDeepLaminaCheckBoxActionPerformed(evt);
            }
        });

        osShallowCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        osShallowCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osShallowCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        osShallowCheckBox.setText("Shallow");
        osShallowCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osShallowCheckBoxActionPerformed(evt);
            }
        });

        osRoundCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        osRoundCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osRoundCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        osRoundCheckBox.setText("Round");
        osRoundCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osRoundCheckBoxActionPerformed(evt);
            }
        });

        osOvalCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        osOvalCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osOvalCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        osOvalCheckBox.setText("Oval");
        osOvalCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osOvalCheckBoxActionPerformed(evt);
            }
        });

        osTempSlopingCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        osTempSlopingCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osTempSlopingCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        osTempSlopingCheckBox.setText("Temp.sloping");
        osTempSlopingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osTempSlopingCheckBoxActionPerformed(evt);
            }
        });

        osUnderminingCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        osUnderminingCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osUnderminingCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        osUnderminingCheckBox.setText("Undermining");
        osUnderminingCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osUnderminingCheckBoxActionPerformed(evt);
            }
        });

        odPeripapAtrophyCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        odPeripapAtrophyCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odPeripapAtrophyCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        odPeripapAtrophyCheckBox.setText("Peripap Atrophy");
        odPeripapAtrophyCheckBox.setToolTipText("");
        odPeripapAtrophyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odPeripapAtrophyCheckBoxActionPerformed(evt);
            }
        });

        odScleralCrescentCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        odScleralCrescentCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odScleralCrescentCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        odScleralCrescentCheckBox.setText("Scleral Cresent");
        odScleralCrescentCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odScleralCrescentCheckBoxActionPerformed(evt);
            }
        });

        odPigmentCrescentCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        odPigmentCrescentCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        odPigmentCrescentCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        odPigmentCrescentCheckBox.setText("Pigment Cresent");
        odPigmentCrescentCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odPigmentCrescentCheckBoxActionPerformed(evt);
            }
        });

        osOpticPitCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        osOpticPitCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osOpticPitCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        osOpticPitCheckBox.setText("Optic Pit");
        osOpticPitCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osOpticPitCheckBoxActionPerformed(evt);
            }
        });

        osMylenationCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        osMylenationCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osMylenationCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        osMylenationCheckBox.setText("Myelination");
        osMylenationCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osMylenationCheckBoxActionPerformed(evt);
            }
        });

        osGlialRemnantsCheckBox.setBackground(new java.awt.Color(32, 33, 35));
        osGlialRemnantsCheckBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        osGlialRemnantsCheckBox.setForeground(new java.awt.Color(255, 255, 255));
        osGlialRemnantsCheckBox.setText("Glial Remnants");
        osGlialRemnantsCheckBox.setToolTipText("");
        osGlialRemnantsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osGlialRemnantsCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(odShallowCheckBox)
                                    .addComponent(odRoundCheckBox)
                                    .addComponent(odDeepLaminaCheckBox))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(odOvalCheckBox)
                                            .addComponent(odTempSlopingCheckbox))
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(odScleralCrescentCheckBox)
                                                .addGap(28, 28, 28))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(odPeripapAtrophyCheckBox)
                                                .addGap(18, 18, 18)))
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(odMylenationCheckBox)
                                            .addComponent(odOpticPitCheckBox)))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(odUnderminingCheckBox)
                                        .addGap(20, 20, 20)
                                        .addComponent(odPigmentCrescentCheckBox)
                                        .addGap(16, 16, 16)
                                        .addComponent(odGlialRemnantsCheckBox))))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(osDeepLaminaCheckBox)
                                    .addComponent(osShallowCheckBox)
                                    .addComponent(osRoundCheckBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(osTempSlopingCheckBox)
                                    .addComponent(osOvalCheckBox)
                                    .addComponent(osUnderminingCheckBox))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(osPigmentCrescentCheckBox)
                                    .addComponent(osPeripapAtrophyCheckBox)
                                    .addComponent(osScleralCrescentCheckBox))
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(osGlialRemnantsCheckBox))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(osMylenationCheckBox)
                                            .addComponent(osOpticPitCheckBox))))))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(odOvalCheckBox)
                    .addComponent(odOpticPitCheckBox)
                    .addComponent(odDeepLaminaCheckBox)
                    .addComponent(odPeripapAtrophyCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(odShallowCheckBox)
                    .addComponent(odTempSlopingCheckbox)
                    .addComponent(odMylenationCheckBox)
                    .addComponent(odScleralCrescentCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(odRoundCheckBox)
                    .addComponent(odUnderminingCheckBox)
                    .addComponent(odGlialRemnantsCheckBox)
                    .addComponent(odPigmentCrescentCheckBox))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(osDeepLaminaCheckBox)
                    .addComponent(osOvalCheckBox)
                    .addComponent(osPeripapAtrophyCheckBox)
                    .addComponent(osOpticPitCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(osShallowCheckBox)
                    .addComponent(osTempSlopingCheckBox)
                    .addComponent(osScleralCrescentCheckBox)
                    .addComponent(osMylenationCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(osRoundCheckBox)
                    .addComponent(osUnderminingCheckBox)
                    .addComponent(osPigmentCrescentCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(osGlialRemnantsCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveButton.setBackground(new java.awt.Color(102, 255, 102));
        saveButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 0, 0));
        saveButton.setText("SAVE");
        saveButton.setToolTipText("");
        saveButton.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 255, 102)));
        saveButton.setPreferredSize(new java.awt.Dimension(125, 38));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fundusEvalMethodPanelLayout = new javax.swing.GroupLayout(fundusEvalMethodPanel);
        fundusEvalMethodPanel.setLayout(fundusEvalMethodPanelLayout);
        fundusEvalMethodPanelLayout.setHorizontalGroup(
            fundusEvalMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(fundusEvalMethodPanelLayout.createSequentialGroup()
                .addGroup(fundusEvalMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fundusEvalMethodPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(fundusEvalMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(fundusEvalMethodPanelLayout.createSequentialGroup()
                                .addComponent(fundusOptionsBttnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))
                    .addGroup(fundusEvalMethodPanelLayout.createSequentialGroup()
                        .addGroup(fundusEvalMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fundusEvalMethodPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(notesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(fundusEvalMethodPanelLayout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(fundusEvalMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cupDiscRatioPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fundusEvalMethodPanelLayout.setVerticalGroup(
            fundusEvalMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundusEvalMethodPanelLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fundusEvalMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cupDiscRatioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fundusEvalMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fundusOptionsBttnPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fundusEvalMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fundusEvalMethodPanelLayout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fundusEvalMethodPanelLayout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(notesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(psPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opthalmicIndcPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fundusEvalMethodPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1944, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(psPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(opthalmicIndcPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fundusEvalMethodPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void optomapImagingRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optomapImagingRadioButtonActionPerformed
        currentResults.setMethodUsed("Optomap Imaging");
    }//GEN-LAST:event_optomapImagingRadioButtonActionPerformed

    private void d78CheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_d78CheckBoxItemStateChanged
        currentResults.setLens78dUsed(d78CheckBox.isSelected());
    }//GEN-LAST:event_d78CheckBoxItemStateChanged

    private void d90CheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_d90CheckBoxItemStateChanged
        currentResults.setLens90Dused(d90CheckBox.isSelected());
    }//GEN-LAST:event_d90CheckBoxItemStateChanged

    private void d20BioCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_d20BioCheckBoxItemStateChanged
        currentResults.setLens20DbioUsed(d20BioCheckBox.isSelected());
    }//GEN-LAST:event_d20BioCheckBoxItemStateChanged

    private void pR2BioCheckBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pR2BioCheckBox4ItemStateChanged
        currentResults.setLensPR22bioUsed(pR2BioCheckBox4.isSelected());
		//System.out.println(pR2BioCheckBox4.isSelected());
    }//GEN-LAST:event_pR2BioCheckBox4ItemStateChanged

    private void sdepressionCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sdepressionCheckBoxItemStateChanged
        currentResults.setScleralDepUsed(sdepressionCheckBox.isSelected());
    }//GEN-LAST:event_sdepressionCheckBoxItemStateChanged

    private void dOpthalmpscopeCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dOpthalmpscopeCheckBoxItemStateChanged
        currentResults.setDirectOpthScopeUsed(dOpthalmpscopeCheckBox.isSelected());
    }//GEN-LAST:event_dOpthalmpscopeCheckBoxItemStateChanged

    private void otherCheckBox7ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_otherCheckBox7ItemStateChanged
        currentResults.setOtherNoteGiven(otherCheckBox7.isSelected());
    }//GEN-LAST:event_otherCheckBox7ItemStateChanged

    private void otherTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_otherTextFieldFocusLost
        currentResults.setOtherNoteText(otherTextField.getText());
    }//GEN-LAST:event_otherTextFieldFocusLost

    private void DFE2CheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DFE2CheckBoxItemStateChanged
        currentResults.setDfeResched(DFE2CheckBox.isSelected());
    }//GEN-LAST:event_DFE2CheckBoxItemStateChanged

    private void DFE1CheckBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DFE1CheckBox2ItemStateChanged
        currentResults.setPatientAdvisedDfe(DFE1CheckBox2.isSelected());
    }//GEN-LAST:event_DFE1CheckBox2ItemStateChanged

    private void DFEDeclinedCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DFEDeclinedCheckBoxItemStateChanged
        currentResults.setDfeDeclined(DFEDeclinedCheckBox.isSelected());
    }//GEN-LAST:event_DFEDeclinedCheckBoxItemStateChanged

    private void DFERefusedCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DFERefusedCheckBoxItemStateChanged
        currentResults.setDfeRefusedAme(DFERefusedCheckBox.isSelected());
    }//GEN-LAST:event_DFERefusedCheckBoxItemStateChanged

    private void FundusPerformedCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FundusPerformedCheckBox1ItemStateChanged
        currentResults.setFundusImgPerformed(FundusPerformedCheckBox1.isSelected());
    }//GEN-LAST:event_FundusPerformedCheckBox1ItemStateChanged

    private void DFENotIndicatedCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DFENotIndicatedCheckBox1ItemStateChanged
        currentResults.setDfeNotInd(DFENotIndicatedCheckBox1.isSelected());
    }//GEN-LAST:event_DFENotIndicatedCheckBox1ItemStateChanged

    private void DFEContraindicatedCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DFEContraindicatedCheckBoxItemStateChanged
        currentResults.setDfeContraind(DFEContraindicatedCheckBox.isSelected());
    }//GEN-LAST:event_DFEContraindicatedCheckBoxItemStateChanged

    private void recentDFECheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_recentDFECheckBox1ItemStateChanged
        currentResults.setRecentDfe(recentDFECheckBox1.isSelected());
    }//GEN-LAST:event_recentDFECheckBox1ItemStateChanged

    private void osDeepLaminaCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_osDeepLaminaCheckBoxItemStateChanged
        currentResults.setDeepLaminaOS(osDeepLaminaCheckBox.isSelected());
    }//GEN-LAST:event_osDeepLaminaCheckBoxItemStateChanged

    private void odDeepLaminaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odDeepLaminaCheckBoxActionPerformed
        currentResults.setDeepLaminaOD(odDeepLaminaCheckBox.isSelected());
    }//GEN-LAST:event_odDeepLaminaCheckBoxActionPerformed
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void maculaComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maculaComboBox1ActionPerformed
        currentResults.setMaculaOD((String)maculaComboBox1.getSelectedItem());
    }//GEN-LAST:event_maculaComboBox1ActionPerformed

    private void maculaComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maculaComboBox2ActionPerformed
        currentResults.setMaculaOS((String)maculaComboBox2.getSelectedItem());
    }//GEN-LAST:event_maculaComboBox2ActionPerformed

    private void vitreousComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vitreousComboBox2ActionPerformed
        currentResults.setVitreousOS((String)vitreousComboBox2.getSelectedItem());
		System.out.println("vitreousOS: " + (String)vitreousComboBox2.getSelectedItem());
    }//GEN-LAST:event_vitreousComboBox2ActionPerformed

    private void vitreousComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vitreousComboBox1ActionPerformed
        currentResults.setVitreousOD((String) vitreousComboBox1.getSelectedItem());
		System.out.println("vitreousOD" + (String)vitreousComboBox1.getSelectedItem());
    }//GEN-LAST:event_vitreousComboBox1ActionPerformed

    private void diabeticEvalComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diabeticEvalComboBox1ActionPerformed
        currentResults.setDiabeticEvalOD((String) diabeticEvalComboBox1.getSelectedItem());
    }//GEN-LAST:event_diabeticEvalComboBox1ActionPerformed

    private void htnEvaluationComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htnEvaluationComboBox1ActionPerformed
        currentResults.setHtnEvalOD((String) htnEvaluationComboBox1.getSelectedItem());
    }//GEN-LAST:event_htnEvaluationComboBox1ActionPerformed

    private void vasculatureComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vasculatureComboBox1ActionPerformed
        currentResults.setVasculatureOD((String) vasculatureComboBox1.getSelectedItem());
    }//GEN-LAST:event_vasculatureComboBox1ActionPerformed

    private void armdComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_armdComboBox1ActionPerformed
        currentResults.setArmdOD((String) armdComboBox1.getSelectedItem());
    }//GEN-LAST:event_armdComboBox1ActionPerformed

    private void posteriorPoleComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posteriorPoleComboBox1ActionPerformed
        currentResults.setPosteriorPoleOD((String) posteriorPoleComboBox1.getSelectedItem());
    }//GEN-LAST:event_posteriorPoleComboBox1ActionPerformed

    private void custom1ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom1ComboBox1ActionPerformed
        currentResults.setCustom1OD((String)custom1ComboBox1.getSelectedItem());
    }//GEN-LAST:event_custom1ComboBox1ActionPerformed

    private void peripheralRetinaComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peripheralRetinaComboBox1ActionPerformed
        currentResults.setPeripheralRetinaOD((String) peripheralRetinaComboBox1.getSelectedItem());
    }//GEN-LAST:event_peripheralRetinaComboBox1ActionPerformed

    private void custom2ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom2ComboBox1ActionPerformed
        currentResults.setCustom2OD((String) custom2ComboBox1.getSelectedItem());
    }//GEN-LAST:event_custom2ComboBox1ActionPerformed

    private void miscRetinaComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miscRetinaComboBox1ActionPerformed
        currentResults.setMiscRetinaOD((String) miscRetinaComboBox1.getSelectedItem());
    }//GEN-LAST:event_miscRetinaComboBox1ActionPerformed

    private void custom3ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom3ComboBox1ActionPerformed
        currentResults.setCustom3OD((String)custom3ComboBox1.getSelectedItem());
    }//GEN-LAST:event_custom3ComboBox1ActionPerformed
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void diabeticEvalComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diabeticEvalComboBox2ActionPerformed
        currentResults.setDiabeticEvalOS((String) diabeticEvalComboBox2.getSelectedItem());
    }//GEN-LAST:event_diabeticEvalComboBox2ActionPerformed

    private void htnEvaluationComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_htnEvaluationComboBox2ActionPerformed
        currentResults.setHtnEvalOS((String) htnEvaluationComboBox2.getSelectedItem());
    }//GEN-LAST:event_htnEvaluationComboBox2ActionPerformed

    private void vasculatureComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vasculatureComboBox2ActionPerformed
        currentResults.setVasculatureOS((String) vasculatureComboBox2.getSelectedItem());
    }//GEN-LAST:event_vasculatureComboBox2ActionPerformed

    private void armdComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_armdComboBox2ActionPerformed
        currentResults.setArmdOS((String) armdComboBox2.getSelectedItem());
    }//GEN-LAST:event_armdComboBox2ActionPerformed

    private void posteriorPoleComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_posteriorPoleComboBox2ActionPerformed
        currentResults.setPosteriorPoleOS((String) posteriorPoleComboBox2.getSelectedItem());
    }//GEN-LAST:event_posteriorPoleComboBox2ActionPerformed

    private void custom1ComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom1ComboBox2ActionPerformed
        currentResults.setCustom1OS((String)custom1ComboBox2.getSelectedItem());
    }//GEN-LAST:event_custom1ComboBox2ActionPerformed

    private void peripheralRetinaComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peripheralRetinaComboBox2ActionPerformed
        currentResults.setPeripheralRetinaOS((String) peripheralRetinaComboBox2.getSelectedItem());
    }//GEN-LAST:event_peripheralRetinaComboBox2ActionPerformed

    private void custom2ComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom2ComboBox2ActionPerformed
        currentResults.setCustom2OS((String) custom2ComboBox2.getSelectedItem());
    }//GEN-LAST:event_custom2ComboBox2ActionPerformed

    private void miscRetinaComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miscRetinaComboBox2ActionPerformed
        currentResults.setMiscRetinaOS((String) miscRetinaComboBox2.getSelectedItem());
    }//GEN-LAST:event_miscRetinaComboBox2ActionPerformed

    private void custom3ComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom3ComboBox2ActionPerformed
        currentResults.setCustom3OS((String)custom3ComboBox2.getSelectedItem());
    }//GEN-LAST:event_custom3ComboBox2ActionPerformed

    private void dilationAgentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dilationAgentComboBoxActionPerformed
        currentResults.setDilationAgent((String) dilationAgentComboBox.getSelectedItem());
    }//GEN-LAST:event_dilationAgentComboBoxActionPerformed

    private void odHorizontalSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_odHorizontalSliderStateChanged
        Integer sliderVal = odHorizontalSlider.getValue();
		Double displayVal = Double.valueOf(sliderVal) / 100;
		odHorizontalTextField.setText(displayVal.toString());
    }//GEN-LAST:event_odHorizontalSliderStateChanged

    private void odVerticalSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_odVerticalSliderStateChanged
        Integer sliderVal = odVerticalSlider.getValue();
		Double displayVal = Double.valueOf(sliderVal) / 100;
		odVerticalTextField.setText(displayVal.toString());
    }//GEN-LAST:event_odVerticalSliderStateChanged

    private void osHorizontalSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_osHorizontalSliderStateChanged
        Integer sliderVal = osHorizontalSlider.getValue();
		Double displayVal = Double.valueOf(sliderVal) / 100;
		osHorizontalTextField.setText(displayVal.toString());
    }//GEN-LAST:event_osHorizontalSliderStateChanged

    private void osVerticalSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_osVerticalSliderStateChanged
        Integer sliderVal = osVerticalSlider.getValue();
		Double displayVal = Double.valueOf(sliderVal) / 100;
		osVerticalTextField.setText(displayVal.toString());
    }//GEN-LAST:event_osVerticalSliderStateChanged

    private void odHorizontalSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_odHorizontalSliderMouseReleased
        currentResults.setHorizOD(Double.valueOf(odHorizontalTextField.getText()));
    }//GEN-LAST:event_odHorizontalSliderMouseReleased

    private void odVerticalSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_odVerticalSliderMouseReleased
        currentResults.setVertOD(Double.valueOf(odVerticalTextField.getText()));
    }//GEN-LAST:event_odVerticalSliderMouseReleased

    private void osHorizontalSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_osHorizontalSliderMouseReleased
        currentResults.setHorizOS(Double.valueOf(osHorizontalTextField.getText()));
    }//GEN-LAST:event_osHorizontalSliderMouseReleased

    private void osVerticalSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_osVerticalSliderMouseReleased
        currentResults.setVertOS(Double.valueOf(osVerticalTextField.getText()));
    }//GEN-LAST:event_osVerticalSliderMouseReleased

    private void fundusEvaluationNotPerformedRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fundusEvaluationNotPerformedRadioButtonActionPerformed
        currentResults.setMethodUsed("Not Performed");
    }//GEN-LAST:event_fundusEvaluationNotPerformedRadioButtonActionPerformed

    private void undilatedEvalRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undilatedEvalRadioButtonActionPerformed
        currentResults.setMethodUsed("Undilated Eval");
    }//GEN-LAST:event_undilatedEvalRadioButtonActionPerformed

    private void smallPupilBIORadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smallPupilBIORadioButtonActionPerformed
        currentResults.setMethodUsed("Small Pupil BIO");
    }//GEN-LAST:event_smallPupilBIORadioButtonActionPerformed

    private void dilatedEvalRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dilatedEvalRadioButtonActionPerformed
        currentResults.setMethodUsed("Dilated Eval");
    }//GEN-LAST:event_dilatedEvalRadioButtonActionPerformed

    private void dfeWithOptomapRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dfeWithOptomapRadioButtonActionPerformed
        currentResults.setMethodUsed("DFE with Optomap");
    }//GEN-LAST:event_dfeWithOptomapRadioButtonActionPerformed

    private void gtt1RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gtt1RadioButtonActionPerformed
        currentResults.setGttOD("1");
    }//GEN-LAST:event_gtt1RadioButtonActionPerformed

    private void gtt2RadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gtt2RadioButtonActionPerformed
        currentResults.setGttOD("2");
    }//GEN-LAST:event_gtt2RadioButtonActionPerformed

    private void odOpticNerveComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odOpticNerveComboBoxActionPerformed
        currentResults.setOpticNerveOD((String) odOpticNerveComboBox.getSelectedItem());
    }//GEN-LAST:event_odOpticNerveComboBoxActionPerformed

    private void odNerveFiberLayerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odNerveFiberLayerComboBoxActionPerformed
        currentResults.setNerveFiberLayerOD((String) odNerveFiberLayerComboBox.getSelectedItem());
    }//GEN-LAST:event_odNerveFiberLayerComboBoxActionPerformed

    private void osOpticNerveComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osOpticNerveComboBoxActionPerformed
        currentResults.setOpticNerveOS((String) osOpticNerveComboBox.getSelectedItem());
    }//GEN-LAST:event_osOpticNerveComboBoxActionPerformed

    private void osNerveFiberLayerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osNerveFiberLayerComboBoxActionPerformed
        currentResults.setNerveFiberLayerOS((String) osNerveFiberLayerComboBox.getSelectedItem());
    }//GEN-LAST:event_osNerveFiberLayerComboBoxActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        dataBase.save(currentResults);
		if (panelToReturnTo == 0)
			mainDash.showAppointmentDisplay();
		else
			mainDash.showPatientSummaryPage();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void odShallowCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odShallowCheckBoxActionPerformed
        currentResults.setShallowOD(odShallowCheckBox.isSelected()); //////////////////////////////////////////////////
    }//GEN-LAST:event_odShallowCheckBoxActionPerformed

    private void odRoundCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odRoundCheckBoxActionPerformed
        currentResults.setRoundOD(odRoundCheckBox.isSelected());
    }//GEN-LAST:event_odRoundCheckBoxActionPerformed

    private void odOvalCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odOvalCheckBoxActionPerformed
        currentResults.setOvalOD(odOvalCheckBox.isSelected());
    }//GEN-LAST:event_odOvalCheckBoxActionPerformed

    private void odTempSlopingCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odTempSlopingCheckboxActionPerformed
        currentResults.setTempSlopingOD(odTempSlopingCheckbox.isSelected());
    }//GEN-LAST:event_odTempSlopingCheckboxActionPerformed

    private void odUnderminingCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odUnderminingCheckBoxActionPerformed
        currentResults.setUnderminingOD(odUnderminingCheckBox.isSelected());
    }//GEN-LAST:event_odUnderminingCheckBoxActionPerformed

    private void odPeripapAtrophyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odPeripapAtrophyCheckBoxActionPerformed
        currentResults.setPeripapAtrophyOD(odPeripapAtrophyCheckBox.isSelected());
    }//GEN-LAST:event_odPeripapAtrophyCheckBoxActionPerformed

    private void odScleralCrescentCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odScleralCrescentCheckBoxActionPerformed
        currentResults.setScleralCrescentOD(odScleralCrescentCheckBox.isSelected());
    }//GEN-LAST:event_odScleralCrescentCheckBoxActionPerformed

    private void odPigmentCrescentCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odPigmentCrescentCheckBoxActionPerformed
        currentResults.setPigmentCrescentOD(odPigmentCrescentCheckBox.isSelected());
    }//GEN-LAST:event_odPigmentCrescentCheckBoxActionPerformed

    private void odOpticPitCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odOpticPitCheckBoxActionPerformed
        currentResults.setOpticPitOD(odOpticPitCheckBox.isSelected());
    }//GEN-LAST:event_odOpticPitCheckBoxActionPerformed

    private void odMylenationCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odMylenationCheckBoxActionPerformed
        currentResults.setMyelinationOD(odMylenationCheckBox.isSelected());
    }//GEN-LAST:event_odMylenationCheckBoxActionPerformed

    private void odGlialRemnantsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odGlialRemnantsCheckBoxActionPerformed
        currentResults.setGlialRemOD(odGlialRemnantsCheckBox.isSelected());
    }//GEN-LAST:event_odGlialRemnantsCheckBoxActionPerformed

    private void osShallowCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osShallowCheckBoxActionPerformed
        currentResults.setShallowOS(osShallowCheckBox.isSelected());
    }//GEN-LAST:event_osShallowCheckBoxActionPerformed

    private void osRoundCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osRoundCheckBoxActionPerformed
        currentResults.setRoundOS(osRoundCheckBox.isSelected());
    }//GEN-LAST:event_osRoundCheckBoxActionPerformed

    private void osOvalCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osOvalCheckBoxActionPerformed
        currentResults.setOvalOS(osOvalCheckBox.isSelected());
    }//GEN-LAST:event_osOvalCheckBoxActionPerformed

    private void osTempSlopingCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osTempSlopingCheckBoxActionPerformed
        currentResults.setTempSlopingOS(osTempSlopingCheckBox.isSelected());
    }//GEN-LAST:event_osTempSlopingCheckBoxActionPerformed

    private void osUnderminingCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osUnderminingCheckBoxActionPerformed
        currentResults.setUnderminingOS(osUnderminingCheckBox.isSelected());
    }//GEN-LAST:event_osUnderminingCheckBoxActionPerformed

    private void osPeripapAtrophyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osPeripapAtrophyCheckBoxActionPerformed
        currentResults.setPeripapAtrophyOS(osPeripapAtrophyCheckBox.isSelected());
    }//GEN-LAST:event_osPeripapAtrophyCheckBoxActionPerformed

    private void osScleralCrescentCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osScleralCrescentCheckBoxActionPerformed
        currentResults.setScleralCrescentOS(osScleralCrescentCheckBox.isSelected());
    }//GEN-LAST:event_osScleralCrescentCheckBoxActionPerformed

    private void osPigmentCrescentCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osPigmentCrescentCheckBoxActionPerformed
        currentResults.setPigmentCrescentOS(osPigmentCrescentCheckBox.isSelected());
    }//GEN-LAST:event_osPigmentCrescentCheckBoxActionPerformed

    private void osOpticPitCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osOpticPitCheckBoxActionPerformed
        currentResults.setOpticPitOS(osOpticPitCheckBox.isSelected());
    }//GEN-LAST:event_osOpticPitCheckBoxActionPerformed

    private void osMylenationCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osMylenationCheckBoxActionPerformed
        currentResults.setMyelinationOS(osMylenationCheckBox.isSelected());
    }//GEN-LAST:event_osMylenationCheckBoxActionPerformed

    private void osGlialRemnantsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osGlialRemnantsCheckBoxActionPerformed
        currentResults.setGlialRemOS(osGlialRemnantsCheckBox.isSelected());
    }//GEN-LAST:event_osGlialRemnantsCheckBoxActionPerformed

    private void osFovealReflexPlusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osFovealReflexPlusRadioButtonActionPerformed
        currentResults.setFovealReflexOs("+");
    }//GEN-LAST:event_osFovealReflexPlusRadioButtonActionPerformed

    private void osFovealReflexMinusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osFovealReflexMinusRadioButtonActionPerformed
        currentResults.setFovealReflexOs("-");
    }//GEN-LAST:event_osFovealReflexMinusRadioButtonActionPerformed

    private void osFovealReflexXRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osFovealReflexXRadioButtonActionPerformed
        currentResults.setFovealReflexOs("X");
    }//GEN-LAST:event_osFovealReflexXRadioButtonActionPerformed

    private void odFovealReflexPlusRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odFovealReflexPlusRadioButton1ActionPerformed
        currentResults.setFovealReflexOD("+");
    }//GEN-LAST:event_odFovealReflexPlusRadioButton1ActionPerformed

    private void odFovealReflexMinusRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odFovealReflexMinusRadioButton1ActionPerformed
        currentResults.setFovealReflexOD("-");
    }//GEN-LAST:event_odFovealReflexMinusRadioButton1ActionPerformed

    private void odFovealReflexXRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odFovealReflexXRadioButton1ActionPerformed
        currentResults.setFovealReflexOD("X");
    }//GEN-LAST:event_odFovealReflexXRadioButton1ActionPerformed

    private void osSpontaneousPulsationPlusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osSpontaneousPulsationPlusRadioButtonActionPerformed
        currentResults.setSponVeinPulsOS("+");
    }//GEN-LAST:event_osSpontaneousPulsationPlusRadioButtonActionPerformed

    private void osSpontaneousPulsationMinusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osSpontaneousPulsationMinusRadioButtonActionPerformed
        currentResults.setSponVeinPulsOS("-");
    }//GEN-LAST:event_osSpontaneousPulsationMinusRadioButtonActionPerformed

    private void osSpontaneousPulsationXRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osSpontaneousPulsationXRadioButtonActionPerformed
        currentResults.setSponVeinPulsOS("X");
    }//GEN-LAST:event_osSpontaneousPulsationXRadioButtonActionPerformed

    private void odSpontaneousPulsationPlusRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odSpontaneousPulsationPlusRadioButton1ActionPerformed
        currentResults.setSponVeinPulsOD("+");
    }//GEN-LAST:event_odSpontaneousPulsationPlusRadioButton1ActionPerformed

    private void odSpontaneousPulsationMinusRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odSpontaneousPulsationMinusRadioButton1ActionPerformed
        currentResults.setSponVeinPulsOD("-");
    }//GEN-LAST:event_odSpontaneousPulsationMinusRadioButton1ActionPerformed

    private void odSpontaneousPulsationXRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odSpontaneousPulsationXRadioButton1ActionPerformed
        currentResults.setSponVeinPulsOD("X");
    }//GEN-LAST:event_odSpontaneousPulsationXRadioButton1ActionPerformed

    private void odVerticalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odVerticalTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_odVerticalTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox DFE1CheckBox2;
    private javax.swing.JCheckBox DFE2CheckBox;
    private javax.swing.JCheckBox DFEContraindicatedCheckBox;
    private javax.swing.JCheckBox DFEDeclinedCheckBox;
    private javax.swing.JCheckBox DFENotIndicatedCheckBox1;
    private javax.swing.JCheckBox DFERefusedCheckBox;
    private javax.swing.JCheckBox FundusPerformedCheckBox1;
    private javax.swing.JComboBox<String> armdComboBox1;
    private javax.swing.JComboBox<String> armdComboBox2;
    private javax.swing.JPanel cupDiscRatioPanel;
    private javax.swing.JComboBox<String> custom1ComboBox1;
    private javax.swing.JComboBox<String> custom1ComboBox2;
    private javax.swing.JComboBox<String> custom2ComboBox1;
    private javax.swing.JComboBox<String> custom2ComboBox2;
    private javax.swing.JComboBox<String> custom3ComboBox1;
    private javax.swing.JComboBox<String> custom3ComboBox2;
    private javax.swing.JCheckBox d20BioCheckBox;
    private javax.swing.JCheckBox d78CheckBox;
    private javax.swing.JCheckBox d90CheckBox;
    private javax.swing.JCheckBox dOpthalmpscopeCheckBox;
    private javax.swing.JRadioButton dfeWithOptomapRadioButton;
    private javax.swing.JComboBox<String> diabeticEvalComboBox1;
    private javax.swing.JComboBox<String> diabeticEvalComboBox2;
    private javax.swing.JRadioButton dilatedEvalRadioButton;
    private javax.swing.JComboBox<String> dilationAgentComboBox;
    private javax.swing.ButtonGroup fundusDilationRadioButtonGroup;
    private javax.swing.JPanel fundusEvalMethodPanel;
    private javax.swing.JRadioButton fundusEvaluationNotPerformedRadioButton;
    private javax.swing.ButtonGroup fundusOptionRadioButtonGroup;
    private javax.swing.JPanel fundusOptionsBttnPanel;
    private javax.swing.JRadioButton gtt1RadioButton;
    private javax.swing.JRadioButton gtt2RadioButton;
    private javax.swing.JComboBox<String> htnEvaluationComboBox1;
    private javax.swing.JComboBox<String> htnEvaluationComboBox2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> maculaComboBox1;
    private javax.swing.JComboBox<String> maculaComboBox2;
    private javax.swing.JComboBox<String> miscRetinaComboBox1;
    private javax.swing.JComboBox<String> miscRetinaComboBox2;
    private javax.swing.JPanel notesPanel;
    private javax.swing.JCheckBox odDeepLaminaCheckBox;
    private javax.swing.JRadioButton odFovealReflexMinusRadioButton1;
    private javax.swing.JRadioButton odFovealReflexPlusRadioButton1;
    private javax.swing.ButtonGroup odFovealReflexRadioButtonGroup;
    private javax.swing.JRadioButton odFovealReflexXRadioButton1;
    private javax.swing.JCheckBox odGlialRemnantsCheckBox;
    private javax.swing.JSlider odHorizontalSlider;
    private javax.swing.JTextField odHorizontalTextField;
    private javax.swing.JCheckBox odMylenationCheckBox;
    private javax.swing.JComboBox<String> odNerveFiberLayerComboBox;
    private javax.swing.JPanel odOpthalmicIndicatorsPanel;
    private javax.swing.JComboBox<String> odOpticNerveComboBox;
    private javax.swing.JCheckBox odOpticPitCheckBox;
    private javax.swing.JCheckBox odOvalCheckBox;
    private javax.swing.JCheckBox odPeripapAtrophyCheckBox;
    private javax.swing.JCheckBox odPigmentCrescentCheckBox;
    private javax.swing.JCheckBox odRoundCheckBox;
    private javax.swing.JCheckBox odScleralCrescentCheckBox;
    private javax.swing.JCheckBox odShallowCheckBox;
    private javax.swing.JRadioButton odSpontaneousPulsationMinusRadioButton1;
    private javax.swing.JRadioButton odSpontaneousPulsationPlusRadioButton1;
    private javax.swing.ButtonGroup odSpontaneousPulsationRadioButtonGroup;
    private javax.swing.JRadioButton odSpontaneousPulsationXRadioButton1;
    private javax.swing.JCheckBox odTempSlopingCheckbox;
    private javax.swing.JCheckBox odUnderminingCheckBox;
    private javax.swing.JSlider odVerticalSlider;
    private javax.swing.JTextField odVerticalTextField;
    private javax.swing.JPanel opthalmicIndcPanel;
    private javax.swing.JRadioButton optomapImagingRadioButton;
    private javax.swing.JCheckBox osDeepLaminaCheckBox;
    private javax.swing.JRadioButton osFovealReflexMinusRadioButton;
    private javax.swing.JRadioButton osFovealReflexPlusRadioButton;
    private javax.swing.ButtonGroup osFovealReflexRadioButtonGroup;
    private javax.swing.JRadioButton osFovealReflexXRadioButton;
    private javax.swing.JCheckBox osGlialRemnantsCheckBox;
    private javax.swing.JSlider osHorizontalSlider;
    private javax.swing.JTextField osHorizontalTextField;
    private javax.swing.JCheckBox osMylenationCheckBox;
    private javax.swing.JComboBox<String> osNerveFiberLayerComboBox;
    private javax.swing.JPanel osOpthalmicIndicatorsPanel;
    private javax.swing.JComboBox<String> osOpticNerveComboBox;
    private javax.swing.JCheckBox osOpticPitCheckBox;
    private javax.swing.JCheckBox osOvalCheckBox;
    private javax.swing.JCheckBox osPeripapAtrophyCheckBox;
    private javax.swing.JCheckBox osPigmentCrescentCheckBox;
    private javax.swing.JCheckBox osRoundCheckBox;
    private javax.swing.JCheckBox osScleralCrescentCheckBox;
    private javax.swing.JCheckBox osShallowCheckBox;
    private javax.swing.JRadioButton osSpontaneousPulsationMinusRadioButton;
    private javax.swing.JRadioButton osSpontaneousPulsationPlusRadioButton;
    private javax.swing.ButtonGroup osSpontaneousPulsationRadioButtonGroup;
    private javax.swing.JRadioButton osSpontaneousPulsationXRadioButton;
    private javax.swing.JCheckBox osTempSlopingCheckBox;
    private javax.swing.JCheckBox osUnderminingCheckBox;
    private javax.swing.JSlider osVerticalSlider;
    private javax.swing.JTextField osVerticalTextField;
    private javax.swing.JCheckBox otherCheckBox7;
    private javax.swing.JTextField otherTextField;
    private javax.swing.JCheckBox pR2BioCheckBox4;
    private javax.swing.JComboBox<String> peripheralRetinaComboBox1;
    private javax.swing.JComboBox<String> peripheralRetinaComboBox2;
    private javax.swing.JComboBox<String> posteriorPoleComboBox1;
    private javax.swing.JComboBox<String> posteriorPoleComboBox2;
    private javax.swing.JPanel posteriorSegTitlePanel;
    private javax.swing.JPanel psPanel;
    private javax.swing.JCheckBox recentDFECheckBox1;
    private javax.swing.JButton saveButton;
    private javax.swing.JCheckBox sdepressionCheckBox;
    private javax.swing.JRadioButton smallPupilBIORadioButton;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JRadioButton undilatedEvalRadioButton;
    private javax.swing.JComboBox<String> vasculatureComboBox1;
    private javax.swing.JComboBox<String> vasculatureComboBox2;
    private javax.swing.JComboBox<String> vitreousComboBox1;
    private javax.swing.JComboBox<String> vitreousComboBox2;
    // End of variables declaration//GEN-END:variables
}
