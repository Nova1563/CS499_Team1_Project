
package cs499_ophthalmology_emr;
import java.sql.*;
import java.time.Duration;
import java.time.Instant;
import org.sqlite.SQLiteConfig;
import java.util.ArrayList;

/**
 * Primary class used to interact with the SQLite database tables. This class is used as an interface/facade into
 * the more specialized AppointmentTableManager PatientTableManager and EyeTestResultsTableManager classes.
 * Use function calls in this class when working with the GUI.
 * <p>
 * Singleton class that contains all the function calls to manipulate and query
 * tables contained in the EMR SQLite database.
 * </p>
 * @version 0.1
 * @author Andrew McKelvy
 * @since Oct 7, 2019
 */
public class DataBaseManager {
	private PatientTableManager patientTable = null;
	private AppointmentTableManager appointmentTable = null;
	private EyeTestResultsTableManager testResultsTable = null;

    private static DataBaseManager thisInstance = null;
	private static final String DB_URL = "jdbc:sqlite:EMR.db";  

	private static Connection conn = null;
	
    // private constructor restricted to this class itself 
    private DataBaseManager() 
    {
		try
		{
			SQLiteConfig config = new SQLiteConfig();  
			config.enforceForeignKeys(true);
			conn = DriverManager.getConnection(DB_URL, config.toProperties()); // Try to connect to test.db no path given means look in the same directory.
			patientTable = new PatientTableManager(conn);
			appointmentTable = new AppointmentTableManager(conn);
			testResultsTable = new EyeTestResultsTableManager(conn);
		}
		catch ( SQLException e )
		{
			System.out.println(e.getMessage());
		}
		catch ( Exception e )
		{
			//System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			e.printStackTrace();
			System.exit(0);
		}							
		
    } 
  
	/**
	 * Creates new instance of the DataBaseManager class if none exists. Returns
	 * the singleton instance if it already exists.
	 * @return DataBaseManager
	 */
    public static DataBaseManager getInstance() 
    { 
        if (thisInstance == null)
		{
            thisInstance = new DataBaseManager();
			//patientTable = PatientTableManager.getInstance(conn);
			//appointmentTable = AppointmentTableManager.getInstance(conn);
		}
  
        return thisInstance; 
    }
	
	/**
	 * For adding a new patient.
	 * Returns an empty Patient object with a unique
	 * patientID assigned to it. 
	 * @return	a new Patient object with unique ID, ready to use.
	 */
	public Patient getNewPatient()
	{
		return patientTable.getNewPatient();
	}
	
	/**
	 * For adding a new appointment.
	 * Returns an empty Appointment with a unique
	 * appointmentID assigned to it.
	 * @param patientID	The patientID that this Appointment will belong to.
	 * @return	a new Appointment object with unique ID, ready to use.
	 */
	public Appointment getNewAppointment(Integer patientID)
	{
		return appointmentTable.getNewAppointment(patientID);
	}
	
	/**
	 * For adding a new eye test result set.
	 * Returns an empty EyeTestResults object with a unique examID,
	 * and associated with a specific appointmentID and patientID.
	 * @return a new EyeTestResults object with unique IDs, ready to use.
	 */
	public EyeTestResults getNewEyeTestResults(Integer patientID, Integer apptID)
	{
		return testResultsTable.getNewEyeTestResults(patientID, apptID);

	}
	
	/**
	 * Saves the info in its incoming Patient object back to SQL.
	 * @param thePatientObj a Patient ready to be stored back in the database.
	 */
	public void save(Patient thePatientObj)
	{
		patientTable.savePatientToSQL(thePatientObj);
	}
	
	/**
	 * Saves the info in its incoming Appointment object back to SQL.
	 * @param theApptObj an Appointment ready to be stored back in the database.
	 */
	public void save(Appointment theApptObj)
	{
		appointmentTable.saveAppointmentToSQL(theApptObj);
	}
	
