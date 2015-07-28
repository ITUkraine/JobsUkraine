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



	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "address")
	private String address;

	@Column(name = "primary_skills")
	private String primarySkills;

	@Column(name = "city")
	private String cityWhereLookingForWork;

	@Column(name = "date_of_start")
	@Temporal(TemporalType.DATE)
	private Date dateStartToWork;

	@Column(name = "experience")
	private String experience;

	@Column(name = "CV")
	private String cv;

	// @Column(name = "all_skills") create category enam or class
	// private List<String> allSkills;

	@Column(name = "dream_job")
	private String dreamJob;

	@Column(name = "education ")
	private String education;

	public Candidate() {

	}

	public Candidate(String name, String lastName, String email, String mobileNumber, Date date,
			String address, String primarySkills, String sityWhereLookingForWork, Date dateStartToWork,
			String experience, String cv, String dreamJob, String education) {
		super(name, lastName, email, mobileNumber);
		this.date = date;
		this.address = address;
		this.primarySkills = primarySkills;
		this.cityWhereLookingForWork = sityWhereLookingForWork;
		this.dateStartToWork = dateStartToWork;
		this.experience = experience;
		this.cv = cv;
		this.dreamJob = dreamJob;
		this.education = education;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPrimarySkills() {
		return primarySkills;
	}

	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}

	public String getSityWhereLookingForWork() {
		return cityWhereLookingForWork;
	}

	public void setSityWhereLookingForWork(String sityWhereLookingForWork) {
		this.cityWhereLookingForWork = sityWhereLookingForWork;
	}

	public Date getDateStartToWork() {
		return dateStartToWork;
	}

	public void setDateStartToWork(Date dateStartToWork) {
		this.dateStartToWork = dateStartToWork;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getDreamJob() {
		return dreamJob;
	}

	public void setDreamJob(String dreamJob) {
		this.dreamJob = dreamJob;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "Candidate [ date=" + date + ", address=" + address + ", primarySkills="
				+ primarySkills + ", sityWhereLookingForWork=" + cityWhereLookingForWork + ", dateStartToWork="
				+ dateStartToWork + ", experience=" + experience + ", cv=" + cv + ", dreamJob=" + dreamJob
				+ ", Education=" + education + "]\n";
	}

}
