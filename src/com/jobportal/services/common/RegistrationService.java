package com.jobportal.services.common;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.jobportal.models.RegistrationModel;

public class RegistrationService {
	
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

	public boolean registerUser(RegistrationModel registrationModel) {
		boolean result = false;
		
		String emailId = registrationModel.getEmail_id();
		String password = registrationModel.getPassword();
		String firstName = registrationModel.getFirst_name();
		String lastName = registrationModel.getLast_name();
		
		String sql = "insert into registration"
				+ "(email_id, first_name, last_name, password) values(?,?,?,?)";
		
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, emailId);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, password);
			
			ps.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}

}
