package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoomModel {
	public static void main(String[] args) throws Exception {

		// search();
		// add();
		// update();
		// delete();
		//conditionalSearch();

	}

	private static void conditionalSearch() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		System.out.println("Connecting....");

		Statement stmt = conn.createStatement();
		// ResultSet rs = stmt.executeQuery("select * from Doctor where doctorId =
		// 1006");
		ResultSet rs = stmt.executeQuery("select * from Doctor where experience>=3");
		while (rs.next()) {
			System.out.println(rs.getInt("doctorId"));
			System.out.println(rs.getString("doctorName"));
			System.out.println(rs.getString("specialization"));
			System.out.println(rs.getInt("experience"));
			System.out.println("--------------------------------");
		}
	}

	private static void delete() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		System.out.println("Connecting....");

		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("delete from Doctor where doctorId=1002");
		System.out.println(i + " Rocord Deleted..");

	}

	private static void update() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		System.out.println("Connecting....");

		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("update  Doctor set specialization='Oncologist' where doctorId=1001");
		System.out.println(i + " Rocord update..");
	}

	private static void add() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		System.out.println("Connecting....");

		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate(
				"insert into Doctor values(1007,'Dr.mathur','surgical',1,5236458456),(1008,'Dr.shyam','Rheumatologist',6,78956454),(1009,'Dr.Ajit Singh','Pulmonologist',10,99995659255 )");
		System.out.println(i + " Rocord Insert..");

	}

	private static void search() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		System.out.println("connection ...." + conn.getCatalog());

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Doctor");
		while (rs.next()) {
			System.out.println("id :" + rs.getInt("doctorId"));
			System.out.println("Name :" + rs.getString("doctorName"));
			System.out.println("Specialization :" + rs.getString("specialization"));
			System.out.println("Experience :" + rs.getInt("experience"));
			System.out.println("Contact :" + rs.getString("contactNo"));
			System.out.println("_________________________________________");

		}
	}

}
