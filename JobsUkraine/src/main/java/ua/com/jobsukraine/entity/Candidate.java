package ua.com.jobsukraine.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "candidate")
@DiscriminatorValue("2")
public class Candidate extends Person implements Comparable<Candidate> {

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
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Column(name = "date_start_work")
	@Temporal(TemporalType.DATE)
	private Date dateStartToWork;

	@Column(name = "dream_job")
	private String dreamJob;

	@Column(name = "education ")
	private String education;

	@Column(name = "experience")
	private String experience;

	@OneToMany
	@JoinColumn(name = "candidat_id")
	private List<Feedback> feedbacks;

	@Column(name = "primary_skills")
	private String primarySkills;

	@Transient
	private double rating;

	@ManyToMany
	@JoinTable(name = "candidate_skill", joinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id") )
	private Set<Skill> skills;

	public Candidate() {

	}

	public Candidate(String address, String cityWhereLookingForWork, String cv, Date dateOfBirth, Date dateStartToWork,
			String dreamJob, String education, String experience) {
		this.address = address;
		this.cityWhereLookingForWork = cityWhereLookingForWork;
		this.cv = cv;
		this.dateOfBirth = dateOfBirth;
		this.dateStartToWork = dateStartToWork;
		this.dreamJob = dreamJob;
		this.education = education;
		this.experience = experience;
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

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public String getPrimarySkills() {
		return primarySkills;
	}

	public double getRating() {
		return rating;
	}

	public Set<Skill> getSkills() {
		return skills;
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

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return super.toString() + " Candidate [ date=" + dateOfBirth + ", address=" + address + ", primarySkills="
				+ primarySkills + ", sityWhereLookingForWork=" + cityWhereLookingForWork + ", dateStartToWork="
				+ dateStartToWork + ", experience=" + experience + ", cv=" + cv + ", dreamJob=" + dreamJob
				+ ", Education=" + education + ", Rating=" + rating + "]\n";
	}

	@Override
	public int compareTo(Candidate o) {
//		if (o.getId() == this.getId())
//			return (int) (this.getRating() - o.getRating());
//		// return 0;
		return (int) (o.getRating() - this.getRating());
	}

}
