package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelectByDoctor {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("connection successful.....");

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Doctor");

		while (rs.next()) {
			System.out.println("ID :" + rs.getInt("doctorId"));
			System.out.println("Name :" + rs.getString("doctorName"));
			System.out.println("Specialization :" + rs.getString("specialization"));
			System.out.println("Experience :" + rs.getInt("experience"));
			System.out.println("Contact No. :" + rs.getString("contactNo"));
			System.out.println("---------------------------------------------------");

		}
	}

}
