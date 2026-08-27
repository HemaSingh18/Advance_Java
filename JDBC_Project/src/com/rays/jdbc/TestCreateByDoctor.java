package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCreateByDoctor {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate("create table Doctor(doctorId int primary key,doctorName varchar(45),specialization varchar(45),experience int,contactNo varchar(75))" );
		System.out.println("Table Created "+i+"row affected");
	}

}
