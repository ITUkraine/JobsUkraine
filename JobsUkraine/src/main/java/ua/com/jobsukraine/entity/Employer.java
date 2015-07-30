package ua.com.jobsukraine.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Employer {

	private String address;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "Employers")
	private List<Category> categorys;
	private String description;
	private String email;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	private LoginInfo info;

	private String name;
	private String phone;

	// TODO fields to add
	// private ArrayList<Categories> categories;
	// country, city they are looking to hire

	private String pictureURL;

	private String website; // can be changed to URL

	public Employer() {

	}

	public Employer(String email, String phone, String address, String description, String website, String pictureURL) {
		super();
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

	public List<Category> getCategorys() {
		return categorys;
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

	public void setCategorys(List<Category> Categorys) {
		this.categorys = Categorys;
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
		return "Employer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ ", description=" + description + ", website=" + website + ", pictureURL=" + pictureURL + "]\n";
	}
}
