package com.tatva.service.impl;

import java.util.List;

import com.tatva.dao.EmployeeDao;
import com.tatva.dao.impl.EmployeeDaoImpl;
import com.tatva.pojo.Employee;
import com.tatva.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	EmployeeDao dao = new EmployeeDaoImpl();

	@Override
	public void addEmployee(Employee employee) {
		dao.addEmployee(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		dao.deleteEmployee(id);
	}

	@Override
	public List<Employee> getEmployees() {
		return dao.getEmployees();
	}

	@Override
	public Employee getDataById(int id) {
		return dao.getDataById(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		dao.updateEmployee(employee);
	}
	
}
