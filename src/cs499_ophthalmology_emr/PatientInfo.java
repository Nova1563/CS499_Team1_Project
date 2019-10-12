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
    private int homePhone;
    private int workPhone;
    private int mobilePhone;
    private String gender;
    private int dateOfBirth;
    private String emailAddress;
    private int ssn;
    private int emgergContactNum;
    private String emergContactName;
    private String insProvider;
    private int insContactNo;
    private int insGroupNo;
    private int insEffectiveDate;
    private float insCoPayAmount;
    private String insProviderAddr;
    private int insProviderPhone;
    
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

    
    //-------------------------------
    public int getHomePhone() 
    {
        return homePhone;
    }

    public void setHomePhone(int homePhone) 
    {
        this.homePhone = homePhone;
    }
    //-------------------------------
    
    
    //-------------------------------
    public int getWorkPhone() 
    {
        return workPhone;
    }
    
    public void setWorkPhone(int workPhone) 
    {
        this.workPhone = workPhone;
    }
    //-------------------------------
    
    
    //-------------------------------
    public int getMobilePhone() 
    {
        return mobilePhone;
    }

    public void setMobilePhone(int mobilePhone) 
    {
        this.mobilePhone = mobilePhone;
    }
    //-------------------------------
    

    //-------------------------------
    public String getGender() 
    {
        return gender;
    }
    
    public void setGender(String gender) 
    {
        this.gender = gender;
    }
    //-------------------------------

    
    //-------------------------------
    public int getDateOfBirth() 
    {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(int dateOfBirth) 
    {
        this.dateOfBirth = dateOfBirth;
    }
    //-------------------------------
    
    
    //-------------------------------
    public String getEmailAddress() 
    {
        return emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) 
    {
        this.emailAddress = emailAddress;
    }
    //-------------------------------
    
    
    //-------------------------------
    public int getSsn() 
    {
        return ssn;
    }
    
    public void setSsn(int ssn) 
    {
        this.ssn = ssn;
    }
    //-------------------------------
    
    
    //-------------------------------
    public int getEmgergContactNum() 
    {
        return emgergContactNum;
    }
    
     public void setEmgergContactNum(int emgergContactNum) 
    {
        this.emgergContactNum = emgergContactNum;
    }
    //-------------------------------
     
     
    //-------------------------------
    public String getEmergContactName() 
    {
        return emergContactName;
    }

    public void setEmergContactName(String emergContactName) 
    {
        this.emergContactName = emergContactName;
    }
    //-------------------------------

    
    //-------------------------------
    public String getInsProvider() 
    {
        return insProvider;
    }

    public void setInsProvider(String insProvider) 
    {
        this.insProvider = insProvider;
    }
    //-------------------------------

    
    //-------------------------------
    public int getInsContactNo() 
    {
        return insContactNo;
    }

    public void setInsContactNo(int insContactNo) 
    {
        this.insContactNo = insContactNo;
    }
    //-------------------------------

    
    //-------------------------------
    public int getInsGroupNo() 
    {
        return insGroupNo;
    }

    public void setInsGroupNo(int insGroupNo) 
    {
        this.insGroupNo = insGroupNo;
    }
    //-------------------------------

    
    //-------------------------------
    public int getInsEffectiveDate() 
    {
        return insEffectiveDate;
    }

    public void setInsEffectiveDate(int insEffectiveDate) 
    {
        this.insEffectiveDate = insEffectiveDate;
    }
    //-------------------------------

    
    //-------------------------------
    public float getInsCoPayAmount() 
    {
        return insCoPayAmount;
    }

    public void setInsCoPayAmount(float insCoPayAmount) 
    {
        this.insCoPayAmount = insCoPayAmount;
    }
    //-------------------------------

    
    //-------------------------------
    public String getInsProviderAddr() 
    {
        return insProviderAddr;
    }

    public void setInsProviderAddr(String insProviderAddr) 
    {
        this.insProviderAddr = insProviderAddr;
    }
    //-------------------------------

    
    //-------------------------------
    public int getInsProviderPhone() 
    {
        return insProviderPhone;
    }

    public void setInsProviderPhone(int insProviderPhone) 
    {
        this.insProviderPhone = insProviderPhone;
    }
    //-------------------------------
    
    
    
   
}
