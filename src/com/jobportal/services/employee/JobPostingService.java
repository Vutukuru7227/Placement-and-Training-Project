package com.jobportal.services.employee;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jobportal.models.ApplicationModel;
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
	
	
	public ArrayList<JobPostModel> getJobIds(String emp_id){
		ArrayList<JobPostModel> jobs = new ArrayList<JobPostModel>();

		String sql = "select * "
				+ "FROM job_postings j"
				+ " WHERE emp_id = ?";
			
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, emp_id);				
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				JobPostModel model = new JobPostModel();
				model.setJob_id(rs.getInt("job_id"));
				model.setEmp_id(rs.getString("emp_id"));
				model.setCompany(rs.getString("company_name"));
				model.setLocation(rs.getString("location"));
				model.setJob_title(rs.getString("job_title"));
				model.setJob_description(rs.getString("job_description"));
				model.setDeadline(rs.getDate("deadline"));
				jobs.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return jobs;

	}
	public ArrayList<ApplicationModel> viewSpecificJobPosted(int job_id) {
		
		ArrayList<ApplicationModel> appliedList = new ArrayList<ApplicationModel>();
		

		String sql = "SELECT * "
				+ "FROM application_details a, job_postings j "
				+ "WHERE j.job_id = a.job_id "
				+ "AND j.job_id = ?";
		
		try {
			
			String job_id_str = job_id+"";
			out.println(job_id_str);
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
		
			ps.setString(1, job_id_str);				
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				ApplicationModel model = new ApplicationModel();
				model.setJob_id(rs.getInt("job_id"));
				model.setEmail_id(rs.getString("email_id"));
				out.print(rs.getString("email_id"));
				appliedList.add(model);
				}
			} catch (Exception e) {
			e.printStackTrace();
		}
		return appliedList;
		
	}
}
