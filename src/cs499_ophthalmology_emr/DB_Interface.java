/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;
import java.sql.*;
import org.sqlite.SQLiteConfig;

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
	private static final String DB_URL = "jdbc:sqlite:EMR.db";  

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
			SQLiteConfig config = new SQLiteConfig();  
			config.enforceForeignKeys(true);
			conn = DriverManager.getConnection(DB_URL, config.toProperties()); // Try to connect to test.db no path given means look in the same directory.
			
			patientInfo = new PatientInfoTable(conn);
			appointments = new AppointmentsTable(conn);
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
	

	
	

	
}
