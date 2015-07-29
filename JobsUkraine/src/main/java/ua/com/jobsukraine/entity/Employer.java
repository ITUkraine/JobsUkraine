package ua.com.jobsukraine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employer {

	private String address;

	private String description;
	private String email;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@OneToOne
	private LoginInfo info;
	private String name;

	private String phone;
	private String pictureURL;

	// TODO fields to add
	// private ArrayList<Categories> categories;
	// country, city they are looking to hire

	private String website; // can be changed to URL

	public Employer() {

	}

	public Employer(String email, String phone, String adress, String description, String website, String pictureURL) {
		super();
		this.email = email;
		this.phone = phone;
		this.address = adress;
		this.description = description;
		this.website = website;
		this.pictureURL = pictureURL;
	}

	public String getAddress() {
		return address;
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
		return "Employer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", adress=" + address
				+ ", description=" + description + ", website=" + website + ", pictureURL=" + pictureURL + "]\n";
	}

}
