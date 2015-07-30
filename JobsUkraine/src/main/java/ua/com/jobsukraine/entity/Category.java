package ua.com.jobsukraine.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;

	public String name;

	public Category() {
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]\n";
	}

	@ManyToMany
	@JoinTable(name = "Category_Candidate", joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id") )
	private List<Candidate> Candidates;

	public List<Candidate> getCandidates() {
		return Candidates;
	}

	public void setCandidates(List<Candidate> Candidates) {
		this.Candidates = Candidates;
	}
	
	@ManyToMany
	@JoinTable(name = "Category_Employer", joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "Employer_id", referencedColumnName = "id") )
	private List<Employer> employers;

	public List<Employer> getEmployers() {
		return employers;
	}

	public void setEmployers(List<Employer> Employers) {
		this.employers = Employers;
	}

}
