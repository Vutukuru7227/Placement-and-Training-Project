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
                    .prepareStatement("insert into application_details (user_id,job_id");
			
			ps.setString(1, model.getUser_id());
			ps.setInt(2, model.getJob_id());
			
			ps.executeUpdate();
			
			result = true;
			return result;
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
		
	}
}
