package ua.com.jobsukraine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

import ua.com.jobsukraine.annotations.UniqueLoginInfoLogin;

@Entity
public class LoginInfo extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "This field is mandatory")
	@Size(min = 6, message = "Password too short")
	@Transient
	private String confirmPassword;

	@NotNull(message = "This field is mandatory")
	@Column(unique = true)
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "Wrong login format")
	@Size(min = 4, max = 20, message = "Length must be from 4 to 20")
	@UniqueLoginInfoLogin(message = "This login already exists")
	private String login;

	@NotNull(message = "This field is mandatory")
	@Size(min = 6, message = "Password too short")
	private String password;

	@ManyToOne
	private Role role;

	public LoginInfo() {
	}

	public LoginInfo(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
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
		return "LoginInfo [id=" + this.getId() + ", role_id=" + ", login=" + login + ", password=" + password + "]\n";
	}
}
