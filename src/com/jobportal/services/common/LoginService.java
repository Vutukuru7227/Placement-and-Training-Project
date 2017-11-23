package com.jobportal.services.common;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jobportal.models.UserModel;
import com.jobportal.repository.*;

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

	@Override
	public UserModel authenticateUser(UserModel loginModel) {
		String dbEmailId = "";
		String dbFirstName = "";
		String dbLastName = "";
		String dbPassword = "";
		String dbAdmin_status = "";
		String dbMember_type = "";
		try {
			
			String email_id = loginModel.getEmail_id();
			
			String sql = "(select * from registration where email_id=?)";
						
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, email_id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {

					dbEmailId = rs.getString(1);
					dbFirstName = rs.getString(2);
					dbLastName = rs.getString(3);
					dbPassword = rs.getString(4);
					dbAdmin_status = rs.getString(5);
					dbMember_type = rs.getString(6);
			}
			if(dbPassword.equals(loginModel.getPassword())){
				UserModel userDetailsModel = new UserModel();
				userDetailsModel.setFirst_name(dbFirstName);
				userDetailsModel.setLast_name(dbLastName);
				userDetailsModel.setEmail_id(dbEmailId);
				userDetailsModel.setPassword(dbPassword);
				userDetailsModel.setAdmin_status(dbAdmin_status);
				userDetailsModel.setMember_type(dbMember_type);
				
				return userDetailsModel;
			
			}
			else {
				return null;
			}
				
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
}
