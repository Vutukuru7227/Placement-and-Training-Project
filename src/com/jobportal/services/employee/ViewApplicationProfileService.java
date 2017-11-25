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
import com.jobportal.models.ProfileModel;
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
	
	public List<ProfileModel> getProfileDetails(String email_id) throws Exception {
		List<ProfileModel> profile = new ArrayList<>();
		try {

    		PreparedStatement preparedStatement = getConnection().
    		prepareStatement("SELECT * FROM user_primary INNER JOIN user_education ON user_primary.email_id = user_education.email_id INNER JOIN user_work_experience ON user_primary.email_id = user_work_experience.email_id INNER JOIN user_skills ON user_primary.email_id = user_skills.email_id;");
    		ResultSet rs = preparedStatement.executeQuery();
     
		      while (rs.next()) {
		          GeneralInfoModel generalmodel = new GeneralInfoModel();
		          generalmodel.setUser_id(rs.getInt("user_id"));
		          generalmodel.setEmail_id(rs.getString("email_id"));
		          generalmodel.setAddress(rs.getString("address"));
		          generalmodel.setPhone_no(rs.getString("phone_no"));
		          generalmodel.setZip_code(rs.getString("zip_code"));
		          
		          EducationModel educationmodel = new EducationModel();
		          educationmodel.setInstitution(rs.getString("institution"));
		          educationmodel.setLevel(rs.getString("level"));
		          educationmodel.setMajor(rs.getString("major"));
		          educationmodel.setGpa(rs.getString("gpa"));
		          educationmodel.setEdu_from(rs.getString("edu_from"));
		          educationmodel.setEdu_to(rs.getString("edu_to"));
		          
		          WorkExperienceModel workmodel = new WorkExperienceModel();
	                workmodel.setTitle(rs.getString("title"));
	                workmodel.setOrganization_name(rs.getString("organization_name"));
	                workmodel.setLocation(rs.getString("location"));
	                workmodel.setExp_from(rs.getString("exp_from"));
	                workmodel.setExp_to(rs.getString("exp_to"));
	                workmodel.setAchievements(rs.getString("achievements"));
	                
	                SkillsModel skillmodel = new SkillsModel();
	                skillmodel.setCategory(rs.getString("category"));
	                skillmodel.setSkill(rs.getString("skill"));
		          
		          ProfileModel profilemodel = new ProfileModel(generalmodel, educationmodel, workmodel, skillmodel);
		          
		          profile.add(profilemodel);
		      }
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }

		return profile;
		
	}
	
}
