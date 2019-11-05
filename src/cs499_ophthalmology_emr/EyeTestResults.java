
package cs499_ophthalmology_emr;

/**
 * A Java object representing one set of eye test results in the SQL database.
 * 
 */

public class EyeTestResults 
{	private final Integer examID;
	private final Integer patientID;
	private final Integer apptID;
    private Integer farChartDistance;
    private Integer dccOS;
    private Integer dccOSph;
    private Integer dscOS;
    private Integer dscOSph;
    private Integer dccOD;
    private Integer dccODph;
    private Integer dscOD;
    private Integer dccOU;
    private Integer dccOUph;
    private Integer dscOU;
    private Integer dscOUph;
    private Integer nearChartDistance;
    private Integer nccOS;
    private Integer nccOSph;
    private Integer nscOS;
    private Integer nscOSph;
    private Integer nccOD;
    private Integer nccODph;
    private Integer nscOD;
    private Integer nccOU;
    private Integer nccOUph;
    private Integer nscOU;
    private Integer nscOUph;
    private Double sphereOD;
    private Double sphereOS;
    private Double cylinderOD;
    private Double cylinderOS;
    private Double axisOD;
    private Double axisOS;
    private Double prismOD;
    private Double prismOS;
    private Double prismBaseOD;
    private Double prismBaseOS;
    private Integer nn20;
    private Integer dd20;
    
    private Integer vitreousOD;
    private Integer maculaOD;
    private Integer vasculatureOD;
    private Integer posteriorPoleOD;
    private Integer peripheralRetinaOD;
    private Integer miscRetinaOD;
    private Integer diabeticEvalOD;
    private Integer htnEvalOD;
    private Integer armdOD;
    private Integer custom1OD;
    private Integer custom2OD;
    private Integer custom3OD;
    private Integer vitreousOS;
    private Integer maculaOS;
    private Integer vasculatureOS;
    private Integer posteriorPoleOS;
    private Integer peripheralRetinaOS;
    private Integer miscRetinaOS;
    private Integer diabeticEvalOS;
    private Integer htnEvalOS;
    private Integer armdOS;
    private Integer custom1OS;
    private Integer custom2OS;
    private Integer custom3OS;

    private Integer sponVeinPulsOD;
    private Integer fovealReflexOD;
    private Integer sponVeinPulsOS;
    private Integer fovealReflexOs;
    private Integer methodUsed;
    private Integer gttOD;
    private Integer gttOS;
    private Integer dilationAgent;
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
    private Integer opticNerve;
    private Integer nerveFiberLayer;
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
		this.farChartDistance = -1;
		this.dccOS = -1;
		this.dccOSph = -1;
		this.dscOS = -1;
		this.dscOSph = -1;
		this.dccOD = -1;
		this.dccODph = -1;
		this.dscOD = -1;
		this.dccOU = -1;
		this.dccOUph = -1;
		this.dscOU = -1;
		this.dscOUph = -1;
		this.nearChartDistance = -1;
		this.nccOS = -1;
		this.nccOSph = -1;
		this.nscOS = -1;
		this.nscOSph = -1;
		this.nccOD = -1;
		this.nccODph = -1;
		this.nscOD = -1;
		this.nccOU = -1;
		this.nccOUph = -1;
		this.nscOU = -1;
		this.nscOUph = -1;
		this.sphereOD = -1.0;
		this.sphereOS = -1.0;
		this.cylinderOD = -1.0;
		this.cylinderOS = -1.0;
		this.axisOD = -1.0;
		this.axisOS = -1.0;
		this.prismOD = -1.0;
		this.prismOS = -1.0;
		this.prismBaseOD = -1.0;
		this.prismBaseOS = -1.0;
		this.nn20 = -1;
		this.dd20 = -1;
		this.vitreousOD = -1;
		this.maculaOD = -1;
		this.vasculatureOD = -1;
		this.posteriorPoleOD = -1;
		this.peripheralRetinaOD = -1;
		this.miscRetinaOD = -1;
		this.diabeticEvalOD = -1;
		this.htnEvalOD = -1;
		this.armdOD = -1;
		this.custom1OD = -1;
		this.custom2OD = -1;
		this.custom3OD = -1;
		this.vitreousOS = -1;
		this.maculaOS = -1;
		this.vasculatureOS = -1;
		this.posteriorPoleOS = -1;
		this.peripheralRetinaOS = -1;
		this.miscRetinaOS = -1;
		this.diabeticEvalOS = -1;
		this.htnEvalOS = -1;
		this.armdOS = -1;
		this.custom1OS = -1;
		this.custom2OS = -1;
		this.custom3OS = -1;
		this.sponVeinPulsOD = -1;
		this.fovealReflexOD = -1;
		this.sponVeinPulsOS = -1;
		this.fovealReflexOs = -1;
		this.methodUsed = -1;
		this.gttOD = -1;
		this.gttOS = -1;
		this.dilationAgent = -1;
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
		this.horizOD = -1.0;
		this.horizOS = -1.0;
		this.vertOD = -1.0;
		this.vertOS = -1.0;
		this.opticNerve = -1;
		this.nerveFiberLayer = -1;
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
	
