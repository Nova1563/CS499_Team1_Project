
package cs499_ophthalmology_emr;

import java.sql.*;

/**
* Methods to interact with the Appointments Table in SQLite database.
*/
public class AppointmentTableManager{
	
	private static Connection conn;
	
	public AppointmentTableManager(Connection theConn)
	{
		conn = theConn;
		initAppointmentsTable();
	}
	
	/**
	* Attempts to build the Appointments table in SQLite DB if it does not exist.
	* Sets columns, does not add rows.
	*/
	private void initAppointmentsTable()
	{
		String createTableString = "CREATE TABLE IF NOT EXISTS appointmentsTable(\n"
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

	/**
	 * 
	 * @param patientID		patientID that the new appointment will be associated with.
	 * @return		ID of the newly added appointment.
	 */
	public int addAppointment(int patientID)
	{
		String addAppointment_SQL = "INSERT INTO appointmentsTable (patientID)\n"
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
			apptID = newID.getInt(1); // Get the newly generated Patient ID.
		}
		catch(SQLException e)
		{
			System.out.println("addAppointment() error: " + e.getMessage());
		}

		return apptID;
	}


	/**
	* Prints all entries in Appointments Table to console.
	* For debugging purposes.
	*/
	public void printAllEntries()
	{
		String printAllEntriesString = "SELECT * from appointmentsTable";

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