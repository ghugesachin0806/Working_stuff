package com.student.manager;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDao {

	public static void insertStudentToDB(Student st) {

		try {

			// JDBC connecting...
			Connection con = CP.createC();
			String qt = "insert into students(sname,sphone,scity) values(?,?,?)";

			// prepared statement

			PreparedStatement pstmt = con.prepareStatement(qt);

			// set parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());

			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void deleteStudent(int userID) {
		// TODO Auto-generated method stub

		try {

			// JDBC connecting...
			Connection con = CP.createC();
			String qt = "delete from students where sid=?";

			// prepared statement

			PreparedStatement pstmt = con.prepareStatement(qt);

			// set parameters
			pstmt.setInt(1, userID);

			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void showAllStudents() {
		// TODO Auto-generated method stub
		try {

			// JDBC connecting...
			Connection con = CP.createC();
			String qt = "select * from students ;";
			Statement stmtlStatement = con.createStatement();

			ResultSet set = stmtlStatement.executeQuery(qt);

			while (set.next()) {
				System.out.println("ID : " + set.getInt("sid"));
				System.out.println("Name : " + set.getString("sname"));
				System.out.println("phone : " + set.getString("sphone"));
				System.out.println("city : " + set.getString("scity"));
				
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
