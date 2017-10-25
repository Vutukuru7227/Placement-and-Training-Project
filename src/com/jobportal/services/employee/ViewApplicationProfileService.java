package com.jobportal.services.employee;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.models.EducationModel;
import com.jobportal.models.GeneralInfoModel;
import com.jobportal.models.SkillsModel;
import com.jobportal.models.WorkExperienceModel;

public class ViewApplicationProfileService {
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
	
	public List<GeneralInfoModel> getGeneralDetails(String email_id) throws Exception {
		List<GeneralInfoModel> general = new ArrayList<>();
		try {
			// We should write where email_id condition using session in the below sql command
			PreparedStatement preparedStatement = getConnection().
                    prepareStatement("select * from user_primary where email_id=?");
            preparedStatement.setString(1, email_id);
            ResultSet rs = preparedStatement.executeQuery();
           
            while (rs.next()) {
                GeneralInfoModel generalmodel = new GeneralInfoModel();
                generalmodel.setUser_id(rs.getInt("user_id"));
                generalmodel.setEmail_id(rs.getString("email_id"));
                generalmodel.setAddress(rs.getString("address"));
                generalmodel.setPhone_no(rs.getString("phone_no"));
                generalmodel.setZip_code(rs.getString("zip_code"));
                
                general.add(generalmodel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return general;
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

}
