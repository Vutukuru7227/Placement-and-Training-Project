package com.jobportal.services.employee;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.jobportal.models.JobPostModel;
import com.jobportal.repository.IEmployee;

public class JobPostingService implements IEmployee{

	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/placement";
			String username = "root";
			String password = "";
			
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			out.println("Connection established");
			
			return conn;
		}catch (Exception e) {
			out.println("Connection error");
		}
		return null;
	}

	@Override
	public boolean postJob(JobPostModel jobpostModel) {
		// TODO Auto-generated method stub
		String emp_id = jobpostModel.getEmp_id();
		String company_name = jobpostModel.getCompany();
		String location = jobpostModel.getLocation();
		String job_title = jobpostModel.getJob_title();
		String job_description = jobpostModel.getJob_description();
		Date application_deadline = convertJavaDateToSqlDate(jobpostModel.getDeadline());
		
		java.sql.Date deadline = (java.sql.Date) application_deadline;
		
		String sql = "insert into job_postings (emp_id, company_name, location, job_title, job_description, deadline) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, emp_id);
			ps.setString(2, company_name);
			ps.setString(3, location);
			ps.setString(4, job_title);
			ps.setString(5, job_description.toString());
			ps.setDate(6, deadline);
			
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
	    return new java.sql.Date(date.getTime());
	}

}
