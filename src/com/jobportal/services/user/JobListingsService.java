package com.jobportal.services.user;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.models.EducationModel;
import com.jobportal.models.JobPostModel;

public class JobListingsService {
	
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

	public List<JobPostModel> getJobListings(String keyword) throws Exception {
		List<JobPostModel> joblist = new ArrayList<>();
		try {
			// We should write where email_id condition using session in the below sql command
			PreparedStatement preparedStatement = getConnection().
                    prepareStatement("select * from job_postings");
            //preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet rs = preparedStatement.executeQuery();
           
            while (rs.next()) {
                JobPostModel joblistmodel = new JobPostModel();
                joblistmodel.setJob_id(rs.getInt("job_id"));
                joblistmodel.setCompany(rs.getString("company_name"));
                joblistmodel.setJob_title(rs.getString("job_title"));
                joblistmodel.setLocation(rs.getString("location"));
                joblistmodel.setJob_description(rs.getString("job_description"));
                
                joblist.add(joblistmodel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		List<JobPostModel> joblist2 = new ArrayList<>();
		for(JobPostModel jpm: joblist){
			if(jpm.getJob_title().toLowerCase().contains(keyword) || jpm.getJob_description().toLowerCase().contains(keyword)){
				JobPostModel joblistmodel = new JobPostModel();
                joblistmodel.setJob_id(jpm.getJob_id());
                joblistmodel.setCompany(jpm.getCompany());
                joblistmodel.setJob_title(jpm.getJob_title());
                joblistmodel.setLocation(jpm.getLocation());
                joblistmodel.setJob_description(jpm.getJob_description());
                
                joblist2.add(joblistmodel);
			}
		}
		
		return joblist2;
		
	}

}
