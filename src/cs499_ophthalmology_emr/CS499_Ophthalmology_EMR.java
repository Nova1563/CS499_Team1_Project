
package cs499_ophthalmology_emr;
/**
 * The Main class and Main function.
 * @author BitSanity
 */

public class CS499_Ophthalmology_EMR {
	public static void main( String args[] )
	{
		DataBaseManager dataBase = DataBaseManager.getInstance();
		//dataBase.doTest();
		
        MainDashboard dash = new MainDashboard();
        //dash.setExtendedState(MainDashboard.MAXIMIZED_BOTH); 
        //dash.setUndecorated(true);

        dash.setVisible(true);
		
		
    }
		
		
                
}
