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
  public static void main( String args[] ) {
      Connection c = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:test.db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Opened database successfully");
      System.out.println("I was here - Ryan");
   }
}