package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSearchConditional {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		System.out.println("connection successfull...."+conn.getCatalog());
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from marksheet12 where name ='nehal'");
		//System.out.println(rs.getString(""));
		while(rs.next()) {
			System.out.println("Id :"+rs.getInt("id"));
			System.out.println("rollNo :"+rs.getInt("rollNo"));
			System.out.println("Name :"+rs.getString("name"));
			System.out.println("Phy :"+rs.getInt("phy"));
			System.out.println("Maths :"+rs.getInt("maths"));
		}
	}

}
