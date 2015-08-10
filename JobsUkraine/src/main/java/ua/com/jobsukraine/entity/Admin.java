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

	private static final long serialVersionUID = 1L;

	@Column(name = "city")
	private String cityWherework;

	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "education ")
	private String education;

	@Column(name = "position")
	private String position;

	public Admin() {

	}

	public Admin(Date dateOfBirth, String cityWherework, String position, String education) {
		this.dateOfBirth = dateOfBirth;
		this.cityWherework = cityWherework;
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

	@Override
	public String toString() {
		return "Admin [dateOfBirth=" + dateOfBirth + ", cityWherework=" + cityWherework + ", position=" + position
				+ ", education=" + education + "]";
	}

}
