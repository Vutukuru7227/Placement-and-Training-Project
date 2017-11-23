package com.jobportal.services.common;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.jobportal.models.UserModel;

public class RegistrationService {
	
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

	public boolean registerUser(UserModel registrationModel) {
		boolean result = false;
		
		String emailId = registrationModel.getEmail_id();
		String password = registrationModel.getPassword();
		String firstName = registrationModel.getFirst_name();
		String lastName = registrationModel.getLast_name();
		String admin_status = "0";
		String member_type = registrationModel.getMember_type();
		
		String sql = "insert into registration"
				+ "(email_id, first_name, last_name, password, admin_status, member_type) values(?,?,?,?,?,?)";
		
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, emailId);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, password);
			ps.setString(5, admin_status);
			ps.setString(6, member_type);
			
			ps.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}	
		return result;
	}
}