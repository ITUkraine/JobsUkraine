package ua.com.jobsukraine.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Skill {

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "skills")
	private Set <Candidate> candidates;
	
	
	
	public Set <Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(Set <Candidate> candidates) {
		this.candidates = candidates;
	}

	public Skill() {
	}

	private String nameOfSkill;
	private String description;

	public String getNameOfSkill() {
		return nameOfSkill;
	}

	public void setNameOfSkill(String nameOfSkill) {
		this.nameOfSkill = nameOfSkill;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public Skill(String nameOfSkill, String description) {
		super();
		this.nameOfSkill = nameOfSkill;
		this.description = description;
	}

}
