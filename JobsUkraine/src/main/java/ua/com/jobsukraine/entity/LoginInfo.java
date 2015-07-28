package ua.com.jobsukraine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LoginInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String login;
	private String password;

	@ManyToOne
	private Role role;

	public LoginInfo() {
	}

	public LoginInfo(int id, Role role_id, String login, String password) {
		super();
		this.id = id;

		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", role_id=" + ", login=" + login + ", password=" + password + "]\n";
	}
}
