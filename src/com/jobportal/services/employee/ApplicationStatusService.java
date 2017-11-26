package com.jobportal.services.employee;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jobportal.models.ApplicationModel;
import com.jobportal.models.JobPostModel;

public class ApplicationStatusService {
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

	public void changeApplicationStatus(String status, String email_id) throws Exception {
		try {
	        
			PreparedStatement preparedStatement = getConnection().
	                    prepareStatement("SELECT a.job_id from application_details as a join job_postings as j on a.job_id = j.job_id where j.emp_id=?");
	        preparedStatement.setString(1, email_id);
	        ResultSet rs = preparedStatement.executeQuery();
			
	        int job_id = 0;
	        while(rs.next()){
	           job_id = rs.getInt("job_id");
	        }
	        
	        System.out.println(job_id);
	        System.out.println(status);
			PreparedStatement preparedStatement2 = getConnection().
                    prepareStatement("update application_details set status=? where job_id=?");
			preparedStatement2.setString(1, status);
			preparedStatement2.setInt(2, job_id);
            preparedStatement2.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

	public ArrayList<ApplicationModel> getApplicationStatus(String email_id) throws Exception {
		ArrayList<ApplicationModel> status = new ArrayList<ApplicationModel>();
		try {
	        
			PreparedStatement preparedStatement = getConnection().
	                    prepareStatement("SELECT a.job_id from application_details as a join job_postings as j on a.job_id = j.job_id where j.emp_id=?");
	        preparedStatement.setString(1, email_id);
	        ResultSet rs = preparedStatement.executeQuery();
	        
	        int job_id = 0;
	        while(rs.next()){
	           job_id = rs.getInt("job_id");
	        }
	        
	        System.out.println(job_id);
	        
	        PreparedStatement preparedStatement2 = getConnection().
                    prepareStatement("select * from application_details where job_id=?");
			
			preparedStatement2.setInt(1, job_id);
			ResultSet rs2 = preparedStatement2.executeQuery();
	        
			//System.out.println("check");
			//System.out.println(rs2);
			
			while(rs2.next()){
				//System.out.println("check2");
				ApplicationModel model = new ApplicationModel();
				
				model.setEmail_id(rs2.getString("email_id"));
				model.setJob_id(rs2.getInt("job_id"));
				model.setStatus(rs2.getString("status"));
				status.add(model);
			}
	        
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return status;
	}
	
	
}
