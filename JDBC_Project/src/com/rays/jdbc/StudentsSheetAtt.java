package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class StudentsSheetAtt {

	public static void main(String[] args) throws Exception {

		// create();
		// add();
		search();
	}

	private static void search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		System.out.println("connection successfull...");

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from StudentsSheets");

		while (rs.next()) {
			System.out.println("Attendance ID :" + rs.getInt("attendanceId"));
			System.out.println("Student Id :" + rs.getInt("studentId"));
			System.out.println("Date :" + rs.getDate("date"));
			System.out.println("Status :" + rs.getString("status"));
			System.out.println("Remarks :" + rs.getString("remarks"));
			System.out.println("-------------------------------------------");
		}
	}

	private static void add() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		System.out.println("connection successfull...");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"insert into StudentsSheets values(1,20021,'2023/05/1','active','attendans full'),(2,20022,'2023/05/5','active','new student'),(3,10024,'2024/02/10','NO','leave in collage'),(4,20025,'2024/02/13','yes','active')");

		System.out.println("row " + i + " record effected..");
	}

	private static void create() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		System.out.println("Connecting....");

		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate(
				"create table StudentsSheets(attendanceId int primary key,studentId long,date Date,status varchar(45), remarks varchar(45))");
		System.out.println(i + " table created...");

	}

}