package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class PatientModel {

	public void create() throws Exception {
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(
					"create table Patient(patientId int primary key, patientName varchar(45),disease varchar(45),doctorName varchar(45),admissionDate Date)");
			int i = ps.executeUpdate();
			System.out.println("Patient table Created " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.commit();
		} finally {
			conn.close();
		}
	}

	public void add(PatientBean bean) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("insert into Patient values(?,?,?,?,?)");

			ps.setInt(1, bean.getPatientId());
			ps.setString(2, bean.getPatientName());
			ps.setString(3, bean.getDisease());
			ps.setString(4, bean.getDoctorName());
			ps.setDate(5, new java.sql.Date(bean.getAdmissionDate().getTime()));
			int i = ps.executeUpdate();
			conn.commit();
			System.out.println("insert row " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();

		} finally {
			conn.close();
		}

	}

	public void update(PatientBean bean) throws Exception {

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(
					"update Patient set patientName=?,disease=?,doctorName=?,admissionDate=? where PatientId=?");

			ps.setString(1, bean.getPatientName());
			ps.setString(2, bean.getDisease());
			ps.setString(3, bean.getDoctorName());
			ps.setDate(4, new java.sql.Date(bean.getAdmissionDate().getTime()));
			ps.setInt(5, bean.getPatientId());
			int i = ps.executeUpdate();
			conn.commit();
			System.out.println("updated " + i + " row");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void delete(PatientBean bean) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("delete from Patient where PatientId=?");
			ps.setInt(1, bean.getPatientId());
			int i = ps.executeUpdate();
			conn.commit();
			System.out.println("Deleted " + i + " row data..");
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void search(PatientBean bean) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("select * from Patient");
			ResultSet rs = ps.executeQuery();
			conn.commit();
			while (rs.next()) {
				System.out.println("Patient Id :" + rs.getInt("PatientId"));
				System.out.println("Patient Name :" + rs.getString("PatientName"));
				System.out.println("Disease :" + rs.getString("Disease"));
				System.out.println("DoctorName :" + rs.getString("DoctorName"));
				System.out.println("Admission Date :" + rs.getDate("AdmissionDate"));
				System.out.println("------------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

}
