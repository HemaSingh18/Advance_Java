package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ComplaintModel {
	
	public int nextPK() throws Exception
	{
		int pk =0;
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
			//conn.setAutoCommit(false);
			
			PreparedStatement ps = conn.prepareStatement("select max(complaintId) from Complaint");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pk = rs.getInt(1);
				
				System.out.println(pk);
			}
			//conn.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			//conn.rollback();
		}finally {
			conn.close();
		}
		return pk+1;
	}
	

	public void create() throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
			conn.setAutoCommit(false);
			
			PreparedStatement ps = conn.prepareStatement("create table Complaint(complaintId int primary key,complaintType varchar(45),complaintDate Date,status varchar(45))");
			int i = ps.executeUpdate();
			conn.commit();
			System.out.println("Create Table "+i);
			
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
	}
	public void add(ComplaintBean bean) throws Exception {
		
		Connection conn = null;
		int pk = 0;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("insert into Complaint values(?,?,?,?)");
		ps.setInt(1,nextPK());
		ps.setString(2, bean.getComplaintType());
		ps.setDate(3, new java.sql.Date(bean.getComplaintDate().getTime()));
		ps.setString(4, bean.getStatus());
		
		int i = ps.executeUpdate();
		conn.commit();
		System.out.println("Insert Table successfully.. "+i);
		
	}catch(Exception e) {
		e.printStackTrace();
		conn.rollback();
	}finally {
		conn.close();
	}
  }
	public void delete(ComplaintBean bean) throws Exception{
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
			conn.setAutoCommit(false);
			
			PreparedStatement ps = conn.prepareStatement("delete from Complaint where complaintId=?");
			ps.setInt(1, bean.getComplaintId());
			
			int i = ps.executeUpdate();
			conn.commit();
			System.out.println("Row Deleted successfully...");
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}
		finally {
			conn.close();
		}
	}
	
     public void update(ComplaintBean bean) throws Exception {
		
		Connection conn = null;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("update Complaint set complaintType=?,complaintDate=?,status=? where ComplaintId=?");
		
		ps.setString(1, bean.getComplaintType());
		//ps.setString(2, bean.getDescription());
		ps.setDate(2, new java.sql.Date(bean.getComplaintDate().getTime()));
		ps.setString(3, bean.getStatus());
		ps.setInt(4,bean.getComplaintId());
		
		int i = ps.executeUpdate();
		conn.commit();
		System.out.println("Updated row successfully.. "+i);
		
	}catch(Exception e) {
		e.printStackTrace();
		conn.rollback();
	}finally {
		conn.close();
	}
  }
     
     public void search(ComplaintBean bean)throws Exception {
    	 
    	 Connection conn = null;
    	 
    	 try {
    		 Class.forName("com.mysql.cj.jdbc.Driver");
    		 conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
    		 conn.setAutoCommit(false);
    		 PreparedStatement ps = conn.prepareStatement("select * from Complaint");
    		 ResultSet rs = ps.executeQuery();
    		 conn.commit();
    		 while(rs.next()) {
    			 System.out.println("Complaint Id :"+rs.getInt("complaintId"));
    			 System.out.println("Complaint Type :"+rs.getString("complaintType"));
    			 System.out.println("Complaint Date :"+rs.getDate("complaintDate"));
    			 System.out.println("Status :"+rs.getString("status"));
    			 System.out.println("--------------------------------");
    		 }
    		 
    	 }catch(Exception e) {
    		 e.printStackTrace();
    		 conn.rollback();
    	 }finally {
    		 conn.close();
    	 }
    	 
     }
	
}

