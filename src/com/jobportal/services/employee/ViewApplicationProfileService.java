package com.jobportal.services.employee;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
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

		//TODO: General info
    		PreparedStatement preparedStatement = getConnection().
    		prepareStatement("SELECT * FROM user_primary where email_id=?");
    		
    		preparedStatement.setString(1, email_id);
    		
    		ResultSet rs = preparedStatement.executeQuery();
    		
    		Hashtable<Integer,GeneralInfoModel> generalInfoList = new Hashtable<Integer, GeneralInfoModel>();
		while (rs.next()) {
		    	  	if(!generalInfoList.containsKey(rs.getInt("user_id"))) {
		    	  		GeneralInfoModel generalmodel = new GeneralInfoModel();
				    generalmodel.setUser_id(rs.getInt("user_id"));
				    generalmodel.setEmail_id(rs.getString("email_id"));
				    generalmodel.setAddress(rs.getString("address"));
				    generalmodel.setPhone_no(rs.getString("phone_no"));
				    generalmodel.setZip_code(rs.getString("zip_code"));
				    generalInfoList.put(rs.getInt("user_id"), generalmodel);
		    	  	}else {
		    	  		continue;
		    	  	}  
		}
		
		//TODO: Education
		PreparedStatement ps_educational = getConnection().prepareStatement("SELECT * FROM user_education WHERE email_id=?");
		ps_educational.setString(1, email_id);
		
		ResultSet rs_educational = ps_educational.executeQuery();
		
		Hashtable<Integer,EducationModel> educationInfoList = new Hashtable<>();
 
		 while(rs_educational.next()) {
			 if(!educationInfoList.containsKey(rs_educational.getInt("user_id"))) {
					EducationModel educationmodel = new EducationModel();
			        educationmodel.setInstitution(rs_educational.getString("institution"));
			        educationmodel.setLevel(rs_educational.getString("level"));
			        educationmodel.setMajor(rs_educational.getString("major"));
			        educationmodel.setGpa(rs_educational.getString("gpa"));
			        educationmodel.setEdu_from(rs_educational.getString("edu_from"));
			        educationmodel.setEdu_to(rs_educational.getString("edu_to"));
			    educationInfoList.put(rs_educational.getInt("user_id"), educationmodel);
	    	  	}else {
	    	  		continue;
	    	  	}
		 }
		 
		 // TODO: Work Experience
		 PreparedStatement ps_experience = getConnection().prepareStatement("SELECT * FROM user_work_experience WHERE email_id=?");
		 ps_experience.setString(1, email_id);
			
			ResultSet rs_experience = ps_experience.executeQuery();
			
			Hashtable<Integer,WorkExperienceModel> workExperienceInfoList = new Hashtable<>();
	 
			 while(rs_experience.next()) {
				 if(!workExperienceInfoList.containsKey(rs_experience.getInt("user_id"))) {			        
				        WorkExperienceModel workmodel = new WorkExperienceModel();
				          workmodel.setTitle(rs_experience.getString("title"));
				          workmodel.setOrganization_name(rs_experience.getString("organization_name"));
				          workmodel.setLocation(rs_experience.getString("location"));
				          workmodel.setExp_from(rs_experience.getString("exp_from"));
				          workmodel.setExp_to(rs_experience.getString("exp_to"));
				          workmodel.setAchievements(rs_experience.getString("achievements"));
				          workExperienceInfoList.put(rs_experience.getInt("user_id"), workmodel);
		    	  	}else {
		    	  		continue;
		    	  	}
			 }
		      
		      
		    //TODO: Skills
			 PreparedStatement ps_skills = getConnection().prepareStatement("SELECT * FROM user_skills WHERE email_id=?");
			 ps_skills.setString(1, email_id);
				
				ResultSet rs_skills = ps_skills.executeQuery();
				
				Hashtable<Integer,SkillsModel> skillInfoList = new Hashtable<>();

				 while(rs_skills.next()) {
					 if(!workExperienceInfoList.containsKey(rs_skills.getInt("user_id"))) {			        
				          SkillsModel skillmodel = new SkillsModel();
				          skillmodel.setCategory(rs_skills.getString("category"));
				          skillmodel.setSkill(rs_skills.getString("skill"));
				          skillInfoList.put(rs_skills.getInt("user_id"), skillmodel);
			    	  	}else {
			    	  		continue;
			    	  	}
				 }
			 
			        
			     ProfileModel profilemodel = new ProfileModel();
			     profilemodel.storeGeneralDetails(generalInfoList);
			     profilemodel.storeEducationDetails(educationInfoList);
			     profilemodel.storeWorkExperienceDetails(workExperienceInfoList);
			     profilemodel.storeSkillDetails(skillInfoList);
			     
			        
			     profile.add(profilemodel);
		      
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }
		return profile;
		
	}
	
}