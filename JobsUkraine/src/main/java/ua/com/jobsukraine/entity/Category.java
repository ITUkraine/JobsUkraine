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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Category {

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "Category_Candidate", joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id") )
	private List<Candidate> candidates;

	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
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
		super();
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

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public void setEmployers(List<Employer> employers) {
		this.employers = employers;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public List<Vacancy> getVacancy() {
		if (vacancy == null)
			vacancy = new ArrayList<>();
		return vacancy;
	}

	public void setVacancy(List<Vacancy> vacancy) {
		this.vacancy = vacancy;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

}
