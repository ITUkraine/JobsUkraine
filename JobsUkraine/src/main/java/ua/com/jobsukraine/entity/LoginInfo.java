package ua.com.jobsukraine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LoginInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToMany
	private int role_id;

	private String login;
	private String password;

	public LoginInfo() {
	}

	public LoginInfo(int id, int role_id, String login, String password) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.login = login;
		this.password = password;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
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
		return "LoginInfo [id=" + id + ", role_id=" + role_id + ", login=" + login + ", password=" + password + "]\n";
	}
}
