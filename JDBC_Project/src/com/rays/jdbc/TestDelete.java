package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("Connection established successsful " + conn.getCatalog());

		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("delete from marksheet12 where id =6");
		System.out.println("Record " + i + " deleted");
	}

}
