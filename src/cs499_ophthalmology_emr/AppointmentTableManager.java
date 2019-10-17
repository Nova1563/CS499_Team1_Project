
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
										+ "patientName			Text,"
										+ "appointmentTime		Integer,\n"
										+ "arrivalStatus		Integer,\n"
										+ "arrivalTime			Integer,\n"
										+ "doctorToSee			Integer,\n"
										+ "FOREIGN KEY(patientID) \n"
										+ "	REFERENCES patientTable(patientID)\n"
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
	 * @return		Ref to the newly created appointment.
	 */
	public Appointment getNewAppointment(Integer patientID)
	{
		String addAppointment_SQL = "INSERT INTO appointmentsTable (patientID)\n"
			+ "VALUES (?)";
		
		Appointment theNewAppointment = null;
		Integer apptID = -1;

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
			theNewAppointment = new Appointment(apptID, patientID);
			
		}
		catch(SQLException e)
		{
			System.out.println("addAppointment(" + patientID.toString() + ") error: " + e.getMessage());
		}

		return theNewAppointment;
	}
	
	public void deleteAppointment(Integer apptID)
	{
		String delEntryString = "DELETE FROM appointmentsTable WHERE apptID = ?";

		try
		{
			PreparedStatement theSQLstatement = conn.prepareStatement(delEntryString);

			theSQLstatement.setInt(1, apptID);
			theSQLstatement.executeUpdate();
			System.out.println("Entry in appointmentsTable with ID " + apptID.toString() + " deleted.");
		}
		catch(SQLException e)
		{
			System.out.println("deletePatient(" + apptID.toString() + ") error: " + e.getMessage());
		}
	}


	/**
	* Prints all entries in Appointments Table to console.
	* For debugging purposes.
	*/
	public void printAllEntries()
	{
		String printAllEntriesString = "SELECT * from appointmentsTable";
		System.out.println("Begin AppointmentTableManager.printAllEntries()...");
		try
		{

			Statement theSQLstatement = conn.createStatement();
			ResultSet queryResults = theSQLstatement.executeQuery(printAllEntriesString);

			while (queryResults.next())
			{
				System.out.println("apptID: " + queryResults.getInt("apptID")
										+ "\tpatientID: " 	+ queryResults.getInt("patientID") 
										+ "\tpatientName: " + queryResults.getString("patientName")
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