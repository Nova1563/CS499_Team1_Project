/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;
import java.sql.*;

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
public class DB_Interface {
	/**
	 * Static variable DB_IF_instance of type DB_Interface. (THE instance of this class.)
	*/
    private static DB_Interface DB_IF_instance = null;
	
	static PatientInfoTable patientInfo = null;
	static AppointmentsTable appointments = null;
	
	
	/**
	 * SQLite JDBC connection object.
	 */
	private static Connection conn = null;
	
    // private constructor restricted to this class itself 
    private DB_Interface() 
    {
		try
		{
			conn = DriverManager.getConnection("jdbc:sqlite:EMR.db"); // Try to connect to test.db no path given means look in the same directory.
			patientInfo = new PatientInfoTable();
			patientInfo.initPatientInfoTable();
			appointments = new AppointmentsTable();
			appointments.initAppointmentsTable();
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
	 * @return DB_Interface
	 */
    public static DB_Interface getInstance() 
    { 
        if (DB_IF_instance == null) 
            DB_IF_instance = new DB_Interface(); 
  
        return DB_IF_instance; 
    }
	
	/**
	* Methods to interact with the Patient Info Table in SQLite database.
	*/
	public class PatientInfoTable
	{
		/**
		* Attempts to build the Patient Info table in SQLite DB if it does not exist.
		* Sets columns, does not add rows.
		*/
		private void initPatientInfoTable()
		{
			// SQL statement for creating the table.
			String createTableString = "CREATE TABLE IF NOT EXISTS patientInfo (\n"
			+ "    patientID			integer PRIMARY KEY,\n"
			+ "    name					text NOT NULL,\n"
			+ "    address				text,\n"
			+ "    homePhoneNum			text,\n"
			+ "    workPhoneNum			text,\n"
			+ "    mobilePhoneNum		text,\n"
			+ "    gender				integer,\n"
			+ "    title				text,\n"
			+ "    age					integer,\n"
			+ "    dateOfBirth			text,\n"
			+ "    emailAddr			text,\n"
			+ "    ssn					text,\n"
			+ "    emergContactPhone	text,\n"
			+ "    emergContactName		text,\n"
			+ "    insProvider			text,\n"
			+ "    insContractNo		text,\n"
			+ "    insGroupNo			text,\n"
			+ "    insEffectiveDate		text,\n"
			+ "    insCoPayAmount		real,\n"		
			+ "    insProviderAddr		text,\n"		
			+ "    insProviderPhone		text\n"
			+ ");";

			try
			{
				Statement theSQLstatement = conn.createStatement();
				theSQLstatement.execute(createTableString);
			}
			catch(SQLException e)
			{
				System.out.println("initPatientInfo() error: " + e.getMessage());
			}
		}
		
		/**
		 * Prints all entries in Patient Info Table to console.
		 * For debugging purposes.
		 */
		public void printAllEntries()
		{
			String printAllEntriesString = "SELECT * from patientInfo";

			try
			{
				
				Statement theSQLstatement = conn.createStatement();
				ResultSet queryResults = theSQLstatement.executeQuery(printAllEntriesString);

				while (queryResults.next())
				{
					System.out.println("patientID: " + queryResults.getInt("patientID")
											+ "\tname: " 	+ queryResults.getString("name") 
											+ "\taddress: " + queryResults.getString("address")
											+ "\thomePhoneNum: " + queryResults.getString("homePhoneNum")
											+ "\tworkPhoneNum: " + queryResults.getString("workPhoneNum")
											+ "\tmobilePhoneNum: " + queryResults.getString("mobilePhoneNum")
											+ "\tgender: " + queryResults.getInt("gender")
											+ "\ttitle: " + queryResults.getString("title")
											+ "\tage: " + queryResults.getInt("age")
											+ "\tdateOfBirth: " + queryResults.getString("dateOfBirth")
											+ "\temailAddr: " + queryResults.getString("emailAddr")
											+ "\tssn: " + queryResults.getString("ssn")
											+ "\temergContactName: " + queryResults.getString("emergContactName")
											+ "\temergContactPhone: " + queryResults.getString("emergContactPhone")
											+ "\tinsProvider: " + queryResults.getString("insProvider")
											+ "\tinsContractNo: " + queryResults.getString("insContractNo")
											+ "\tinsGroupNo: " + queryResults.getString("insGroupNo")
											+ "\tinsEffectiveDate: " + queryResults.getString("insEffectiveDate")
											+ "\tinsCoPayAmount: " + queryResults.getFloat("insCoPayAmount")
											+ "\tinsProviderAddr: " + queryResults.getString("insProviderAddr")
											+ "\tinsProviderPhone: " + queryResults.getString("ssn"));
				}
			}
			catch(SQLException e)
			{
				System.out.println("printAllEntries() PatientInfoTable error: " + e.getMessage());
				e.printStackTrace();
			}
		}
		
		/**
		 * 
		 * @param name	name of the patient to be added to database.
		 * @return		ID of the newly added patient.
		 */
		public int addPatient(String name)
		{
			String addPatient_SQL = "INSERT INTO patientInfo (name)\n"
				+ "VALUES (?)";
	
			int patientID = -1;
			
			try
			{
				// Add new entry to table. Name is required.
				PreparedStatement theSQLstatement = conn.prepareStatement(addPatient_SQL,
														Statement.RETURN_GENERATED_KEYS);
				theSQLstatement.setString(1, name);
				theSQLstatement.executeUpdate();
				
				// Get the newly created patient entry's ID.
				ResultSet newID = theSQLstatement.getGeneratedKeys();
				patientID = newID.getInt(1); // Get the newly generated Patient ID.
			}
			catch(SQLException e)
			{
				System.out.println("addPatient() error: " + e.getMessage());
			}
			
			return patientID;
		}
		
		public void deletePatient(int id)
		{
			String delEntryString = "DELETE FROM patientInfo WHERE id = ?";

			try
			{
				PreparedStatement theSQLstatement = conn.prepareStatement(delEntryString);

				theSQLstatement.setInt(1, id);
				theSQLstatement.executeUpdate();
				//System.out.println("Table entry deleted.");
			}
			catch(SQLException e)
			{
				System.out.println("deletePatient() error: " + e.getMessage());
			}
		}
	}
	
	public class AppointmentsTable{
		
		private void initAppointmentsTable()
		{
			String createTableString = "CREATE TABLE IF NOT EXISTS appointments(\n"
											+ "apptID				Integer PRIMARY KEY,\n"
											+ "patientID			Integer NOT NULL,\n"
											+ "appointmentTime		Integer,\n"
											+ "arrivalStatus		Integer,\n"
											+ "arrivalTime			Integer,\n"
											+ "doctorToSee			Integer,\n"
											+ "FOREIGN KEY(patientID) \n"
											+ "	REFERENCES patientInfo(patientID)\n"
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
		
		public int addAppointment(int patientID)
		{
			String addAppointment_SQL = "INSERT INTO appointments (patientID)\n"
				+ "VALUES (?)";
	
			int apptID = -1;
			
			try
			{
				// Add new entry to table. patientID is required.
				PreparedStatement theSQLstatement = conn.prepareStatement(addAppointment_SQL,
														Statement.RETURN_GENERATED_KEYS);
				theSQLstatement.setInt(1, patientID);
				theSQLstatement.executeUpdate();
				
				// Get the newly created patient entry's ID.
				ResultSet newID = theSQLstatement.getGeneratedKeys();
				patientID = newID.getInt(1); // Get the newly generated Patient ID.
			}
			catch(SQLException e)
			{
				System.out.println("addAppointment() error: " + e.getMessage());
			}
			
			return apptID;
		}
		
		
		
		public void printAllEntries()
		{
			String printAllEntriesString = "SELECT * from appointments";

			try
			{
				
				Statement theSQLstatement = conn.createStatement();
				ResultSet queryResults = theSQLstatement.executeQuery(printAllEntriesString);

				while (queryResults.next())
				{
					System.out.println("apptID: " + queryResults.getInt("apptID")
											+ "\tpatientID: " 	+ queryResults.getInt("patientID") 
											+ "\tappointmentTime: " + queryResults.getInt("appointmentTime")
											+ "\tarrivalStatus: " + queryResults.getInt("arrivalStatus")
											+ "\tarrivalTime: " + queryResults.getInt("arrivalTime")
											+ "\tdoctorToSee: " + queryResults.getInt("doctorToSee"));
				}
			}
			catch(SQLException e)
			{
				System.out.println("printAllEntries() AppointmentsTable error: " + e.getMessage());
				e.printStackTrace();
			}
		}
		
	}
	
}
