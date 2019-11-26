
package cs499_ophthalmology_emr;

/**
 * A Java object representing one set of eye test results in the SQL database.
 * 
 */

public class EyeTestResults 
{   private final Integer examID;
    private final Integer patientID;
    private final Integer apptID;
    private String farChartDistance;
    private String dccOS;
    private String dscODph; // Angela
    private String dccOSph;
    private String dscOS;
    private String dscOSph;
    private String dccOD;
    private String dccODph;
    private String dscOD;
    private String dccOU;
    private String dccOUph;
    private String dscOU;
    private String dscOUph; 
    private String nearChartDistance;
    private String nccOS;
    private String nccOSph;
    private String nscOS;
    private String nscOSph;
    private String nccOD;
    private String nccODph;
    private String nscOD;
    private String nccOU;
    private String nccOUph;
    private String nscOU;
    private String nscOUph;
    private Double sphereOD;
    private Double sphereOS;
    private Double cylinderOD;
    private Double cylinderOS;
    private Double axisOD;
    private Double axisOS;
    private Double addOD;
    private Double addOS;
    private Double prismOD;
    private Double prismOS;
    private Double prismBaseOD;
    private Double prismBaseOS;
    private String nn20OD;
    private String dd20OD;
    private String nn20OS;
    private String dd20OS;
    
    private String vitreousOD;
    private String maculaOD;
    private String vasculatureOD;
    private String posteriorPoleOD;
    private String peripheralRetinaOD;
    private String miscRetinaOD;
    private String diabeticEvalOD;
    private String htnEvalOD;
    private String armdOD;
    private String custom1OD;
    private String custom2OD;
    private String custom3OD;
    private String vitreousOS;
    private String maculaOS;
    private String vasculatureOS;
    private String posteriorPoleOS;
    private String peripheralRetinaOS;
    private String miscRetinaOS;
    private String diabeticEvalOS;
    private String htnEvalOS;
    private String armdOS;
    private String custom1OS;
    private String custom2OS;
    private String custom3OS;

    private String sponVeinPulsOD;
    private String fovealReflexOD;
    private String sponVeinPulsOS;
    private String fovealReflexOs;
    private String methodUsed;
    private String gttOD;
    private String gttOS;
    private String dilationAgent;
    private Boolean lens78dUsed;
    private Boolean lens90Dused;
    private Boolean lens20DbioUsed;
    private Boolean LensPR22bioUsed;
    private Boolean ScleralDepUsed;
    private Boolean directOpthScopeUsed;
    private Boolean otherNoteGiven;
    private String otherNoteText;
    private Boolean patientAdvisedDfe;
    private Boolean dfeResched;
    private Boolean dfeDeclined;
    private Boolean fundusImgPerformed;
    private Boolean dfeRefusedAme;
    private Boolean dfeNotInd;
    private Boolean dfeContraind;
    private Boolean recentDfe;
    private Double horizOD;
    private Double horizOS;
    private Double vertOD;
    private Double vertOS;
    private String opticNerveOD;
    private String nerveFiberLayerOD;
	private String opticNerveOS;
    private String nerveFiberLayerOS;
    private Boolean deepLaminaOD;
    private Boolean deepLaminaOS;
    private Boolean shallowOD;
    private Boolean shallowOS;
    private Boolean roundOD;
    private Boolean roundOS;
    private Boolean ovalOD;
    private Boolean ovalOS;
    private Boolean tempSlopingOD;
    private Boolean tempSlopingOS;
    private Boolean underminingOD;
    private Boolean underminingOS;
    private Boolean peripapAtrophyOD;
    private Boolean peripapAtrophyOS;
    private Boolean scleralCrescentOD;
    private Boolean scleralCrescentOS;
    private Boolean pigmentCrescentOD;
    private Boolean pigmentCrescentOS;
    private Boolean opticPitOD;
    private Boolean opticPitOS;
    private Boolean myelinationOD;
    private Boolean myelinationOS;
    private Boolean glialRemOD;
    private Boolean glialRemOS;
	
