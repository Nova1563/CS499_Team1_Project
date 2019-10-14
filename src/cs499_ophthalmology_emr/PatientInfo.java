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
    
    private List<PatientAppointment> appointmentList = new ArrayList<>();
    
    

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the zip
     */
    public int getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * @return the patientID
     */
    public int getPatientID() {
        return patientID;
    }

    /**
     * @param patientID the patientID to set
     */
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    /**
     * @return the homePhone
     */
    public int getHomePhone() {
        return homePhone;
    }

    /**
     * @param homePhone the homePhone to set
     */
    public void setHomePhone(int homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * @return the workPhone
     */
    public int getWorkPhone() {
        return workPhone;
    }

    /**
     * @param workPhone the workPhone to set
     */
    public void setWorkPhone(int workPhone) {
        this.workPhone = workPhone;
    }

    /**
     * @return the mobilePhone
     */
    public int getMobilePhone() {
        return mobilePhone;
    }

    /**
     * @param mobilePhone the mobilePhone to set
     */
    public void setMobilePhone(int mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the dateOfBirth
     */
    public int getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the ssn
     */
    public int getSsn() {
        return ssn;
    }

    /**
     * @param ssn the ssn to set
     */
    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    /**
     * @return the emgergContactNum
     */
    public int getEmgergContactNum() {
        return emgergContactNum;
    }

    /**
     * @param emgergContactNum the emgergContactNum to set
     */
    public void setEmgergContactNum(int emgergContactNum) {
        this.emgergContactNum = emgergContactNum;
    }

    /**
     * @return the emergContactName
     */
    public String getEmergContactName() {
        return emergContactName;
    }

    /**
     * @param emergContactName the emergContactName to set
     */
    public void setEmergContactName(String emergContactName) {
        this.emergContactName = emergContactName;
    }

    /**
     * @return the insProvider
     */
    public String getInsProvider() {
        return insProvider;
    }

    /**
     * @param insProvider the insProvider to set
     */
    public void setInsProvider(String insProvider) {
        this.insProvider = insProvider;
    }

    /**
     * @return the insContactNo
     */
    public int getInsContactNo() {
        return insContactNo;
    }

    /**
     * @param insContactNo the insContactNo to set
     */
    public void setInsContactNo(int insContactNo) {
        this.insContactNo = insContactNo;
    }

    /**
     * @return the insGroupNo
     */
    public int getInsGroupNo() {
        return insGroupNo;
    }

    /**
     * @param insGroupNo the insGroupNo to set
     */
    public void setInsGroupNo(int insGroupNo) {
        this.insGroupNo = insGroupNo;
    }

    /**
     * @return the insEffectiveDate
     */
    public int getInsEffectiveDate() {
        return insEffectiveDate;
    }

    /**
     * @param insEffectiveDate the insEffectiveDate to set
     */
    public void setInsEffectiveDate(int insEffectiveDate) {
        this.insEffectiveDate = insEffectiveDate;
    }

    /**
     * @return the insCoPayAmount
     */
    public float getInsCoPayAmount() {
        return insCoPayAmount;
    }

    /**
     * @param insCoPayAmount the insCoPayAmount to set
     */
    public void setInsCoPayAmount(float insCoPayAmount) {
        this.insCoPayAmount = insCoPayAmount;
    }

    /**
     * @return the insProviderAddr
     */
    public String getInsProviderAddr() {
        return insProviderAddr;
    }

    /**
     * @param insProviderAddr the insProviderAddr to set
     */
    public void setInsProviderAddr(String insProviderAddr) {
        this.insProviderAddr = insProviderAddr;
    }

    /**
     * @return the insProviderPhone
     */
    public int getInsProviderPhone() {
        return insProviderPhone;
    }

    /**
     * @param insProviderPhone the insProviderPhone to set
     */
    public void setInsProviderPhone(int insProviderPhone) {
        this.insProviderPhone = insProviderPhone;
    }

    /**
     * @return the appointmentList
     */
    public List<PatientAppointment> getAppointmentList() {
        return appointmentList;
    }

    /**
     * @param appointmentList the appointmentList to set
     */
    public void setAppointmentList(List<PatientAppointment> appointmentList) {
        this.appointmentList = appointmentList;
    }
    
    
    
    
    
   
}
