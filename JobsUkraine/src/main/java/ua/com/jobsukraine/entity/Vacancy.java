package ua.com.jobsukraine.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Vacancy extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 1L;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "vacancies")
	private List<Candidate> candidates;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@NotNull
	private String description;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

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

	public List<Candidate> getCandidates() {
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

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public void setCandidates(List<Candidate> candidates) {
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
		return "Vacancy [id=" + this.getId() + ", employer=" + employer + ", category=" + category + ", name=" + name
				+ ", description=" + description + ", salary=" + salary + "]";
	}

}
