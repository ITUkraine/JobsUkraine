package ua.com.jobsukraine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import ua.com.jobsukraine.entity.passwordcontol.FieldMatch;

@Entity
@FieldMatch.List({
		@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"), })
public class LoginInfo {

	@Transient
	@Pattern(regexp = "[a-zA-Z0-9]+")
	@Size(min = 8, max = 20)
	private String confirmPassword;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Column(unique = true)
	@Size(min = 4, max = 20)
	private String login;

	@NotNull
	@Pattern(regexp = "[a-zA-Z0-9]+")
	@Size(min = 8, max = 20)
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public Role getRole() {
		return role;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginInfo [id=" + id + ", role_id=" + ", login=" + login + ", password=" + password + "]\n";
	}
}
