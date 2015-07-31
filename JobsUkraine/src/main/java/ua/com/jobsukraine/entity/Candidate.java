package ua.com.jobsukraine.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "candidate")
@DiscriminatorValue("2")
public class Candidate extends Person {

	@NotNull
	@Column(name = "address")
	private String address;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "candidates")
	private List<Category> categories;

	@NotNull
	@Column(name = "city")
	private String cityWhereLookingForWork;

	private String cv;

	@NotNull
	@Column(name = "date_of_birth")
	private Long dateOfBirth;

	@Transient
	private String dateOfBirthInString;

	@Transient
	private String dateStartToWorkInString;

	@Column(name = "date_start_work")
	private Long dateStartToWork;

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

	@Transient
	private double rating;

	@ManyToMany
	@JoinTable(name = "candidate_skill", joinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id") )
	private Set <Skill> skills;

	public Set <Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set <Skill> skills) {
		this.skills = skills;
	}

	public Candidate() {

	}

	public Candidate(String address, String cityWhereLookingForWork, String cv, Long dateOfBirth, Long dateStartToWork,
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

	public Long getDateOfBirth() {
		return dateOfBirth;
	}

	public Long getDateStartToWork() {
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
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

	public void setDateOfBirth(Long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setDateStartToWork(Long dateStartToWork) {
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

	public String getDateOfBirthInString() {
		return dateOfBirthInString;
	}

	public void setDateOfBirthInString(String dateOfBirthInString) {
		this.dateOfBirthInString = dateOfBirthInString;
	}

	public String getDateStartToWorkInString() {
		return dateStartToWorkInString;
	}

	public void setDateStartToWorkInString(String dateStartToWorkInString) {
		this.dateStartToWorkInString = dateStartToWorkInString;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	@Override
	public String toString() {
		return "Candidate [ date=" + dateOfBirth + ", address=" + address + ", primarySkills=" + primarySkills
				+ ", sityWhereLookingForWork=" + cityWhereLookingForWork + ", dateStartToWork=" + dateStartToWork
				+ ", experience=" + experience + ", cv=" + cv + ", dreamJob=" + dreamJob + ", Education=" + education
				+ ", Rating=" + rating + "]\n";
	}
}
