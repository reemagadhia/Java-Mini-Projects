package com.tatva.service;

import java.util.List;

import com.tatva.pojo.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);
	public void deleteEmployee(int id);
	public List<Employee> getEmployees();
	public Employee getDataById(int id);
	public void updateEmployee(Employee employee);
}
