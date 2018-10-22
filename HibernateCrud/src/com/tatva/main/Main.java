package com.tatva.main;

import java.util.Scanner;

import com.tatva.pojo.Employee;
import com.tatva.service.EmployeeService;
import com.tatva.service.impl.EmployeeServiceImpl;

public class Main {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		EmployeeService service = new EmployeeServiceImpl();
		Employee employee = new Employee();
		int choice,id;
		String employeeName, employeeEmail, employeePassword;
		do{
			System.out.println("\nPlease Enter your Choice:\n"
					+ "1. Add Employee\n"
					+ "2. Delete Employee\n"
					+ "3. Update Employee\n"
					+ "4. View All Employees\n"
					+ "5. View a single Employee\n"
					+ "6. Exit\n");
			
		    choice = scanner.nextInt();
		    switch(choice){
		    case 1:
		    	System.out.println("\nPlease Enter Employee Name:");
		    	employeeName = scanner.next();
		    	employee.setEmployeeName(employeeName);
		    	
		    	System.out.println("\nPlease Enter Employee Email:");
		    	employeeEmail = scanner.next();
		    	employee.setEmployeeEmail(employeeEmail);
		    	
		    	System.out.println("\nPlease Enter Employee Password:");
		    	employeePassword = scanner.next();
		    	employee.setEmployeePassword(employeePassword);
		    	System.out.println("\n----DATA ADDED SUCCESSFULLY----");
		    	service.addEmployee(employee);
		    	break;
		    	
		    case 2:
		    	System.out.println("\nPlease Enter Id of the Employee you want to delete:");
		    	id = scanner.nextInt();
		    	service.deleteEmployee(id);
		    	System.out.println("\n----DATA DELETED SUCCESSFULLY----");
		    	break;
		    	
		    case 3:
		    	System.out.println("\nPlease Enter Id of Employee you want to update:");
		    	id = scanner.nextInt();
		    	employee.setId(id); 
		    	
		    	System.out.println("\nPlease Enter Employee Name:");
		    	employeeName = scanner.next();
		    	employee.setEmployeeName(employeeName);
		    	
		    	System.out.println("\nPlease Enter Employee Email:");
		    	employeeEmail = scanner.next();
		    	employee.setEmployeeEmail(employeeEmail);
		    	
		    	System.out.println("\nPlease Enter Employee Password:");
		    	employeePassword = scanner.next();
		    	employee.setEmployeePassword(employeePassword);
		    	
		    	service.updateEmployee(employee);
		    	System.out.println("\n----DATA UPDATED SUCCESSFULLY----");
		    	service.updateEmployee(employee);
		    	break;
		    	
		    case 4:
		    	System.out.println("\nEMPLOYEE DATA\n");
		    	System.out.print("Id\t");
	    		System.out.print("Emp Name\t");
	    		System.out.print("Emp Email\t\t");
	    		System.out.print("Emp Password");
		    	for(Employee emp:service.getEmployees()){
                    System.out.print("\n"+emp.getId()+"\t");
		    		System.out.print(emp.getEmployeeName()+"\t");
		    		System.out.print("\t"+emp.getEmployeeEmail()+"\t");
		    		System.out.print("\t"+emp.getEmployeePassword()+"\n");
		    	}
		    	break;
		    	
		    case 5:
		    	System.out.println("\nPlease Enter Id of the Employee you want to view:");
		    	id = scanner.nextInt();
		    	Employee emp = service.getDataById(id);
		    	System.out.print("Id\t");
	    		System.out.print("Emp Name\t");
	    		System.out.print("Emp Email\t\t");
	    		System.out.print("Emp Password");
                System.out.print("\n"+emp.getId()+"\t");
		    	System.out.print(emp.getEmployeeName()+"\t");
		    	System.out.print("\t"+emp.getEmployeeEmail()+"\t");
		    	System.out.print("\t"+emp.getEmployeePassword()+"\n");
		    	break;
		    	
		    case 6:
		    	System.out.println("END!!!");
		    	break;
		    	
		    default:
		    	System.out.println("\nInvalid Choice\n");
		    }
		}while(choice!=6);
	}

}
