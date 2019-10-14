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
public class PatientAppointment 
{
    private int appID;
    private int patientID;
    private int appointmentTime;
    private int arrivalStatus;
    private int arrivalTime;
    private int doctorToSee;
    
    
    
    /**
     * @return the appID
     */
    public int getAppID() {
        return appID;
    }

    /**
     * @param appID the appID to set
     */
    public void setAppID(int appID) {
        this.appID = appID;
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
     * @return the appointmentTime
     */
    public int getAppointmentTime() {
        return appointmentTime;
    }

    /**
     * @param appointmentTime the appointmentTime to set
     */
    public void setAppointmentTime(int appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    /**
     * @return the arrivalStatus
     */
    public int getArrivalStatus() {
        return arrivalStatus;
    }

    /**
     * @param arrivalStatus the arrivalStatus to set
     */
    public void setArrivalStatus(int arrivalStatus) {
        this.arrivalStatus = arrivalStatus;
    }

    /**
     * @return the arrivalTime
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @return the doctorToSee
     */
    public int getDoctorToSee() {
        return doctorToSee;
    }

    /**
     * @param doctorToSee the doctorToSee to set
     */
    public void setDoctorToSee(int doctorToSee) {
        this.doctorToSee = doctorToSee;
    }
    
    
    
}
