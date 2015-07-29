package ua.com.jobsukraine.form;

import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;

public class EmployerForm {

	private Employer emp;

	private LoginInfo info;

	public EmployerForm() {
		// TODO Auto-generated constructor stub
	}

	public Employer getEmp() {
		return emp;
	}

	public LoginInfo getInfo() {
		return info;
	}

	public void setEmp(Employer emp) {
		this.emp = emp;
	}

	public void setInfo(LoginInfo info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "EmployerForm [emp=" + emp + ", info=" + info + "]";
	}

}
