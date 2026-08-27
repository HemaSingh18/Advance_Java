package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class TestInsertByDoctor {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate(
				"insert into Doctor values(1001,'Dr.seema','dentist',3,7458625586),(1002,'Dr.Hema','physician',6,785489631),(1003,'Dr.Hemant','Neurology',10,985643335),(1004,'Dr.mahi','Orthopedics',5,857854785),(1005,'Dr.sapna','Dermatology',1,58463555),(1006,'Dr.chinmay','Psychiatriest',2,5256235555)");

		System.out.println("Insert " + i + " record");

	}

}
