package ua.com.jobsukraine.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Vacancy {

	@ManyToMany
	@JoinTable(name = "vacancy_candidate", joinColumns = @JoinColumn(name = "vacancy_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id") )

	private Set<Candidate> candidates;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@NotNull
	private String description;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	private String name;

	@NotNull
	private int salary;

	public Vacancy() {

	}

	public Vacancy(Employer employer, Category category, String name, String description, int salary) {
		this.employer = employer;
		this.category = category;
		this.name = name;
		this.description = description;
		this.salary = salary;
	}

	public Set<Candidate> getCandidates() {
		return candidates;
	}

	public Category getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public Employer getEmployer() {
		return employer;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Vacancy [id=" + id + ", employer=" + employer + ", category=" + category + ", name=" + name
				+ ", description=" + description + ", salary=" + salary + "]";
	}

}