	/**
	 * Saves the info in its incoming EyeTestResults object back to SQL.
	 * @param theResultsObj an EyeTestResults ready to be stored back in the database.
	 */
	public void save(EyeTestResults theResultsObj)
	{
		testResultsTable.saveEyeTestResultsToSQL(theResultsObj);
	}
	
	public Integer getNumOfPatientEntries()
	{
		return patientTable.getNumOfPatientEntries();
	}
	
	/**
	 * Retrieves a Patient entry from the SQL database with
	 * the matching patientID
	 * @param patientID the ID of the patient requested.
	 * @return a Patient object containing the requested patient's data.
	 */
	public Patient getPatientByID(Integer patientID)
	{
		return patientTable.getPatient(patientID);
	}
	
	public ArrayList<Patient> searchForPatientName(String name)
	{
		return patientTable.getPatientsByName(name);
	}
	
	public ArrayList<Patient> getAllPatients()
	{
		return patientTable.getAllPatients();
	}
	
	public ArrayList<Appointment> getAllAppointments()
	{
		return appointmentTable.getAllAppointments();
	}
	
	/**
	 * Returns an ArrayList of Appointment objects that are associated with the Patient
	 * object passed into it.
	 * NOTE: This may be a redundant method, as Patient class contains a similar method.
	 * @param thePatientObj The Patient object to retrieve Appointments from.
	 * @return an ArrayList of Appointments associated with the patient.
	 */
	public ArrayList<Appointment> getPatientAppointmentList(Patient thePatientObj)
	{
		return appointmentTable.getAppointmentsListByPatientID(thePatientObj.getPatientID());
	}
	
	/**
	 * Returns an Appointment object from SQL with the matching appointmentID. 
	 * @param apptID the ID to match.
	 * @return The matching Appointment object.
	 */
	public Appointment getAppointmentByID(Integer apptID)
	{
		return appointmentTable.getAppointmentByID(apptID);
	}
	
	/**
	 * Returns an ArrayList of Appointments for a particular date.
	 * @param date the date to match to. YYYYMMDD
	 * @return ArrayList of Appointments for a date.
	 */
	public ArrayList<Appointment> getAppointmentListByDate(Integer date)
	{
		return appointmentTable.getAppointmentListByDate(date);
	}
	
	/**
	 * Returns the EyeTestResults object with matching examID.
	 * @param examID the ID to match
	 * @return the matching EyeTestResults object.
	 */
	public EyeTestResults getExamResultsByExamID(Integer examID)
	{
		return testResultsTable.getEyeTestResultsByExamID(examID);
	}
	
	public EyeTestResults getExamResultsByApptID(Integer apptID)
	{
		return testResultsTable.getEyeTestResultsByApptID(apptID);
	}
	
	public ArrayList<EyeTestResults> getAllExamResultsForPatient(Integer patientID)
	{
		return testResultsTable.getAllEyeTestResultsByPatient(patientID);
	}
	
	/**
	 * Deletes a patient from the SQL database.
	 * @param thePatientObj the Patient object of the patient to be deleted.
	 */
	public void delete(Patient thePatientObj)
	{
		//Integer patientID = thePatientObj.getPatientID();
		
		//ArrayList<Appointment> itsAppts = getPatientAppointmentList(thePatientObj);
		
		//itsAppts.forEach(appt -> delete(getExamResultsByApptID(appt.getApptID()))); // Delete SQL entries for patient's Eye Test Results.
		//itsAppts.forEach(appt -> delete(appt));										// Delete SQL entries for patient's Appointments.
		
		patientTable.deletePatient(thePatientObj);									// Delete SQL entry for this Patient.
	}
	
	/**
	 * Deletes an appointment from the SQL database.
	 * @param theApptObj the Appointment object of the appointment to be deleted.
	 */
	public void delete(Appointment theApptObj)
	{
		Integer apptID = theApptObj.getApptID();
		appointmentTable.deleteAppointment(apptID);		// Delete SQL entry for this Appointment.
	}
	
