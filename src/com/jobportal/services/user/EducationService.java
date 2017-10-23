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
import com.jobportal.models.WorkExperienceModel;

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
	
	public void addEducation(EducationModel edumodel) throws Exception {
        try {
            PreparedStatement ps = getConnection()
                    .prepareStatement("insert into user_education (email_id,institution,level,gpa,major,edu_from, edu_to) values (?, ?, ?, ?, ?, ?, ? )");
            // Parameters start with 1
            ps.setString(1, edumodel.getEmail_id());
            ps.setString(2, edumodel.getInstitution());
            ps.setString(3, edumodel.getLevel());
            ps.setString(4, edumodel.getGpa());
            ps.setString(5, edumodel.getMajor());
            ps.setString(6, edumodel.getEdu_from());
            ps.setString(7, edumodel.getEdu_to());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public List<EducationModel> getEducationDetails(String email_id) throws Exception {
		List<EducationModel> education = new ArrayList<>();
		try {
			// We should write where email_id condition using session in the below sql command
			PreparedStatement preparedStatement = getConnection().
                    prepareStatement("select * from user_education where email_id=?");
            preparedStatement.setString(1, email_id);
            ResultSet rs = preparedStatement.executeQuery();
           
            while (rs.next()) {
                EducationModel edumodel = new EducationModel();
                edumodel.setUser_id(rs.getInt("user_id"));
                edumodel.setEmail_id(rs.getString("email_id"));
                edumodel.setInstitution(rs.getString("institution"));
                edumodel.setLevel(rs.getString("level"));
                edumodel.setMajor(rs.getString("major"));
                edumodel.setGpa(rs.getString("gpa"));
                edumodel.setEdu_from(rs.getString("edu_from"));
                edumodel.setEdu_to(rs.getString("edu_to"));
                
                education.add(edumodel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return education;
		
	}

	public void deleteEducation(int userId) throws Exception {
		try {
            PreparedStatement preparedStatement = getConnection()
                    .prepareStatement("delete from user_education where user_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	public EducationModel editEducation(int userId) throws Exception {
		EducationModel edumodel = new EducationModel();
        try {
            PreparedStatement preparedStatement = getConnection().
                    prepareStatement("select * from user_education where user_id=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	edumodel.setUser_id(rs.getInt("user_id"));
            	edumodel.setInstitution(rs.getString("institution"));
                edumodel.setLevel(rs.getString("level"));
                edumodel.setMajor(rs.getString("major"));
                edumodel.setGpa(rs.getString("gpa"));
                edumodel.setEdu_from(rs.getString("edu_from"));
                edumodel.setEdu_to(rs.getString("edu_to"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return edumodel;
    }

	public void updateEducation(EducationModel edumodel) throws Exception {
		try {
            PreparedStatement ps = getConnection()
                    .prepareStatement("update user_education set institution=?,level=?,gpa=?,major=?,edu_from=?,edu_to=? where user_id=?");
            // Parameters start with 1
          
            ps.setString(1, edumodel.getInstitution());
            ps.setString(2, edumodel.getLevel());
            ps.setString(3, edumodel.getGpa());
            ps.setString(4, edumodel.getMajor());
            ps.setString(5, edumodel.getEdu_from());
            ps.setString(6, edumodel.getEdu_to());
            ps.setInt(7, edumodel.getUser_id());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

    
}
