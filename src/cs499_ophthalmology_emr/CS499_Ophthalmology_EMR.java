/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;

/**
 *
 * @author TheWitchDoctor
 */

//public class CS499_Ophthalmology_EMR {

    /**
     * @param args the command line arguments
     */
 //   public static void main(String[] args) {
        // TODO code application logic here
 //   }
    
//}

import java.sql.*;
// This is only to test JDBC. This should not be coded into.
public class CS499_Ophthalmology_EMR {      
	public static void main( String args[] )
	{
		Connection conn = null;
      
		try
		{
			//Class.forName("org.sqlite.JDBC");  // This is probably not necessary. Used for legacy implementations.
			conn = DriverManager.getConnection("jdbc:sqlite:test.db"); // Try to connect to test.db no path given means look in the same directory
										// as the program. to specify another path, you'd do something like "jdbc:sqlite:C:/TestDir/test2.db"
			createTable(conn);
			addTableEntry(conn, "Andrew", "Huntsville, AL", "35649");
			//deleteTableEntryWithID(conn, 1);
			printAllEntries(conn);
	 
		} catch ( Exception e )
		{
			//System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("ANGELA WAS HERE FIRST B4 THIS DECIDED TO BE FAKKKKEEE >:-(");
		System.out.println("Opened database successfully");
		System.out.println("I was here - Ryan");
		System.out.println("Andrew was here too, son!");
		System.out.println("Kendal");
		System.out.println("Testing on my laptop luuuul");
	
		
		
		
		
      
   }
  
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
}