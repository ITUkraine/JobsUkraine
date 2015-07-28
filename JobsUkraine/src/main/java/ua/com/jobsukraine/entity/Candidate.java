package ua.com.jobsukraine.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "candidate")
public class Candidate {
	public Candidate() {
		
	}
	
	
	


	public Candidate(String name, String lastName, Date date, String email, String mobileNumber, String address, //constructor for regestriation
			String primarySkills, String sityWhereLookingForWork, Date dateStartToWork) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.date = date;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.primarySkills = primarySkills;
		this.sityWhereLookingForWork = sityWhereLookingForWork;
		this.dateStartToWork = dateStartToWork;
	}





	public Candidate(User user, String login, String name, String lastName, Date date, String email,		// contr with all fields
			String mobileNumber, String address, String primarySkills, String sityWhereLookingForWork,
			Date dateStartToWork, String experience, String cv, String dreamJob, String education) {
		super();
		this.user = user;
		this.login = login;
		this.name = name;
		this.lastName = lastName;
		this.date = date;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.primarySkills = primarySkills;
		this.sityWhereLookingForWork = sityWhereLookingForWork;
		this.dateStartToWork = dateStartToWork;
		this.experience = experience;
		this.cv = cv;
		this.dreamJob = dreamJob;
		Education = education;
	}





	@OneToOne
	@MapsId
	private User user;
	
	@Id
    private String login;
	
	@Column(name = "name")
	private String name;
	 
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date = new Date();
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobileNumber")
	private String mobileNumber;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "primary_skills")
	private String primarySkills;
	
	@Column(name = "sity")
	private String sityWhereLookingForWork;
	
	@Column(name = "date_of_start")
	@Temporal(TemporalType.DATE)
	private Date dateStartToWork = new Date();
	
	@Column(name = "experience")
	private String experience;
	
	@Column(name = "CV")
	private String cv;
	
//	@Column(name = "all_skills")	create category enam or class
//	private List<String> allSkills; 
	
	@Column(name = "dream_job")
	private String dreamJob;
	
	@Column(name = "education ")
	private String Education ;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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
		return sityWhereLookingForWork;
	}

	public void setSityWhereLookingForWork(String sityWhereLookingForWork) {
		this.sityWhereLookingForWork = sityWhereLookingForWork;
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
		return Education;
	}

	public void setEducation(String education) {
		Education = education;
	}


	@Override
	public String toString() {
		return "Candidate [name=" + name + ", lastName=" + lastName + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", address=" + address + ", primarySkills=" + primarySkills + ", Education="
				+ Education + "]\n";
	}
	
	

}
