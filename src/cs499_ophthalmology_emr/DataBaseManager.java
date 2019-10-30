
package cs499_ophthalmology_emr;
import java.sql.*;
import java.util.HashSet;
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
		//TODO: Impletment TableManager function.
		System.out.println("DataBaseManager.save(EyeTestResults) not yet implemented.");
		//testResultsTable.saveEyeTestResultsToSQL(theResultsObj);
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
	public EyeTestResults getExamResultsByID(Integer examID)
	{
		//TODO: Implement TableManager function.
		System.out.println("DataBaseManager.getExamResultsByID() not yet implemented.");
		//return testResultsTable.getExamResultsByID(examID);
		return null;
	}
	
	// TODO: EyeTestResultsTable related functions.
	
	/**
	 * Deletes a patient from the SQL database.
	 * @param thePatientObj the Patient object of the patient to be deleted.
	 */
	public void delete(Patient thePatientObj)
	{
		patientTable.deletePatient(thePatientObj);
	}
	
	/**
	 * Deletes an appointment from the SQL database.
	 * @param theApptObj the Appointment object of the appointment to be deleted.
	 */
	public void delete(Appointment theApptObj)
	{
		appointmentTable.deleteAppointment(theApptObj.getApptID());
	}
	
	/**
	 * Deletes an eye test result from the SQL database.
	 * @param theResultsObj the EyeTestResults object of the results to be deleted.
	 */
	public void delete(EyeTestResults theResultsObj)
	{
		// TODO: implement TableManager function.
	}
	
	///////////////////////////////// Test Methods and Data ///////////////////////////////
	
	/**
	 * For miscellaneous testing.
	 */
	public void doTest()
	{
		System.out.println("\nBegin DB_Interface.doTest()...");
		// Get a new patient object from SQL handler.
		Patient testSubject1 = patientTable.getNewPatient(); // Get the actual Patient object.
		Integer patient1ID = testSubject1.getPatientID();	// Get the Patient object's patientID.
		System.out.println(patient1ID.toString());
		
		
		// Get a new Appointment object and attach it to the Patient object.
		Appointment itsAppointment = appointmentTable.getNewAppointment(patient1ID);
		Integer apptID = itsAppointment.getApptID();
		testSubject1.attachAppointment(itsAppointment);
		itsAppointment.setPatientName(testSubject1.getName());
		System.out.println(itsAppointment.getPatientName());
		itsAppointment.setArrivalStatus(2);
		appointmentTable.saveAppointmentToSQL(itsAppointment);
		
		EyeTestResults anExamReport = getNewEyeTestResults(patient1ID, apptID);
		
		patientTable.printAllEntries();
		appointmentTable.printAllEntries();
		testResultsTable.printAllEntries();
		
		
		// Clean up.
		//appointmentTable.deleteAppointment(itsAppointment.getApptID());
		//patientTable.deletePatient(patient1ID);
		//patientTable.getAllPatients();
		System.out.println("End DB_Interface.doTest().\n");
	}
	

	
}
