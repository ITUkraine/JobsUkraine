package ua.com.jobsukraine.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Admin extends Person {

	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "city")
	private String cityWherework;

	@Column(name = "time_start_work")
	private String timeStartToWork;

	@Column(name = "position")
	private String position;

	@Column(name = "education ")
	private String education;
	
	public Admin() {

	}
	
	

	public Admin(Date dateOfBirth, String cityWherework, String timeStartToWork, String position, String education) {
		super();
		this.dateOfBirth = dateOfBirth;
		this.cityWherework = cityWherework;
		this.timeStartToWork = timeStartToWork;
		this.position = position;
		this.education = education;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCityWherework() {
		return cityWherework;
	}

	public void setCityWherework(String cityWherework) {
		this.cityWherework = cityWherework;
	}

	public String getTimeStartToWork() {
		return timeStartToWork;
	}

	public void setTimeStartToWork(String timeStartToWork) {
		this.timeStartToWork = timeStartToWork;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "Admin [dateOfBirth=" + dateOfBirth + ", cityWherework=" + cityWherework + ", timeStartToWork="
				+ timeStartToWork + ", position=" + position + ", education=" + education + "]";
	}

	

}