	public EyeTestResults(Integer _examID, Integer _patientID, Integer _apptID)
	{
		this.examID = _examID;
		this.patientID = _patientID;
		this.apptID = _apptID;
		this.farChartDistance = "";
		this.dccOS = "";
		this.dccOSph = "";
		this.dscOS = "";
                this.dscODph =""; //Angela
		this.dscOSph = "";
		this.dccOD = "";
		this.dccODph = "";
		this.dscOD = "";
		this.dccOU = "";
		this.dccOUph = "";
		this.dscOU = "";
		this.dscOUph = "";
		this.nearChartDistance = "";
		this.nccOS = "";
		this.nccOSph = "";
		this.nscOS = "";
		this.nscOSph = "";
		this.nccOD = "";
		this.nccODph = "";
		this.nscOD = "";
		this.nccOU = "";
		this.nccOUph = "";
		this.nscOU = "";
		this.nscOUph = "";
		this.sphereOD = -1.0;
		this.sphereOS = -1.0;
		this.cylinderOD = -1.0;
		this.cylinderOS = -1.0;
		this.axisOD = -1.0;
		this.axisOS = -1.0;
		this.addOD = -1.0;
		this.addOS = -1.0;
		this.prismOD = -1.0;
		this.prismOS = -1.0;
		this.prismBaseOD = -1.0;
		this.prismBaseOS = -1.0;
		this.nn20OD = "";
		this.dd20OD = "";
		this.nn20OS = "";
		this.dd20OS = "";
		this.vitreousOD = "NOT CHECKED";
		this.maculaOD = "NOT CHECKED";
		this.vasculatureOD = "NOT CHECKED";
		this.posteriorPoleOD = "NOT CHECKED";
		this.peripheralRetinaOD = "NOT CHECKED";
		this.miscRetinaOD = "NOT CHECKED";
		this.diabeticEvalOD = "NOT CHECKED";
		this.htnEvalOD = "NOT CHECKED";
		this.armdOD = "NOT CHECKED";
		this.custom1OD = "NOT CHECKED";
		this.custom2OD = "NOT CHECKED";
		this.custom3OD = "NOT CHECKED";
		this.vitreousOS = "NOT CHECKED";
		this.maculaOS = "NOT CHECKED";
		this.vasculatureOS = "NOT CHECKED";
		this.posteriorPoleOS = "NOT CHECKED";
		this.peripheralRetinaOS = "NOT CHECKED";
		this.miscRetinaOS = "NOT CHECKED";
		this.diabeticEvalOS = "NOT CHECKED";
		this.htnEvalOS = "NOT CHECKED";
		this.armdOS = "NOT CHECKED";
		this.custom1OS = "NOT CHECKED";
		this.custom2OS = "NOT CHECKED";
		this.custom3OS = "NOT CHECKED";
		this.sponVeinPulsOD = "X";
		this.fovealReflexOD = "X";
		this.sponVeinPulsOS = "X";
		this.fovealReflexOs = "X";
		this.methodUsed = "Not Performed";
		this.gttOD = "1";
		this.gttOS = "1";
		this.dilationAgent = "None";
		this.lens78dUsed = false;
		this.lens90Dused = false;
		this.lens20DbioUsed = false;
		this.LensPR22bioUsed = false;
		this.ScleralDepUsed = false;
		this.directOpthScopeUsed = false;
		this.otherNoteGiven = false;
		this.otherNoteText = "";
		this.patientAdvisedDfe = false;
		this.dfeResched = false;
		this.dfeDeclined = false;
		this.fundusImgPerformed = false;
		this.dfeRefusedAme = false;
		this.dfeNotInd = false;
		this.dfeContraind = false;
		this.recentDfe = false;
		this.horizOD = 0.0;
		this.horizOS = 0.0;
		this.vertOD = 0.0;
		this.vertOS = 0.0;
		this.opticNerveOD = "NOT CHECKED";
		this.nerveFiberLayerOD = "NOT CHECKED";
		this.opticNerveOS = "NOT CHECKED";
		this.nerveFiberLayerOS = "NOT CHECKED";
		this.deepLaminaOD = false;
		this.deepLaminaOS = false;
		this.shallowOD = false;
		this.shallowOS = false;
		this.roundOD = false;
		this.roundOS = false;
		this.ovalOD = false;
		this.ovalOS = false;
		this.tempSlopingOD = false;
		this.tempSlopingOS = false;
		this.underminingOD = false;
		this.underminingOS = false;
		this.peripapAtrophyOD = false;
		this.peripapAtrophyOS = false;
		this.scleralCrescentOD = false;
		this.scleralCrescentOS = false;
		this.pigmentCrescentOD = false;
		this.pigmentCrescentOS = false;
		this.opticPitOD = false;
		this.opticPitOS = false;
		this.myelinationOD = false;
		this.myelinationOS = false;
		this.glialRemOD = false;
		this.glialRemOS = false;
	}

