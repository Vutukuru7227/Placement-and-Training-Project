package com.jobportal.services.user;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jobportal.models.EducationModel;

public class EducationService {
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
	
	public void addEducation(EducationModel education) throws Exception {
        try {
            PreparedStatement ps = getConnection()
                    .prepareStatement("insert into user_education (email_id,institution,level,gpa,major,edu_from, edu_to) values (?, ?, ?, ?, ?, ?, ? )");
            // Parameters start with 1
            ps.setString(1, education.getEmail_id());
            ps.setString(2, education.getInstitution());
            ps.setString(3, education.getLevel());
            ps.setString(4, education.getGpa());
            ps.setString(5, education.getMajor());
            ps.setString(6, education.getEdu_from());
            ps.setString(7, education.getEdu_to());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
