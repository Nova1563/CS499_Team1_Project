
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
										+ "farChartDistance		Text,\n"
										+ "dccOS		Text,\n"
										+ "dccOSph		Text,\n"
										+ "dscOS		Text,\n"
										+ "dscOSph		Text,\n"
										+ "dccOD		Text,\n"
										+ "dccODph		Text,\n"
										+ "dscOD		Text,\n"
										+ "dccOU		Text,\n"
										+ "dccOUph		Text,\n"
										+ "dscOU		Text,\n"
										+ "dscOUph		Text,\n"
										+ "nearChartDistance		Text,\n"
										+ "nccOS		Text,\n"
										+ "nccOSph		Text,\n"
										+ "nscOS		Text,\n"
										+ "nscOSph		Text,\n"
										+ "nccOD		Text,\n"
										+ "nccODph		Text,\n"
										+ "nscOD		Text,\n"
										+ "nccOU		Text,\n"
										+ "nccOUph		Text,\n"
										+ "nscOU		Text,\n"
										+ "nscOUph		Text,\n"
										+ "sphereOD		Float,\n"
										+ "sphereOS		Float,\n"
										+ "cylinderOD		Float,\n"
										+ "cylinderOS		Float,\n"
										+ "axisOD		Float,\n"
										+ "axisOS		Float,\n"
										+ "addOD		Float,\n"
										+ "addOS		Float,\n"
										+ "prismOD		Float,\n"
										+ "prismOS		Float,\n"
										+ "prismBaseOD		Float,\n"
										+ "prismBaseOS		Float,\n"
										+ "nn20OD		Text,\n"
										+ "dd20OD		Text,\n"
										+ "nn20OS		Text,\n"
										+ "dd20OS		Text,\n"
										+ "vitreousOD		Text,\n"
										+ "maculaOD		Text,\n"
										+ "vasculatureOD		Text,\n"
										+ "posteriorPoleOD		Text,\n"
										+ "peripheralRetinaOD		Text,\n"
										+ "miscRetinaOD		Text,\n"
										+ "diabeticEvalOD		Text,\n"
										+ "htnEvalOD		Text,\n"
										+ "armdOD		Text,\n"
										+ "custom1OD		Text,\n"
										+ "custom2OD		Text,\n"
										+ "custom3OD		Text,\n"
										+ "vitreousOS		Text,\n"
										+ "maculaOS		Text,\n"
										+ "vasculatureOS		Text,\n"
										+ "posteriorPoleOS		Text,\n"
										+ "peripheralRetinaOS		Text,\n"
										+ "miscRetinaOS		Text,\n"
										+ "diabeticEvalOS		Text,\n"
										+ "htnEvalOS		Text,\n"
										+ "armdOS		Text,\n"
										+ "custom1OS		Text,\n"
										+ "custom2OS		Text,\n"
										+ "custom3OS		Text,\n"
										+ "sponVeinPulsOD		Text,\n"
										+ "fovealReflexOD		Text,\n"
										+ "sponVeinPulsOS		Text,\n"
										+ "fovealReflexOs		Text,\n"
										+ "methodUsed		Text,\n"
										+ "gttOD		Text,\n"
										+ "gttOS		Text,\n"
										+ "dilationAgent		Text,\n"
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
										+ "opticNerve		Text,\n"
										+ "nerveFiberLayer		Text,\n"
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
										+ "FOREIGN KEY(patientID) REFERENCES patientTable(patientID) ON DELETE CASCADE\n,"
										+ "FOREIGN KEY(apptID) REFERENCES appointmentsTable(apptID) ON DELETE CASCADE\n"
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
			theNewResultsObject = new EyeTestResults(examID, apptID, patientID);
			
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
					+ "\tfarChartDistance: " + queryResults.getString("farChartDistance")
					+ "\tdccOS: " + queryResults.getString("dccOS")
					+ "\tdccOSph: " + queryResults.getString("dccOSph")
					+ "\tdscOS: " + queryResults.getString("dscOS")
					+ "\tdscOSph: " + queryResults.getString("dscOSph")
					+ "\tdccOD: " + queryResults.getString("dccOD")
					+ "\tdccODph: " + queryResults.getString("dccODph")
					+ "\tdscOD: " + queryResults.getString("dscOD")
					+ "\tdccOU: " + queryResults.getString("dccOU")
					+ "\tdccOUph: " + queryResults.getString("dccOUph")
					+ "\tdscOU: " + queryResults.getString("dscOU")
					+ "\tdscOUph: " + queryResults.getString("dscOUph")
					+ "\tnearChartDistance: " + queryResults.getString("nearChartDistance")
					+ "\tnccOS: " + queryResults.getString("nccOS")
					+ "\tnccOSph: " + queryResults.getString("nccOSph")
					+ "\tnscOS: " + queryResults.getString("nscOS")
					+ "\tnscOSph: " + queryResults.getString("nscOSph")
					+ "\tnccOD: " + queryResults.getString("nccOD")
					+ "\tnccODph: " + queryResults.getString("nccODph")
					+ "\tnscOD: " + queryResults.getString("nscOD")
					+ "\tnccOU: " + queryResults.getString("nccOU")
					+ "\tnccOUph: " + queryResults.getString("nccOUph")
					+ "\tnscOU: " + queryResults.getString("nscOU")
					+ "\tnscOUph: " + queryResults.getString("nscOUph")
					+ "\tsphereOD: " + queryResults.getFloat("sphereOD")
					+ "\tsphereOS: " + queryResults.getFloat("sphereOS")
					+ "\tcylinderOD: " + queryResults.getFloat("cylinderOD")
					+ "\tcylinderOS: " + queryResults.getFloat("cylinderOS")
					+ "\taxisOD: " + queryResults.getFloat("axisOD")
					+ "\taxisOS: " + queryResults.getFloat("axisOS")
					+ "\taddOD: " + queryResults.getFloat("addOD")
					+ "\taddOS: " + queryResults.getFloat("addOS")			
					+ "\tprismOD: " + queryResults.getFloat("prismOD")
					+ "\tprismOS: " + queryResults.getFloat("prismOS")
					+ "\tprismBaseOD: " + queryResults.getFloat("prismBaseOD")
					+ "\tprismBaseOS: " + queryResults.getFloat("prismBaseOS")
					+ "\tnn20OD: " + queryResults.getString("nn20OD")
					+ "\tdd20OD: " + queryResults.getString("dd20OD")
					+ "\tnn20OS: " + queryResults.getString("nn20OS")
					+ "\tdd20OS: " + queryResults.getString("dd20OS")
					+ "\tvitreousOD: " + queryResults.getString("vitreousOD")
					+ "\tmaculaOD: " + queryResults.getString("maculaOD")
					+ "\tvasculatureOD: " + queryResults.getString("vasculatureOD")
					+ "\tposteriorPoleOD: " + queryResults.getString("posteriorPoleOD")
					+ "\tperipheralRetinaOD: " + queryResults.getString("peripheralRetinaOD")
					+ "\tmiscRetinaOD: " + queryResults.getString("miscRetinaOD")
					+ "\tdiabeticEvalOD: " + queryResults.getString("diabeticEvalOD")
					+ "\thtnEvalOD: " + queryResults.getString("htnEvalOD")
					+ "\tarmdOD: " + queryResults.getString("armdOD")
					+ "\tcustom1OD: " + queryResults.getString("custom1OD")
					+ "\tcustom2OD: " + queryResults.getString("custom2OD")
					+ "\tcustom3OD: " + queryResults.getString("custom3OD")
					+ "\tvitreousOS: " + queryResults.getString("vitreousOS")
					+ "\tmaculaOS: " + queryResults.getString("maculaOS")
					+ "\tvasculatureOS: " + queryResults.getString("vasculatureOS")
					+ "\tposteriorPoleOS: " + queryResults.getString("posteriorPoleOS")
					+ "\tperipheralRetinaOS: " + queryResults.getString("peripheralRetinaOS")
					+ "\tmiscRetinaOS: " + queryResults.getString("miscRetinaOS")
					+ "\tdiabeticEvalOS: " + queryResults.getString("diabeticEvalOS")
					+ "\thtnEvalOS: " + queryResults.getString("htnEvalOS")
					+ "\tarmdOS: " + queryResults.getString("armdOS")
					+ "\tcustom1OS: " + queryResults.getString("custom1OS")
					+ "\tcustom2OS: " + queryResults.getString("custom2OS")
					+ "\tcustom3OS: " + queryResults.getString("custom3OS")
					+ "\tsponVeinPulsOD: " + queryResults.getString("sponVeinPulsOD")
					+ "\tfovealReflexOD: " + queryResults.getString("fovealReflexOD")
					+ "\tsponVeinPulsOS: " + queryResults.getString("sponVeinPulsOS")
					+ "\tfovealReflexOs: " + queryResults.getString("fovealReflexOs")
					+ "\tmethodUsed: " + queryResults.getString("methodUsed")
					+ "\tgttOD: " + queryResults.getString("gttOD")
					+ "\tgttOS: " + queryResults.getString("gttOS")
					+ "\tdilationAgent: " + queryResults.getString("dilationAgent")
					+ "\tlens78dUsed: " + queryResults.getBoolean("lens78dUsed")
					+ "\tlens90Dused: " + queryResults.getBoolean("lens90Dused")
					+ "\tlens20DbioUsed: " + queryResults.getBoolean("lens20DbioUsed")
					+ "\tLensPR22bioUsed: " + queryResults.getBoolean("LensPR22bioUsed")
					+ "\tScleralDepUsed: " + queryResults.getBoolean("ScleralDepUsed")
					+ "\tdirectOpthScopeUsed: " + queryResults.getBoolean("directOpthScopeUsed")
					+ "\totherNoteGiven: " + queryResults.getBoolean("otherNoteGiven")
					+ "\totherNoteText: " + queryResults.getString("otherNoteText")
					+ "\tpatientAdvisedDfe: " + queryResults.getBoolean("patientAdvisedDfe")
					+ "\tdfeResched: " + queryResults.getBoolean("dfeResched")
					+ "\tdfeDeclined: " + queryResults.getBoolean("dfeDeclined")
					+ "\tfundusImgPerformed: " + queryResults.getBoolean("fundusImgPerformed")
					+ "\tdfeRefusedAme: " + queryResults.getBoolean("dfeRefusedAme")
					+ "\tdfeNotInd: " + queryResults.getBoolean("dfeNotInd")
					+ "\tdfeContraind: " + queryResults.getBoolean("dfeContraind")
					+ "\trecentDfe: " + queryResults.getBoolean("recentDfe")
					+ "\thorizOD: " + queryResults.getFloat("horizOD")
					+ "\thorizOS: " + queryResults.getFloat("horizOS")
					+ "\tvertOD: " + queryResults.getFloat("vertOD")
					+ "\tvertOS: " + queryResults.getFloat("vertOS")
					+ "\topticNerve: " + queryResults.getString("opticNerve")
					+ "\tnerveFiberLayer: " + queryResults.getString("nerveFiberLayer")
					+ "\tdeepLaminaOD: " + queryResults.getBoolean("deepLaminaOD")
					+ "\tdeepLaminaOS: " + queryResults.getBoolean("deepLaminaOS")
					+ "\tshallowOD: " + queryResults.getBoolean("shallowOD")
					+ "\tshallowOS: " + queryResults.getBoolean("shallowOS")
					+ "\troundOD: " + queryResults.getBoolean("roundOD")
					+ "\troundOS: " + queryResults.getBoolean("roundOS")
					+ "\tovalOD: " + queryResults.getBoolean("ovalOD")
					+ "\tovalOS: " + queryResults.getBoolean("ovalOS")
					+ "\ttempSlopingOD: " + queryResults.getBoolean("tempSlopingOD")
					+ "\ttempSlopingOS: " + queryResults.getBoolean("tempSlopingOS")
					+ "\tunderminingOD: " + queryResults.getBoolean("underminingOD")
					+ "\tunderminingOS: " + queryResults.getBoolean("underminingOS")
					+ "\tperipapAtrophyOD: " + queryResults.getBoolean("peripapAtrophyOD")
					+ "\tperipapAtrophyOS: " + queryResults.getBoolean("peripapAtrophyOS")
					+ "\tscleralCrescentOD: " + queryResults.getBoolean("scleralCrescentOD")
					+ "\tscleralCrescentOS: " + queryResults.getBoolean("scleralCrescentOS")
					+ "\tpigmentCrescentOD: " + queryResults.getBoolean("pigmentCrescentOD")
					+ "\tpigmentCrescentOS: " + queryResults.getBoolean("pigmentCrescentOS")
					+ "\topticPitOD: " + queryResults.getBoolean("opticPitOD")
					+ "\topticPitOS: " + queryResults.getBoolean("opticPitOS")
					+ "\tmyelinationOD: " + queryResults.getBoolean("myelinationOD")
					+ "\tmyelinationOS: " + queryResults.getBoolean("myelinationOS")
					+ "\tglialRemOD: " + queryResults.getBoolean("glialRemOD")
					+ "\tglialRemOS: " + queryResults.getBoolean("glialRemOS") );
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
		Integer examID = theResults.getExamID();
		
		String sqlString = "UPDATE eyeTestResults SET "
						+ "farChartDistance = ? ,"
						+ "dccOS = ? ,"
						+ "dccOSph = ? ,"
						+ "dscOS = ? ,"
						+ "dscOSph = ? ,"
						+ "dccOD = ? ,"
						+ "dccODph = ? ,"
						+ "dscOD = ? ,"
						+ "dccOU = ? ,"
						+ "dccOUph = ? ,"
						+ "dscOU = ? ,"
						+ "dscOUph = ? ,"
						+ "nearChartDistance = ? ,"
						+ "nccOS = ? ,"
						+ "nccOSph = ? ,"
						+ "nscOS = ? ,"
						+ "nscOSph = ? ,"
						+ "nccOD = ? ,"
						+ "nccODph = ? ,"
						+ "nscOD = ? ,"
						+ "nccOU = ? ,"
						+ "nccOUph = ? ,"
						+ "nscOU = ? ,"
						+ "nscOUph = ? ,"
						+ "sphereOD = ? ,"
						+ "sphereOS = ? ,"
						+ "cylinderOD = ? ,"
						+ "cylinderOS = ? ,"
						+ "axisOD = ? ,"
						+ "axisOS = ? ,"
						+ "prismOD = ? ,"
						+ "prismOS = ? ,"
						+ "prismBaseOD = ? ,"
						+ "prismBaseOS = ? ,"
						+ "nn20OD = ? ,"
						+ "dd20OD = ? ,"
						+ "vitreousOD = ? ,"
						+ "maculaOD = ? ,"
						+ "vasculatureOD = ? ,"
						+ "posteriorPoleOD = ? ,"
						+ "peripheralRetinaOD = ? ,"
						+ "miscRetinaOD = ? ,"
						+ "diabeticEvalOD = ? ,"
						+ "htnEvalOD = ? ,"
						+ "armdOD = ? ,"
						+ "custom1OD = ? ,"
						+ "custom2OD = ? ,"
						+ "custom3OD = ? ,"
						+ "vitreousOS = ? ,"
						+ "maculaOS = ? ,"
						+ "vasculatureOS = ? ,"
						+ "posteriorPoleOS = ? ,"
						+ "peripheralRetinaOS = ? ,"
						+ "miscRetinaOS = ? ,"
						+ "diabeticEvalOS = ? ,"
						+ "htnEvalOS = ? ,"
						+ "armdOS = ? ,"
						+ "custom1OS = ? ,"
						+ "custom2OS = ? ,"
						+ "custom3OS = ? ,"
						+ "sponVeinPulsOD = ? ,"
						+ "fovealReflexOD = ? ,"
						+ "sponVeinPulsOS = ? ,"
						+ "fovealReflexOs = ? ,"
						+ "methodUsed = ? ,"
						+ "gttOD = ? ,"
						+ "gttOS = ? ,"
						+ "dilationAgent = ? ,"
						+ "lens78dUsed = ? ,"
						+ "lens90Dused = ? ,"
						+ "lens20DbioUsed = ? ,"
						+ "LensPR22bioUsed = ? ,"
						+ "ScleralDepUsed = ? ,"
						+ "directOpthScopeUsed = ? ,"
						+ "otherNoteGiven = ? ,"
						+ "otherNoteText = ? ,"
						+ "patientAdvisedDfe = ? ,"
						+ "dfeResched = ? ,"
						+ "dfeDeclined = ? ,"
						+ "fundusImgPerformed = ? ,"
						+ "dfeRefusedAme = ? ,"
						+ "dfeNotInd = ? ,"
						+ "dfeContraind = ? ,"
						+ "recentDfe = ? ,"
						+ "horizOD = ? ,"
						+ "horizOS = ? ,"
						+ "vertOD = ? ,"
						+ "vertOS = ? ,"
						+ "opticNerve = ? ,"
						+ "nerveFiberLayer = ? ,"
						+ "deepLaminaOD = ? ,"
						+ "deepLaminaOS = ? ,"
						+ "shallowOD = ? ,"
						+ "shallowOS = ? ,"
						+ "roundOD = ? ,"
						+ "roundOS = ? ,"
						+ "ovalOD = ? ,"
						+ "ovalOS = ? ,"
						+ "tempSlopingOD = ? ,"
						+ "tempSlopingOS = ? ,"
						+ "underminingOD = ? ,"
						+ "underminingOS = ? ,"
						+ "peripapAtrophyOD = ? ,"
						+ "peripapAtrophyOS = ? ,"
						+ "scleralCrescentOD = ? ,"
						+ "scleralCrescentOS = ? ,"
						+ "pigmentCrescentOD = ? ,"
						+ "pigmentCrescentOS = ? ,"
						+ "opticPitOD = ? ,"
						+ "opticPitOS = ? ,"
						+ "myelinationOD = ? ,"
						+ "myelinationOS = ? ,"
						+ "glialRemOD = ? ,"
						+ "glialRemOS = ? ,"
						+ "nn20OS = ? ,"	//
						+ "dd20OS = ? ,"	//
						+ "addOS = ? ,"		//
						+ "addOD = ? "		//
						+ "WHERE resultsID = ? ";
		
		try
		{
			PreparedStatement theSQLstatement = conn.prepareStatement(sqlString);

			theSQLstatement.setString(1 , theResults.getFarChartDistance());		 // farChartDistance
			theSQLstatement.setString(2 , theResults.getDccOS());		 // dccOS
			theSQLstatement.setString(3 , theResults.getDccOSph());		 // dccOSph
			theSQLstatement.setString(4 , theResults.getDscOS());		 // dscOS
			theSQLstatement.setString(5 , theResults.getDscOSph());		 // dscOSph
			theSQLstatement.setString(6 , theResults.getDccOD());		 // dccOD
			theSQLstatement.setString(7 , theResults.getDccODph());		 // dccODph
			theSQLstatement.setString(8 , theResults.getDscOD());		 // dscOD
			theSQLstatement.setString(9 , theResults.getDccOU());		 // dccOU
			theSQLstatement.setString(10 , theResults.getDccOUph());		 // dccOUph
			theSQLstatement.setString(11 , theResults.getDscOU());		 // dscOU
			theSQLstatement.setString(12 , theResults.getDscOUph());		 // dscOUph
			theSQLstatement.setString(13 , theResults.getNearChartDistance());		 // nearChartDistance
			theSQLstatement.setString(14 , theResults.getNccOS());		 // nccOS
			theSQLstatement.setString(15 , theResults.getNccOSph());		 // nccOSph
			theSQLstatement.setString(16 , theResults.getNscOS());		 // nscOS
			theSQLstatement.setString(17 , theResults.getNscOSph());		 // nscOSph
			theSQLstatement.setString(18 , theResults.getNccOD());		 // nccOD
			theSQLstatement.setString(19 , theResults.getNccODph());		 // nccODph
			theSQLstatement.setString(20 , theResults.getNscOD());		 // nscOD
			theSQLstatement.setString(21 , theResults.getNccOU());		 // nccOU
			theSQLstatement.setString(22 , theResults.getNccOUph());		 // nccOUph
			theSQLstatement.setString(23 , theResults.getNscOU());		 // nscOU
			theSQLstatement.setString(24 , theResults.getNscOUph());		 // nscOUph
			theSQLstatement.setDouble(25 , theResults.getSphereOD());		 // sphereOD
			theSQLstatement.setDouble(26 , theResults.getSphereOS());		 // sphereOS
			theSQLstatement.setDouble(27 , theResults.getCylinderOD());		 // cylinderOD
			theSQLstatement.setDouble(28 , theResults.getCylinderOS());		 // cylinderOS
			theSQLstatement.setDouble(29 , theResults.getAxisOD());		 // axisOD
			theSQLstatement.setDouble(30 , theResults.getAxisOS());		 // axisOS
			theSQLstatement.setDouble(31 , theResults.getPrismOD());		 // prismOD
			theSQLstatement.setDouble(32 , theResults.getPrismOS());		 // prismOS
			theSQLstatement.setDouble(33 , theResults.getPrismBaseOD());		 // prismBaseOD
			theSQLstatement.setDouble(34 , theResults.getPrismBaseOS());		 // prismBaseOS
			theSQLstatement.setString(35 , theResults.getNn20OD());		 // nn20
			theSQLstatement.setString(36 , theResults.getDd20OD());		 // dd20
			theSQLstatement.setString(37 , theResults.getVitreousOD());		 // vitreousOD
			theSQLstatement.setString(38 , theResults.getMaculaOD());		 // maculaOD
			theSQLstatement.setString(39 , theResults.getVasculatureOD());		 // vasculatureOD
			theSQLstatement.setString(40 , theResults.getPosteriorPoleOD());		 // posteriorPoleOD
			theSQLstatement.setString(41 , theResults.getPeripheralRetinaOD());		 // peripheralRetinaOD
			theSQLstatement.setString(42 , theResults.getMiscRetinaOD());		 // miscRetinaOD
			theSQLstatement.setString(43 , theResults.getDiabeticEvalOD());		 // diabeticEvalOD
			theSQLstatement.setString(44 , theResults.getHtnEvalOD());		 // htnEvalOD
			theSQLstatement.setString(45 , theResults.getArmdOD());		 // armdOD
			theSQLstatement.setString(46 , theResults.getCustom1OD());		 // custom1OD
			theSQLstatement.setString(47 , theResults.getCustom2OD());		 // custom2OD
			theSQLstatement.setString(48 , theResults.getCustom3OD());		 // custom3OD
			theSQLstatement.setString(49 , theResults.getVitreousOS());		 // vitreousOS
			theSQLstatement.setString(50 , theResults.getMaculaOS());		 // maculaOS
			theSQLstatement.setString(51 , theResults.getVasculatureOS());		 // vasculatureOS
			theSQLstatement.setString(52 , theResults.getPosteriorPoleOS());		 // posteriorPoleOS
			theSQLstatement.setString(53 , theResults.getPeripheralRetinaOS());		 // peripheralRetinaOS
			theSQLstatement.setString(54 , theResults.getMiscRetinaOS());		 // miscRetinaOS
			theSQLstatement.setString(55 , theResults.getDiabeticEvalOS());		 // diabeticEvalOS
			theSQLstatement.setString(56 , theResults.getHtnEvalOS());		 // htnEvalOS
			theSQLstatement.setString(57 , theResults.getArmdOS());		 // armdOS
			theSQLstatement.setString(58 , theResults.getCustom1OS());		 // custom1OS
			theSQLstatement.setString(59 , theResults.getCustom2OS());		 // custom2OS
			theSQLstatement.setString(60 , theResults.getCustom3OS());		 // custom3OS
			theSQLstatement.setString(61 , theResults.getSponVeinPulsOD());		 // sponVeinPulsOD
			theSQLstatement.setString(62 , theResults.getFovealReflexOD());		 // fovealReflexOD
			theSQLstatement.setString(63 , theResults.getSponVeinPulsOS());		 // sponVeinPulsOS
			theSQLstatement.setString(64 , theResults.getFovealReflexOs());		 // fovealReflexOs
			theSQLstatement.setString(65 , theResults.getMethodUsed());		 // methodUsed
			theSQLstatement.setString(66 , theResults.getGttOD());		 // gttOD
			theSQLstatement.setString(67 , theResults.getGttOS());		 // gttOS
			theSQLstatement.setString(68 , theResults.getDilationAgent());		 // dilationAgent
			theSQLstatement.setBoolean(69 , theResults.getLens78dUsed());		 // lens78dUsed
			theSQLstatement.setBoolean(70 , theResults.getLens90Dused());		 // lens90Dused
			theSQLstatement.setBoolean(71 , theResults.getLens20DbioUsed());		 // lens20DbioUsed
			theSQLstatement.setBoolean(72 , theResults.getLensPR22bioUsed());		 // LensPR22bioUsed
			theSQLstatement.setBoolean(73 , theResults.getScleralDepUsed());		 // ScleralDepUsed
			theSQLstatement.setBoolean(74 , theResults.getDirectOpthScopeUsed());		 // directOpthScopeUsed
			theSQLstatement.setBoolean(75 , theResults.getOtherNoteGiven());		 // otherNoteGiven
			theSQLstatement.setString(76 , theResults.getOtherNoteText());		 // otherNoteText
			theSQLstatement.setBoolean(77 , theResults.getPatientAdvisedDfe());		 // patientAdvisedDfe
			theSQLstatement.setBoolean(78 , theResults.getDfeResched());		 // dfeResched
			theSQLstatement.setBoolean(79 , theResults.getDfeDeclined());		 // dfeDeclined
			theSQLstatement.setBoolean(80 , theResults.getFundusImgPerformed());		 // fundusImgPerformed
			theSQLstatement.setBoolean(81 , theResults.getDfeRefusedAme());		 // dfeRefusedAme
			theSQLstatement.setBoolean(82 , theResults.getDfeNotInd());		 // dfeNotInd
			theSQLstatement.setBoolean(83 , theResults.getDfeContraind());		 // dfeContraind
			theSQLstatement.setBoolean(84 , theResults.getRecentDfe());		 // recentDfe
			theSQLstatement.setDouble(85 , theResults.getHorizOD());		 // horizOD
			theSQLstatement.setDouble(86 , theResults.getHorizOS());		 // horizOS
			theSQLstatement.setDouble(87 , theResults.getVertOD());		 // vertOD
			theSQLstatement.setDouble(88 , theResults.getVertOS());		 // vertOS
			theSQLstatement.setString(89 , theResults.getOpticNerve());		 // opticNerve
			theSQLstatement.setString(90 , theResults.getNerveFiberLayer());		 // nerveFiberLayer
			theSQLstatement.setBoolean(91 , theResults.getDeepLaminaOD());		 // deepLaminaOD
			theSQLstatement.setBoolean(92 , theResults.getDeepLaminaOS());		 // deepLaminaOS
			theSQLstatement.setBoolean(93 , theResults.getShallowOD());		 // shallowOD
			theSQLstatement.setBoolean(94 , theResults.getShallowOS());		 // shallowOS
			theSQLstatement.setBoolean(95 , theResults.getRoundOD());		 // roundOD
			theSQLstatement.setBoolean(96 , theResults.getRoundOS());		 // roundOS
			theSQLstatement.setBoolean(97 , theResults.getOvalOD());		 // ovalOD
			theSQLstatement.setBoolean(98 , theResults.getOvalOS());		 // ovalOS
			theSQLstatement.setBoolean(99 , theResults.getTempSlopingOD());		 // tempSlopingOD
			theSQLstatement.setBoolean(100 , theResults.getTempSlopingOS());		 // tempSlopingOS
			theSQLstatement.setBoolean(101 , theResults.getUnderminingOD());		 // underminingOD
			theSQLstatement.setBoolean(102 , theResults.getUnderminingOS());		 // underminingOS
			theSQLstatement.setBoolean(103 , theResults.getPeripapAtrophyOD());		 // peripapAtrophyOD
			theSQLstatement.setBoolean(104 , theResults.getPeripapAtrophyOS());		 // peripapAtrophyOS
			theSQLstatement.setBoolean(105 , theResults.getScleralCrescentOD());		 // scleralCrescentOD
			theSQLstatement.setBoolean(106 , theResults.getScleralCrescentOS());		 // scleralCrescentOS
			theSQLstatement.setBoolean(107 , theResults.getPigmentCrescentOD());		 // pigmentCrescentOD
			theSQLstatement.setBoolean(108 , theResults.getPigmentCrescentOS());		 // pigmentCrescentOS
			theSQLstatement.setBoolean(109 , theResults.getOpticPitOD());		 // opticPitOD
			theSQLstatement.setBoolean(110 , theResults.getOpticPitOS());		 // opticPitOS
			theSQLstatement.setBoolean(111 , theResults.getMyelinationOD());		 // myelinationOD
			theSQLstatement.setBoolean(112 , theResults.getMyelinationOS());		 // myelinationOS
			theSQLstatement.setBoolean(113 , theResults.getGlialRemOD());		 // glialRemOD
			theSQLstatement.setBoolean(114 , theResults.getGlialRemOS());		 // glialRemOS
			theSQLstatement.setString(115, theResults.getNn20OS());	// nn20OS
			theSQLstatement.setString(116, theResults.getDd20OS());
			theSQLstatement.setDouble(117, theResults.getAddOS());
			theSQLstatement.setDouble(118, theResults.getAddOD());
			
			theSQLstatement.setInt(119, examID);
			
			theSQLstatement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("saveEyeTestResultsToSQL() error: " + e.getMessage());
		}
	}
	
		public EyeTestResults getEyeTestResultsByExamID(Integer examID)
	{
	
		EyeTestResults theFoundExam = null;
		Integer apptID = -1;
		Integer patientID = -1;
		
		String theSQLstatementStr = "SELECT * from eyeTestResults WHERE apptID = ?";

		try
		{
			PreparedStatement theSQLstatement = conn.prepareStatement(theSQLstatementStr);
			theSQLstatement.setInt(1, examID);
			ResultSet theResults = theSQLstatement.executeQuery(theSQLstatementStr);
			
			apptID = theResults.getInt("apptID");
			patientID = theResults.getInt("patientID");
			
			theFoundExam = new EyeTestResults(examID, patientID, apptID);
			
			theFoundExam.setFarChartDistance(theResults.getString("farChartDistance"));
			theFoundExam.setDccOS(theResults.getString("dccOS"));
			theFoundExam.setDccOSph(theResults.getString("dccOSph"));
			theFoundExam.setDscOS(theResults.getString("dscOS"));
			theFoundExam.setDscOSph(theResults.getString("dscOSph"));
			theFoundExam.setDccOD(theResults.getString("dccOD"));
			theFoundExam.setDccODph(theResults.getString("dccODph"));
			theFoundExam.setDscOD(theResults.getString("dscOD"));
			theFoundExam.setDccOU(theResults.getString("dccOU"));
			theFoundExam.setDccOUph(theResults.getString("dccOUph"));
			theFoundExam.setDscOU(theResults.getString("dscOU"));
			theFoundExam.setDscOUph(theResults.getString("dscOUph"));
			theFoundExam.setNearChartDistance(theResults.getString("nearChartDistance"));
			theFoundExam.setNccOS(theResults.getString("nccOS"));
			theFoundExam.setNccOSph(theResults.getString("nccOSph"));
			theFoundExam.setNscOS(theResults.getString("nscOS"));
			theFoundExam.setNscOSph(theResults.getString("nscOSph"));
			theFoundExam.setNccOD(theResults.getString("nccOD"));
			theFoundExam.setNccODph(theResults.getString("nccODph"));
			theFoundExam.setNscOD(theResults.getString("nscOD"));
			theFoundExam.setNccOU(theResults.getString("nccOU"));
			theFoundExam.setNccOUph(theResults.getString("nccOUph"));
			theFoundExam.setNscOU(theResults.getString("nscOU"));
			theFoundExam.setNscOUph(theResults.getString("nscOUph"));
			theFoundExam.setSphereOD(theResults.getDouble("sphereOD"));
			theFoundExam.setSphereOS(theResults.getDouble("sphereOS"));
			theFoundExam.setCylinderOD(theResults.getDouble("cylinderOD"));
			theFoundExam.setCylinderOS(theResults.getDouble("cylinderOS"));
			theFoundExam.setAxisOD(theResults.getDouble("axisOD"));
			theFoundExam.setAxisOS(theResults.getDouble("axisOS"));
			theFoundExam.setAddOD(theResults.getDouble("addOD"));
			theFoundExam.setAddOS(theResults.getDouble("addOS"));
			theFoundExam.setPrismOD(theResults.getDouble("prismOD"));
			theFoundExam.setPrismOS(theResults.getDouble("prismOS"));
			theFoundExam.setPrismBaseOD(theResults.getDouble("prismBaseOD"));
			theFoundExam.setPrismBaseOS(theResults.getDouble("prismBaseOS"));
			theFoundExam.setNn20OD(theResults.getString("nn20OD"));
			theFoundExam.setDd20OD(theResults.getString("dd20OD"));
			theFoundExam.setNn20OS(theResults.getString("nn20OS"));
			theFoundExam.setDd20OS(theResults.getString("dd20OS"));
			theFoundExam.setVitreousOD(theResults.getString("vitreousOD"));
			theFoundExam.setMaculaOD(theResults.getString("maculaOD"));
			theFoundExam.setVasculatureOD(theResults.getString("vasculatureOD"));
			theFoundExam.setPosteriorPoleOD(theResults.getString("posteriorPoleOD"));
			theFoundExam.setPeripheralRetinaOD(theResults.getString("peripheralRetinaOD"));
			theFoundExam.setMiscRetinaOD(theResults.getString("miscRetinaOD"));
			theFoundExam.setDiabeticEvalOD(theResults.getString("diabeticEvalOD"));
			theFoundExam.setHtnEvalOD(theResults.getString("htnEvalOD"));
			theFoundExam.setArmdOD(theResults.getString("armdOD"));
			theFoundExam.setCustom1OD(theResults.getString("custom1OD"));
			theFoundExam.setCustom2OD(theResults.getString("custom2OD"));
			theFoundExam.setCustom3OD(theResults.getString("custom3OD"));
			theFoundExam.setVitreousOS(theResults.getString("vitreousOS"));
			theFoundExam.setMaculaOS(theResults.getString("maculaOS"));
			theFoundExam.setVasculatureOS(theResults.getString("vasculatureOS"));
			theFoundExam.setPosteriorPoleOS(theResults.getString("posteriorPoleOS"));
			theFoundExam.setPeripheralRetinaOS(theResults.getString("peripheralRetinaOS"));
			theFoundExam.setMiscRetinaOS(theResults.getString("miscRetinaOS"));
			theFoundExam.setDiabeticEvalOS(theResults.getString("diabeticEvalOS"));
			theFoundExam.setHtnEvalOS(theResults.getString("htnEvalOS"));
			theFoundExam.setArmdOS(theResults.getString("armdOS"));
			theFoundExam.setCustom1OS(theResults.getString("custom1OS"));
			theFoundExam.setCustom2OS(theResults.getString("custom2OS"));
			theFoundExam.setCustom3OS(theResults.getString("custom3OS"));
			theFoundExam.setSponVeinPulsOD(theResults.getString("sponVeinPulsOD"));
			theFoundExam.setFovealReflexOD(theResults.getString("fovealReflexOD"));
			theFoundExam.setSponVeinPulsOS(theResults.getString("sponVeinPulsOS"));
			theFoundExam.setFovealReflexOs(theResults.getString("fovealReflexOs"));
			theFoundExam.setMethodUsed(theResults.getString("methodUsed"));
			theFoundExam.setGttOD(theResults.getString("gttOD"));
			theFoundExam.setGttOS(theResults.getString("gttOS"));
			theFoundExam.setDilationAgent(theResults.getString("dilationAgent"));
			theFoundExam.setLens78dUsed(theResults.getBoolean("lens78dUsed"));
			theFoundExam.setLens90Dused(theResults.getBoolean("lens90Dused"));
			theFoundExam.setLens20DbioUsed(theResults.getBoolean("lens20DbioUsed"));
			theFoundExam.setLensPR22bioUsed(theResults.getBoolean("LensPR22bioUsed"));
			theFoundExam.setScleralDepUsed(theResults.getBoolean("ScleralDepUsed"));
			theFoundExam.setDirectOpthScopeUsed(theResults.getBoolean("directOpthScopeUsed"));
			theFoundExam.setOtherNoteGiven(theResults.getBoolean("otherNoteGiven"));
			theFoundExam.setOtherNoteText(theResults.getString("otherNoteText"));
			theFoundExam.setPatientAdvisedDfe(theResults.getBoolean("patientAdvisedDfe"));
			theFoundExam.setDfeResched(theResults.getBoolean("dfeResched"));
			theFoundExam.setDfeDeclined(theResults.getBoolean("dfeDeclined"));
			theFoundExam.setFundusImgPerformed(theResults.getBoolean("fundusImgPerformed"));
			theFoundExam.setDfeRefusedAme(theResults.getBoolean("dfeRefusedAme"));
			theFoundExam.setDfeNotInd(theResults.getBoolean("dfeNotInd"));
			theFoundExam.setDfeContraind(theResults.getBoolean("dfeContraind"));
			theFoundExam.setRecentDfe(theResults.getBoolean("recentDfe"));
			theFoundExam.setHorizOD(theResults.getDouble("horizOD"));
			theFoundExam.setHorizOS(theResults.getDouble("horizOS"));
			theFoundExam.setVertOD(theResults.getDouble("vertOD"));
			theFoundExam.setVertOS(theResults.getDouble("vertOS"));
			theFoundExam.setOpticNerve(theResults.getString("opticNerve"));
			theFoundExam.setNerveFiberLayer(theResults.getString("nerveFiberLayer"));
			theFoundExam.setDeepLaminaOD(theResults.getBoolean("deepLaminaOD"));
			theFoundExam.setDeepLaminaOS(theResults.getBoolean("deepLaminaOS"));
			theFoundExam.setShallowOD(theResults.getBoolean("shallowOD"));
			theFoundExam.setShallowOS(theResults.getBoolean("shallowOS"));
			theFoundExam.setRoundOD(theResults.getBoolean("roundOD"));
			theFoundExam.setRoundOS(theResults.getBoolean("roundOS"));
			theFoundExam.setOvalOD(theResults.getBoolean("ovalOD"));
			theFoundExam.setOvalOS(theResults.getBoolean("ovalOS"));
			theFoundExam.setTempSlopingOD(theResults.getBoolean("tempSlopingOD"));
			theFoundExam.setTempSlopingOS(theResults.getBoolean("tempSlopingOS"));
			theFoundExam.setUnderminingOD(theResults.getBoolean("underminingOD"));
			theFoundExam.setUnderminingOS(theResults.getBoolean("underminingOS"));
			theFoundExam.setPeripapAtrophyOD(theResults.getBoolean("peripapAtrophyOD"));
			theFoundExam.setPeripapAtrophyOS(theResults.getBoolean("peripapAtrophyOS"));
			theFoundExam.setScleralCrescentOD(theResults.getBoolean("scleralCrescentOD"));
			theFoundExam.setScleralCrescentOS(theResults.getBoolean("scleralCrescentOS"));
			theFoundExam.setPigmentCrescentOD(theResults.getBoolean("pigmentCrescentOD"));
			theFoundExam.setPigmentCrescentOS(theResults.getBoolean("pigmentCrescentOS"));
			theFoundExam.setOpticPitOD(theResults.getBoolean("opticPitOD"));
			theFoundExam.setOpticPitOS(theResults.getBoolean("opticPitOS"));
			theFoundExam.setMyelinationOD(theResults.getBoolean("myelinationOD"));
			theFoundExam.setMyelinationOS(theResults.getBoolean("myelinationOS"));
			theFoundExam.setGlialRemOD(theResults.getBoolean("glialRemOD"));
			theFoundExam.setGlialRemOS(theResults.getBoolean("glialRemOS"));
			
		}
		catch(SQLException e)
		{
			System.out.println("getEyeTestResultsByApptID(" + apptID.toString() + ") error: " + e.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public EyeTestResults getEyeTestResultsByApptID(Integer apptID)
	{
	
		EyeTestResults theFoundExam = null;
		Integer examID = -1;
		Integer patientID = -1;
		
		String theSQLstatementStr = "SELECT * from eyeTestResults WHERE apptID = ?";

		try
		{
			PreparedStatement theSQLstatement = conn.prepareStatement(theSQLstatementStr);
			theSQLstatement.setInt(1, apptID);
			ResultSet theResults = theSQLstatement.executeQuery();
			
			examID = theResults.getInt("resultsID");
			patientID = theResults.getInt("patientID");
			
			theFoundExam = new EyeTestResults(examID, patientID, apptID);
			
			theFoundExam.setFarChartDistance(theResults.getString("farChartDistance"));
			theFoundExam.setDccOS(theResults.getString("dccOS"));
			theFoundExam.setDccOSph(theResults.getString("dccOSph"));
			theFoundExam.setDscOS(theResults.getString("dscOS"));
			theFoundExam.setDscOSph(theResults.getString("dscOSph"));
			theFoundExam.setDccOD(theResults.getString("dccOD"));
			theFoundExam.setDccODph(theResults.getString("dccODph"));
			theFoundExam.setDscOD(theResults.getString("dscOD"));
			theFoundExam.setDccOU(theResults.getString("dccOU"));
			theFoundExam.setDccOUph(theResults.getString("dccOUph"));
			theFoundExam.setDscOU(theResults.getString("dscOU"));
			theFoundExam.setDscOUph(theResults.getString("dscOUph"));
			theFoundExam.setNearChartDistance(theResults.getString("nearChartDistance"));
			theFoundExam.setNccOS(theResults.getString("nccOS"));
			theFoundExam.setNccOSph(theResults.getString("nccOSph"));
			theFoundExam.setNscOS(theResults.getString("nscOS"));
			theFoundExam.setNscOSph(theResults.getString("nscOSph"));
			theFoundExam.setNccOD(theResults.getString("nccOD"));
			theFoundExam.setNccODph(theResults.getString("nccODph"));
			theFoundExam.setNscOD(theResults.getString("nscOD"));
			theFoundExam.setNccOU(theResults.getString("nccOU"));
			theFoundExam.setNccOUph(theResults.getString("nccOUph"));
			theFoundExam.setNscOU(theResults.getString("nscOU"));
			theFoundExam.setNscOUph(theResults.getString("nscOUph"));
			theFoundExam.setSphereOD(theResults.getDouble("sphereOD"));
			theFoundExam.setSphereOS(theResults.getDouble("sphereOS"));
			theFoundExam.setCylinderOD(theResults.getDouble("cylinderOD"));
			theFoundExam.setCylinderOS(theResults.getDouble("cylinderOS"));
			theFoundExam.setAxisOD(theResults.getDouble("axisOD"));
			theFoundExam.setAxisOS(theResults.getDouble("axisOS"));
			theFoundExam.setAddOD(theResults.getDouble("addOD"));
			theFoundExam.setAddOS(theResults.getDouble("addOS"));
			theFoundExam.setPrismOD(theResults.getDouble("prismOD"));
			theFoundExam.setPrismOS(theResults.getDouble("prismOS"));
			theFoundExam.setPrismBaseOD(theResults.getDouble("prismBaseOD"));
			theFoundExam.setPrismBaseOS(theResults.getDouble("prismBaseOS"));
			theFoundExam.setNn20OD(theResults.getString("nn20OD"));
			theFoundExam.setDd20OD(theResults.getString("dd20OD"));
			theFoundExam.setNn20OS(theResults.getString("nn20OS"));
			theFoundExam.setDd20OS(theResults.getString("dd20OS"));
			theFoundExam.setVitreousOD(theResults.getString("vitreousOD"));
			theFoundExam.setMaculaOD(theResults.getString("maculaOD"));
			theFoundExam.setVasculatureOD(theResults.getString("vasculatureOD"));
			theFoundExam.setPosteriorPoleOD(theResults.getString("posteriorPoleOD"));
			theFoundExam.setPeripheralRetinaOD(theResults.getString("peripheralRetinaOD"));
			theFoundExam.setMiscRetinaOD(theResults.getString("miscRetinaOD"));
			theFoundExam.setDiabeticEvalOD(theResults.getString("diabeticEvalOD"));
			theFoundExam.setHtnEvalOD(theResults.getString("htnEvalOD"));
			theFoundExam.setArmdOD(theResults.getString("armdOD"));
			theFoundExam.setCustom1OD(theResults.getString("custom1OD"));
			theFoundExam.setCustom2OD(theResults.getString("custom2OD"));
			theFoundExam.setCustom3OD(theResults.getString("custom3OD"));
			theFoundExam.setVitreousOS(theResults.getString("vitreousOS"));
			theFoundExam.setMaculaOS(theResults.getString("maculaOS"));
			theFoundExam.setVasculatureOS(theResults.getString("vasculatureOS"));
			theFoundExam.setPosteriorPoleOS(theResults.getString("posteriorPoleOS"));
			theFoundExam.setPeripheralRetinaOS(theResults.getString("peripheralRetinaOS"));
			theFoundExam.setMiscRetinaOS(theResults.getString("miscRetinaOS"));
			theFoundExam.setDiabeticEvalOS(theResults.getString("diabeticEvalOS"));
			theFoundExam.setHtnEvalOS(theResults.getString("htnEvalOS"));
			theFoundExam.setArmdOS(theResults.getString("armdOS"));
			theFoundExam.setCustom1OS(theResults.getString("custom1OS"));
			theFoundExam.setCustom2OS(theResults.getString("custom2OS"));
			theFoundExam.setCustom3OS(theResults.getString("custom3OS"));
			theFoundExam.setSponVeinPulsOD(theResults.getString("sponVeinPulsOD"));
			theFoundExam.setFovealReflexOD(theResults.getString("fovealReflexOD"));
			theFoundExam.setSponVeinPulsOS(theResults.getString("sponVeinPulsOS"));
			theFoundExam.setFovealReflexOs(theResults.getString("fovealReflexOs"));
			theFoundExam.setMethodUsed(theResults.getString("methodUsed"));
			theFoundExam.setGttOD(theResults.getString("gttOD"));
			theFoundExam.setGttOS(theResults.getString("gttOS"));
			theFoundExam.setDilationAgent(theResults.getString("dilationAgent"));
			theFoundExam.setLens78dUsed(theResults.getBoolean("lens78dUsed"));
			theFoundExam.setLens90Dused(theResults.getBoolean("lens90Dused"));
			theFoundExam.setLens20DbioUsed(theResults.getBoolean("lens20DbioUsed"));
			theFoundExam.setLensPR22bioUsed(theResults.getBoolean("LensPR22bioUsed"));
			theFoundExam.setScleralDepUsed(theResults.getBoolean("ScleralDepUsed"));
			theFoundExam.setDirectOpthScopeUsed(theResults.getBoolean("directOpthScopeUsed"));
			theFoundExam.setOtherNoteGiven(theResults.getBoolean("otherNoteGiven"));
			theFoundExam.setOtherNoteText(theResults.getString("otherNoteText"));
			theFoundExam.setPatientAdvisedDfe(theResults.getBoolean("patientAdvisedDfe"));
			theFoundExam.setDfeResched(theResults.getBoolean("dfeResched"));
			theFoundExam.setDfeDeclined(theResults.getBoolean("dfeDeclined"));
			theFoundExam.setFundusImgPerformed(theResults.getBoolean("fundusImgPerformed"));
			theFoundExam.setDfeRefusedAme(theResults.getBoolean("dfeRefusedAme"));
			theFoundExam.setDfeNotInd(theResults.getBoolean("dfeNotInd"));
			theFoundExam.setDfeContraind(theResults.getBoolean("dfeContraind"));
			theFoundExam.setRecentDfe(theResults.getBoolean("recentDfe"));
			theFoundExam.setHorizOD(theResults.getDouble("horizOD"));
			theFoundExam.setHorizOS(theResults.getDouble("horizOS"));
			theFoundExam.setVertOD(theResults.getDouble("vertOD"));
			theFoundExam.setVertOS(theResults.getDouble("vertOS"));
			theFoundExam.setOpticNerve(theResults.getString("opticNerve"));
			theFoundExam.setNerveFiberLayer(theResults.getString("nerveFiberLayer"));
			theFoundExam.setDeepLaminaOD(theResults.getBoolean("deepLaminaOD"));
			theFoundExam.setDeepLaminaOS(theResults.getBoolean("deepLaminaOS"));
			theFoundExam.setShallowOD(theResults.getBoolean("shallowOD"));
			theFoundExam.setShallowOS(theResults.getBoolean("shallowOS"));
			theFoundExam.setRoundOD(theResults.getBoolean("roundOD"));
			theFoundExam.setRoundOS(theResults.getBoolean("roundOS"));
			theFoundExam.setOvalOD(theResults.getBoolean("ovalOD"));
			theFoundExam.setOvalOS(theResults.getBoolean("ovalOS"));
			theFoundExam.setTempSlopingOD(theResults.getBoolean("tempSlopingOD"));
			theFoundExam.setTempSlopingOS(theResults.getBoolean("tempSlopingOS"));
			theFoundExam.setUnderminingOD(theResults.getBoolean("underminingOD"));
			theFoundExam.setUnderminingOS(theResults.getBoolean("underminingOS"));
			theFoundExam.setPeripapAtrophyOD(theResults.getBoolean("peripapAtrophyOD"));
			theFoundExam.setPeripapAtrophyOS(theResults.getBoolean("peripapAtrophyOS"));
			theFoundExam.setScleralCrescentOD(theResults.getBoolean("scleralCrescentOD"));
			theFoundExam.setScleralCrescentOS(theResults.getBoolean("scleralCrescentOS"));
			theFoundExam.setPigmentCrescentOD(theResults.getBoolean("pigmentCrescentOD"));
			theFoundExam.setPigmentCrescentOS(theResults.getBoolean("pigmentCrescentOS"));
			theFoundExam.setOpticPitOD(theResults.getBoolean("opticPitOD"));
			theFoundExam.setOpticPitOS(theResults.getBoolean("opticPitOS"));
			theFoundExam.setMyelinationOD(theResults.getBoolean("myelinationOD"));
			theFoundExam.setMyelinationOS(theResults.getBoolean("myelinationOS"));
			theFoundExam.setGlialRemOD(theResults.getBoolean("glialRemOD"));
			theFoundExam.setGlialRemOS(theResults.getBoolean("glialRemOS"));
			
		}
		catch(SQLException e)
		{
			System.out.println("getEyeTestResultsByApptID(" + apptID.toString() + ") error: " + e.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<EyeTestResults> getAllEyeTestResultsByPatient(Integer patientID)
	{
		ArrayList<EyeTestResults> theExamList = new ArrayList<EyeTestResults>();
		
		EyeTestResults theFoundExam = null;
		
		String theSQLstatementStr = "SELECT * from eyeTestResults WHERE patientID = ?";

		try
		{
			PreparedStatement theSQLstatement = conn.prepareStatement(theSQLstatementStr);
			theSQLstatement.setInt(1, patientID);
			ResultSet examInfo = theSQLstatement.executeQuery(theSQLstatementStr);
			
			while (examInfo.next())
			{
				theFoundExam = getEyeTestResultsByApptID(examInfo.getInt("apptID"));

				theExamList.add(theFoundExam);
			}
		}
		catch(SQLException e)
		{
			System.out.println("getAllEyeTestResultsByPatient(" + patientID.toString() + ") error: " + e.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return theExamList;
	}
	
	public void deleteEyeTestResult(Integer examID)
	{
		String delEntryString = "DELETE FROM eyeTestResults WHERE resultsID = ?";

		try
		{
			PreparedStatement theSQLstatement = conn.prepareStatement(delEntryString);

			theSQLstatement.setInt(1, examID);
			theSQLstatement.executeUpdate();
			System.out.println("Entry in eyeTestResults with ID " + examID.toString() + " deleted.");
		}
		catch(SQLException e)
		{
			System.out.println("deleteEyeTestResult(" + examID.toString() + ") error: " + e.getMessage());
		}
	}
	
	public Integer getNumOfEyeTestResultsEntries()
	{
		ResultSet queryResults = null;
		Integer numOfResults = -1;
		String sqlString = "SELECT COUNT(resultID) FROM eyeTestResults";
		
		
		try
		{

			PreparedStatement theSQLstatement = conn.prepareStatement(sqlString);
			queryResults = theSQLstatement.executeQuery();
			numOfResults = queryResults.getInt(1);
		}
		catch (SQLException e)
		{
			System.out.println("getNumOfAppointmentEntries() error: " + e.getMessage());
		}

		System.out.println("getNumOfEyeTestResultsEntries: " + numOfResults.toString());
		return numOfResults;
	}
	
}
