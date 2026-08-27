package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("Connection established successsful " + conn.getCatalog());

		Statement stm = conn.createStatement();
		int i = stm.executeUpdate("update marksheet12 set name ='priya' where id=11");
		System.out.println("Update marksheet " + i + " row affected");
	}
}
