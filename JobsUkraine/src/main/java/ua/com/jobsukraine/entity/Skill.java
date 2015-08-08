package ua.com.jobsukraine.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Skill extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 1L;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "skills")
	private Set<Candidate> candidates;

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
		return "Skill [id=" + this.getId() + ", nameOfSkill=" + nameOfSkill + "]";
	}

}
