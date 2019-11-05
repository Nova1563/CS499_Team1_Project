
package cs499_ophthalmology_emr;
/**
 * The Main class and Main function.
 * @author BitSanity
 */

public class CS499_Ophthalmology_EMR {
	public static void main( String args[] )
	{
		//DataBaseManager dataBase = DataBaseManager.getInstance();
		
		int newPatientID = -1;
		int newAppointmentID = -1;
		
		//newPatientID = dataBase.patientInfo.addPatient("Who is That");
		//System.out.println("New patientID created: " + newPatientID);
		
		//newAppointmentID = dataBase.appointments.addAppointment(1);
		//System.out.println("New appointmentID created: " + newAppointmentID);
		
		//dataBase.patientInfo.printAllEntries();
		//dataBase.appointments.printAllEntries();
                
                MainWindow dash = new MainWindow();
                
                dash.setVisible(true);
                
        

		//dataBase.patientTable.doTest();
		  
        }
		
		
                
}
