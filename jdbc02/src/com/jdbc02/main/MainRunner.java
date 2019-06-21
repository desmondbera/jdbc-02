package com.jdbc02.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainRunner {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
//		showAllEmployees();
//		showEmployee();
//		newEmployee();
//		Employee employee = new Employee(22, "terry", "griffin", "tgriffin@gmail.com");
//		newEmployee(employee);
		
//		Employee employee = new Employee(22, "terry", "BIG G", "tgriffin@gmail.com");
//		updateEmployee(employee);
		
		Employee employee = new Employee(22, null, null, null);
		
		deleteEmployee(employee);
	}

	private static void updateEmployee(Employee pEmployee) throws ClassNotFoundException, SQLException, IOException {
		EmployeeDAO empDAO = new EmployeeDAO();
		boolean result = empDAO.updateEmployee(pEmployee);
		if(result) {
			System.out.println("Employee updated!");
		} else {
			System.out.println("Employeed not updated.");
		}
	}

	private static void deleteEmployee(Employee pEmployee) throws ClassNotFoundException, SQLException, IOException {
		EmployeeDAO empDAO = new EmployeeDAO();
		boolean result = empDAO.deleteEmployee(pEmployee);
		if(result) {
			System.out.println("Employee deleted!");
		} else {
			System.out.println("Employeed not updated.");
		}
	}

	private static void newEmployee(Employee pEmployee) throws ClassNotFoundException, SQLException, IOException {
		EmployeeDAO newEMP = new EmployeeDAO();
		boolean result = newEMP.insertEmployee(pEmployee);
		if(result) {
			System.out.println("Employee saved!");
		} else {
			System.out.println("Save failed");
		}		
	}

	private static void showEmployee() throws ClassNotFoundException, SQLException, IOException {
		EmployeeDAOI empDAO = new EmployeeDAO();
		System.out.println(empDAO.getEmployeeById(10));
		
	}

	private static void showAllEmployees() throws ClassNotFoundException, SQLException, IOException {

		// declare an employee list
		List<Employee> employeeList = new ArrayList<>();
	
		// Call getAllEmployees from employeeDAO
		EmployeeDAO employee = new EmployeeDAO();
		employeeList = employee.getAllEmployees();
		
		//print list of employees
		for(Employee x : employeeList) {
			System.out.println("X is: " + x.toString());
		}
	}

}
