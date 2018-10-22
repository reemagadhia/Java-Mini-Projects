package com.tatva.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="employeeName")
	private String employeeName;
	@Column(name="employeeEmail")
	private String employeeEmail;
	@Column(name="employeePassword")
	private String employeePassword;
	
	
	public Employee() {
		super();
	}
	public Employee(int id) {
		super();
		this.id = id;
	}
	public Employee(String employeeName, String employeeEmail,
			String employeePassword) {
		super();
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeePassword = employeePassword;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeName=" + employeeName
				+ ", employeeEmail=" + employeeEmail + ", employeePassword="
				+ employeePassword + "]";
	}
	
}
