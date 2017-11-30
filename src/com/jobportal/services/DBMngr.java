package com.jobportal.services;

import static java.lang.System.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.jobportal.models.ApplicationModel;
import com.jobportal.models.EducationModel;
import com.jobportal.models.EmployerModel;
import com.jobportal.models.GeneralInfoModel;
import com.jobportal.models.JobPostModel;
import com.jobportal.models.JobSeekerModel;
import com.jobportal.models.ProfileModel;
import com.jobportal.models.SkillsModel;
import com.jobportal.models.WorkExperienceModel;
import com.jobportal.repository.IEmployee;
import com.jobportal.repository.ILogin;

public class DBMngr implements IEmployee, ILogin {
	
	//TODO: LoginService
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

	public String authenticateUserandSpecifyType(String email_id, String password) {
		
		String dbPassword = "";
		String dbMember_type = "";
		try {
			
			String sql = "(select * from registration where email_id=?)";
						
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, email_id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
					dbPassword = rs.getString(4);
					dbMember_type = rs.getString(6);
			}
			if(dbPassword.equals(password)){
				
				if(dbMember_type.equals("Applicant")) {
					System.out.println(dbMember_type);
					return "Applicant";
					
				}else {
					
					return "Employer";
				}		
			}
			else {
				return null;
			}
				
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public EmployerModel getEmployerDetails(String email_id) {
		String dbEmailId = "";
		String dbFirstName = "";
		String dbLastName = "";
		try {
			String sql = "(select * from registration where email_id=?)";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, email_id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				dbEmailId = rs.getString(1);
				dbFirstName = rs.getString(2);
				dbLastName = rs.getString(3);
			}
			EmployerModel employerModel = new EmployerModel();
			employerModel.setEmail_id(dbEmailId);
			employerModel.setFirst_name(dbFirstName);
			employerModel.setLast_name(dbLastName);
			
			return employerModel;
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}	
	}
	
