package com.jdbc02.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc02.dao.MariaDBConnection;

public class EmployeeDAO extends MariaDBConnection implements EmployeeDAOI {
	
	@Override
	public List<Employee> getAllEmployees() throws SQLException, ClassNotFoundException, IOException {
		List<Employee> employeeList = new ArrayList<>();
		conn = this.getConnection();
		ps = conn.prepareStatement(SQL.GET_ALL_EMPLOYEES.getQuery());
		rs = ps.executeQuery();
		while(rs.next()) {
			employeeList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
//			System.out.printf("employee %d: %d %s %s %s %n", employeeCount, rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
		}
		this.dispose(conn, ps, rs);
		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeById(int pEmployeeId) throws SQLException, ClassNotFoundException, IOException {

		List<Employee> employeeList = new ArrayList<>();
		conn = this.getConnection();
		ps = conn.prepareStatement(SQL.GET_EMPLOYEE_BY_ID.getQuery());
		ps.setInt(1, pEmployeeId);
		rs = ps.executeQuery();
		while(rs.next()) {
			employeeList.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		}
		
		this.dispose(conn, ps, rs);
		return employeeList;
	}

	@Override
	public boolean insertEmployee(Employee pEmployee) throws SQLException, ClassNotFoundException, IOException {
		
		conn = this.getConnection();
		ps = conn.prepareStatement(SQL.INSERT_EMPLOYEE.getQuery());
		ps.setInt(1,  pEmployee.getId());
		ps.setString(2, pEmployee.getFirstName());
		ps.setString(3, pEmployee.getLastName());
		ps.setString(4,  pEmployee.getEmail());
		
		int result = ps.executeUpdate();
		
		boolean x = result > 0 ? true : false;
		
		return x;
	}

	@Override
	public boolean deleteEmployee(Employee pEmployee) throws SQLException, ClassNotFoundException, IOException {
		conn = this.getConnection();
		ps = conn.prepareStatement(SQL.DELETE_EMPLOYEE.getQuery());
		
		ps.setInt(1, pEmployee.getId());
//		ps.setString(1, pEmployee.getFirstName());
//		ps.setString(2, pEmployee.getLastName());
//		ps.setInt(3,  pEmployee.getId());
		
		
		
		int result = ps.executeUpdate();
		
		boolean x = result > 0 ? true : false;
		
		return x;
	}

	@Override
	public boolean updateEmployee(Employee pEmployee) throws ClassNotFoundException, SQLException, IOException {
		conn = this.getConnection();
		ps = conn.prepareStatement(SQL.UPDATED_EMPLOYEE.getQuery());
		
		ps.setString(1, pEmployee.getFirstName());
		ps.setString(2, pEmployee.getLastName());
		ps.setInt(3,  pEmployee.getId());
		
		int result = ps.executeUpdate();
		
		boolean x = result > 0 ? true : false;
		
		return x;
	}

}
