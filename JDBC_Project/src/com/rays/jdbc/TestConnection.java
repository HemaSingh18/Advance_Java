package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("Connection established successsful " + conn.getCatalog());

		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("select * from marksheet12");

		while (rs.next()) {
			System.out.println(rs.getInt("id"));
			System.out.println(rs.getInt("rollNo"));
			System.out.println(rs.getString("name"));
			System.out.println(rs.getInt("phy"));
			System.out.println(rs.getInt("chm"));
			System.out.println(rs.getInt("maths"));
			System.out.println("-------------------------------");
		}
	}

}
