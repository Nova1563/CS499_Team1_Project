
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
					+ "\topticNerve: " + queryResults.getInt("opticNerve")
					+ "\tnerveFiberLayer: " + queryResults.getInt("nerveFiberLayer")
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
						+ "nn20 = ? ,"
						+ "dd20 = ? ,"
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
						+ "glialRemOS = ? "
						+ "WHERE resultsID = ? ";
		
		try
		{
			PreparedStatement theSQLstatement = conn.prepareStatement(sqlString);

			theSQLstatement.setInt(1 , theResults.getFarChartDistance());		 // farChartDistance
			theSQLstatement.setInt(2 , theResults.getDccOS());		 // dccOS
			theSQLstatement.setInt(3 , theResults.getDccOSph());		 // dccOSph
			theSQLstatement.setInt(4 , theResults.getDscOS());		 // dscOS
			theSQLstatement.setInt(5 , theResults.getDscOSph());		 // dscOSph
			theSQLstatement.setInt(6 , theResults.getDccOD());		 // dccOD
			theSQLstatement.setInt(7 , theResults.getDccODph());		 // dccODph
			theSQLstatement.setInt(8 , theResults.getDscOD());		 // dscOD
			theSQLstatement.setInt(9 , theResults.getDccOU());		 // dccOU
			theSQLstatement.setInt(10 , theResults.getDccOUph());		 // dccOUph
			theSQLstatement.setInt(11 , theResults.getDscOU());		 // dscOU
			theSQLstatement.setInt(12 , theResults.getDscOUph());		 // dscOUph
			theSQLstatement.setInt(13 , theResults.getNearChartDistance());		 // nearChartDistance
			theSQLstatement.setInt(14 , theResults.getNccOS());		 // nccOS
			theSQLstatement.setInt(15 , theResults.getNccOSph());		 // nccOSph
			theSQLstatement.setInt(16 , theResults.getNscOS());		 // nscOS
			theSQLstatement.setInt(17 , theResults.getNscOSph());		 // nscOSph
			theSQLstatement.setInt(18 , theResults.getNccOD());		 // nccOD
			theSQLstatement.setInt(19 , theResults.getNccODph());		 // nccODph
			theSQLstatement.setInt(20 , theResults.getNscOD());		 // nscOD
			theSQLstatement.setInt(21 , theResults.getNccOU());		 // nccOU
			theSQLstatement.setInt(22 , theResults.getNccOUph());		 // nccOUph
			theSQLstatement.setInt(23 , theResults.getNscOU());		 // nscOU
			theSQLstatement.setInt(24 , theResults.getNscOUph());		 // nscOUph
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
			theSQLstatement.setInt(35 , theResults.getNn20());		 // nn20
			theSQLstatement.setInt(36 , theResults.getDd20());		 // dd20
			theSQLstatement.setInt(37 , theResults.getVitreousOD());		 // vitreousOD
			theSQLstatement.setInt(38 , theResults.getMaculaOD());		 // maculaOD
			theSQLstatement.setInt(39 , theResults.getVasculatureOD());		 // vasculatureOD
			theSQLstatement.setInt(40 , theResults.getPosteriorPoleOD());		 // posteriorPoleOD
			theSQLstatement.setInt(41 , theResults.getPeripheralRetinaOD());		 // peripheralRetinaOD
			theSQLstatement.setInt(42 , theResults.getMiscRetinaOD());		 // miscRetinaOD
			theSQLstatement.setInt(43 , theResults.getDiabeticEvalOD());		 // diabeticEvalOD
			theSQLstatement.setInt(44 , theResults.getHtnEvalOD());		 // htnEvalOD
			theSQLstatement.setInt(45 , theResults.getArmdOD());		 // armdOD
			theSQLstatement.setInt(46 , theResults.getCustom1OD());		 // custom1OD
			theSQLstatement.setInt(47 , theResults.getCustom2OD());		 // custom2OD
			theSQLstatement.setInt(48 , theResults.getCustom3OD());		 // custom3OD
			theSQLstatement.setInt(49 , theResults.getVitreousOS());		 // vitreousOS
			theSQLstatement.setInt(50 , theResults.getMaculaOS());		 // maculaOS
			theSQLstatement.setInt(51 , theResults.getVasculatureOS());		 // vasculatureOS
			theSQLstatement.setInt(52 , theResults.getPosteriorPoleOS());		 // posteriorPoleOS
			theSQLstatement.setInt(53 , theResults.getPeripheralRetinaOS());		 // peripheralRetinaOS
			theSQLstatement.setInt(54 , theResults.getMiscRetinaOS());		 // miscRetinaOS
			theSQLstatement.setInt(55 , theResults.getDiabeticEvalOS());		 // diabeticEvalOS
			theSQLstatement.setInt(56 , theResults.getHtnEvalOS());		 // htnEvalOS
			theSQLstatement.setInt(57 , theResults.getArmdOS());		 // armdOS
			theSQLstatement.setInt(58 , theResults.getCustom1OS());		 // custom1OS
			theSQLstatement.setInt(59 , theResults.getCustom2OS());		 // custom2OS
			theSQLstatement.setInt(60 , theResults.getCustom3OS());		 // custom3OS
			theSQLstatement.setInt(61 , theResults.getSponVeinPulsOD());		 // sponVeinPulsOD
			theSQLstatement.setInt(62 , theResults.getFovealReflexOD());		 // fovealReflexOD
			theSQLstatement.setInt(63 , theResults.getSponVeinPulsOS());		 // sponVeinPulsOS
			theSQLstatement.setInt(64 , theResults.getFovealReflexOs());		 // fovealReflexOs
			theSQLstatement.setInt(65 , theResults.getMethodUsed());		 // methodUsed
			theSQLstatement.setInt(66 , theResults.getGttOD());		 // gttOD
			theSQLstatement.setInt(67 , theResults.getGttOS());		 // gttOS
			theSQLstatement.setInt(68 , theResults.getDilationAgent());		 // dilationAgent
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
			theSQLstatement.setInt(89 , theResults.getOpticNerve());		 // opticNerve
			theSQLstatement.setInt(90 , theResults.getNerveFiberLayer());		 // nerveFiberLayer
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
			theSQLstatement.setInt(115, examID);
			
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
			
			theFoundExam.setFarChartDistance(theResults.getInt("farChartDistance"));
			theFoundExam.setDccOS(theResults.getInt("dccOS"));
			theFoundExam.setDccOSph(theResults.getInt("dccOSph"));
			theFoundExam.setDscOS(theResults.getInt("dscOS"));
			theFoundExam.setDscOSph(theResults.getInt("dscOSph"));
			theFoundExam.setDccOD(theResults.getInt("dccOD"));
			theFoundExam.setDccODph(theResults.getInt("dccODph"));
			theFoundExam.setDscOD(theResults.getInt("dscOD"));
			theFoundExam.setDccOU(theResults.getInt("dccOU"));
			theFoundExam.setDccOUph(theResults.getInt("dccOUph"));
			theFoundExam.setDscOU(theResults.getInt("dscOU"));
			theFoundExam.setDscOUph(theResults.getInt("dscOUph"));
			theFoundExam.setNearChartDistance(theResults.getInt("nearChartDistance"));
			theFoundExam.setNccOS(theResults.getInt("nccOS"));
			theFoundExam.setNccOSph(theResults.getInt("nccOSph"));
			theFoundExam.setNscOS(theResults.getInt("nscOS"));
			theFoundExam.setNscOSph(theResults.getInt("nscOSph"));
			theFoundExam.setNccOD(theResults.getInt("nccOD"));
			theFoundExam.setNccODph(theResults.getInt("nccODph"));
			theFoundExam.setNscOD(theResults.getInt("nscOD"));
			theFoundExam.setNccOU(theResults.getInt("nccOU"));
			theFoundExam.setNccOUph(theResults.getInt("nccOUph"));
			theFoundExam.setNscOU(theResults.getInt("nscOU"));
			theFoundExam.setNscOUph(theResults.getInt("nscOUph"));
			theFoundExam.setSphereOD(theResults.getDouble("sphereOD"));
			theFoundExam.setSphereOS(theResults.getDouble("sphereOS"));
			theFoundExam.setCylinderOD(theResults.getDouble("cylinderOD"));
			theFoundExam.setCylinderOS(theResults.getDouble("cylinderOS"));
			theFoundExam.setAxisOD(theResults.getDouble("axisOD"));
			theFoundExam.setAxisOS(theResults.getDouble("axisOS"));
			theFoundExam.setPrismOD(theResults.getDouble("prismOD"));
			theFoundExam.setPrismOS(theResults.getDouble("prismOS"));
			theFoundExam.setPrismBaseOD(theResults.getDouble("prismBaseOD"));
			theFoundExam.setPrismBaseOS(theResults.getDouble("prismBaseOS"));
			theFoundExam.setNn20(theResults.getInt("nn20"));
			theFoundExam.setDd20(theResults.getInt("dd20"));
			theFoundExam.setVitreousOD(theResults.getInt("vitreousOD"));
			theFoundExam.setMaculaOD(theResults.getInt("maculaOD"));
			theFoundExam.setVasculatureOD(theResults.getInt("vasculatureOD"));
			theFoundExam.setPosteriorPoleOD(theResults.getInt("posteriorPoleOD"));
			theFoundExam.setPeripheralRetinaOD(theResults.getInt("peripheralRetinaOD"));
			theFoundExam.setMiscRetinaOD(theResults.getInt("miscRetinaOD"));
			theFoundExam.setDiabeticEvalOD(theResults.getInt("diabeticEvalOD"));
			theFoundExam.setHtnEvalOD(theResults.getInt("htnEvalOD"));
			theFoundExam.setArmdOD(theResults.getInt("armdOD"));
			theFoundExam.setCustom1OD(theResults.getInt("custom1OD"));
			theFoundExam.setCustom2OD(theResults.getInt("custom2OD"));
			theFoundExam.setCustom3OD(theResults.getInt("custom3OD"));
			theFoundExam.setVitreousOS(theResults.getInt("vitreousOS"));
			theFoundExam.setMaculaOS(theResults.getInt("maculaOS"));
			theFoundExam.setVasculatureOS(theResults.getInt("vasculatureOS"));
			theFoundExam.setPosteriorPoleOS(theResults.getInt("posteriorPoleOS"));
			theFoundExam.setPeripheralRetinaOS(theResults.getInt("peripheralRetinaOS"));
			theFoundExam.setMiscRetinaOS(theResults.getInt("miscRetinaOS"));
			theFoundExam.setDiabeticEvalOS(theResults.getInt("diabeticEvalOS"));
			theFoundExam.setHtnEvalOS(theResults.getInt("htnEvalOS"));
			theFoundExam.setArmdOS(theResults.getInt("armdOS"));
			theFoundExam.setCustom1OS(theResults.getInt("custom1OS"));
			theFoundExam.setCustom2OS(theResults.getInt("custom2OS"));
			theFoundExam.setCustom3OS(theResults.getInt("custom3OS"));
			theFoundExam.setSponVeinPulsOD(theResults.getInt("sponVeinPulsOD"));
			theFoundExam.setFovealReflexOD(theResults.getInt("fovealReflexOD"));
			theFoundExam.setSponVeinPulsOS(theResults.getInt("sponVeinPulsOS"));
			theFoundExam.setFovealReflexOs(theResults.getInt("fovealReflexOs"));
			theFoundExam.setMethodUsed(theResults.getInt("methodUsed"));
			theFoundExam.setGttOD(theResults.getInt("gttOD"));
			theFoundExam.setGttOS(theResults.getInt("gttOS"));
			theFoundExam.setDilationAgent(theResults.getInt("dilationAgent"));
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
			theFoundExam.setOpticNerve(theResults.getInt("opticNerve"));
			theFoundExam.setNerveFiberLayer(theResults.getInt("nerveFiberLayer"));
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
			
			theFoundExam.setFarChartDistance(theResults.getInt("farChartDistance"));
			theFoundExam.setDccOS(theResults.getInt("dccOS"));
			theFoundExam.setDccOSph(theResults.getInt("dccOSph"));
			theFoundExam.setDscOS(theResults.getInt("dscOS"));
			theFoundExam.setDscOSph(theResults.getInt("dscOSph"));
			theFoundExam.setDccOD(theResults.getInt("dccOD"));
			theFoundExam.setDccODph(theResults.getInt("dccODph"));
			theFoundExam.setDscOD(theResults.getInt("dscOD"));
			theFoundExam.setDccOU(theResults.getInt("dccOU"));
			theFoundExam.setDccOUph(theResults.getInt("dccOUph"));
			theFoundExam.setDscOU(theResults.getInt("dscOU"));
			theFoundExam.setDscOUph(theResults.getInt("dscOUph"));
			theFoundExam.setNearChartDistance(theResults.getInt("nearChartDistance"));
			theFoundExam.setNccOS(theResults.getInt("nccOS"));
			theFoundExam.setNccOSph(theResults.getInt("nccOSph"));
			theFoundExam.setNscOS(theResults.getInt("nscOS"));
			theFoundExam.setNscOSph(theResults.getInt("nscOSph"));
			theFoundExam.setNccOD(theResults.getInt("nccOD"));
			theFoundExam.setNccODph(theResults.getInt("nccODph"));
			theFoundExam.setNscOD(theResults.getInt("nscOD"));
			theFoundExam.setNccOU(theResults.getInt("nccOU"));
			theFoundExam.setNccOUph(theResults.getInt("nccOUph"));
			theFoundExam.setNscOU(theResults.getInt("nscOU"));
			theFoundExam.setNscOUph(theResults.getInt("nscOUph"));
			theFoundExam.setSphereOD(theResults.getDouble("sphereOD"));
			theFoundExam.setSphereOS(theResults.getDouble("sphereOS"));
			theFoundExam.setCylinderOD(theResults.getDouble("cylinderOD"));
			theFoundExam.setCylinderOS(theResults.getDouble("cylinderOS"));
			theFoundExam.setAxisOD(theResults.getDouble("axisOD"));
			theFoundExam.setAxisOS(theResults.getDouble("axisOS"));
			theFoundExam.setPrismOD(theResults.getDouble("prismOD"));
			theFoundExam.setPrismOS(theResults.getDouble("prismOS"));
			theFoundExam.setPrismBaseOD(theResults.getDouble("prismBaseOD"));
			theFoundExam.setPrismBaseOS(theResults.getDouble("prismBaseOS"));
			theFoundExam.setNn20(theResults.getInt("nn20"));
			theFoundExam.setDd20(theResults.getInt("dd20"));
			theFoundExam.setVitreousOD(theResults.getInt("vitreousOD"));
			theFoundExam.setMaculaOD(theResults.getInt("maculaOD"));
			theFoundExam.setVasculatureOD(theResults.getInt("vasculatureOD"));
			theFoundExam.setPosteriorPoleOD(theResults.getInt("posteriorPoleOD"));
			theFoundExam.setPeripheralRetinaOD(theResults.getInt("peripheralRetinaOD"));
			theFoundExam.setMiscRetinaOD(theResults.getInt("miscRetinaOD"));
			theFoundExam.setDiabeticEvalOD(theResults.getInt("diabeticEvalOD"));
			theFoundExam.setHtnEvalOD(theResults.getInt("htnEvalOD"));
			theFoundExam.setArmdOD(theResults.getInt("armdOD"));
			theFoundExam.setCustom1OD(theResults.getInt("custom1OD"));
			theFoundExam.setCustom2OD(theResults.getInt("custom2OD"));
			theFoundExam.setCustom3OD(theResults.getInt("custom3OD"));
			theFoundExam.setVitreousOS(theResults.getInt("vitreousOS"));
			theFoundExam.setMaculaOS(theResults.getInt("maculaOS"));
			theFoundExam.setVasculatureOS(theResults.getInt("vasculatureOS"));
			theFoundExam.setPosteriorPoleOS(theResults.getInt("posteriorPoleOS"));
			theFoundExam.setPeripheralRetinaOS(theResults.getInt("peripheralRetinaOS"));
			theFoundExam.setMiscRetinaOS(theResults.getInt("miscRetinaOS"));
			theFoundExam.setDiabeticEvalOS(theResults.getInt("diabeticEvalOS"));
			theFoundExam.setHtnEvalOS(theResults.getInt("htnEvalOS"));
			theFoundExam.setArmdOS(theResults.getInt("armdOS"));
			theFoundExam.setCustom1OS(theResults.getInt("custom1OS"));
			theFoundExam.setCustom2OS(theResults.getInt("custom2OS"));
			theFoundExam.setCustom3OS(theResults.getInt("custom3OS"));
			theFoundExam.setSponVeinPulsOD(theResults.getInt("sponVeinPulsOD"));
			theFoundExam.setFovealReflexOD(theResults.getInt("fovealReflexOD"));
			theFoundExam.setSponVeinPulsOS(theResults.getInt("sponVeinPulsOS"));
			theFoundExam.setFovealReflexOs(theResults.getInt("fovealReflexOs"));
			theFoundExam.setMethodUsed(theResults.getInt("methodUsed"));
			theFoundExam.setGttOD(theResults.getInt("gttOD"));
			theFoundExam.setGttOS(theResults.getInt("gttOS"));
			theFoundExam.setDilationAgent(theResults.getInt("dilationAgent"));
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
			theFoundExam.setOpticNerve(theResults.getInt("opticNerve"));
			theFoundExam.setNerveFiberLayer(theResults.getInt("nerveFiberLayer"));
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
