package ua.com.jobsukraine.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "person")
@DiscriminatorColumn(name = "PRSN_TYPE", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Person {

	@Email
	@Column(name = "email", unique=true)
	private String email;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private LoginInfo info;

	@NotNull
	@Size(min = 3, max = 20)
	@Pattern(regexp = "([À-ß¨²É¥ª¯][à-ÿ¸³é´º¿]+)|([A-Z][a-z]+)")
	@Column(name = "last_name")
	private String lastName;

	@Pattern(regexp = "×îëîâ³ê|Æ³íêà")
	@Column(name = "sex")
	private String sex;

	@NotNull
	@Pattern(regexp = "(^[0][0-9]{9})")
	@Column(name = "mobileNumber", unique=true)
	private String mobileNumber;

	@NotNull
	@Size(min = 3, max = 25)
	@Pattern(regexp = "([À-ß¨²É¥ª¯][à-ÿ¸³é´º¿]+)|([A-Z][a-z]+)")
	@Column(name = "name")
	private String name;

	public Person() {
	}

	public Person(String name, String lastName, String email, String mobileNumber) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public LoginInfo getInfo() {
		return info;
	}

	public String getLastName() {
		return lastName;
	}

	public String getsex() {
		return sex;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setInfo(LoginInfo info) {
		this.info = info;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setsex(String sex) {
		this.sex = sex;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", email=" + email + ", mobileNumber="
				+ mobileNumber + "]\n";
	}

}
