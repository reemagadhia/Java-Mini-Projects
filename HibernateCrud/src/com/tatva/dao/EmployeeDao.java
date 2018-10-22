package com.tatva.dao;

import java.util.List;

import com.tatva.pojo.Employee;


public interface EmployeeDao {
	public void addEmployee(Employee employee);
	public void deleteEmployee(int id);
	public List<Employee> getEmployees();
	public Employee getDataById(int id);
	public void updateEmployee(Employee employee);
}
