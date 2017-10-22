package com.jobportal.services.common;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jobportal.models.RegistrationModel;
import com.jobportal.repository.*;

public class LoginService implements ILogin{
	
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
	public RegistrationModel authenticateUser(RegistrationModel loginModel) {
		String dbEmailId = "";
		String dbFirstName = "";
		String dbLastName = "";
		String dbPassword = "";
		String dbAdmin_status = "";
		String dbMember_type = "";
		try {
			
			String email_id = loginModel.getEmail_id();
			String password = loginModel.getPassword();
			
			String sql = "(select 1 from registration where email_id=? and password=?)";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, email_id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				String userDetails = "select * from registration where email_id=? and password=?";
				PreparedStatement psUser = getConnection().prepareStatement(userDetails);
				psUser.setString(1, email_id);
				psUser.setString(2, password);
				
				ResultSet rsUser = psUser.executeQuery();
				
				while(rsUser.next()) {
					dbEmailId = rsUser.getString(1);
					dbFirstName = rsUser.getString(2);
					dbLastName = rsUser.getString(3);
					dbPassword = rsUser.getString(4);
					dbAdmin_status = rsUser.getString(5);
					dbMember_type = rsUser.getString(6);
				}

				RegistrationModel userDetailsModel = new RegistrationModel();
				userDetailsModel.setFirst_name(dbFirstName);
				userDetailsModel.setLast_name(dbLastName);
				userDetailsModel.setEmail_id(dbEmailId);
				userDetailsModel.setPassword(dbPassword);
				userDetailsModel.setAdmin_status(dbAdmin_status);
				userDetailsModel.setMember_type(dbMember_type);
				
				return userDetailsModel;
				
			}
			
			return null;
				
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
}
