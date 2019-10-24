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

enum AssessmentRangeEnum
{
    NORM, LOW, HIGH, CRITCAL, CHECKED
}

public class EyeTestResults 
{
    private int farChartDistance;
    private int dccOS;
    private int dccOSph;
    private int dscOS;
    private int dscOSph;
    private int dccOD;
    private int dccODph;
    private int dscOD;
    private int dccOU;
    private int dccOUph;
    private int dscOU;
    private int dscOUph;
    private int nearChartDistance;
    private int nccOS;
    private int nccOSph;
    private int nscOS;
    private int nscOSph;
    private int nccOD;
    private int nccODph;
    private int nscOD;
    private int nccOU;
    private int nccOUph;
    private int nscOU;
    private int nscOUph;
    private float sphereOD;
    private float sphereOS;
    private float cylinderOD;
    private float cylinderOS;
    private float axisOD;
    private float axisOS;
    private float prismOD;
    private float prismOS;
    private float prismBaseOD;
    private float prismBaseOS;
    private int nn20;
    private int dd20;
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
    private int sponVeinPulsOD;
    private int fovealReflexOD;
    private int sponVeinPulsOS;
    private int fovealReflexOs;
    private int methodUsed;
    private int gttOD;
    private int intgttOS;
    private int dilationAgent;
    private boolean lens78dUsed;
    private boolean lens90Dused;
    private boolean lens20DbioUsed;
    private boolean LensPR22bioUsed;
    private boolean ScleralDepUsed;
    private boolean directOpthScopeUsed;
    private boolean otherNoteGiven;
    private boolean otherNoteText;
    private boolean patientAdvisedDfe;
    private boolean dfeResched;
    private boolean dfeDeclined;
    private boolean fundusImgPerformed;
    private boolean dfeRefusedAme;
    private boolean dfeNotInd;
    private boolean dfeContraind;
    private boolean recentDfe;
    private float horizOD;
    private float horizOS;
    private float vertOD;
    private float vertOS;
    //opticNerv
    //nervFiberLayer
    private boolean deepLaminaOD;
    private boolean deepLaminaOS;
    private boolean shallowOD;
    private boolean shallowOS;
    private boolean roundOD;
    private boolean roundOS;
    private boolean ovalOD;
    private boolean ovalOS;
    private boolean tempSlopingOD;
    private boolean tempSlopingOS;
    private boolean underminingOD;
    private boolean underminingOS;
    private boolean peripapAtrophyOD;
    private boolean peripapAtrophyOS;
    private boolean scleralCrescentOD;
    private boolean scleralCrescentOS;
    private boolean pigmentCrescentOD;
    private boolean pigmentCrescentOS;
    private boolean opticPitOD;
    private boolean opticPitOS;
    private boolean myelinationOD;
    private boolean myelinationOS;
    private boolean glialRemOD;
    private boolean glialRemOS;
}
