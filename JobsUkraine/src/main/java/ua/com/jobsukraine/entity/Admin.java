package ua.com.jobsukraine.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("1")
public class Admin extends Person {

	@Column(name = "city")
	private String cityWherework;

	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "education ")
	private String education;

	@Column(name = "position")
	private String position;

	@Column(name = "time_start_work")
	private String timeStartToWork;

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

	public String getCityWherework() {
		return cityWherework;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEducation() {
		return education;
	}

	public String getPosition() {
		return position;
	}

	public String getTimeStartToWork() {
		return timeStartToWork;
	}

	public void setCityWherework(String cityWherework) {
		this.cityWherework = cityWherework;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setTimeStartToWork(String timeStartToWork) {
		this.timeStartToWork = timeStartToWork;
	}

	@Override
	public String toString() {
		return "Admin [dateOfBirth=" + dateOfBirth + ", cityWherework=" + cityWherework + ", timeStartToWork="
				+ timeStartToWork + ", position=" + position + ", education=" + education + "]";
	}

}
