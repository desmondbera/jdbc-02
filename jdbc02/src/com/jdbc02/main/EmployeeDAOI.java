package com.jdbc02.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAOI {
	enum SQL {
		GET_ALL_EMPLOYEES("SELECT * FROM employee"), 
		GET_EMPLOYEE_BY_ID("SELECT * FROM employee WHERE id = ?"),
		
		INSERT_EMPLOYEE("INSERT INTO employee VALUES(?, ?, ?, ?)"),
		DELETE_EMPLOYEE("delete from employee where id = ?"),
		UPDATED_EMPLOYEE("UPDATE employee SET firstName = ?, lastName = ? where id = ?");
		
		private final String query;
		SQL(String s) {
			this.query = s;
		}
		
		public String getQuery() {
			return query;
		}
	}
	
	List<Employee> getAllEmployees() throws SQLException, ClassNotFoundException, IOException;
	List<Employee> getEmployeeById(int pEmployeeId) throws SQLException, ClassNotFoundException, IOException;
	boolean insertEmployee(Employee pEmployee) throws SQLException, ClassNotFoundException, IOException;
	boolean deleteEmployee(Employee employeeId) throws SQLException, ClassNotFoundException, IOException;
	boolean updateEmployee(Employee pEmployee) throws ClassNotFoundException, SQLException, IOException;
}
