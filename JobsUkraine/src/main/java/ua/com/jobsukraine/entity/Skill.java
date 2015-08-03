package ua.com.jobsukraine.entity;

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
	private Set<Candidate> candidates;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nameOfSkill;

	public Skill() {
	}

	public Skill(String nameOfSkill) {
		this.nameOfSkill = nameOfSkill;
	}

	public Set<Candidate> getCandidates() {
		return candidates;
	}

	public String getNameOfSkill() {
		return nameOfSkill;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}

	public void setNameOfSkill(String nameOfSkill) {
		this.nameOfSkill = nameOfSkill;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", nameOfSkill=" + nameOfSkill + "]";
	}

}
