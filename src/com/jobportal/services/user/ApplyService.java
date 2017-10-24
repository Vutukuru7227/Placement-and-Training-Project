package com.jobportal.services.user;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.jobportal.models.ApplicationModel;

public class ApplyService {
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
	
	public boolean Apply(ApplicationModel model){
		boolean result = false;
		
		try{
			PreparedStatement ps = getConnection()
                    .prepareStatement("insert into application_details (email_id,job_id) values (?, ?)");
			
			ps.setString(1, model.getEmail_id());
			ps.setInt(2, model.getJob_id());
			
			ps.executeUpdate();
			
			result = true;
			
		}catch (Exception e) {
			e.printStackTrace();
			result = false;
			// TODO: handle exception
		}
		return result;
		
	}
}
