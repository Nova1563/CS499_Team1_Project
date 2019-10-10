
package cs499_ophthalmology_emr;

import java.sql.*;


/**
* Methods to interact with the Patient Info Table in SQLite database.
*/
public class PatientInfoTable
{
	private Connection conn;
	
	public PatientInfoTable(Connection theConn)
	{
		conn = theConn;
		initPatientInfoTable();
	}

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

	/**
	 * 
	 * @param id	ID of the patient to be deleted from the database.
	 */
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
