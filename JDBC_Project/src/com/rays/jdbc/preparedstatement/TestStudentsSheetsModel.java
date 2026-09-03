package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;

public class TestStudentsSheetsModel {

	public static void main(String[] args) throws Exception {
		// add();
		// update();
		delete();
	}

	private static void delete() throws Exception {

		StudentsSheetsModel sm = new StudentsSheetsModel();
		sm.delete(6);
	}

	private static void update() throws Exception {

		StudentsSheetsModel sm = new StudentsSheetsModel();
		sm.update("Good student", "active", 3);
	}

	private static void add() throws Exception {

		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		StudentsSheetsModel sm = new StudentsSheetsModel();
		sm.add(7, 20027, simple.parse("2025-04-10"), "active", "good person");

	}

}