	public Integer getExamID()
	{
		return this.examID;
	}
	
	public Integer getApptID()
	{
		return this.apptID;
	}
	
	public Integer getPatientID()
	{
		return this.patientID;
	}
	
	public String getFarChartDistance() {
		return farChartDistance;
	}

	public void setFarChartDistance(String farChartDistance) {
		this.farChartDistance = farChartDistance;
	}

	public String getDccOS() {
		return dccOS;
	}

	public void setDccOS(String dccOS) {
		this.dccOS = dccOS;
	}

	public String getDccOSph() {
		return dccOSph;
	}

	public void setDccOSph(String dccOSph) {
		this.dccOSph = dccOSph;
	}

	public String getDscOS() {
		return dscOS;
	}

	public void setDscOS(String dscOS) {
		this.dscOS = dscOS;
	}
        // Angela added this ------
        public String getDscODph() {
		return dscODph;
	}
        public void setDscODph(String dscODph) {
		this.dscODph = dscODph;
	}
        // -------------------------
	public String getDscOSph() {
		return dscOSph;
	}

	public void setDscOSph(String dscOSph) {
		this.dscOSph = dscOSph;
	}

	public String getDccOD() {
		return dccOD;
	}

	public void setDccOD(String dccOD) {
		this.dccOD = dccOD;
	}

	public String getDccODph() {
		return dccODph;
	}

	public void setDccODph(String dccODph) {
		this.dccODph = dccODph;
	}

	public String getDscOD() {
		return dscOD;
	}

	public void setDscOD(String dscOD) {
		this.dscOD = dscOD;
	}

	public String getDccOU() {
		return dccOU;
	}

	public void setDccOU(String dccOU) {
		this.dccOU = dccOU;
	}

	public String getDccOUph() {
		return dccOUph;
	}

	public void setDccOUph(String dccOUph) {
		this.dccOUph = dccOUph;
	}

	public String getDscOU() {
		return dscOU;
	}

	public void setDscOU(String dscOU) {
		this.dscOU = dscOU;
	}

	public String getDscOUph() {
		return dscOUph;
	}

	public void setDscOUph(String dscOUph) {
		this.dscOUph = dscOUph;
	}

	public String getNearChartDistance() {
		return nearChartDistance;
	}

	public void setNearChartDistance(String nearChartDistance) {
		this.nearChartDistance = nearChartDistance;
	}

	public String getNccOS() {
		return nccOS;
	}

	public void setNccOS(String nccOS) {
		this.nccOS = nccOS;
	}

	public String getNccOSph() {
		return nccOSph;
	}

	public void setNccOSph(String nccOSph) {
		this.nccOSph = nccOSph;
	}

	public String getNscOS() {
		return nscOS;
	}

