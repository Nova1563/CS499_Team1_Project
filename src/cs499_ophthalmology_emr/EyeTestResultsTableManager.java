
package cs499_ophthalmology_emr;

import java.sql.*;

/**
 * For use only by the DataBaseManager class.
 */
public class EyeTestResultsTableManager {
	
	private static Connection conn;
	
	public EyeTestResultsTableManager(Connection theConn)
	{
		this.conn = theConn;
		initEyeTestResultsTable();
	}
	
	private void initEyeTestResultsTable()
	{
		String createTableString = "CREATE TABLE IF NOT EXISTS eyeTestResults(\n"
										+ "resultsID			Integer PRIMARY KEY,\n"
										+ "patientID			Integer NOT NULL,\n"
										+ "apptID				Integer NOT NULL,\n"				
										+ "farChartDistance		Integer,\n"
										+ "dccOS		Integer,\n"
										+ "dccOSph		Integer,\n"
										+ "dscOS		Integer,\n"
										+ "dscOSph		Integer,\n"
										+ "dccOD		Integer,\n"
										+ "dccODph		Integer,\n"
										+ "dscOD		Integer,\n"
										+ "dccOU		Integer,\n"
										+ "dccOUph		Integer,\n"
										+ "dscOU		Integer,\n"
										+ "dscOUph		Integer,\n"
										+ "nearChartDistance		Integer,\n"
										+ "nccOS		Integer,\n"
										+ "nccOSph		Integer,\n"
										+ "nscOS		Integer,\n"
										+ "nscOSph		Integer,\n"
										+ "nccOD		Integer,\n"
										+ "nccODph		Integer,\n"
										+ "nscOD		Integer,\n"
										+ "nccOU		Integer,\n"
										+ "nccOUph		Integer,\n"
										+ "nscOU		Integer,\n"
										+ "nscOUph		Integer,\n"
										+ "sphereOD		Float,\n"
										+ "sphereOS		Float,\n"
										+ "cylinderOD		Float,\n"
										+ "cylinderOS		Float,\n"
										+ "axisOD		Float,\n"
										+ "axisOS		Float,\n"
										+ "prismOD		Float,\n"
										+ "prismOS		Float,\n"
										+ "prismBaseOD		Float,\n"
										+ "prismBaseOS		Float,\n"
										+ "nn20		Integer,\n"
										+ "dd20		Integer,\n"
										+ "vitreousOD		Integer,\n"
										+ "maculaOD		Integer,\n"
										+ "vasculatureOD		Integer,\n"
										+ "posteriorPoleOD		Integer,\n"
										+ "peripheralRetinaOD		Integer,\n"
										+ "miscRetinaOD		Integer,\n"
										+ "diabeticEvalOD		Integer,\n"
										+ "htnEvalOD		Integer,\n"
										+ "armdOD		Integer,\n"
										+ "custom1OD		Integer,\n"
										+ "custom2OD		Integer,\n"
										+ "custom3OD		Integer,\n"
										+ "vitreousOS		Integer,\n"
										+ "maculaOS		Integer,\n"
										+ "vasculatureOS		Integer,\n"
										+ "posteriorPoleOS		Integer,\n"
										+ "peripheralRetinaOS		Integer,\n"
										+ "miscRetinaOS		Integer,\n"
										+ "diabeticEvalOS		Integer,\n"
										+ "htnEvalOS		Integer,\n"
										+ "armdOS		Integer,\n"
										+ "custom1OS		Integer,\n"
										+ "custom2OS		Integer,\n"
										+ "custom3OS		Integer,\n"
										+ "sponVeinPulsOD		Integer,\n"
										+ "fovealReflexOD		Integer,\n"
										+ "sponVeinPulsOS		Integer,\n"
										+ "fovealReflexOs		Integer,\n"
										+ "methodUsed		Integer,\n"
										+ "gttOD		Integer,\n"
										+ "gttOS		Integer,\n"
										+ "dilationAgent		Integer,\n"
										+ "lens78dUsed		Boolean,\n"
										+ "lens90Dused		Boolean,\n"
										+ "lens20DbioUsed		Boolean,\n"
										+ "LensPR22bioUsed		Boolean,\n"
										+ "ScleralDepUsed		Boolean,\n"
										+ "directOpthScopeUsed		Boolean,\n"
										+ "otherNoteGiven		Boolean,\n"
										+ "otherNoteText		String,\n"
										+ "patientAdvisedDfe		Boolean,\n"
										+ "dfeResched		Boolean,\n"
										+ "dfeDeclined		Boolean,\n"
										+ "fundusImgPerformed		Boolean,\n"
										+ "dfeRefusedAme		Boolean,\n"
										+ "dfeNotInd		Boolean,\n"
										+ "dfeContraind		Boolean,\n"
										+ "recentDfe		Boolean,\n"
										+ "horizOD		Float,\n"
										+ "horizOS		Float,\n"
										+ "vertOD		Float,\n"
										+ "vertOS		Float,\n"
										+ "opticNerv		Integer,\n"
										+ "nervFiberLayer		Integer,\n"
										+ "deepLaminaOD		Boolean,\n"
										+ "deepLaminaOS		Boolean,\n"
										+ "shallowOD		Boolean,\n"
										+ "shallowOS		Boolean,\n"
										+ "roundOD		Boolean,\n"
										+ "roundOS		Boolean,\n"
										+ "ovalOD		Boolean,\n"
										+ "ovalOS		Boolean,\n"
										+ "tempSlopingOD		Boolean,\n"
										+ "tempSlopingOS		Boolean,\n"
										+ "underminingOD		Boolean,\n"
										+ "underminingOS		Boolean,\n"
										+ "peripapAtrophyOD		Boolean,\n"
										+ "peripapAtrophyOS		Boolean,\n"
										+ "scleralCrescentOD		Boolean,\n"
										+ "scleralCrescentOS		Boolean,\n"
										+ "pigmentCrescentOD		Boolean,\n"
										+ "pigmentCrescentOS		Boolean,\n"
										+ "opticPitOD		Boolean,\n"
										+ "opticPitOS		Boolean,\n"
										+ "myelinationOD		Boolean,\n"
										+ "myelinationOS		Boolean,\n"
										+ "glialRemOD		Boolean,\n"
										+ "glialRemOS		Boolean,\n"
										+ "FOREIGN KEY(patientID) REFERENCES patientInfo(patientID)\n,"
										+ "FOREIGN KEY(apptID) REFERENCES appointments(apptID)\n,"
										+ ");";
		
	}
	
	public void printAllEntries()
	{
		// TODO: Make this.
	}
	
}
