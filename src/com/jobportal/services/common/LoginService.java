package com.jobportal.services.common;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jobportal.models.EmployerModel;
import com.jobportal.models.JobSeekerModel;
import com.jobportal.repository.ILogin;

public class LoginService implements ILogin{
	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/placement?useSSL=false";
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

	public String authenticateUserandSpecifyType(String email_id, String password) {
		
		String dbPassword = "";
		String dbMember_type = "";
		try {
			
			String sql = "(select * from registration where email_id=?)";
						
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, email_id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
					dbPassword = rs.getString(4);
					dbMember_type = rs.getString(6);
			}
			if(dbPassword.equals(password)){
				
				if(dbMember_type.equals("Applicant")) {
					System.out.println(dbMember_type);
					return "Applicant";
					
				}else {
					
					return "Employer";
				}		
			}
			else {
				return null;
			}
				
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public EmployerModel getEmployerDetails(String email_id) {
		String dbEmailId = "";
		String dbFirstName = "";
		String dbLastName = "";
		try {
			String sql = "(select * from registration where email_id=?)";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, email_id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				dbEmailId = rs.getString(1);
				dbFirstName = rs.getString(2);
				dbLastName = rs.getString(3);
			}
			EmployerModel employerModel = new EmployerModel();
			employerModel.setEmail_id(dbEmailId);
			employerModel.setFirst_name(dbFirstName);
			employerModel.setLast_name(dbLastName);
			
			return employerModel;
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}	
	}
	
	public JobSeekerModel getJobSeekerDetails(String email_id) {
		String dbEmailId = "";
		String dbFirstName = "";
		String dbLastName = "";
		try {
			String sql = "(select * from registration where email_id=?)";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, email_id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				dbEmailId = rs.getString(1);
				dbFirstName = rs.getString(2);
				dbLastName = rs.getString(3);
			}
			JobSeekerModel jobSeekerModel = new JobSeekerModel();
			jobSeekerModel.setEmail_id(dbEmailId);
			jobSeekerModel.setFirst_name(dbFirstName);
			jobSeekerModel.setLast_name(dbLastName);
			
			return jobSeekerModel;
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}	
	}
	
}
