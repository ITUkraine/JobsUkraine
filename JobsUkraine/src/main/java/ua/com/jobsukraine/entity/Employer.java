package ua.com.jobsukraine.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class Employer {

	@NotNull(message = "This field is mandatory")
	private String address;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "employers")
	private List<Category> categories;

	@NotNull(message = "This field is mandatory")
	private String description;

	@NotNull(message = "This field is mandatory")
	@Email
	private String email;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	private LoginInfo info;
	@NotNull(message = "This field is mandatory")
	private String name;

	@NotNull(message = "This field is mandatory")
	@Column(unique = true)
	@Size(min = 5, max = 12)
	private String phone;

	// @URL
	private String pictureURL;

	@OneToMany(mappedBy = "employer")
	private List<Vacancy> vacancy;

	@Size(min = 0, max = 30)
	private String website; // can be changed to URL

	public Employer() {

	}

	public Employer(String email, String phone, String address, String description, String website, String pictureURL) {
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.description = description;
		this.website = website;
		this.pictureURL = pictureURL;
	}

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

	public LoginInfo getInfo() {
		return info;
	}

	public int getLogin() {
		return id;
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

	public void setInfo(LoginInfo info) {
		this.info = info;
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
		return "Employer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", description=" + description + ", website=" + website + ", pictureURL=" + pictureURL
				+ "]\n";
	}
}