	public void setNscOS(String nscOS) {
		this.nscOS = nscOS;
	}

	public String getNscOSph() {
		return nscOSph;
	}

	public void setNscOSph(String nscOSph) {
		this.nscOSph = nscOSph;
	}

	public String getNccOD() {
		return nccOD;
	}

	public void setNccOD(String nccOD) {
		this.nccOD = nccOD;
	}

	public String getNccODph() {
		return nccODph;
	}

	public void setNccODph(String nccODph) {
		this.nccODph = nccODph;
	}

	public String getNscOD() {
		return nscOD;
	}

	public void setNscOD(String nscOD) {
		this.nscOD = nscOD;
	}

	public String getNccOU() {
		return nccOU;
	}

	public void setNccOU(String nccOU) {
		this.nccOU = nccOU;
	}

	public String getNccOUph() {
		return nccOUph;
	}

	public void setNccOUph(String nccOUph) {
		this.nccOUph = nccOUph;
	}

	public String getNscOU() {
		return nscOU;
	}

	public void setNscOU(String nscOU) {
		this.nscOU = nscOU;
	}

	public String getNscOUph() {
		return nscOUph;
	}

	public void setNscOUph(String nscOUph) {
		this.nscOUph = nscOUph;
	}

	public Double getSphereOD() {
		return sphereOD;
	}

	public void setSphereOD(Double sphereOD) {
		this.sphereOD = sphereOD;
	}

	public Double getSphereOS() {
		return sphereOS;
	}

	public void setSphereOS(Double sphereOS) {
		this.sphereOS = sphereOS;
	}

	public Double getCylinderOD() {
		return cylinderOD;
	}

	public void setCylinderOD(Double cylinderOD) {
		this.cylinderOD = cylinderOD;
	}

	public Double getCylinderOS() {
		return cylinderOS;
	}

	public void setCylinderOS(Double cylinderOS) {
		this.cylinderOS = cylinderOS;
	}

	public Double getAxisOD() {
		return axisOD;
	}

	public void setAxisOD(Double axisOD) {
		this.axisOD = axisOD;
	}

	public Double getAxisOS() {
		return axisOS;
	}

	public void setAxisOS(Double axisOS) {
		this.axisOS = axisOS;
	}

	public Double getAddOD() {
		return addOD;
	}

	public void setAddOD(Double addOD) {
		this.addOD = addOD;
	}

	public Double getAddOS() {
		return addOS;
	}

	public void setAddOS(Double addOS) {
		this.addOS = addOS;
	}

	public Double getPrismOD() {
		return prismOD;
	}

	public void setPrismOD(Double prismOD) {
		this.prismOD = prismOD;
	}

	public Double getPrismOS() {
		return prismOS;
	}

	public void setPrismOS(Double prismOS) {
		this.prismOS = prismOS;
	}

	public Double getPrismBaseOD() {
		return prismBaseOD;
	}

	public void setPrismBaseOD(Double prismBaseOD) {
		this.prismBaseOD = prismBaseOD;
	}

	public Double getPrismBaseOS() {
		return prismBaseOS;
	}

	public void setPrismBaseOS(Double prismBaseOS) {
		this.prismBaseOS = prismBaseOS;
	}

	public String getNn20OD() {
		return nn20OD;
	}

	public void setNn20OD(String nn20OD) {
		this.nn20OD = nn20OD;
	}

	public String getDd20OD() {
		return dd20OD;
	}

	public void setDd20OD(String dd20OD) {
		this.dd20OD = dd20OD;
	}

	public String getNn20OS() {
		return nn20OS;
	}

	public void setNn20OS(String nn20OS) {
		this.nn20OS = nn20OS;
	}

	public String getDd20OS() {
		return dd20OS;
	}

	public void setDd20OS(String dd20OS) {
		this.dd20OS = dd20OS;
	}

	public String getVitreousOD() {
		return vitreousOD;
	}