	/**
	 * Deletes an eye test result from the SQL database.
	 * @param theResultsObj the EyeTestResults object of the results to be deleted.
	 */
	public void delete(EyeTestResults theResultsObj)
	{
		testResultsTable.deleteEyeTestResult(theResultsObj.getExamID());
	}
	
	///////////////////////////////// Test Methods and Data ///////////////////////////////
	
	/**
	 * For miscellaneous testing.
	 */
	public void doTest()
	{
		makeNewPatientsFillArrayTest();
                addAppointmentsAndExamsToAllPatientsTest();
                
	}
	
	private void makeNewPatientsFillArrayTest()
	{
		ArrayList<Patient> patients = new ArrayList<Patient>();
		Instant retrievePatientsStart;
		Instant retrievePatientsEnd;
		Instant savePatientsStart;
		Instant savePatientsEnd;
		
		Integer numPatients = 4;
		long nsGetNew = 0;
		long nsSaveNew = 0;
		
		retrievePatientsStart = Instant.now();
		
		for(int i = 1; i <= numPatients; i++)
		{
			Patient aPatient = patientTable.getTestPatientObject();
			patients.add(aPatient);
		}
		
		retrievePatientsEnd = Instant.now();
		
		nsGetNew = Duration.between(retrievePatientsStart, retrievePatientsEnd).toNanos();
		
		/////
		
		savePatientsStart = Instant.now();
		
		patients.forEach((patient -> save(patient)));
		
		savePatientsEnd = Instant.now();
		
		nsSaveNew = Duration.between(savePatientsStart, savePatientsEnd).toNanos();
		
		System.out.println("makeNewPatientsFillArrayTest duration: " + nsGetNew + " nanoseconds for " + numPatients + " entries.\n");
		System.out.println("savePatientsyTest duration: " + nsSaveNew + " nanoseconds for " + numPatients + " entries.\n");
	}
	
	private ArrayList<Patient> getAllPatientsTest()
	{
		ArrayList<Patient> patients;
		Instant retrievePatientsStart;
		Instant retrievePatientsEnd;
		Integer numPatients = getNumOfPatientEntries();
		long ns = 0;
		
		retrievePatientsStart = Instant.now();
		patients = getAllPatients();
		retrievePatientsEnd = Instant.now();
		
		ns = Duration.between(retrievePatientsStart, retrievePatientsEnd).toNanos();
		
		System.out.println("\ngetAllPatientsFillArrayTest duration: " + ns + " nanoseconds for " + numPatients + " entries.\n");
		
		return patients;
	}
	
	private void addAppointmentsAndExamsToAllPatientsTest()
	{
		
		ArrayList<Patient> thePatients = patientTable.getAllPatients();
		Integer numPatients = patientTable.getNumOfPatientEntries();
		
		for(int i = 1; i <= numPatients; i++)
		{
			System.out.println("addAppointmentsAndExamsToAllPatientsTest: " + i);
			Patient currentPatient = thePatients.get(i-1);
			Integer patientID = currentPatient.getPatientID();
			
			
			Appointment anAppt = getNewAppointment(patientID);
			Integer apptID = anAppt.getApptID();
			anAppt.setApptDate(1000);
                        anAppt.setDoctorToSee(apptID);
                        anAppt.setPatientName(DB_URL);
			save(anAppt);
			
			EyeTestResults examResults = getNewEyeTestResults(patientID, apptID);
			examResults.setFarChartDistance(1);
			save(examResults);
			
			
			
			anAppt = getNewAppointment(patientID);
			apptID = anAppt.getApptID();
			anAppt.setAppointmentTime(2000);
			save(anAppt);
			
			examResults = getNewEyeTestResults(patientID, apptID);
			examResults.setFarChartDistance(2);
			save(examResults);
			
			
			
			anAppt = getNewAppointment(patientID);
			apptID = anAppt.getApptID();
			anAppt.setAppointmentTime(3000);
			save(anAppt);
			
			examResults = getNewEyeTestResults(patientID, apptID);
			examResults.setFarChartDistance(3);
			save(examResults);
			
		}
		
	}
	

}
