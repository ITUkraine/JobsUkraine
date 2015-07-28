package ua.com.jobsukraine.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import ua.com.jobsukraine.entity.enums.Categories;

@Entity
public class Employer {

	@Id
	private String login;

	private String name;
	private String email;
	private String phone;
	private String adress;
	private String description;

	private String website; // can be changed to URL
	private String pictureURL;

	// TODO fields to add
	private ArrayList<Categories> categories;
	// country, city they are looking to hire

	@OneToOne
	@MapsId
	private User user;

	public Employer() {

	}

	public Employer(String login, String email, String phone, String adress, String description, String website,
			String pictureURL, ArrayList<Categories> categories) {
		super();
		this.login = login;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
		this.description = description;
		this.website = website;
		this.pictureURL = pictureURL;
		this.categories = categories;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}

	public ArrayList<Categories> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<Categories> categories) {
		this.categories = categories;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Employer [login=" + login + ", name=" + name + ", email=" + email + ", phone=" + phone + ", adress="
				+ adress + ", description=" + description + ", website=" + website + ", pictureURL=" + pictureURL
				+ ", categories=" + categories + "]\n";
	}

}
