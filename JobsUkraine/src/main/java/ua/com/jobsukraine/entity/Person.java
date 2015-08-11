package ua.com.jobsukraine.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "person")
@DiscriminatorColumn(name = "PRSN_TYPE", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Person extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 1L;

	@Email(message = "Wrong email format")
	@NotNull(message = "This field is mandatory")
	@NotEmpty(message = "This field is mandatory")
	@Column(name = "email", unique = true)
	private String email;

	@NotNull(message = "This field is mandatory")
	@NotEmpty(message = "This field is mandatory")
	@Column(name = "last_name")
	private String lastName;

	@OneToOne(cascade = CascadeType.ALL)
	private LoginInfo loginInfo;

	@NotNull(message = "This field is mandatory")
	@Pattern(regexp = "^[0-9\\-\\(\\)]*$", message = "Wrong phone format")
	@NotEmpty(message = "This field is mandatory")
	@Column(name = "mobileNumber")
	private String mobileNumber;

	@NotNull(message = "This field is mandatory")
	@NotEmpty(message = "This field is mandatory")
	@Column(name = "name")
	private String name;

	@NotNull(message = "This field is mandatory")
	@NotEmpty(message = "This field is mandatory")
	@Pattern(regexp = "male|female", message = "Must match \"male\" or \"female\"")
	@Column(name = "sex")
	private String sex;

	public Person() {
	}

	public Person(String name, String lastName, String email, String mobileNumber) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public LoginInfo getInfo() {
		return loginInfo;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setInfo(LoginInfo info) {
		this.loginInfo = info;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [id=" + this.getId() + ", name=" + name + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + "]\n";
	}

}
