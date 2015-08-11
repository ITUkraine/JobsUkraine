package ua.com.jobsukraine.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

import ua.com.jobsukraine.annotations.UniqueEmployer;

@Entity
@UniqueEmployer(message = "Employer with such email allready exists")
public class Employer extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "This field is mandatory")
	@NotEmpty(message = "This field is mandatory")
	private String address;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Category_Employer", joinColumns = @JoinColumn(name = "employer_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id") )
	private List<Category> categories;
	
	@Lob @Basic(fetch=FetchType.LAZY)
	@NotNull(message = "This field is mandatory")
	@NotEmpty(message = "This field is mandatory")
	private String description;

	@NotNull(message = "This field is mandatory")
	@NotEmpty(message = "This field is mandatory")
	@Email(message = "Wrong email format")
	@Column(unique = true)
	private String email;

	@OneToMany(mappedBy = "employer")
	private List<Feedback> Feedbacks;

	@OneToOne(cascade = CascadeType.ALL)
	private LoginInfo loginInfo;

	@NotNull(message = "This field is mandatory")
	@NotEmpty(message = "This field is mandatory")
	private String name;

	@NotNull(message = "This field is mandatory")
	@NotEmpty(message = "This field is mandatory")
	@Pattern(regexp = "^[0-9\\-\\(\\)]*$", message = "Wrong phone format")
	private String phone;

	private String pictureURL;

	@OneToMany(mappedBy = "employer")
	private List<Vacancy> vacancy;

	private String website;

	public String getAddress() {
		return address;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public String getDescription() {
		return description;
	}

	public String getEmail() {
		return email;
	}

	public List<Feedback> getFeedbacks() {
		return Feedbacks;
	}

	public LoginInfo getInfo() {
		return loginInfo;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public String getWebsite() {
		return website;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		Feedbacks = feedbacks;
	}

	public void setInfo(LoginInfo info) {
		this.loginInfo = info;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "Employer [id=" + this.getId() + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", address=" + address + ", description=" + description + ", website=" + website + ", pictureURL="
				+ pictureURL + "]\n";
	}
}
