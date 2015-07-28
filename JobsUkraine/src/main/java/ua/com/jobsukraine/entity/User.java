package ua.com.jobsukraine.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import ua.com.jobsukraine.entity.enums.Role;

@Entity
public class User {
	
	@Id
	private String login;
	
	private String pass;
	private Role role;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String login, String pass, Role role) {
		super();
		this.login = login;
		this.pass = pass;
		this.role = role;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [login=" + login + ", pass=" + pass + ", role=" + role + "]";
	}
	
}
