
package cs499_ophthalmology_emr;

import java.sql.*;
import java.util.ArrayList;

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
										+ "opticNerve		Integer,\n"
										+ "nerveFiberLayer		Integer,\n"
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
										+ "FOREIGN KEY(patientID) REFERENCES patientTable(patientID)\n,"
										+ "FOREIGN KEY(apptID) REFERENCES appointmentsTable(apptID)\n"
										+ ");";
		try
		{
			Statement theSQLstatement = conn.createStatement();
			theSQLstatement.execute(createTableString);
		}
		catch(SQLException e)
		{
			System.out.println("initAppointments() error: " + e.getMessage());
		}
		
	}
	
	public EyeTestResults getNewEyeTestResults(Integer patientID, Integer apptID)
	{
		EyeTestResults theNewResultsObject = null;
		///////////
		
		String addExam_SQL = "INSERT INTO eyeTestResults (patientID, apptID)\n"
			+ "VALUES (?, ?)";
		
		Integer examID = -1;

		try
		{
			// Add new entry to table. patientID and apptID are required.
			PreparedStatement theSQLstatement = conn.prepareStatement(addExam_SQL,
													Statement.RETURN_GENERATED_KEYS);
			theSQLstatement.setInt(1, patientID);
			theSQLstatement.setInt(2, apptID);
			theSQLstatement.executeUpdate();

			// Get the newly created patient entry's ID.
			ResultSet newID = theSQLstatement.getGeneratedKeys();
			examID = newID.getInt(1); // Get the newly generated Patient ID.
			theNewResultsObject = new EyeTestResults(apptID, patientID);
			
		}
		catch(SQLException e)
		{
			System.out.println("getNewEyeTestResults() error: " + e.getMessage());
		}
		//System.out.println("getNewEyeTestResults returning entry ID " + apptID.toString());
		
		//////////
		return theNewResultsObject;
	}
	
	public void printAllEntries()
	{
		String printAllEntriesString = "SELECT * from eyeTestResults";
		System.out.println("Begin EyeTestResultsManager.printAllEntries()...");
		try
		{

			Statement theSQLstatement = conn.createStatement();
			ResultSet queryResults = theSQLstatement.executeQuery(printAllEntriesString);

			while (queryResults.next())
			{
				System.out.println(
						"resultsID: " + queryResults.getInt("resultsID")
					+ "\tpatientID: " + queryResults.getInt("patientID")
					+ "\tapptID: " + queryResults.getInt("apptID")
					+ "\tfarChartDistance: " + queryResults.getInt("farChartDistance")
					+ "\tdccOS: " + queryResults.getInt("dccOS")
					+ "\tdccOSph: " + queryResults.getInt("dccOSph")
					+ "\tdscOS: " + queryResults.getInt("dscOS")
					+ "\tdscOSph: " + queryResults.getInt("dscOSph")
					+ "\tdccOD: " + queryResults.getInt("dccOD")
					+ "\tdccODph: " + queryResults.getInt("dccODph")
					+ "\tdscOD: " + queryResults.getInt("dscOD")
					+ "\tdccOU: " + queryResults.getInt("dccOU")
					+ "\tdccOUph: " + queryResults.getInt("dccOUph")
					+ "\tdscOU: " + queryResults.getInt("dscOU")
					+ "\tdscOUph: " + queryResults.getInt("dscOUph")
					+ "\tnearChartDistance: " + queryResults.getInt("nearChartDistance")
					+ "\tnccOS: " + queryResults.getInt("nccOS")
					+ "\tnccOSph: " + queryResults.getInt("nccOSph")
					+ "\tnscOS: " + queryResults.getInt("nscOS")
					+ "\tnscOSph: " + queryResults.getInt("nscOSph")
					+ "\tnccOD: " + queryResults.getInt("nccOD")
					+ "\tnccODph: " + queryResults.getInt("nccODph")
					+ "\tnscOD: " + queryResults.getInt("nscOD")
					+ "\tnccOU: " + queryResults.getInt("nccOU")
					+ "\tnccOUph: " + queryResults.getInt("nccOUph")
					+ "\tnscOU: " + queryResults.getInt("nscOU")
					+ "\tnscOUph: " + queryResults.getInt("nscOUph")
					+ "\tsphereOD: " + queryResults.getFloat("sphereOD")
					+ "\tsphereOS: " + queryResults.getFloat("sphereOS")
					+ "\tcylinderOD: " + queryResults.getFloat("cylinderOD")
					+ "\tcylinderOS: " + queryResults.getFloat("cylinderOS")
					+ "\taxisOD: " + queryResults.getFloat("axisOD")
					+ "\taxisOS: " + queryResults.getFloat("axisOS")
					+ "\tprismOD: " + queryResults.getFloat("prismOD")
					+ "\tprismOS: " + queryResults.getFloat("prismOS")
					+ "\tprismBaseOD: " + queryResults.getFloat("prismBaseOD")
					+ "\tprismBaseOS: " + queryResults.getFloat("prismBaseOS")
					+ "\tnn20: " + queryResults.getInt("nn20")
					+ "\tdd20: " + queryResults.getInt("dd20")
					+ "\tvitreousOD: " + queryResults.getInt("vitreousOD")
					+ "\tmaculaOD: " + queryResults.getInt("maculaOD")
					+ "\tvasculatureOD: " + queryResults.getInt("vasculatureOD")
					+ "\tposteriorPoleOD: " + queryResults.getInt("posteriorPoleOD")
					+ "\tperipheralRetinaOD: " + queryResults.getInt("peripheralRetinaOD")
					+ "\tmiscRetinaOD: " + queryResults.getInt("miscRetinaOD")
					+ "\tdiabeticEvalOD: " + queryResults.getInt("diabeticEvalOD")
					+ "\thtnEvalOD: " + queryResults.getInt("htnEvalOD")
					+ "\tarmdOD: " + queryResults.getInt("armdOD")
					+ "\tcustom1OD: " + queryResults.getInt("custom1OD")
					+ "\tcustom2OD: " + queryResults.getInt("custom2OD")
					+ "\tcustom3OD: " + queryResults.getInt("custom3OD")
					+ "\tvitreousOS: " + queryResults.getInt("vitreousOS")
					+ "\tmaculaOS: " + queryResults.getInt("maculaOS")
					+ "\tvasculatureOS: " + queryResults.getInt("vasculatureOS")
					+ "\tposteriorPoleOS: " + queryResults.getInt("posteriorPoleOS")
					+ "\tperipheralRetinaOS: " + queryResults.getInt("peripheralRetinaOS")
					+ "\tmiscRetinaOS: " + queryResults.getInt("miscRetinaOS")
					+ "\tdiabeticEvalOS: " + queryResults.getInt("diabeticEvalOS")
					+ "\thtnEvalOS: " + queryResults.getInt("htnEvalOS")
					+ "\tarmdOS: " + queryResults.getInt("armdOS")
					+ "\tcustom1OS: " + queryResults.getInt("custom1OS")
					+ "\tcustom2OS: " + queryResults.getInt("custom2OS")
					+ "\tcustom3OS: " + queryResults.getInt("custom3OS")
					+ "\tsponVeinPulsOD: " + queryResults.getInt("sponVeinPulsOD")
					+ "\tfovealReflexOD: " + queryResults.getInt("fovealReflexOD")
					+ "\tsponVeinPulsOS: " + queryResults.getInt("sponVeinPulsOS")
					+ "\tfovealReflexOs: " + queryResults.getInt("fovealReflexOs")
					+ "\tmethodUsed: " + queryResults.getInt("methodUsed")
					+ "\tgttOD: " + queryResults.getInt("gttOD")
					+ "\tgttOS: " + queryResults.getInt("gttOS")
					+ "\tdilationAgent: " + queryResults.getInt("dilationAgent")
					+ "\tlens78dUsed: " + queryResults.getInt("lens78dUsed")
					+ "\tlens90Dused: " + queryResults.getInt("lens90Dused")
					+ "\tlens20DbioUsed: " + queryResults.getInt("lens20DbioUsed")
					+ "\tLensPR22bioUsed: " + queryResults.getInt("LensPR22bioUsed")
					+ "\tScleralDepUsed: " + queryResults.getInt("ScleralDepUsed")
					+ "\tdirectOpthScopeUsed: " + queryResults.getInt("directOpthScopeUsed")
					+ "\totherNoteGiven: " + queryResults.getInt("otherNoteGiven")
					+ "\totherNoteText: " + queryResults.getString("otherNoteText")
					+ "\tpatientAdvisedDfe: " + queryResults.getInt("patientAdvisedDfe")
					+ "\tdfeResched: " + queryResults.getInt("dfeResched")
					+ "\tdfeDeclined: " + queryResults.getInt("dfeDeclined")
					+ "\tfundusImgPerformed: " + queryResults.getInt("fundusImgPerformed")
					+ "\tdfeRefusedAme: " + queryResults.getInt("dfeRefusedAme")
					+ "\tdfeNotInd: " + queryResults.getInt("dfeNotInd")
					+ "\tdfeContraind: " + queryResults.getInt("dfeContraind")
					+ "\trecentDfe: " + queryResults.getInt("recentDfe")
					+ "\thorizOD: " + queryResults.getFloat("horizOD")
					+ "\thorizOS: " + queryResults.getFloat("horizOS")
					+ "\tvertOD: " + queryResults.getFloat("vertOD")
					+ "\tvertOS: " + queryResults.getFloat("vertOS")
					+ "\topticNerve: " + queryResults.getInt("opticNerve")
					+ "\tnerveFiberLayer: " + queryResults.getInt("nerveFiberLayer")
					+ "\tdeepLaminaOD: " + queryResults.getInt("deepLaminaOD")
					+ "\tdeepLaminaOS: " + queryResults.getInt("deepLaminaOS")
					+ "\tshallowOD: " + queryResults.getInt("shallowOD")
					+ "\tshallowOS: " + queryResults.getInt("shallowOS")
					+ "\troundOD: " + queryResults.getInt("roundOD")
					+ "\troundOS: " + queryResults.getInt("roundOS")
					+ "\tovalOD: " + queryResults.getInt("ovalOD")
					+ "\tovalOS: " + queryResults.getInt("ovalOS")
					+ "\ttempSlopingOD: " + queryResults.getInt("tempSlopingOD")
					+ "\ttempSlopingOS: " + queryResults.getInt("tempSlopingOS")
					+ "\tunderminingOD: " + queryResults.getInt("underminingOD")
					+ "\tunderminingOS: " + queryResults.getInt("underminingOS")
					+ "\tperipapAtrophyOD: " + queryResults.getInt("peripapAtrophyOD")
					+ "\tperipapAtrophyOS: " + queryResults.getInt("peripapAtrophyOS")
					+ "\tscleralCrescentOD: " + queryResults.getInt("scleralCrescentOD")
					+ "\tscleralCrescentOS: " + queryResults.getInt("scleralCrescentOS")
					+ "\tpigmentCrescentOD: " + queryResults.getInt("pigmentCrescentOD")
					+ "\tpigmentCrescentOS: " + queryResults.getInt("pigmentCrescentOS")
					+ "\topticPitOD: " + queryResults.getInt("opticPitOD")
					+ "\topticPitOS: " + queryResults.getInt("opticPitOS")
					+ "\tmyelinationOD: " + queryResults.getInt("myelinationOD")
					+ "\tmyelinationOS: " + queryResults.getInt("myelinationOS")
					+ "\tglialRemOD: " + queryResults.getInt("glialRemOD")
					+ "\tglialRemOS: " + queryResults.getInt("glialRemOS") );
			}
		}
		catch(SQLException e)
		{
			System.out.println("printAllEntries() eyeTestResults error: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void saveEyeTestResultsToSQL(EyeTestResults theResults)
	{
		//TODO: Implement this.
	}
	
	public EyeTestResults getEyeTestResultsByAppt(Integer apptID)
	{
		//TODO: Implement this.
		return null;
	}
	
	public ArrayList<EyeTestResults> getAllEyeTestResultsByPatient(Integer patientID)
	{
		//TODO: Implement this.
		return null;
	}
	
}