	public void setVitreousOD(String vitreousOD) {
		this.vitreousOD = vitreousOD;
	}

	public String getMaculaOD() {
		return maculaOD;
	}

	public void setMaculaOD(String maculaOD) {
		this.maculaOD = maculaOD;
	}

	public String getVasculatureOD() {
		return vasculatureOD;
	}

	public void setVasculatureOD(String vasculatureOD) {
		this.vasculatureOD = vasculatureOD;
	}

	public String getPosteriorPoleOD() {
		return posteriorPoleOD;
	}

	public void setPosteriorPoleOD(String posteriorPoleOD) {
		this.posteriorPoleOD = posteriorPoleOD;
	}

	public String getPeripheralRetinaOD() {
		return peripheralRetinaOD;
	}

	public void setPeripheralRetinaOD(String peripheralRetinaOD) {
		this.peripheralRetinaOD = peripheralRetinaOD;
	}

	public String getMiscRetinaOD() {
		return miscRetinaOD;
	}

	public void setMiscRetinaOD(String miscRetinaOD) {
		this.miscRetinaOD = miscRetinaOD;
	}

	public String getDiabeticEvalOD() {
		return diabeticEvalOD;
	}

	public void setDiabeticEvalOD(String diabeticEvalOD) {
		this.diabeticEvalOD = diabeticEvalOD;
	}

	public String getHtnEvalOD() {
		return htnEvalOD;
	}

	public void setHtnEvalOD(String htnEvalOD) {
		this.htnEvalOD = htnEvalOD;
	}

	public String getArmdOD() {
		return armdOD;
	}

	public void setArmdOD(String armdOD) {
		this.armdOD = armdOD;
	}

	public String getCustom1OD() {
		return custom1OD;
	}

	public void setCustom1OD(String custom1OD) {
		this.custom1OD = custom1OD;
	}

	public String getCustom2OD() {
		return custom2OD;
	}

	public void setCustom2OD(String custom2OD) {
		this.custom2OD = custom2OD;
	}

	public String getCustom3OD() {
		return custom3OD;
	}

	public void setCustom3OD(String custom3OD) {
		this.custom3OD = custom3OD;
	}

	public String getVitreousOS() {
		return vitreousOS;
	}

	public void setVitreousOS(String vitreousOS) {
		this.vitreousOS = vitreousOS;
	}

	public String getMaculaOS() {
		return maculaOS;
	}

	public void setMaculaOS(String maculaOS) {
		this.maculaOS = maculaOS;
	}

	public String getVasculatureOS() {
		return vasculatureOS;
	}

	public void setVasculatureOS(String vasculatureOS) {
		this.vasculatureOS = vasculatureOS;
	}

	public String getPosteriorPoleOS() {
		return posteriorPoleOS;
	}

	public void setPosteriorPoleOS(String posteriorPoleOS) {
		this.posteriorPoleOS = posteriorPoleOS;
	}

	public String getPeripheralRetinaOS() {
		return peripheralRetinaOS;
	}

	public void setPeripheralRetinaOS(String peripheralRetinaOS) {
		this.peripheralRetinaOS = peripheralRetinaOS;
	}

	public String getMiscRetinaOS() {
		return miscRetinaOS;
	}

	public void setMiscRetinaOS(String miscRetinaOS) {
		this.miscRetinaOS = miscRetinaOS;
	}

	public String getDiabeticEvalOS() {
		return diabeticEvalOS;
	}

	public void setDiabeticEvalOS(String diabeticEvalOS) {
		this.diabeticEvalOS = diabeticEvalOS;
	}

	public String getHtnEvalOS() {
		return htnEvalOS;
	}

	public void setHtnEvalOS(String htnEvalOS) {
		this.htnEvalOS = htnEvalOS;
	}

	public String getArmdOS() {
		return armdOS;
	}

	public void setArmdOS(String armdOS) {
		this.armdOS = armdOS;
	}

