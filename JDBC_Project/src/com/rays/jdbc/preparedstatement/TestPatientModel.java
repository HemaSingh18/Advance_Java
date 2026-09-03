package com.rays.jdbc.preparedstatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestPatientModel {

	public static void main(String[] args) throws Exception {

		// testcreate();
		//testadd();
		// testupdate();
		 //testdelete();
		testsearch();
	}

	private static void testcreate() throws Exception {
		PatientModel pm = new PatientModel();
		pm.create();
	}

	private static void testadd() throws Exception {

		PatientModel pm = new PatientModel();
		PatientBean pb = new PatientBean();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		pb.setPatientId(6);
		pb.setPatientName("shyam sunder");
		pb.setDisease("fiver");
		pb.setDoctorName("Dr.ram");
		pb.setAdmissionDate(format.parse("2024-05-12"));
		pm.add(pb);
	}

	private static void testupdate() throws Exception {

		PatientModel pm = new PatientModel();
		PatientBean pb = new PatientBean();

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		pb.setPatientId(1);
		pb.setPatientName("nehal");
		pb.setDisease("COVID-19");
		pb.setDoctorName("Dr. Priti");
		pb.setAdmissionDate(format.parse("2023-02-13"));
		pm.update(pb);
	}

	private static void testdelete() throws Exception {

		PatientModel pm = new PatientModel();
		PatientBean pb = new PatientBean();
		pb.setPatientId(1);
		pm.delete(pb);
	}
	private static void testsearch() throws Exception {
		PatientModel pm = new PatientModel();
		PatientBean pb = new PatientBean();
		pm.search(pb);
	}
}
