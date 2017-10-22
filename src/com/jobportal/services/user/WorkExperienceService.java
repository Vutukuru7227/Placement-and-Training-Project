package com.jobportal.services.user;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.models.WorkExperienceModel;

public class WorkExperienceService {
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
	
	public void addWorkex(WorkExperienceModel workmodel) throws Exception {
        try {
            PreparedStatement ps = getConnection()
                    .prepareStatement("insert into user_work_experience (email_id,title,organization_name,location,exp_from,exp_to,achievements) values (?, ?, ?, ?, ?, ?, ? )");
            // Parameters start with 1
            ps.setString(1, workmodel.getEmail_id());
            ps.setString(2, workmodel.getTitle());
            ps.setString(3, workmodel.getOrganization_name());
            ps.setString(4, workmodel.getLocation());
            ps.setString(5, workmodel.getExp_from());
            ps.setString(6, workmodel.getExp_to());
            ps.setString(7, workmodel.getAchievements());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public List<WorkExperienceModel> getWorkexDetails(String email_id) throws Exception {
		List<WorkExperienceModel> workex = new ArrayList<>();
		try {
			// We should write where email_id condition using session in the below sql command
			PreparedStatement preparedStatement = getConnection().
                    prepareStatement("select * from user_work_experience where email_id=?");
            preparedStatement.setString(1, email_id);
            ResultSet rs = preparedStatement.executeQuery();
           
            while (rs.next()) {
                WorkExperienceModel workmodel = new WorkExperienceModel();
                workmodel.setUser_id(rs.getInt("user_id"));
                workmodel.setEmail_id(rs.getString("email_id"));
                workmodel.setTitle(rs.getString("title"));
                workmodel.setOrganization_name(rs.getString("organization_name"));
                workmodel.setLocation(rs.getString("location"));
                workmodel.setExp_from(rs.getString("exp_from"));
                workmodel.setExp_to(rs.getString("exp_to"));
                workmodel.setAchievements(rs.getString("achievements"));
                
                workex.add(workmodel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return workex;
		
	}

	public void deleteWorkex(int userId) throws Exception {
		try {
            PreparedStatement preparedStatement = getConnection()
                    .prepareStatement("delete from user_work_experience where user_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	public WorkExperienceModel editWorkex(int userId) throws Exception {
		WorkExperienceModel workmodel = new WorkExperienceModel();
        try {
            PreparedStatement preparedStatement = getConnection().
                    prepareStatement("select * from user_work_experience where user_id=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	workmodel.setUser_id(rs.getInt("user_id"));
            	workmodel.setTitle(rs.getString("title"));
                workmodel.setOrganization_name(rs.getString("organization_name"));
                workmodel.setLocation(rs.getString("location"));
                workmodel.setExp_from(rs.getString("exp_from"));
                workmodel.setExp_to(rs.getString("exp_to"));
                workmodel.setAchievements(rs.getString("achievements"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workmodel;
    }

	public void updateWorkex(WorkExperienceModel workmodel) throws Exception {
		try {
            PreparedStatement ps = getConnection()
                    .prepareStatement("update user_work_experience set title=?, organization_name=?, location=?, exp_from=?,  exp_to=?, achievements=? where user_id=?");
            // Parameters start with 1
            ps.setString(1, workmodel.getTitle());
            ps.setString(2, workmodel.getOrganization_name());
            ps.setString(3, workmodel.getLocation());
            ps.setString(4, workmodel.getExp_from());
            ps.setString(5, workmodel.getExp_to());
            ps.setString(6, workmodel.getAchievements());
            ps.setInt(7, workmodel.getUser_id());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

}
