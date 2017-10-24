package com.jobportal.services.user;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.jobportal.models.JobPostModel;

public class JobListingService {
	
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
	
	public static ArrayList<JobPostModel> getJobListings(String search){
	
		ArrayList<JobPostModel> jobListings = new ArrayList<JobPostModel>();
		JobPostModel jobListingModel = new JobPostModel();
		out.println("Search is"+search);
		try {
			String sql = "(SELECT * FROM job_postings WHERE job_title LIKE %"+search+"%)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ResultSet resultSet = ps.executeQuery(sql);
			
			while(resultSet.next()){
				jobListingModel.setJob_id(resultSet.getInt("job_id"));
				jobListingModel.setEmp_id(resultSet.getString("emp_id"));
				jobListingModel.setCompany(resultSet.getString("company_name"));
				jobListingModel.setLocation(resultSet.getString("location"));
				jobListingModel.setJob_title(resultSet.getString("job_title"));
				jobListingModel.setJob_description(resultSet.getString("job_description"));
				jobListingModel.setDeadline(resultSet.getDate("deadline"));
				
				jobListings.add(jobListingModel);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return jobListings;		
	}
}
