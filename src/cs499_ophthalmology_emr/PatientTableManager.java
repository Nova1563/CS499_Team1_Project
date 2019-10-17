
package cs499_ophthalmology_emr;

import java.sql.*;
import java.util.HashSet;


/**
* Methods to interact with the Patient Info Table in SQLite database.
*/
public class PatientTableManager
{
	private static Connection conn = null;
	
	public PatientTableManager(Connection theConn)
	{
		conn = theConn;
		initPatientTable();
	}

	/**
	* Attempts to build the Patient Info table in SQLite DB if it does not exist.
	* Sets columns, does not add rows.
	*/
	private void initPatientTable()
	{
		// SQL statement for creating the table.
		String createTableString = "CREATE TABLE IF NOT EXISTS patientTable (\n"
		+ "    patientID			integer PRIMARY KEY,\n"
		+ "    name					text,\n"
		+ "    address				text,\n"
		+ "    homePhoneNum			text,\n"
		+ "    workPhoneNum			text,\n"
		+ "    mobilePhoneNum		text,\n"
		+ "    gender				text,\n"
		+ "    title				text,\n"
		+ "    age					integer,\n"
		+ "    dateOfBirth			integer,\n"
		+ "    emailAddr			text,\n"
		+ "    ssn					text,\n"
		+ "    emergContactPhone	text,\n"
		+ "    emergContactName		text,\n"
		+ "    insProvider			text,\n"
		+ "    insContractNo		text,\n"
		+ "    insGroupNo			text,\n"
		+ "    insEffectiveDate		integer,\n"
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
		String printAllEntriesString = "SELECT * from patientTable";
		System.out.println("Begin PatientTableManager.printAllEntries()...");
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
										+ "\tgender: " + queryResults.getString("gender")
										+ "\ttitle: " + queryResults.getString("title")
										+ "\tage: " + queryResults.getInt("age")
										+ "\tdateOfBirth: " + queryResults.getInt("dateOfBirth")
										+ "\temailAddr: " + queryResults.getString("emailAddr")
										+ "\tssn: " + queryResults.getString("ssn")
										+ "\temergContactName: " + queryResults.getString("emergContactName")
										+ "\temergContactPhone: " + queryResults.getString("emergContactPhone")
										+ "\tinsProvider: " + queryResults.getString("insProvider")
										+ "\tinsContractNo: " + queryResults.getString("insContractNo")
										+ "\tinsGroupNo: " + queryResults.getString("insGroupNo")
										+ "\tinsEffectiveDate: " + queryResults.getInt("insEffectiveDate")
										+ "\tinsCoPayAmount: " + queryResults.getFloat("insCoPayAmount")
										+ "\tinsProviderAddr: " + queryResults.getString("insProviderAddr")
										+ "\tinsProviderPhone: " + queryResults.getString("insProviderPhone"));
			}
		}
		catch(SQLException e)
		{
			System.out.println("printAllEntries() PatientTable error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param name	name of the patient to be added to database.
	 * @return		ID of the newly added patient.
	 */
	public Patient getNewPatient()
	{
	//	String addPatient_SQL = "INSERT INTO patientTable (name)\n"
	//		+ "VALUES (?)";
		Patient theNewPatientEntry = new Patient();
		String addPatient_SQL = "INSERT INTO patientTable DEFAULT VALUES";

		int patientID = -1;

		try
		{
			// Add new entry to table. Name is required.
			PreparedStatement theSQLstatement = conn.prepareStatement(addPatient_SQL,
													Statement.RETURN_GENERATED_KEYS);
			//theSQLstatement.setString(1, name);
			theSQLstatement.executeUpdate();

			// Get the newly created patient entry's ID.
			ResultSet newID = theSQLstatement.getGeneratedKeys();
			patientID = newID.getInt(1); // Get the newly generated Patient ID.
			theNewPatientEntry.setPatientID(patientID);
		}
		catch(SQLException e)
		{
			System.out.println("getNewPatient() error: " + e.getMessage());
		}

		return theNewPatientEntry;
	}

	/**
	 * 
	 * @param id	ID of the patient to be deleted from the database.
	 */
	public void deletePatient(Integer patientID)
	{
		String delEntryString = "DELETE FROM patientTable WHERE patientID = ?";

		try
		{
			PreparedStatement theSQLstatement = conn.prepareStatement(delEntryString);

			theSQLstatement.setInt(1, patientID);
			theSQLstatement.executeUpdate();
			System.out.println("Entry in patientTable with ID " + patientID.toString() + " deleted.");
		}
		catch(SQLException e)
		{
			System.out.println("deletePatient(" + patientID.toString() + ") error: " + e.getMessage());
		}
	}
	
	public void updatePatientEntry(Patient thePatient)
	{
		
		Integer patientID = thePatient.getPatientID();
		
		String sqlString = "UPDATE patientTable SET "
						+ "name = ? ,"
						+ "address = ? ,"
						+ "homePhoneNum = ? ,"
						+ "workPhoneNum = ? ,"
						+ "mobilePhoneNum = ? ,"
						+ "gender = ? ,"
						+ "title = ? ,"
						+ "age = ? ,"
						+ "dateOfBirth = ? ,"
						+ "emailAddr = ? ,"
						+ "ssn = ? ,"
						+ "emergContactName = ? ,"
						+ "emergContactPhone = ? ,"
						+ "insProvider = ? ,"
						+ "insContractNo = ? ,"
						+ "insGroupNo = ? ,"
						+ "insEffectiveDate = ? ,"
						+ "insCoPayAmount = ? ,"
						+ "insProviderAddr = ? ,"
						+ "insProviderPhone = ? "
						+ "WHERE patientID = ? ";
		
		try
		{
			PreparedStatement theSQLstatement = conn.prepareStatement(sqlString);

			theSQLstatement.setString(1, thePatient.getName());
			theSQLstatement.setString(2, thePatient.getAddress());
			theSQLstatement.setString(3, thePatient.getHomePhone());
			theSQLstatement.setString(4, thePatient.getWorkPhone());
			theSQLstatement.setString(5, thePatient.getMobilePhone());
			theSQLstatement.setString(6, thePatient.getGender());
			theSQLstatement.setString(7, thePatient.getTitle());
			theSQLstatement.setInt(8, thePatient.getAge());
			theSQLstatement.setInt(9, thePatient.getDateOfBirth());
			theSQLstatement.setString(10, thePatient.getEmailAddress());
			theSQLstatement.setString(11, thePatient.getSsn());
			theSQLstatement.setString(12, thePatient.getEmergContactName());
			theSQLstatement.setString(13, thePatient.getEmergContactPhone());
			theSQLstatement.setString(14, thePatient.getInsProvider());
			theSQLstatement.setString(15, thePatient.getInsContractNo());
			theSQLstatement.setString(16, thePatient.getInsGroupNo());
			theSQLstatement.setInt(17, thePatient.getInsEffectiveDate());
			theSQLstatement.setDouble(18, thePatient.getInsCoPayAmount());
			theSQLstatement.setString(19, thePatient.getInsProviderAddr());
			theSQLstatement.setString(20 ,thePatient.getInsProviderPhone());
			theSQLstatement.setInt(21 , patientID);
			
			theSQLstatement.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("updatePatientInfo(" + patientID.toString() + ", PatientInfo ...) error: " + e.getMessage());
		}
	
	}
	
	private ResultSet getPatientEntryResultSet(Integer patientID)
	{
		ResultSet queryResults = null;
		String sqlString = "SELECT * FROM patientTable WHERE patientID = ?";
		
		try
		{

			PreparedStatement theSQLstatement = conn.prepareStatement(sqlString);
			queryResults = theSQLstatement.executeQuery(sqlString);
		
		}
		catch (SQLException e)
		{
			System.out.println("getPatientEntryResultSet(" + patientID.toString() + ") error: " + e.getMessage());
		}
				
		return queryResults;
	}
	
	/////////////////////////// Test Methods and Data ////////////////////////////////
	
	// TODO: generate random pools of data to pull from.
	
	public void doTest()
	{
		Patient testSubject = getTestPatientObject();
		System.out.println("Default Patient fields:" );
		printAllEntries();
		
		updatePatientEntry(testSubject);
		System.out.println("Updated Patient fields:");
		printAllEntries();
		
		deletePatient(testSubject.getPatientID());
		printAllEntries();
	}
	
	private Patient getTestPatientObject()
	{
		Patient thePatient = getNewPatient();
		
		thePatient.setName("How is that?");
		thePatient.setAddress("address goes here");
		thePatient.setAge(44);
		thePatient.setDateOfBirth(121575);
		thePatient.setEmailAddress("Im@YoMommas.house");
		thePatient.setHomePhone("123456789");
		thePatient.setWorkPhone("8675309");
		thePatient.setMobilePhone("MyNumbah");
		thePatient.setGender("Popcicle");
		thePatient.setTitle("The Magnificent");
		thePatient.setSsn("456-456-1234");
		thePatient.setEmergContactName("Zombie Bob");
		thePatient.setEmergContactPhone("1-800-WhatWhoHuh");
		thePatient.setInsProvider("Red Sword Red Dagger");
		thePatient.setInsGroupNo("Grp55567");
		thePatient.setInsContractNo("00000-1");
		thePatient.setInsEffectiveDate(122987);
		thePatient.setInsCoPayAmount(45.55);
		thePatient.setInsProviderAddr("123 Insurance Drive");
		thePatient.setInsProviderPhone("6547764578");
		//TODO: set all fields randomly.
		
		return thePatient;
	}
	
	
	
}
