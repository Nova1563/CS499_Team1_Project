/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RDavi
 */
public class PatientInfo
{
    private String address;
    private int age;
    private int zip;
    private int patientID;
    
    List<PatientAppointment> appointmentList = new ArrayList<>();
    
    
    //-------------------------------
    public String getAddress()
    {
        return this.address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    //-------------------------------
    
    //-------------------------------
    public int getAge()
    {
        return this.age;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    //-------------------------------
    
    //-------------------------------
    public int getZip()
    {
        return this.zip;
    }
    
    public void setZip(int zip)
    {
        this.zip = zip;
    }
    //-------------------------------
    
    //-------------------------------
    public int getPatientID()
    {
        return this.patientID;
    }
    
    public void setPatientID(int patientID)
    {
        this.patientID = patientID;
    }
    //-------------------------------
}
