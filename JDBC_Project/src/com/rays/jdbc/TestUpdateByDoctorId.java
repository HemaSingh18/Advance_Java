package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdateByDoctorId {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		System.out.println("Connected.....");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("update  Doctor set doctorName ='Dr.Nidhi' where doctorId=1004");

		System.out.println("Update " + i + " row record");
	}

}
