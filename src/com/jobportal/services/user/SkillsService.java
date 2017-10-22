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
import com.jobportal.models.SkillsModel;

public class SkillsService {
	
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

	public void deleteSkill(int userId) throws Exception {
		try {
            PreparedStatement preparedStatement = getConnection()
                    .prepareStatement("delete from user_skills where user_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	public List<SkillsModel> getSkillDetails(String email_id) throws Exception {
		List<SkillsModel> skills = new ArrayList<>();
		try {
			// We should write where email_id condition using session in the below sql command
			PreparedStatement preparedStatement = getConnection().
                    prepareStatement("select * from user_skills where email_id=?");
            preparedStatement.setString(1, email_id);
            ResultSet rs = preparedStatement.executeQuery();
           
            while (rs.next()) {
                SkillsModel skillmodel = new SkillsModel();
                skillmodel.setUser_id(rs.getInt("user_id"));
                skillmodel.setEmail_id(rs.getString("email_id"));
                skillmodel.setCategory(rs.getString("category"));
                skillmodel.setSkill(rs.getString("skill"));
               
                skills.add(skillmodel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return skills;
	}

	public SkillsModel editSkill(int userId) throws Exception {
		SkillsModel skillmodel = new SkillsModel();
        try {
            PreparedStatement preparedStatement = getConnection().
                    prepareStatement("select * from user_skills where user_id=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	skillmodel.setUser_id(rs.getInt("user_id"));
            	 skillmodel.setCategory(rs.getString("category"));
                 skillmodel.setSkill(rs.getString("skill"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return skillmodel;
	}

	public void addSkill(SkillsModel skillmodel) throws Exception {
		try {
            PreparedStatement ps = getConnection()
                    .prepareStatement("insert into user_skills (email_id,category,skill) values (?, ?, ? )");
            // Parameters start with 1
            ps.setString(1, skillmodel.getEmail_id());
            ps.setString(2, skillmodel.getCategory());
            ps.setString(3, skillmodel.getSkill());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	public void updateSkill(SkillsModel skillmodel) throws Exception {
		try {
            PreparedStatement ps = getConnection()
                    .prepareStatement("update user_skills set category=?,skill=? where user_id=?");
            // Parameters start with 1
          
            ps.setString(1, skillmodel.getCategory());
            ps.setString(2, skillmodel.getSkill());
            ps.setInt(3, skillmodel.getUser_id());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
