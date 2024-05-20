package app_sys.models;

import java.util.Date;
import java.sql.Time;

public class Appointment {
	
	private int id;
	private int patientId;
	private int doctorId;
	private Date date;
	private Time time;

//	public Appointment(int patientId, int doctorId, Date date, Time time) {
//		super();
//		this.patientId = patientId;
//		this.doctorId = doctorId;
//		this.date = date;
//		this.time = time;
//	}
	
	
	public Appointment(int id, int patientId, int doctorId, Date date, Time time) {
		super();
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.date = date;
		this.time = time;
	}

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Appointment [patientId=" + patientId + ", doctorId=" + doctorId + ", date=" + date + ", time=" + time
				+ "]";
	}
}
