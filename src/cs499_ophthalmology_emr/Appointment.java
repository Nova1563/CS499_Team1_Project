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
public class Appointment 
{
    private final int apptID;	
    private final int patientID;
	private String patientName;
	private String reasonForVisit;
    private int appointmentTime;
    private int arrivalStatus;
    private int arrivalTime;
    private int doctorToSee;
    
	public Appointment(Integer _apptID, Integer _patientID)
	{
		this.apptID = _apptID;
		this.patientID = _patientID;
	}
    
    
    /**
     * @return the appID
     */
    public int getApptID() {
        return apptID;
    }

    /**
     * @return the patientID
     */
    public int getPatientID() {
        return patientID;
    }
	
	public String getPatientName()
	{
		return patientName;
	}
	
	public void setPatientName(String name)
	{
		this.patientName = name;
	}
	
	public String getReasonForVisit() {
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
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
