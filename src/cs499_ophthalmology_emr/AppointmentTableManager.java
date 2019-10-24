
package cs499_ophthalmology_emr;

import java.sql.*;
import java.util.ArrayList;
//import java.util.List;
/**
* For use only by the DataBaseManager class.
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
										+ "patientName			Text,\n"
										+ "apptDate				Integer, \n"
										+ "reasonForVisit		Text,\n"
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
	
	/**
	 * 
	 * @param apptID The appointment ID to match
	 * @return the Appointment from database with matching ID
	 */
	public Appointment getAppointmentByID(Integer apptID)
	{
		Appointment apptToReturn = null;
		
		String theSQLstatementStr = "SELECT * from appointmentsTable WHERE apptID = ?";

		try
		{

			PreparedStatement theSQLstatement = conn.prepareStatement(theSQLstatementStr);
			theSQLstatement.setInt(1, apptID);
			ResultSet appointmentInfo = theSQLstatement.executeQuery(theSQLstatementStr);
			apptToReturn = new Appointment(appointmentInfo.getInt("apptID"), appointmentInfo.getInt("patientID"));
			 
			apptToReturn.setPatientName(appointmentInfo.getString("patientName"));
			apptToReturn.setApptDate(appointmentInfo.getInt("apptDate"));
			apptToReturn.setAppointmentTime(appointmentInfo.getInt("appointmentTime"));
			apptToReturn.setArrivalStatus(appointmentInfo.getInt("arrivalStatus"));
			apptToReturn.setArrivalTime(appointmentInfo.getInt("arrivalTime"));
			apptToReturn.setDoctorToSee(appointmentInfo.getInt("doctorToSee"));
			apptToReturn.setReasonForVisit(appointmentInfo.getString("reasonForVisit"));
		}
		catch(SQLException e)
		{
			System.out.println("getAppointmentByID(" + apptID.toString() + ") error: " + e.getMessage());
			e.printStackTrace();
		}
		
		return apptToReturn;
	}
	
	/**
	 * Returns an ArrayList of all Appointments that belong to a matching patientID.
	 * @param patientID The ID of the patient to retrieve from.
	 * @return ArrayList of Appointment objects containing all of a patient's appointments.
	 */
	public ArrayList<Appointment> getAppointmentsListByPatientID(Integer patientID)
	{
		ArrayList<Appointment> theApptList = new ArrayList<Appointment>();
		
		Appointment theFoundAppt = null;
		
		String theSQLstatementStr = "SELECT * from appointmentsTable WHERE patientID = ?";

		try
		{
			PreparedStatement theSQLstatement = conn.prepareStatement(theSQLstatementStr);
			theSQLstatement.setInt(1, patientID);
			ResultSet appointmentInfo = theSQLstatement.executeQuery(theSQLstatementStr);
			
			while (appointmentInfo.next())
			{
				theFoundAppt = new Appointment(appointmentInfo.getInt("apptID"), appointmentInfo.getInt("patientID"));

				theFoundAppt.setPatientName(appointmentInfo.getString("patientName"));
				theFoundAppt.setApptDate(appointmentInfo.getInt("apptDate"));
				theFoundAppt.setAppointmentTime(appointmentInfo.getInt("appointmentTime"));
				theFoundAppt.setArrivalStatus(appointmentInfo.getInt("arrivalStatus"));
				theFoundAppt.setArrivalTime(appointmentInfo.getInt("arrivalTime"));
				theFoundAppt.setDoctorToSee(appointmentInfo.getInt("doctorToSee"));
				theFoundAppt.setReasonForVisit(appointmentInfo.getString("reasonForVisit"));

				theApptList.add(theFoundAppt);
			}
		}
		catch(SQLException e)
		{
			System.out.println("getAppointmentsListByPatientID(" + patientID.toString() + ") error: " + e.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return theApptList;
	}
	
	public ArrayList<Appointment> getAppointmentListByDate(Integer date)
	{
		ArrayList<Appointment> theApptList = new ArrayList<Appointment>();
		
		Appointment theFoundAppt = null;
		
		String theSQLstatementStr = "SELECT * from appointmentsTable WHERE date = ?";

		try
		{
			PreparedStatement theSQLstatement = conn.prepareStatement(theSQLstatementStr);
			theSQLstatement.setInt(1, date);
			ResultSet appointmentInfo = theSQLstatement.executeQuery(theSQLstatementStr);
			
			while (appointmentInfo.next())
			{
				theFoundAppt = new Appointment(appointmentInfo.getInt("apptID"), appointmentInfo.getInt("patientID"));

				theFoundAppt.setPatientName(appointmentInfo.getString("patientName"));
				theFoundAppt.setApptDate(appointmentInfo.getInt("apptDate"));
				theFoundAppt.setAppointmentTime(appointmentInfo.getInt("appointmentTime"));
				theFoundAppt.setArrivalStatus(appointmentInfo.getInt("arrivalStatus"));
				theFoundAppt.setArrivalTime(appointmentInfo.getInt("arrivalTime"));
				theFoundAppt.setDoctorToSee(appointmentInfo.getInt("doctorToSee"));
				theFoundAppt.setReasonForVisit(appointmentInfo.getString("reasonForVisit"));

				theApptList.add(theFoundAppt);
			}
		}
		catch(SQLException e)
		{
			System.out.println("getAppointmentsListByPatientID(" + date.toString() + ") error: " + e.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return theApptList;
	}
	
	/**
	 * Saves an Appointment back into SQL database.
	 * @param theAppt The modified Appointment object.
	 */
	public void saveAppointmentToSQL(Appointment theAppt)
	{
		Integer apptID = theAppt.getApptID();
		
		String sqlString = "UPDATE appointmentsTable SET "
						+ "patientName = ? ,"
						+ "apptDate = ? ,"
						+ "appointmentTime = ? ,"
						+ "reasonForVisit = ? ,"
						+ "arrivalStatus = ? ,"
						+ "arrivalTime = ?, "
						+ "doctorToSee = ? "
						+ "WHERE apptID = ? ";
		
		try
		{
			PreparedStatement theSQLstatement = conn.prepareStatement(sqlString);

			theSQLstatement.setString(1, theAppt.getPatientName());
			theSQLstatement.setInt(2, theAppt.getApptDate());
			theSQLstatement.setInt(3, theAppt.getAppointmentTime());
			theSQLstatement.setString(4, theAppt.getReasonForVisit());
			theSQLstatement.setInt(5, theAppt.getArrivalStatus());
			theSQLstatement.setInt(6, theAppt.getArrivalTime());
			theSQLstatement.setInt(7, theAppt.getDoctorToSee());
			theSQLstatement.setInt(8, apptID);
			
			theSQLstatement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("saveAppointmentToSQL() error: " + e.getMessage());
		}
	}
	
	/**
	 * Deletes an appointment from the SQL database with the matching ID.
	 * @param apptID The ID of the appointment to delete.
	 */
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
										+ "\tapptDate: " + queryResults.getInt("apptDate")
										+ "\tappointmentTime: " + queryResults.getInt("appointmentTime")
										+ "\treasonForVisit: " + queryResults.getString("reasonForVisit")
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