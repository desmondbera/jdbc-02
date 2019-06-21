package com.jdbc02.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public abstract class MariaDBConnection {
	
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	// Method = connection()
	protected Connection getConnection() throws SQLException, ClassNotFoundException, IOException {
		final Properties prop = new Properties();
		final InputStream inputStream = MariaDBConnection.class.getClassLoader().getResourceAsStream("resources/db.properties");
		prop.load(inputStream);
		
//		Class.forName(prop.getProperty("DRIVER"));
		final Connection connection = DriverManager.getConnection(prop.getProperty("URL"), prop.getProperty("USER"), prop.getProperty("PASSWORD"));
		return connection;
	}
	
	// Method = dispose()
	
	protected void dispose(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
			
			if(ps != null && !ps.isClosed()) {
				ps.close();
			}
			
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
