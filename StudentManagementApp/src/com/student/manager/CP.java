package com.student.manager;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	
	public static Connection con;
	
	public static Connection createC() {
		
		try {
			// LOAD the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Create connection ....
			String url = "jdbc:mysql://localhost:3306/student_manage";
			String username = "root";
			String pass =  "rivendell";
			
			con = DriverManager.getConnection(url, username, pass);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}

}
