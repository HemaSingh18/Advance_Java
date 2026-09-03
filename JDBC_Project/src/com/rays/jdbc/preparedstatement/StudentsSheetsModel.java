package com.rays.jdbc.preparedstatement;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class StudentsSheetsModel {

	public void add(int attendanceId, int studentId, Date date, String status, String remarks) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			conn.setAutoCommit(false);

			PreparedStatement ps = conn.prepareStatement("insert into StudentsSheets values(?,?,?,?,?)");
			ps.setInt(1, attendanceId);
			ps.setInt(2, studentId);
			ps.setDate(3, new java.sql.Date(date.getTime()));
			ps.setString(4, status);
			ps.setString(5, remarks);

			int i = ps.executeUpdate();
			conn.commit();
			System.out.println("Record Insert Successfully: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	// public void update(int attendanceId, int studentId, Date date, String status,
	// String remarks) throws Exception
	public void update(String remarks, String status, int attendanceId) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			conn.setAutoCommit(false);

			PreparedStatement ps = conn
					.prepareStatement("update StudentsSheets set status=?,remarks=? where attendanceId=?");

			ps.setString(1, remarks);
			// ps.setInt(2, studentId);
			// ps.setDate(3, new java.sql.Date(date.getTime()));
			ps.setString(2, status);
			ps.setInt(3, attendanceId);

			int i = ps.executeUpdate();
			conn.commit();
			System.out.println("Record update Successfully: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public static void delete(int attendanceId) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			conn.setAutoCommit(false);

			PreparedStatement ps = conn.prepareStatement("delete from StudentsSheets where attendanceId = ?");
			ps.setInt(1, attendanceId);

			int i = ps.executeUpdate();
			conn.commit();
			System.out.println(i + " Recorde deleted");
		} catch (Exception e) {
			//System.out.println(e.getMessage());
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

}