	public String getCustom1OS() {
		return custom1OS;
	}

	public void setCustom1OS(String custom1OS) {
		this.custom1OS = custom1OS;
	}

	public String getCustom2OS() {
		return custom2OS;
	}

	public void setCustom2OS(String custom2OS) {
		this.custom2OS = custom2OS;
	}

	public String getCustom3OS() {
		return custom3OS;
	}

	public void setCustom3OS(String custom3OS) {
		this.custom3OS = custom3OS;
	}

	public String getSponVeinPulsOD() {
		return sponVeinPulsOD;
	}

	public void setSponVeinPulsOD(String sponVeinPulsOD) {
		this.sponVeinPulsOD = sponVeinPulsOD;
	}

	public String getFovealReflexOD() {
		return fovealReflexOD;
	}

	public void setFovealReflexOD(String fovealReflexOD) {
		this.fovealReflexOD = fovealReflexOD;
	}

	public String getSponVeinPulsOS() {
		return sponVeinPulsOS;
	}

	public void setSponVeinPulsOS(String sponVeinPulsOS) {
		this.sponVeinPulsOS = sponVeinPulsOS;
	}

	public String getFovealReflexOs() {
		return fovealReflexOs;
	}

	public void setFovealReflexOs(String fovealReflexOs) {
		this.fovealReflexOs = fovealReflexOs;
	}

	public String getMethodUsed() {
		return methodUsed;
	}

	public void setMethodUsed(String methodUsed) {
		this.methodUsed = methodUsed;
	}

	public String getGttOD() {
		return gttOD;
	}

	public void setGttOD(String gttOD) {
		this.gttOD = gttOD;
	}

	public String getGttOS() {
		return gttOS;
	}

	public void setGttOS(String gttOS) {
		this.gttOS = gttOS;
	}

	public String getDilationAgent() {
		return dilationAgent;
	}

	public void setDilationAgent(String dilationAgent) {
		this.dilationAgent = dilationAgent;
	}

	public Boolean getLens78dUsed() {
		return lens78dUsed;
	}

	public void setLens78dUsed(Boolean lens78dUsed) {
		this.lens78dUsed = lens78dUsed;
	}

	public Boolean getLens90Dused() {
		return lens90Dused;
	}

	public void setLens90Dused(Boolean lens90Dused) {
		this.lens90Dused = lens90Dused;
	}

	public Boolean getLens20DbioUsed() {
		return lens20DbioUsed;
	}

	public void setLens20DbioUsed(Boolean lens20DbioUsed) {
		this.lens20DbioUsed = lens20DbioUsed;
	}

	public Boolean getLensPR22bioUsed() {
		return LensPR22bioUsed;
	}

	public void setLensPR22bioUsed(Boolean LensPR22bioUsed) {
		this.LensPR22bioUsed = LensPR22bioUsed;
	}

	public Boolean getScleralDepUsed() {
		return ScleralDepUsed;
	}

	public void setScleralDepUsed(Boolean ScleralDepUsed) {
		this.ScleralDepUsed = ScleralDepUsed;
	}

	public Boolean getDirectOpthScopeUsed() {
		return directOpthScopeUsed;
	}

	public void setDirectOpthScopeUsed(Boolean directOpthScopeUsed) {
		this.directOpthScopeUsed = directOpthScopeUsed;
	}

	public Boolean getOtherNoteGiven() {
		return otherNoteGiven;
	}

	public void setOtherNoteGiven(Boolean otherNoteGiven) {
		this.otherNoteGiven = otherNoteGiven;
	}

	public String getOtherNoteText() {
		return otherNoteText;
	}

	public void setOtherNoteText(String otherNoteText) {
		this.otherNoteText = otherNoteText;
	}

	public Boolean getPatientAdvisedDfe() {
		return patientAdvisedDfe;
	}

	public void setPatientAdvisedDfe(Boolean patientAdvisedDfe) {
		this.patientAdvisedDfe = patientAdvisedDfe;
	}

