
package cs499_ophthalmology_emr;

import java.sql.*;

/**
 *
 * @author Andrew McKelvy
 */
public class EyeTestResultsTableManager {
	
	private static Connection conn;
	
	public EyeTestResultsTableManager(Connection theConn)
	{
		this.conn = theConn;
		initEyeTestResultsTable();
	}
	
	private void initEyeTestResultsTable()
	{
		String createTableString = "CREATE TABLE IF NOT EXISTS eyeTestResults(\n"
										+ "resultsID			Integer PRIMARY KEY,\n"
										+ "patientID			Integer NOT NULL,\n"
										+ "apptID				Integer NOT NULL,\n"
										// TODO: Generate and insert remaining table fields here.
										+ "FOREIGN KEY(patientID) REFERENCES patientInfo(patientID)\n,"
										+ "FOREIGN KEY(apptID) REFERENCES appointments(apptID)\n,"
										+ ");";
		
	}
	
	public void printAllEntries()
	{
		// TODO: Make this.
	}
	
}