	public Integer getFarChartDistance() {
		return farChartDistance;
	}

	public void setFarChartDistance(Integer farChartDistance) {
		this.farChartDistance = farChartDistance;
	}

	public Integer getDccOS() {
		return dccOS;
	}

	public void setDccOS(Integer dccOS) {
		this.dccOS = dccOS;
	}

	public Integer getDccOSph() {
		return dccOSph;
	}

	public void setDccOSph(Integer dccOSph) {
		this.dccOSph = dccOSph;
	}

	public Integer getDscOS() {
		return dscOS;
	}

	public void setDscOS(Integer dscOS) {
		this.dscOS = dscOS;
	}

	public Integer getDscOSph() {
		return dscOSph;
	}

	public void setDscOSph(Integer dscOSph) {
		this.dscOSph = dscOSph;
	}

	public Integer getDccOD() {
		return dccOD;
	}

	public void setDccOD(Integer dccOD) {
		this.dccOD = dccOD;
	}

	public Integer getDccODph() {
		return dccODph;
	}

	public void setDccODph(Integer dccODph) {
		this.dccODph = dccODph;
	}

	public Integer getDscOD() {
		return dscOD;
	}

	public void setDscOD(Integer dscOD) {
		this.dscOD = dscOD;
	}

	public Integer getDccOU() {
		return dccOU;
	}

	public void setDccOU(Integer dccOU) {
		this.dccOU = dccOU;
	}

	public Integer getDccOUph() {
		return dccOUph;
	}

	public void setDccOUph(Integer dccOUph) {
		this.dccOUph = dccOUph;
	}

	public Integer getDscOU() {
		return dscOU;
	}

	public void setDscOU(Integer dscOU) {
		this.dscOU = dscOU;
	}

	public Integer getDscOUph() {
		return dscOUph;
	}

	public void setDscOUph(Integer dscOUph) {
		this.dscOUph = dscOUph;
	}

	public Integer getNearChartDistance() {
		return nearChartDistance;
	}

	public void setNearChartDistance(Integer nearChartDistance) {
		this.nearChartDistance = nearChartDistance;
	}

	public Integer getNccOS() {
		return nccOS;
	}

	public void setNccOS(Integer nccOS) {
		this.nccOS = nccOS;
	}

	public Integer getNccOSph() {
		return nccOSph;
	}

	public void setNccOSph(Integer nccOSph) {
		this.nccOSph = nccOSph;
	}

	public Integer getNscOS() {
		return nscOS;
	}

	public void setNscOS(Integer nscOS) {
		this.nscOS = nscOS;
	}

	public Integer getNscOSph() {
		return nscOSph;
	}

	public void setNscOSph(Integer nscOSph) {
		this.nscOSph = nscOSph;
	}

