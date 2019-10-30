/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;

/**
 * A Java object representing one set of eye test results in the SQL database.
 * 
 */

// JUST FOR ANGIEEEEEEEEEEE

enum AssessmentRangeEnum
{
    NORM, LOW, HIGH, CRITCAL, CHECKED
}

public class EyeTestResults 
{
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
    private Float sphereOD;
    private Float sphereOS;
    private Float cylinderOD;
    private Float cylinderOS;
    private Float axisOD;
    private Float axisOS;
    private Float prismOD;
    private Float prismOS;
    private Float prismBaseOD;
    private Float prismBaseOS;
    private Integer nn20;
    private Integer dd20;
    /*
    vitreousOD
    maculaOD
    vasculatureOD
    posteriorPoleOD
    peripheralRetinaOD
    miscRetinaOD
    diabeticEvalOD
    htnEvalOD
    armdOD
    custom1OD
    custom2OD
    custom3OD
    vitreousOS
    maculaOS
    vasculatureOS
    posteriorPoleOS
    peripheralRetinaOS
    miscRetinaOS
    diabeticEvalOS
    htnEvalOS
    armdOS
    custom1OS
    custom2OS
    custom3OS
*/
    private Integer sponVeinPulsOD;
    private Integer fovealReflexOD;
    private Integer sponVeinPulsOS;
    private Integer fovealReflexOs;
    private Integer methodUsed;
    private Integer gttOD;
    private Integer IntegergttOS;
    private Integer dilationAgent;
    private Boolean lens78dUsed;
    private Boolean lens90Dused;
    private Boolean lens20DbioUsed;
    private Boolean LensPR22bioUsed;
    private Boolean ScleralDepUsed;
    private Boolean directOpthScopeUsed;
    private Boolean otherNoteGiven;
    private Boolean otherNoteText;
    private Boolean patientAdvisedDfe;
    private Boolean dfeResched;
    private Boolean dfeDeclined;
    private Boolean fundusImgPerformed;
    private Boolean dfeRefusedAme;
    private Boolean dfeNotInd;
    private Boolean dfeContraind;
    private Boolean recentDfe;
    private Float horizOD;
    private Float horizOS;
    private Float vertOD;
    private Float vertOS;
    //opticNerv
    //nervFiberLayer
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
}
