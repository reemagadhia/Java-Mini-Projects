package com.tatva.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tatva.dao.EmployeeDao;
import com.tatva.pojo.Employee;
import com.tatva.util.Util;

public class EmployeeDaoImpl implements EmployeeDao{
	Transaction tx = null;
	
	@Override
	public void addEmployee(Employee employee) {
		Session session = Util.getSessionFactory().openSession();
		try{
			tx = session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
		}
		catch(Exception e){
			if(tx!= null){
				tx.rollback();
			}
		}
		finally{
			session.flush();
			session.close();
		}
	}

	@Override
	public void deleteEmployee(int id) {
		Session session = Util.getSessionFactory().openSession();
		Employee employee = new Employee(id);
		try{
			tx = session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit();
		}
		catch(Exception e){
			if(tx!= null){
				tx.rollback();
				System.out.println("\nYou cannot delete record that doesn't exist.\n");
			}
		}
		finally{
			session.flush();
			session.close();
		}
	}

	@Override
	public List<Employee> getEmployees() {
		Session session = Util.getSessionFactory().openSession();
		List<Employee> employees = new ArrayList<>();
		try{
			tx = session.beginTransaction();
			employees = session.createQuery("from com.tatva.pojo.Employee").list();
		}
		catch(Exception e){
			
		}
		return employees;
	}

	@Override
	public Employee getDataById(int id) {
		Session session = Util.getSessionFactory().openSession();
		Employee employee = new Employee(id);
		try{
			tx = session.beginTransaction();
			Query qry = session.createQuery("from com.tatva.pojo.Employee where id =:id");
			qry.setInteger("id", id);
			employee = (Employee) qry.uniqueResult();
			session.getTransaction().commit();
		}
		catch(Exception e){
			if(tx!= null){
				tx.rollback();
			}
		}
		finally{
			session.flush();
			session.close();
		}
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session session = Util.getSessionFactory().openSession();
		try{
			tx = session.beginTransaction();
			session.update(employee);
			session.getTransaction().commit();
		}
		catch(Exception e){
			if(tx!= null){
				tx.rollback();
				System.out.println("\nYou cannot update record that doesn't exist.\n");
			}
		}
		finally{
			session.close();
		}
	}
	
}
