
package cs499_ophthalmology_emr;
/**
 *
 * @author BitSanity
 */

public class CS499_Ophthalmology_EMR {      
	public static void main( String args[] )
	{
		DB_Interface dataBase = DB_Interface.getInstance();
		
		int newPatientID = -1;
		
		//newPatientID = dataBase.patientInfo.addPatient("Andrew McKelvy");
		//System.out.println("New ID created: " + newPatientID);
		
		dataBase.patientInfo.printAllEntries();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		// This functionality moved to the DB_Interface class.
		// This should be deleted eventually, but is left here for now for
		// reference. -AM
  /*
    public static void createTable(Connection conn)
    {
		// SQL statement for creating a new table
		String createTableString = "CREATE TABLE IF NOT EXISTS patientInfo (\n"
		+ "    id integer PRIMARY KEY,\n"
		+ "    name text NOT NULL,\n"
		+ "    address text NOT NULL,\n"
                + "    zip     text NOT NULL\n"
		+ ");";
    
		try
		{
			Statement theSQLstatement = conn.createStatement();
			theSQLstatement.execute(createTableString);
		}
		catch(SQLException e)
		{
		    System.out.println("createTable() error: " + e.getMessage());
		}
    }
	
	public static void addTableEntry(Connection conn, String name, String address, String zip)
	{
		String addEntryString = "INSERT INTO patientInfo (name, address, zip)\n"
				+ "VALUES (?,?,?)";
		
		try
		{
		    PreparedStatement theSQLstatement = conn.prepareStatement(addEntryString);
			
			theSQLstatement.setString(1, name);
			theSQLstatement.setString(2, address);
                        theSQLstatement.setString(3, zip);
			theSQLstatement.executeUpdate();
			System.out.println("Table entry added.");
		}
		catch(SQLException e)
		{
		    System.out.println("addTableEntry() error: " + e.getMessage());
		}
	}
	
	public static void deleteTableEntryWithID(Connection conn, int id)
	{
		String delEntryString = "DELETE FROM patientInfo WHERE id = ?";
		
		try
		{
		    PreparedStatement theSQLstatement = conn.prepareStatement(delEntryString);
			
			theSQLstatement.setInt(1, id);
			theSQLstatement.executeUpdate();
			System.out.println("Table entry deleted.");
		}
		catch(SQLException e)
		{
		    System.out.println("deleteTableEntryWithID() error: " + e.getMessage());
		}
	}
	
	public static void printAllEntries(Connection conn)
	{
		String printAllEntriesString = "SELECT * from patientInfo";
		
		try
		{
			Statement theSQLstatement = conn.createStatement();
			ResultSet queryResults = theSQLstatement.executeQuery(printAllEntriesString);
			
			while (queryResults.next())
			{
				System.out.println("RowID: " + queryResults.getInt("id") + "\tName: " 
                                        + queryResults.getString("name") 
                                        + "\tAddress: " + queryResults.getString("address")
                                        + "\tZip: " + queryResults.getString("zip"));
			}
		}
		catch(SQLException e)
		{
		    System.out.println("printAllEntries() error: " + e.getMessage());
		}
	}
	*/
}