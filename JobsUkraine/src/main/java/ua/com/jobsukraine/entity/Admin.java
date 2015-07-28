package ua.com.jobsukraine.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Admin {

	@Id
	private String login;

	private String name;

	@OneToOne
	@MapsId
	private User user;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String login, String name) {
		super();
		this.login = login;
		this.name = name;
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

	@Override
	public String toString() {
		return "Admin [login=" + login + ", name=" + name + "]";
	}

}
