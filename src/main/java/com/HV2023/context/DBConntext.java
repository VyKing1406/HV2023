package com.HV2023.context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConntext {
	private final String jdbcUrl = "jdbc:mysql://localhost:3306/elearning";
	private final String user = "root";
    private final String password = "HoangVuong";
	public Connection getConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			return DriverManager.getConnection(jdbcUrl, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
