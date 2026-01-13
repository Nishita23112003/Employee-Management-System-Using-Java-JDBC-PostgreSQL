package com.qsp.employee_management_system.connection;
import java.sql.*;
public class GetConnection {

	public static Connection getConnectionObject() {
		String url="jdbc:postgresql://localhost:5432/ems_db";
		String user="postgres";
		String pwd="nishi";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection(url, user, pwd);
			return con;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
