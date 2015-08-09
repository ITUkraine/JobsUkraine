package ua.com.jobsukraine.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Category extends AbstractPersistable<Integer>  {

	private static final long serialVersionUID = 1L;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "Category_Candidate", 
		joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id") ,
		inverseJoinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id"))
	private List<Candidate> candidates;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "Category_Employer",
		joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id") , 
		inverseJoinColumns = @JoinColumn(name = "employer_id", referencedColumnName = "id") )
	private List<Employer> employers;

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

	public String getName() {
		return name;
	}

	public List<Vacancy> getVacancy() {
		return vacancy;
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

	public void setVacancy(List<Vacancy> vacancy) {
		this.vacancy = vacancy;
	}

	@Override
	public String toString() {
		return "Category [id=" + this.getId() + ", name=" + name + "]";
	}

}
