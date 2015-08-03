package ua.com.jobsukraine.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Category {

	@ManyToMany
	@JoinTable(name = "Category_Candidate", joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id") )
	private List<Candidate> candidates;

	@ManyToMany
	@JoinTable(name = "Category_Employer", joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "employer_id", referencedColumnName = "id") )
	private List<Employer> employers;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;

	@NotNull
	public String name;

	@OneToMany(mappedBy = "category")
	private List<Vacancy> vacancy;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public List<Employer> getEmployers() {
		return employers;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Vacancy> getVacancy() {
		return vacancy;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public void setCandidatInCategory(Candidate candidat) {
		if (candidates == null) {
			candidates = new ArrayList<>();
			candidates.add(candidat);
		} else {

			this.candidates.add(candidat);

		}
	}

	public void setEmployerInCategory(Employer employer) {
		if (employers == null) {
			employers = new ArrayList<>();
			employers.add(employer);
		} else {

			this.employers.add(employer);

		}
	}

	public void setEmployers(List<Employer> employers) {
		this.employers = employers;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVacancy(List<Vacancy> vacancy) {
		this.vacancy = vacancy;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

}
