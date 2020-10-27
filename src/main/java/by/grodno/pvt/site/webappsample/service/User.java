package by.grodno.pvt.site.webappsample.service;

import java.util.Date;

public class User {

	private Integer id;
	private String firstName;
	private String lastName;
	private Date birthdate;
	private boolean male;

	private Integer department;
	private Double salary;

	public User(Integer id, String firstMame, String lastName, Date birthdate, boolean male) {
		super();
		this.id = id;
		this.firstName = firstMame;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.male = male;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