	public Integer getNccOD() {
		return nccOD;
	}

	public void setNccOD(Integer nccOD) {
		this.nccOD = nccOD;
	}

	public Integer getNccODph() {
		return nccODph;
	}

	public void setNccODph(Integer nccODph) {
		this.nccODph = nccODph;
	}

	public Integer getNscOD() {
		return nscOD;
	}

	public void setNscOD(Integer nscOD) {
		this.nscOD = nscOD;
	}

	public Integer getNccOU() {
		return nccOU;
	}

	public void setNccOU(Integer nccOU) {
		this.nccOU = nccOU;
	}

	public Integer getNccOUph() {
		return nccOUph;
	}

	public void setNccOUph(Integer nccOUph) {
		this.nccOUph = nccOUph;
	}

	public Integer getNscOU() {
		return nscOU;
	}

	public void setNscOU(Integer nscOU) {
		this.nscOU = nscOU;
	}

	public Integer getNscOUph() {
		return nscOUph;
	}

	public void setNscOUph(Integer nscOUph) {
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

	public Integer getNn20() {
		return nn20;
	}

	public void setNn20(Integer nn20) {
		this.nn20 = nn20;
	}

	public Integer getDd20() {
		return dd20;
	}

	public void setDd20(Integer dd20) {
		this.dd20 = dd20;
	}

	public Integer getVitreousOD() {
		return vitreousOD;
	}

	public void setVitreousOD(Integer vitreousOD) {
		this.vitreousOD = vitreousOD;
	}

	public Integer getMaculaOD() {
		return maculaOD;
	}

	public void setMaculaOD(Integer maculaOD) {
		this.maculaOD = maculaOD;
	}

	public Integer getVasculatureOD() {
		return vasculatureOD;
	}

	public void setVasculatureOD(Integer vasculatureOD) {
		this.vasculatureOD = vasculatureOD;
	}

	public Integer getPosteriorPoleOD() {
		return posteriorPoleOD;
	}

	public void setPosteriorPoleOD(Integer posteriorPoleOD) {
		this.posteriorPoleOD = posteriorPoleOD;
	}

	public Integer getPeripheralRetinaOD() {
		return peripheralRetinaOD;
	}

	public void setPeripheralRetinaOD(Integer peripheralRetinaOD) {
		this.peripheralRetinaOD = peripheralRetinaOD;
	}

	public Integer getMiscRetinaOD() {
		return miscRetinaOD;
	}

	public void setMiscRetinaOD(Integer miscRetinaOD) {
		this.miscRetinaOD = miscRetinaOD;
	}

	public Integer getDiabeticEvalOD() {
		return diabeticEvalOD;
	}

	public void setDiabeticEvalOD(Integer diabeticEvalOD) {
		this.diabeticEvalOD = diabeticEvalOD;
	}

	public Integer getHtnEvalOD() {
		return htnEvalOD;
	}

	public void setHtnEvalOD(Integer htnEvalOD) {
		this.htnEvalOD = htnEvalOD;
	}

	public Integer getArmdOD() {
		return armdOD;
	}

	public void setArmdOD(Integer armdOD) {
		this.armdOD = armdOD;
	}

	public Integer getCustom1OD() {
		return custom1OD;
	}

	public void setCustom1OD(Integer custom1OD) {
		this.custom1OD = custom1OD;
	}

	public Integer getCustom2OD() {
		return custom2OD;
	}

	public void setCustom2OD(Integer custom2OD) {
		this.custom2OD = custom2OD;
	}

	public Integer getCustom3OD() {
		return custom3OD;
	}

	public void setCustom3OD(Integer custom3OD) {
		this.custom3OD = custom3OD;
	}

	public Integer getVitreousOS() {
		return vitreousOS;
	}

	public void setVitreousOS(Integer vitreousOS) {
		this.vitreousOS = vitreousOS;
	}

	public Integer getMaculaOS() {
		return maculaOS;
	}

	public void setMaculaOS(Integer maculaOS) {
		this.maculaOS = maculaOS;
	}

	public Integer getVasculatureOS() {
		return vasculatureOS;
	}

	public void setVasculatureOS(Integer vasculatureOS) {
		this.vasculatureOS = vasculatureOS;
	}

	public Integer getPosteriorPoleOS() {
		return posteriorPoleOS;
	}

	public void setPosteriorPoleOS(Integer posteriorPoleOS) {
		this.posteriorPoleOS = posteriorPoleOS;
	}

	public Integer getPeripheralRetinaOS() {
		return peripheralRetinaOS;
	}

	public void setPeripheralRetinaOS(Integer peripheralRetinaOS) {
		this.peripheralRetinaOS = peripheralRetinaOS;
	}

	public Integer getMiscRetinaOS() {
		return miscRetinaOS;
	}

	public void setMiscRetinaOS(Integer miscRetinaOS) {
		this.miscRetinaOS = miscRetinaOS;
	}

	public Integer getDiabeticEvalOS() {
		return diabeticEvalOS;
	}

	public void setDiabeticEvalOS(Integer diabeticEvalOS) {
		this.diabeticEvalOS = diabeticEvalOS;
	}

	public Integer getHtnEvalOS() {
		return htnEvalOS;
	}

	public void setHtnEvalOS(Integer htnEvalOS) {
		this.htnEvalOS = htnEvalOS;
	}

	public Integer getArmdOS() {
		return armdOS;
	}

	public void setArmdOS(Integer armdOS) {
		this.armdOS = armdOS;
	}

	public Integer getCustom1OS() {
		return custom1OS;
	}

	public void setCustom1OS(Integer custom1OS) {
		this.custom1OS = custom1OS;
	}

	public Integer getCustom2OS() {
		return custom2OS;
	}

	public void setCustom2OS(Integer custom2OS) {
		this.custom2OS = custom2OS;
	}

	public Integer getCustom3OS() {
		return custom3OS;
	}

	public void setCustom3OS(Integer custom3OS) {
		this.custom3OS = custom3OS;
	}

	public Integer getSponVeinPulsOD() {
		return sponVeinPulsOD;
	}

	public void setSponVeinPulsOD(Integer sponVeinPulsOD) {
		this.sponVeinPulsOD = sponVeinPulsOD;
	}

	public Integer getFovealReflexOD() {
		return fovealReflexOD;
	}

	public void setFovealReflexOD(Integer fovealReflexOD) {
		this.fovealReflexOD = fovealReflexOD;
	}

	public Integer getSponVeinPulsOS() {
		return sponVeinPulsOS;
	}

	public void setSponVeinPulsOS(Integer sponVeinPulsOS) {
		this.sponVeinPulsOS = sponVeinPulsOS;
	}

	public Integer getFovealReflexOs() {
		return fovealReflexOs;
	}

	public void setFovealReflexOs(Integer fovealReflexOs) {
		this.fovealReflexOs = fovealReflexOs;
	}

	public Integer getMethodUsed() {
		return methodUsed;
	}

	public void setMethodUsed(Integer methodUsed) {
		this.methodUsed = methodUsed;
	}

	public Integer getGttOD() {
		return gttOD;
	}

	public void setGttOD(Integer gttOD) {
		this.gttOD = gttOD;
	}

	public Integer getGttOS() {
		return gttOS;
	}

	public void setGttOS(Integer gttOS) {
		this.gttOS = gttOS;
	}

	public Integer getDilationAgent() {
		return dilationAgent;
	}

	public void setDilationAgent(Integer dilationAgent) {
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

	public Integer getOpticNerve() {
		return opticNerve;
	}

	public void setOpticNerve(Integer opticNerve) {
		this.opticNerve = opticNerve;
	}

	public Integer getNerveFiberLayer() {
		return nerveFiberLayer;
	}

	public void setNerveFiberLayer(Integer nerveFiberLayer) {
		this.nerveFiberLayer = nerveFiberLayer;
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
