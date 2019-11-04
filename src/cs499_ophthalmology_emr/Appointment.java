/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs499_ophthalmology_emr;

/**
 * A Java object representing one appointment entry in the SQL database.
 * 
 */
public class Appointment 
{
    private final Integer apptID;	
    private final Integer patientID;
	private String patientName;
	private String reasonForVisit;
	private Integer apptDate;

    private Integer appointmentTime;
    private Integer arrivalStatus;
    private Integer arrivalTime;
    private Integer doctorToSee;
    
	public Appointment(Integer _apptID, Integer _patientID)
	{
		this.apptID = _apptID;
		this.patientID = _patientID;
		
		this.patientName = "";
		this.reasonForVisit = "";
		this.apptDate = -1;
		this.appointmentTime = -1;
		this.arrivalStatus = -1;
		this.arrivalTime = -1;
		this.doctorToSee = -1;		
	}
    
    
    /**
     * @return the appID
     */
    public Integer getApptID() {
        return apptID;
    }

    /**
     * @return the patientID
     */
    public Integer getPatientID() {
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
	
	public Integer getApptDate() {
		return apptDate;
	}

	public void setApptDate(Integer apptDate) {
		this.apptDate = apptDate;
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
    public Integer getAppointmentTime() {
        return appointmentTime;
    }

    /**
     * @param appointmentTime the appointmentTime to set
     */
    public void setAppointmentTime(Integer appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    /**
     * @return the arrivalStatus
     */
    public Integer getArrivalStatus() {
        return arrivalStatus;
    }

    /**
     * @param arrivalStatus the arrivalStatus to set
     */
    public void setArrivalStatus(Integer arrivalStatus) {
        this.arrivalStatus = arrivalStatus;
    }

    /**
     * @return the arrivalTime
     */
    public Integer getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(Integer arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @return the doctorToSee
     */
    public Integer getDoctorToSee() {
        return doctorToSee;
    }

    /**
     * @param doctorToSee the doctorToSee to set
     */
    public void setDoctorToSee(Integer doctorToSee) {
        this.doctorToSee = doctorToSee;
    }
    
    
    
}
