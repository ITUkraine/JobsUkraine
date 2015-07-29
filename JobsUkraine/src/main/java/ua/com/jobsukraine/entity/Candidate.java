package ua.com.jobsukraine.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "candidate")
public class Candidate extends Person {

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String cityWhereLookingForWork;

	@Column(name = "CV")
	private String cv;

	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "date_of_start")
	@Temporal(TemporalType.DATE)
	private Date dateStartToWork;

	@Column(name = "dream_job")
	private String dreamJob;

	@Column(name = "education ")
	private String education;

	// @Column(name = "all_skills") create category enam or class
	// private List<String> allSkills;

	@Column(name = "experience")
	private String experience;

	@Column(name = "primary_skills")
	private String primarySkills;

	public Candidate() {

	}

	public Candidate(String name, String lastName, String email, String mobileNumber, Date dateOfBirth, String address,
			String primarySkills, String sityWhereLookingForWork, Date dateStartToWork, String experience, String cv,
			String dreamJob, String education) {
		super(name, lastName, email, mobileNumber);
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.primarySkills = primarySkills;
		this.cityWhereLookingForWork = sityWhereLookingForWork;
		this.dateStartToWork = dateStartToWork;
		this.experience = experience;
		this.cv = cv;
		this.dreamJob = dreamJob;
		this.education = education;
	}

	public String getAddress() {
		return address;
	}

	public String getCv() {
		return cv;
	}

	public Date getDate() {
		return dateOfBirth;
	}

	public Date getDateStartToWork() {
		return dateStartToWork;
	}

	public String getDreamJob() {
		return dreamJob;
	}

	public String getEducation() {
		return education;
	}

	public String getExperience() {
		return experience;
	}

	public String getPrimarySkills() {
		return primarySkills;
	}

	public String getSityWhereLookingForWork() {
		return cityWhereLookingForWork;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public void setDate(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setDateStartToWork(Date dateStartToWork) {
		this.dateStartToWork = dateStartToWork;
	}

	public void setDreamJob(String dreamJob) {
		this.dreamJob = dreamJob;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}

	public void setSityWhereLookingForWork(String sityWhereLookingForWork) {
		this.cityWhereLookingForWork = sityWhereLookingForWork;
	}

	@Override
	public String toString() {
		return "Candidate [ date=" + dateOfBirth + ", address=" + address + ", primarySkills=" + primarySkills
				+ ", sityWhereLookingForWork=" + cityWhereLookingForWork + ", dateStartToWork=" + dateStartToWork
				+ ", experience=" + experience + ", cv=" + cv + ", dreamJob=" + dreamJob + ", Education=" + education
				+ "]\n";
	}

}
