/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;

/**
 *
 * @author RDavi
 */
public class PatientInfo
{
    String name;
    String address;
    int age;
    int zip;
    int patientID;
    
    
    public PatientInfo(String name, int age, String address, 
            int zip, int patientID)
    {
        this.name = name;
        this.address = address;
        this.age = age;
        this.zip = zip;
        this.patientID = patientID;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public int getZip()
    {
        return zip;
    }
    
    public int getPatientID()
    {
        return patientID;
    }
}
