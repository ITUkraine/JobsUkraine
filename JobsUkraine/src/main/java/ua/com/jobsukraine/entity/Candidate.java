package ua.com.jobsukraine.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "candidate")
@DiscriminatorValue("2")
public class Candidate extends Person {

	@Column(name = "address")
	private String address;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "Candidates")
	private List<Category> categories;

	@Column(name = "city")
	private String cityWhereLookingForWork;

	@Column(name = "CV")
	private String cv;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "date_of_start")
	@Temporal(TemporalType.DATE)
	private Date dateStartToWork;

	@Column(name = "dream_job")
	private String dreamJob;

	// @Column(name = "all_skills") create category enam or class
	// private List<String> allSkills;

	@Column(name = "education ")
	private String education;

	@Column(name = "experience")
	private String experience;

	@Column(name = "primary_skills")
	private String primarySkills;
	
	@OneToMany
	@JoinColumn(name = "candidat_id")
	private List<Feedback> feedbacks;

	public Candidate() {

	}

	public Candidate(String address, String cityWhereLookingForWork, String cv, Date dateOfBirth, Date dateStartToWork,
			String dreamJob, String education, String experience, String primarySkills, List<Category> categories) {
		super();
		this.address = address;
		this.cityWhereLookingForWork = cityWhereLookingForWork;
		this.cv = cv;
		this.dateOfBirth = dateOfBirth;
		this.dateStartToWork = dateStartToWork;
		this.dreamJob = dreamJob;
		this.education = education;
		this.experience = experience;
		this.primarySkills = primarySkills;
		this.categories = categories;
	}

	public String getAddress() {
		return address;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public String getCityWhereLookingForWork() {
		return cityWhereLookingForWork;
	}

	public String getCv() {
		return cv;
	}

	public Date getDateOfBirth() {
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

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void setCityWhereLookingForWork(String cityWhereLookingForWork) {
		this.cityWhereLookingForWork = cityWhereLookingForWork;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public void setDateOfBirth(Date dateOfBirth) {
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

	@Override
	public String toString() {
		return "Candidate [ date=" + dateOfBirth + ", address=" + address + ", primarySkills=" + primarySkills
				+ ", sityWhereLookingForWork=" + cityWhereLookingForWork + ", dateStartToWork=" + dateStartToWork
				+ ", experience=" + experience + ", cv=" + cv + ", dreamJob=" + dreamJob + ", Education=" + education
				+ "]\n";
	}
}