	public Boolean getDfeResched() {
		return dfeResched;
	}

	public void setDfeResched(Boolean dfeResched) {
		this.dfeResched = dfeResched;
	}

	public Boolean getDfeDeclined() {
		return dfeDeclined;
	}

	public void setDfeDeclined(Boolean dfeDeclined) {
		this.dfeDeclined = dfeDeclined;
	}

	public Boolean getFundusImgPerformed() {
		return fundusImgPerformed;
	}

	public void setFundusImgPerformed(Boolean fundusImgPerformed) {
		this.fundusImgPerformed = fundusImgPerformed;
	}

	public Boolean getDfeRefusedAme() {
		return dfeRefusedAme;
	}

	public void setDfeRefusedAme(Boolean dfeRefusedAme) {
		this.dfeRefusedAme = dfeRefusedAme;
	}

	public Boolean getDfeNotInd() {
		return dfeNotInd;
	}

	public void setDfeNotInd(Boolean dfeNotInd) {
		this.dfeNotInd = dfeNotInd;
	}

	public Boolean getDfeContraind() {
		return dfeContraind;
	}

	public void setDfeContraind(Boolean dfeContraind) {
		this.dfeContraind = dfeContraind;
	}

	public Boolean getRecentDfe() {
		return recentDfe;
	}

	public void setRecentDfe(Boolean recentDfe) {
		this.recentDfe = recentDfe;
	}

	public Double getHorizOD() {
		return horizOD;
	}

	public void setHorizOD(Double horizOD) {
		this.horizOD = horizOD;
	}

	public Double getHorizOS() {
		return horizOS;
	}

	public void setHorizOS(Double horizOS) {
		this.horizOS = horizOS;
	}

	public Double getVertOD() {
		return vertOD;
	}

	public void setVertOD(Double vertOD) {
		this.vertOD = vertOD;
	}

	public Double getVertOS() {
		return vertOS;
	}

	public void setVertOS(Double vertOS) {
		this.vertOS = vertOS;
	}

	public String getOpticNerveOD() {
		return opticNerveOD;
	}

	public void setOpticNerveOD(String opticNerve) {
		this.opticNerveOD = opticNerve;
	}

	public String getNerveFiberLayerOD() {
		return nerveFiberLayerOD;
	}

	public void setNerveFiberLayerOD(String nerveFiberLayer) {
		this.nerveFiberLayerOD = nerveFiberLayer;
	}

	public String getOpticNerveOS() {
		return opticNerveOS;
	}

	public void setOpticNerveOS(String opticNerveOS) {
		this.opticNerveOS = opticNerveOS;
	}

	public String getNerveFiberLayerOS() {
		return nerveFiberLayerOS;
	}

	public void setNerveFiberLayerOS(String nerveFiberLayerOS) {
		this.nerveFiberLayerOS = nerveFiberLayerOS;
	}
	
	

	public Boolean getDeepLaminaOD() {
		return deepLaminaOD;
	}

	public void setDeepLaminaOD(Boolean deepLaminaOD) {
		this.deepLaminaOD = deepLaminaOD;
	}

	public Boolean getDeepLaminaOS() {
		return deepLaminaOS;
	}

	public void setDeepLaminaOS(Boolean deepLaminaOS) {
		this.deepLaminaOS = deepLaminaOS;
	}

	public Boolean getShallowOD() {
		return shallowOD;
	}

	public void setShallowOD(Boolean shallowOD) {
		this.shallowOD = shallowOD;
	}

	public Boolean getShallowOS() {
		return shallowOS;
	}

	public void setShallowOS(Boolean shallowOS) {
		this.shallowOS = shallowOS;
	}

	public Boolean getRoundOD() {
		return roundOD;
	}

	public void setRoundOD(Boolean roundOD) {
		this.roundOD = roundOD;
	}

