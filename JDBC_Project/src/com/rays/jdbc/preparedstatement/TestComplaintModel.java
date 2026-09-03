package com.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;

public class TestComplaintModel {

	public static void main(String[] args) throws Exception {
		//testcreate();
		//testAdd();
		//testDelete();
		//testUpdate();
		testSearch();
	}

	private static void testcreate() throws Exception {

		//SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");

		ComplaintModel cm = new ComplaintModel();
		//bean.setComplaintId(16);

	}
	private static void testAdd() throws Exception {
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");

		ComplaintModel cm = new ComplaintModel();
		ComplaintBean bean = new ComplaintBean();
		bean.setComplaintType("consumer complaint");
		bean.setDescription("customer froud");
		bean.setComplaintDate(simple.parse("2002-03-10"));
		cm.add(bean);
	}
	private static void testDelete() throws Exception {
		ComplaintModel cm = new ComplaintModel();
		ComplaintBean cb = new ComplaintBean();
		cb.setComplaintId(1); 
		cm.delete(cb);
	}
	private static void testUpdate() throws Exception {
		ComplaintModel cm = new ComplaintModel();
		ComplaintBean bean = new ComplaintBean();
		
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		
		bean.setComplaintId(16);
		bean.setComplaintType("H&M complaint");
		//bean.setDescription("customer froud");
		bean.setComplaintDate(simple.parse("2002-04-10"));
		bean.setStatus("running");
		cm.update(bean);
	}
	 
	private static void testSearch() throws Exception {
		ComplaintModel cm = new ComplaintModel();
		ComplaintBean bean = new ComplaintBean();
		cm.search(bean);
	}
}
