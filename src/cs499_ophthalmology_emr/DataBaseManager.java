/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;
import java.sql.*;
import java.util.HashSet;
import org.sqlite.SQLiteConfig;
import java.util.ArrayList;

/**
 * Class used to interact with the SQLite database tables.
 * <p>
 * Singleton class that contains all the function calls to manipulate and query
 * tables contained in the EMR SQLite database.
 * </p>
 * @version 0.1
 * @author Andrew McKelvy
 * @since Oct 7, 2019
 */
public class DataBaseManager {
	PatientTableManager patientTable = null;
	AppointmentTableManager appointmentTable = null;
	EyeTestResultsTableManager testResultsTable = null;
	
	/**
	 * Static variable DB_IF_instance of type DB_Interface. (THE instance of this class.)
	*/
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
	 * Creates new instance of the DB_Interface class if none exists. Returns
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
	 * Returns an empty Patient object with a unique
	 * patientID assigned to it.
	 * @return	a new Patient object with unique ID, ready to use.
	 */
	public Patient getNewPatient()
	{
		return patientTable.getNewPatient();
	}
	
	/**
	 * Returns an empty Appointment with a unique appointmentID
	 * assigned to it.
	 * @param patientID	The patientID that this Appointment will belong to.
	 * @return	a new Appointment object with unique ID, ready to use.
	 */
	public Appointment getNewAppointment(Integer patientID)
	{
		return appointmentTable.getNewAppointment(patientID);
	}
	
	/**
	 * Returns an empty EyeTestResults object with a unique examID,
	 * and associated with a specific appointmentID and patientID.
	 * @return a new EyeTestResults object with unique IDs, ready to use.
	 */
	public EyeTestResults getNewEyeTestResults()
	{
		//TODO: Implement this and TableManager function.
		System.out.println("DataBaseManager.getNewEyeTestResults() not yet implemented.");
		return null;
	}
	
	/**
	 * Saves the info in the incoming Patient object back to SQL.
	 * @param thePatientObj a Patient ready to be stored back in the database.
	 */
	public void save(Patient thePatientObj)
	{
		patientTable.savePatientToSQL(thePatientObj);
	}
	
	/**
	 * Saves the info in the incoming Appointment object back to SQL.
	 * @param theApptObj an Appointment ready to be stored back in the database.
	 */
	public void save(Appointment theApptObj)
	{
		appointmentTable.saveAppointmentToSQL(theApptObj);
	}
	
	/**
	 * Saves the info in the incoming EyeTestResults object back to SQL.
	 * @param theResultsObj an EyeTestResults ready to be stored back in the database.
	 */
	public void save(EyeTestResults theResultsObj)
	{
		//TODO: Impletment TableManager function.
		System.out.println("DataBaseManager.save(EyeTestResults) not yet implemented.");
		//testResultsTable.saveEyeTestResultsToSQL(theResultsObj);
	}
	
	public Patient getPatientByID(Integer patientID)
	{
		return patientTable.getPatient(patientID);
	}
	
	public ArrayList<Appointment> getPatientAppointmentList(Patient thePatientObj)
	{
		return appointmentTable.getAppointmentsListByPatientID(thePatientObj.getPatientID());
	}
	
	public Appointment getAppointmentByID(Integer apptID)
	{
		return appointmentTable.getAppointmentByID(apptID);
	}
	
	public ArrayList<Appointment> getAppointmentListByDate(Integer date)
	{
		//TODO: Insert table field, update Appointment, implement AppointmentsTableManager function.
		System.out.println("DataBaseManager.getAppointmentByDate() not yet implemented.");
		return appointmentTable.getAppointmentListByDate(date);
		//return null;
	}
	
	public EyeTestResults getExamResultsByID(Integer examID)
	{
		//TODO: Implement TableManager function.
		System.out.println("DataBaseManager.getExamResultsByID() not yet implemented.");
		//return testResultsTable.getExamResultsByID(examID);
		return null;
	}
	
	// TODO: EyeTestResultsTable related functions.
	
	public void delete(Patient thePatientObj)
	{
		patientTable.deletePatient(thePatientObj);
	}
	
	public void delete(Appointment theApptObj)
	{
		appointmentTable.deleteAppointment(theApptObj.getApptID());
	}
	
	public void delete(EyeTestResults theResultsObj)
	{
		// TODO: implement TableManager function.
	}
	
	///////////////////////////////// Test Methods and Data ///////////////////////////////
	
	public void doTest()
	{
		System.out.println("\nBegin DB_Interface.doTest()...");
		// Get a new patient object from SQL handler.
		Patient testSubject1 = patientTable.getNewPatient(); // Get the actual Patient object.
		Integer patient1ID = testSubject1.getPatientID();	// Get the Patient object's patientID.
		
		
		
		// Get a new Appointment object and attach it to the Patient object.
		Appointment itsAppointment = appointmentTable.getNewAppointment(patient1ID);
		testSubject1.attachAppointment(itsAppointment);
		itsAppointment.setPatientName(testSubject1.getName());
		itsAppointment.setArrivalStatus(2);
		appointmentTable.saveAppointmentToSQL(itsAppointment);
		//itsAppointment = appointmentTable.getNewAppointment(patient1ID);
		//testSubject1.attachAppointment(itsAppointment);
		
		patientTable.printAllEntries();
		appointmentTable.printAllEntries();
		
		// Clean up.
		//appointmentTable.deleteAppointment(itsAppointment.getApptID());
		//patientTable.deletePatient(patient1ID);
		
		System.out.println("End DB_Interface.doTest().\n");
	}
	

	
}