	public Boolean getRoundOS() {
		return roundOS;
	}

	public void setRoundOS(Boolean roundOS) {
		this.roundOS = roundOS;
	}

	public Boolean getOvalOD() {
		return ovalOD;
	}

	public void setOvalOD(Boolean ovalOD) {
		this.ovalOD = ovalOD;
	}

	public Boolean getOvalOS() {
		return ovalOS;
	}

	public void setOvalOS(Boolean ovalOS) {
		this.ovalOS = ovalOS;
	}

	public Boolean getTempSlopingOD() {
		return tempSlopingOD;
	}

	public void setTempSlopingOD(Boolean tempSlopingOD) {
		this.tempSlopingOD = tempSlopingOD;
	}

	public Boolean getTempSlopingOS() {
		return tempSlopingOS;
	}

	public void setTempSlopingOS(Boolean tempSlopingOS) {
		this.tempSlopingOS = tempSlopingOS;
	}

	public Boolean getUnderminingOD() {
		return underminingOD;
	}

	public void setUnderminingOD(Boolean underminingOD) {
		this.underminingOD = underminingOD;
	}

	public Boolean getUnderminingOS() {
		return underminingOS;
	}

	public void setUnderminingOS(Boolean underminingOS) {
		this.underminingOS = underminingOS;
	}

	public Boolean getPeripapAtrophyOD() {
		return peripapAtrophyOD;
	}

	public void setPeripapAtrophyOD(Boolean peripapAtrophyOD) {
		this.peripapAtrophyOD = peripapAtrophyOD;
	}

	public Boolean getPeripapAtrophyOS() {
		return peripapAtrophyOS;
	}

	public void setPeripapAtrophyOS(Boolean peripapAtrophyOS) {
		this.peripapAtrophyOS = peripapAtrophyOS;
	}

	public Boolean getScleralCrescentOD() {
		return scleralCrescentOD;
	}

	public void setScleralCrescentOD(Boolean scleralCrescentOD) {
		this.scleralCrescentOD = scleralCrescentOD;
	}

	public Boolean getScleralCrescentOS() {
		return scleralCrescentOS;
	}

	public void setScleralCrescentOS(Boolean scleralCrescentOS) {
		this.scleralCrescentOS = scleralCrescentOS;
	}

	public Boolean getPigmentCrescentOD() {
		return pigmentCrescentOD;
	}

	public void setPigmentCrescentOD(Boolean pigmentCrescentOD) {
		this.pigmentCrescentOD = pigmentCrescentOD;
	}

	public Boolean getPigmentCrescentOS() {
		return pigmentCrescentOS;
	}

	public void setPigmentCrescentOS(Boolean pigmentCrescentOS) {
		this.pigmentCrescentOS = pigmentCrescentOS;
	}

	public Boolean getOpticPitOD() {
		return opticPitOD;
	}

	public void setOpticPitOD(Boolean opticPitOD) {
		this.opticPitOD = opticPitOD;
	}

	public Boolean getOpticPitOS() {
		return opticPitOS;
	}

	public void setOpticPitOS(Boolean opticPitOS) {
		this.opticPitOS = opticPitOS;
	}

	public Boolean getMyelinationOD() {
		return myelinationOD;
	}

	public void setMyelinationOD(Boolean myelinationOD) {
		this.myelinationOD = myelinationOD;
	}

	public Boolean getMyelinationOS() {
		return myelinationOS;
	}

	public void setMyelinationOS(Boolean myelinationOS) {
		this.myelinationOS = myelinationOS;
	}

	public Boolean getGlialRemOD() {
		return glialRemOD;
	}

	public void setGlialRemOD(Boolean glialRemOD) {
		this.glialRemOD = glialRemOD;
	}

	public Boolean getGlialRemOS() {
		return glialRemOS;
	}

	public void setGlialRemOS(Boolean glialRemOS) {
		this.glialRemOS = glialRemOS;
	}
	
}