	public JobSeekerModel getJobSeekerDetails(String email_id) {
		String dbEmailId = "";
		String dbFirstName = "";
		String dbLastName = "";
		try {
			String sql = "(select * from registration where email_id=?)";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, email_id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				dbEmailId = rs.getString(1);
				dbFirstName = rs.getString(2);
				dbLastName = rs.getString(3);
			}
			JobSeekerModel jobSeekerModel = new JobSeekerModel();
			jobSeekerModel.setEmail_id(dbEmailId);
			jobSeekerModel.setFirst_name(dbFirstName);
			jobSeekerModel.setLast_name(dbLastName);
			
			return jobSeekerModel;
			
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}	
	}
	
	//TODO: RegistrationService
	
	public boolean registerUser(JobSeekerModel registrationModel) {
		boolean result = false;
		
		String emailId = registrationModel.getEmail_id();
		String password = registrationModel.getPassword();
		String firstName = registrationModel.getFirst_name();
		String lastName = registrationModel.getLast_name();
		String admin_status = "0";
		String member_type = registrationModel.getMember_type();
		
		String sql = "insert into registration"
				+ "(email_id, first_name, last_name, password, admin_status, member_type) values(?,?,?,?,?,?)";
		
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, emailId);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, password);
			ps.setString(5, admin_status);
			ps.setString(6, member_type);
			
			ps.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}	
		return result;
	}
	
	
	
	public boolean registerUser(EmployerModel registrationModel) {
		boolean result = false;
		
		String emailId = registrationModel.getEmail_id();
		String password = registrationModel.getPassword();
		String firstName = registrationModel.getFirst_name();
		String lastName = registrationModel.getLast_name();
		String admin_status = "0";
		String member_type = registrationModel.getMember_type();
		
		String sql = "insert into registration"
				+ "(email_id, first_name, last_name, password, admin_status, member_type) values(?,?,?,?,?,?)";
		
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, emailId);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, password);
			ps.setString(5, admin_status);
			ps.setString(6, member_type);
			
			ps.executeUpdate();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}	
		return result;
	}
	
	//TODO: ApplicationStatusService
	
	public void changeApplicationStatus(String status, String emp_id, String email_id) throws Exception {
		try {
	        
			PreparedStatement preparedStatement = getConnection().
	                    prepareStatement("SELECT a.job_id from application_details as a join job_postings as j on a.job_id = j.job_id where j.emp_id=?");
	        preparedStatement.setString(1, emp_id);
	        ResultSet rs = preparedStatement.executeQuery();
			
	        int job_id = 0;
	        while(rs.next()){
	           job_id = rs.getInt("job_id");
	        }
	        
	        System.out.println(job_id);
	        System.out.println(status);
			PreparedStatement preparedStatement2 = getConnection().
                    prepareStatement("update application_details set status=? where job_id=? and email_id=?");
			preparedStatement2.setString(1, status);
			preparedStatement2.setInt(2, job_id);
			preparedStatement2.setString(3, email_id);
            preparedStatement2.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

	public ApplicationModel getApplicationStatus(String emp_id, String email_id) throws Exception {
//		 ApplicationModel status = new ApplicationModel();
		try {
	        
			PreparedStatement preparedStatement = getConnection().
	                    prepareStatement("SELECT a.job_id from application_details as a join job_postings as j on a.job_id = j.job_id where j.emp_id=?");
	        preparedStatement.setString(1, emp_id);
	        ResultSet rs = preparedStatement.executeQuery();
	        
	        int job_id = 0;
	        while(rs.next()){
	           job_id = rs.getInt("job_id");
	        }
	        
	        System.out.println(job_id);
	        
	        PreparedStatement preparedStatement2 = getConnection().
                    prepareStatement("select * from application_details where job_id=? and email_id=?");
			
			preparedStatement2.setInt(1, job_id);
			preparedStatement2.setString(2, email_id);
			ResultSet rs2 = preparedStatement2.executeQuery();
	        
			//System.out.println("check");
			//System.out.println(rs2);
			
			while(rs2.next()){
				//System.out.println("check2");
				ApplicationModel model = new ApplicationModel();
				
				model.setEmail_id(rs2.getString("email_id"));
				model.setJob_id(rs2.getInt("job_id"));
				model.setStatus(rs2.getString("status"));
				return model;
			}
	        
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return null;
	}
	
	//TODO: JobPostingService
	
	@Override
	public boolean postJob(JobPostModel jobpostModel) {
		// TODO Auto-generated method stub
		String emp_id = jobpostModel.getEmp_id();
		String company_name = jobpostModel.getCompany();
		String location = jobpostModel.getLocation();
		String job_title = jobpostModel.getJob_title();
		String job_description = jobpostModel.getJob_description();
		Date application_deadline = convertJavaDateToSqlDate(jobpostModel.getDeadline());
		
		java.sql.Date deadline = (java.sql.Date) application_deadline;
		
		String sql = "insert into job_postings (emp_id, company_name, location, job_title, job_description, deadline) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			
			ps.setString(1, emp_id);
			ps.setString(2, company_name);
			ps.setString(3, location);
			ps.setString(4, job_title);
			ps.setString(5, job_description.toString());
			ps.setDate(6, deadline);
			
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
	    return new java.sql.Date(date.getTime());
	}
	
	
	public ArrayList<JobPostModel> getJobIds(String emp_id){
		ArrayList<JobPostModel> jobs = new ArrayList<JobPostModel>();

		String sql = "select * "
				+ "FROM job_postings j"
				+ " WHERE emp_id = ?";
			
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, emp_id);				
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				JobPostModel model = new JobPostModel();
				model.setJob_id(rs.getInt("job_id"));
				model.setEmp_id(rs.getString("emp_id"));
				model.setCompany(rs.getString("company_name"));
				model.setLocation(rs.getString("location"));
				model.setJob_title(rs.getString("job_title"));
				model.setJob_description(rs.getString("job_description"));
				model.setDeadline(rs.getDate("deadline"));
				jobs.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return jobs;

	}
	public ArrayList<ApplicationModel> viewSpecificJobPosted(int job_id) {
		
		ArrayList<ApplicationModel> appliedList = new ArrayList<ApplicationModel>();
		

		String sql = "SELECT * "
				+ "FROM application_details a, job_postings j "
				+ "WHERE j.job_id = a.job_id "
				+ "AND j.job_id = ?";
		
		try {
			
			String job_id_str = job_id+"";
			out.println(job_id_str);
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
		
			ps.setString(1, job_id_str);				
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				ApplicationModel model = new ApplicationModel();
				model.setJob_id(rs.getInt("job_id"));
				model.setEmail_id(rs.getString("email_id"));
				out.print(rs.getString("email_id"));
				appliedList.add(model);
				}
			} catch (Exception e) {
			e.printStackTrace();
		}
		return appliedList;
		
	}
	
	//TODO: ViewApplicationProfileService
	
	public List<ProfileModel> getProfileDetails(String email_id, ProfileModel profile) throws Exception {
		List<ProfileModel> profileList = new ArrayList<>();
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
			 
			        
//			     ProfileModel profilemodel = new ProfileModel();
			     profile.storeGeneralDetails(generalInfoList);
			     profile.storeEducationDetails(educationInfoList);
			     profile.storeWorkExperienceDetails(workExperienceInfoList);
			     profile.storeSkillDetails(skillInfoList);
			     
			        
			     profileList.add(profile);
		      
		  } catch (SQLException e) {
		      e.printStackTrace();
		  }
		return profileList;
		
	}
	
	
	//TODO: ApplyService
	
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
	
	//TODO: EducationService
	
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
	
	
	//TODO: GeneralInfoService
	
	public void deleteGeneralInfo(int userId) throws Exception {
		try {
            PreparedStatement preparedStatement = getConnection()
                    .prepareStatement("delete from user_primary where user_id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
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

	public GeneralInfoModel editGeneralInfo(int userId) throws Exception {
		GeneralInfoModel generalmodel = new GeneralInfoModel();
        try {
            PreparedStatement preparedStatement = getConnection().
                    prepareStatement("select * from user_primary where user_id=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	 generalmodel.setUser_id(rs.getInt("user_id"));
                 generalmodel.setAddress(rs.getString("address"));
                 generalmodel.setPhone_no(rs.getString("phone_no"));
                 generalmodel.setZip_code(rs.getString("zip_code"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generalmodel;

	}

	public void addGeneralInfo(GeneralInfoModel generalmodel) throws Exception {
		 try {
	            PreparedStatement ps = getConnection()
	                    .prepareStatement("insert into user_primary (email_id,address,phone_no,zip_code) values (?, ?, ?, ?)");
	            // Parameters start with 1
	            ps.setString(1, generalmodel.getEmail_id());
	            ps.setString(2, generalmodel.getAddress());
	            ps.setString(3, generalmodel.getPhone_no());
	            ps.setString(4, generalmodel.getZip_code());
	            
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	public void updateGeneralInfo(GeneralInfoModel generalmodel) throws Exception {
		try {
            PreparedStatement ps = getConnection()
                    .prepareStatement("update user_primary set address=?,phone_no=?,zip_code=? where user_id=?");
            // Parameters start with 1
          
            ps.setString(1, generalmodel.getAddress());
            ps.setString(2, generalmodel.getPhone_no());
            ps.setString(3, generalmodel.getZip_code());
            ps.setInt(4, generalmodel.getUser_id());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	
	
	//TODO: JobListingsService
	
	public List<JobPostModel> getJobListings(String keyword) throws Exception {
		List<JobPostModel> joblist = new ArrayList<>();
		try {
			// We should write where email_id condition using session in the below sql command
			PreparedStatement preparedStatement = getConnection().
                    prepareStatement("select * from job_postings");
            //preparedStatement.setString(1, "%" + keyword + "%");
            ResultSet rs = preparedStatement.executeQuery();
           
            while (rs.next()) {
                JobPostModel joblistmodel = new JobPostModel();
                joblistmodel.setJob_id(rs.getInt("job_id"));
                joblistmodel.setCompany(rs.getString("company_name"));
                joblistmodel.setJob_title(rs.getString("job_title"));
                joblistmodel.setLocation(rs.getString("location"));
                joblistmodel.setJob_description(rs.getString("job_description"));
                
                joblist.add(joblistmodel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		List<JobPostModel> joblist2 = new ArrayList<>();
		for(JobPostModel jpm: joblist){
			if(jpm.getJob_title().contains(keyword) || jpm.getJob_description().toLowerCase().contains(keyword)){
				JobPostModel joblistmodel = new JobPostModel();
                joblistmodel.setJob_id(jpm.getJob_id());
                joblistmodel.setCompany(jpm.getCompany());
                joblistmodel.setJob_title(jpm.getJob_title());
                joblistmodel.setLocation(jpm.getLocation());
                joblistmodel.setJob_description(jpm.getJob_description());
                
                joblist2.add(joblistmodel);
			}
		}
		
		return joblist2;
		
	}

	
	
	//TODO: SkillsService
	
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
	
	//TODO: ViewApplicationsStatusService
	
	public ArrayList<ApplicationModel> getApplications(String email_id) throws Exception {
		ArrayList<ApplicationModel> status = new ArrayList<ApplicationModel>();
		try {
	        
	        PreparedStatement preparedStatement2 = getConnection().
                    prepareStatement("select * from application_details where email_id=?");
			
			preparedStatement2.setString(1, email_id);
			ResultSet rs2 = preparedStatement2.executeQuery();
	        
			//System.out.println("check");
			//System.out.println(rs2);
			
			while(rs2.next()){
				//System.out.println("check2");
				ApplicationModel model = new ApplicationModel();
				
				model.setEmail_id(rs2.getString("email_id"));
				model.setJob_id(rs2.getInt("job_id"));
				model.setStatus(rs2.getString("status"));
				status.add(model);
			}
	        
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return status;
	}
	
	
	//TODO: WorkExperienceService

	
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
